package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.Id3Peeker;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.protobuf.CodedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import l0.a;
import l0.b;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class Mp3Extractor implements Extractor {

    /* renamed from: u  reason: collision with root package name */
    public static final ExtractorsFactory f24499u = new a();

    /* renamed from: v  reason: collision with root package name */
    private static final Id3Decoder.FramePredicate f24500v = new b();

    /* renamed from: a  reason: collision with root package name */
    private final int f24501a;

    /* renamed from: b  reason: collision with root package name */
    private final long f24502b;

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f24503c;

    /* renamed from: d  reason: collision with root package name */
    private final MpegAudioUtil.Header f24504d;

    /* renamed from: e  reason: collision with root package name */
    private final GaplessInfoHolder f24505e;

    /* renamed from: f  reason: collision with root package name */
    private final Id3Peeker f24506f;

    /* renamed from: g  reason: collision with root package name */
    private final TrackOutput f24507g;

    /* renamed from: h  reason: collision with root package name */
    private ExtractorOutput f24508h;

    /* renamed from: i  reason: collision with root package name */
    private TrackOutput f24509i;

    /* renamed from: j  reason: collision with root package name */
    private TrackOutput f24510j;

    /* renamed from: k  reason: collision with root package name */
    private int f24511k;

    /* renamed from: l  reason: collision with root package name */
    private Metadata f24512l;

    /* renamed from: m  reason: collision with root package name */
    private long f24513m;

    /* renamed from: n  reason: collision with root package name */
    private long f24514n;

    /* renamed from: o  reason: collision with root package name */
    private long f24515o;

    /* renamed from: p  reason: collision with root package name */
    private int f24516p;

    /* renamed from: q  reason: collision with root package name */
    private Seeker f24517q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f24518r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f24519s;

    /* renamed from: t  reason: collision with root package name */
    private long f24520t;

    public Mp3Extractor() {
        this(0);
    }

    @EnsuresNonNull({"extractorOutput", "realTrackOutput"})
    private void e() {
        Assertions.i(this.f24509i);
        Util.j(this.f24508h);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: com.google.android.exoplayer2.extractor.mp3.Seeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.google.android.exoplayer2.extractor.mp3.MlltSeeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.google.android.exoplayer2.extractor.mp3.IndexSeeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.google.android.exoplayer2.extractor.mp3.IndexSeeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.google.android.exoplayer2.extractor.mp3.IndexSeeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: com.google.android.exoplayer2.extractor.mp3.IndexSeeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.google.android.exoplayer2.extractor.mp3.IndexSeeker} */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
        if (r0 == null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        r0 = null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.exoplayer2.extractor.mp3.Seeker f(com.google.android.exoplayer2.extractor.ExtractorInput r12) throws java.io.IOException {
        /*
            r11 = this;
            com.google.android.exoplayer2.extractor.mp3.Seeker r0 = r11.r(r12)
            com.google.android.exoplayer2.metadata.Metadata r1 = r11.f24512l
            long r2 = r12.getPosition()
            com.google.android.exoplayer2.extractor.mp3.MlltSeeker r1 = q(r1, r2)
            boolean r2 = r11.f24518r
            if (r2 == 0) goto L_0x0018
            com.google.android.exoplayer2.extractor.mp3.Seeker$UnseekableSeeker r12 = new com.google.android.exoplayer2.extractor.mp3.Seeker$UnseekableSeeker
            r12.<init>()
            return r12
        L_0x0018:
            int r2 = r11.f24501a
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
            com.google.android.exoplayer2.metadata.Metadata r0 = r11.f24512l
            long r2 = l(r0)
            r0 = -1
            goto L_0x0028
        L_0x003f:
            com.google.android.exoplayer2.extractor.mp3.IndexSeeker r0 = new com.google.android.exoplayer2.extractor.mp3.IndexSeeker
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
            int r2 = r11.f24501a
            r2 = r2 & r1
            if (r2 == 0) goto L_0x006c
        L_0x0060:
            int r0 = r11.f24501a
            r0 = r0 & 2
            if (r0 == 0) goto L_0x0067
            goto L_0x0068
        L_0x0067:
            r1 = 0
        L_0x0068:
            com.google.android.exoplayer2.extractor.mp3.Seeker r0 = r11.k(r12, r1)
        L_0x006c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.f(com.google.android.exoplayer2.extractor.ExtractorInput):com.google.android.exoplayer2.extractor.mp3.Seeker");
    }

    private long h(long j2) {
        return this.f24513m + ((j2 * 1000000) / ((long) this.f24504d.f23840d));
    }

    private Seeker k(ExtractorInput extractorInput, boolean z2) throws IOException {
        extractorInput.m(this.f24503c.e(), 0, 4);
        this.f24503c.U(0);
        this.f24504d.a(this.f24503c.q());
        return new ConstantBitrateSeeker(extractorInput.getLength(), extractorInput.getPosition(), this.f24504d, z2);
    }

    private static long l(Metadata metadata) {
        if (metadata == null) {
            return -9223372036854775807L;
        }
        int f2 = metadata.f();
        for (int i2 = 0; i2 < f2; i2++) {
            Metadata.Entry e2 = metadata.e(i2);
            if (e2 instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) e2;
                if (textInformationFrame.f25428b.equals("TLEN")) {
                    return Util.F0(Long.parseLong(textInformationFrame.f25441e.get(0)));
                }
            }
        }
        return -9223372036854775807L;
    }

    private static int m(ParsableByteArray parsableByteArray, int i2) {
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

    private static boolean n(int i2, long j2) {
        return ((long) (i2 & -128000)) == (j2 & -128000);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] o() {
        return new Extractor[]{new Mp3Extractor()};
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean p(int i2, int i3, int i4, int i5, int i6) {
        return (i3 == 67 && i4 == 79 && i5 == 77 && (i6 == 77 || i2 == 2)) || (i3 == 77 && i4 == 76 && i5 == 76 && (i6 == 84 || i2 == 2));
    }

    private static MlltSeeker q(Metadata metadata, long j2) {
        if (metadata == null) {
            return null;
        }
        int f2 = metadata.f();
        for (int i2 = 0; i2 < f2; i2++) {
            Metadata.Entry e2 = metadata.e(i2);
            if (e2 instanceof MlltFrame) {
                return MlltSeeker.a(j2, (MlltFrame) e2, l(metadata));
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ab A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.exoplayer2.extractor.mp3.Seeker r(com.google.android.exoplayer2.extractor.ExtractorInput r11) throws java.io.IOException {
        /*
            r10 = this;
            com.google.android.exoplayer2.util.ParsableByteArray r5 = new com.google.android.exoplayer2.util.ParsableByteArray
            com.google.android.exoplayer2.audio.MpegAudioUtil$Header r0 = r10.f24504d
            int r0 = r0.f23839c
            r5.<init>((int) r0)
            byte[] r0 = r5.e()
            com.google.android.exoplayer2.audio.MpegAudioUtil$Header r1 = r10.f24504d
            int r1 = r1.f23839c
            r6 = 0
            r11.m(r0, r6, r1)
            com.google.android.exoplayer2.audio.MpegAudioUtil$Header r0 = r10.f24504d
            int r1 = r0.f23837a
            r2 = 1
            r1 = r1 & r2
            r3 = 21
            if (r1 == 0) goto L_0x0028
            int r0 = r0.f23841e
            if (r0 == r2) goto L_0x002c
            r3 = 36
            r7 = 36
            goto L_0x0033
        L_0x0028:
            int r0 = r0.f23841e
            if (r0 == r2) goto L_0x002f
        L_0x002c:
            r7 = 21
            goto L_0x0033
        L_0x002f:
            r3 = 13
            r7 = 13
        L_0x0033:
            int r8 = m(r5, r7)
            r0 = 1483304551(0x58696e67, float:1.02664153E15)
            r9 = 1231971951(0x496e666f, float:976486.94)
            if (r8 == r0) goto L_0x0062
            if (r8 != r9) goto L_0x0042
            goto L_0x0062
        L_0x0042:
            r0 = 1447187017(0x56425249, float:5.3414667E13)
            if (r8 != r0) goto L_0x005d
            long r0 = r11.getLength()
            long r2 = r11.getPosition()
            com.google.android.exoplayer2.audio.MpegAudioUtil$Header r4 = r10.f24504d
            com.google.android.exoplayer2.extractor.mp3.VbriSeeker r0 = com.google.android.exoplayer2.extractor.mp3.VbriSeeker.a(r0, r2, r4, r5)
            com.google.android.exoplayer2.audio.MpegAudioUtil$Header r1 = r10.f24504d
            int r1 = r1.f23839c
            r11.k(r1)
            goto L_0x00b2
        L_0x005d:
            r11.e()
            r0 = 0
            goto L_0x00b2
        L_0x0062:
            long r0 = r11.getLength()
            long r2 = r11.getPosition()
            com.google.android.exoplayer2.audio.MpegAudioUtil$Header r4 = r10.f24504d
            com.google.android.exoplayer2.extractor.mp3.XingSeeker r0 = com.google.android.exoplayer2.extractor.mp3.XingSeeker.a(r0, r2, r4, r5)
            if (r0 == 0) goto L_0x009c
            com.google.android.exoplayer2.extractor.GaplessInfoHolder r1 = r10.f24505e
            boolean r1 = r1.a()
            if (r1 != 0) goto L_0x009c
            r11.e()
            int r7 = r7 + 141
            r11.h(r7)
            com.google.android.exoplayer2.util.ParsableByteArray r1 = r10.f24503c
            byte[] r1 = r1.e()
            r2 = 3
            r11.m(r1, r6, r2)
            com.google.android.exoplayer2.util.ParsableByteArray r1 = r10.f24503c
            r1.U(r6)
            com.google.android.exoplayer2.extractor.GaplessInfoHolder r1 = r10.f24505e
            com.google.android.exoplayer2.util.ParsableByteArray r2 = r10.f24503c
            int r2 = r2.K()
            r1.d(r2)
        L_0x009c:
            com.google.android.exoplayer2.audio.MpegAudioUtil$Header r1 = r10.f24504d
            int r1 = r1.f23839c
            r11.k(r1)
            if (r0 == 0) goto L_0x00b2
            boolean r1 = r0.f()
            if (r1 != 0) goto L_0x00b2
            if (r8 != r9) goto L_0x00b2
            com.google.android.exoplayer2.extractor.mp3.Seeker r11 = r10.k(r11, r6)
            return r11
        L_0x00b2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.r(com.google.android.exoplayer2.extractor.ExtractorInput):com.google.android.exoplayer2.extractor.mp3.Seeker");
    }

    private boolean s(ExtractorInput extractorInput) throws IOException {
        Seeker seeker = this.f24517q;
        if (seeker != null) {
            long e2 = seeker.e();
            if (e2 != -1 && extractorInput.g() > e2 - 4) {
                return true;
            }
        }
        try {
            return !extractorInput.c(this.f24503c.e(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    @RequiresNonNull({"extractorOutput", "realTrackOutput"})
    private int t(ExtractorInput extractorInput) throws IOException {
        Metadata metadata;
        if (this.f24511k == 0) {
            try {
                v(extractorInput, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.f24517q == null) {
            Seeker f2 = f(extractorInput);
            this.f24517q = f2;
            this.f24508h.u(f2);
            TrackOutput trackOutput = this.f24510j;
            Format.Builder Q = new Format.Builder().g0(this.f24504d.f23838b).Y(CodedOutputStream.DEFAULT_BUFFER_SIZE).J(this.f24504d.f23841e).h0(this.f24504d.f23840d).P(this.f24505e.f24224a).Q(this.f24505e.f24225b);
            if ((this.f24501a & 8) != 0) {
                metadata = null;
            } else {
                metadata = this.f24512l;
            }
            trackOutput.d(Q.Z(metadata).G());
            this.f24515o = extractorInput.getPosition();
        } else if (this.f24515o != 0) {
            long position = extractorInput.getPosition();
            long j2 = this.f24515o;
            if (position < j2) {
                extractorInput.k((int) (j2 - position));
            }
        }
        return u(extractorInput);
    }

    @RequiresNonNull({"realTrackOutput", "seeker"})
    private int u(ExtractorInput extractorInput) throws IOException {
        if (this.f24516p == 0) {
            extractorInput.e();
            if (s(extractorInput)) {
                return -1;
            }
            this.f24503c.U(0);
            int q2 = this.f24503c.q();
            if (!n(q2, (long) this.f24511k) || MpegAudioUtil.j(q2) == -1) {
                extractorInput.k(1);
                this.f24511k = 0;
                return 0;
            }
            this.f24504d.a(q2);
            if (this.f24513m == -9223372036854775807L) {
                this.f24513m = this.f24517q.b(extractorInput.getPosition());
                if (this.f24502b != -9223372036854775807L) {
                    this.f24513m += this.f24502b - this.f24517q.b(0);
                }
            }
            MpegAudioUtil.Header header = this.f24504d;
            this.f24516p = header.f23839c;
            Seeker seeker = this.f24517q;
            if (seeker instanceof IndexSeeker) {
                IndexSeeker indexSeeker = (IndexSeeker) seeker;
                indexSeeker.c(h(this.f24514n + ((long) header.f23843g)), extractorInput.getPosition() + ((long) this.f24504d.f23839c));
                if (this.f24519s && indexSeeker.a(this.f24520t)) {
                    this.f24519s = false;
                    this.f24510j = this.f24509i;
                }
            }
        }
        int b2 = this.f24510j.b(extractorInput, this.f24516p, true);
        if (b2 == -1) {
            return -1;
        }
        int i2 = this.f24516p - b2;
        this.f24516p = i2;
        if (i2 > 0) {
            return 0;
        }
        this.f24510j.e(h(this.f24514n), 1, this.f24504d.f23839c, 0, (TrackOutput.CryptoData) null);
        this.f24514n += (long) this.f24504d.f23843g;
        this.f24516p = 0;
        return 0;
    }

    private boolean v(ExtractorInput extractorInput, boolean z2) throws IOException {
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
            if ((this.f24501a & 8) == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                framePredicate = null;
            } else {
                framePredicate = f24500v;
            }
            Metadata a2 = this.f24506f.a(extractorInput, framePredicate);
            this.f24512l = a2;
            if (a2 != null) {
                this.f24505e.c(a2);
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
            if (!s(extractorInput)) {
                this.f24503c.U(0);
                int q2 = this.f24503c.q();
                if ((i4 == 0 || n(q2, (long) i4)) && (j2 = MpegAudioUtil.j(q2)) != -1) {
                    i5++;
                    if (i5 != 1) {
                        if (i5 == 4) {
                            break;
                        }
                    } else {
                        this.f24504d.a(q2);
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
        this.f24511k = i4;
        return true;
    }

    public void a(long j2, long j3) {
        this.f24511k = 0;
        this.f24513m = -9223372036854775807L;
        this.f24514n = 0;
        this.f24516p = 0;
        this.f24520t = j3;
        Seeker seeker = this.f24517q;
        if ((seeker instanceof IndexSeeker) && !((IndexSeeker) seeker).a(j3)) {
            this.f24519s = true;
            this.f24510j = this.f24507g;
        }
    }

    public void c(ExtractorOutput extractorOutput) {
        this.f24508h = extractorOutput;
        TrackOutput d2 = extractorOutput.d(0, 1);
        this.f24509i = d2;
        this.f24510j = d2;
        this.f24508h.m();
    }

    public boolean g(ExtractorInput extractorInput) throws IOException {
        return v(extractorInput, true);
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        e();
        int t2 = t(extractorInput);
        if (t2 == -1 && (this.f24517q instanceof IndexSeeker)) {
            long h2 = h(this.f24514n);
            if (this.f24517q.h() != h2) {
                ((IndexSeeker) this.f24517q).g(h2);
                this.f24508h.u(this.f24517q);
            }
        }
        return t2;
    }

    public void j() {
        this.f24518r = true;
    }

    public void release() {
    }

    public Mp3Extractor(int i2) {
        this(i2, -9223372036854775807L);
    }

    public Mp3Extractor(int i2, long j2) {
        this.f24501a = (i2 & 2) != 0 ? i2 | 1 : i2;
        this.f24502b = j2;
        this.f24503c = new ParsableByteArray(10);
        this.f24504d = new MpegAudioUtil.Header();
        this.f24505e = new GaplessInfoHolder();
        this.f24513m = -9223372036854775807L;
        this.f24506f = new Id3Peeker();
        DummyTrackOutput dummyTrackOutput = new DummyTrackOutput();
        this.f24507g = dummyTrackOutput;
        this.f24510j = dummyTrackOutput;
    }
}
