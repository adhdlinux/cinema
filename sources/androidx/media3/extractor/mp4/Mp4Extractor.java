package androidx.media3.extractor.mp4;

import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SniffFailure;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.TrueHdSampleRechunker;
import androidx.media3.extractor.d;
import androidx.media3.extractor.metadata.mp4.MotionPhotoMetadata;
import androidx.media3.extractor.mp4.Atom;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import com.facebook.common.time.Clock;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import n.b;
import n.c;

public final class Mp4Extractor implements Extractor, SeekMap {
    @Deprecated
    public static final ExtractorsFactory B = new b();
    private MotionPhotoMetadata A;

    /* renamed from: a  reason: collision with root package name */
    private final SubtitleParser.Factory f8615a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8616b;

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f8617c;

    /* renamed from: d  reason: collision with root package name */
    private final ParsableByteArray f8618d;

    /* renamed from: e  reason: collision with root package name */
    private final ParsableByteArray f8619e;

    /* renamed from: f  reason: collision with root package name */
    private final ParsableByteArray f8620f;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayDeque<Atom.ContainerAtom> f8621g;

    /* renamed from: h  reason: collision with root package name */
    private final SefReader f8622h;

    /* renamed from: i  reason: collision with root package name */
    private final List<Metadata.Entry> f8623i;

    /* renamed from: j  reason: collision with root package name */
    private ImmutableList<SniffFailure> f8624j;

    /* renamed from: k  reason: collision with root package name */
    private int f8625k;

    /* renamed from: l  reason: collision with root package name */
    private int f8626l;

    /* renamed from: m  reason: collision with root package name */
    private long f8627m;

    /* renamed from: n  reason: collision with root package name */
    private int f8628n;

    /* renamed from: o  reason: collision with root package name */
    private ParsableByteArray f8629o;

    /* renamed from: p  reason: collision with root package name */
    private int f8630p;

    /* renamed from: q  reason: collision with root package name */
    private int f8631q;

    /* renamed from: r  reason: collision with root package name */
    private int f8632r;

    /* renamed from: s  reason: collision with root package name */
    private int f8633s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f8634t;

    /* renamed from: u  reason: collision with root package name */
    private ExtractorOutput f8635u;

    /* renamed from: v  reason: collision with root package name */
    private Mp4Track[] f8636v;

    /* renamed from: w  reason: collision with root package name */
    private long[][] f8637w;

    /* renamed from: x  reason: collision with root package name */
    private int f8638x;

    /* renamed from: y  reason: collision with root package name */
    private long f8639y;

    /* renamed from: z  reason: collision with root package name */
    private int f8640z;

    private static final class Mp4Track {

        /* renamed from: a  reason: collision with root package name */
        public final Track f8641a;

        /* renamed from: b  reason: collision with root package name */
        public final TrackSampleTable f8642b;

        /* renamed from: c  reason: collision with root package name */
        public final TrackOutput f8643c;

        /* renamed from: d  reason: collision with root package name */
        public final TrueHdSampleRechunker f8644d;

        /* renamed from: e  reason: collision with root package name */
        public int f8645e;

        public Mp4Track(Track track, TrackSampleTable trackSampleTable, TrackOutput trackOutput) {
            TrueHdSampleRechunker trueHdSampleRechunker;
            this.f8641a = track;
            this.f8642b = trackSampleTable;
            this.f8643c = trackOutput;
            if ("audio/true-hd".equals(track.f8665f.f4015n)) {
                trueHdSampleRechunker = new TrueHdSampleRechunker();
            } else {
                trueHdSampleRechunker = null;
            }
            this.f8644d = trueHdSampleRechunker;
        }
    }

    @Deprecated
    public Mp4Extractor() {
        this(SubtitleParser.Factory.f8798a, 16);
    }

    private void A() {
        Metadata metadata;
        if (this.f8640z == 2 && (this.f8616b & 2) != 0) {
            TrackOutput d2 = this.f8635u.d(0, 4);
            if (this.A == null) {
                metadata = null;
            } else {
                metadata = new Metadata(this.A);
            }
            d2.c(new Format.Builder().h0(metadata).K());
            this.f8635u.m();
            this.f8635u.r(new SeekMap.Unseekable(-9223372036854775807L));
        }
    }

