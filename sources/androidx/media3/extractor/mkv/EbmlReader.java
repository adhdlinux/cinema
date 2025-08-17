package androidx.media3.extractor.mkv;

import androidx.media3.extractor.ExtractorInput;
import java.io.IOException;

interface EbmlReader {
    boolean a(ExtractorInput extractorInput) throws IOException;

    void b(EbmlProcessor ebmlProcessor);

    void reset();
}
