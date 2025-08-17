package com.google.android.exoplayer2.source.rtsp;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import q0.c;

final class RtspMessageChannel implements Closeable {

    /* renamed from: h  reason: collision with root package name */
    public static final Charset f26880h = Charsets.UTF_8;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final MessageListener f26881b;

    /* renamed from: c  reason: collision with root package name */
    private final Loader f26882c = new Loader("ExoPlayer:RtspMessageChannel:ReceiverLoader");
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Map<Integer, InterleavedBinaryDataListener> f26883d = Collections.synchronizedMap(new HashMap());

    /* renamed from: e  reason: collision with root package name */
    private Sender f26884e;

    /* renamed from: f  reason: collision with root package name */
    private Socket f26885f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f26886g;

    public interface InterleavedBinaryDataListener {
        void q(byte[] bArr);
    }

    private final class LoaderCallbackImpl implements Loader.Callback<Receiver> {
        private LoaderCallbackImpl() {
        }

        /* renamed from: a */
        public void p(Receiver receiver, long j2, long j3, boolean z2) {
        }

        /* renamed from: b */
        public void q(Receiver receiver, long j2, long j3) {
        }

        /* renamed from: c */
        public Loader.LoadErrorAction t(Receiver receiver, long j2, long j3, IOException iOException, int i2) {
            if (!RtspMessageChannel.this.f26886g) {
                RtspMessageChannel.this.f26881b.a(iOException);
            }
            return Loader.f28464f;
        }
    }

    public interface MessageListener {
        void a(Exception exc);

        void b(List<String> list, Exception exc);

        void c(List<String> list);
    }

    private static final class MessageParser {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f26888a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private int f26889b = 1;

        /* renamed from: c  reason: collision with root package name */
        private long f26890c;

        private ImmutableList<String> a(byte[] bArr) {
            boolean z2;
            String str;
            if (this.f26889b == 3) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.g(z2);
            if (bArr.length <= 0 || bArr[bArr.length - 1] != 10) {
                throw new IllegalArgumentException("Message body is empty or does not end with a LF.");
            }
            if (bArr.length <= 1 || bArr[bArr.length - 2] != 13) {
                str = new String(bArr, 0, bArr.length - 1, RtspMessageChannel.f26880h);
            } else {
                str = new String(bArr, 0, bArr.length - 2, RtspMessageChannel.f26880h);
            }
            this.f26888a.add(str);
            ImmutableList<String> n2 = ImmutableList.n(this.f26888a);
            e();
            return n2;
        }

        private ImmutableList<String> b(byte[] bArr) throws ParserException {
            boolean z2;
            if (bArr.length >= 2 && bArr[bArr.length - 2] == 13 && bArr[bArr.length - 1] == 10) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.a(z2);
            String str = new String(bArr, 0, bArr.length - 2, RtspMessageChannel.f26880h);
            this.f26888a.add(str);
            int i2 = this.f26889b;
            if (i2 != 1) {
                if (i2 == 2) {
                    long g2 = RtspMessageUtil.g(str);
                    if (g2 != -1) {
                        this.f26890c = g2;
                    }
                    if (!str.isEmpty()) {
                        return null;
                    }
                    if (this.f26890c > 0) {
                        this.f26889b = 3;
                        return null;
                    }
                    ImmutableList<String> n2 = ImmutableList.n(this.f26888a);
                    e();
                    return n2;
                }
                throw new IllegalStateException();
            } else if (!RtspMessageUtil.f(str)) {
                return null;
            } else {
                this.f26889b = 2;
                return null;
            }
        }

        private static byte[] d(byte b2, DataInputStream dataInputStream) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = {b2, dataInputStream.readByte()};
            byteArrayOutputStream.write(bArr);
            while (true) {
                if (bArr[0] == 13 && bArr[1] == 10) {
                    return byteArrayOutputStream.toByteArray();
                }
                bArr[0] = bArr[1];
                byte readByte = dataInputStream.readByte();
                bArr[1] = readByte;
                byteArrayOutputStream.write(readByte);
            }
        }

        private void e() {
            this.f26888a.clear();
            this.f26889b = 1;
            this.f26890c = 0;
        }

