package androidx.media3.exoplayer.dash;

import androidx.media3.exoplayer.dash.manifest.RangedUri;
import androidx.media3.extractor.ChunkIndex;

public final class DashWrappingSegmentIndex implements DashSegmentIndex {

    /* renamed from: a  reason: collision with root package name */
    private final ChunkIndex f5984a;

    /* renamed from: b  reason: collision with root package name */
    private final long f5985b;

    public DashWrappingSegmentIndex(ChunkIndex chunkIndex, long j2) {
        this.f5984a = chunkIndex;
        this.f5985b = j2;
    }

    public long b(long j2) {
        return this.f5984a.f7956e[(int) j2] - this.f5985b;
    }

    public long c(long j2, long j3) {
        return this.f5984a.f7955d[(int) j2];
    }

    public long d(long j2, long j3) {
        return 0;
    }

    public long e(long j2, long j3) {
        return -9223372036854775807L;
    }

    public RangedUri f(long j2) {
        ChunkIndex chunkIndex = this.f5984a;
        int i2 = (int) j2;
        return new RangedUri((String) null, chunkIndex.f7954c[i2], (long) chunkIndex.f7953b[i2]);
    }

    public long g(long j2, long j3) {
        return (long) this.f5984a.a(j2 + this.f5985b);
    }

    public long h(long j2) {
        return (long) this.f5984a.f7952a;
    }

    public boolean i() {
        return true;
    }

    public long j() {
        return 0;
    }

    public long k(long j2, long j3) {
        return (long) this.f5984a.f7952a;
    }
}
