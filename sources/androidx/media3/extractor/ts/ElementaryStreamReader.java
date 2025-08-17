package androidx.media3.extractor.ts;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ts.TsPayloadReader;

public interface ElementaryStreamReader {
    void a();

    void b(ParsableByteArray parsableByteArray) throws ParserException;

    void d(long j2, int i2);

    void e(boolean z2);

    void f(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator);
}
