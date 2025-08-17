package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import java.io.IOException;

public class ContainerMediaChunk extends BaseMediaChunk {

    /* renamed from: o  reason: collision with root package name */
    private final int f26117o;

    /* renamed from: p  reason: collision with root package name */
    private final long f26118p;

    /* renamed from: q  reason: collision with root package name */
    private final ChunkExtractor f26119q;

    /* renamed from: r  reason: collision with root package name */
    private long f26120r;

    /* renamed from: s  reason: collision with root package name */
    private volatile boolean f26121s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f26122t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContainerMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i2, Object obj, long j2, long j3, long j4, long j5, long j6, int i3, long j7, ChunkExtractor chunkExtractor) {
        super(dataSource, dataSpec, format, i2, obj, j2, j3, j4, j5, j6);
        this.f26117o = i3;
        this.f26118p = j7;
        this.f26119q = chunkExtractor;
    }

    public final void a() throws IOException {
        DefaultExtractorInput defaultExtractorInput;
        long j2;
        long j3;
        if (this.f26120r == 0) {
            BaseMediaChunkOutput j4 = j();
            j4.b(this.f26118p);
            ChunkExtractor chunkExtractor = this.f26119q;
            ChunkExtractor.TrackOutputProvider l2 = l(j4);
            long j5 = this.f26051k;
            if (j5 == -9223372036854775807L) {
                j2 = -9223372036854775807L;
            } else {
                j2 = j5 - this.f26118p;
            }
            long j6 = this.f26052l;
            if (j6 == -9223372036854775807L) {
                j3 = -9223372036854775807L;
            } else {
                j3 = j6 - this.f26118p;
            }
            chunkExtractor.e(l2, j2, j3);
        }
        try {
            DataSpec e2 = this.f26079b.e(this.f26120r);
            StatsDataSource statsDataSource = this.f26086i;
            defaultExtractorInput = new DefaultExtractorInput(statsDataSource, e2.f28345g, statsDataSource.i(e2));
            do {
                if (this.f26121s || !this.f26119q.a(defaultExtractorInput)) {
                    break;
                }
                break;
                break;
            } while (!this.f26119q.a(defaultExtractorInput));
            break;
            this.f26120r = defaultExtractorInput.getPosition() - this.f26079b.f28345g;
            DataSourceUtil.a(this.f26086i);
            this.f26122t = !this.f26121s;
        } catch (Throwable th) {
            DataSourceUtil.a(this.f26086i);
            throw th;
        }
    }

    public final void b() {
        this.f26121s = true;
    }

    public long g() {
        return this.f26129j + ((long) this.f26117o);
    }

    public boolean h() {
        return this.f26122t;
    }

    /* access modifiers changed from: protected */
    public ChunkExtractor.TrackOutputProvider l(BaseMediaChunkOutput baseMediaChunkOutput) {
        return baseMediaChunkOutput;
    }
}
