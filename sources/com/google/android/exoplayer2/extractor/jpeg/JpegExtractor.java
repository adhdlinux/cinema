package com.google.android.exoplayer2.extractor.jpeg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

public final class JpegExtractor implements Extractor {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f24391a = new ParsableByteArray(6);

    /* renamed from: b  reason: collision with root package name */
    private ExtractorOutput f24392b;

    /* renamed from: c  reason: collision with root package name */
    private int f24393c;

    /* renamed from: d  reason: collision with root package name */
    private int f24394d;

    /* renamed from: e  reason: collision with root package name */
    private int f24395e;

    /* renamed from: f  reason: collision with root package name */
    private long f24396f = -1;

    /* renamed from: g  reason: collision with root package name */
    private MotionPhotoMetadata f24397g;

    /* renamed from: h  reason: collision with root package name */
    private ExtractorInput f24398h;

    /* renamed from: i  reason: collision with root package name */
    private StartOffsetExtractorInput f24399i;

    /* renamed from: j  reason: collision with root package name */
    private Mp4Extractor f24400j;

    private void b(ExtractorInput extractorInput) throws IOException {
        this.f24391a.Q(2);
        extractorInput.m(this.f24391a.e(), 0, 2);
        extractorInput.h(this.f24391a.N() - 2);
    }

    private void d() {
        f(new Metadata.Entry[0]);
        ((ExtractorOutput) Assertions.e(this.f24392b)).m();
        this.f24392b.u(new SeekMap.Unseekable(-9223372036854775807L));
        this.f24393c = 6;
    }

    private static MotionPhotoMetadata e(String str, long j2) throws IOException {
        MotionPhotoDescription a2;
        if (j2 == -1 || (a2 = XmpMotionPhotoDescriptionParser.a(str)) == null) {
            return null;
        }
        return a2.a(j2);
    }

    private void f(Metadata.Entry... entryArr) {
        ((ExtractorOutput) Assertions.e(this.f24392b)).d(1024, 4).d(new Format.Builder().M("image/jpeg").Z(new Metadata(entryArr)).G());
    }

    private int h(ExtractorInput extractorInput) throws IOException {
        this.f24391a.Q(2);
        extractorInput.m(this.f24391a.e(), 0, 2);
        return this.f24391a.N();
    }

    private void j(ExtractorInput extractorInput) throws IOException {
        this.f24391a.Q(2);
        extractorInput.readFully(this.f24391a.e(), 0, 2);
        int N = this.f24391a.N();
        this.f24394d = N;
        if (N == 65498) {
            if (this.f24396f != -1) {
                this.f24393c = 4;
            } else {
                d();
            }
        } else if ((N < 65488 || N > 65497) && N != 65281) {
            this.f24393c = 1;
        }
    }

    private void k(ExtractorInput extractorInput) throws IOException {
        String B;
        if (this.f24394d == 65505) {
            ParsableByteArray parsableByteArray = new ParsableByteArray(this.f24395e);
            extractorInput.readFully(parsableByteArray.e(), 0, this.f24395e);
            if (this.f24397g == null && "http://ns.adobe.com/xap/1.0/".equals(parsableByteArray.B()) && (B = parsableByteArray.B()) != null) {
                MotionPhotoMetadata e2 = e(B, extractorInput.getLength());
                this.f24397g = e2;
                if (e2 != null) {
                    this.f24396f = e2.f25451e;
                }
            }
        } else {
            extractorInput.k(this.f24395e);
        }
        this.f24393c = 0;
    }

    private void l(ExtractorInput extractorInput) throws IOException {
        this.f24391a.Q(2);
        extractorInput.readFully(this.f24391a.e(), 0, 2);
        this.f24395e = this.f24391a.N() - 2;
        this.f24393c = 2;
    }

    private void m(ExtractorInput extractorInput) throws IOException {
        if (!extractorInput.c(this.f24391a.e(), 0, 1, true)) {
            d();
            return;
        }
        extractorInput.e();
        if (this.f24400j == null) {
            this.f24400j = new Mp4Extractor();
        }
        StartOffsetExtractorInput startOffsetExtractorInput = new StartOffsetExtractorInput(extractorInput, this.f24396f);
        this.f24399i = startOffsetExtractorInput;
        if (this.f24400j.g(startOffsetExtractorInput)) {
            this.f24400j.c(new StartOffsetExtractorOutput(this.f24396f, (ExtractorOutput) Assertions.e(this.f24392b)));
            n();
            return;
        }
        d();
    }

    private void n() {
        f((Metadata.Entry) Assertions.e(this.f24397g));
        this.f24393c = 5;
    }

    public void a(long j2, long j3) {
        if (j2 == 0) {
            this.f24393c = 0;
            this.f24400j = null;
        } else if (this.f24393c == 5) {
            ((Mp4Extractor) Assertions.e(this.f24400j)).a(j2, j3);
        }
    }

    public void c(ExtractorOutput extractorOutput) {
        this.f24392b = extractorOutput;
    }

    public boolean g(ExtractorInput extractorInput) throws IOException {
        if (h(extractorInput) != 65496) {
            return false;
        }
        int h2 = h(extractorInput);
        this.f24394d = h2;
        if (h2 == 65504) {
            b(extractorInput);
            this.f24394d = h(extractorInput);
        }
        if (this.f24394d != 65505) {
            return false;
        }
        extractorInput.h(2);
        this.f24391a.Q(6);
        extractorInput.m(this.f24391a.e(), 0, 6);
        if (this.f24391a.J() == 1165519206 && this.f24391a.N() == 0) {
            return true;
        }
        return false;
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i2 = this.f24393c;
        if (i2 == 0) {
            j(extractorInput);
            return 0;
        } else if (i2 == 1) {
            l(extractorInput);
            return 0;
        } else if (i2 == 2) {
            k(extractorInput);
            return 0;
        } else if (i2 == 4) {
            long position = extractorInput.getPosition();
            long j2 = this.f24396f;
            if (position != j2) {
                positionHolder.f24231a = j2;
                return 1;
            }
            m(extractorInput);
            return 0;
        } else if (i2 == 5) {
            if (this.f24399i == null || extractorInput != this.f24398h) {
                this.f24398h = extractorInput;
                this.f24399i = new StartOffsetExtractorInput(extractorInput, this.f24396f);
            }
            int i3 = ((Mp4Extractor) Assertions.e(this.f24400j)).i(this.f24399i, positionHolder);
            if (i3 == 1) {
                positionHolder.f24231a += this.f24396f;
            }
            return i3;
        } else if (i2 == 6) {
            return -1;
        } else {
            throw new IllegalStateException();
        }
    }

    public void release() {
        Mp4Extractor mp4Extractor = this.f24400j;
        if (mp4Extractor != null) {
            mp4Extractor.release();
        }
    }
}
