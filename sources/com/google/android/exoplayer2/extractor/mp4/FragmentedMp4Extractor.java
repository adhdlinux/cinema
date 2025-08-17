package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import android.util.SparseArray;
import com.facebook.common.time.Clock;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.CeaUtil;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.unity3d.services.core.device.MimeTypes;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import m0.a;

public class FragmentedMp4Extractor implements Extractor {
    public static final ExtractorsFactory I = new a();
    private static final byte[] J = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final Format K = new Format.Builder().g0("application/x-emsg").G();
    private int A;
    private int B;
    private int C;
    private boolean D;
    private ExtractorOutput E;
    private TrackOutput[] F;
    private TrackOutput[] G;
    private boolean H;

    /* renamed from: a  reason: collision with root package name */
    private final int f24575a;

    /* renamed from: b  reason: collision with root package name */
    private final Track f24576b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Format> f24577c;

    /* renamed from: d  reason: collision with root package name */
    private final SparseArray<TrackBundle> f24578d;

    /* renamed from: e  reason: collision with root package name */
    private final ParsableByteArray f24579e;

    /* renamed from: f  reason: collision with root package name */
    private final ParsableByteArray f24580f;

    /* renamed from: g  reason: collision with root package name */
    private final ParsableByteArray f24581g;

    /* renamed from: h  reason: collision with root package name */
    private final byte[] f24582h;

    /* renamed from: i  reason: collision with root package name */
    private final ParsableByteArray f24583i;

    /* renamed from: j  reason: collision with root package name */
    private final TimestampAdjuster f24584j;

    /* renamed from: k  reason: collision with root package name */
    private final EventMessageEncoder f24585k;

    /* renamed from: l  reason: collision with root package name */
    private final ParsableByteArray f24586l;

    /* renamed from: m  reason: collision with root package name */
    private final ArrayDeque<Atom.ContainerAtom> f24587m;

    /* renamed from: n  reason: collision with root package name */
    private final ArrayDeque<MetadataSampleInfo> f24588n;

    /* renamed from: o  reason: collision with root package name */
    private final TrackOutput f24589o;

    /* renamed from: p  reason: collision with root package name */
    private int f24590p;

    /* renamed from: q  reason: collision with root package name */
    private int f24591q;

    /* renamed from: r  reason: collision with root package name */
    private long f24592r;

    /* renamed from: s  reason: collision with root package name */
    private int f24593s;

    /* renamed from: t  reason: collision with root package name */
    private ParsableByteArray f24594t;

    /* renamed from: u  reason: collision with root package name */
    private long f24595u;

    /* renamed from: v  reason: collision with root package name */
    private int f24596v;

    /* renamed from: w  reason: collision with root package name */
    private long f24597w;

    /* renamed from: x  reason: collision with root package name */
    private long f24598x;

    /* renamed from: y  reason: collision with root package name */
    private long f24599y;

    /* renamed from: z  reason: collision with root package name */
    private TrackBundle f24600z;

    private static final class MetadataSampleInfo {

        /* renamed from: a  reason: collision with root package name */
        public final long f24601a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f24602b;

        /* renamed from: c  reason: collision with root package name */
        public final int f24603c;

        public MetadataSampleInfo(long j2, boolean z2, int i2) {
            this.f24601a = j2;
            this.f24602b = z2;
            this.f24603c = i2;
        }
    }

    private static final class TrackBundle {

        /* renamed from: a  reason: collision with root package name */
        public final TrackOutput f24604a;

        /* renamed from: b  reason: collision with root package name */
        public final TrackFragment f24605b = new TrackFragment();

        /* renamed from: c  reason: collision with root package name */
        public final ParsableByteArray f24606c = new ParsableByteArray();

        /* renamed from: d  reason: collision with root package name */
        public TrackSampleTable f24607d;

        /* renamed from: e  reason: collision with root package name */
        public DefaultSampleValues f24608e;

        /* renamed from: f  reason: collision with root package name */
        public int f24609f;

        /* renamed from: g  reason: collision with root package name */
        public int f24610g;

        /* renamed from: h  reason: collision with root package name */
        public int f24611h;

        /* renamed from: i  reason: collision with root package name */
        public int f24612i;

        /* renamed from: j  reason: collision with root package name */
        private final ParsableByteArray f24613j = new ParsableByteArray(1);

        /* renamed from: k  reason: collision with root package name */
        private final ParsableByteArray f24614k = new ParsableByteArray();
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public boolean f24615l;

        public TrackBundle(TrackOutput trackOutput, TrackSampleTable trackSampleTable, DefaultSampleValues defaultSampleValues) {
            this.f24604a = trackOutput;
            this.f24607d = trackSampleTable;
            this.f24608e = defaultSampleValues;
            j(trackSampleTable, defaultSampleValues);
        }

        public int c() {
            int i2;
            if (!this.f24615l) {
                i2 = this.f24607d.f24699g[this.f24609f];
            } else if (this.f24605b.f24685k[this.f24609f]) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (g() != null) {
                return i2 | 1073741824;
            }
            return i2;
        }

        public long d() {
            if (!this.f24615l) {
                return this.f24607d.f24695c[this.f24609f];
            }
            return this.f24605b.f24681g[this.f24611h];
        }

        public long e() {
            if (!this.f24615l) {
                return this.f24607d.f24698f[this.f24609f];
            }
            return this.f24605b.c(this.f24609f);
        }

        public int f() {
            if (!this.f24615l) {
                return this.f24607d.f24696d[this.f24609f];
            }
            return this.f24605b.f24683i[this.f24609f];
        }

        public TrackEncryptionBox g() {
            if (!this.f24615l) {
                return null;
            }
            int i2 = ((DefaultSampleValues) Util.j(this.f24605b.f24675a)).f24565a;
            TrackEncryptionBox trackEncryptionBox = this.f24605b.f24688n;
            if (trackEncryptionBox == null) {
                trackEncryptionBox = this.f24607d.f24693a.a(i2);
            }
            if (trackEncryptionBox == null || !trackEncryptionBox.f24670a) {
                return null;
            }
            return trackEncryptionBox;
        }

        public boolean h() {
            this.f24609f++;
            if (!this.f24615l) {
                return false;
            }
            int i2 = this.f24610g + 1;
            this.f24610g = i2;
            int[] iArr = this.f24605b.f24682h;
            int i3 = this.f24611h;
            if (i2 != iArr[i3]) {
                return true;
            }
            this.f24611h = i3 + 1;
            this.f24610g = 0;
            return false;
        }

