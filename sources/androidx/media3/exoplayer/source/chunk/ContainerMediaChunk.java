package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.TrackOutput;
import java.io.IOException;

public class ContainerMediaChunk extends BaseMediaChunk {

    /* renamed from: o  reason: collision with root package name */
    private final int f7256o;

    /* renamed from: p  reason: collision with root package name */
    private final long f7257p;

    /* renamed from: q  reason: collision with root package name */
    private final ChunkExtractor f7258q;

    /* renamed from: r  reason: collision with root package name */
    private long f7259r;

    /* renamed from: s  reason: collision with root package name */
    private volatile boolean f7260s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f7261t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContainerMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i2, Object obj, long j2, long j3, long j4, long j5, long j6, int i3, long j7, ChunkExtractor chunkExtractor) {
        super(dataSource, dataSpec, format, i2, obj, j2, j3, j4, j5, j6);
        this.f7256o = i3;
        this.f7257p = j7;
        this.f7258q = chunkExtractor;
    }

    private void m(BaseMediaChunkOutput baseMediaChunkOutput) {
        if (MimeTypes.p(this.f7220d.f4014m)) {
            Format format = this.f7220d;
            int i2 = format.I;
            if ((i2 > 1 || format.J > 1) && i2 != -1 && format.J != -1) {
                TrackOutput d2 = baseMediaChunkOutput.d(0, 4);
                Format format2 = this.f7220d;
                int i3 = format2.J * format2.I;
                long j2 = (this.f7224h - this.f7223g) / ((long) i3);
                for (int i4 = 1; i4 < i3; i4++) {
                    d2.b(new ParsableByteArray(), 0);
                    d2.f(((long) i4) * j2, 0, 0, 0, (TrackOutput.CryptoData) null);
                }
            }
        }
    }

    public final void a() throws IOException {
        DefaultExtractorInput defaultExtractorInput;
        long j2;
        long j3;
        BaseMediaChunkOutput j4 = j();
        if (this.f7259r == 0) {
            j4.b(this.f7257p);
            ChunkExtractor chunkExtractor = this.f7258q;
            ChunkExtractor.TrackOutputProvider l2 = l(j4);
            long j5 = this.f7188k;
            if (j5 == -9223372036854775807L) {
                j2 = -9223372036854775807L;
            } else {
                j2 = j5 - this.f7257p;
            }
            long j6 = this.f7189l;
            if (j6 == -9223372036854775807L) {
                j3 = -9223372036854775807L;
            } else {
                j3 = j6 - this.f7257p;
            }
            chunkExtractor.e(l2, j2, j3);
        }
        try {
            DataSpec e2 = this.f7218b.e(this.f7259r);
            StatsDataSource statsDataSource = this.f7225i;
            defaultExtractorInput = new DefaultExtractorInput(statsDataSource, e2.f4829g, statsDataSource.i(e2));
            while (!this.f7260s && this.f7258q.a(defaultExtractorInput)) {
            }
            m(j4);
            this.f7259r = defaultExtractorInput.getPosition() - this.f7218b.f4829g;
            DataSourceUtil.a(this.f7225i);
            this.f7261t = !this.f7260s;
        } catch (Throwable th) {
            DataSourceUtil.a(this.f7225i);
            throw th;
        }
    }

    public final void b() {
        this.f7260s = true;
    }

    public long g() {
        return this.f7268j + ((long) this.f7256o);
    }

    public boolean h() {
        return this.f7261t;
    }

    /* access modifiers changed from: protected */
    public ChunkExtractor.TrackOutputProvider l(BaseMediaChunkOutput baseMediaChunkOutput) {
        return baseMediaChunkOutput;
    }
}
