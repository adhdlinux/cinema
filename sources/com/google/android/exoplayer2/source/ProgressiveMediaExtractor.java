package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.upstream.DataReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ProgressiveMediaExtractor {

    public interface Factory {
        ProgressiveMediaExtractor a(PlayerId playerId);
    }

    void a(long j2, long j3);

    void b();

    long c();

    int d(PositionHolder positionHolder) throws IOException;

    void e(DataReader dataReader, Uri uri, Map<String, List<String>> map, long j2, long j3, ExtractorOutput extractorOutput) throws IOException;

    void release();
}
