package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface HlsExtractorFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final HlsExtractorFactory f26424a = new DefaultHlsExtractorFactory();

    HlsMediaChunkExtractor a(Uri uri, Format format, List<Format> list, TimestampAdjuster timestampAdjuster, Map<String, List<String>> map, ExtractorInput extractorInput, PlayerId playerId) throws IOException;
}
