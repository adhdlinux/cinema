package androidx.media3.exoplayer.hls;

import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.text.SubtitleParser;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface HlsExtractorFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final HlsExtractorFactory f6335a = new DefaultHlsExtractorFactory();

    HlsExtractorFactory a(SubtitleParser.Factory factory);

    HlsExtractorFactory b(boolean z2);

    Format c(Format format);

    HlsMediaChunkExtractor d(Uri uri, Format format, List<Format> list, TimestampAdjuster timestampAdjuster, Map<String, List<String>> map, ExtractorInput extractorInput, PlayerId playerId) throws IOException;
}
