package okhttp3.internal.http2;

import com.facebook.imageutils.JfifUtil;
import com.google.protobuf.CodedOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

public final class Http2Reader implements Closeable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Logger logger;
    private final boolean client;
    private final ContinuationSource continuation;
    private final Hpack.Reader hpackReader;
    private final BufferedSource source;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Logger getLogger() {
            return Http2Reader.logger;
        }

        public final int lengthWithoutPadding(int i2, int i3, int i4) throws IOException {
            if ((i3 & 8) != 0) {
                i2--;
            }
            if (i4 <= i2) {
                return i2 - i4;
            }
            throw new IOException("PROTOCOL_ERROR padding " + i4 + " > remaining length " + i2);
        }
    }

    public static final class ContinuationSource implements Source {
        private int flags;
        private int left;
        private int length;
        private int padding;
        private final BufferedSource source;
        private int streamId;

        public ContinuationSource(BufferedSource bufferedSource) {
            Intrinsics.f(bufferedSource, "source");
            this.source = bufferedSource;
        }

        private final void readContinuationHeader() throws IOException {
            int i2 = this.streamId;
            int readMedium = Util.readMedium(this.source);
            this.left = readMedium;
            this.length = readMedium;
            int and = Util.and(this.source.readByte(), (int) JfifUtil.MARKER_FIRST_BYTE);
            this.flags = Util.and(this.source.readByte(), (int) JfifUtil.MARKER_FIRST_BYTE);
            Companion companion = Http2Reader.Companion;
            if (companion.getLogger().isLoggable(Level.FINE)) {
                companion.getLogger().fine(Http2.INSTANCE.frameLog(true, this.streamId, this.length, and, this.flags));
            }
            int readInt = this.source.readInt() & Integer.MAX_VALUE;
            this.streamId = readInt;
            if (and != 9) {
                throw new IOException(and + " != TYPE_CONTINUATION");
            } else if (readInt != i2) {
                throw new IOException("TYPE_CONTINUATION streamId changed");
            }
        }

        public void close() throws IOException {
        }

        public final int getFlags() {
            return this.flags;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getLength() {
            return this.length;
        }

        public final int getPadding() {
            return this.padding;
        }

        public final int getStreamId() {
            return this.streamId;
        }

        public long read(Buffer buffer, long j2) throws IOException {
            Intrinsics.f(buffer, "sink");
            while (true) {
                int i2 = this.left;
                if (i2 == 0) {
                    this.source.skip((long) this.padding);
                    this.padding = 0;
                    if ((this.flags & 4) != 0) {
                        return -1;
                    }
                    readContinuationHeader();
                } else {
                    long read = this.source.read(buffer, Math.min(j2, (long) i2));
                    if (read == -1) {
                        return -1;
                    }
                    this.left -= (int) read;
                    return read;
                }
            }
        }

        public final void setFlags(int i2) {
            this.flags = i2;
        }

        public final void setLeft(int i2) {
            this.left = i2;
        }

        public final void setLength(int i2) {
            this.length = i2;
        }

        public final void setPadding(int i2) {
            this.padding = i2;
        }

        public final void setStreamId(int i2) {
            this.streamId = i2;
        }

        public Timeout timeout() {
            return this.source.timeout();
        }
    }

    public interface Handler {
        void ackSettings();

        void alternateService(int i2, String str, ByteString byteString, String str2, int i3, long j2);

        void data(boolean z2, int i2, BufferedSource bufferedSource, int i3) throws IOException;

        void goAway(int i2, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z2, int i2, int i3, List<Header> list);

        void ping(boolean z2, int i2, int i3);

        void priority(int i2, int i3, int i4, boolean z2);

        void pushPromise(int i2, int i3, List<Header> list) throws IOException;

        void rstStream(int i2, ErrorCode errorCode);

        void settings(boolean z2, Settings settings);

        void windowUpdate(int i2, long j2);
    }

    static {
        Logger logger2 = Logger.getLogger(Http2.class.getName());
        Intrinsics.e(logger2, "getLogger(Http2::class.java.name)");
        logger = logger2;
    }

    public Http2Reader(BufferedSource bufferedSource, boolean z2) {
        Intrinsics.f(bufferedSource, "source");
        this.source = bufferedSource;
        this.client = z2;
        ContinuationSource continuationSource = new ContinuationSource(bufferedSource);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(continuationSource, CodedOutputStream.DEFAULT_BUFFER_SIZE, 0, 4, (DefaultConstructorMarker) null);
    }

    private final void readData(Handler handler, int i2, int i3, int i4) throws IOException {
        boolean z2;
        if (i4 != 0) {
            int i5 = 0;
            boolean z3 = true;
            if ((i3 & 1) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((i3 & 32) == 0) {
                z3 = false;
            }
            if (!z3) {
                if ((i3 & 8) != 0) {
                    i5 = Util.and(this.source.readByte(), (int) JfifUtil.MARKER_FIRST_BYTE);
                }
                handler.data(z2, i4, this.source, Companion.lengthWithoutPadding(i2, i3, i5));
                this.source.skip((long) i5);
                return;
            }
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
    }

    private final void readGoAway(Handler handler, int i2, int i3, int i4) throws IOException {
        if (i2 < 8) {
            throw new IOException("TYPE_GOAWAY length < 8: " + i2);
        } else if (i4 == 0) {
            int readInt = this.source.readInt();
            int readInt2 = this.source.readInt();
            int i5 = i2 - 8;
            ErrorCode fromHttp2 = ErrorCode.Companion.fromHttp2(readInt2);
            if (fromHttp2 != null) {
                ByteString byteString = ByteString.f41332f;
                if (i5 > 0) {
                    byteString = this.source.Q((long) i5);
                }
                handler.goAway(readInt, fromHttp2, byteString);
                return;
            }
            throw new IOException("TYPE_GOAWAY unexpected error code: " + readInt2);
        } else {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
    }

    private final List<Header> readHeaderBlock(int i2, int i3, int i4, int i5) throws IOException {
        this.continuation.setLeft(i2);
        ContinuationSource continuationSource = this.continuation;
        continuationSource.setLength(continuationSource.getLeft());
        this.continuation.setPadding(i3);
        this.continuation.setFlags(i4);
        this.continuation.setStreamId(i5);
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private final void readHeaders(Handler handler, int i2, int i3, int i4) throws IOException {
        boolean z2;
        if (i4 != 0) {
            int i5 = 0;
            if ((i3 & 1) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((i3 & 8) != 0) {
                i5 = Util.and(this.source.readByte(), (int) JfifUtil.MARKER_FIRST_BYTE);
            }
            if ((i3 & 32) != 0) {
                readPriority(handler, i4);
                i2 -= 5;
            }
            handler.headers(z2, i4, -1, readHeaderBlock(Companion.lengthWithoutPadding(i2, i3, i5), i5, i3, i4));
            return;
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
    }

    private final void readPing(Handler handler, int i2, int i3, int i4) throws IOException {
        if (i2 != 8) {
            throw new IOException("TYPE_PING length != 8: " + i2);
        } else if (i4 == 0) {
            int readInt = this.source.readInt();
            int readInt2 = this.source.readInt();
            boolean z2 = true;
            if ((i3 & 1) == 0) {
                z2 = false;
            }
            handler.ping(z2, readInt, readInt2);
        } else {
            throw new IOException("TYPE_PING streamId != 0");
        }
    }

    private final void readPriority(Handler handler, int i2, int i3, int i4) throws IOException {
        if (i2 != 5) {
            throw new IOException("TYPE_PRIORITY length: " + i2 + " != 5");
        } else if (i4 != 0) {
            readPriority(handler, i4);
        } else {
            throw new IOException("TYPE_PRIORITY streamId == 0");
        }
    }

    private final void readPushPromise(Handler handler, int i2, int i3, int i4) throws IOException {
        int i5;
        if (i4 != 0) {
            if ((i3 & 8) != 0) {
                i5 = Util.and(this.source.readByte(), (int) JfifUtil.MARKER_FIRST_BYTE);
            } else {
                i5 = 0;
            }
            handler.pushPromise(i4, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(Companion.lengthWithoutPadding(i2 - 4, i3, i5), i5, i3, i4));
            return;
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
    }

    private final void readRstStream(Handler handler, int i2, int i3, int i4) throws IOException {
        if (i2 != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + i2 + " != 4");
        } else if (i4 != 0) {
            int readInt = this.source.readInt();
            ErrorCode fromHttp2 = ErrorCode.Companion.fromHttp2(readInt);
            if (fromHttp2 != null) {
                handler.rstStream(i4, fromHttp2);
                return;
            }
            throw new IOException("TYPE_RST_STREAM unexpected error code: " + readInt);
        } else {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
    }

    private final void readSettings(Handler handler, int i2, int i3, int i4) throws IOException {
        int readInt;
        if (i4 != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        } else if ((i3 & 1) != 0) {
            if (i2 == 0) {
                handler.ackSettings();
                return;
            }
            throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
        } else if (i2 % 6 == 0) {
            Settings settings = new Settings();
            IntProgression i5 = RangesKt___RangesKt.i(RangesKt___RangesKt.j(0, i2), 6);
            int a2 = i5.a();
            int b2 = i5.b();
            int d2 = i5.d();
            if ((d2 > 0 && a2 <= b2) || (d2 < 0 && b2 <= a2)) {
                while (true) {
                    int and = Util.and(this.source.readShort(), 65535);
                    readInt = this.source.readInt();
                    if (and != 2) {
                        if (and == 3) {
                            and = 4;
                        } else if (and != 4) {
                            if (and == 5 && (readInt < 16384 || readInt > 16777215)) {
                            }
                        } else if (readInt >= 0) {
                            and = 7;
                        } else {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                        }
                    } else if (!(readInt == 0 || readInt == 1)) {
                        throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                    }
                    settings.set(and, readInt);
                    if (a2 == b2) {
                        break;
                    }
                    a2 += d2;
                }
                throw new IOException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: " + readInt);
            }
            handler.settings(false, settings);
        } else {
            throw new IOException("TYPE_SETTINGS length % 6 != 0: " + i2);
        }
    }

    private final void readWindowUpdate(Handler handler, int i2, int i3, int i4) throws IOException {
        if (i2 == 4) {
            long and = Util.and(this.source.readInt(), 2147483647L);
            if (and != 0) {
                handler.windowUpdate(i4, and);
                return;
            }
            throw new IOException("windowSizeIncrement was 0");
        }
        throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + i2);
    }

    public void close() throws IOException {
        this.source.close();
    }

    public final boolean nextFrame(boolean z2, Handler handler) throws IOException {
        Intrinsics.f(handler, "handler");
        try {
            this.source.N(9);
            int readMedium = Util.readMedium(this.source);
            if (readMedium <= 16384) {
                int and = Util.and(this.source.readByte(), (int) JfifUtil.MARKER_FIRST_BYTE);
                int and2 = Util.and(this.source.readByte(), (int) JfifUtil.MARKER_FIRST_BYTE);
                int readInt = this.source.readInt() & Integer.MAX_VALUE;
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Http2.INSTANCE.frameLog(true, readInt, readMedium, and, and2));
                }
                if (!z2 || and == 4) {
                    switch (and) {
                        case 0:
                            readData(handler, readMedium, and2, readInt);
                            return true;
                        case 1:
                            readHeaders(handler, readMedium, and2, readInt);
                            return true;
                        case 2:
                            readPriority(handler, readMedium, and2, readInt);
                            return true;
                        case 3:
                            readRstStream(handler, readMedium, and2, readInt);
                            return true;
                        case 4:
                            readSettings(handler, readMedium, and2, readInt);
                            return true;
                        case 5:
                            readPushPromise(handler, readMedium, and2, readInt);
                            return true;
                        case 6:
                            readPing(handler, readMedium, and2, readInt);
                            return true;
                        case 7:
                            readGoAway(handler, readMedium, and2, readInt);
                            return true;
                        case 8:
                            readWindowUpdate(handler, readMedium, and2, readInt);
                            return true;
                        default:
                            this.source.skip((long) readMedium);
                            return true;
                    }
                } else {
                    throw new IOException("Expected a SETTINGS frame but was " + Http2.INSTANCE.formattedType$okhttp(and));
                }
            } else {
                throw new IOException("FRAME_SIZE_ERROR: " + readMedium);
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void readConnectionPreface(Handler handler) throws IOException {
        Intrinsics.f(handler, "handler");
        if (!this.client) {
            BufferedSource bufferedSource = this.source;
            ByteString byteString = Http2.CONNECTION_PREFACE;
            ByteString Q = bufferedSource.Q((long) byteString.size());
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine(Util.format("<< CONNECTION " + Q.k(), new Object[0]));
            }
            if (!Intrinsics.a(byteString, Q)) {
                throw new IOException("Expected a connection header but was " + Q.y());
            }
        } else if (!nextFrame(true, handler)) {
            throw new IOException("Required SETTINGS preface not received");
        }
    }

    private final void readPriority(Handler handler, int i2) throws IOException {
        int readInt = this.source.readInt();
        handler.priority(i2, readInt & Integer.MAX_VALUE, Util.and(this.source.readByte(), (int) JfifUtil.MARKER_FIRST_BYTE) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }
}
