package androidx.media3.extractor.mp3;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.Id3Peeker;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.d;
import androidx.media3.extractor.metadata.id3.Id3Decoder;
import androidx.media3.extractor.metadata.id3.MlltFrame;
import androidx.media3.extractor.metadata.id3.TextInformationFrame;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.google.protobuf.CodedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.List;
import m.a;
import m.b;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class Mp3Extractor implements Extractor {

    /* renamed from: u  reason: collision with root package name */
    public static final ExtractorsFactory f8484u = new a();

    /* renamed from: v  reason: collision with root package name */
    private static final Id3Decoder.FramePredicate f8485v = new b();

    /* renamed from: a  reason: collision with root package name */
    private final int f8486a;

    /* renamed from: b  reason: collision with root package name */
    private final long f8487b;

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f8488c;

    /* renamed from: d  reason: collision with root package name */
    private final MpegAudioUtil.Header f8489d;

    /* renamed from: e  reason: collision with root package name */
    private final GaplessInfoHolder f8490e;

    /* renamed from: f  reason: collision with root package name */
    private final Id3Peeker f8491f;

    /* renamed from: g  reason: collision with root package name */
    private final TrackOutput f8492g;

    /* renamed from: h  reason: collision with root package name */
    private ExtractorOutput f8493h;

    /* renamed from: i  reason: collision with root package name */
    private TrackOutput f8494i;

    /* renamed from: j  reason: collision with root package name */
    private TrackOutput f8495j;

    /* renamed from: k  reason: collision with root package name */
    private int f8496k;

    /* renamed from: l  reason: collision with root package name */
    private Metadata f8497l;

    /* renamed from: m  reason: collision with root package name */
    private long f8498m;

    /* renamed from: n  reason: collision with root package name */
    private long f8499n;

    /* renamed from: o  reason: collision with root package name */
    private long f8500o;

    /* renamed from: p  reason: collision with root package name */
    private int f8501p;

    /* renamed from: q  reason: collision with root package name */
    private Seeker f8502q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f8503r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f8504s;

    /* renamed from: t  reason: collision with root package name */
    private long f8505t;

    public Mp3Extractor() {
        this(0);
    }

    @EnsuresNonNull({"extractorOutput", "realTrackOutput"})
    private void e() {
        Assertions.j(this.f8494i);
        Util.i(this.f8493h);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: androidx.media3.extractor.mp3.Seeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: androidx.media3.extractor.mp3.MlltSeeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: androidx.media3.extractor.mp3.IndexSeeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: androidx.media3.extractor.mp3.IndexSeeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: androidx.media3.extractor.mp3.IndexSeeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: androidx.media3.extractor.mp3.IndexSeeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: androidx.media3.extractor.mp3.IndexSeeker} */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
        if (r0 == null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        r0 = null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.media3.extractor.mp3.Seeker f(androidx.media3.extractor.ExtractorInput r12) throws java.io.IOException {
        /*
            r11 = this;
            androidx.media3.extractor.mp3.Seeker r0 = r11.u(r12)
            androidx.media3.common.Metadata r1 = r11.f8497l
            long r2 = r12.getPosition()
            androidx.media3.extractor.mp3.MlltSeeker r1 = t(r1, r2)
            boolean r2 = r11.f8503r
            if (r2 == 0) goto L_0x0018
            androidx.media3.extractor.mp3.Seeker$UnseekableSeeker r12 = new androidx.media3.extractor.mp3.Seeker$UnseekableSeeker
            r12.<init>()
            return r12
        L_0x0018:
            int r2 = r11.f8486a
            r2 = r2 & 4
            if (r2 == 0) goto L_0x004a
            if (r1 == 0) goto L_0x002b
            long r2 = r1.h()
            long r0 = r1.e()
        L_0x0028:
            r9 = r0
            r5 = r2
            goto L_0x003f
        L_0x002b:
            if (r0 == 0) goto L_0x0036
            long r2 = r0.h()
            long r0 = r0.e()
            goto L_0x0028
        L_0x0036:
            androidx.media3.common.Metadata r0 = r11.f8497l
            long r2 = o(r0)
            r0 = -1
            goto L_0x0028
        L_0x003f:
            androidx.media3.extractor.mp3.IndexSeeker r0 = new androidx.media3.extractor.mp3.IndexSeeker
            long r7 = r12.getPosition()
            r4 = r0
            r4.<init>(r5, r7, r9)
            goto L_0x0052
        L_0x004a:
            if (r1 == 0) goto L_0x004e
            r0 = r1
            goto L_0x0052
        L_0x004e:
            if (r0 == 0) goto L_0x0051
            goto L_0x0052
        L_0x0051:
            r0 = 0
        L_0x0052:
            r1 = 1
            if (r0 == 0) goto L_0x0060
            boolean r2 = r0.f()
            if (r2 != 0) goto L_0x006c
            int r2 = r11.f8486a
            r2 = r2 & r1
            if (r2 == 0) goto L_0x006c
        L_0x0060:
            int r0 = r11.f8486a
            r0 = r0 & 2
            if (r0 == 0) goto L_0x0067
            goto L_0x0068
        L_0x0067:
            r1 = 0
        L_0x0068:
            androidx.media3.extractor.mp3.Seeker r0 = r11.n(r12, r1)
        L_0x006c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp3.Mp3Extractor.f(androidx.media3.extractor.ExtractorInput):androidx.media3.extractor.mp3.Seeker");
    }

    private long h(long j2) {
        return this.f8498m + ((j2 * 1000000) / ((long) this.f8489d.f8065d));
    }

    private Seeker m(long j2, XingFrame xingFrame, long j3) {
        long j4;
        long j5;
        XingFrame xingFrame2 = xingFrame;
        long a2 = xingFrame.a();
        if (a2 == -9223372036854775807L) {
            return null;
        }
        long j6 = xingFrame2.f8513c;
        if (j6 != -1) {
            j4 = j6 - ((long) xingFrame2.f8511a.f8064c);
            j5 = j2 + j6;
        } else if (j3 == -1) {
            return null;
        } else {
            j5 = j3;
            j4 = (j3 - j2) - ((long) xingFrame2.f8511a.f8064c);
        }
        return new ConstantBitrateSeeker(j5, j2 + ((long) xingFrame2.f8511a.f8064c), Ints.d(Util.e1(j4, 8000000, a2, RoundingMode.HALF_UP)), Ints.d(LongMath.b(j4, xingFrame2.f8512b, RoundingMode.HALF_UP)), false);
    }

    private Seeker n(ExtractorInput extractorInput, boolean z2) throws IOException {
        extractorInput.m(this.f8488c.e(), 0, 4);
        this.f8488c.U(0);
        this.f8489d.a(this.f8488c.q());
        return new ConstantBitrateSeeker(extractorInput.getLength(), extractorInput.getPosition(), this.f8489d, z2);
    }

    private static long o(Metadata metadata) {
        if (metadata == null) {
            return -9223372036854775807L;
        }
        int f2 = metadata.f();
        for (int i2 = 0; i2 < f2; i2++) {
            Metadata.Entry e2 = metadata.e(i2);
            if (e2 instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) e2;
                if (textInformationFrame.f8328b.equals("TLEN")) {
                    return Util.P0(Long.parseLong(textInformationFrame.f8342e.get(0)));
                }
            }
        }
        return -9223372036854775807L;
    }

    private static int p(ParsableByteArray parsableByteArray, int i2) {
        if (parsableByteArray.g() >= i2 + 4) {
            parsableByteArray.U(i2);
            int q2 = parsableByteArray.q();
            if (q2 == 1483304551 || q2 == 1231971951) {
                return q2;
            }
        }
        if (parsableByteArray.g() < 40) {
            return 0;
        }
        parsableByteArray.U(36);
        if (parsableByteArray.q() == 1447187017) {
            return 1447187017;
        }
        return 0;
    }

    private static boolean q(int i2, long j2) {
        return ((long) (i2 & -128000)) == (j2 & -128000);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] r() {
        return new Extractor[]{new Mp3Extractor()};
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean s(int i2, int i3, int i4, int i5, int i6) {
        return (i3 == 67 && i4 == 79 && i5 == 77 && (i6 == 77 || i2 == 2)) || (i3 == 77 && i4 == 76 && i5 == 76 && (i6 == 84 || i2 == 2));
    }

    private static MlltSeeker t(Metadata metadata, long j2) {
        if (metadata == null) {
            return null;
        }
        int f2 = metadata.f();
        for (int i2 = 0; i2 < f2; i2++) {
            Metadata.Entry e2 = metadata.e(i2);
            if (e2 instanceof MlltFrame) {
                return MlltSeeker.a(j2, (MlltFrame) e2, o(metadata));
            }
        }
        return null;
    }

    private Seeker u(ExtractorInput extractorInput) throws IOException {
        int i2;
        int i3;
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.f8489d.f8064c);
        extractorInput.m(parsableByteArray.e(), 0, this.f8489d.f8064c);
        MpegAudioUtil.Header header = this.f8489d;
        int i4 = 21;
        if ((header.f8062a & 1) != 0) {
            if (header.f8066e != 1) {
                i4 = 36;
            }
        } else if (header.f8066e == 1) {
            i4 = 13;
        }
        int p2 = p(parsableByteArray, i4);
        if (p2 != 1231971951) {
            if (p2 == 1447187017) {
                VbriSeeker a2 = VbriSeeker.a(extractorInput.getLength(), extractorInput.getPosition(), this.f8489d, parsableByteArray);
                extractorInput.k(this.f8489d.f8064c);
                return a2;
            } else if (p2 != 1483304551) {
                extractorInput.e();
                return null;
            }
        }
        XingFrame b2 = XingFrame.b(this.f8489d, parsableByteArray);
        if (!(this.f8490e.a() || (i2 = b2.f8514d) == -1 || (i3 = b2.f8515e) == -1)) {
            GaplessInfoHolder gaplessInfoHolder = this.f8490e;
            gaplessInfoHolder.f8036a = i2;
            gaplessInfoHolder.f8037b = i3;
        }
        long position = extractorInput.getPosition();
        if (!(extractorInput.getLength() == -1 || b2.f8513c == -1 || extractorInput.getLength() == b2.f8513c + position)) {
            Log.f("Mp3Extractor", "Data size mismatch between stream (" + extractorInput.getLength() + ") and Xing frame (" + (b2.f8513c + position) + "), using Xing value.");
        }
        extractorInput.k(this.f8489d.f8064c);
        if (p2 == 1483304551) {
            return XingSeeker.a(b2, position);
        }
        return m(position, b2, extractorInput.getLength());
    }

    private boolean v(ExtractorInput extractorInput) throws IOException {
        Seeker seeker = this.f8502q;
        if (seeker != null) {
            long e2 = seeker.e();
            if (e2 != -1 && extractorInput.g() > e2 - 4) {
                return true;
            }
        }
        try {
            return !extractorInput.c(this.f8488c.e(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    @RequiresNonNull({"extractorOutput", "realTrackOutput"})
    private int w(ExtractorInput extractorInput) throws IOException {
        Metadata metadata;
        if (this.f8496k == 0) {
            try {
                y(extractorInput, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.f8502q == null) {
            Seeker f2 = f(extractorInput);
            this.f8502q = f2;
            this.f8493h.r(f2);
            Format.Builder W = new Format.Builder().o0(this.f8489d.f8063b).f0(CodedOutputStream.DEFAULT_BUFFER_SIZE).N(this.f8489d.f8066e).p0(this.f8489d.f8065d).V(this.f8490e.f8036a).W(this.f8490e.f8037b);
            if ((this.f8486a & 8) != 0) {
                metadata = null;
            } else {
                metadata = this.f8497l;
            }
            Format.Builder h02 = W.h0(metadata);
            if (this.f8502q.l() != -2147483647) {
                h02.M(this.f8502q.l());
            }
            this.f8495j.c(h02.K());
            this.f8500o = extractorInput.getPosition();
        } else if (this.f8500o != 0) {
            long position = extractorInput.getPosition();
            long j2 = this.f8500o;
            if (position < j2) {
                extractorInput.k((int) (j2 - position));
            }
        }
        return x(extractorInput);
    }

    @RequiresNonNull({"realTrackOutput", "seeker"})
    private int x(ExtractorInput extractorInput) throws IOException {
        if (this.f8501p == 0) {
            extractorInput.e();
            if (v(extractorInput)) {
                return -1;
            }
            this.f8488c.U(0);
            int q2 = this.f8488c.q();
            if (!q(q2, (long) this.f8496k) || MpegAudioUtil.j(q2) == -1) {
                extractorInput.k(1);
                this.f8496k = 0;
                return 0;
            }
            this.f8489d.a(q2);
            if (this.f8498m == -9223372036854775807L) {
                this.f8498m = this.f8502q.b(extractorInput.getPosition());
                if (this.f8487b != -9223372036854775807L) {
                    this.f8498m += this.f8487b - this.f8502q.b(0);
                }
            }
            MpegAudioUtil.Header header = this.f8489d;
            this.f8501p = header.f8064c;
            Seeker seeker = this.f8502q;
            if (seeker instanceof IndexSeeker) {
                IndexSeeker indexSeeker = (IndexSeeker) seeker;
                indexSeeker.c(h(this.f8499n + ((long) header.f8068g)), extractorInput.getPosition() + ((long) this.f8489d.f8064c));
                if (this.f8504s && indexSeeker.a(this.f8505t)) {
                    this.f8504s = false;
                    this.f8495j = this.f8494i;
                }
            }
        }
        int d2 = this.f8495j.d(extractorInput, this.f8501p, true);
        if (d2 == -1) {
            return -1;
        }
        int i2 = this.f8501p - d2;
        this.f8501p = i2;
        if (i2 > 0) {
            return 0;
        }
        this.f8495j.f(h(this.f8499n), 1, this.f8489d.f8064c, 0, (TrackOutput.CryptoData) null);
        this.f8499n += (long) this.f8489d.f8068g;
        this.f8501p = 0;
        return 0;
    }

    private boolean y(ExtractorInput extractorInput, boolean z2) throws IOException {
        int i2;
        int i3;
        int i4;
        int j2;
        boolean z3;
        Id3Decoder.FramePredicate framePredicate;
        if (z2) {
            i2 = 32768;
        } else {
            i2 = 131072;
        }
        extractorInput.e();
        if (extractorInput.getPosition() == 0) {
            if ((this.f8486a & 8) == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                framePredicate = null;
            } else {
                framePredicate = f8485v;
            }
            Metadata a2 = this.f8491f.a(extractorInput, framePredicate);
            this.f8497l = a2;
            if (a2 != null) {
                this.f8490e.c(a2);
            }
            i3 = (int) extractorInput.g();
            if (!z2) {
                extractorInput.k(i3);
            }
            i4 = 0;
        } else {
            i4 = 0;
            i3 = 0;
        }
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (!v(extractorInput)) {
                this.f8488c.U(0);
                int q2 = this.f8488c.q();
                if ((i4 == 0 || q(q2, (long) i4)) && (j2 = MpegAudioUtil.j(q2)) != -1) {
                    i5++;
                    if (i5 != 1) {
                        if (i5 == 4) {
                            break;
                        }
                    } else {
                        this.f8489d.a(q2);
                        i4 = q2;
                    }
                    extractorInput.h(j2 - 4);
                } else {
                    int i7 = i6 + 1;
                    if (i6 != i2) {
                        if (z2) {
                            extractorInput.e();
                            extractorInput.h(i3 + i7);
                        } else {
                            extractorInput.k(1);
                        }
                        i6 = i7;
                        i4 = 0;
                        i5 = 0;
                    } else if (z2) {
                        return false;
                    } else {
                        throw ParserException.a("Searched too many bytes.", (Throwable) null);
                    }
                }
            } else if (i5 <= 0) {
                throw new EOFException();
            }
        }
        if (z2) {
            extractorInput.k(i3 + i6);
        } else {
            extractorInput.e();
        }
        this.f8496k = i4;
        return true;
    }

    public void a(long j2, long j3) {
        this.f8496k = 0;
        this.f8498m = -9223372036854775807L;
        this.f8499n = 0;
        this.f8501p = 0;
        this.f8505t = j3;
        Seeker seeker = this.f8502q;
        if ((seeker instanceof IndexSeeker) && !((IndexSeeker) seeker).a(j3)) {
            this.f8504s = true;
            this.f8495j = this.f8492g;
        }
    }

    public /* synthetic */ Extractor c() {
        return d.b(this);
    }

    public void g(ExtractorOutput extractorOutput) {
        this.f8493h = extractorOutput;
        TrackOutput d2 = extractorOutput.d(0, 1);
        this.f8494i = d2;
        this.f8495j = d2;
        this.f8493h.m();
    }

    public boolean i(ExtractorInput extractorInput) throws IOException {
        return y(extractorInput, true);
    }

    public /* synthetic */ List j() {
        return d.a(this);
    }

    public int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        e();
        int w2 = w(extractorInput);
        if (w2 == -1 && (this.f8502q instanceof IndexSeeker)) {
            long h2 = h(this.f8499n);
            if (this.f8502q.h() != h2) {
                ((IndexSeeker) this.f8502q).g(h2);
                this.f8493h.r(this.f8502q);
            }
        }
        return w2;
    }

    public void l() {
        this.f8503r = true;
    }

    public void release() {
    }

    public Mp3Extractor(int i2) {
        this(i2, -9223372036854775807L);
    }

    public Mp3Extractor(int i2, long j2) {
        this.f8486a = (i2 & 2) != 0 ? i2 | 1 : i2;
        this.f8487b = j2;
        this.f8488c = new ParsableByteArray(10);
        this.f8489d = new MpegAudioUtil.Header();
        this.f8490e = new GaplessInfoHolder();
        this.f8498m = -9223372036854775807L;
        this.f8491f = new Id3Peeker();
        DiscardingTrackOutput discardingTrackOutput = new DiscardingTrackOutput();
        this.f8492g = discardingTrackOutput;
        this.f8495j = discardingTrackOutput;
    }
}
