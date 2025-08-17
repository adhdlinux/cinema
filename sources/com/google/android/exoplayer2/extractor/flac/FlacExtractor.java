package com.google.android.exoplayer2.extractor.flac;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.FlacFrameReader;
import com.google.android.exoplayer2.extractor.FlacMetadataReader;
import com.google.android.exoplayer2.extractor.FlacSeekTableSeekMap;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import j0.b;
import java.io.IOException;

public final class FlacExtractor implements Extractor {

    /* renamed from: o  reason: collision with root package name */
    public static final ExtractorsFactory f24345o = new b();

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f24346a;

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f24347b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f24348c;

    /* renamed from: d  reason: collision with root package name */
    private final FlacFrameReader.SampleNumberHolder f24349d;

    /* renamed from: e  reason: collision with root package name */
    private ExtractorOutput f24350e;

    /* renamed from: f  reason: collision with root package name */
    private TrackOutput f24351f;

    /* renamed from: g  reason: collision with root package name */
    private int f24352g;

    /* renamed from: h  reason: collision with root package name */
    private Metadata f24353h;

    /* renamed from: i  reason: collision with root package name */
    private FlacStreamMetadata f24354i;

    /* renamed from: j  reason: collision with root package name */
    private int f24355j;

    /* renamed from: k  reason: collision with root package name */
    private int f24356k;

    /* renamed from: l  reason: collision with root package name */
    private FlacBinarySearchSeeker f24357l;

    /* renamed from: m  reason: collision with root package name */
    private int f24358m;

    /* renamed from: n  reason: collision with root package name */
    private long f24359n;

    public FlacExtractor() {
        this(0);
    }

    private long d(ParsableByteArray parsableByteArray, boolean z2) {
        boolean z3;
        Assertions.e(this.f24354i);
        int f2 = parsableByteArray.f();
        while (f2 <= parsableByteArray.g() - 16) {
            parsableByteArray.U(f2);
            if (FlacFrameReader.d(parsableByteArray, this.f24354i, this.f24356k, this.f24349d)) {
                parsableByteArray.U(f2);
                return this.f24349d.f24204a;
            }
            f2++;
        }
        if (z2) {
            while (f2 <= parsableByteArray.g() - this.f24355j) {
                parsableByteArray.U(f2);
                boolean z4 = false;
                try {
                    z3 = FlacFrameReader.d(parsableByteArray, this.f24354i, this.f24356k, this.f24349d);
                } catch (IndexOutOfBoundsException unused) {
                    z3 = false;
                }
                if (parsableByteArray.f() <= parsableByteArray.g()) {
                    z4 = z3;
                }
                if (z4) {
                    parsableByteArray.U(f2);
                    return this.f24349d.f24204a;
                }
                f2++;
            }
            parsableByteArray.U(parsableByteArray.g());
            return -1;
        }
        parsableByteArray.U(f2);
        return -1;
    }

    private void e(ExtractorInput extractorInput) throws IOException {
        this.f24356k = FlacMetadataReader.b(extractorInput);
        ((ExtractorOutput) Util.j(this.f24350e)).u(f(extractorInput.getPosition(), extractorInput.getLength()));
        this.f24352g = 5;
    }

    private SeekMap f(long j2, long j3) {
        Assertions.e(this.f24354i);
        FlacStreamMetadata flacStreamMetadata = this.f24354i;
        if (flacStreamMetadata.f24218k != null) {
            return new FlacSeekTableSeekMap(flacStreamMetadata, j2);
        }
        if (j3 == -1 || flacStreamMetadata.f24217j <= 0) {
            return new SeekMap.Unseekable(flacStreamMetadata.f());
        }
        FlacBinarySearchSeeker flacBinarySearchSeeker = new FlacBinarySearchSeeker(flacStreamMetadata, this.f24356k, j2, j3);
        this.f24357l = flacBinarySearchSeeker;
        return flacBinarySearchSeeker.b();
    }

    private void h(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = this.f24346a;
        extractorInput.m(bArr, 0, bArr.length);
        extractorInput.e();
        this.f24352g = 2;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] j() {
        return new Extractor[]{new FlacExtractor()};
    }

    private void k() {
        ((TrackOutput) Util.j(this.f24351f)).e((this.f24359n * 1000000) / ((long) ((FlacStreamMetadata) Util.j(this.f24354i)).f24212e), 1, this.f24358m, 0, (TrackOutput.CryptoData) null);
    }

