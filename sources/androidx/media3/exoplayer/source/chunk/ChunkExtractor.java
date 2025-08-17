package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.Format;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.SubtitleParser;
import java.io.IOException;
import java.util.List;

public interface ChunkExtractor {

    public interface Factory {
        Factory a(SubtitleParser.Factory factory);

        Factory b(boolean z2);

        Format c(Format format);

        ChunkExtractor d(int i2, Format format, boolean z2, List<Format> list, TrackOutput trackOutput, PlayerId playerId);
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
