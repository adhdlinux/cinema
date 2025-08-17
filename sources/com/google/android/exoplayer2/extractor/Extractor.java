package com.google.android.exoplayer2.extractor;

import java.io.IOException;

public interface Extractor {
    void a(long j2, long j3);

    void c(ExtractorOutput extractorOutput);

    boolean g(ExtractorInput extractorInput) throws IOException;

    int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException;

    void release();
}
