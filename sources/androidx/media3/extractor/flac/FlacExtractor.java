package androidx.media3.extractor.flac;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.FlacFrameReader;
import androidx.media3.extractor.FlacMetadataReader;
import androidx.media3.extractor.FlacSeekTableSeekMap;
import androidx.media3.extractor.FlacStreamMetadata;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.d;
import java.io.IOException;
import java.util.List;
import k.b;

public final class FlacExtractor implements Extractor {

    /* renamed from: o  reason: collision with root package name */
    public static final ExtractorsFactory f8192o = new b();

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f8193a;

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f8194b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f8195c;

    /* renamed from: d  reason: collision with root package name */
    private final FlacFrameReader.SampleNumberHolder f8196d;

    /* renamed from: e  reason: collision with root package name */
    private ExtractorOutput f8197e;

    /* renamed from: f  reason: collision with root package name */
    private TrackOutput f8198f;

    /* renamed from: g  reason: collision with root package name */
    private int f8199g;

    /* renamed from: h  reason: collision with root package name */
    private Metadata f8200h;

    /* renamed from: i  reason: collision with root package name */
    private FlacStreamMetadata f8201i;

    /* renamed from: j  reason: collision with root package name */
    private int f8202j;

    /* renamed from: k  reason: collision with root package name */
    private int f8203k;

    /* renamed from: l  reason: collision with root package name */
    private FlacBinarySearchSeeker f8204l;

    /* renamed from: m  reason: collision with root package name */
    private int f8205m;

    /* renamed from: n  reason: collision with root package name */
    private long f8206n;

    public FlacExtractor() {
        this(0);
    }