        public ImmutableList<String> c(byte b2, DataInputStream dataInputStream) throws IOException {
            boolean z2;
            ImmutableList<String> b3 = b(d(b2, dataInputStream));
            while (b3 == null) {
                if (this.f26889b == 3) {
                    long j2 = this.f26890c;
                    if (j2 > 0) {
                        int d2 = Ints.d(j2);
                        if (d2 != -1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        Assertions.g(z2);
                        byte[] bArr = new byte[d2];
                        dataInputStream.readFully(bArr, 0, d2);
                        b3 = a(bArr);
                    } else {
                        throw new IllegalStateException("Expects a greater than zero Content-Length.");
                    }
                } else {
                    b3 = b(d(dataInputStream.readByte(), dataInputStream));
                }
            }
            return b3;
        }
    }

    private final class Receiver implements Loader.Loadable {

        /* renamed from: a  reason: collision with root package name */
        private final DataInputStream f26891a;

        /* renamed from: b  reason: collision with root package name */
        private final MessageParser f26892b = new MessageParser();

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f26893c;

        public Receiver(InputStream inputStream) {
            this.f26891a = new DataInputStream(inputStream);
        }

        private void c() throws IOException {
            int readUnsignedByte = this.f26891a.readUnsignedByte();
            int readUnsignedShort = this.f26891a.readUnsignedShort();
            byte[] bArr = new byte[readUnsignedShort];
            this.f26891a.readFully(bArr, 0, readUnsignedShort);
            InterleavedBinaryDataListener interleavedBinaryDataListener = (InterleavedBinaryDataListener) RtspMessageChannel.this.f26883d.get(Integer.valueOf(readUnsignedByte));
            if (interleavedBinaryDataListener != null && !RtspMessageChannel.this.f26886g) {
                interleavedBinaryDataListener.q(bArr);
            }
        }

        private void d(byte b2) throws IOException {
            if (!RtspMessageChannel.this.f26886g) {
                RtspMessageChannel.this.f26881b.c(this.f26892b.c(b2, this.f26891a));
            }
        }

        public void a() throws IOException {
            while (!this.f26893c) {
                byte readByte = this.f26891a.readByte();
                if (readByte == 36) {
                    c();
                } else {
                    d(readByte);
                }
            }
        }

        public void b() {
            this.f26893c = true;
        }
    }

    private final class Sender implements Closeable {

        /* renamed from: b  reason: collision with root package name */
        private final OutputStream f26895b;

        /* renamed from: c  reason: collision with root package name */
        private final HandlerThread f26896c;

        /* renamed from: d  reason: collision with root package name */
        private final Handler f26897d;

        public Sender(OutputStream outputStream) {
            this.f26895b = outputStream;
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:RtspMessageChannel:Sender");
            this.f26896c = handlerThread;
            handlerThread.start();
            this.f26897d = new Handler(handlerThread.getLooper());
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(byte[] bArr, List list) {
            try {
                this.f26895b.write(bArr);
            } catch (Exception e2) {
                if (!RtspMessageChannel.this.f26886g) {
                    RtspMessageChannel.this.f26881b.b(list, e2);
                }
            }
        }

        public void close() {
            Handler handler = this.f26897d;
            HandlerThread handlerThread = this.f26896c;
            Objects.requireNonNull(handlerThread);
            handler.post(new c(handlerThread));
            try {
                this.f26896c.join();
            } catch (InterruptedException unused) {
                this.f26896c.interrupt();
            }
        }

        public void i(List<String> list) {
            this.f26897d.post(new g(this, RtspMessageUtil.b(list), list));
        }
    }

    public RtspMessageChannel(MessageListener messageListener) {
        this.f26881b = messageListener;
    }

    public void close() throws IOException {
        if (!this.f26886g) {
            try {
                Sender sender = this.f26884e;
                if (sender != null) {
                    sender.close();
                }
                this.f26882c.l();
                Socket socket = this.f26885f;
                if (socket != null) {
                    socket.close();
                }
            } finally {
                this.f26886g = true;
            }
        }
    }

    public void k(Socket socket) throws IOException {
        this.f26885f = socket;
        this.f26884e = new Sender(socket.getOutputStream());
        this.f26882c.n(new Receiver(socket.getInputStream()), new LoaderCallbackImpl(), 0);
    }

    public void q(int i2, InterleavedBinaryDataListener interleavedBinaryDataListener) {
        this.f26883d.put(Integer.valueOf(i2), interleavedBinaryDataListener);
    }

    public void s(List<String> list) {
        Assertions.i(this.f26884e);
        this.f26884e.i(list);
    }
}
