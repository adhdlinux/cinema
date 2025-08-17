package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;

public final class DashWrappingSegmentIndex implements DashSegmentIndex {

    /* renamed from: a  reason: collision with root package name */
    private final ChunkIndex f26214a;

    /* renamed from: b  reason: collision with root package name */
    private final long f26215b;

    public DashWrappingSegmentIndex(ChunkIndex chunkIndex, long j2) {
        this.f26214a = chunkIndex;
        this.f26215b = j2;
    }

    public long b(long j2) {
        return this.f26214a.f24166e[(int) j2] - this.f26215b;
    }

    public long c(long j2, long j3) {
        return this.f26214a.f24165d[(int) j2];
    }

    public long d(long j2, long j3) {
        return 0;
    }

    public long e(long j2, long j3) {
        return -9223372036854775807L;
    }

    public RangedUri f(long j2) {
        ChunkIndex chunkIndex = this.f26214a;
        int i2 = (int) j2;
        return new RangedUri((String) null, chunkIndex.f24164c[i2], (long) chunkIndex.f24163b[i2]);
    }

    public long g(long j2, long j3) {
        return (long) this.f26214a.a(j2 + this.f26215b);
    }

    public long h(long j2) {
        return (long) this.f26214a.f24162a;
    }

    public boolean i() {
        return true;
    }

    public long j() {
        return 0;
    }

    public long k(long j2, long j3) {
        return (long) this.f26214a.f24162a;
    }
}
