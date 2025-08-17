package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import java.util.List;

public final /* synthetic */ class a implements ChunkExtractor.Factory {
    public final ChunkExtractor a(int i2, Format format, boolean z2, List list, TrackOutput trackOutput, PlayerId playerId) {
        return BundledChunkExtractor.g(i2, format, z2, list, trackOutput, playerId);
    }
}
