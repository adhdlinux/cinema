package okhttp3.internal.http2;

import com.facebook.imageutils.JfifUtil;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSink;

public final class Http2Writer implements Closeable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize = Http2.INITIAL_MAX_FRAME_SIZE;
    private final BufferedSink sink;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Http2Writer(BufferedSink bufferedSink, boolean z2) {
        Intrinsics.f(bufferedSink, "sink");
        this.sink = bufferedSink;
        this.client = z2;
        Buffer buffer = new Buffer();
        this.hpackBuffer = buffer;
        this.hpackWriter = new Hpack.Writer(0, false, buffer, 3, (DefaultConstructorMarker) null);
    }

    private final void writeContinuationFrames(int i2, long j2) throws IOException {
        int i3;
        while (j2 > 0) {
            long min = Math.min((long) this.maxFrameSize, j2);
            j2 -= min;
            int i4 = (int) min;
            if (j2 == 0) {
                i3 = 4;
            } else {
                i3 = 0;
            }
            frameHeader(i2, i4, 9, i3);
            this.sink.write(this.hpackBuffer, min);
        }
    }

    public final synchronized void applyAndAckSettings(Settings settings) throws IOException {
        Intrinsics.f(settings, "peerSettings");
        if (!this.closed) {
            this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
            if (settings.getHeaderTableSize() != -1) {
                this.hpackWriter.resizeHeaderTable(settings.getHeaderTableSize());
            }
            frameHeader(0, 0, 4, 1);
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    public final synchronized void connectionPreface() throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        } else if (this.client) {
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine(Util.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.k(), new Object[0]));
            }
            this.sink.h0(Http2.CONNECTION_PREFACE);
            this.sink.flush();
        }
    }

    public final synchronized void data(boolean z2, int i2, Buffer buffer, int i3) throws IOException {
        if (!this.closed) {
            dataFrame(i2, z2 ? 1 : 0, buffer, i3);
        } else {
            throw new IOException("closed");
        }
    }

    public final void dataFrame(int i2, int i3, Buffer buffer, int i4) throws IOException {
        frameHeader(i2, i4, 0, i3);
        if (i4 > 0) {
            BufferedSink bufferedSink = this.sink;
            Intrinsics.c(buffer);
            bufferedSink.write(buffer, (long) i4);
        }
    }

    public final synchronized void flush() throws IOException {
        if (!this.closed) {
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final void frameHeader(int i2, int i3, int i4, int i5) throws IOException {
        boolean z2;
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Http2.INSTANCE.frameLog(false, i2, i3, i4, i5));
        }
        boolean z3 = true;
        if (i3 <= this.maxFrameSize) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if ((Integer.MIN_VALUE & i2) != 0) {
                z3 = false;
            }
            if (z3) {
                Util.writeMedium(this.sink, i3);
                this.sink.writeByte(i4 & JfifUtil.MARKER_FIRST_BYTE);
                this.sink.writeByte(i5 & JfifUtil.MARKER_FIRST_BYTE);
                this.sink.writeInt(i2 & Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException(("reserved bit set: " + i2).toString());
        }
        throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + ": " + i3).toString());
    }

    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final synchronized void goAway(int i2, ErrorCode errorCode, byte[] bArr) throws IOException {
        boolean z2;
        Intrinsics.f(errorCode, "errorCode");
        Intrinsics.f(bArr, "debugData");
        if (!this.closed) {
            boolean z3 = false;
            if (errorCode.getHttpCode() != -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                frameHeader(0, bArr.length + 8, 7, 0);
                this.sink.writeInt(i2);
                this.sink.writeInt(errorCode.getHttpCode());
                if (bArr.length == 0) {
                    z3 = true;
                }
                if (!z3) {
                    this.sink.write(bArr);
                }
                this.sink.flush();
            } else {
                throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void headers(boolean z2, int i2, List<Header> list) throws IOException {
        int i3;
        Intrinsics.f(list, "headerBlock");
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            long size = this.hpackBuffer.size();
            long min = Math.min((long) this.maxFrameSize, size);
            int i4 = (size > min ? 1 : (size == min ? 0 : -1));
            if (i4 == 0) {
                i3 = 4;
            } else {
                i3 = 0;
            }
            if (z2) {
                i3 |= 1;
            }
            frameHeader(i2, (int) min, 1, i3);
            this.sink.write(this.hpackBuffer, min);
            if (i4 > 0) {
                writeContinuationFrames(i2, size - min);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final synchronized void ping(boolean z2, int i2, int i3) throws IOException {
        int i4;
        if (!this.closed) {
            if (z2) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            frameHeader(0, 8, 6, i4);
            this.sink.writeInt(i2);
            this.sink.writeInt(i3);
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void pushPromise(int i2, int i3, List<Header> list) throws IOException {
        int i4;
        Intrinsics.f(list, "requestHeaders");
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            long size = this.hpackBuffer.size();
            int min = (int) Math.min(((long) this.maxFrameSize) - 4, size);
            int i5 = min + 4;
            long j2 = (long) min;
            int i6 = (size > j2 ? 1 : (size == j2 ? 0 : -1));
            if (i6 == 0) {
                i4 = 4;
            } else {
                i4 = 0;
            }
            frameHeader(i2, i5, 5, i4);
            this.sink.writeInt(i3 & Integer.MAX_VALUE);
            this.sink.write(this.hpackBuffer, j2);
            if (i6 > 0) {
                writeContinuationFrames(i2, size - j2);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void rstStream(int i2, ErrorCode errorCode) throws IOException {
        boolean z2;
        Intrinsics.f(errorCode, "errorCode");
        if (!this.closed) {
            if (errorCode.getHttpCode() != -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                frameHeader(i2, 4, 3, 0);
                this.sink.writeInt(errorCode.getHttpCode());
                this.sink.flush();
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void settings(Settings settings) throws IOException {
        int i2;
        Intrinsics.f(settings, "settings");
        if (!this.closed) {
            frameHeader(0, settings.size() * 6, 4, 0);
            for (int i3 = 0; i3 < 10; i3++) {
                if (settings.isSet(i3)) {
                    if (i3 == 4) {
                        i2 = 3;
                    } else if (i3 != 7) {
                        i2 = i3;
                    } else {
                        i2 = 4;
                    }
                    this.sink.writeShort(i2);
                    this.sink.writeInt(settings.get(i3));
                }
            }
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void windowUpdate(int i2, long j2) throws IOException {
        boolean z2;
        if (!this.closed) {
            if (j2 == 0 || j2 > 2147483647L) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                frameHeader(i2, 4, 8, 0);
                this.sink.writeInt((int) j2);
                this.sink.flush();
            } else {
                throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j2).toString());
            }
        } else {
            throw new IOException("closed");
        }
    }
}
