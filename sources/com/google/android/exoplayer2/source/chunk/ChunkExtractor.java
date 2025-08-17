package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import java.io.IOException;
import java.util.List;

public interface ChunkExtractor {

    public interface Factory {
        ChunkExtractor a(int i2, Format format, boolean z2, List<Format> list, TrackOutput trackOutput, PlayerId playerId);
    }

    public interface TrackOutputProvider {
        TrackOutput d(int i2, int i3);
    }

    boolean a(ExtractorInput extractorInput) throws IOException;

    ChunkIndex b();

    Format[] c();

    void e(TrackOutputProvider trackOutputProvider, long j2, long j3);

    void release();
}
