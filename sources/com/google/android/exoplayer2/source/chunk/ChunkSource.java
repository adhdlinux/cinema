package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import java.io.IOException;
import java.util.List;

public interface ChunkSource {
    void a() throws IOException;

    int c(long j2, List<? extends MediaChunk> list);

    boolean d(long j2, Chunk chunk, List<? extends MediaChunk> list);

    void f(Chunk chunk);

    long g(long j2, SeekParameters seekParameters);

    boolean h(Chunk chunk, boolean z2, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, LoadErrorHandlingPolicy loadErrorHandlingPolicy);

    void j(long j2, long j3, List<? extends MediaChunk> list, ChunkHolder chunkHolder);

    void release();
}
