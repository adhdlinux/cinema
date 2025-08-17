package com.google.android.exoplayer2.extractor.ts;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.protobuf.CodedOutputStream;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class PsExtractor implements Extractor {

    /* renamed from: l  reason: collision with root package name */
    public static final ExtractorsFactory f25049l = new d();

    /* renamed from: a  reason: collision with root package name */
    private final TimestampAdjuster f25050a;

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray<PesReader> f25051b;

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f25052c;

    /* renamed from: d  reason: collision with root package name */
    private final PsDurationReader f25053d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f25054e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f25055f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f25056g;

    /* renamed from: h  reason: collision with root package name */
    private long f25057h;

    /* renamed from: i  reason: collision with root package name */
    private PsBinarySearchSeeker f25058i;

    /* renamed from: j  reason: collision with root package name */
    private ExtractorOutput f25059j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f25060k;

    private static final class PesReader {

        /* renamed from: a  reason: collision with root package name */
        private final ElementaryStreamReader f25061a;

        /* renamed from: b  reason: collision with root package name */
        private final TimestampAdjuster f25062b;

        /* renamed from: c  reason: collision with root package name */
        private final ParsableBitArray f25063c = new ParsableBitArray(new byte[64]);

        /* renamed from: d  reason: collision with root package name */
        private boolean f25064d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f25065e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f25066f;

        /* renamed from: g  reason: collision with root package name */
        private int f25067g;

        /* renamed from: h  reason: collision with root package name */
        private long f25068h;

        public PesReader(ElementaryStreamReader elementaryStreamReader, TimestampAdjuster timestampAdjuster) {
            this.f25061a = elementaryStreamReader;
            this.f25062b = timestampAdjuster;
        }

        private void b() {
            this.f25063c.r(8);
            this.f25064d = this.f25063c.g();
            this.f25065e = this.f25063c.g();
            this.f25063c.r(6);
            this.f25067g = this.f25063c.h(8);
        }

        private void c() {
            this.f25068h = 0;
            if (this.f25064d) {
                this.f25063c.r(4);
                this.f25063c.r(1);
                this.f25063c.r(1);
                long h2 = (((long) this.f25063c.h(3)) << 30) | ((long) (this.f25063c.h(15) << 15)) | ((long) this.f25063c.h(15));
                this.f25063c.r(1);
                if (!this.f25066f && this.f25065e) {
                    this.f25063c.r(4);
                    this.f25063c.r(1);
                    this.f25063c.r(1);
                    this.f25063c.r(1);
                    this.f25062b.b((((long) this.f25063c.h(3)) << 30) | ((long) (this.f25063c.h(15) << 15)) | ((long) this.f25063c.h(15)));
                    this.f25066f = true;
                }
                this.f25068h = this.f25062b.b(h2);
            }
        }

        public void a(ParsableByteArray parsableByteArray) throws ParserException {
            parsableByteArray.l(this.f25063c.f28757a, 0, 3);
            this.f25063c.p(0);
            b();
            parsableByteArray.l(this.f25063c.f28757a, 0, this.f25067g);
            this.f25063c.p(0);
            c();
            this.f25061a.d(this.f25068h, 4);
            this.f25061a.c(parsableByteArray);
            this.f25061a.f();
        }

        public void d() {
            this.f25066f = false;
            this.f25061a.a();
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
        if (!this.f25060k) {
            this.f25060k = true;
            if (this.f25053d.c() != -9223372036854775807L) {
                PsBinarySearchSeeker psBinarySearchSeeker = new PsBinarySearchSeeker(this.f25053d.d(), this.f25053d.c(), j2);
                this.f25058i = psBinarySearchSeeker;
                this.f25059j.u(psBinarySearchSeeker.b());
                return;
            }
            this.f25059j.u(new SeekMap.Unseekable(this.f25053d.c()));
        }
    }

    public void a(long j2, long j3) {
        boolean z2;
        boolean z3 = true;
        if (this.f25050a.e() == -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            long c2 = this.f25050a.c();
            if (c2 == -9223372036854775807L || c2 == 0 || c2 == j3) {
                z3 = false;
            }
            z2 = z3;
        }
        if (z2) {
            this.f25050a.g(j3);
        }
        PsBinarySearchSeeker psBinarySearchSeeker = this.f25058i;
        if (psBinarySearchSeeker != null) {
            psBinarySearchSeeker.h(j3);
        }
        for (int i2 = 0; i2 < this.f25051b.size(); i2++) {
            this.f25051b.valueAt(i2).d();
        }
    }

    public void c(ExtractorOutput extractorOutput) {
        this.f25059j = extractorOutput;
    }

    public boolean g(ExtractorInput extractorInput) throws IOException {
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

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        boolean z2;
        long j2;
        long j3;
        ElementaryStreamReader elementaryStreamReader;
        Assertions.i(this.f25059j);
        long length = extractorInput.getLength();
        int i2 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
        if (i2 != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && !this.f25053d.e()) {
            return this.f25053d.g(extractorInput, positionHolder);
        }
        e(length);
        PsBinarySearchSeeker psBinarySearchSeeker = this.f25058i;
        if (psBinarySearchSeeker != null && psBinarySearchSeeker.d()) {
            return this.f25058i.c(extractorInput, positionHolder);
        }
        extractorInput.e();
        if (i2 != 0) {
            j2 = length - extractorInput.g();
        } else {
            j2 = -1;
        }
        if ((j2 != -1 && j2 < 4) || !extractorInput.c(this.f25052c.e(), 0, 4, true)) {
            return -1;
        }
        this.f25052c.U(0);
        int q2 = this.f25052c.q();
        if (q2 == 441) {
            return -1;
        }
        if (q2 == 442) {
            extractorInput.m(this.f25052c.e(), 0, 10);
            this.f25052c.U(9);
            extractorInput.k((this.f25052c.H() & 7) + 14);
            return 0;
        } else if (q2 == 443) {
            extractorInput.m(this.f25052c.e(), 0, 2);
            this.f25052c.U(0);
            extractorInput.k(this.f25052c.N() + 6);
            return 0;
        } else if (((q2 & -256) >> 8) != 1) {
            extractorInput.k(1);
            return 0;
        } else {
            int i3 = q2 & JfifUtil.MARKER_FIRST_BYTE;
            PesReader pesReader = this.f25051b.get(i3);
            if (!this.f25054e) {
                if (pesReader == null) {
                    if (i3 == 189) {
                        elementaryStreamReader = new Ac3Reader();
                        this.f25055f = true;
                        this.f25057h = extractorInput.getPosition();
                    } else if ((i3 & 224) == 192) {
                        elementaryStreamReader = new MpegAudioReader();
                        this.f25055f = true;
                        this.f25057h = extractorInput.getPosition();
                    } else if ((i3 & 240) == 224) {
                        elementaryStreamReader = new H262Reader();
                        this.f25056g = true;
                        this.f25057h = extractorInput.getPosition();
                    } else {
                        elementaryStreamReader = null;
                    }
                    if (elementaryStreamReader != null) {
                        elementaryStreamReader.e(this.f25059j, new TsPayloadReader.TrackIdGenerator(i3, UserVerificationMethods.USER_VERIFY_HANDPRINT));
                        pesReader = new PesReader(elementaryStreamReader, this.f25050a);
                        this.f25051b.put(i3, pesReader);
                    }
                }
                if (!this.f25055f || !this.f25056g) {
                    j3 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                } else {
                    j3 = this.f25057h + 8192;
                }
                if (extractorInput.getPosition() > j3) {
                    this.f25054e = true;
                    this.f25059j.m();
                }
            }
            extractorInput.m(this.f25052c.e(), 0, 2);
            this.f25052c.U(0);
            int N = this.f25052c.N() + 6;
            if (pesReader == null) {
                extractorInput.k(N);
            } else {
                this.f25052c.Q(N);
                extractorInput.readFully(this.f25052c.e(), 0, N);
                this.f25052c.U(6);
                pesReader.a(this.f25052c);
                ParsableByteArray parsableByteArray = this.f25052c;
                parsableByteArray.T(parsableByteArray.b());
            }
            return 0;
        }
    }

    public void release() {
    }

    public PsExtractor(TimestampAdjuster timestampAdjuster) {
        this.f25050a = timestampAdjuster;
        this.f25052c = new ParsableByteArray((int) CodedOutputStream.DEFAULT_BUFFER_SIZE);
        this.f25051b = new SparseArray<>();
        this.f25053d = new PsDurationReader();
    }
}
