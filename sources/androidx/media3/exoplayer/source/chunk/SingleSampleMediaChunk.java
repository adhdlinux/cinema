package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.Format;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.TrackOutput;
import java.io.IOException;

public final class SingleSampleMediaChunk extends BaseMediaChunk {

    /* renamed from: o  reason: collision with root package name */
    private final int f7270o;

    /* renamed from: p  reason: collision with root package name */
    private final Format f7271p;

    /* renamed from: q  reason: collision with root package name */
    private long f7272q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f7273r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleSampleMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i2, Object obj, long j2, long j3, long j4, int i3, Format format2) {
        super(dataSource, dataSpec, format, i2, obj, j2, j3, -9223372036854775807L, -9223372036854775807L, j4);
        this.f7270o = i3;
        this.f7271p = format2;
    }

    /* JADX INFO: finally extract failed */
    public void a() throws IOException {
        BaseMediaChunkOutput j2 = j();
        j2.b(0);
        TrackOutput d2 = j2.d(0, this.f7270o);
        d2.c(this.f7271p);
        try {
            long i2 = this.f7225i.i(this.f7218b.e(this.f7272q));
            if (i2 != -1) {
                i2 += this.f7272q;
            }
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(this.f7225i, this.f7272q, i2);
            for (int i3 = 0; i3 != -1; i3 = d2.d(defaultExtractorInput, Integer.MAX_VALUE, true)) {
                this.f7272q += (long) i3;
            }
            d2.f(this.f7223g, 1, (int) this.f7272q, 0, (TrackOutput.CryptoData) null);
            DataSourceUtil.a(this.f7225i);
            this.f7273r = true;
        } catch (Throwable th) {
            DataSourceUtil.a(this.f7225i);
            throw th;
        }
    }

    public void b() {
    }

    public boolean h() {
        return this.f7273r;
    }
}
