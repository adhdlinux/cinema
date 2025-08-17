package androidx.media3.extractor.webp;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SingleSampleExtractor;
import androidx.media3.extractor.d;
import java.io.IOException;
import java.util.List;

public final class WebpExtractor implements Extractor {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f9599a = new ParsableByteArray(4);

    /* renamed from: b  reason: collision with root package name */
    private final SingleSampleExtractor f9600b = new SingleSampleExtractor(-1, -1, "image/webp");

    public void a(long j2, long j3) {
        this.f9600b.a(j2, j3);
    }

    public /* synthetic */ Extractor c() {
        return d.b(this);
    }

    public void g(ExtractorOutput extractorOutput) {
        this.f9600b.g(extractorOutput);
    }

    public boolean i(ExtractorInput extractorInput) throws IOException {
        this.f9599a.Q(4);
        extractorInput.m(this.f9599a.e(), 0, 4);
        if (this.f9599a.J() != 1380533830) {
            return false;
        }
        extractorInput.h(4);
        this.f9599a.Q(4);
        extractorInput.m(this.f9599a.e(), 0, 4);
        if (this.f9599a.J() == 1464156752) {
            return true;
        }
        return false;
    }

    public /* synthetic */ List j() {
        return d.a(this);
    }

    public int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        return this.f9600b.k(extractorInput, positionHolder);
    }

    public void release() {
    }
}
