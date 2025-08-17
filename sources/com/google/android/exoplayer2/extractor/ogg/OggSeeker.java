package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import java.io.IOException;

interface OggSeeker {
    long a(ExtractorInput extractorInput) throws IOException;

    SeekMap b();

    void c(long j2);
}
