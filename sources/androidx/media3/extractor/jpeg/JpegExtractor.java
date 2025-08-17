package androidx.media3.extractor.jpeg;

import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SingleSampleExtractor;
import androidx.media3.extractor.d;
import java.io.IOException;
import java.util.List;

public final class JpegExtractor implements Extractor {

    /* renamed from: a  reason: collision with root package name */
    private final Extractor f8240a;

    public JpegExtractor() {
        this(0);
    }

    public void a(long j2, long j3) {
        this.f8240a.a(j2, j3);
    }

    public /* synthetic */ Extractor c() {
        return d.b(this);
    }

    public void g(ExtractorOutput extractorOutput) {
        this.f8240a.g(extractorOutput);
    }

    public boolean i(ExtractorInput extractorInput) throws IOException {
        return this.f8240a.i(extractorInput);
    }

    public /* synthetic */ List j() {
        return d.a(this);
    }

    public int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        return this.f8240a.k(extractorInput, positionHolder);
    }

    public void release() {
        this.f8240a.release();
    }

    public JpegExtractor(int i2) {
        if ((i2 & 1) != 0) {
            this.f8240a = new SingleSampleExtractor(65496, 2, "image/jpeg");
        } else {
            this.f8240a = new JpegMotionPhotoExtractor();
        }
    }
}
