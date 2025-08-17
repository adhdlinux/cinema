package androidx.media3.extractor.ts;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.d;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.protobuf.CodedOutputStream;
import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class PsExtractor implements Extractor {

    /* renamed from: l  reason: collision with root package name */
    public static final ExtractorsFactory f9470l = new d();

    /* renamed from: a  reason: collision with root package name */
    private final TimestampAdjuster f9471a;

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray<PesReader> f9472b;

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f9473c;

    /* renamed from: d  reason: collision with root package name */
    private final PsDurationReader f9474d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9475e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9476f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9477g;

    /* renamed from: h  reason: collision with root package name */
    private long f9478h;

    /* renamed from: i  reason: collision with root package name */
    private PsBinarySearchSeeker f9479i;

    /* renamed from: j  reason: collision with root package name */
    private ExtractorOutput f9480j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f9481k;

    private static final class PesReader {

        /* renamed from: a  reason: collision with root package name */
        private final ElementaryStreamReader f9482a;

        /* renamed from: b  reason: collision with root package name */
        private final TimestampAdjuster f9483b;

        /* renamed from: c  reason: collision with root package name */
        private final ParsableBitArray f9484c = new ParsableBitArray(new byte[64]);

        /* renamed from: d  reason: collision with root package name */
        private boolean f9485d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f9486e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f9487f;

        /* renamed from: g  reason: collision with root package name */
        private int f9488g;

        /* renamed from: h  reason: collision with root package name */
        private long f9489h;

        public PesReader(ElementaryStreamReader elementaryStreamReader, TimestampAdjuster timestampAdjuster) {
            this.f9482a = elementaryStreamReader;
            this.f9483b = timestampAdjuster;
        }

        private void b() {
            this.f9484c.r(8);
            this.f9485d = this.f9484c.g();
            this.f9486e = this.f9484c.g();
            this.f9484c.r(6);
            this.f9488g = this.f9484c.h(8);
        }

        private void c() {
            this.f9489h = 0;
            if (this.f9485d) {
                this.f9484c.r(4);
                this.f9484c.r(1);
                this.f9484c.r(1);
                long h2 = (((long) this.f9484c.h(3)) << 30) | ((long) (this.f9484c.h(15) << 15)) | ((long) this.f9484c.h(15));
                this.f9484c.r(1);
                if (!this.f9487f && this.f9486e) {
                    this.f9484c.r(4);
                    this.f9484c.r(1);
                    this.f9484c.r(1);
                    this.f9484c.r(1);
                    this.f9483b.b((((long) this.f9484c.h(3)) << 30) | ((long) (this.f9484c.h(15) << 15)) | ((long) this.f9484c.h(15)));
                    this.f9487f = true;
                }
                this.f9489h = this.f9483b.b(h2);
            }
        }

        public void a(ParsableByteArray parsableByteArray) throws ParserException {
            parsableByteArray.l(this.f9484c.f4688a, 0, 3);
            this.f9484c.p(0);
            b();
            parsableByteArray.l(this.f9484c.f4688a, 0, this.f9488g);
            this.f9484c.p(0);
            c();
            this.f9482a.d(this.f9489h, 4);
            this.f9482a.b(parsableByteArray);
            this.f9482a.e(false);
        }

        public void d() {
            this.f9487f = false;
            this.f9482a.a();
        }
    }

    public PsExtractor() {
        this(new TimestampAdjuster(0));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] d() {
        return new Extractor[]{new PsExtractor()};
    }

    @RequiresNonNull({"output"})
    private void e(long j2) {
        if (!this.f9481k) {
            this.f9481k = true;
            if (this.f9474d.c() != -9223372036854775807L) {
                PsBinarySearchSeeker psBinarySearchSeeker = new PsBinarySearchSeeker(this.f9474d.d(), this.f9474d.c(), j2);
                this.f9479i = psBinarySearchSeeker;
                this.f9480j.r(psBinarySearchSeeker.b());
                return;
            }
            this.f9480j.r(new SeekMap.Unseekable(this.f9474d.c()));
        }
    }

    public void a(long j2, long j3) {
        boolean z2;
        boolean z3 = true;
        if (this.f9471a.f() == -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            long d2 = this.f9471a.d();
            if (d2 == -9223372036854775807L || d2 == 0 || d2 == j3) {
                z3 = false;
            }
            z2 = z3;
        }
        if (z2) {
            this.f9471a.i(j3);
        }
        PsBinarySearchSeeker psBinarySearchSeeker = this.f9479i;
        if (psBinarySearchSeeker != null) {
            psBinarySearchSeeker.h(j3);
        }
        for (int i2 = 0; i2 < this.f9472b.size(); i2++) {
            this.f9472b.valueAt(i2).d();
        }
    }

    public /* synthetic */ Extractor c() {
        return d.b(this);
    }

    public void g(ExtractorOutput extractorOutput) {
        this.f9480j = extractorOutput;
    }

    public boolean i(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = new byte[14];
        extractorInput.m(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        extractorInput.h(bArr[13] & 7);
        extractorInput.m(bArr, 0, 3);
        if (1 == (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[2] & 255))) {
            return true;
        }
        return false;
    }

    public /* synthetic */ List j() {
        return d.a(this);
    }

    public int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        boolean z2;
        long j2;
        long j3;
        ElementaryStreamReader elementaryStreamReader;
        Assertions.j(this.f9480j);
        long length = extractorInput.getLength();
        int i2 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
        if (i2 != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && !this.f9474d.e()) {
            return this.f9474d.g(extractorInput, positionHolder);
        }
        e(length);
        PsBinarySearchSeeker psBinarySearchSeeker = this.f9479i;
        if (psBinarySearchSeeker != null && psBinarySearchSeeker.d()) {
            return this.f9479i.c(extractorInput, positionHolder);
        }
        extractorInput.e();
        if (i2 != 0) {
            j2 = length - extractorInput.g();
        } else {
            j2 = -1;
        }
        if ((j2 != -1 && j2 < 4) || !extractorInput.c(this.f9473c.e(), 0, 4, true)) {
            return -1;
        }
        this.f9473c.U(0);
        int q2 = this.f9473c.q();
        if (q2 == 441) {
            return -1;
        }
        if (q2 == 442) {
            extractorInput.m(this.f9473c.e(), 0, 10);
            this.f9473c.U(9);
            extractorInput.k((this.f9473c.H() & 7) + 14);
            return 0;
        } else if (q2 == 443) {
            extractorInput.m(this.f9473c.e(), 0, 2);
            this.f9473c.U(0);
            extractorInput.k(this.f9473c.N() + 6);
            return 0;
        } else if (((q2 & -256) >> 8) != 1) {
            extractorInput.k(1);
            return 0;
        } else {
            int i3 = q2 & JfifUtil.MARKER_FIRST_BYTE;
            PesReader pesReader = this.f9472b.get(i3);
            if (!this.f9475e) {
                if (pesReader == null) {
                    if (i3 == 189) {
                        elementaryStreamReader = new Ac3Reader();
                        this.f9476f = true;
                        this.f9478h = extractorInput.getPosition();
                    } else if ((i3 & 224) == 192) {
                        elementaryStreamReader = new MpegAudioReader();
                        this.f9476f = true;
                        this.f9478h = extractorInput.getPosition();
                    } else if ((i3 & 240) == 224) {
                        elementaryStreamReader = new H262Reader();
                        this.f9477g = true;
                        this.f9478h = extractorInput.getPosition();
                    } else {
                        elementaryStreamReader = null;
                    }
                    if (elementaryStreamReader != null) {
                        elementaryStreamReader.f(this.f9480j, new TsPayloadReader.TrackIdGenerator(i3, UserVerificationMethods.USER_VERIFY_HANDPRINT));
                        pesReader = new PesReader(elementaryStreamReader, this.f9471a);
                        this.f9472b.put(i3, pesReader);
                    }
                }
                if (!this.f9476f || !this.f9477g) {
                    j3 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                } else {
                    j3 = this.f9478h + 8192;
                }
                if (extractorInput.getPosition() > j3) {
                    this.f9475e = true;
                    this.f9480j.m();
                }
            }
            extractorInput.m(this.f9473c.e(), 0, 2);
            this.f9473c.U(0);
            int N = this.f9473c.N() + 6;
            if (pesReader == null) {
                extractorInput.k(N);
            } else {
                this.f9473c.Q(N);
                extractorInput.readFully(this.f9473c.e(), 0, N);
                this.f9473c.U(6);
                pesReader.a(this.f9473c);
                ParsableByteArray parsableByteArray = this.f9473c;
                parsableByteArray.T(parsableByteArray.b());
            }
            return 0;
        }
    }

    public void release() {
    }

    public PsExtractor(TimestampAdjuster timestampAdjuster) {
        this.f9471a = timestampAdjuster;
        this.f9473c = new ParsableByteArray((int) CodedOutputStream.DEFAULT_BUFFER_SIZE);
        this.f9472b = new SparseArray<>();
        this.f9474d = new PsDurationReader();
    }
}