    private long d(ParsableByteArray parsableByteArray, boolean z2) {
        boolean z3;
        Assertions.f(this.f8201i);
        int f2 = parsableByteArray.f();
        while (f2 <= parsableByteArray.g() - 16) {
            parsableByteArray.U(f2);
            if (FlacFrameReader.d(parsableByteArray, this.f8201i, this.f8203k, this.f8196d)) {
                parsableByteArray.U(f2);
                return this.f8196d.f8015a;
            }
            f2++;
        }
        if (z2) {
            while (f2 <= parsableByteArray.g() - this.f8202j) {
                parsableByteArray.U(f2);
                boolean z4 = false;
                try {
                    z3 = FlacFrameReader.d(parsableByteArray, this.f8201i, this.f8203k, this.f8196d);
                } catch (IndexOutOfBoundsException unused) {
                    z3 = false;
                }
                if (parsableByteArray.f() <= parsableByteArray.g()) {
                    z4 = z3;
                }
                if (z4) {
                    parsableByteArray.U(f2);
                    return this.f8196d.f8015a;
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
        this.f8203k = FlacMetadataReader.b(extractorInput);
        ((ExtractorOutput) Util.i(this.f8197e)).r(f(extractorInput.getPosition(), extractorInput.getLength()));
        this.f8199g = 5;
    }

    private SeekMap f(long j2, long j3) {
        Assertions.f(this.f8201i);
        FlacStreamMetadata flacStreamMetadata = this.f8201i;
        if (flacStreamMetadata.f8029k != null) {
            return new FlacSeekTableSeekMap(flacStreamMetadata, j2);
        }
        if (j3 == -1 || flacStreamMetadata.f8028j <= 0) {
            return new SeekMap.Unseekable(flacStreamMetadata.f());
        }
        FlacBinarySearchSeeker flacBinarySearchSeeker = new FlacBinarySearchSeeker(flacStreamMetadata, this.f8203k, j2, j3);
        this.f8204l = flacBinarySearchSeeker;
        return flacBinarySearchSeeker.b();
    }

    private void h(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = this.f8193a;
        extractorInput.m(bArr, 0, bArr.length);
        extractorInput.e();
        this.f8199g = 2;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] l() {
        return new Extractor[]{new FlacExtractor()};
    }

    private void m() {
        ((TrackOutput) Util.i(this.f8198f)).f((this.f8206n * 1000000) / ((long) ((FlacStreamMetadata) Util.i(this.f8201i)).f8023e), 1, this.f8205m, 0, (TrackOutput.CryptoData) null);
    }

    private int n(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        boolean z2;
        Assertions.f(this.f8198f);
        Assertions.f(this.f8201i);
        FlacBinarySearchSeeker flacBinarySearchSeeker = this.f8204l;
        if (flacBinarySearchSeeker != null && flacBinarySearchSeeker.d()) {
            return this.f8204l.c(extractorInput, positionHolder);
        }
        if (this.f8206n == -1) {
            this.f8206n = FlacFrameReader.i(extractorInput, this.f8201i);
            return 0;
        }
        int g2 = this.f8194b.g();
        if (g2 < 32768) {
            int read = extractorInput.read(this.f8194b.e(), g2, 32768 - g2);
            if (read == -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                this.f8194b.T(g2 + read);
            } else if (this.f8194b.a() == 0) {
                m();
                return -1;
            }
        } else {
            z2 = false;
        }
        int f2 = this.f8194b.f();
        int i2 = this.f8205m;
        int i3 = this.f8202j;
        if (i2 < i3) {
            ParsableByteArray parsableByteArray = this.f8194b;
            parsableByteArray.V(Math.min(i3 - i2, parsableByteArray.a()));
        }
        long d2 = d(this.f8194b, z2);
        int f3 = this.f8194b.f() - f2;
        this.f8194b.U(f2);
        this.f8198f.b(this.f8194b, f3);
        this.f8205m += f3;
        if (d2 != -1) {
            m();
            this.f8205m = 0;
            this.f8206n = d2;
        }
        if (this.f8194b.a() < 16) {
            int a2 = this.f8194b.a();
            System.arraycopy(this.f8194b.e(), this.f8194b.f(), this.f8194b.e(), 0, a2);
            this.f8194b.U(0);
            this.f8194b.T(a2);
        }
        return 0;
    }

    private void o(ExtractorInput extractorInput) throws IOException {
        this.f8200h = FlacMetadataReader.d(extractorInput, !this.f8195c);
        this.f8199g = 1;
    }

    private void p(ExtractorInput extractorInput) throws IOException {
        FlacMetadataReader.FlacStreamMetadataHolder flacStreamMetadataHolder = new FlacMetadataReader.FlacStreamMetadataHolder(this.f8201i);
        boolean z2 = false;
        while (!z2) {
            z2 = FlacMetadataReader.e(extractorInput, flacStreamMetadataHolder);
            this.f8201i = (FlacStreamMetadata) Util.i(flacStreamMetadataHolder.f8016a);
        }
        Assertions.f(this.f8201i);
        this.f8202j = Math.max(this.f8201i.f8021c, 6);
        ((TrackOutput) Util.i(this.f8198f)).c(this.f8201i.g(this.f8193a, this.f8200h));
        this.f8199g = 4;
    }

    private void q(ExtractorInput extractorInput) throws IOException {
        FlacMetadataReader.i(extractorInput);
        this.f8199g = 3;
    }

    public void a(long j2, long j3) {
        long j4 = 0;
        if (j2 == 0) {
            this.f8199g = 0;
        } else {
            FlacBinarySearchSeeker flacBinarySearchSeeker = this.f8204l;
            if (flacBinarySearchSeeker != null) {
                flacBinarySearchSeeker.h(j3);
            }
        }
        if (j3 != 0) {
            j4 = -1;
        }
        this.f8206n = j4;
        this.f8205m = 0;
        this.f8194b.Q(0);
    }

    public /* synthetic */ Extractor c() {
        return d.b(this);
    }

    public void g(ExtractorOutput extractorOutput) {
        this.f8197e = extractorOutput;
        this.f8198f = extractorOutput.d(0, 1);
        extractorOutput.m();
    }

    public boolean i(ExtractorInput extractorInput) throws IOException {
        FlacMetadataReader.c(extractorInput, false);
        return FlacMetadataReader.a(extractorInput);
    }

    public /* synthetic */ List j() {
        return d.a(this);
    }

    public int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i2 = this.f8199g;
        if (i2 == 0) {
            o(extractorInput);
            return 0;
        } else if (i2 == 1) {
            h(extractorInput);
            return 0;
        } else if (i2 == 2) {
            q(extractorInput);
            return 0;
        } else if (i2 == 3) {
            p(extractorInput);
            return 0;
        } else if (i2 == 4) {
            e(extractorInput);
            return 0;
        } else if (i2 == 5) {
            return n(extractorInput, positionHolder);
        } else {
            throw new IllegalStateException();
        }
    }

    public void release() {
    }

    public FlacExtractor(int i2) {
        this.f8193a = new byte[42];
        this.f8194b = new ParsableByteArray(new byte[32768], 0);
        this.f8195c = (i2 & 1) == 0 ? false : true;
        this.f8196d = new FlacFrameReader.SampleNumberHolder();
        this.f8199g = 0;
    }
}
