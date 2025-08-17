package androidx.media3.extractor;

import java.io.IOException;
import java.util.List;
import org.checkerframework.dataflow.qual.SideEffectFree;

public interface Extractor {
    void a(long j2, long j3);

    @SideEffectFree
    Extractor c();

    void g(ExtractorOutput extractorOutput);

    boolean i(ExtractorInput extractorInput) throws IOException;

    List<SniffFailure> j();

    int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException;

    void release();
}
