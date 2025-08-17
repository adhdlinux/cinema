package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;

interface EbmlReader {
    boolean a(ExtractorInput extractorInput) throws IOException;

    void b(EbmlProcessor ebmlProcessor);

    void reset();
}
