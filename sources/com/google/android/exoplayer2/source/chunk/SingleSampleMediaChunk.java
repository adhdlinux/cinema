package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.io.IOException;

public final class SingleSampleMediaChunk extends BaseMediaChunk {

    /* renamed from: o  reason: collision with root package name */
    private final int f26131o;

    /* renamed from: p  reason: collision with root package name */
    private final Format f26132p;

    /* renamed from: q  reason: collision with root package name */
    private long f26133q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f26134r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleSampleMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i2, Object obj, long j2, long j3, long j4, int i3, Format format2) {
        super(dataSource, dataSpec, format, i2, obj, j2, j3, -9223372036854775807L, -9223372036854775807L, j4);
        this.f26131o = i3;
        this.f26132p = format2;
    }

    /* JADX INFO: finally extract failed */
    public void a() throws IOException {
        BaseMediaChunkOutput j2 = j();
        j2.b(0);
        TrackOutput d2 = j2.d(0, this.f26131o);
        d2.d(this.f26132p);
        try {
            long i2 = this.f26086i.i(this.f26079b.e(this.f26133q));
            if (i2 != -1) {
                i2 += this.f26133q;
            }
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(this.f26086i, this.f26133q, i2);
            for (int i3 = 0; i3 != -1; i3 = d2.b(defaultExtractorInput, Integer.MAX_VALUE, true)) {
                this.f26133q += (long) i3;
            }
            d2.e(this.f26084g, 1, (int) this.f26133q, 0, (TrackOutput.CryptoData) null);
            DataSourceUtil.a(this.f26086i);
            this.f26134r = true;
        } catch (Throwable th) {
            DataSourceUtil.a(this.f26086i);
            throw th;
        }
    }

    public void b() {
    }

    public boolean h() {
        return this.f26134r;
    }
}
