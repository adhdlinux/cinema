package androidx.media3.extractor.bmp;

import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SingleSampleExtractor;
import androidx.media3.extractor.d;
import java.io.IOException;
import java.util.List;

public final class BmpExtractor implements Extractor {

    /* renamed from: a  reason: collision with root package name */
    private final SingleSampleExtractor f8188a = new SingleSampleExtractor(16973, 2, "image/bmp");

    public void a(long j2, long j3) {
        this.f8188a.a(j2, j3);
    }

    public /* synthetic */ Extractor c() {
        return d.b(this);
    }

    public void g(ExtractorOutput extractorOutput) {
        this.f8188a.g(extractorOutput);
    }

    public boolean i(ExtractorInput extractorInput) throws IOException {
        return this.f8188a.i(extractorInput);
    }

    public /* synthetic */ List j() {
        return d.a(this);
    }

    public int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        return this.f8188a.k(extractorInput, positionHolder);
    }

    public void release() {
    }
}