        public int i(int i2, int i3) {
            ParsableByteArray parsableByteArray;
            boolean z2;
            int i4;
            TrackEncryptionBox g2 = g();
            if (g2 == null) {
                return 0;
            }
            int i5 = g2.f24673d;
            if (i5 != 0) {
                parsableByteArray = this.f24605b.f24689o;
            } else {
                byte[] bArr = (byte[]) Util.j(g2.f24674e);
                this.f24614k.S(bArr, bArr.length);
                ParsableByteArray parsableByteArray2 = this.f24614k;
                i5 = bArr.length;
                parsableByteArray = parsableByteArray2;
            }
            boolean g3 = this.f24605b.g(this.f24609f);
            if (g3 || i3 != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            byte[] e2 = this.f24613j.e();
            if (z2) {
                i4 = 128;
            } else {
                i4 = 0;
            }
            e2[0] = (byte) (i4 | i5);
            this.f24613j.U(0);
            this.f24604a.f(this.f24613j, 1, 1);
            this.f24604a.f(parsableByteArray, i5, 1);
            if (!z2) {
                return i5 + 1;
            }
            if (!g3) {
                this.f24606c.Q(8);
                byte[] e3 = this.f24606c.e();
                e3[0] = 0;
                e3[1] = 1;
                e3[2] = (byte) ((i3 >> 8) & JfifUtil.MARKER_FIRST_BYTE);
                e3[3] = (byte) (i3 & JfifUtil.MARKER_FIRST_BYTE);
                e3[4] = (byte) ((i2 >> 24) & JfifUtil.MARKER_FIRST_BYTE);
                e3[5] = (byte) ((i2 >> 16) & JfifUtil.MARKER_FIRST_BYTE);
                e3[6] = (byte) ((i2 >> 8) & JfifUtil.MARKER_FIRST_BYTE);
                e3[7] = (byte) (i2 & JfifUtil.MARKER_FIRST_BYTE);
                this.f24604a.f(this.f24606c, 8, 1);
                return i5 + 1 + 8;
            }
            ParsableByteArray parsableByteArray3 = this.f24605b.f24689o;
            int N = parsableByteArray3.N();
            parsableByteArray3.V(-2);
            int i6 = (N * 6) + 2;
            if (i3 != 0) {
                this.f24606c.Q(i6);
                byte[] e4 = this.f24606c.e();
                parsableByteArray3.l(e4, 0, i6);
                int i7 = (((e4[2] & 255) << 8) | (e4[3] & 255)) + i3;
                e4[2] = (byte) ((i7 >> 8) & JfifUtil.MARKER_FIRST_BYTE);
                e4[3] = (byte) (i7 & JfifUtil.MARKER_FIRST_BYTE);
                parsableByteArray3 = this.f24606c;
            }
            this.f24604a.f(parsableByteArray3, i6, 1);
            return i5 + 1 + i6;
        }

        public void j(TrackSampleTable trackSampleTable, DefaultSampleValues defaultSampleValues) {
            this.f24607d = trackSampleTable;
            this.f24608e = defaultSampleValues;
            this.f24604a.d(trackSampleTable.f24693a.f24664f);
            k();
        }

        public void k() {
            this.f24605b.f();
            this.f24609f = 0;
            this.f24611h = 0;
            this.f24610g = 0;
            this.f24612i = 0;
            this.f24615l = false;
        }

        public void l(long j2) {
            int i2 = this.f24609f;
            while (true) {
                TrackFragment trackFragment = this.f24605b;
                if (i2 < trackFragment.f24680f && trackFragment.c(i2) <= j2) {
                    if (this.f24605b.f24685k[i2]) {
                        this.f24612i = i2;
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }

        public void m() {
            TrackEncryptionBox g2 = g();
            if (g2 != null) {
                ParsableByteArray parsableByteArray = this.f24605b.f24689o;
                int i2 = g2.f24673d;
                if (i2 != 0) {
                    parsableByteArray.V(i2);
                }
                if (this.f24605b.g(this.f24609f)) {
                    parsableByteArray.V(parsableByteArray.N() * 6);
                }
            }
        }

        public void n(DrmInitData drmInitData) {
            String str;
            TrackEncryptionBox a2 = this.f24607d.f24693a.a(((DefaultSampleValues) Util.j(this.f24605b.f24675a)).f24565a);
            if (a2 != null) {
                str = a2.f24671b;
            } else {
                str = null;
            }
            this.f24604a.d(this.f24607d.f24693a.f24664f.b().O(drmInitData.d(str)).G());
        }
    }

    public FragmentedMp4Extractor() {
        this(0);
    }

    private static void A(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        z(parsableByteArray, 0, trackFragment);
    }

    private static Pair<Long, ChunkIndex> B(ParsableByteArray parsableByteArray, long j2) throws ParserException {
        long j3;
        long j4;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        parsableByteArray2.U(8);
        int c2 = Atom.c(parsableByteArray.q());
        parsableByteArray2.V(4);
        long J2 = parsableByteArray.J();
        if (c2 == 0) {
            j4 = parsableByteArray.J();
            j3 = parsableByteArray.J();
        } else {
            j4 = parsableByteArray.M();
            j3 = parsableByteArray.M();
        }
        long j5 = j4;
        long j6 = j2 + j3;
        long R0 = Util.R0(j5, 1000000, J2);
        parsableByteArray2.V(2);
        int N = parsableByteArray.N();
        int[] iArr = new int[N];
        long[] jArr = new long[N];
        long[] jArr2 = new long[N];
        long[] jArr3 = new long[N];
        long j7 = j5;
        long j8 = R0;
        int i2 = 0;
        while (i2 < N) {
            int q2 = parsableByteArray.q();
            if ((q2 & Integer.MIN_VALUE) == 0) {
                long J3 = parsableByteArray.J();
                iArr[i2] = q2 & Integer.MAX_VALUE;
                jArr[i2] = j6;
                jArr3[i2] = j8;
                long j9 = j7 + J3;
                long[] jArr4 = jArr2;
                long[] jArr5 = jArr3;
                int i3 = N;
                int[] iArr2 = iArr;
                long R02 = Util.R0(j9, 1000000, J2);
                jArr4[i2] = R02 - jArr5[i2];
                parsableByteArray2.V(4);
                j6 += (long) iArr2[i2];
                i2++;
                iArr = iArr2;
                jArr3 = jArr5;
                jArr2 = jArr4;
                jArr = jArr;
                N = i3;
                long j10 = R02;
                j7 = j9;
                j8 = j10;
            } else {
                throw ParserException.a("Unhandled indirect reference", (Throwable) null);
            }
        }
        return Pair.create(Long.valueOf(R0), new ChunkIndex(iArr, jArr, jArr2, jArr3));
    }

    private static long C(ParsableByteArray parsableByteArray) {
        parsableByteArray.U(8);
        if (Atom.c(parsableByteArray.q()) == 1) {
            return parsableByteArray.M();
        }
        return parsableByteArray.J();
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [android.util.SparseArray, android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$TrackBundle>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle D(com.google.android.exoplayer2.util.ParsableByteArray r4, android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle> r5, boolean r6) {
        /*
            r0 = 8
            r4.U(r0)
            int r0 = r4.q()
            int r0 = com.google.android.exoplayer2.extractor.mp4.Atom.b(r0)
            int r1 = r4.q()
            if (r6 == 0) goto L_0x0019
            r6 = 0
            java.lang.Object r5 = r5.valueAt(r6)
            goto L_0x001d
        L_0x0019:
            java.lang.Object r5 = r5.get(r1)
        L_0x001d:
            com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$TrackBundle r5 = (com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle) r5
            if (r5 != 0) goto L_0x0023
            r4 = 0
            return r4
        L_0x0023:
            r6 = r0 & 1
            if (r6 == 0) goto L_0x0031
            long r1 = r4.M()
            com.google.android.exoplayer2.extractor.mp4.TrackFragment r6 = r5.f24605b
            r6.f24677c = r1
            r6.f24678d = r1
        L_0x0031:
            com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues r6 = r5.f24608e
            r1 = r0 & 2
            if (r1 == 0) goto L_0x003e
            int r1 = r4.q()
            int r1 = r1 + -1
            goto L_0x0040
        L_0x003e:
            int r1 = r6.f24565a
        L_0x0040:
            r2 = r0 & 8
            if (r2 == 0) goto L_0x0049
            int r2 = r4.q()
            goto L_0x004b
        L_0x0049:
            int r2 = r6.f24566b
        L_0x004b:
            r3 = r0 & 16
            if (r3 == 0) goto L_0x0054
            int r3 = r4.q()
            goto L_0x0056
        L_0x0054:
            int r3 = r6.f24567c
        L_0x0056:
            r0 = r0 & 32
            if (r0 == 0) goto L_0x005f
            int r4 = r4.q()
            goto L_0x0061
        L_0x005f:
            int r4 = r6.f24568d
        L_0x0061:
            com.google.android.exoplayer2.extractor.mp4.TrackFragment r6 = r5.f24605b
            com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues r0 = new com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues
            r0.<init>(r1, r2, r3, r4)
            r6.f24675a = r0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.D(com.google.android.exoplayer2.util.ParsableByteArray, android.util.SparseArray, boolean):com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$TrackBundle");
    }

    private static void E(Atom.ContainerAtom containerAtom, SparseArray<TrackBundle> sparseArray, boolean z2, int i2, byte[] bArr) throws ParserException {
        String str;
        TrackBundle D2 = D(((Atom.LeafAtom) Assertions.e(containerAtom.g(1952868452))).f24535b, sparseArray, z2);
        if (D2 != null) {
            TrackFragment trackFragment = D2.f24605b;
            long j2 = trackFragment.f24691q;
            boolean z3 = trackFragment.f24692r;
            D2.k();
            boolean unused = D2.f24615l = true;
            Atom.LeafAtom g2 = containerAtom.g(1952867444);
            if (g2 == null || (i2 & 2) != 0) {
                trackFragment.f24691q = j2;
                trackFragment.f24692r = z3;
            } else {
                trackFragment.f24691q = C(g2.f24535b);
                trackFragment.f24692r = true;
            }
            H(containerAtom, D2, i2);
            TrackEncryptionBox a2 = D2.f24607d.f24693a.a(((DefaultSampleValues) Assertions.e(trackFragment.f24675a)).f24565a);
            Atom.LeafAtom g3 = containerAtom.g(1935763834);
            if (g3 != null) {
                x((TrackEncryptionBox) Assertions.e(a2), g3.f24535b, trackFragment);
            }
            Atom.LeafAtom g4 = containerAtom.g(1935763823);
            if (g4 != null) {
                w(g4.f24535b, trackFragment);
            }
            Atom.LeafAtom g5 = containerAtom.g(1936027235);
            if (g5 != null) {
                A(g5.f24535b, trackFragment);
            }
            if (a2 != null) {
                str = a2.f24671b;
            } else {
                str = null;
            }
            y(containerAtom, str, trackFragment);
            int size = containerAtom.f24533c.size();
            for (int i3 = 0; i3 < size; i3++) {
                Atom.LeafAtom leafAtom = containerAtom.f24533c.get(i3);
                if (leafAtom.f24531a == 1970628964) {
                    I(leafAtom.f24535b, trackFragment, bArr);
                }
            }
        }
    }

    private static Pair<Integer, DefaultSampleValues> F(ParsableByteArray parsableByteArray) {
        parsableByteArray.U(12);
        return Pair.create(Integer.valueOf(parsableByteArray.q()), new DefaultSampleValues(parsableByteArray.q() - 1, parsableByteArray.q(), parsableByteArray.q(), parsableByteArray.q()));
    }

    private static int G(TrackBundle trackBundle, int i2, int i3, ParsableByteArray parsableByteArray, int i4) throws ParserException {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        long j2;
        boolean z7;
        int i5;
        boolean z8;
        int i6;
        boolean z9;
        int i7;
        boolean z10;
        boolean z11;
        boolean z12;
        int i8;
        boolean z13;
        TrackBundle trackBundle2 = trackBundle;
        parsableByteArray.U(8);
        int b2 = Atom.b(parsableByteArray.q());
        Track track = trackBundle2.f24607d.f24693a;
        TrackFragment trackFragment = trackBundle2.f24605b;
        DefaultSampleValues defaultSampleValues = (DefaultSampleValues) Util.j(trackFragment.f24675a);
        trackFragment.f24682h[i2] = parsableByteArray.L();
        long[] jArr = trackFragment.f24681g;
        long j3 = trackFragment.f24677c;
        jArr[i2] = j3;
        if ((b2 & 1) != 0) {
            jArr[i2] = j3 + ((long) parsableByteArray.q());
        }
        if ((b2 & 4) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i9 = defaultSampleValues.f24568d;
        if (z2) {
            i9 = parsableByteArray.q();
        }
        if ((b2 & UserVerificationMethods.USER_VERIFY_HANDPRINT) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((b2 & 512) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if ((b2 & 1024) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if ((b2 & 2048) != 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (l(track)) {
            j2 = ((long[]) Util.j(track.f24667i))[0];
        } else {
            j2 = 0;
        }
        int[] iArr = trackFragment.f24683i;
        long[] jArr2 = trackFragment.f24684j;
        boolean[] zArr = trackFragment.f24685k;
        int i10 = i9;
        if (track.f24660b != 2 || (i3 & 1) == 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        int i11 = i4 + trackFragment.f24682h[i2];
        boolean z14 = z7;
        long[] jArr3 = jArr2;
        boolean[] zArr2 = zArr;
        long j4 = track.f24661c;
        long j5 = trackFragment.f24691q;
        int i12 = i4;
        while (i12 < i11) {
            if (z3) {
                i5 = parsableByteArray.q();
            } else {
                i5 = defaultSampleValues.f24566b;
            }
            int d2 = d(i5);
            if (z4) {
                i6 = parsableByteArray.q();
                z8 = z3;
            } else {
                z8 = z3;
                i6 = defaultSampleValues.f24567c;
            }
            int d3 = d(i6);
            if (z5) {
                z9 = z2;
                i7 = parsableByteArray.q();
            } else if (i12 != 0 || !z2) {
                z9 = z2;
                i7 = defaultSampleValues.f24568d;
            } else {
                z9 = z2;
                i7 = i10;
            }
            if (z6) {
                z12 = z6;
                z11 = z4;
                z10 = z5;
                i8 = parsableByteArray.q();
            } else {
                z12 = z6;
                z11 = z4;
                z10 = z5;
                i8 = 0;
            }
            long R0 = Util.R0((((long) i8) + j5) - j2, 1000000, j4);
            jArr3[i12] = R0;
            if (!trackFragment.f24692r) {
                jArr3[i12] = R0 + trackBundle2.f24607d.f24700h;
            }
            iArr[i12] = d3;
            if (((i7 >> 16) & 1) != 0 || (z14 && i12 != 0)) {
                z13 = false;
            } else {
                z13 = true;
            }
            zArr2[i12] = z13;
            j5 += (long) d2;
            i12++;
            trackBundle2 = trackBundle;
            z3 = z8;
            z2 = z9;
            z6 = z12;
            z4 = z11;
            z5 = z10;
        }
        trackFragment.f24691q = j5;
        return i11;
    }

    private static void H(Atom.ContainerAtom containerAtom, TrackBundle trackBundle, int i2) throws ParserException {
        List<Atom.LeafAtom> list = containerAtom.f24533c;
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Atom.LeafAtom leafAtom = list.get(i5);
            if (leafAtom.f24531a == 1953658222) {
                ParsableByteArray parsableByteArray = leafAtom.f24535b;
                parsableByteArray.U(12);
                int L = parsableByteArray.L();
                if (L > 0) {
                    i4 += L;
                    i3++;
                }
            }
        }
        trackBundle.f24611h = 0;
        trackBundle.f24610g = 0;
        trackBundle.f24609f = 0;
        trackBundle.f24605b.e(i3, i4);
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            Atom.LeafAtom leafAtom2 = list.get(i8);
            if (leafAtom2.f24531a == 1953658222) {
                i7 = G(trackBundle, i6, i2, leafAtom2.f24535b, i7);
                i6++;
            }
        }
    }

    private static void I(ParsableByteArray parsableByteArray, TrackFragment trackFragment, byte[] bArr) throws ParserException {
        parsableByteArray.U(8);
        parsableByteArray.l(bArr, 0, 16);
        if (Arrays.equals(bArr, J)) {
            z(parsableByteArray, 16, trackFragment);
        }
    }

    private void J(long j2) throws ParserException {
        while (!this.f24587m.isEmpty() && this.f24587m.peek().f24532b == j2) {
            o(this.f24587m.pop());
        }
        e();
    }

    private boolean K(ExtractorInput extractorInput) throws IOException {
        if (this.f24593s == 0) {
            if (!extractorInput.f(this.f24586l.e(), 0, 8, true)) {
                return false;
            }
            this.f24593s = 8;
            this.f24586l.U(0);
            this.f24592r = this.f24586l.J();
            this.f24591q = this.f24586l.q();
        }
        long j2 = this.f24592r;
        if (j2 == 1) {
            extractorInput.readFully(this.f24586l.e(), 8, 8);
            this.f24593s += 8;
            this.f24592r = this.f24586l.M();
        } else if (j2 == 0) {
            long length = extractorInput.getLength();
            if (length == -1 && !this.f24587m.isEmpty()) {
                length = this.f24587m.peek().f24532b;
            }
            if (length != -1) {
                this.f24592r = (length - extractorInput.getPosition()) + ((long) this.f24593s);
            }
        }
        if (this.f24592r >= ((long) this.f24593s)) {
            long position = extractorInput.getPosition() - ((long) this.f24593s);
            int i2 = this.f24591q;
            if ((i2 == 1836019558 || i2 == 1835295092) && !this.H) {
                this.E.u(new SeekMap.Unseekable(this.f24598x, position));
                this.H = true;
            }
            if (this.f24591q == 1836019558) {
                int size = this.f24578d.size();
                for (int i3 = 0; i3 < size; i3++) {
                    TrackFragment trackFragment = this.f24578d.valueAt(i3).f24605b;
                    trackFragment.f24676b = position;
                    trackFragment.f24678d = position;
                    trackFragment.f24677c = position;
                }
            }
            int i4 = this.f24591q;
            if (i4 == 1835295092) {
                this.f24600z = null;
                this.f24595u = position + this.f24592r;
                this.f24590p = 2;
                return true;
            }
            if (O(i4)) {
                long position2 = (extractorInput.getPosition() + this.f24592r) - 8;
                this.f24587m.push(new Atom.ContainerAtom(this.f24591q, position2));
                if (this.f24592r == ((long) this.f24593s)) {
                    J(position2);
                } else {
                    e();
                }
            } else if (P(this.f24591q)) {
                if (this.f24593s != 8) {
                    throw ParserException.e("Leaf atom defines extended atom size (unsupported).");
                } else if (this.f24592r <= 2147483647L) {
                    ParsableByteArray parsableByteArray = new ParsableByteArray((int) this.f24592r);
                    System.arraycopy(this.f24586l.e(), 0, parsableByteArray.e(), 0, 8);
                    this.f24594t = parsableByteArray;
                    this.f24590p = 1;
                } else {
                    throw ParserException.e("Leaf atom with length > 2147483647 (unsupported).");
                }
            } else if (this.f24592r <= 2147483647L) {
                this.f24594t = null;
                this.f24590p = 1;
            } else {
                throw ParserException.e("Skipping atom with length > 2147483647 (unsupported).");
            }
            return true;
        }
        throw ParserException.e("Atom size less than header length (unsupported).");
    }

    private void L(ExtractorInput extractorInput) throws IOException {
        int i2 = ((int) this.f24592r) - this.f24593s;
        ParsableByteArray parsableByteArray = this.f24594t;
        if (parsableByteArray != null) {
            extractorInput.readFully(parsableByteArray.e(), 8, i2);
            q(new Atom.LeafAtom(this.f24591q, parsableByteArray), extractorInput.getPosition());
        } else {
            extractorInput.k(i2);
        }
        J(extractorInput.getPosition());
    }

    private void M(ExtractorInput extractorInput) throws IOException {
        int size = this.f24578d.size();
        long j2 = Clock.MAX_TIME;
        TrackBundle trackBundle = null;
        for (int i2 = 0; i2 < size; i2++) {
            TrackFragment trackFragment = this.f24578d.valueAt(i2).f24605b;
            if (trackFragment.f24690p) {
                long j3 = trackFragment.f24678d;
                if (j3 < j2) {
                    trackBundle = this.f24578d.valueAt(i2);
                    j2 = j3;
                }
            }
        }
        if (trackBundle == null) {
            this.f24590p = 3;
            return;
        }
        int position = (int) (j2 - extractorInput.getPosition());
        if (position >= 0) {
            extractorInput.k(position);
            trackBundle.f24605b.a(extractorInput);
            return;
        }
        throw ParserException.a("Offset to encryption data was negative.", (Throwable) null);
    }

    private boolean N(ExtractorInput extractorInput) throws IOException {
        TrackOutput.CryptoData cryptoData;
        int i2;
        boolean z2;
        ExtractorInput extractorInput2 = extractorInput;
        TrackBundle trackBundle = this.f24600z;
        Throwable th = null;
        if (trackBundle == null) {
            trackBundle = j(this.f24578d);
            if (trackBundle == null) {
                int position = (int) (this.f24595u - extractorInput.getPosition());
                if (position >= 0) {
                    extractorInput2.k(position);
                    e();
                    return false;
                }
                throw ParserException.a("Offset to end of mdat was negative.", (Throwable) null);
            }
            int d2 = (int) (trackBundle.d() - extractorInput.getPosition());
            if (d2 < 0) {
                Log.i("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                d2 = 0;
            }
            extractorInput2.k(d2);
            this.f24600z = trackBundle;
        }
        int i3 = 4;
        int i4 = 1;
        if (this.f24590p == 3) {
            int f2 = trackBundle.f();
            this.A = f2;
            if (trackBundle.f24609f < trackBundle.f24612i) {
                extractorInput2.k(f2);
                trackBundle.m();
                if (!trackBundle.h()) {
                    this.f24600z = null;
                }
                this.f24590p = 3;
                return true;
            }
            if (trackBundle.f24607d.f24693a.f24665g == 1) {
                this.A = f2 - 8;
                extractorInput2.k(8);
            }
            if ("audio/ac4".equals(trackBundle.f24607d.f24693a.f24664f.f23071m)) {
                this.B = trackBundle.i(this.A, 7);
                Ac4Util.a(this.A, this.f24583i);
                trackBundle.f24604a.c(this.f24583i, 7);
                this.B += 7;
            } else {
                this.B = trackBundle.i(this.A, 0);
            }
            this.A += this.B;
            this.f24590p = 4;
            this.C = 0;
        }
        Track track = trackBundle.f24607d.f24693a;
        TrackOutput trackOutput = trackBundle.f24604a;
        long e2 = trackBundle.e();
        TimestampAdjuster timestampAdjuster = this.f24584j;
        if (timestampAdjuster != null) {
            e2 = timestampAdjuster.a(e2);
        }
        long j2 = e2;
        if (track.f24668j == 0) {
            while (true) {
                int i5 = this.B;
                int i6 = this.A;
                if (i5 >= i6) {
                    break;
                }
                this.B += trackOutput.b(extractorInput2, i6 - i5, false);
            }
        } else {
            byte[] e3 = this.f24580f.e();
            e3[0] = 0;
            e3[1] = 0;
            e3[2] = 0;
            int i7 = track.f24668j;
            int i8 = i7 + 1;
            int i9 = 4 - i7;
            while (this.B < this.A) {
                int i10 = this.C;
                if (i10 == 0) {
                    extractorInput2.readFully(e3, i9, i8);
                    this.f24580f.U(0);
                    int q2 = this.f24580f.q();
                    if (q2 >= i4) {
                        this.C = q2 - 1;
                        this.f24579e.U(0);
                        trackOutput.c(this.f24579e, i3);
                        trackOutput.c(this.f24580f, i4);
                        if (this.G.length <= 0 || !NalUnitUtil.g(track.f24664f.f23071m, e3[i3])) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        this.D = z2;
                        this.B += 5;
                        this.A += i9;
                    } else {
                        throw ParserException.a("Invalid NAL length", th);
                    }
                } else {
                    if (this.D) {
                        this.f24581g.Q(i10);
                        extractorInput2.readFully(this.f24581g.e(), 0, this.C);
                        trackOutput.c(this.f24581g, this.C);
                        i2 = this.C;
                        int q3 = NalUnitUtil.q(this.f24581g.e(), this.f24581g.g());
                        this.f24581g.U(MimeTypes.VIDEO_H265.equals(track.f24664f.f23071m) ? 1 : 0);
                        this.f24581g.T(q3);
                        CeaUtil.a(j2, this.f24581g, this.G);
                    } else {
                        i2 = trackOutput.b(extractorInput2, i10, false);
                    }
                    this.B += i2;
                    this.C -= i2;
                    th = null;
                    i3 = 4;
                    i4 = 1;
                }
            }
        }
        int c2 = trackBundle.c();
        TrackEncryptionBox g2 = trackBundle.g();
        if (g2 != null) {
            cryptoData = g2.f24672c;
        } else {
            cryptoData = null;
        }
        trackOutput.e(j2, c2, this.A, 0, cryptoData);
        t(j2);
        if (!trackBundle.h()) {
            this.f24600z = null;
        }
        this.f24590p = 3;
        return true;
    }

    private static boolean O(int i2) {
        return i2 == 1836019574 || i2 == 1953653099 || i2 == 1835297121 || i2 == 1835626086 || i2 == 1937007212 || i2 == 1836019558 || i2 == 1953653094 || i2 == 1836475768 || i2 == 1701082227;
    }

    private static boolean P(int i2) {
        return i2 == 1751411826 || i2 == 1835296868 || i2 == 1836476516 || i2 == 1936286840 || i2 == 1937011556 || i2 == 1937011827 || i2 == 1668576371 || i2 == 1937011555 || i2 == 1937011578 || i2 == 1937013298 || i2 == 1937007471 || i2 == 1668232756 || i2 == 1937011571 || i2 == 1952867444 || i2 == 1952868452 || i2 == 1953196132 || i2 == 1953654136 || i2 == 1953658222 || i2 == 1886614376 || i2 == 1935763834 || i2 == 1935763823 || i2 == 1936027235 || i2 == 1970628964 || i2 == 1935828848 || i2 == 1936158820 || i2 == 1701606260 || i2 == 1835362404 || i2 == 1701671783;
    }

    private static int d(int i2) throws ParserException {
        if (i2 >= 0) {
            return i2;
        }
        throw ParserException.a("Unexpected negative value: " + i2, (Throwable) null);
    }

    private void e() {
        this.f24590p = 0;
        this.f24593s = 0;
    }

    private DefaultSampleValues f(SparseArray<DefaultSampleValues> sparseArray, int i2) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return (DefaultSampleValues) Assertions.e(sparseArray.get(i2));
    }

    private static DrmInitData h(List<Atom.LeafAtom> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            Atom.LeafAtom leafAtom = list.get(i2);
            if (leafAtom.f24531a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] e2 = leafAtom.f24535b.e();
                UUID f2 = PsshAtomUtil.f(e2);
                if (f2 == null) {
                    Log.i("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(f2, "video/mp4", e2));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData((List<DrmInitData.SchemeData>) arrayList);
    }

    private static TrackBundle j(SparseArray<TrackBundle> sparseArray) {
        int size = sparseArray.size();
        TrackBundle trackBundle = null;
        long j2 = Clock.MAX_TIME;
        for (int i2 = 0; i2 < size; i2++) {
            TrackBundle valueAt = sparseArray.valueAt(i2);
            if ((valueAt.f24615l || valueAt.f24609f != valueAt.f24607d.f24694b) && (!valueAt.f24615l || valueAt.f24611h != valueAt.f24605b.f24679e)) {
                long d2 = valueAt.d();
                if (d2 < j2) {
                    trackBundle = valueAt;
                    j2 = d2;
                }
            }
        }
        return trackBundle;
    }

    private void k() {
        int i2;
        TrackOutput[] trackOutputArr = new TrackOutput[2];
        this.F = trackOutputArr;
        TrackOutput trackOutput = this.f24589o;
        int i3 = 0;
        if (trackOutput != null) {
            trackOutputArr[0] = trackOutput;
            i2 = 1;
        } else {
            i2 = 0;
        }
        int i4 = 100;
        if ((this.f24575a & 4) != 0) {
            trackOutputArr[i2] = this.E.d(100, 5);
            i4 = 101;
            i2++;
        }
        TrackOutput[] trackOutputArr2 = (TrackOutput[]) Util.K0(this.F, i2);
        this.F = trackOutputArr2;
        for (TrackOutput d2 : trackOutputArr2) {
            d2.d(K);
        }
        this.G = new TrackOutput[this.f24577c.size()];
        while (i3 < this.G.length) {
            TrackOutput d3 = this.E.d(i4, 3);
            d3.d(this.f24577c.get(i3));
            this.G[i3] = d3;
            i3++;
            i4++;
        }
    }

    private static boolean l(Track track) {
        long[] jArr;
        long[] jArr2 = track.f24666h;
        if (jArr2 == null || jArr2.length != 1 || (jArr = track.f24667i) == null) {
            return false;
        }
        long j2 = jArr2[0];
        if (j2 != 0 && Util.R0(j2 + jArr[0], 1000000, track.f24662d) < track.f24663e) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] m() {
        return new Extractor[]{new FragmentedMp4Extractor()};
    }

    private void o(Atom.ContainerAtom containerAtom) throws ParserException {
        int i2 = containerAtom.f24531a;
        if (i2 == 1836019574) {
            s(containerAtom);
        } else if (i2 == 1836019558) {
            r(containerAtom);
        } else if (!this.f24587m.isEmpty()) {
            this.f24587m.peek().d(containerAtom);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void p(com.google.android.exoplayer2.util.ParsableByteArray r28) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            com.google.android.exoplayer2.extractor.TrackOutput[] r2 = r0.F
            int r2 = r2.length
            if (r2 != 0) goto L_0x000a
            return
        L_0x000a:
            r2 = 8
            r1.U(r2)
            int r2 = r28.q()
            int r2 = com.google.android.exoplayer2.extractor.mp4.Atom.c(r2)
            r3 = 1
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r2 == 0) goto L_0x0074
            if (r2 == r3) goto L_0x0038
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Skipping unsupported emsg version: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "FragmentedMp4Extractor"
            com.google.android.exoplayer2.util.Log.i(r2, r1)
            return
        L_0x0038:
            long r12 = r28.J()
            long r6 = r28.M()
            r8 = 1000000(0xf4240, double:4.940656E-318)
            r10 = r12
            long r14 = com.google.android.exoplayer2.util.Util.R0(r6, r8, r10)
            long r6 = r28.J()
            r8 = 1000(0x3e8, double:4.94E-321)
            long r6 = com.google.android.exoplayer2.util.Util.R0(r6, r8, r10)
            long r8 = r28.J()
            java.lang.String r2 = r28.B()
            java.lang.Object r2 = com.google.android.exoplayer2.util.Assertions.e(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r10 = r28.B()
            java.lang.Object r10 = com.google.android.exoplayer2.util.Assertions.e(r10)
            java.lang.String r10 = (java.lang.String) r10
            r20 = r2
            r22 = r6
            r24 = r8
            r21 = r10
            r8 = r4
            goto L_0x00be
        L_0x0074:
            java.lang.String r2 = r28.B()
            java.lang.Object r2 = com.google.android.exoplayer2.util.Assertions.e(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r6 = r28.B()
            java.lang.Object r6 = com.google.android.exoplayer2.util.Assertions.e(r6)
            r10 = r6
            java.lang.String r10 = (java.lang.String) r10
            long r6 = r28.J()
            long r11 = r28.J()
            r13 = 1000000(0xf4240, double:4.940656E-318)
            r15 = r6
            long r8 = com.google.android.exoplayer2.util.Util.R0(r11, r13, r15)
            long r11 = r0.f24599y
            int r13 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00a3
            long r11 = r11 + r8
            r17 = r11
            goto L_0x00a5
        L_0x00a3:
            r17 = r4
        L_0x00a5:
            long r11 = r28.J()
            r13 = 1000(0x3e8, double:4.94E-321)
            r15 = r6
            long r6 = com.google.android.exoplayer2.util.Util.R0(r11, r13, r15)
            long r11 = r28.J()
            r20 = r2
            r22 = r6
            r21 = r10
            r24 = r11
            r14 = r17
        L_0x00be:
            int r2 = r28.a()
            byte[] r2 = new byte[r2]
            int r6 = r28.a()
            r7 = 0
            r1.l(r2, r7, r6)
            com.google.android.exoplayer2.metadata.emsg.EventMessage r1 = new com.google.android.exoplayer2.metadata.emsg.EventMessage
            r19 = r1
            r26 = r2
            r19.<init>(r20, r21, r22, r24, r26)
            com.google.android.exoplayer2.util.ParsableByteArray r2 = new com.google.android.exoplayer2.util.ParsableByteArray
            com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder r6 = r0.f24585k
            byte[] r1 = r6.a(r1)
            r2.<init>((byte[]) r1)
            int r1 = r2.a()
            com.google.android.exoplayer2.extractor.TrackOutput[] r6 = r0.F
            int r10 = r6.length
            r11 = 0
        L_0x00e8:
            if (r11 >= r10) goto L_0x00f5
            r12 = r6[r11]
            r2.U(r7)
            r12.c(r2, r1)
            int r11 = r11 + 1
            goto L_0x00e8
        L_0x00f5:
            int r2 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0109
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo> r2 = r0.f24588n
            com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo r4 = new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo
            r4.<init>(r8, r3, r1)
            r2.addLast(r4)
            int r2 = r0.f24596v
            int r2 = r2 + r1
            r0.f24596v = r2
            goto L_0x0140
        L_0x0109:
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo> r2 = r0.f24588n
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0121
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo> r2 = r0.f24588n
            com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo r3 = new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo
            r3.<init>(r14, r7, r1)
            r2.addLast(r3)
            int r2 = r0.f24596v
            int r2 = r2 + r1
            r0.f24596v = r2
            goto L_0x0140
        L_0x0121:
            com.google.android.exoplayer2.util.TimestampAdjuster r2 = r0.f24584j
            if (r2 == 0) goto L_0x0129
            long r14 = r2.a(r14)
        L_0x0129:
            com.google.android.exoplayer2.extractor.TrackOutput[] r2 = r0.F
            int r3 = r2.length
        L_0x012c:
            if (r7 >= r3) goto L_0x0140
            r16 = r2[r7]
            r19 = 1
            r21 = 0
            r22 = 0
            r17 = r14
            r20 = r1
            r16.e(r17, r19, r20, r21, r22)
            int r7 = r7 + 1
            goto L_0x012c
        L_0x0140:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.p(com.google.android.exoplayer2.util.ParsableByteArray):void");
    }

    private void q(Atom.LeafAtom leafAtom, long j2) throws ParserException {
        if (!this.f24587m.isEmpty()) {
            this.f24587m.peek().e(leafAtom);
            return;
        }
        int i2 = leafAtom.f24531a;
        if (i2 == 1936286840) {
            Pair<Long, ChunkIndex> B2 = B(leafAtom.f24535b, j2);
            this.f24599y = ((Long) B2.first).longValue();
            this.E.u((SeekMap) B2.second);
            this.H = true;
        } else if (i2 == 1701671783) {
            p(leafAtom.f24535b);
        }
    }

    private void r(Atom.ContainerAtom containerAtom) throws ParserException {
        boolean z2;
        SparseArray<TrackBundle> sparseArray = this.f24578d;
        if (this.f24576b != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        v(containerAtom, sparseArray, z2, this.f24575a, this.f24582h);
        DrmInitData h2 = h(containerAtom.f24533c);
        if (h2 != null) {
            int size = this.f24578d.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f24578d.valueAt(i2).n(h2);
            }
        }
        if (this.f24597w != -9223372036854775807L) {
            int size2 = this.f24578d.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.f24578d.valueAt(i3).l(this.f24597w);
            }
            this.f24597w = -9223372036854775807L;
        }
    }

    private void s(Atom.ContainerAtom containerAtom) throws ParserException {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        int i2 = 0;
        if (this.f24576b == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2, "Unexpected moov box.");
        DrmInitData h2 = h(containerAtom.f24533c);
        Atom.ContainerAtom containerAtom2 = (Atom.ContainerAtom) Assertions.e(containerAtom.f(1836475768));
        SparseArray sparseArray = new SparseArray();
        int size = containerAtom2.f24533c.size();
        long j2 = -9223372036854775807L;
        for (int i3 = 0; i3 < size; i3++) {
            Atom.LeafAtom leafAtom = containerAtom2.f24533c.get(i3);
            int i4 = leafAtom.f24531a;
            if (i4 == 1953654136) {
                Pair<Integer, DefaultSampleValues> F2 = F(leafAtom.f24535b);
                sparseArray.put(((Integer) F2.first).intValue(), (DefaultSampleValues) F2.second);
            } else if (i4 == 1835362404) {
                j2 = u(leafAtom.f24535b);
            }
        }
        GaplessInfoHolder gaplessInfoHolder = new GaplessInfoHolder();
        if ((this.f24575a & 16) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        List<TrackSampleTable> A2 = AtomParsers.A(containerAtom, gaplessInfoHolder, j2, h2, z3, false, new a(this));
        int size2 = A2.size();
        if (this.f24578d.size() == 0) {
            while (i2 < size2) {
                TrackSampleTable trackSampleTable = A2.get(i2);
                Track track = trackSampleTable.f24693a;
                this.f24578d.put(track.f24659a, new TrackBundle(this.E.d(i2, track.f24660b), trackSampleTable, f(sparseArray, track.f24659a)));
                this.f24598x = Math.max(this.f24598x, track.f24663e);
                i2++;
            }
            this.E.m();
            return;
        }
        if (this.f24578d.size() != size2) {
            z4 = false;
        }
        Assertions.g(z4);
        while (i2 < size2) {
            TrackSampleTable trackSampleTable2 = A2.get(i2);
            Track track2 = trackSampleTable2.f24693a;
            this.f24578d.get(track2.f24659a).j(trackSampleTable2, f(sparseArray, track2.f24659a));
            i2++;
        }
    }

    private void t(long j2) {
        while (!this.f24588n.isEmpty()) {
            MetadataSampleInfo removeFirst = this.f24588n.removeFirst();
            this.f24596v -= removeFirst.f24603c;
            long j3 = removeFirst.f24601a;
            if (removeFirst.f24602b) {
                j3 += j2;
            }
            TimestampAdjuster timestampAdjuster = this.f24584j;
            if (timestampAdjuster != null) {
                j3 = timestampAdjuster.a(j3);
            }
            for (TrackOutput e2 : this.F) {
                e2.e(j3, 1, removeFirst.f24603c, this.f24596v, (TrackOutput.CryptoData) null);
            }
        }
    }

    private static long u(ParsableByteArray parsableByteArray) {
        parsableByteArray.U(8);
        if (Atom.c(parsableByteArray.q()) == 0) {
            return parsableByteArray.J();
        }
        return parsableByteArray.M();
    }

    private static void v(Atom.ContainerAtom containerAtom, SparseArray<TrackBundle> sparseArray, boolean z2, int i2, byte[] bArr) throws ParserException {
        int size = containerAtom.f24534d.size();
        for (int i3 = 0; i3 < size; i3++) {
            Atom.ContainerAtom containerAtom2 = containerAtom.f24534d.get(i3);
            if (containerAtom2.f24531a == 1953653094) {
                E(containerAtom2, sparseArray, z2, i2, bArr);
            }
        }
    }

    private static void w(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        long j2;
        parsableByteArray.U(8);
        int q2 = parsableByteArray.q();
        if ((Atom.b(q2) & 1) == 1) {
            parsableByteArray.V(8);
        }
        int L = parsableByteArray.L();
        if (L == 1) {
            int c2 = Atom.c(q2);
            long j3 = trackFragment.f24678d;
            if (c2 == 0) {
                j2 = parsableByteArray.J();
            } else {
                j2 = parsableByteArray.M();
            }
            trackFragment.f24678d = j3 + j2;
            return;
        }
        throw ParserException.a("Unexpected saio entry count: " + L, (Throwable) null);
    }

    private static void x(TrackEncryptionBox trackEncryptionBox, ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        int i2;
        boolean z2;
        int i3 = trackEncryptionBox.f24673d;
        parsableByteArray.U(8);
        boolean z3 = true;
        if ((Atom.b(parsableByteArray.q()) & 1) == 1) {
            parsableByteArray.V(8);
        }
        int H2 = parsableByteArray.H();
        int L = parsableByteArray.L();
        if (L <= trackFragment.f24680f) {
            if (H2 == 0) {
                boolean[] zArr = trackFragment.f24687m;
                i2 = 0;
                for (int i4 = 0; i4 < L; i4++) {
                    int H3 = parsableByteArray.H();
                    i2 += H3;
                    if (H3 > i3) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zArr[i4] = z2;
                }
            } else {
                if (H2 <= i3) {
                    z3 = false;
                }
                i2 = (H2 * L) + 0;
                Arrays.fill(trackFragment.f24687m, 0, L, z3);
            }
            Arrays.fill(trackFragment.f24687m, L, trackFragment.f24680f, false);
            if (i2 > 0) {
                trackFragment.d(i2);
                return;
            }
            return;
        }
        throw ParserException.a("Saiz sample count " + L + " is greater than fragment sample count" + trackFragment.f24680f, (Throwable) null);
    }

    private static void y(Atom.ContainerAtom containerAtom, String str, TrackFragment trackFragment) throws ParserException {
        boolean z2;
        Atom.ContainerAtom containerAtom2 = containerAtom;
        TrackFragment trackFragment2 = trackFragment;
        byte[] bArr = null;
        ParsableByteArray parsableByteArray = null;
        ParsableByteArray parsableByteArray2 = null;
        for (int i2 = 0; i2 < containerAtom2.f24533c.size(); i2++) {
            Atom.LeafAtom leafAtom = containerAtom2.f24533c.get(i2);
            ParsableByteArray parsableByteArray3 = leafAtom.f24535b;
            int i3 = leafAtom.f24531a;
            if (i3 == 1935828848) {
                parsableByteArray3.U(12);
                if (parsableByteArray3.q() == 1936025959) {
                    parsableByteArray = parsableByteArray3;
                }
            } else if (i3 == 1936158820) {
                parsableByteArray3.U(12);
                if (parsableByteArray3.q() == 1936025959) {
                    parsableByteArray2 = parsableByteArray3;
                }
            }
        }
        if (parsableByteArray != null && parsableByteArray2 != null) {
            parsableByteArray.U(8);
            int c2 = Atom.c(parsableByteArray.q());
            parsableByteArray.V(4);
            if (c2 == 1) {
                parsableByteArray.V(4);
            }
            if (parsableByteArray.q() == 1) {
                parsableByteArray2.U(8);
                int c3 = Atom.c(parsableByteArray2.q());
                parsableByteArray2.V(4);
                if (c3 == 1) {
                    if (parsableByteArray2.J() == 0) {
                        throw ParserException.e("Variable length description in sgpd found (unsupported)");
                    }
                } else if (c3 >= 2) {
                    parsableByteArray2.V(4);
                }
                if (parsableByteArray2.J() == 1) {
                    parsableByteArray2.V(1);
                    int H2 = parsableByteArray2.H();
                    int i4 = (H2 & 240) >> 4;
                    int i5 = H2 & 15;
                    if (parsableByteArray2.H() == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        int H3 = parsableByteArray2.H();
                        byte[] bArr2 = new byte[16];
                        parsableByteArray2.l(bArr2, 0, 16);
                        if (H3 == 0) {
                            int H4 = parsableByteArray2.H();
                            bArr = new byte[H4];
                            parsableByteArray2.l(bArr, 0, H4);
                        }
                        trackFragment2.f24686l = true;
                        trackFragment2.f24688n = new TrackEncryptionBox(z2, str, H3, bArr2, i4, i5, bArr);
                        return;
                    }
                    return;
                }
                throw ParserException.e("Entry count in sgpd != 1 (unsupported).");
            }
            throw ParserException.e("Entry count in sbgp != 1 (unsupported).");
        }
    }

    private static void z(ParsableByteArray parsableByteArray, int i2, TrackFragment trackFragment) throws ParserException {
        boolean z2;
        parsableByteArray.U(i2 + 8);
        int b2 = Atom.b(parsableByteArray.q());
        if ((b2 & 1) == 0) {
            if ((b2 & 2) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            int L = parsableByteArray.L();
            if (L == 0) {
                Arrays.fill(trackFragment.f24687m, 0, trackFragment.f24680f, false);
            } else if (L == trackFragment.f24680f) {
                Arrays.fill(trackFragment.f24687m, 0, L, z2);
                trackFragment.d(parsableByteArray.a());
                trackFragment.b(parsableByteArray);
            } else {
                throw ParserException.a("Senc sample count " + L + " is different from fragment sample count" + trackFragment.f24680f, (Throwable) null);
            }
        } else {
            throw ParserException.e("Overriding TrackEncryptionBox parameters is unsupported.");
        }
    }

    public void a(long j2, long j3) {
        int size = this.f24578d.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f24578d.valueAt(i2).k();
        }
        this.f24588n.clear();
        this.f24596v = 0;
        this.f24597w = j3;
        this.f24587m.clear();
        e();
    }

    public void c(ExtractorOutput extractorOutput) {
        this.E = extractorOutput;
        e();
        k();
        Track track = this.f24576b;
        if (track != null) {
            this.f24578d.put(0, new TrackBundle(extractorOutput.d(0, track.f24660b), new TrackSampleTable(this.f24576b, new long[0], new int[0], 0, new long[0], new int[0], 0), new DefaultSampleValues(0, 0, 0, 0)));
            this.E.m();
        }
    }

    public boolean g(ExtractorInput extractorInput) throws IOException {
        return Sniffer.b(extractorInput);
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        while (true) {
            int i2 = this.f24590p;
            if (i2 != 0) {
                if (i2 == 1) {
                    L(extractorInput);
                } else if (i2 == 2) {
                    M(extractorInput);
                } else if (N(extractorInput)) {
                    return 0;
                }
            } else if (!K(extractorInput)) {
                return -1;
            }
        }
    }

    /* access modifiers changed from: protected */
    public Track n(Track track) {
        return track;
    }

    public void release() {
    }

    public FragmentedMp4Extractor(int i2) {
        this(i2, (TimestampAdjuster) null);
    }

    public FragmentedMp4Extractor(int i2, TimestampAdjuster timestampAdjuster) {
        this(i2, timestampAdjuster, (Track) null, Collections.emptyList());
    }

    public FragmentedMp4Extractor(int i2, TimestampAdjuster timestampAdjuster, Track track) {
        this(i2, timestampAdjuster, track, Collections.emptyList());
    }

    public FragmentedMp4Extractor(int i2, TimestampAdjuster timestampAdjuster, Track track, List<Format> list) {
        this(i2, timestampAdjuster, track, list, (TrackOutput) null);
    }

    public FragmentedMp4Extractor(int i2, TimestampAdjuster timestampAdjuster, Track track, List<Format> list, TrackOutput trackOutput) {
        this.f24575a = i2;
        this.f24584j = timestampAdjuster;
        this.f24576b = track;
        this.f24577c = Collections.unmodifiableList(list);
        this.f24589o = trackOutput;
        this.f24585k = new EventMessageEncoder();
        this.f24586l = new ParsableByteArray(16);
        this.f24579e = new ParsableByteArray(NalUnitUtil.f28716a);
        this.f24580f = new ParsableByteArray(5);
        this.f24581g = new ParsableByteArray();
        byte[] bArr = new byte[16];
        this.f24582h = bArr;
        this.f24583i = new ParsableByteArray(bArr);
        this.f24587m = new ArrayDeque<>();
        this.f24588n = new ArrayDeque<>();
        this.f24578d = new SparseArray<>();
        this.f24598x = -9223372036854775807L;
        this.f24597w = -9223372036854775807L;
        this.f24599y = -9223372036854775807L;
        this.E = ExtractorOutput.f24202z0;
        this.F = new TrackOutput[0];
        this.G = new TrackOutput[0];
    }
}