    private static int B(ParsableByteArray parsableByteArray) {
        parsableByteArray.U(8);
        int o2 = o(parsableByteArray.q());
        if (o2 != 0) {
            return o2;
        }
        parsableByteArray.V(4);
        while (parsableByteArray.a() > 0) {
            int o3 = o(parsableByteArray.q());
            if (o3 != 0) {
                return o3;
            }
        }
        return 0;
    }

    private void C(Atom.ContainerAtom containerAtom) throws ParserException {
        boolean z2;
        Metadata metadata;
        Metadata metadata2;
        boolean z3;
        int i2;
        Metadata metadata3;
        int i3;
        Metadata metadata4;
        int i4;
        int i5;
        Atom.ContainerAtom containerAtom2 = containerAtom;
        ArrayList arrayList = new ArrayList();
        if (this.f8640z == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        GaplessInfoHolder gaplessInfoHolder = new GaplessInfoHolder();
        Atom.LeafAtom g2 = containerAtom2.g(1969517665);
        if (g2 != null) {
            Metadata C = AtomParsers.C(g2);
            gaplessInfoHolder.c(C);
            metadata = C;
        } else {
            metadata = null;
        }
        Atom.ContainerAtom f2 = containerAtom2.f(1835365473);
        if (f2 != null) {
            metadata2 = AtomParsers.p(f2);
        } else {
            metadata2 = null;
        }
        Metadata metadata5 = new Metadata(AtomParsers.r(((Atom.LeafAtom) Assertions.f(containerAtom2.g(1836476516))).f8528b));
        if ((this.f8616b & 1) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        long j2 = -9223372036854775807L;
        Metadata metadata6 = metadata5;
        List<TrackSampleTable> B2 = AtomParsers.B(containerAtom, gaplessInfoHolder, -9223372036854775807L, (DrmInitData) null, z3, z2, new c());
        long j3 = -9223372036854775807L;
        int i6 = 0;
        int i7 = -1;
        int i8 = 0;
        while (i6 < B2.size()) {
            TrackSampleTable trackSampleTable = B2.get(i6);
            if (trackSampleTable.f8695b == 0) {
                i2 = i8;
                metadata3 = metadata;
            } else {
                Track track = trackSampleTable.f8694a;
                metadata3 = metadata;
                Metadata metadata7 = metadata2;
                long j4 = track.f8664e;
                if (j4 == j2) {
                    j4 = trackSampleTable.f8701h;
                }
                j3 = Math.max(j3, j4);
                i2 = i8 + 1;
                Mp4Track mp4Track = new Mp4Track(track, trackSampleTable, this.f8635u.d(i8, track.f8661b));
                if ("audio/true-hd".equals(track.f8665f.f4015n)) {
                    i3 = trackSampleTable.f8698e * 16;
                } else {
                    i3 = trackSampleTable.f8698e + 30;
                }
                Format.Builder a2 = track.f8665f.a();
                a2.f0(i3);
                if (track.f8661b == 2) {
                    if ((this.f8616b & 8) != 0) {
                        int i9 = track.f8665f.f4007f;
                        if (i7 == -1) {
                            i5 = 1;
                        } else {
                            i5 = 2;
                        }
                        a2.m0(i9 | i5);
                    }
                    if (j4 > 0 && (i4 = trackSampleTable.f8695b) > 0) {
                        a2.X(((float) i4) / (((float) j4) / 1000000.0f));
                    }
                }
                MetadataUtil.k(track.f8661b, gaplessInfoHolder, a2);
                int i10 = track.f8661b;
                Metadata[] metadataArr = new Metadata[3];
                if (this.f8623i.isEmpty()) {
                    metadata4 = null;
                } else {
                    metadata4 = new Metadata((List<? extends Metadata.Entry>) this.f8623i);
                }
                metadataArr[0] = metadata4;
                metadataArr[1] = metadata3;
                metadataArr[2] = metadata6;
                metadata2 = metadata7;
                MetadataUtil.l(i10, metadata2, a2, metadataArr);
                mp4Track.f8643c.c(a2.K());
                if (track.f8661b == 2) {
                    if (i7 == -1) {
                        i7 = arrayList.size();
                    }
                }
                arrayList.add(mp4Track);
            }
            i6++;
            metadata = metadata3;
            i8 = i2;
            j2 = -9223372036854775807L;
        }
        this.f8638x = i7;
        this.f8639y = j3;
        Mp4Track[] mp4TrackArr = (Mp4Track[]) arrayList.toArray(new Mp4Track[0]);
        this.f8636v = mp4TrackArr;
        this.f8637w = p(mp4TrackArr);
        this.f8635u.m();
        this.f8635u.r(this);
    }

    private void D(long j2) {
        if (this.f8626l == 1836086884) {
            int i2 = this.f8628n;
            this.A = new MotionPhotoMetadata(0, j2, -9223372036854775807L, j2 + ((long) i2), this.f8627m - ((long) i2));
        }
    }

    private boolean E(ExtractorInput extractorInput) throws IOException {
        boolean z2;
        boolean z3;
        Atom.ContainerAtom peek;
        if (this.f8628n == 0) {
            if (!extractorInput.f(this.f8620f.e(), 0, 8, true)) {
                A();
                return false;
            }
            this.f8628n = 8;
            this.f8620f.U(0);
            this.f8627m = this.f8620f.J();
            this.f8626l = this.f8620f.q();
        }
        long j2 = this.f8627m;
        if (j2 == 1) {
            extractorInput.readFully(this.f8620f.e(), 8, 8);
            this.f8628n += 8;
            this.f8627m = this.f8620f.M();
        } else if (j2 == 0) {
            long length = extractorInput.getLength();
            if (length == -1 && (peek = this.f8621g.peek()) != null) {
                length = peek.f8525b;
            }
            if (length != -1) {
                this.f8627m = (length - extractorInput.getPosition()) + ((long) this.f8628n);
            }
        }
        if (this.f8627m >= ((long) this.f8628n)) {
            if (I(this.f8626l)) {
                long position = extractorInput.getPosition();
                long j3 = this.f8627m;
                int i2 = this.f8628n;
                long j4 = (position + j3) - ((long) i2);
                if (j3 != ((long) i2) && this.f8626l == 1835365473) {
                    y(extractorInput);
                }
                this.f8621g.push(new Atom.ContainerAtom(this.f8626l, j4));
                if (this.f8627m == ((long) this.f8628n)) {
                    z(j4);
                } else {
                    q();
                }
            } else if (J(this.f8626l)) {
                if (this.f8628n == 8) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Assertions.h(z2);
                if (this.f8627m <= 2147483647L) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Assertions.h(z3);
                ParsableByteArray parsableByteArray = new ParsableByteArray((int) this.f8627m);
                System.arraycopy(this.f8620f.e(), 0, parsableByteArray.e(), 0, 8);
                this.f8629o = parsableByteArray;
                this.f8625k = 1;
            } else {
                D(extractorInput.getPosition() - ((long) this.f8628n));
                this.f8629o = null;
                this.f8625k = 1;
            }
            return true;
        }
        throw ParserException.d("Atom size less than header length (unsupported).");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0073 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean F(androidx.media3.extractor.ExtractorInput r10, androidx.media3.extractor.PositionHolder r11) throws java.io.IOException {
        /*
            r9 = this;
            long r0 = r9.f8627m
            int r2 = r9.f8628n
            long r2 = (long) r2
            long r0 = r0 - r2
            long r2 = r10.getPosition()
            long r2 = r2 + r0
            androidx.media3.common.util.ParsableByteArray r4 = r9.f8629o
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0046
            byte[] r11 = r4.e()
            int r7 = r9.f8628n
            int r1 = (int) r0
            r10.readFully(r11, r7, r1)
            int r10 = r9.f8626l
            r11 = 1718909296(0x66747970, float:2.8862439E23)
            if (r10 != r11) goto L_0x002b
            r9.f8634t = r5
            int r10 = B(r4)
            r9.f8640z = r10
            goto L_0x005e
        L_0x002b:
            java.util.ArrayDeque<androidx.media3.extractor.mp4.Atom$ContainerAtom> r10 = r9.f8621g
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L_0x005e
            java.util.ArrayDeque<androidx.media3.extractor.mp4.Atom$ContainerAtom> r10 = r9.f8621g
            java.lang.Object r10 = r10.peek()
            androidx.media3.extractor.mp4.Atom$ContainerAtom r10 = (androidx.media3.extractor.mp4.Atom.ContainerAtom) r10
            androidx.media3.extractor.mp4.Atom$LeafAtom r11 = new androidx.media3.extractor.mp4.Atom$LeafAtom
            int r0 = r9.f8626l
            r11.<init>(r0, r4)
            r10.e(r11)
            goto L_0x005e
        L_0x0046:
            boolean r4 = r9.f8634t
            if (r4 != 0) goto L_0x0053
            int r4 = r9.f8626l
            r7 = 1835295092(0x6d646174, float:4.4175247E27)
            if (r4 != r7) goto L_0x0053
            r9.f8640z = r5
        L_0x0053:
            r7 = 262144(0x40000, double:1.295163E-318)
            int r4 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r4 >= 0) goto L_0x0060
            int r11 = (int) r0
            r10.k(r11)
        L_0x005e:
            r10 = 0
            goto L_0x0068
        L_0x0060:
            long r7 = r10.getPosition()
            long r7 = r7 + r0
            r11.f8069a = r7
            r10 = 1
        L_0x0068:
            r9.z(r2)
            if (r10 == 0) goto L_0x0073
            int r10 = r9.f8625k
            r11 = 2
            if (r10 == r11) goto L_0x0073
            goto L_0x0074
        L_0x0073:
            r5 = 0
        L_0x0074:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.Mp4Extractor.F(androidx.media3.extractor.ExtractorInput, androidx.media3.extractor.PositionHolder):boolean");
    }

    private int G(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i2;
        PositionHolder positionHolder2;
        ExtractorInput extractorInput2 = extractorInput;
        long position = extractorInput.getPosition();
        if (this.f8630p == -1) {
            int u2 = u(position);
            this.f8630p = u2;
            if (u2 == -1) {
                return -1;
            }
        }
        Mp4Track mp4Track = this.f8636v[this.f8630p];
        TrackOutput trackOutput = mp4Track.f8643c;
        int i3 = mp4Track.f8645e;
        TrackSampleTable trackSampleTable = mp4Track.f8642b;
        long j2 = trackSampleTable.f8696c[i3];
        int i4 = trackSampleTable.f8697d[i3];
        TrueHdSampleRechunker trueHdSampleRechunker = mp4Track.f8644d;
        long j3 = (j2 - position) + ((long) this.f8631q);
        if (j3 < 0) {
            i2 = 1;
            positionHolder2 = positionHolder;
        } else if (j3 >= 262144) {
            positionHolder2 = positionHolder;
            i2 = 1;
        } else {
            if (mp4Track.f8641a.f8666g == 1) {
                j3 += 8;
                i4 -= 8;
            }
            extractorInput2.k((int) j3);
            Track track = mp4Track.f8641a;
            if (track.f8669j == 0) {
                if ("audio/ac4".equals(track.f8665f.f4015n)) {
                    if (this.f8632r == 0) {
                        Ac4Util.a(i4, this.f8619e);
                        trackOutput.b(this.f8619e, 7);
                        this.f8632r += 7;
                    }
                    i4 += 7;
                } else if (trueHdSampleRechunker != null) {
                    trueHdSampleRechunker.d(extractorInput2);
                }
                while (true) {
                    int i5 = this.f8632r;
                    if (i5 >= i4) {
                        break;
                    }
                    int d2 = trackOutput.d(extractorInput2, i4 - i5, false);
                    this.f8631q += d2;
                    this.f8632r += d2;
                    this.f8633s -= d2;
                }
            } else {
                byte[] e2 = this.f8618d.e();
                e2[0] = 0;
                e2[1] = 0;
                e2[2] = 0;
                int i6 = mp4Track.f8641a.f8669j;
                int i7 = 4 - i6;
                while (this.f8632r < i4) {
                    int i8 = this.f8633s;
                    if (i8 == 0) {
                        extractorInput2.readFully(e2, i7, i6);
                        this.f8631q += i6;
                        this.f8618d.U(0);
                        int q2 = this.f8618d.q();
                        if (q2 >= 0) {
                            this.f8633s = q2;
                            this.f8617c.U(0);
                            trackOutput.b(this.f8617c, 4);
                            this.f8632r += 4;
                            i4 += i7;
                        } else {
                            throw ParserException.a("Invalid NAL length", (Throwable) null);
                        }
                    } else {
                        int d3 = trackOutput.d(extractorInput2, i8, false);
                        this.f8631q += d3;
                        this.f8632r += d3;
                        this.f8633s -= d3;
                    }
                }
            }
            int i9 = i4;
            TrackSampleTable trackSampleTable2 = mp4Track.f8642b;
            long j4 = trackSampleTable2.f8699f[i3];
            int i10 = trackSampleTable2.f8700g[i3];
            if (trueHdSampleRechunker != null) {
                int i11 = i9;
                TrueHdSampleRechunker trueHdSampleRechunker2 = trueHdSampleRechunker;
                trueHdSampleRechunker.c(trackOutput, j4, i10, i11, 0, (TrackOutput.CryptoData) null);
                if (i3 + 1 == mp4Track.f8642b.f8695b) {
                    trueHdSampleRechunker2.a(trackOutput, (TrackOutput.CryptoData) null);
                }
            } else {
                trackOutput.f(j4, i10, i9, 0, (TrackOutput.CryptoData) null);
            }
            mp4Track.f8645e++;
            this.f8630p = -1;
            this.f8631q = 0;
            this.f8632r = 0;
            this.f8633s = 0;
            return 0;
        }
        positionHolder2.f8069a = j2;
        return i2;
    }

    private int H(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int c2 = this.f8622h.c(extractorInput, positionHolder, this.f8623i);
        if (c2 == 1 && positionHolder.f8069a == 0) {
            q();
        }
        return c2;
    }

    private static boolean I(int i2) {
        return i2 == 1836019574 || i2 == 1953653099 || i2 == 1835297121 || i2 == 1835626086 || i2 == 1937007212 || i2 == 1701082227 || i2 == 1835365473;
    }

    private static boolean J(int i2) {
        return i2 == 1835296868 || i2 == 1836476516 || i2 == 1751411826 || i2 == 1937011556 || i2 == 1937011827 || i2 == 1937011571 || i2 == 1668576371 || i2 == 1701606260 || i2 == 1937011555 || i2 == 1937011578 || i2 == 1937013298 || i2 == 1937007471 || i2 == 1668232756 || i2 == 1953196132 || i2 == 1718909296 || i2 == 1969517665 || i2 == 1801812339 || i2 == 1768715124;
    }

    private void K(Mp4Track mp4Track, long j2) {
        TrackSampleTable trackSampleTable = mp4Track.f8642b;
        int a2 = trackSampleTable.a(j2);
        if (a2 == -1) {
            a2 = trackSampleTable.b(j2);
        }
        mp4Track.f8645e = a2;
    }

    private static int o(int i2) {
        if (i2 != 1751476579) {
            return i2 != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static long[][] p(Mp4Track[] mp4TrackArr) {
        long[][] jArr = new long[mp4TrackArr.length][];
        int[] iArr = new int[mp4TrackArr.length];
        long[] jArr2 = new long[mp4TrackArr.length];
        boolean[] zArr = new boolean[mp4TrackArr.length];
        for (int i2 = 0; i2 < mp4TrackArr.length; i2++) {
            jArr[i2] = new long[mp4TrackArr[i2].f8642b.f8695b];
            jArr2[i2] = mp4TrackArr[i2].f8642b.f8699f[0];
        }
        long j2 = 0;
        int i3 = 0;
        while (i3 < mp4TrackArr.length) {
            long j3 = Clock.MAX_TIME;
            int i4 = -1;
            for (int i5 = 0; i5 < mp4TrackArr.length; i5++) {
                if (!zArr[i5]) {
                    long j4 = jArr2[i5];
                    if (j4 <= j3) {
                        i4 = i5;
                        j3 = j4;
                    }
                }
            }
            int i6 = iArr[i4];
            long[] jArr3 = jArr[i4];
            jArr3[i6] = j2;
            TrackSampleTable trackSampleTable = mp4TrackArr[i4].f8642b;
            j2 += (long) trackSampleTable.f8697d[i6];
            int i7 = i6 + 1;
            iArr[i4] = i7;
            if (i7 < jArr3.length) {
                jArr2[i4] = trackSampleTable.f8699f[i7];
            } else {
                zArr[i4] = true;
                i3++;
            }
        }
        return jArr;
    }

    private void q() {
        this.f8625k = 0;
        this.f8628n = 0;
    }

    private static int t(TrackSampleTable trackSampleTable, long j2) {
        int a2 = trackSampleTable.a(j2);
        if (a2 == -1) {
            return trackSampleTable.b(j2);
        }
        return a2;
    }

    private int u(long j2) {
        boolean z2;
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        long j3 = Clock.MAX_TIME;
        boolean z3 = true;
        long j4 = Clock.MAX_TIME;
        boolean z4 = true;
        long j5 = Clock.MAX_TIME;
        while (true) {
            Mp4Track[] mp4TrackArr = this.f8636v;
            if (i4 >= mp4TrackArr.length) {
                break;
            }
            Mp4Track mp4Track = mp4TrackArr[i4];
            int i5 = mp4Track.f8645e;
            TrackSampleTable trackSampleTable = mp4Track.f8642b;
            if (i5 != trackSampleTable.f8695b) {
                long j6 = trackSampleTable.f8696c[i5];
                long j7 = ((long[][]) Util.i(this.f8637w))[i4][i5];
                long j8 = j6 - j2;
                if (j8 < 0 || j8 >= 262144) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if ((!z2 && z4) || (z2 == z4 && j8 < j5)) {
                    z4 = z2;
                    j5 = j8;
                    i3 = i4;
                    j4 = j7;
                }
                if (j7 < j3) {
                    z3 = z2;
                    i2 = i4;
                    j3 = j7;
                }
            }
            i4++;
        }
        if (j3 == Clock.MAX_TIME || !z3 || j4 < j3 + 10485760) {
            return i3;
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Track v(Track track) {
        return track;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] w() {
        return new Extractor[]{new Mp4Extractor(SubtitleParser.Factory.f8798a, 16)};
    }

    private static long x(TrackSampleTable trackSampleTable, long j2, long j3) {
        int t2 = t(trackSampleTable, j2);
        if (t2 == -1) {
            return j3;
        }
        return Math.min(trackSampleTable.f8696c[t2], j3);
    }

    private void y(ExtractorInput extractorInput) throws IOException {
        this.f8619e.Q(8);
        extractorInput.m(this.f8619e.e(), 0, 8);
        AtomParsers.f(this.f8619e);
        extractorInput.k(this.f8619e.f());
        extractorInput.e();
    }

    private void z(long j2) throws ParserException {
        while (!this.f8621g.isEmpty() && this.f8621g.peek().f8525b == j2) {
            Atom.ContainerAtom pop = this.f8621g.pop();
            if (pop.f8524a == 1836019574) {
                C(pop);
                this.f8621g.clear();
                this.f8625k = 2;
            } else if (!this.f8621g.isEmpty()) {
                this.f8621g.peek().d(pop);
            }
        }
        if (this.f8625k != 2) {
            q();
        }
    }

    public void a(long j2, long j3) {
        this.f8621g.clear();
        this.f8628n = 0;
        this.f8630p = -1;
        this.f8631q = 0;
        this.f8632r = 0;
        this.f8633s = 0;
        if (j2 != 0) {
            for (Mp4Track mp4Track : this.f8636v) {
                K(mp4Track, j3);
                TrueHdSampleRechunker trueHdSampleRechunker = mp4Track.f8644d;
                if (trueHdSampleRechunker != null) {
                    trueHdSampleRechunker.b();
                }
            }
        } else if (this.f8625k != 3) {
            q();
        } else {
            this.f8622h.g();
            this.f8623i.clear();
        }
    }

    public /* synthetic */ Extractor c() {
        return d.b(this);
    }

    public SeekMap.SeekPoints d(long j2) {
        return r(j2, -1);
    }

    public boolean f() {
        return true;
    }

    public void g(ExtractorOutput extractorOutput) {
        if ((this.f8616b & 16) == 0) {
            extractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.f8615a);
        }
        this.f8635u = extractorOutput;
    }

    public long h() {
        return this.f8639y;
    }

    public boolean i(ExtractorInput extractorInput) throws IOException {
        boolean z2;
        ImmutableList<SniffFailure> immutableList;
        if ((this.f8616b & 2) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        SniffFailure d2 = Sniffer.d(extractorInput, z2);
        if (d2 != null) {
            immutableList = ImmutableList.s(d2);
        } else {
            immutableList = ImmutableList.r();
        }
        this.f8624j = immutableList;
        if (d2 == null) {
            return true;
        }
        return false;
    }

    public int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        while (true) {
            int i2 = this.f8625k;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        return G(extractorInput, positionHolder);
                    }
                    if (i2 == 3) {
                        return H(extractorInput, positionHolder);
                    }
                    throw new IllegalStateException();
                } else if (F(extractorInput, positionHolder)) {
                    return 1;
                }
            } else if (!E(extractorInput)) {
                return -1;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.media3.extractor.SeekMap.SeekPoints r(long r17, int r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r19
            androidx.media3.extractor.mp4.Mp4Extractor$Mp4Track[] r4 = r0.f8636v
            int r5 = r4.length
            if (r5 != 0) goto L_0x0013
            androidx.media3.extractor.SeekMap$SeekPoints r1 = new androidx.media3.extractor.SeekMap$SeekPoints
            androidx.media3.extractor.SeekPoint r2 = androidx.media3.extractor.SeekPoint.f8074c
            r1.<init>(r2)
            return r1
        L_0x0013:
            r5 = -1
            if (r3 == r5) goto L_0x0018
            r6 = r3
            goto L_0x001a
        L_0x0018:
            int r6 = r0.f8638x
        L_0x001a:
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9 = -1
            if (r6 == r5) goto L_0x0058
            r4 = r4[r6]
            androidx.media3.extractor.mp4.TrackSampleTable r4 = r4.f8642b
            int r6 = t(r4, r1)
            if (r6 != r5) goto L_0x0035
            androidx.media3.extractor.SeekMap$SeekPoints r1 = new androidx.media3.extractor.SeekMap$SeekPoints
            androidx.media3.extractor.SeekPoint r2 = androidx.media3.extractor.SeekPoint.f8074c
            r1.<init>(r2)
            return r1
        L_0x0035:
            long[] r11 = r4.f8699f
            r12 = r11[r6]
            long[] r11 = r4.f8696c
            r14 = r11[r6]
            int r11 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r11 >= 0) goto L_0x005e
            int r11 = r4.f8695b
            int r11 = r11 + -1
            if (r6 >= r11) goto L_0x005e
            int r1 = r4.b(r1)
            if (r1 == r5) goto L_0x005e
            if (r1 == r6) goto L_0x005e
            long[] r2 = r4.f8699f
            r9 = r2[r1]
            long[] r2 = r4.f8696c
            r1 = r2[r1]
            goto L_0x0060
        L_0x0058:
            r14 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r12 = r1
        L_0x005e:
            r1 = r9
            r9 = r7
        L_0x0060:
            if (r3 != r5) goto L_0x007f
            r3 = 0
        L_0x0063:
            androidx.media3.extractor.mp4.Mp4Extractor$Mp4Track[] r4 = r0.f8636v
            int r5 = r4.length
            if (r3 >= r5) goto L_0x007f
            int r5 = r0.f8638x
            if (r3 == r5) goto L_0x007c
            r4 = r4[r3]
            androidx.media3.extractor.mp4.TrackSampleTable r4 = r4.f8642b
            long r14 = x(r4, r12, r14)
            int r5 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r5 == 0) goto L_0x007c
            long r1 = x(r4, r9, r1)
        L_0x007c:
            int r3 = r3 + 1
            goto L_0x0063
        L_0x007f:
            androidx.media3.extractor.SeekPoint r3 = new androidx.media3.extractor.SeekPoint
            r3.<init>(r12, r14)
            int r4 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r4 != 0) goto L_0x008e
            androidx.media3.extractor.SeekMap$SeekPoints r1 = new androidx.media3.extractor.SeekMap$SeekPoints
            r1.<init>(r3)
            return r1
        L_0x008e:
            androidx.media3.extractor.SeekPoint r4 = new androidx.media3.extractor.SeekPoint
            r4.<init>(r9, r1)
            androidx.media3.extractor.SeekMap$SeekPoints r1 = new androidx.media3.extractor.SeekMap$SeekPoints
            r1.<init>(r3, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.Mp4Extractor.r(long, int):androidx.media3.extractor.SeekMap$SeekPoints");
    }

    public void release() {
    }

    /* renamed from: s */
    public ImmutableList<SniffFailure> j() {
        return this.f8624j;
    }

    public Mp4Extractor(SubtitleParser.Factory factory, int i2) {
        this.f8615a = factory;
        this.f8616b = i2;
        this.f8624j = ImmutableList.r();
        this.f8625k = (i2 & 4) != 0 ? 3 : 0;
        this.f8622h = new SefReader();
        this.f8623i = new ArrayList();
        this.f8620f = new ParsableByteArray(16);
        this.f8621g = new ArrayDeque<>();
        this.f8617c = new ParsableByteArray(NalUnitUtil.f4748a);
        this.f8618d = new ParsableByteArray(4);
        this.f8619e = new ParsableByteArray();
        this.f8630p = -1;
        this.f8635u = ExtractorOutput.f8013y0;
        this.f8636v = new Mp4Track[0];
    }
}
