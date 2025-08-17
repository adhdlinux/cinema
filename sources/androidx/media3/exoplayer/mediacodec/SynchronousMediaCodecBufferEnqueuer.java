package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.os.Bundle;
import androidx.media3.decoder.CryptoInfo;

class SynchronousMediaCodecBufferEnqueuer implements MediaCodecBufferEnqueuer {

    /* renamed from: a  reason: collision with root package name */
    private final MediaCodec f6754a;

    public SynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec) {
        this.f6754a = mediaCodec;
    }

    public void a(int i2, int i3, int i4, long j2, int i5) {
        this.f6754a.queueInputBuffer(i2, i3, i4, j2, i5);
    }

    public void b(Bundle bundle) {
        this.f6754a.setParameters(bundle);
    }

    public void c() {
    }

    public void flush() {
    }

    public void g(int i2, int i3, CryptoInfo cryptoInfo, long j2, int i4) {
        this.f6754a.queueSecureInputBuffer(i2, i3, cryptoInfo.a(), j2, i4);
    }

    public void shutdown() {
    }

    public void start() {
    }
}
