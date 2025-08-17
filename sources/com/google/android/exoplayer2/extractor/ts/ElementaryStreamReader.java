package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.ParsableByteArray;

public interface ElementaryStreamReader {
    void a();

    void c(ParsableByteArray parsableByteArray) throws ParserException;

    void d(long j2, int i2);

    void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator);

    void f();
}
