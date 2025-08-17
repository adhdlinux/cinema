package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.common.base.Supplier;
import java.nio.ByteBuffer;

final class AsynchronousMediaCodecAdapter implements MediaCodecAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final MediaCodec f25215a;

    /* renamed from: b  reason: collision with root package name */
    private final AsynchronousMediaCodecCallback f25216b;

    /* renamed from: c  reason: collision with root package name */
    private final AsynchronousMediaCodecBufferEnqueuer f25217c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f25218d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f25219e;

    /* renamed from: f  reason: collision with root package name */
    private int f25220f;

    public static final class Factory implements MediaCodecAdapter.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final Supplier<HandlerThread> f25221a;

        /* renamed from: b  reason: collision with root package name */
        private final Supplier<HandlerThread> f25222b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f25223c;

        public Factory(int i2, boolean z2) {
            this(new b(i2), new c(i2), z2);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ HandlerThread e(int i2) {
            return new HandlerThread(AsynchronousMediaCodecAdapter.s(i2));
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ HandlerThread f(int i2) {
            return new HandlerThread(AsynchronousMediaCodecAdapter.t(i2));
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
        /* renamed from: d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter a(com.google.android.exoplayer2.mediacodec.MediaCodecAdapter.Configuration r10) throws java.io.IOException {
            /*
                r9 = this;
                com.google.android.exoplayer2.mediacodec.MediaCodecInfo r0 = r10.f25265a
                java.lang.String r0 = r0.f25273a
                r1 = 0
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004d }
                r2.<init>()     // Catch:{ Exception -> 0x004d }
                java.lang.String r3 = "createCodec:"
                r2.append(r3)     // Catch:{ Exception -> 0x004d }
                r2.append(r0)     // Catch:{ Exception -> 0x004d }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x004d }
                com.google.android.exoplayer2.util.TraceUtil.a(r2)     // Catch:{ Exception -> 0x004d }
                android.media.MediaCodec r0 = android.media.MediaCodec.createByCodecName(r0)     // Catch:{ Exception -> 0x004d }
                com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter r2 = new com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter     // Catch:{ Exception -> 0x004b }
                com.google.common.base.Supplier<android.os.HandlerThread> r3 = r9.f25221a     // Catch:{ Exception -> 0x004b }
                java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x004b }
                r5 = r3
                android.os.HandlerThread r5 = (android.os.HandlerThread) r5     // Catch:{ Exception -> 0x004b }
                com.google.common.base.Supplier<android.os.HandlerThread> r3 = r9.f25222b     // Catch:{ Exception -> 0x004b }
                java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x004b }
                r6 = r3
                android.os.HandlerThread r6 = (android.os.HandlerThread) r6     // Catch:{ Exception -> 0x004b }
                boolean r7 = r9.f25223c     // Catch:{ Exception -> 0x004b }
                r8 = 0
                r3 = r2
                r4 = r0
                r3.<init>(r4, r5, r6, r7)     // Catch:{ Exception -> 0x004b }
                com.google.android.exoplayer2.util.TraceUtil.c()     // Catch:{ Exception -> 0x0048 }
                android.media.MediaFormat r1 = r10.f25266b     // Catch:{ Exception -> 0x0048 }
                android.view.Surface r3 = r10.f25268d     // Catch:{ Exception -> 0x0048 }
                android.media.MediaCrypto r4 = r10.f25269e     // Catch:{ Exception -> 0x0048 }
                int r10 = r10.f25270f     // Catch:{ Exception -> 0x0048 }
                r2.v(r1, r3, r4, r10)     // Catch:{ Exception -> 0x0048 }
                return r2
            L_0x0048:
                r10 = move-exception
                r1 = r2
                goto L_0x004f
            L_0x004b:
                r10 = move-exception
                goto L_0x004f
            L_0x004d:
                r10 = move-exception
                r0 = r1
            L_0x004f:
                if (r1 != 0) goto L_0x0057
                if (r0 == 0) goto L_0x005a
                r0.release()
                goto L_0x005a
            L_0x0057:
                r1.release()
            L_0x005a:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter.Factory.a(com.google.android.exoplayer2.mediacodec.MediaCodecAdapter$Configuration):com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter");
        }

        Factory(Supplier<HandlerThread> supplier, Supplier<HandlerThread> supplier2, boolean z2) {
            this.f25221a = supplier;
            this.f25222b = supplier2;
            this.f25223c = z2;
        }
    }

    /* access modifiers changed from: private */
    public static String s(int i2) {
        return u(i2, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    /* access modifiers changed from: private */
    public static String t(int i2) {
        return u(i2, "ExoPlayer:MediaCodecQueueingThread:");
    }

    private static String u(int i2, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i2 == 1) {
            sb.append("Audio");
        } else if (i2 == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i2);
            sb.append(")");
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public void v(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i2) {
        this.f25216b.h(this.f25215a);
        TraceUtil.a("configureCodec");
        this.f25215a.configure(mediaFormat, surface, mediaCrypto, i2);
        TraceUtil.c();
        this.f25217c.q();
        TraceUtil.a("startCodec");
        this.f25215a.start();
        TraceUtil.c();
        this.f25220f = 1;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, MediaCodec mediaCodec, long j2, long j3) {
        onFrameRenderedListener.a(this, j2, j3);
    }

    private void x() {
        if (this.f25218d) {
            try {
                this.f25217c.r();
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e2);
            }
        }
    }

    public void a(int i2, int i3, int i4, long j2, int i5) {
        this.f25217c.m(i2, i3, i4, j2, i5);
    }

    public void b(Bundle bundle) {
        x();
        this.f25215a.setParameters(bundle);
    }

    public MediaFormat c() {
        return this.f25216b.g();
    }

    public void d(int i2) {
        x();
        this.f25215a.setVideoScalingMode(i2);
    }

    public ByteBuffer e(int i2) {
        return this.f25215a.getInputBuffer(i2);
    }

    public void f(Surface surface) {
        x();
        this.f25215a.setOutputSurface(surface);
    }

    public void flush() {
        this.f25217c.i();
        this.f25215a.flush();
        this.f25216b.e();
        this.f25215a.start();
    }

    public void g(int i2, int i3, CryptoInfo cryptoInfo, long j2, int i4) {
        this.f25217c.n(i2, i3, cryptoInfo, j2, i4);
    }

    public boolean h() {
        return false;
    }

    public void i(int i2, long j2) {
        this.f25215a.releaseOutputBuffer(i2, j2);
    }

    public int j() {
        this.f25217c.l();
        return this.f25216b.c();
    }

    public int k(MediaCodec.BufferInfo bufferInfo) {
        this.f25217c.l();
        return this.f25216b.d(bufferInfo);
    }

    public void l(int i2, boolean z2) {
        this.f25215a.releaseOutputBuffer(i2, z2);
    }

    public ByteBuffer m(int i2) {
        return this.f25215a.getOutputBuffer(i2);
    }

    public void n(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, Handler handler) {
        x();
        this.f25215a.setOnFrameRenderedListener(new a(this, onFrameRenderedListener), handler);
    }

    public void release() {
        try {
            if (this.f25220f == 1) {
                this.f25217c.p();
                this.f25216b.o();
            }
            this.f25220f = 2;
        } finally {
            if (!this.f25219e) {
                this.f25215a.release();
                this.f25219e = true;
            }
        }
    }

    private AsynchronousMediaCodecAdapter(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z2) {
        this.f25215a = mediaCodec;
        this.f25216b = new AsynchronousMediaCodecCallback(handlerThread);
        this.f25217c = new AsynchronousMediaCodecBufferEnqueuer(mediaCodec, handlerThread2);
        this.f25218d = z2;
        this.f25220f = 0;
    }
}
