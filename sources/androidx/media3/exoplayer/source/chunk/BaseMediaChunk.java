package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;

public abstract class BaseMediaChunk extends MediaChunk {

    /* renamed from: k  reason: collision with root package name */
    public final long f7188k;

    /* renamed from: l  reason: collision with root package name */
    public final long f7189l;

    /* renamed from: m  reason: collision with root package name */
    private BaseMediaChunkOutput f7190m;

    /* renamed from: n  reason: collision with root package name */
    private int[] f7191n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i2, Object obj, long j2, long j3, long j4, long j5, long j6) {
        super(dataSource, dataSpec, format, i2, obj, j2, j3, j6);
        this.f7188k = j4;
        this.f7189l = j5;
    }

    public final int i(int i2) {
        return ((int[]) Assertions.j(this.f7191n))[i2];
    }

    /* access modifiers changed from: protected */
    public final BaseMediaChunkOutput j() {
        return (BaseMediaChunkOutput) Assertions.j(this.f7190m);
    }

    public void k(BaseMediaChunkOutput baseMediaChunkOutput) {
        this.f7190m = baseMediaChunkOutput;
        this.f7191n = baseMediaChunkOutput.a();
    }
}
