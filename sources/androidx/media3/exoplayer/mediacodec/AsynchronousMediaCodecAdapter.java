package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import com.google.common.base.Supplier;
import java.nio.ByteBuffer;

final class AsynchronousMediaCodecAdapter implements MediaCodecAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final MediaCodec f6634a;

    /* renamed from: b  reason: collision with root package name */
    private final AsynchronousMediaCodecCallback f6635b;

    /* renamed from: c  reason: collision with root package name */
    private final MediaCodecBufferEnqueuer f6636c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6637d;

    /* renamed from: e  reason: collision with root package name */
    private int f6638e;

    public static final class Factory implements MediaCodecAdapter.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final Supplier<HandlerThread> f6639a;

        /* renamed from: b  reason: collision with root package name */
        private final Supplier<HandlerThread> f6640b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f6641c;

        public Factory(int i2) {
            this(new d(i2), new e(i2));
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ HandlerThread f(int i2) {
            return new HandlerThread(AsynchronousMediaCodecAdapter.t(i2));
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ HandlerThread g(int i2) {
            return new HandlerThread(AsynchronousMediaCodecAdapter.u(i2));
        }

        private static boolean h(Format format) {
            int i2 = Util.f4714a;
            if (i2 < 34) {
                return false;
            }
            if (i2 >= 35 || MimeTypes.s(format.f4015n)) {
                return true;
            }
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0063  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0069  */
        /* renamed from: d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecAdapter a(androidx.media3.exoplayer.mediacodec.MediaCodecAdapter.Configuration r7) throws java.io.IOException {
            /*
                r6 = this;
                androidx.media3.exoplayer.mediacodec.MediaCodecInfo r0 = r7.f6678a
                java.lang.String r0 = r0.f6687a
                r1 = 0
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005f }
                r2.<init>()     // Catch:{ Exception -> 0x005f }
                java.lang.String r3 = "createCodec:"
                r2.append(r3)     // Catch:{ Exception -> 0x005f }
                r2.append(r0)     // Catch:{ Exception -> 0x005f }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x005f }
                androidx.media3.common.util.TraceUtil.a(r2)     // Catch:{ Exception -> 0x005f }
                android.media.MediaCodec r0 = android.media.MediaCodec.createByCodecName(r0)     // Catch:{ Exception -> 0x005f }
                int r2 = r7.f6683f     // Catch:{ Exception -> 0x005d }
                boolean r3 = r6.f6641c     // Catch:{ Exception -> 0x005d }
                if (r3 == 0) goto L_0x0033
                androidx.media3.common.Format r3 = r7.f6680c     // Catch:{ Exception -> 0x005d }
                boolean r3 = h(r3)     // Catch:{ Exception -> 0x005d }
                if (r3 == 0) goto L_0x0033
                androidx.media3.exoplayer.mediacodec.SynchronousMediaCodecBufferEnqueuer r3 = new androidx.media3.exoplayer.mediacodec.SynchronousMediaCodecBufferEnqueuer     // Catch:{ Exception -> 0x005d }
                r3.<init>(r0)     // Catch:{ Exception -> 0x005d }
                r2 = r2 | 4
                goto L_0x0040
            L_0x0033:
                androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer r3 = new androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer     // Catch:{ Exception -> 0x005d }
                com.google.common.base.Supplier<android.os.HandlerThread> r4 = r6.f6640b     // Catch:{ Exception -> 0x005d }
                java.lang.Object r4 = r4.get()     // Catch:{ Exception -> 0x005d }
                android.os.HandlerThread r4 = (android.os.HandlerThread) r4     // Catch:{ Exception -> 0x005d }
                r3.<init>(r0, r4)     // Catch:{ Exception -> 0x005d }
            L_0x0040:
                androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecAdapter r4 = new androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecAdapter     // Catch:{ Exception -> 0x005d }
                com.google.common.base.Supplier<android.os.HandlerThread> r5 = r6.f6639a     // Catch:{ Exception -> 0x005d }
                java.lang.Object r5 = r5.get()     // Catch:{ Exception -> 0x005d }
                android.os.HandlerThread r5 = (android.os.HandlerThread) r5     // Catch:{ Exception -> 0x005d }
                r4.<init>(r0, r5, r3)     // Catch:{ Exception -> 0x005d }
                androidx.media3.common.util.TraceUtil.b()     // Catch:{ Exception -> 0x005a }
                android.media.MediaFormat r1 = r7.f6679b     // Catch:{ Exception -> 0x005a }
                android.view.Surface r3 = r7.f6681d     // Catch:{ Exception -> 0x005a }
                android.media.MediaCrypto r7 = r7.f6682e     // Catch:{ Exception -> 0x005a }
                r4.w(r1, r3, r7, r2)     // Catch:{ Exception -> 0x005a }
                return r4
            L_0x005a:
                r7 = move-exception
                r1 = r4
                goto L_0x0061
            L_0x005d:
                r7 = move-exception
                goto L_0x0061
            L_0x005f:
                r7 = move-exception
                r0 = r1
            L_0x0061:
                if (r1 != 0) goto L_0x0069
                if (r0 == 0) goto L_0x006c
                r0.release()
                goto L_0x006c
            L_0x0069:
                r1.release()
            L_0x006c:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecAdapter.Factory.a(androidx.media3.exoplayer.mediacodec.MediaCodecAdapter$Configuration):androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecAdapter");
        }

        public void e(boolean z2) {
            this.f6641c = z2;
        }

        Factory(Supplier<HandlerThread> supplier, Supplier<HandlerThread> supplier2) {
            this.f6639a = supplier;
            this.f6640b = supplier2;
            this.f6641c = true;
        }
    }

    /* access modifiers changed from: private */
    public static String t(int i2) {
        return v(i2, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    /* access modifiers changed from: private */
    public static String u(int i2) {
        return v(i2, "ExoPlayer:MediaCodecQueueingThread:");
    }

    private static String v(int i2, String str) {
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
    public void w(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i2) {
        this.f6635b.h(this.f6634a);
        TraceUtil.a("configureCodec");
        this.f6634a.configure(mediaFormat, surface, mediaCrypto, i2);
        TraceUtil.b();
        this.f6636c.start();
        TraceUtil.a("startCodec");
        this.f6634a.start();
        TraceUtil.b();
        this.f6638e = 1;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, MediaCodec mediaCodec, long j2, long j3) {
        onFrameRenderedListener.a(this, j2, j3);
    }

    public void a(int i2, int i3, int i4, long j2, int i5) {
        this.f6636c.a(i2, i3, i4, j2, i5);
    }

    public void b(Bundle bundle) {
        this.f6636c.b(bundle);
    }

    public MediaFormat c() {
        return this.f6635b.g();
    }

    public void d(int i2) {
        this.f6634a.setVideoScalingMode(i2);
    }

    public ByteBuffer e(int i2) {
        return this.f6634a.getInputBuffer(i2);
    }

    public void f(Surface surface) {
        this.f6634a.setOutputSurface(surface);
    }

    public void flush() {
        this.f6636c.flush();
        this.f6634a.flush();
        this.f6635b.e();
        this.f6634a.start();
    }

    public void g(int i2, int i3, CryptoInfo cryptoInfo, long j2, int i4) {
        this.f6636c.g(i2, i3, cryptoInfo, j2, i4);
    }

    public boolean h() {
        return false;
    }

    public void i(int i2, long j2) {
        this.f6634a.releaseOutputBuffer(i2, j2);
    }

    public int j() {
        this.f6636c.c();
        return this.f6635b.c();
    }

    public int k(MediaCodec.BufferInfo bufferInfo) {
        this.f6636c.c();
        return this.f6635b.d(bufferInfo);
    }

    public void l(int i2, boolean z2) {
        this.f6634a.releaseOutputBuffer(i2, z2);
    }

    public ByteBuffer m(int i2) {
        return this.f6634a.getOutputBuffer(i2);
    }

    public boolean n(MediaCodecAdapter.OnBufferAvailableListener onBufferAvailableListener) {
        this.f6635b.p(onBufferAvailableListener);
        return true;
    }

    public void o(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, Handler handler) {
        this.f6634a.setOnFrameRenderedListener(new c(this, onFrameRenderedListener), handler);
    }

    public void release() {
        try {
            if (this.f6638e == 1) {
                this.f6636c.shutdown();
                this.f6635b.q();
            }
            this.f6638e = 2;
            if (!this.f6637d) {
                try {
                    int i2 = Util.f4714a;
                    if (i2 >= 30 && i2 < 33) {
                        this.f6634a.stop();
                    }
                } finally {
                    this.f6634a.release();
                    this.f6637d = true;
                }
            }
        } catch (Throwable th) {
            if (!this.f6637d) {
                int i3 = Util.f4714a;
                if (i3 >= 30 && i3 < 33) {
                    this.f6634a.stop();
                }
            }
            throw th;
        } finally {
            this.f6634a.release();
            this.f6637d = true;
        }
    }

    private AsynchronousMediaCodecAdapter(MediaCodec mediaCodec, HandlerThread handlerThread, MediaCodecBufferEnqueuer mediaCodecBufferEnqueuer) {
        this.f6634a = mediaCodec;
        this.f6635b = new AsynchronousMediaCodecCallback(handlerThread);
        this.f6636c = mediaCodecBufferEnqueuer;
        this.f6638e = 0;
    }
}
