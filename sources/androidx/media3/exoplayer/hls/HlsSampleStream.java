package androidx.media3.exoplayer.hls;

import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.source.SampleStream;
import java.io.IOException;

final class HlsSampleStream implements SampleStream {

    /* renamed from: b  reason: collision with root package name */
    private final int f6407b;

    /* renamed from: c  reason: collision with root package name */
    private final HlsSampleStreamWrapper f6408c;

    /* renamed from: d  reason: collision with root package name */
    private int f6409d = -1;

    public HlsSampleStream(HlsSampleStreamWrapper hlsSampleStreamWrapper, int i2) {
        this.f6408c = hlsSampleStreamWrapper;
        this.f6407b = i2;
    }

    private boolean c() {
        int i2 = this.f6409d;
        return (i2 == -1 || i2 == -3 || i2 == -2) ? false : true;
    }

    public void a() throws IOException {
        int i2 = this.f6409d;
        if (i2 == -2) {
            throw new SampleQueueMappingException(this.f6408c.n().b(this.f6407b).a(0).f4015n);
        } else if (i2 == -1) {
            this.f6408c.W();
        } else if (i2 != -3) {
            this.f6408c.X(i2);
        }
    }

    public void b() {
        boolean z2;
        if (this.f6409d == -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        this.f6409d = this.f6408c.z(this.f6407b);
    }

    public int d(long j2) {
        if (c()) {
            return this.f6408c.q0(this.f6409d, j2);
        }
        return 0;
    }

    public void e() {
        if (this.f6409d != -1) {
            this.f6408c.r0(this.f6407b);
            this.f6409d = -1;
        }
    }

    public boolean isReady() {
        if (this.f6409d == -3 || (c() && this.f6408c.R(this.f6409d))) {
            return true;
        }
        return false;
    }

    public int m(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
        if (this.f6409d == -3) {
            decoderInputBuffer.addFlag(4);
            return -4;
        } else if (c()) {
            return this.f6408c.g0(this.f6409d, formatHolder, decoderInputBuffer, i2);
        } else {
            return -3;
        }
    }
}
