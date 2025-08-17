package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoInfo;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

class AsynchronousMediaCodecBufferEnqueuer implements MediaCodecBufferEnqueuer {

    /* renamed from: g  reason: collision with root package name */
    private static final ArrayDeque<MessageParams> f6642g = new ArrayDeque<>();

    /* renamed from: h  reason: collision with root package name */
    private static final Object f6643h = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final MediaCodec f6644a;

    /* renamed from: b  reason: collision with root package name */
    private final HandlerThread f6645b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f6646c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicReference<RuntimeException> f6647d;

    /* renamed from: e  reason: collision with root package name */
    private final ConditionVariable f6648e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6649f;

    private static class MessageParams {

        /* renamed from: a  reason: collision with root package name */
        public int f6651a;

        /* renamed from: b  reason: collision with root package name */
        public int f6652b;

        /* renamed from: c  reason: collision with root package name */
        public int f6653c;

        /* renamed from: d  reason: collision with root package name */
        public final MediaCodec.CryptoInfo f6654d = new MediaCodec.CryptoInfo();

        /* renamed from: e  reason: collision with root package name */
        public long f6655e;

        /* renamed from: f  reason: collision with root package name */
        public int f6656f;

        MessageParams() {
        }

        public void a(int i2, int i3, int i4, long j2, int i5) {
            this.f6651a = i2;
            this.f6652b = i3;
            this.f6653c = i4;
            this.f6655e = j2;
            this.f6656f = i5;
        }
    }

