package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;

public interface RtpPayloadReader {
    void a(long j2, long j3);

    void b(ParsableByteArray parsableByteArray, long j2, int i2, boolean z2) throws ParserException;

    void c(ExtractorOutput extractorOutput, int i2);

    void d(long j2, int i2);
}
