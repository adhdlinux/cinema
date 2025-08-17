package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.Format;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.extractor.DefaultExtractorInput;
import java.io.IOException;

public final class InitializationChunk extends Chunk {

    /* renamed from: j  reason: collision with root package name */
    private final ChunkExtractor f7264j;

    /* renamed from: k  reason: collision with root package name */
    private ChunkExtractor.TrackOutputProvider f7265k;

    /* renamed from: l  reason: collision with root package name */
    private long f7266l;

    /* renamed from: m  reason: collision with root package name */
    private volatile boolean f7267m;

    public InitializationChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i2, Object obj, ChunkExtractor chunkExtractor) {
        super(dataSource, dataSpec, 2, format, i2, obj, -9223372036854775807L, -9223372036854775807L);
        this.f7264j = chunkExtractor;
    }

    public void a() throws IOException {
        DefaultExtractorInput defaultExtractorInput;
        if (this.f7266l == 0) {
            this.f7264j.e(this.f7265k, -9223372036854775807L, -9223372036854775807L);
        }
        try {
            DataSpec e2 = this.f7218b.e(this.f7266l);
            StatsDataSource statsDataSource = this.f7225i;
            defaultExtractorInput = new DefaultExtractorInput(statsDataSource, e2.f4829g, statsDataSource.i(e2));
            do {
                if (this.f7267m || !this.f7264j.a(defaultExtractorInput)) {
                    break;
                }
                break;
                break;
            } while (!this.f7264j.a(defaultExtractorInput));
            break;
            this.f7266l = defaultExtractorInput.getPosition() - this.f7218b.f4829g;
            DataSourceUtil.a(this.f7225i);
        } catch (Throwable th) {
            DataSourceUtil.a(this.f7225i);
            throw th;
        }
    }

    public void b() {
        this.f7267m = true;
    }

    public void g(ChunkExtractor.TrackOutputProvider trackOutputProvider) {
        this.f7265k = trackOutputProvider;
    }
}