    public AsynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec, HandlerThread handlerThread) {
        this(mediaCodec, handlerThread, new ConditionVariable());
    }

    private void e() throws InterruptedException {
        this.f6648e.c();
        ((Handler) Assertions.f(this.f6646c)).obtainMessage(3).sendToTarget();
        this.f6648e.a();
    }

    private static void f(CryptoInfo cryptoInfo, MediaCodec.CryptoInfo cryptoInfo2) {
        cryptoInfo2.numSubSamples = cryptoInfo.f5058f;
        cryptoInfo2.numBytesOfClearData = i(cryptoInfo.f5056d, cryptoInfo2.numBytesOfClearData);
        cryptoInfo2.numBytesOfEncryptedData = i(cryptoInfo.f5057e, cryptoInfo2.numBytesOfEncryptedData);
        cryptoInfo2.key = (byte[]) Assertions.f(h(cryptoInfo.f5054b, cryptoInfo2.key));
        cryptoInfo2.iv = (byte[]) Assertions.f(h(cryptoInfo.f5053a, cryptoInfo2.iv));
        cryptoInfo2.mode = cryptoInfo.f5055c;
        if (Util.f4714a >= 24) {
            cryptoInfo2.setPattern(new MediaCodec.CryptoInfo.Pattern(cryptoInfo.f5059g, cryptoInfo.f5060h));
        }
    }

    private static byte[] h(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private static int[] i(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer$MessageParams} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer$MessageParams} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j(android.os.Message r11) {
        /*
            r10 = this;
            int r0 = r11.what
            r1 = 1
            if (r0 == r1) goto L_0x0042
            r1 = 2
            if (r0 == r1) goto L_0x002e
            r1 = 3
            r2 = 0
            if (r0 == r1) goto L_0x0028
            r1 = 4
            if (r0 == r1) goto L_0x0020
            java.util.concurrent.atomic.AtomicReference<java.lang.RuntimeException> r0 = r10.f6647d
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            int r11 = r11.what
            java.lang.String r11 = java.lang.String.valueOf(r11)
            r1.<init>(r11)
            androidx.media3.exoplayer.mediacodec.f.a(r0, r2, r1)
            goto L_0x0055
        L_0x0020:
            java.lang.Object r11 = r11.obj
            android.os.Bundle r11 = (android.os.Bundle) r11
            r10.m(r11)
            goto L_0x0055
        L_0x0028:
            androidx.media3.common.util.ConditionVariable r11 = r10.f6648e
            r11.e()
            goto L_0x0055
        L_0x002e:
            java.lang.Object r11 = r11.obj
            r2 = r11
            androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer$MessageParams r2 = (androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer.MessageParams) r2
            int r4 = r2.f6651a
            int r5 = r2.f6652b
            android.media.MediaCodec$CryptoInfo r6 = r2.f6654d
            long r7 = r2.f6655e
            int r9 = r2.f6656f
            r3 = r10
            r3.l(r4, r5, r6, r7, r9)
            goto L_0x0055
        L_0x0042:
            java.lang.Object r11 = r11.obj
            r2 = r11
            androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer$MessageParams r2 = (androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer.MessageParams) r2
            int r4 = r2.f6651a
            int r5 = r2.f6652b
            int r6 = r2.f6653c
            long r7 = r2.f6655e
            int r9 = r2.f6656f
            r3 = r10
            r3.k(r4, r5, r6, r7, r9)
        L_0x0055:
            if (r2 == 0) goto L_0x005a
            p(r2)
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer.j(android.os.Message):void");
    }

    private void k(int i2, int i3, int i4, long j2, int i5) {
        try {
            this.f6644a.queueInputBuffer(i2, i3, i4, j2, i5);
        } catch (RuntimeException e2) {
            f.a(this.f6647d, (Object) null, e2);
        }
    }

    private void l(int i2, int i3, MediaCodec.CryptoInfo cryptoInfo, long j2, int i4) {
        try {
            synchronized (f6643h) {
                this.f6644a.queueSecureInputBuffer(i2, i3, cryptoInfo, j2, i4);
            }
        } catch (RuntimeException e2) {
            f.a(this.f6647d, (Object) null, e2);
        }
    }

    private void m(Bundle bundle) {
        try {
            this.f6644a.setParameters(bundle);
        } catch (RuntimeException e2) {
            f.a(this.f6647d, (Object) null, e2);
        }
    }

    private void n() throws InterruptedException {
        ((Handler) Assertions.f(this.f6646c)).removeCallbacksAndMessages((Object) null);
        e();
    }

    private static MessageParams o() {
        ArrayDeque<MessageParams> arrayDeque = f6642g;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                MessageParams messageParams = new MessageParams();
                return messageParams;
            }
            MessageParams removeFirst = arrayDeque.removeFirst();
            return removeFirst;
        }
    }

    private static void p(MessageParams messageParams) {
        ArrayDeque<MessageParams> arrayDeque = f6642g;
        synchronized (arrayDeque) {
            arrayDeque.add(messageParams);
        }
    }

    public void a(int i2, int i3, int i4, long j2, int i5) {
        c();
        MessageParams o2 = o();
        o2.a(i2, i3, i4, j2, i5);
        ((Handler) Util.i(this.f6646c)).obtainMessage(1, o2).sendToTarget();
    }

    public void b(Bundle bundle) {
        c();
        ((Handler) Util.i(this.f6646c)).obtainMessage(4, bundle).sendToTarget();
    }

    public void c() {
        RuntimeException andSet = this.f6647d.getAndSet((Object) null);
        if (andSet != null) {
            throw andSet;
        }
    }

    public void flush() {
        if (this.f6649f) {
            try {
                n();
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e2);
            }
        }
    }

    public void g(int i2, int i3, CryptoInfo cryptoInfo, long j2, int i4) {
        c();
        MessageParams o2 = o();
        o2.a(i2, i3, 0, j2, i4);
        f(cryptoInfo, o2.f6654d);
        ((Handler) Util.i(this.f6646c)).obtainMessage(2, o2).sendToTarget();
    }

    public void shutdown() {
        if (this.f6649f) {
            flush();
            this.f6645b.quit();
        }
        this.f6649f = false;
    }

    public void start() {
        if (!this.f6649f) {
            this.f6645b.start();
            this.f6646c = new Handler(this.f6645b.getLooper()) {
                public void handleMessage(Message message) {
                    AsynchronousMediaCodecBufferEnqueuer.this.j(message);
                }
            };
            this.f6649f = true;
        }
    }

    AsynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec, HandlerThread handlerThread, ConditionVariable conditionVariable) {
        this.f6644a = mediaCodec;
        this.f6645b = handlerThread;
        this.f6648e = conditionVariable;
        this.f6647d = new AtomicReference<>();
    }
}