    private int l(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        boolean z2;
        Assertions.e(this.f24351f);
        Assertions.e(this.f24354i);
        FlacBinarySearchSeeker flacBinarySearchSeeker = this.f24357l;
        if (flacBinarySearchSeeker != null && flacBinarySearchSeeker.d()) {
            return this.f24357l.c(extractorInput, positionHolder);
        }
        if (this.f24359n == -1) {
            this.f24359n = FlacFrameReader.i(extractorInput, this.f24354i);
            return 0;
        }
        int g2 = this.f24347b.g();
        if (g2 < 32768) {
            int read = extractorInput.read(this.f24347b.e(), g2, 32768 - g2);
            if (read == -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                this.f24347b.T(g2 + read);
            } else if (this.f24347b.a() == 0) {
                k();
                return -1;
            }
        } else {
            z2 = false;
        }
        int f2 = this.f24347b.f();
        int i2 = this.f24358m;
        int i3 = this.f24355j;
        if (i2 < i3) {
            ParsableByteArray parsableByteArray = this.f24347b;
            parsableByteArray.V(Math.min(i3 - i2, parsableByteArray.a()));
        }
        long d2 = d(this.f24347b, z2);
        int f3 = this.f24347b.f() - f2;
        this.f24347b.U(f2);
        this.f24351f.c(this.f24347b, f3);
        this.f24358m += f3;
        if (d2 != -1) {
            k();
            this.f24358m = 0;
            this.f24359n = d2;
        }
        if (this.f24347b.a() < 16) {
            int a2 = this.f24347b.a();
            System.arraycopy(this.f24347b.e(), this.f24347b.f(), this.f24347b.e(), 0, a2);
            this.f24347b.U(0);
            this.f24347b.T(a2);
        }
        return 0;
    }

    private void m(ExtractorInput extractorInput) throws IOException {
        this.f24353h = FlacMetadataReader.d(extractorInput, !this.f24348c);
        this.f24352g = 1;
    }

    private void n(ExtractorInput extractorInput) throws IOException {
        FlacMetadataReader.FlacStreamMetadataHolder flacStreamMetadataHolder = new FlacMetadataReader.FlacStreamMetadataHolder(this.f24354i);
        boolean z2 = false;
        while (!z2) {
            z2 = FlacMetadataReader.e(extractorInput, flacStreamMetadataHolder);
            this.f24354i = (FlacStreamMetadata) Util.j(flacStreamMetadataHolder.f24205a);
        }
        Assertions.e(this.f24354i);
        this.f24355j = Math.max(this.f24354i.f24210c, 6);
        ((TrackOutput) Util.j(this.f24351f)).d(this.f24354i.g(this.f24346a, this.f24353h));
        this.f24352g = 4;
    }

    private void o(ExtractorInput extractorInput) throws IOException {
        FlacMetadataReader.i(extractorInput);
        this.f24352g = 3;
    }

    public void a(long j2, long j3) {
        long j4 = 0;
        if (j2 == 0) {
            this.f24352g = 0;
        } else {
            FlacBinarySearchSeeker flacBinarySearchSeeker = this.f24357l;
            if (flacBinarySearchSeeker != null) {
                flacBinarySearchSeeker.h(j3);
            }
        }
        if (j3 != 0) {
            j4 = -1;
        }
        this.f24359n = j4;
        this.f24358m = 0;
        this.f24347b.Q(0);
    }

    public void c(ExtractorOutput extractorOutput) {
        this.f24350e = extractorOutput;
        this.f24351f = extractorOutput.d(0, 1);
        extractorOutput.m();
    }

    public boolean g(ExtractorInput extractorInput) throws IOException {
        FlacMetadataReader.c(extractorInput, false);
        return FlacMetadataReader.a(extractorInput);
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i2 = this.f24352g;
        if (i2 == 0) {
            m(extractorInput);
            return 0;
        } else if (i2 == 1) {
            h(extractorInput);
            return 0;
        } else if (i2 == 2) {
            o(extractorInput);
            return 0;
        } else if (i2 == 3) {
            n(extractorInput);
            return 0;
        } else if (i2 == 4) {
            e(extractorInput);
            return 0;
        } else if (i2 == 5) {
            return l(extractorInput, positionHolder);
        } else {
            throw new IllegalStateException();
        }
    }

    public void release() {
    }

    public FlacExtractor(int i2) {
        this.f24346a = new byte[42];
        this.f24347b = new ParsableByteArray(new byte[32768], 0);
        this.f24348c = (i2 & 1) == 0 ? false : true;
        this.f24349d = new FlacFrameReader.SampleNumberHolder();
        this.f24352g = 0;
    }
}
