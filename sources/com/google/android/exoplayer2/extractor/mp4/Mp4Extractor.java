package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.TrueHdSampleRechunker;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import m0.b;
import m0.c;

public final class Mp4Extractor implements Extractor, SeekMap {

    /* renamed from: y  reason: collision with root package name */
    public static final ExtractorsFactory f24617y = new b();

    /* renamed from: a  reason: collision with root package name */
    private final int f24618a;

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f24619b;

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f24620c;

    /* renamed from: d  reason: collision with root package name */
    private final ParsableByteArray f24621d;

    /* renamed from: e  reason: collision with root package name */
    private final ParsableByteArray f24622e;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayDeque<Atom.ContainerAtom> f24623f;

    /* renamed from: g  reason: collision with root package name */
    private final SefReader f24624g;

    /* renamed from: h  reason: collision with root package name */
    private final List<Metadata.Entry> f24625h;

    /* renamed from: i  reason: collision with root package name */
    private int f24626i;

    /* renamed from: j  reason: collision with root package name */
    private int f24627j;

    /* renamed from: k  reason: collision with root package name */
    private long f24628k;

    /* renamed from: l  reason: collision with root package name */
    private int f24629l;

    /* renamed from: m  reason: collision with root package name */
    private ParsableByteArray f24630m;

    /* renamed from: n  reason: collision with root package name */
    private int f24631n;

    /* renamed from: o  reason: collision with root package name */
    private int f24632o;

    /* renamed from: p  reason: collision with root package name */
    private int f24633p;

    /* renamed from: q  reason: collision with root package name */
    private int f24634q;

    /* renamed from: r  reason: collision with root package name */
    private ExtractorOutput f24635r;

    /* renamed from: s  reason: collision with root package name */
    private Mp4Track[] f24636s;

    /* renamed from: t  reason: collision with root package name */
    private long[][] f24637t;

    /* renamed from: u  reason: collision with root package name */
    private int f24638u;

    /* renamed from: v  reason: collision with root package name */
    private long f24639v;

    /* renamed from: w  reason: collision with root package name */
    private int f24640w;

    /* renamed from: x  reason: collision with root package name */
    private MotionPhotoMetadata f24641x;

    private static final class Mp4Track {

        /* renamed from: a  reason: collision with root package name */
        public final Track f24642a;

        /* renamed from: b  reason: collision with root package name */
        public final TrackSampleTable f24643b;

        /* renamed from: c  reason: collision with root package name */
        public final TrackOutput f24644c;

        /* renamed from: d  reason: collision with root package name */
        public final TrueHdSampleRechunker f24645d;

        /* renamed from: e  reason: collision with root package name */
        public int f24646e;

        public Mp4Track(Track track, TrackSampleTable trackSampleTable, TrackOutput trackOutput) {
            TrueHdSampleRechunker trueHdSampleRechunker;
            this.f24642a = track;
            this.f24643b = trackSampleTable;
            this.f24644c = trackOutput;
            if ("audio/true-hd".equals(track.f24664f.f23071m)) {
                trueHdSampleRechunker = new TrueHdSampleRechunker();
            } else {
                trueHdSampleRechunker = null;
            }
            this.f24645d = trueHdSampleRechunker;
        }
    }

    public Mp4Extractor() {
        this(0);
    }

