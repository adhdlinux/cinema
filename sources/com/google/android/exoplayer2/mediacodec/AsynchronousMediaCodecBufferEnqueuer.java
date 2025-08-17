package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.media3.exoplayer.mediacodec.f;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

class AsynchronousMediaCodecBufferEnqueuer {

    /* renamed from: g  reason: collision with root package name */
    private static final ArrayDeque<MessageParams> f25224g = new ArrayDeque<>();

    /* renamed from: h  reason: collision with root package name */
    private static final Object f25225h = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final MediaCodec f25226a;

    /* renamed from: b  reason: collision with root package name */
    private final HandlerThread f25227b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f25228c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicReference<RuntimeException> f25229d;

    /* renamed from: e  reason: collision with root package name */
    private final ConditionVariable f25230e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f25231f;

    private static class MessageParams {

        /* renamed from: a  reason: collision with root package name */
        public int f25233a;

        /* renamed from: b  reason: collision with root package name */
        public int f25234b;

        /* renamed from: c  reason: collision with root package name */
        public int f25235c;

        /* renamed from: d  reason: collision with root package name */
        public final MediaCodec.CryptoInfo f25236d = new MediaCodec.CryptoInfo();

        /* renamed from: e  reason: collision with root package name */
        public long f25237e;

        /* renamed from: f  reason: collision with root package name */
        public int f25238f;

        MessageParams() {
        }

        public void a(int i2, int i3, int i4, long j2, int i5) {
            this.f25233a = i2;
            this.f25234b = i3;
            this.f25235c = i4;
            this.f25237e = j2;
            this.f25238f = i5;
        }
    }

