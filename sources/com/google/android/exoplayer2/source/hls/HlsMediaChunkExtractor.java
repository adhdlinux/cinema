package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import java.io.IOException;

public interface HlsMediaChunkExtractor {
    boolean a(ExtractorInput extractorInput) throws IOException;

    void b();

    void c(ExtractorOutput extractorOutput);

    boolean d();

    boolean h();

    HlsMediaChunkExtractor i();
}