    private boolean A(ExtractorInput extractorInput) throws IOException {
        boolean z2;
        boolean z3;
        Atom.ContainerAtom peek;
        if (this.f24629l == 0) {
            if (!extractorInput.f(this.f24622e.e(), 0, 8, true)) {
                w();
                return false;
            }
            this.f24629l = 8;
            this.f24622e.U(0);
            this.f24628k = this.f24622e.J();
            this.f24627j = this.f24622e.q();
        }
        long j2 = this.f24628k;
        if (j2 == 1) {
            extractorInput.readFully(this.f24622e.e(), 8, 8);
            this.f24629l += 8;
            this.f24628k = this.f24622e.M();
        } else if (j2 == 0) {
            long length = extractorInput.getLength();
            if (length == -1 && (peek = this.f24623f.peek()) != null) {
                length = peek.f24532b;
            }
            if (length != -1) {
                this.f24628k = (length - extractorInput.getPosition()) + ((long) this.f24629l);
            }
        }
        if (this.f24628k >= ((long) this.f24629l)) {
            if (E(this.f24627j)) {
                long position = extractorInput.getPosition();
                long j3 = this.f24628k;
                int i2 = this.f24629l;
                long j4 = (position + j3) - ((long) i2);
                if (j3 != ((long) i2) && this.f24627j == 1835365473) {
                    u(extractorInput);
                }
                this.f24623f.push(new Atom.ContainerAtom(this.f24627j, j4));
                if (this.f24628k == ((long) this.f24629l)) {
                    v(j4);
                } else {
                    n();
                }
            } else if (F(this.f24627j)) {
                if (this.f24629l == 8) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Assertions.g(z2);
                if (this.f24628k <= 2147483647L) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Assertions.g(z3);
                ParsableByteArray parsableByteArray = new ParsableByteArray((int) this.f24628k);
                System.arraycopy(this.f24622e.e(), 0, parsableByteArray.e(), 0, 8);
                this.f24630m = parsableByteArray;
                this.f24626i = 1;
            } else {
                z(extractorInput.getPosition() - ((long) this.f24629l));
                this.f24630m = null;
                this.f24626i = 1;
            }
            return true;
        }
        throw ParserException.e("Atom size less than header length (unsupported).");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0064 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean B(com.google.android.exoplayer2.extractor.ExtractorInput r10, com.google.android.exoplayer2.extractor.PositionHolder r11) throws java.io.IOException {
        /*
            r9 = this;
            long r0 = r9.f24628k
            int r2 = r9.f24629l
            long r2 = (long) r2
            long r0 = r0 - r2
            long r2 = r10.getPosition()
            long r2 = r2 + r0
            com.google.android.exoplayer2.util.ParsableByteArray r4 = r9.f24630m
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0044
            byte[] r11 = r4.e()
            int r7 = r9.f24629l
            int r1 = (int) r0
            r10.readFully(r11, r7, r1)
            int r10 = r9.f24627j
            r11 = 1718909296(0x66747970, float:2.8862439E23)
            if (r10 != r11) goto L_0x0029
            int r10 = x(r4)
            r9.f24640w = r10
            goto L_0x004f
        L_0x0029:
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.Atom$ContainerAtom> r10 = r9.f24623f
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L_0x004f
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.Atom$ContainerAtom> r10 = r9.f24623f
            java.lang.Object r10 = r10.peek()
            com.google.android.exoplayer2.extractor.mp4.Atom$ContainerAtom r10 = (com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom) r10
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r11 = new com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom
            int r0 = r9.f24627j
            r11.<init>(r0, r4)
            r10.e(r11)
            goto L_0x004f
        L_0x0044:
            r7 = 262144(0x40000, double:1.295163E-318)
            int r4 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r4 >= 0) goto L_0x0051
            int r11 = (int) r0
            r10.k(r11)
        L_0x004f:
            r10 = 0
            goto L_0x0059
        L_0x0051:
            long r7 = r10.getPosition()
            long r7 = r7 + r0
            r11.f24231a = r7
            r10 = 1
        L_0x0059:
            r9.v(r2)
            if (r10 == 0) goto L_0x0064
            int r10 = r9.f24626i
            r11 = 2
            if (r10 == r11) goto L_0x0064
            goto L_0x0065
        L_0x0064:
            r5 = 0
        L_0x0065:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.B(com.google.android.exoplayer2.extractor.ExtractorInput, com.google.android.exoplayer2.extractor.PositionHolder):boolean");
    }

    private int C(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i2;
        PositionHolder positionHolder2;
        ExtractorInput extractorInput2 = extractorInput;
        long position = extractorInput.getPosition();
        if (this.f24631n == -1) {
            int q2 = q(position);
            this.f24631n = q2;
            if (q2 == -1) {
                return -1;
            }
        }
        Mp4Track mp4Track = this.f24636s[this.f24631n];
        TrackOutput trackOutput = mp4Track.f24644c;
        int i3 = mp4Track.f24646e;
        TrackSampleTable trackSampleTable = mp4Track.f24643b;
        long j2 = trackSampleTable.f24695c[i3];
        int i4 = trackSampleTable.f24696d[i3];
        TrueHdSampleRechunker trueHdSampleRechunker = mp4Track.f24645d;
        long j3 = (j2 - position) + ((long) this.f24632o);
        if (j3 < 0) {
            i2 = 1;
            positionHolder2 = positionHolder;
        } else if (j3 >= 262144) {
            positionHolder2 = positionHolder;
            i2 = 1;
        } else {
            if (mp4Track.f24642a.f24665g == 1) {
                j3 += 8;
                i4 -= 8;
            }
            extractorInput2.k((int) j3);
            Track track = mp4Track.f24642a;
            if (track.f24668j == 0) {
                if ("audio/ac4".equals(track.f24664f.f23071m)) {
                    if (this.f24633p == 0) {
                        Ac4Util.a(i4, this.f24621d);
                        trackOutput.c(this.f24621d, 7);
                        this.f24633p += 7;
                    }
                    i4 += 7;
                } else if (trueHdSampleRechunker != null) {
                    trueHdSampleRechunker.d(extractorInput2);
                }
                while (true) {
                    int i5 = this.f24633p;
                    if (i5 >= i4) {
                        break;
                    }
                    int b2 = trackOutput.b(extractorInput2, i4 - i5, false);
                    this.f24632o += b2;
                    this.f24633p += b2;
                    this.f24634q -= b2;
                }
            } else {
                byte[] e2 = this.f24620c.e();
                e2[0] = 0;
                e2[1] = 0;
                e2[2] = 0;
                int i6 = mp4Track.f24642a.f24668j;
                int i7 = 4 - i6;
                while (this.f24633p < i4) {
                    int i8 = this.f24634q;
                    if (i8 == 0) {
                        extractorInput2.readFully(e2, i7, i6);
                        this.f24632o += i6;
                        this.f24620c.U(0);
                        int q3 = this.f24620c.q();
                        if (q3 >= 0) {
                            this.f24634q = q3;
                            this.f24619b.U(0);
                            trackOutput.c(this.f24619b, 4);
                            this.f24633p += 4;
                            i4 += i7;
                        } else {
                            throw ParserException.a("Invalid NAL length", (Throwable) null);
                        }
                    } else {
                        int b3 = trackOutput.b(extractorInput2, i8, false);
                        this.f24632o += b3;
                        this.f24633p += b3;
                        this.f24634q -= b3;
                    }
                }
            }
            int i9 = i4;
            TrackSampleTable trackSampleTable2 = mp4Track.f24643b;
            long j4 = trackSampleTable2.f24698f[i3];
            int i10 = trackSampleTable2.f24699g[i3];
            if (trueHdSampleRechunker != null) {
                int i11 = i9;
                TrueHdSampleRechunker trueHdSampleRechunker2 = trueHdSampleRechunker;
                trueHdSampleRechunker.c(trackOutput, j4, i10, i11, 0, (TrackOutput.CryptoData) null);
                if (i3 + 1 == mp4Track.f24643b.f24694b) {
                    trueHdSampleRechunker2.a(trackOutput, (TrackOutput.CryptoData) null);
                }
            } else {
                trackOutput.e(j4, i10, i9, 0, (TrackOutput.CryptoData) null);
            }
            mp4Track.f24646e++;
            this.f24631n = -1;
            this.f24632o = 0;
            this.f24633p = 0;
            this.f24634q = 0;
            return 0;
        }
        positionHolder2.f24231a = j2;
        return i2;
    }

    private int D(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int c2 = this.f24624g.c(extractorInput, positionHolder, this.f24625h);
        if (c2 == 1 && positionHolder.f24231a == 0) {
            n();
        }
        return c2;
    }

    private static boolean E(int i2) {
        return i2 == 1836019574 || i2 == 1953653099 || i2 == 1835297121 || i2 == 1835626086 || i2 == 1937007212 || i2 == 1701082227 || i2 == 1835365473;
    }

    private static boolean F(int i2) {
        return i2 == 1835296868 || i2 == 1836476516 || i2 == 1751411826 || i2 == 1937011556 || i2 == 1937011827 || i2 == 1937011571 || i2 == 1668576371 || i2 == 1701606260 || i2 == 1937011555 || i2 == 1937011578 || i2 == 1937013298 || i2 == 1937007471 || i2 == 1668232756 || i2 == 1953196132 || i2 == 1718909296 || i2 == 1969517665 || i2 == 1801812339 || i2 == 1768715124;
    }

    private void G(Mp4Track mp4Track, long j2) {
        TrackSampleTable trackSampleTable = mp4Track.f24643b;
        int a2 = trackSampleTable.a(j2);
        if (a2 == -1) {
            a2 = trackSampleTable.b(j2);
        }
        mp4Track.f24646e = a2;
    }

    private static int l(int i2) {
        if (i2 != 1751476579) {
            return i2 != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static long[][] m(Mp4Track[] mp4TrackArr) {
        long[][] jArr = new long[mp4TrackArr.length][];
        int[] iArr = new int[mp4TrackArr.length];
        long[] jArr2 = new long[mp4TrackArr.length];
        boolean[] zArr = new boolean[mp4TrackArr.length];
        for (int i2 = 0; i2 < mp4TrackArr.length; i2++) {
            jArr[i2] = new long[mp4TrackArr[i2].f24643b.f24694b];
            jArr2[i2] = mp4TrackArr[i2].f24643b.f24698f[0];
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
            TrackSampleTable trackSampleTable = mp4TrackArr[i4].f24643b;
            j2 += (long) trackSampleTable.f24696d[i6];
            int i7 = i6 + 1;
            iArr[i4] = i7;
            if (i7 < jArr3.length) {
                jArr2[i4] = trackSampleTable.f24698f[i7];
            } else {
                zArr[i4] = true;
                i3++;
            }
        }
        return jArr;
    }

    private void n() {
        this.f24626i = 0;
        this.f24629l = 0;
    }

    private static int p(TrackSampleTable trackSampleTable, long j2) {
        int a2 = trackSampleTable.a(j2);
        if (a2 == -1) {
            return trackSampleTable.b(j2);
        }
        return a2;
    }

    private int q(long j2) {
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
            Mp4Track[] mp4TrackArr = this.f24636s;
            if (i4 >= mp4TrackArr.length) {
                break;
            }
            Mp4Track mp4Track = mp4TrackArr[i4];
            int i5 = mp4Track.f24646e;
            TrackSampleTable trackSampleTable = mp4Track.f24643b;
            if (i5 != trackSampleTable.f24694b) {
                long j6 = trackSampleTable.f24695c[i5];
                long j7 = ((long[][]) Util.j(this.f24637t))[i4][i5];
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
    public static /* synthetic */ Track r(Track track) {
        return track;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] s() {
        return new Extractor[]{new Mp4Extractor()};
    }

    private static long t(TrackSampleTable trackSampleTable, long j2, long j3) {
        int p2 = p(trackSampleTable, j2);
        if (p2 == -1) {
            return j3;
        }
        return Math.min(trackSampleTable.f24695c[p2], j3);
    }

    private void u(ExtractorInput extractorInput) throws IOException {
        this.f24621d.Q(8);
        extractorInput.m(this.f24621d.e(), 0, 8);
        AtomParsers.e(this.f24621d);
        extractorInput.k(this.f24621d.f());
        extractorInput.e();
    }

    private void v(long j2) throws ParserException {
        while (!this.f24623f.isEmpty() && this.f24623f.peek().f24532b == j2) {
            Atom.ContainerAtom pop = this.f24623f.pop();
            if (pop.f24531a == 1836019574) {
                y(pop);
                this.f24623f.clear();
                this.f24626i = 2;
            } else if (!this.f24623f.isEmpty()) {
                this.f24623f.peek().d(pop);
            }
        }
        if (this.f24626i != 2) {
            n();
        }
    }

    private void w() {
        Metadata metadata;
        if (this.f24640w == 2 && (this.f24618a & 2) != 0) {
            TrackOutput d2 = this.f24635r.d(0, 4);
            if (this.f24641x == null) {
                metadata = null;
            } else {
                metadata = new Metadata(this.f24641x);
            }
            d2.d(new Format.Builder().Z(metadata).G());
            this.f24635r.m();
            this.f24635r.u(new SeekMap.Unseekable(-9223372036854775807L));
        }
    }

    private static int x(ParsableByteArray parsableByteArray) {
        parsableByteArray.U(8);
        int l2 = l(parsableByteArray.q());
        if (l2 != 0) {
            return l2;
        }
        parsableByteArray.V(4);
        while (parsableByteArray.a() > 0) {
            int l3 = l(parsableByteArray.q());
            if (l3 != 0) {
                return l3;
            }
        }
        return 0;
    }

    private void y(Atom.ContainerAtom containerAtom) throws ParserException {
        boolean z2;
        Metadata metadata;
        Metadata metadata2;
        Metadata metadata3;
        boolean z3;
        int i2;
        List<TrackSampleTable> list;
        int i3;
        Metadata metadata4;
        int i4;
        Atom.ContainerAtom containerAtom2 = containerAtom;
        ArrayList arrayList = new ArrayList();
        if (this.f24640w == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        GaplessInfoHolder gaplessInfoHolder = new GaplessInfoHolder();
        Atom.LeafAtom g2 = containerAtom2.g(1969517665);
        if (g2 != null) {
            Pair<Metadata, Metadata> B = AtomParsers.B(g2);
            Metadata metadata5 = (Metadata) B.first;
            Metadata metadata6 = (Metadata) B.second;
            if (metadata5 != null) {
                gaplessInfoHolder.c(metadata5);
            }
            metadata2 = metadata6;
            metadata = metadata5;
        } else {
            metadata2 = null;
            metadata = null;
        }
        Atom.ContainerAtom f2 = containerAtom2.f(1835365473);
        if (f2 != null) {
            metadata3 = AtomParsers.n(f2);
        } else {
            metadata3 = null;
        }
        if ((this.f24618a & 1) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Metadata metadata7 = metadata3;
        List<TrackSampleTable> A = AtomParsers.A(containerAtom, gaplessInfoHolder, -9223372036854775807L, (DrmInitData) null, z3, z2, new c());
        int size = A.size();
        long j2 = -9223372036854775807L;
        long j3 = -9223372036854775807L;
        int i5 = 0;
        int i6 = -1;
        while (i5 < size) {
            TrackSampleTable trackSampleTable = A.get(i5);
            if (trackSampleTable.f24694b == 0) {
                list = A;
                i2 = size;
            } else {
                Track track = trackSampleTable.f24693a;
                list = A;
                i2 = size;
                long j4 = track.f24663e;
                if (j4 == j2) {
                    j4 = trackSampleTable.f24700h;
                }
                long max = Math.max(j3, j4);
                Mp4Track mp4Track = new Mp4Track(track, trackSampleTable, this.f24635r.d(i5, track.f24660b));
                if ("audio/true-hd".equals(track.f24664f.f23071m)) {
                    i3 = trackSampleTable.f24697e * 16;
                } else {
                    i3 = trackSampleTable.f24697e + 30;
                }
                Format.Builder b2 = track.f24664f.b();
                b2.Y(i3);
                if (track.f24660b == 2 && j4 > 0 && (i4 = trackSampleTable.f24694b) > 1) {
                    b2.R(((float) i4) / (((float) j4) / 1000000.0f));
                }
                MetadataUtil.k(track.f24660b, gaplessInfoHolder, b2);
                int i7 = track.f24660b;
                Metadata[] metadataArr = new Metadata[2];
                metadataArr[0] = metadata2;
                if (this.f24625h.isEmpty()) {
                    metadata4 = null;
                } else {
                    metadata4 = new Metadata((List<? extends Metadata.Entry>) this.f24625h);
                }
                metadataArr[1] = metadata4;
                MetadataUtil.l(i7, metadata, metadata7, b2, metadataArr);
                mp4Track.f24644c.d(b2.G());
                if (track.f24660b == 2) {
                    if (i6 == -1) {
                        i6 = arrayList.size();
                    }
                }
                arrayList.add(mp4Track);
                j3 = max;
            }
            i5++;
            A = list;
            size = i2;
            j2 = -9223372036854775807L;
        }
        this.f24638u = i6;
        this.f24639v = j3;
        Mp4Track[] mp4TrackArr = (Mp4Track[]) arrayList.toArray(new Mp4Track[0]);
        this.f24636s = mp4TrackArr;
        this.f24637t = m(mp4TrackArr);
        this.f24635r.m();
        this.f24635r.u(this);
    }

    private void z(long j2) {
        if (this.f24627j == 1836086884) {
            int i2 = this.f24629l;
            this.f24641x = new MotionPhotoMetadata(0, j2, -9223372036854775807L, j2 + ((long) i2), this.f24628k - ((long) i2));
        }
    }

    public void a(long j2, long j3) {
        this.f24623f.clear();
        this.f24629l = 0;
        this.f24631n = -1;
        this.f24632o = 0;
        this.f24633p = 0;
        this.f24634q = 0;
        if (j2 != 0) {
            for (Mp4Track mp4Track : this.f24636s) {
                G(mp4Track, j3);
                TrueHdSampleRechunker trueHdSampleRechunker = mp4Track.f24645d;
                if (trueHdSampleRechunker != null) {
                    trueHdSampleRechunker.b();
                }
            }
        } else if (this.f24626i != 3) {
            n();
        } else {
            this.f24624g.g();
            this.f24625h.clear();
        }
    }

    public void c(ExtractorOutput extractorOutput) {
        this.f24635r = extractorOutput;
    }

    public SeekMap.SeekPoints d(long j2) {
        return o(j2, -1);
    }

    public boolean f() {
        return true;
    }

    public boolean g(ExtractorInput extractorInput) throws IOException {
        return Sniffer.d(extractorInput, (this.f24618a & 2) != 0);
    }

    public long h() {
        return this.f24639v;
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        while (true) {
            int i2 = this.f24626i;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        return C(extractorInput, positionHolder);
                    }
                    if (i2 == 3) {
                        return D(extractorInput, positionHolder);
                    }
                    throw new IllegalStateException();
                } else if (B(extractorInput, positionHolder)) {
                    return 1;
                }
            } else if (!A(extractorInput)) {
                return -1;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints o(long r17, int r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r19
            com.google.android.exoplayer2.extractor.mp4.Mp4Extractor$Mp4Track[] r4 = r0.f24636s
            int r5 = r4.length
            if (r5 != 0) goto L_0x0013
            com.google.android.exoplayer2.extractor.SeekMap$SeekPoints r1 = new com.google.android.exoplayer2.extractor.SeekMap$SeekPoints
            com.google.android.exoplayer2.extractor.SeekPoint r2 = com.google.android.exoplayer2.extractor.SeekPoint.f24236c
            r1.<init>(r2)
            return r1
        L_0x0013:
            r5 = -1
            if (r3 == r5) goto L_0x0018
            r6 = r3
            goto L_0x001a
        L_0x0018:
            int r6 = r0.f24638u
        L_0x001a:
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9 = -1
            if (r6 == r5) goto L_0x0058
            r4 = r4[r6]
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r4 = r4.f24643b
            int r6 = p(r4, r1)
            if (r6 != r5) goto L_0x0035
            com.google.android.exoplayer2.extractor.SeekMap$SeekPoints r1 = new com.google.android.exoplayer2.extractor.SeekMap$SeekPoints
            com.google.android.exoplayer2.extractor.SeekPoint r2 = com.google.android.exoplayer2.extractor.SeekPoint.f24236c
            r1.<init>(r2)
            return r1
        L_0x0035:
            long[] r11 = r4.f24698f
            r12 = r11[r6]
            long[] r11 = r4.f24695c
            r14 = r11[r6]
            int r11 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r11 >= 0) goto L_0x005e
            int r11 = r4.f24694b
            int r11 = r11 + -1
            if (r6 >= r11) goto L_0x005e
            int r1 = r4.b(r1)
            if (r1 == r5) goto L_0x005e
            if (r1 == r6) goto L_0x005e
            long[] r2 = r4.f24698f
            r9 = r2[r1]
            long[] r2 = r4.f24695c
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
            com.google.android.exoplayer2.extractor.mp4.Mp4Extractor$Mp4Track[] r4 = r0.f24636s
            int r5 = r4.length
            if (r3 >= r5) goto L_0x007f
            int r5 = r0.f24638u
            if (r3 == r5) goto L_0x007c
            r4 = r4[r3]
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r4 = r4.f24643b
            long r14 = t(r4, r12, r14)
            int r5 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r5 == 0) goto L_0x007c
            long r1 = t(r4, r9, r1)
        L_0x007c:
            int r3 = r3 + 1
            goto L_0x0063
        L_0x007f:
            com.google.android.exoplayer2.extractor.SeekPoint r3 = new com.google.android.exoplayer2.extractor.SeekPoint
            r3.<init>(r12, r14)
            int r4 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r4 != 0) goto L_0x008e
            com.google.android.exoplayer2.extractor.SeekMap$SeekPoints r1 = new com.google.android.exoplayer2.extractor.SeekMap$SeekPoints
            r1.<init>(r3)
            return r1
        L_0x008e:
            com.google.android.exoplayer2.extractor.SeekPoint r4 = new com.google.android.exoplayer2.extractor.SeekPoint
            r4.<init>(r9, r1)
            com.google.android.exoplayer2.extractor.SeekMap$SeekPoints r1 = new com.google.android.exoplayer2.extractor.SeekMap$SeekPoints
            r1.<init>(r3, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.o(long, int):com.google.android.exoplayer2.extractor.SeekMap$SeekPoints");
    }

    public void release() {
    }

    public Mp4Extractor(int i2) {
        this.f24618a = i2;
        this.f24626i = (i2 & 4) != 0 ? 3 : 0;
        this.f24624g = new SefReader();
        this.f24625h = new ArrayList();
        this.f24622e = new ParsableByteArray(16);
        this.f24623f = new ArrayDeque<>();
        this.f24619b = new ParsableByteArray(NalUnitUtil.f28716a);
        this.f24620c = new ParsableByteArray(4);
        this.f24621d = new ParsableByteArray();
        this.f24631n = -1;
        this.f24635r = ExtractorOutput.f24202z0;
        this.f24636s = new Mp4Track[0];
    }
}
