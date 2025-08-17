package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SynchronousMediaCodecAdapter implements MediaCodecAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final MediaCodec f25339a;

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer[] f25340b;

    /* renamed from: c  reason: collision with root package name */
    private ByteBuffer[] f25341c;

    public static class Factory implements MediaCodecAdapter.Factory {
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.exoplayer2.mediacodec.MediaCodecAdapter a(com.google.android.exoplayer2.mediacodec.MediaCodecAdapter.Configuration r6) throws java.io.IOException {
            /*
                r5 = this;
                r0 = 0
                android.media.MediaCodec r1 = r5.b(r6)     // Catch:{ IOException -> 0x0030, RuntimeException -> 0x002e }
                java.lang.String r2 = "configureCodec"
                com.google.android.exoplayer2.util.TraceUtil.a(r2)     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                android.media.MediaFormat r2 = r6.f25266b     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                android.view.Surface r3 = r6.f25268d     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                android.media.MediaCrypto r4 = r6.f25269e     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                int r6 = r6.f25270f     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                r1.configure(r2, r3, r4, r6)     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                com.google.android.exoplayer2.util.TraceUtil.c()     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                java.lang.String r6 = "startCodec"
                com.google.android.exoplayer2.util.TraceUtil.a(r6)     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                r1.start()     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                com.google.android.exoplayer2.util.TraceUtil.c()     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter r6 = new com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter.Factory.a(com.google.android.exoplayer2.mediacodec.MediaCodecAdapter$Configuration):com.google.android.exoplayer2.mediacodec.MediaCodecAdapter");
        }

        /* access modifiers changed from: protected */
        public MediaCodec b(MediaCodecAdapter.Configuration configuration) throws IOException {
            Assertions.e(configuration.f25265a);
            String str = configuration.f25265a.f25273a;
            TraceUtil.a("createCodec:" + str);
            MediaCodec createByCodecName = MediaCodec.createByCodecName(str);
            TraceUtil.c();
            return createByCodecName;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, MediaCodec mediaCodec, long j2, long j3) {
        onFrameRenderedListener.a(this, j2, j3);
    }

    public void a(int i2, int i3, int i4, long j2, int i5) {
        this.f25339a.queueInputBuffer(i2, i3, i4, j2, i5);
    }

    public void b(Bundle bundle) {
        this.f25339a.setParameters(bundle);
    }

    public MediaFormat c() {
        return this.f25339a.getOutputFormat();
    }

    public void d(int i2) {
        this.f25339a.setVideoScalingMode(i2);
    }

    public ByteBuffer e(int i2) {
        if (Util.f28808a >= 21) {
            return this.f25339a.getInputBuffer(i2);
        }
        return ((ByteBuffer[]) Util.j(this.f25340b))[i2];
    }

    public void f(Surface surface) {
        this.f25339a.setOutputSurface(surface);
    }

    public void flush() {
        this.f25339a.flush();
    }

    public void g(int i2, int i3, CryptoInfo cryptoInfo, long j2, int i4) {
        this.f25339a.queueSecureInputBuffer(i2, i3, cryptoInfo.a(), j2, i4);
    }

    public boolean h() {
        return false;
    }

    public void i(int i2, long j2) {
        this.f25339a.releaseOutputBuffer(i2, j2);
    }

    public int j() {
        return this.f25339a.dequeueInputBuffer(0);
    }

    public int k(MediaCodec.BufferInfo bufferInfo) {
        int dequeueOutputBuffer;
        do {
            dequeueOutputBuffer = this.f25339a.dequeueOutputBuffer(bufferInfo, 0);
            if (dequeueOutputBuffer == -3 && Util.f28808a < 21) {
                this.f25341c = this.f25339a.getOutputBuffers();
                continue;
            }
        } while (dequeueOutputBuffer == -3);
        return dequeueOutputBuffer;
    }

    public void l(int i2, boolean z2) {
        this.f25339a.releaseOutputBuffer(i2, z2);
    }

    public ByteBuffer m(int i2) {
        if (Util.f28808a >= 21) {
            return this.f25339a.getOutputBuffer(i2);
        }
        return ((ByteBuffer[]) Util.j(this.f25341c))[i2];
    }

    public void n(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, Handler handler) {
        this.f25339a.setOnFrameRenderedListener(new j(this, onFrameRenderedListener), handler);
    }

    public void release() {
        this.f25340b = null;
        this.f25341c = null;
        this.f25339a.release();
    }

    private SynchronousMediaCodecAdapter(MediaCodec mediaCodec) {
        this.f25339a = mediaCodec;
        if (Util.f28808a < 21) {
            this.f25340b = mediaCodec.getInputBuffers();
            this.f25341c = mediaCodec.getOutputBuffers();
        }
    }
}
