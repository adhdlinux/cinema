package androidx.media3.exoplayer.source.chunk;

import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import java.io.IOException;
import java.util.List;

public interface ChunkSource {
    void a() throws IOException;

    int c(long j2, List<? extends MediaChunk> list);

    boolean d(Chunk chunk, boolean z2, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, LoadErrorHandlingPolicy loadErrorHandlingPolicy);

    boolean e(long j2, Chunk chunk, List<? extends MediaChunk> list);

    void f(Chunk chunk);

    void g(LoadingInfo loadingInfo, long j2, List<? extends MediaChunk> list, ChunkHolder chunkHolder);

    long h(long j2, SeekParameters seekParameters);

    void release();
}
