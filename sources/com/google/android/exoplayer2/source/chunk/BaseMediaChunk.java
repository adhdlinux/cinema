package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;

public abstract class BaseMediaChunk extends MediaChunk {

    /* renamed from: k  reason: collision with root package name */
    public final long f26051k;

    /* renamed from: l  reason: collision with root package name */
    public final long f26052l;

    /* renamed from: m  reason: collision with root package name */
    private BaseMediaChunkOutput f26053m;

    /* renamed from: n  reason: collision with root package name */
    private int[] f26054n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i2, Object obj, long j2, long j3, long j4, long j5, long j6) {
        super(dataSource, dataSpec, format, i2, obj, j2, j3, j6);
        this.f26051k = j4;
        this.f26052l = j5;
    }

    public final int i(int i2) {
        return ((int[]) Assertions.i(this.f26054n))[i2];
    }

    /* access modifiers changed from: protected */
    public final BaseMediaChunkOutput j() {
        return (BaseMediaChunkOutput) Assertions.i(this.f26053m);
    }

    public void k(BaseMediaChunkOutput baseMediaChunkOutput) {
        this.f26053m = baseMediaChunkOutput;
        this.f26054n = baseMediaChunkOutput.a();
    }
}