    public AsynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec, HandlerThread handlerThread) {
        this(mediaCodec, handlerThread, new ConditionVariable());
    }

    private void b() throws InterruptedException {
        this.f25230e.d();
        ((Handler) Assertions.e(this.f25228c)).obtainMessage(2).sendToTarget();
        this.f25230e.a();
    }

    private static void c(CryptoInfo cryptoInfo, MediaCodec.CryptoInfo cryptoInfo2) {
        cryptoInfo2.numSubSamples = cryptoInfo.f23941f;
        cryptoInfo2.numBytesOfClearData = e(cryptoInfo.f23939d, cryptoInfo2.numBytesOfClearData);
        cryptoInfo2.numBytesOfEncryptedData = e(cryptoInfo.f23940e, cryptoInfo2.numBytesOfEncryptedData);
        cryptoInfo2.key = (byte[]) Assertions.e(d(cryptoInfo.f23937b, cryptoInfo2.key));
        cryptoInfo2.iv = (byte[]) Assertions.e(d(cryptoInfo.f23936a, cryptoInfo2.iv));
        cryptoInfo2.mode = cryptoInfo.f23938c;
        if (Util.f28808a >= 24) {
            cryptoInfo2.setPattern(new MediaCodec.CryptoInfo.Pattern(cryptoInfo.f23942g, cryptoInfo.f23943h));
        }
    }

    private static byte[] d(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private static int[] e(int[] iArr, int[] iArr2) {
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
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer$MessageParams} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer$MessageParams} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(android.os.Message r11) {
        /*
            r10 = this;
            int r0 = r11.what
            if (r0 == 0) goto L_0x0036
            r1 = 1
            if (r0 == r1) goto L_0x0022
            r1 = 2
            r2 = 0
            if (r0 == r1) goto L_0x001c
            java.util.concurrent.atomic.AtomicReference<java.lang.RuntimeException> r0 = r10.f25229d
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            int r11 = r11.what
            java.lang.String r11 = java.lang.String.valueOf(r11)
            r1.<init>(r11)
            androidx.media3.exoplayer.mediacodec.f.a(r0, r2, r1)
            goto L_0x0049
        L_0x001c:
            com.google.android.exoplayer2.util.ConditionVariable r11 = r10.f25230e
            r11.f()
            goto L_0x0049
        L_0x0022:
            java.lang.Object r11 = r11.obj
            r2 = r11
            com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer$MessageParams r2 = (com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.MessageParams) r2
            int r4 = r2.f25233a
            int r5 = r2.f25234b
            android.media.MediaCodec$CryptoInfo r6 = r2.f25236d
            long r7 = r2.f25237e
            int r9 = r2.f25238f
            r3 = r10
            r3.h(r4, r5, r6, r7, r9)
            goto L_0x0049
        L_0x0036:
            java.lang.Object r11 = r11.obj
            r2 = r11
            com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer$MessageParams r2 = (com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.MessageParams) r2
            int r4 = r2.f25233a
            int r5 = r2.f25234b
            int r6 = r2.f25235c
            long r7 = r2.f25237e
            int r9 = r2.f25238f
            r3 = r10
            r3.g(r4, r5, r6, r7, r9)
        L_0x0049:
            if (r2 == 0) goto L_0x004e
            o(r2)
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.f(android.os.Message):void");
    }

    private void g(int i2, int i3, int i4, long j2, int i5) {
        try {
            this.f25226a.queueInputBuffer(i2, i3, i4, j2, i5);
        } catch (RuntimeException e2) {
            f.a(this.f25229d, (Object) null, e2);
        }
    }

    private void h(int i2, int i3, MediaCodec.CryptoInfo cryptoInfo, long j2, int i4) {
        try {
            synchronized (f25225h) {
                this.f25226a.queueSecureInputBuffer(i2, i3, cryptoInfo, j2, i4);
            }
        } catch (RuntimeException e2) {
            f.a(this.f25229d, (Object) null, e2);
        }
    }

    private void j() throws InterruptedException {
        ((Handler) Assertions.e(this.f25228c)).removeCallbacksAndMessages((Object) null);
        b();
    }

    private static MessageParams k() {
        ArrayDeque<MessageParams> arrayDeque = f25224g;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                MessageParams messageParams = new MessageParams();
                return messageParams;
            }
            MessageParams removeFirst = arrayDeque.removeFirst();
            return removeFirst;
        }
    }

    private static void o(MessageParams messageParams) {
        ArrayDeque<MessageParams> arrayDeque = f25224g;
        synchronized (arrayDeque) {
            arrayDeque.add(messageParams);
        }
    }

    public void i() {
        if (this.f25231f) {
            try {
                j();
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e2);
            }
        }
    }

    public void l() {
        RuntimeException andSet = this.f25229d.getAndSet((Object) null);
        if (andSet != null) {
            throw andSet;
        }
    }

    public void m(int i2, int i3, int i4, long j2, int i5) {
        l();
        MessageParams k2 = k();
        k2.a(i2, i3, i4, j2, i5);
        ((Handler) Util.j(this.f25228c)).obtainMessage(0, k2).sendToTarget();
    }

    public void n(int i2, int i3, CryptoInfo cryptoInfo, long j2, int i4) {
        l();
        MessageParams k2 = k();
        k2.a(i2, i3, 0, j2, i4);
        c(cryptoInfo, k2.f25236d);
        ((Handler) Util.j(this.f25228c)).obtainMessage(1, k2).sendToTarget();
    }

    public void p() {
        if (this.f25231f) {
            i();
            this.f25227b.quit();
        }
        this.f25231f = false;
    }

    public void q() {
        if (!this.f25231f) {
            this.f25227b.start();
            this.f25228c = new Handler(this.f25227b.getLooper()) {
                public void handleMessage(Message message) {
                    AsynchronousMediaCodecBufferEnqueuer.this.f(message);
                }
            };
            this.f25231f = true;
        }
    }

    public void r() throws InterruptedException {
        b();
    }

    AsynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec, HandlerThread handlerThread, ConditionVariable conditionVariable) {
        this.f25226a = mediaCodec;
        this.f25227b = handlerThread;
        this.f25230e = conditionVariable;
        this.f25229d = new AtomicReference<>();
    }
}
