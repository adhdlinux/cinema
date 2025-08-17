package androidx.media3.extractor.jpeg;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.d;
import androidx.media3.extractor.metadata.mp4.MotionPhotoMetadata;
import androidx.media3.extractor.mp4.Mp4Extractor;
import androidx.media3.extractor.text.SubtitleParser;
import java.io.IOException;
import java.util.List;

final class JpegMotionPhotoExtractor implements Extractor {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f8241a = new ParsableByteArray(6);

    /* renamed from: b  reason: collision with root package name */
    private ExtractorOutput f8242b;

    /* renamed from: c  reason: collision with root package name */
    private int f8243c;

    /* renamed from: d  reason: collision with root package name */
    private int f8244d;

    /* renamed from: e  reason: collision with root package name */
    private int f8245e;

    /* renamed from: f  reason: collision with root package name */
    private long f8246f = -1;

    /* renamed from: g  reason: collision with root package name */
    private MotionPhotoMetadata f8247g;

    /* renamed from: h  reason: collision with root package name */
    private ExtractorInput f8248h;

    /* renamed from: i  reason: collision with root package name */
    private StartOffsetExtractorInput f8249i;

    /* renamed from: j  reason: collision with root package name */
    private Mp4Extractor f8250j;

    private void b(ExtractorInput extractorInput) throws IOException {
        this.f8241a.Q(2);
        extractorInput.m(this.f8241a.e(), 0, 2);
        extractorInput.h(this.f8241a.N() - 2);
    }

    private void d() {
        ((ExtractorOutput) Assertions.f(this.f8242b)).m();
        this.f8242b.r(new SeekMap.Unseekable(-9223372036854775807L));
        this.f8243c = 6;
    }

    private static MotionPhotoMetadata e(String str, long j2) throws IOException {
        MotionPhotoDescription a2;
        if (j2 == -1 || (a2 = XmpMotionPhotoDescriptionParser.a(str)) == null) {
            return null;
        }
        return a2.a(j2);
    }

    private void f(MotionPhotoMetadata motionPhotoMetadata) {
        ((ExtractorOutput) Assertions.f(this.f8242b)).d(1024, 4).c(new Format.Builder().Q("image/jpeg").h0(new Metadata(motionPhotoMetadata)).K());
    }

    private int h(ExtractorInput extractorInput) throws IOException {
        this.f8241a.Q(2);
        extractorInput.m(this.f8241a.e(), 0, 2);
        return this.f8241a.N();
    }

    private void l(ExtractorInput extractorInput) throws IOException {
        this.f8241a.Q(2);
        extractorInput.readFully(this.f8241a.e(), 0, 2);
        int N = this.f8241a.N();
        this.f8244d = N;
        if (N == 65498) {
            if (this.f8246f != -1) {
                this.f8243c = 4;
            } else {
                d();
            }
        } else if ((N < 65488 || N > 65497) && N != 65281) {
            this.f8243c = 1;
        }
    }

    private void m(ExtractorInput extractorInput) throws IOException {
        String B;
        if (this.f8244d == 65505) {
            ParsableByteArray parsableByteArray = new ParsableByteArray(this.f8245e);
            extractorInput.readFully(parsableByteArray.e(), 0, this.f8245e);
            if (this.f8247g == null && "http://ns.adobe.com/xap/1.0/".equals(parsableByteArray.B()) && (B = parsableByteArray.B()) != null) {
                MotionPhotoMetadata e2 = e(B, extractorInput.getLength());
                this.f8247g = e2;
                if (e2 != null) {
                    this.f8246f = e2.f8348e;
                }
            }
        } else {
            extractorInput.k(this.f8245e);
        }
        this.f8243c = 0;
    }

    private void n(ExtractorInput extractorInput) throws IOException {
        this.f8241a.Q(2);
        extractorInput.readFully(this.f8241a.e(), 0, 2);
        this.f8245e = this.f8241a.N() - 2;
        this.f8243c = 2;
    }

    private void o(ExtractorInput extractorInput) throws IOException {
        if (!extractorInput.c(this.f8241a.e(), 0, 1, true)) {
            d();
            return;
        }
        extractorInput.e();
        if (this.f8250j == null) {
            this.f8250j = new Mp4Extractor(SubtitleParser.Factory.f8798a, 8);
        }
        StartOffsetExtractorInput startOffsetExtractorInput = new StartOffsetExtractorInput(extractorInput, this.f8246f);
        this.f8249i = startOffsetExtractorInput;
        if (this.f8250j.i(startOffsetExtractorInput)) {
            this.f8250j.g(new StartOffsetExtractorOutput(this.f8246f, (ExtractorOutput) Assertions.f(this.f8242b)));
            p();
            return;
        }
        d();
    }

    private void p() {
        f((MotionPhotoMetadata) Assertions.f(this.f8247g));
        this.f8243c = 5;
    }

    public void a(long j2, long j3) {
        if (j2 == 0) {
            this.f8243c = 0;
            this.f8250j = null;
        } else if (this.f8243c == 5) {
            ((Mp4Extractor) Assertions.f(this.f8250j)).a(j2, j3);
        }
    }

    public /* synthetic */ Extractor c() {
        return d.b(this);
    }

    public void g(ExtractorOutput extractorOutput) {
        this.f8242b = extractorOutput;
    }

    public boolean i(ExtractorInput extractorInput) throws IOException {
        if (h(extractorInput) != 65496) {
            return false;
        }
        int h2 = h(extractorInput);
        this.f8244d = h2;
        if (h2 == 65504) {
            b(extractorInput);
            this.f8244d = h(extractorInput);
        }
        if (this.f8244d != 65505) {
            return false;
        }
        extractorInput.h(2);
        this.f8241a.Q(6);
        extractorInput.m(this.f8241a.e(), 0, 6);
        if (this.f8241a.J() == 1165519206 && this.f8241a.N() == 0) {
            return true;
        }
        return false;
    }

    public /* synthetic */ List j() {
        return d.a(this);
    }

    public int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i2 = this.f8243c;
        if (i2 == 0) {
            l(extractorInput);
            return 0;
        } else if (i2 == 1) {
            n(extractorInput);
            return 0;
        } else if (i2 == 2) {
            m(extractorInput);
            return 0;
        } else if (i2 == 4) {
            long position = extractorInput.getPosition();
            long j2 = this.f8246f;
            if (position != j2) {
                positionHolder.f8069a = j2;
                return 1;
            }
            o(extractorInput);
            return 0;
        } else if (i2 == 5) {
            if (this.f8249i == null || extractorInput != this.f8248h) {
                this.f8248h = extractorInput;
                this.f8249i = new StartOffsetExtractorInput(extractorInput, this.f8246f);
            }
            int k2 = ((Mp4Extractor) Assertions.f(this.f8250j)).k(this.f8249i, positionHolder);
            if (k2 == 1) {
                positionHolder.f8069a += this.f8246f;
            }
            return k2;
        } else if (i2 == 6) {
            return -1;
        } else {
            throw new IllegalStateException();
        }
    }

    public void release() {
        Mp4Extractor mp4Extractor = this.f8250j;
        if (mp4Extractor != null) {
            mp4Extractor.release();
        }
    }
}
