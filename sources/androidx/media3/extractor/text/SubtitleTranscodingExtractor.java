package androidx.media3.extractor.text;

import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.d;
import androidx.media3.extractor.text.SubtitleParser;
import java.io.IOException;
import java.util.List;

public class SubtitleTranscodingExtractor implements Extractor {

    /* renamed from: a  reason: collision with root package name */
    private final Extractor f8802a;

    /* renamed from: b  reason: collision with root package name */
    private final SubtitleParser.Factory f8803b;

    /* renamed from: c  reason: collision with root package name */
    private SubtitleTranscodingExtractorOutput f8804c;

    public SubtitleTranscodingExtractor(Extractor extractor, SubtitleParser.Factory factory) {
        this.f8802a = extractor;
        this.f8803b = factory;
    }

    public void a(long j2, long j3) {
        SubtitleTranscodingExtractorOutput subtitleTranscodingExtractorOutput = this.f8804c;
        if (subtitleTranscodingExtractorOutput != null) {
            subtitleTranscodingExtractorOutput.a();
        }
        this.f8802a.a(j2, j3);
    }

    public Extractor c() {
        return this.f8802a;
    }

    public void g(ExtractorOutput extractorOutput) {
        SubtitleTranscodingExtractorOutput subtitleTranscodingExtractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.f8803b);
        this.f8804c = subtitleTranscodingExtractorOutput;
        this.f8802a.g(subtitleTranscodingExtractorOutput);
    }

    public boolean i(ExtractorInput extractorInput) throws IOException {
        return this.f8802a.i(extractorInput);
    }

    public /* synthetic */ List j() {
        return d.a(this);
    }

    public int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        return this.f8802a.k(extractorInput, positionHolder);
    }

    public void release() {
        this.f8802a.release();
    }
}
