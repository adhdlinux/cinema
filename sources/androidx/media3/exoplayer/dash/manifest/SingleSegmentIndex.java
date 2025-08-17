package androidx.media3.exoplayer.dash.manifest;

import androidx.media3.exoplayer.dash.DashSegmentIndex;

final class SingleSegmentIndex implements DashSegmentIndex {

    /* renamed from: a  reason: collision with root package name */
    private final RangedUri f6134a;

    public SingleSegmentIndex(RangedUri rangedUri) {
        this.f6134a = rangedUri;
    }

    public long b(long j2) {
        return 0;
    }

    public long c(long j2, long j3) {
        return j3;
    }

    public long d(long j2, long j3) {
        return 0;
    }

    public long e(long j2, long j3) {
        return -9223372036854775807L;
    }

    public RangedUri f(long j2) {
        return this.f6134a;
    }

    public long g(long j2, long j3) {
        return 0;
    }

    public long h(long j2) {
        return 1;
    }

    public boolean i() {
        return true;
    }

    public long j() {
        return 0;
    }

    public long k(long j2, long j3) {
        return 1;
    }
}
