package androidx.media3.extractor.ogg;

import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.SeekMap;
import java.io.IOException;

interface OggSeeker {
    long a(ExtractorInput extractorInput) throws IOException;

    SeekMap b();

    void c(long j2);
}
