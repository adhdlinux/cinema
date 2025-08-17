package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SynchronousMediaCodecAdapter implements MediaCodecAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final MediaCodec f6751a;

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer[] f6752b;

    /* renamed from: c  reason: collision with root package name */
    private ByteBuffer[] f6753c;

    public static class Factory implements MediaCodecAdapter.Factory {
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.media3.exoplayer.mediacodec.MediaCodecAdapter a(androidx.media3.exoplayer.mediacodec.MediaCodecAdapter.Configuration r6) throws java.io.IOException {
            /*
                r5 = this;
                r0 = 0
                android.media.MediaCodec r1 = r5.b(r6)     // Catch:{ IOException -> 0x0030, RuntimeException -> 0x002e }
                java.lang.String r2 = "configureCodec"
                androidx.media3.common.util.TraceUtil.a(r2)     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                android.media.MediaFormat r2 = r6.f6679b     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                android.view.Surface r3 = r6.f6681d     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                android.media.MediaCrypto r4 = r6.f6682e     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                int r6 = r6.f6683f     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                r1.configure(r2, r3, r4, r6)     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                androidx.media3.common.util.TraceUtil.b()     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                java.lang.String r6 = "startCodec"
                androidx.media3.common.util.TraceUtil.a(r6)     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                r1.start()     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                androidx.media3.common.util.TraceUtil.b()     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                androidx.media3.exoplayer.mediacodec.SynchronousMediaCodecAdapter r6 = new androidx.media3.exoplayer.mediacodec.SynchronousMediaCodecAdapter     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                r6.<init>(r1)     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                return r6
            L_0x0029:
                r6 = move-exception
                goto L_0x002c
            L_0x002b:
                r6 = move-exception
            L_0x002c:
                r0 = r1
                goto L_0x0031
            L_0x002e:
                r6 = move-exception
                goto L_0x0031
            L_0x0030:
                r6 = move-exception
            L_0x0031:
                if (r0 == 0) goto L_0x0036
                r0.release()
            L_0x0036:
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.SynchronousMediaCodecAdapter.Factory.a(androidx.media3.exoplayer.mediacodec.MediaCodecAdapter$Configuration):androidx.media3.exoplayer.mediacodec.MediaCodecAdapter");
        }

        /* access modifiers changed from: protected */
        public MediaCodec b(MediaCodecAdapter.Configuration configuration) throws IOException {
            Assertions.f(configuration.f6678a);
            String str = configuration.f6678a.f6687a;
            TraceUtil.a("createCodec:" + str);
            MediaCodec createByCodecName = MediaCodec.createByCodecName(str);
            TraceUtil.b();
            return createByCodecName;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, MediaCodec mediaCodec, long j2, long j3) {
        onFrameRenderedListener.a(this, j2, j3);
    }

    public void a(int i2, int i3, int i4, long j2, int i5) {
        this.f6751a.queueInputBuffer(i2, i3, i4, j2, i5);
    }

    public void b(Bundle bundle) {
        this.f6751a.setParameters(bundle);
    }

    public MediaFormat c() {
        return this.f6751a.getOutputFormat();
    }

    public void d(int i2) {
        this.f6751a.setVideoScalingMode(i2);
    }

    public ByteBuffer e(int i2) {
        if (Util.f4714a >= 21) {
            return this.f6751a.getInputBuffer(i2);
        }
        return ((ByteBuffer[]) Util.i(this.f6752b))[i2];
    }

    public void f(Surface surface) {
        this.f6751a.setOutputSurface(surface);
    }

    public void flush() {
        this.f6751a.flush();
    }

    public void g(int i2, int i3, CryptoInfo cryptoInfo, long j2, int i4) {
        this.f6751a.queueSecureInputBuffer(i2, i3, cryptoInfo.a(), j2, i4);
    }

    public boolean h() {
        return false;
    }

    public void i(int i2, long j2) {
        this.f6751a.releaseOutputBuffer(i2, j2);
    }

    public int j() {
        return this.f6751a.dequeueInputBuffer(0);
    }

    public int k(MediaCodec.BufferInfo bufferInfo) {
        int dequeueOutputBuffer;
        do {
            dequeueOutputBuffer = this.f6751a.dequeueOutputBuffer(bufferInfo, 0);
            if (dequeueOutputBuffer == -3 && Util.f4714a < 21) {
                this.f6753c = this.f6751a.getOutputBuffers();
                continue;
            }
        } while (dequeueOutputBuffer == -3);
        return dequeueOutputBuffer;
    }

    public void l(int i2, boolean z2) {
        this.f6751a.releaseOutputBuffer(i2, z2);
    }

    public ByteBuffer m(int i2) {
        if (Util.f4714a >= 21) {
            return this.f6751a.getOutputBuffer(i2);
        }
        return ((ByteBuffer[]) Util.i(this.f6753c))[i2];
    }

    public /* synthetic */ boolean n(MediaCodecAdapter.OnBufferAvailableListener onBufferAvailableListener) {
        return i.a(this, onBufferAvailableListener);
    }

    public void o(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, Handler handler) {
        this.f6751a.setOnFrameRenderedListener(new x(this, onFrameRenderedListener), handler);
    }

    public void release() {
        this.f6752b = null;
        this.f6753c = null;
        try {
            int i2 = Util.f4714a;
            if (i2 >= 30 && i2 < 33) {
                this.f6751a.stop();
            }
        } finally {
            this.f6751a.release();
        }
    }

    private SynchronousMediaCodecAdapter(MediaCodec mediaCodec) {
        this.f6751a = mediaCodec;
        if (Util.f4714a < 21) {
            this.f6752b = mediaCodec.getInputBuffers();
            this.f6753c = mediaCodec.getOutputBuffers();
        }
    }
}
