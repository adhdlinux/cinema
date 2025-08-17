package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.DataReader;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
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

    void d(DataReader dataReader, Uri uri, Map<String, List<String>> map, long j2, long j3, ExtractorOutput extractorOutput) throws IOException;

    int e(PositionHolder positionHolder) throws IOException;

    void release();
}
