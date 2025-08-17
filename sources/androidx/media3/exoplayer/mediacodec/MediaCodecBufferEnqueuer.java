package androidx.media3.exoplayer.mediacodec;

import android.os.Bundle;
import androidx.media3.decoder.CryptoInfo;

interface MediaCodecBufferEnqueuer {
    void a(int i2, int i3, int i4, long j2, int i5);

    void b(Bundle bundle);

    void c();

    void flush();

    void g(int i2, int i3, CryptoInfo cryptoInfo, long j2, int i4);

    void shutdown();

    void start();
}
