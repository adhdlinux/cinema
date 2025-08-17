package androidx.media3.extractor.avif;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SingleSampleExtractor;
import androidx.media3.extractor.d;
import java.io.IOException;
import java.util.List;

public final class AvifExtractor implements Extractor {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f8186a = new ParsableByteArray(4);

    /* renamed from: b  reason: collision with root package name */
    private final SingleSampleExtractor f8187b = new SingleSampleExtractor(-1, -1, "image/avif");

    private boolean b(ExtractorInput extractorInput, int i2) throws IOException {
        this.f8186a.Q(4);
        extractorInput.m(this.f8186a.e(), 0, 4);
        if (this.f8186a.J() == ((long) i2)) {
            return true;
        }
        return false;
    }

    public void a(long j2, long j3) {
        this.f8187b.a(j2, j3);
    }

    public /* synthetic */ Extractor c() {
        return d.b(this);
    }

    public void g(ExtractorOutput extractorOutput) {
        this.f8187b.g(extractorOutput);
    }

    public boolean i(ExtractorInput extractorInput) throws IOException {
        extractorInput.h(4);
        if (!b(extractorInput, 1718909296) || !b(extractorInput, 1635150182)) {
            return false;
        }
        return true;
    }

    public /* synthetic */ List j() {
        return d.a(this);
    }

    public int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        return this.f8187b.k(extractorInput, positionHolder);
    }

    public void release() {
    }
}
