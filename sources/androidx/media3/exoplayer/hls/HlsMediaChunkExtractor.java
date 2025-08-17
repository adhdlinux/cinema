package androidx.media3.exoplayer.hls;

import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import java.io.IOException;

public interface HlsMediaChunkExtractor {
    boolean a(ExtractorInput extractorInput) throws IOException;

    void b();

    boolean d();

    void g(ExtractorOutput extractorOutput);

    boolean h();

    HlsMediaChunkExtractor i();
}
