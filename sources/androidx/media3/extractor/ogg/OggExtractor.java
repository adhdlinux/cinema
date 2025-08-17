package androidx.media3.extractor.ogg;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.d;
import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

public class OggExtractor implements Extractor {

    /* renamed from: d  reason: collision with root package name */
    public static final ExtractorsFactory f8724d = new a();

    /* renamed from: a  reason: collision with root package name */
    private ExtractorOutput f8725a;

    /* renamed from: b  reason: collision with root package name */
    private StreamReader f8726b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8727c;

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] d() {
        return new Extractor[]{new OggExtractor()};
    }

    private static ParsableByteArray e(ParsableByteArray parsableByteArray) {
        parsableByteArray.U(0);
        return parsableByteArray;
    }

    @EnsuresNonNullIf(expression = {"streamReader"}, result = true)
    private boolean f(ExtractorInput extractorInput) throws IOException {
        OggPageHeader oggPageHeader = new OggPageHeader();
        if (oggPageHeader.a(extractorInput, true) && (oggPageHeader.f8734b & 2) == 2) {
            int min = Math.min(oggPageHeader.f8741i, 8);
            ParsableByteArray parsableByteArray = new ParsableByteArray(min);
            extractorInput.m(parsableByteArray.e(), 0, min);
            if (FlacReader.p(e(parsableByteArray))) {
                this.f8726b = new FlacReader();
            } else if (VorbisReader.r(e(parsableByteArray))) {
                this.f8726b = new VorbisReader();
            } else if (OpusReader.o(e(parsableByteArray))) {
                this.f8726b = new OpusReader();
            }
            return true;
        }
        return false;
    }

    public void a(long j2, long j3) {
        StreamReader streamReader = this.f8726b;
        if (streamReader != null) {
            streamReader.m(j2, j3);
        }
    }

    public /* synthetic */ Extractor c() {
        return d.b(this);
    }

    public void g(ExtractorOutput extractorOutput) {
        this.f8725a = extractorOutput;
    }

    public boolean i(ExtractorInput extractorInput) throws IOException {
        try {
            return f(extractorInput);
        } catch (ParserException unused) {
            return false;
        }
    }

    public /* synthetic */ List j() {
        return d.a(this);
    }

    public int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        Assertions.j(this.f8725a);
        if (this.f8726b == null) {
            if (f(extractorInput)) {
                extractorInput.e();
            } else {
                throw ParserException.a("Failed to determine bitstream type", (Throwable) null);
            }
        }
        if (!this.f8727c) {
            TrackOutput d2 = this.f8725a.d(0, 1);
            this.f8725a.m();
            this.f8726b.d(this.f8725a, d2);
            this.f8727c = true;
        }
        return this.f8726b.g(extractorInput, positionHolder);
    }

    public void release() {
    }
}
