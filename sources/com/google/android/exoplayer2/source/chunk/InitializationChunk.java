package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import java.io.IOException;

public final class InitializationChunk extends Chunk {

    /* renamed from: j  reason: collision with root package name */
    private final ChunkExtractor f26125j;

    /* renamed from: k  reason: collision with root package name */
    private ChunkExtractor.TrackOutputProvider f26126k;

    /* renamed from: l  reason: collision with root package name */
    private long f26127l;

    /* renamed from: m  reason: collision with root package name */
    private volatile boolean f26128m;

    public InitializationChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i2, Object obj, ChunkExtractor chunkExtractor) {
        super(dataSource, dataSpec, 2, format, i2, obj, -9223372036854775807L, -9223372036854775807L);
        this.f26125j = chunkExtractor;
    }

    public void a() throws IOException {
        DefaultExtractorInput defaultExtractorInput;
        if (this.f26127l == 0) {
            this.f26125j.e(this.f26126k, -9223372036854775807L, -9223372036854775807L);
        }
        try {
            DataSpec e2 = this.f26079b.e(this.f26127l);
            StatsDataSource statsDataSource = this.f26086i;
            defaultExtractorInput = new DefaultExtractorInput(statsDataSource, e2.f28345g, statsDataSource.i(e2));
            do {
                if (this.f26128m || !this.f26125j.a(defaultExtractorInput)) {
                    break;
                }
                break;
                break;
            } while (!this.f26125j.a(defaultExtractorInput));
            break;
            this.f26127l = defaultExtractorInput.getPosition() - this.f26079b.f28345g;
            DataSourceUtil.a(this.f26086i);
        } catch (Throwable th) {
            DataSourceUtil.a(this.f26086i);
            throw th;
        }
    }

    public void b() {
        this.f26128m = true;
    }

    public void g(ChunkExtractor.TrackOutputProvider trackOutputProvider) {
        this.f26126k = trackOutputProvider;
    }
}
