package androidx.media3.extractor.mp4;

import android.util.Pair;
import android.util.SparseArray;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.CeaUtil;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SniffFailure;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.d;
import androidx.media3.extractor.metadata.emsg.EventMessageEncoder;
import androidx.media3.extractor.mp4.Atom;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import com.facebook.common.time.Clock;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.common.collect.ImmutableList;
import com.unity3d.services.core.device.MimeTypes;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import n.a;

public class FragmentedMp4Extractor implements Extractor {
    @Deprecated
    public static final ExtractorsFactory K = new a();
    private static final byte[] L = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final Format M = new Format.Builder().o0("application/x-emsg").K();
    private long A;
    private TrackBundle B;
    private int C;
    private int D;
    private int E;
    private boolean F;
    private ExtractorOutput G;
    private TrackOutput[] H;
    private TrackOutput[] I;
    private boolean J;

    /* renamed from: a  reason: collision with root package name */
    private final SubtitleParser.Factory f8571a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8572b;

    /* renamed from: c  reason: collision with root package name */
    private final Track f8573c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Format> f8574d;

    /* renamed from: e  reason: collision with root package name */
    private final SparseArray<TrackBundle> f8575e;

    /* renamed from: f  reason: collision with root package name */
    private final ParsableByteArray f8576f;

    /* renamed from: g  reason: collision with root package name */
    private final ParsableByteArray f8577g;

    /* renamed from: h  reason: collision with root package name */
    private final ParsableByteArray f8578h;

    /* renamed from: i  reason: collision with root package name */
    private final byte[] f8579i;

    /* renamed from: j  reason: collision with root package name */
    private final ParsableByteArray f8580j;

    /* renamed from: k  reason: collision with root package name */
    private final TimestampAdjuster f8581k;

    /* renamed from: l  reason: collision with root package name */
    private final EventMessageEncoder f8582l;

    /* renamed from: m  reason: collision with root package name */
    private final ParsableByteArray f8583m;

    /* renamed from: n  reason: collision with root package name */
    private final ArrayDeque<Atom.ContainerAtom> f8584n;

    /* renamed from: o  reason: collision with root package name */
    private final ArrayDeque<MetadataSampleInfo> f8585o;

    /* renamed from: p  reason: collision with root package name */
    private final TrackOutput f8586p;

    /* renamed from: q  reason: collision with root package name */
    private ImmutableList<SniffFailure> f8587q;

    /* renamed from: r  reason: collision with root package name */
    private int f8588r;

    /* renamed from: s  reason: collision with root package name */
    private int f8589s;

    /* renamed from: t  reason: collision with root package name */
    private long f8590t;

    /* renamed from: u  reason: collision with root package name */
    private int f8591u;

    /* renamed from: v  reason: collision with root package name */
    private ParsableByteArray f8592v;

    /* renamed from: w  reason: collision with root package name */
    private long f8593w;

    /* renamed from: x  reason: collision with root package name */
    private int f8594x;

    /* renamed from: y  reason: collision with root package name */
    private long f8595y;

    /* renamed from: z  reason: collision with root package name */
    private long f8596z;

    private static final class MetadataSampleInfo {

        /* renamed from: a  reason: collision with root package name */
        public final long f8597a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f8598b;

        /* renamed from: c  reason: collision with root package name */
        public final int f8599c;

        public MetadataSampleInfo(long j2, boolean z2, int i2) {
            this.f8597a = j2;
            this.f8598b = z2;
            this.f8599c = i2;
        }
    }

    private static final class TrackBundle {

        /* renamed from: a  reason: collision with root package name */
        public final TrackOutput f8600a;

        /* renamed from: b  reason: collision with root package name */
        public final TrackFragment f8601b = new TrackFragment();

        /* renamed from: c  reason: collision with root package name */
        public final ParsableByteArray f8602c = new ParsableByteArray();

        /* renamed from: d  reason: collision with root package name */
        public TrackSampleTable f8603d;

        /* renamed from: e  reason: collision with root package name */
        public DefaultSampleValues f8604e;

        /* renamed from: f  reason: collision with root package name */
        public int f8605f;

        /* renamed from: g  reason: collision with root package name */
        public int f8606g;

        /* renamed from: h  reason: collision with root package name */
        public int f8607h;

        /* renamed from: i  reason: collision with root package name */
        public int f8608i;

        /* renamed from: j  reason: collision with root package name */
        private final ParsableByteArray f8609j = new ParsableByteArray(1);

        /* renamed from: k  reason: collision with root package name */
        private final ParsableByteArray f8610k = new ParsableByteArray();
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public boolean f8611l;

        public TrackBundle(TrackOutput trackOutput, TrackSampleTable trackSampleTable, DefaultSampleValues defaultSampleValues) {
            this.f8600a = trackOutput;
            this.f8603d = trackSampleTable;
            this.f8604e = defaultSampleValues;
            j(trackSampleTable, defaultSampleValues);
        }

        public int c() {
            int i2;
            if (!this.f8611l) {
                i2 = this.f8603d.f8700g[this.f8605f];
            } else if (this.f8601b.f8686k[this.f8605f]) {
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
            if (!this.f8611l) {
                return this.f8603d.f8696c[this.f8605f];
            }
            return this.f8601b.f8682g[this.f8607h];
        }

        public long e() {
            if (!this.f8611l) {
                return this.f8603d.f8699f[this.f8605f];
            }
            return this.f8601b.c(this.f8605f);
        }

        public int f() {
            if (!this.f8611l) {
                return this.f8603d.f8697d[this.f8605f];
            }
            return this.f8601b.f8684i[this.f8605f];
        }

        public TrackEncryptionBox g() {
            if (!this.f8611l) {
                return null;
            }
            int i2 = ((DefaultSampleValues) Util.i(this.f8601b.f8676a)).f8561a;
            TrackEncryptionBox trackEncryptionBox = this.f8601b.f8689n;
            if (trackEncryptionBox == null) {
                trackEncryptionBox = this.f8603d.f8694a.a(i2);
            }
            if (trackEncryptionBox == null || !trackEncryptionBox.f8671a) {
                return null;
            }
            return trackEncryptionBox;
        }

        public boolean h() {
            this.f8605f++;
            if (!this.f8611l) {
                return false;
            }
            int i2 = this.f8606g + 1;
            this.f8606g = i2;
            int[] iArr = this.f8601b.f8683h;
            int i3 = this.f8607h;
            if (i2 != iArr[i3]) {
                return true;
            }
            this.f8607h = i3 + 1;
            this.f8606g = 0;
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
            int i5 = g2.f8674d;
            if (i5 != 0) {
                parsableByteArray = this.f8601b.f8690o;
            } else {
                byte[] bArr = (byte[]) Util.i(g2.f8675e);
                this.f8610k.S(bArr, bArr.length);
                ParsableByteArray parsableByteArray2 = this.f8610k;
                i5 = bArr.length;
                parsableByteArray = parsableByteArray2;
            }
            boolean g3 = this.f8601b.g(this.f8605f);
            if (g3 || i3 != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            byte[] e2 = this.f8609j.e();
            if (z2) {
                i4 = 128;
            } else {
                i4 = 0;
            }
            e2[0] = (byte) (i4 | i5);
            this.f8609j.U(0);
            this.f8600a.a(this.f8609j, 1, 1);
            this.f8600a.a(parsableByteArray, i5, 1);
            if (!z2) {
                return i5 + 1;
            }
            if (!g3) {
                this.f8602c.Q(8);
                byte[] e3 = this.f8602c.e();
                e3[0] = 0;
                e3[1] = 1;
                e3[2] = (byte) ((i3 >> 8) & JfifUtil.MARKER_FIRST_BYTE);
                e3[3] = (byte) (i3 & JfifUtil.MARKER_FIRST_BYTE);
                e3[4] = (byte) ((i2 >> 24) & JfifUtil.MARKER_FIRST_BYTE);
                e3[5] = (byte) ((i2 >> 16) & JfifUtil.MARKER_FIRST_BYTE);
                e3[6] = (byte) ((i2 >> 8) & JfifUtil.MARKER_FIRST_BYTE);
                e3[7] = (byte) (i2 & JfifUtil.MARKER_FIRST_BYTE);
                this.f8600a.a(this.f8602c, 8, 1);
                return i5 + 1 + 8;
            }
            ParsableByteArray parsableByteArray3 = this.f8601b.f8690o;
            int N = parsableByteArray3.N();
            parsableByteArray3.V(-2);
            int i6 = (N * 6) + 2;
            if (i3 != 0) {
                this.f8602c.Q(i6);
                byte[] e4 = this.f8602c.e();
                parsableByteArray3.l(e4, 0, i6);
                int i7 = (((e4[2] & 255) << 8) | (e4[3] & 255)) + i3;
                e4[2] = (byte) ((i7 >> 8) & JfifUtil.MARKER_FIRST_BYTE);
                e4[3] = (byte) (i7 & JfifUtil.MARKER_FIRST_BYTE);
                parsableByteArray3 = this.f8602c;
            }
            this.f8600a.a(parsableByteArray3, i6, 1);
            return i5 + 1 + i6;
        }

        public void j(TrackSampleTable trackSampleTable, DefaultSampleValues defaultSampleValues) {
            this.f8603d = trackSampleTable;
            this.f8604e = defaultSampleValues;
            this.f8600a.c(trackSampleTable.f8694a.f8665f);
            k();
        }

        public void k() {
            this.f8601b.f();
            this.f8605f = 0;
            this.f8607h = 0;
            this.f8606g = 0;
            this.f8608i = 0;
            this.f8611l = false;
        }

        public void l(long j2) {
            int i2 = this.f8605f;
            while (true) {
                TrackFragment trackFragment = this.f8601b;
                if (i2 < trackFragment.f8681f && trackFragment.c(i2) <= j2) {
                    if (this.f8601b.f8686k[i2]) {
                        this.f8608i = i2;
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
                ParsableByteArray parsableByteArray = this.f8601b.f8690o;
                int i2 = g2.f8674d;
                if (i2 != 0) {
                    parsableByteArray.V(i2);
                }
                if (this.f8601b.g(this.f8605f)) {
                    parsableByteArray.V(parsableByteArray.N() * 6);
                }
            }
        }

        public void n(DrmInitData drmInitData) {
            String str;
            TrackEncryptionBox a2 = this.f8603d.f8694a.a(((DefaultSampleValues) Util.i(this.f8601b.f8676a)).f8561a);
            if (a2 != null) {
                str = a2.f8672b;
            } else {
                str = null;
            }
            this.f8600a.c(this.f8603d.f8694a.f8665f.a().U(drmInitData.d(str)).K());
        }
    }

    @Deprecated
    public FragmentedMp4Extractor() {
        this(SubtitleParser.Factory.f8798a, 32, (TimestampAdjuster) null, (Track) null, ImmutableList.r(), (TrackOutput) null);
    }

    private static void A(TrackEncryptionBox trackEncryptionBox, ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        int i2;
        boolean z2;
        int i3 = trackEncryptionBox.f8674d;
        parsableByteArray.U(8);
        boolean z3 = true;
        if ((Atom.b(parsableByteArray.q()) & 1) == 1) {
            parsableByteArray.V(8);
        }
        int H2 = parsableByteArray.H();
        int L2 = parsableByteArray.L();
        if (L2 <= trackFragment.f8681f) {
            if (H2 == 0) {
                boolean[] zArr = trackFragment.f8688m;
                i2 = 0;
                for (int i4 = 0; i4 < L2; i4++) {
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
                i2 = (H2 * L2) + 0;
                Arrays.fill(trackFragment.f8688m, 0, L2, z3);
            }
            Arrays.fill(trackFragment.f8688m, L2, trackFragment.f8681f, false);
            if (i2 > 0) {
                trackFragment.d(i2);
                return;
            }
            return;
        }
        throw ParserException.a("Saiz sample count " + L2 + " is greater than fragment sample count" + trackFragment.f8681f, (Throwable) null);
    }

    private static void B(Atom.ContainerAtom containerAtom, String str, TrackFragment trackFragment) throws ParserException {
        boolean z2;
        Atom.ContainerAtom containerAtom2 = containerAtom;
        TrackFragment trackFragment2 = trackFragment;
        byte[] bArr = null;
        ParsableByteArray parsableByteArray = null;
        ParsableByteArray parsableByteArray2 = null;
        for (int i2 = 0; i2 < containerAtom2.f8526c.size(); i2++) {
            Atom.LeafAtom leafAtom = containerAtom2.f8526c.get(i2);
            ParsableByteArray parsableByteArray3 = leafAtom.f8528b;
            int i3 = leafAtom.f8524a;
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
                        throw ParserException.d("Variable length description in sgpd found (unsupported)");
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
                        trackFragment2.f8687l = true;
                        trackFragment2.f8689n = new TrackEncryptionBox(z2, str, H3, bArr2, i4, i5, bArr);
                        return;
                    }
                    return;
                }
                throw ParserException.d("Entry count in sgpd != 1 (unsupported).");
            }
            throw ParserException.d("Entry count in sbgp != 1 (unsupported).");
        }
    }

    private static void C(ParsableByteArray parsableByteArray, int i2, TrackFragment trackFragment) throws ParserException {
        boolean z2;
        parsableByteArray.U(i2 + 8);
        int b2 = Atom.b(parsableByteArray.q());
        if ((b2 & 1) == 0) {
            if ((b2 & 2) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            int L2 = parsableByteArray.L();
            if (L2 == 0) {
                Arrays.fill(trackFragment.f8688m, 0, trackFragment.f8681f, false);
            } else if (L2 == trackFragment.f8681f) {
                Arrays.fill(trackFragment.f8688m, 0, L2, z2);
                trackFragment.d(parsableByteArray.a());
                trackFragment.a(parsableByteArray);
            } else {
                throw ParserException.a("Senc sample count " + L2 + " is different from fragment sample count" + trackFragment.f8681f, (Throwable) null);
            }
        } else {
            throw ParserException.d("Overriding TrackEncryptionBox parameters is unsupported.");
        }
    }

    private static void D(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        C(parsableByteArray, 0, trackFragment);
    }

    private static Pair<Long, ChunkIndex> E(ParsableByteArray parsableByteArray, long j2) throws ParserException {
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
        long c12 = Util.c1(j5, 1000000, J2);
        parsableByteArray2.V(2);
        int N = parsableByteArray.N();
        int[] iArr = new int[N];
        long[] jArr = new long[N];
        long[] jArr2 = new long[N];
        long[] jArr3 = new long[N];
        long j7 = j5;
        long j8 = c12;
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
                long c13 = Util.c1(j9, 1000000, J2);
                jArr4[i2] = c13 - jArr5[i2];
                parsableByteArray2.V(4);
                j6 += (long) iArr2[i2];
                i2++;
                iArr = iArr2;
                jArr3 = jArr5;
                jArr2 = jArr4;
                jArr = jArr;
                N = i3;
                long j10 = c13;
                j7 = j9;
                j8 = j10;
            } else {
                throw ParserException.a("Unhandled indirect reference", (Throwable) null);
            }
        }
        return Pair.create(Long.valueOf(c12), new ChunkIndex(iArr, jArr, jArr2, jArr3));
    }

    private static long F(ParsableByteArray parsableByteArray) {
        parsableByteArray.U(8);
        if (Atom.c(parsableByteArray.q()) == 1) {
            return parsableByteArray.M();
        }
        return parsableByteArray.J();
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [android.util.SparseArray, android.util.SparseArray<androidx.media3.extractor.mp4.FragmentedMp4Extractor$TrackBundle>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.media3.extractor.mp4.FragmentedMp4Extractor.TrackBundle G(androidx.media3.common.util.ParsableByteArray r4, android.util.SparseArray<androidx.media3.extractor.mp4.FragmentedMp4Extractor.TrackBundle> r5, boolean r6) {
        /*
            r0 = 8
            r4.U(r0)
            int r0 = r4.q()
            int r0 = androidx.media3.extractor.mp4.Atom.b(r0)
            int r1 = r4.q()
            if (r6 == 0) goto L_0x0019
            r6 = 0
            java.lang.Object r5 = r5.valueAt(r6)
            goto L_0x001d
        L_0x0019:
            java.lang.Object r5 = r5.get(r1)
        L_0x001d:
            androidx.media3.extractor.mp4.FragmentedMp4Extractor$TrackBundle r5 = (androidx.media3.extractor.mp4.FragmentedMp4Extractor.TrackBundle) r5
            if (r5 != 0) goto L_0x0023
            r4 = 0
            return r4
        L_0x0023:
            r6 = r0 & 1
            if (r6 == 0) goto L_0x0031
            long r1 = r4.M()
            androidx.media3.extractor.mp4.TrackFragment r6 = r5.f8601b
            r6.f8678c = r1
            r6.f8679d = r1
        L_0x0031:
            androidx.media3.extractor.mp4.DefaultSampleValues r6 = r5.f8604e
            r1 = r0 & 2
            if (r1 == 0) goto L_0x003e
            int r1 = r4.q()
            int r1 = r1 + -1
            goto L_0x0040
        L_0x003e:
            int r1 = r6.f8561a
        L_0x0040:
            r2 = r0 & 8
            if (r2 == 0) goto L_0x0049
            int r2 = r4.q()
            goto L_0x004b
        L_0x0049:
            int r2 = r6.f8562b
        L_0x004b:
            r3 = r0 & 16
            if (r3 == 0) goto L_0x0054
            int r3 = r4.q()
            goto L_0x0056
        L_0x0054:
            int r3 = r6.f8563c
        L_0x0056:
            r0 = r0 & 32
            if (r0 == 0) goto L_0x005f
            int r4 = r4.q()
            goto L_0x0061
        L_0x005f:
            int r4 = r6.f8564d
        L_0x0061:
            androidx.media3.extractor.mp4.TrackFragment r6 = r5.f8601b
            androidx.media3.extractor.mp4.DefaultSampleValues r0 = new androidx.media3.extractor.mp4.DefaultSampleValues
            r0.<init>(r1, r2, r3, r4)
            r6.f8676a = r0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.FragmentedMp4Extractor.G(androidx.media3.common.util.ParsableByteArray, android.util.SparseArray, boolean):androidx.media3.extractor.mp4.FragmentedMp4Extractor$TrackBundle");
    }

    private static void H(Atom.ContainerAtom containerAtom, SparseArray<TrackBundle> sparseArray, boolean z2, int i2, byte[] bArr) throws ParserException {
        String str;
        TrackBundle G2 = G(((Atom.LeafAtom) Assertions.f(containerAtom.g(1952868452))).f8528b, sparseArray, z2);
        if (G2 != null) {
            TrackFragment trackFragment = G2.f8601b;
            long j2 = trackFragment.f8692q;
            boolean z3 = trackFragment.f8693r;
            G2.k();
            boolean unused = G2.f8611l = true;
            Atom.LeafAtom g2 = containerAtom.g(1952867444);
            if (g2 == null || (i2 & 2) != 0) {
                trackFragment.f8692q = j2;
                trackFragment.f8693r = z3;
            } else {
                trackFragment.f8692q = F(g2.f8528b);
                trackFragment.f8693r = true;
            }
            K(containerAtom, G2, i2);
            TrackEncryptionBox a2 = G2.f8603d.f8694a.a(((DefaultSampleValues) Assertions.f(trackFragment.f8676a)).f8561a);
            Atom.LeafAtom g3 = containerAtom.g(1935763834);
            if (g3 != null) {
                A((TrackEncryptionBox) Assertions.f(a2), g3.f8528b, trackFragment);
            }
            Atom.LeafAtom g4 = containerAtom.g(1935763823);
            if (g4 != null) {
                z(g4.f8528b, trackFragment);
            }
            Atom.LeafAtom g5 = containerAtom.g(1936027235);
            if (g5 != null) {
                D(g5.f8528b, trackFragment);
            }
            if (a2 != null) {
                str = a2.f8672b;
            } else {
                str = null;
            }
            B(containerAtom, str, trackFragment);
            int size = containerAtom.f8526c.size();
            for (int i3 = 0; i3 < size; i3++) {
                Atom.LeafAtom leafAtom = containerAtom.f8526c.get(i3);
                if (leafAtom.f8524a == 1970628964) {
                    L(leafAtom.f8528b, trackFragment, bArr);
                }
            }
        }
    }

    private static Pair<Integer, DefaultSampleValues> I(ParsableByteArray parsableByteArray) {
        parsableByteArray.U(12);
        return Pair.create(Integer.valueOf(parsableByteArray.q()), new DefaultSampleValues(parsableByteArray.q() - 1, parsableByteArray.q(), parsableByteArray.q(), parsableByteArray.q()));
    }

    private static int J(TrackBundle trackBundle, int i2, int i3, ParsableByteArray parsableByteArray, int i4) throws ParserException {
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
        Track track = trackBundle2.f8603d.f8694a;
        TrackFragment trackFragment = trackBundle2.f8601b;
        DefaultSampleValues defaultSampleValues = (DefaultSampleValues) Util.i(trackFragment.f8676a);
        trackFragment.f8683h[i2] = parsableByteArray.L();
        long[] jArr = trackFragment.f8682g;
        long j3 = trackFragment.f8678c;
        jArr[i2] = j3;
        if ((b2 & 1) != 0) {
            jArr[i2] = j3 + ((long) parsableByteArray.q());
        }
        if ((b2 & 4) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i9 = defaultSampleValues.f8564d;
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
        if (o(track)) {
            j2 = ((long[]) Util.i(track.f8668i))[0];
        } else {
            j2 = 0;
        }
        int[] iArr = trackFragment.f8684i;
        long[] jArr2 = trackFragment.f8685j;
        boolean[] zArr = trackFragment.f8686k;
        int i10 = i9;
        if (track.f8661b != 2 || (i3 & 1) == 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        int i11 = i4 + trackFragment.f8683h[i2];
        boolean z14 = z7;
        long[] jArr3 = jArr2;
        boolean[] zArr2 = zArr;
        long j4 = track.f8662c;
        long j5 = trackFragment.f8692q;
        int i12 = i4;
        while (i12 < i11) {
            if (z3) {
                i5 = parsableByteArray.q();
            } else {
                i5 = defaultSampleValues.f8562b;
            }
            int d2 = d(i5);
            if (z4) {
                i6 = parsableByteArray.q();
                z8 = z3;
            } else {
                z8 = z3;
                i6 = defaultSampleValues.f8563c;
            }
            int d3 = d(i6);
            if (z5) {
                z9 = z2;
                i7 = parsableByteArray.q();
            } else if (i12 != 0 || !z2) {
                z9 = z2;
                i7 = defaultSampleValues.f8564d;
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
            long c12 = Util.c1((((long) i8) + j5) - j2, 1000000, j4);
            jArr3[i12] = c12;
            if (!trackFragment.f8693r) {
                jArr3[i12] = c12 + trackBundle2.f8603d.f8701h;
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
        trackFragment.f8692q = j5;
        return i11;
    }

    private static void K(Atom.ContainerAtom containerAtom, TrackBundle trackBundle, int i2) throws ParserException {
        List<Atom.LeafAtom> list = containerAtom.f8526c;
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Atom.LeafAtom leafAtom = list.get(i5);
            if (leafAtom.f8524a == 1953658222) {
                ParsableByteArray parsableByteArray = leafAtom.f8528b;
                parsableByteArray.U(12);
                int L2 = parsableByteArray.L();
                if (L2 > 0) {
                    i4 += L2;
                    i3++;
                }
            }
        }
        trackBundle.f8607h = 0;
        trackBundle.f8606g = 0;
        trackBundle.f8605f = 0;
        trackBundle.f8601b.e(i3, i4);
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            Atom.LeafAtom leafAtom2 = list.get(i8);
            if (leafAtom2.f8524a == 1953658222) {
                i7 = J(trackBundle, i6, i2, leafAtom2.f8528b, i7);
                i6++;
            }
        }
    }

    private static void L(ParsableByteArray parsableByteArray, TrackFragment trackFragment, byte[] bArr) throws ParserException {
        parsableByteArray.U(8);
        parsableByteArray.l(bArr, 0, 16);
        if (Arrays.equals(bArr, L)) {
            C(parsableByteArray, 16, trackFragment);
        }
    }

    private void M(long j2) throws ParserException {
        while (!this.f8584n.isEmpty() && this.f8584n.peek().f8525b == j2) {
            r(this.f8584n.pop());
        }
        e();
    }

    private boolean N(ExtractorInput extractorInput) throws IOException {
        if (this.f8591u == 0) {
            if (!extractorInput.f(this.f8583m.e(), 0, 8, true)) {
                return false;
            }
            this.f8591u = 8;
            this.f8583m.U(0);
            this.f8590t = this.f8583m.J();
            this.f8589s = this.f8583m.q();
        }
        long j2 = this.f8590t;
        if (j2 == 1) {
            extractorInput.readFully(this.f8583m.e(), 8, 8);
            this.f8591u += 8;
            this.f8590t = this.f8583m.M();
        } else if (j2 == 0) {
            long length = extractorInput.getLength();
            if (length == -1 && !this.f8584n.isEmpty()) {
                length = this.f8584n.peek().f8525b;
            }
            if (length != -1) {
                this.f8590t = (length - extractorInput.getPosition()) + ((long) this.f8591u);
            }
        }
        if (this.f8590t >= ((long) this.f8591u)) {
            long position = extractorInput.getPosition() - ((long) this.f8591u);
            int i2 = this.f8589s;
            if ((i2 == 1836019558 || i2 == 1835295092) && !this.J) {
                this.G.r(new SeekMap.Unseekable(this.f8596z, position));
                this.J = true;
            }
            if (this.f8589s == 1836019558) {
                int size = this.f8575e.size();
                for (int i3 = 0; i3 < size; i3++) {
                    TrackFragment trackFragment = this.f8575e.valueAt(i3).f8601b;
                    trackFragment.f8677b = position;
                    trackFragment.f8679d = position;
                    trackFragment.f8678c = position;
                }
            }
            int i4 = this.f8589s;
            if (i4 == 1835295092) {
                this.B = null;
                this.f8593w = position + this.f8590t;
                this.f8588r = 2;
                return true;
            }
            if (R(i4)) {
                long position2 = (extractorInput.getPosition() + this.f8590t) - 8;
                this.f8584n.push(new Atom.ContainerAtom(this.f8589s, position2));
                if (this.f8590t == ((long) this.f8591u)) {
                    M(position2);
                } else {
                    e();
                }
            } else if (S(this.f8589s)) {
                if (this.f8591u != 8) {
                    throw ParserException.d("Leaf atom defines extended atom size (unsupported).");
                } else if (this.f8590t <= 2147483647L) {
                    ParsableByteArray parsableByteArray = new ParsableByteArray((int) this.f8590t);
                    System.arraycopy(this.f8583m.e(), 0, parsableByteArray.e(), 0, 8);
                    this.f8592v = parsableByteArray;
                    this.f8588r = 1;
                } else {
                    throw ParserException.d("Leaf atom with length > 2147483647 (unsupported).");
                }
            } else if (this.f8590t <= 2147483647L) {
                this.f8592v = null;
                this.f8588r = 1;
            } else {
                throw ParserException.d("Skipping atom with length > 2147483647 (unsupported).");
            }
            return true;
        }
        throw ParserException.d("Atom size less than header length (unsupported).");
    }

    private void O(ExtractorInput extractorInput) throws IOException {
        int i2 = ((int) this.f8590t) - this.f8591u;
        ParsableByteArray parsableByteArray = this.f8592v;
        if (parsableByteArray != null) {
            extractorInput.readFully(parsableByteArray.e(), 8, i2);
            t(new Atom.LeafAtom(this.f8589s, parsableByteArray), extractorInput.getPosition());
        } else {
            extractorInput.k(i2);
        }
        M(extractorInput.getPosition());
    }

    private void P(ExtractorInput extractorInput) throws IOException {
        int size = this.f8575e.size();
        long j2 = Clock.MAX_TIME;
        TrackBundle trackBundle = null;
        for (int i2 = 0; i2 < size; i2++) {
            TrackFragment trackFragment = this.f8575e.valueAt(i2).f8601b;
            if (trackFragment.f8691p) {
                long j3 = trackFragment.f8679d;
                if (j3 < j2) {
                    trackBundle = this.f8575e.valueAt(i2);
                    j2 = j3;
                }
            }
        }
        if (trackBundle == null) {
            this.f8588r = 3;
            return;
        }
        int position = (int) (j2 - extractorInput.getPosition());
        if (position >= 0) {
            extractorInput.k(position);
            trackBundle.f8601b.b(extractorInput);
            return;
        }
        throw ParserException.a("Offset to encryption data was negative.", (Throwable) null);
    }

    private boolean Q(ExtractorInput extractorInput) throws IOException {
        TrackOutput.CryptoData cryptoData;
        int i2;
        boolean z2;
        ExtractorInput extractorInput2 = extractorInput;
        TrackBundle trackBundle = this.B;
        Throwable th = null;
        if (trackBundle == null) {
            trackBundle = l(this.f8575e);
            if (trackBundle == null) {
                int position = (int) (this.f8593w - extractorInput.getPosition());
                if (position >= 0) {
                    extractorInput2.k(position);
                    e();
                    return false;
                }
                throw ParserException.a("Offset to end of mdat was negative.", (Throwable) null);
            }
            int d2 = (int) (trackBundle.d() - extractorInput.getPosition());
            if (d2 < 0) {
                Log.h("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                d2 = 0;
            }
            extractorInput2.k(d2);
            this.B = trackBundle;
        }
        int i3 = 4;
        int i4 = 1;
        if (this.f8588r == 3) {
            int f2 = trackBundle.f();
            this.C = f2;
            if (trackBundle.f8605f < trackBundle.f8608i) {
                extractorInput2.k(f2);
                trackBundle.m();
                if (!trackBundle.h()) {
                    this.B = null;
                }
                this.f8588r = 3;
                return true;
            }
            if (trackBundle.f8603d.f8694a.f8666g == 1) {
                this.C = f2 - 8;
                extractorInput2.k(8);
            }
            if ("audio/ac4".equals(trackBundle.f8603d.f8694a.f8665f.f4015n)) {
                this.D = trackBundle.i(this.C, 7);
                Ac4Util.a(this.C, this.f8580j);
                trackBundle.f8600a.b(this.f8580j, 7);
                this.D += 7;
            } else {
                this.D = trackBundle.i(this.C, 0);
            }
            this.C += this.D;
            this.f8588r = 4;
            this.E = 0;
        }
        Track track = trackBundle.f8603d.f8694a;
        TrackOutput trackOutput = trackBundle.f8600a;
        long e2 = trackBundle.e();
        TimestampAdjuster timestampAdjuster = this.f8581k;
        if (timestampAdjuster != null) {
            e2 = timestampAdjuster.a(e2);
        }
        long j2 = e2;
        if (track.f8669j == 0) {
            while (true) {
                int i5 = this.D;
                int i6 = this.C;
                if (i5 >= i6) {
                    break;
                }
                this.D += trackOutput.d(extractorInput2, i6 - i5, false);
            }
        } else {
            byte[] e3 = this.f8577g.e();
            e3[0] = 0;
            e3[1] = 0;
            e3[2] = 0;
            int i7 = track.f8669j;
            int i8 = i7 + 1;
            int i9 = 4 - i7;
            while (this.D < this.C) {
                int i10 = this.E;
                if (i10 == 0) {
                    extractorInput2.readFully(e3, i9, i8);
                    this.f8577g.U(0);
                    int q2 = this.f8577g.q();
                    if (q2 >= i4) {
                        this.E = q2 - 1;
                        this.f8576f.U(0);
                        trackOutput.b(this.f8576f, i3);
                        trackOutput.b(this.f8577g, i4);
                        if (this.I.length <= 0 || !NalUnitUtil.g(track.f8665f.f4015n, e3[i3])) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        this.F = z2;
                        this.D += 5;
                        this.C += i9;
                    } else {
                        throw ParserException.a("Invalid NAL length", th);
                    }
                } else {
                    if (this.F) {
                        this.f8578h.Q(i10);
                        extractorInput2.readFully(this.f8578h.e(), 0, this.E);
                        trackOutput.b(this.f8578h, this.E);
                        i2 = this.E;
                        int r2 = NalUnitUtil.r(this.f8578h.e(), this.f8578h.g());
                        this.f8578h.U(MimeTypes.VIDEO_H265.equals(track.f8665f.f4015n) ? 1 : 0);
                        this.f8578h.T(r2);
                        CeaUtil.a(j2, this.f8578h, this.I);
                    } else {
                        i2 = trackOutput.d(extractorInput2, i10, false);
                    }
                    this.D += i2;
                    this.E -= i2;
                    th = null;
                    i3 = 4;
                    i4 = 1;
                }
            }
        }
        int c2 = trackBundle.c();
        TrackEncryptionBox g2 = trackBundle.g();
        if (g2 != null) {
            cryptoData = g2.f8673c;
        } else {
            cryptoData = null;
        }
        trackOutput.f(j2, c2, this.C, 0, cryptoData);
        w(j2);
        if (!trackBundle.h()) {
            this.B = null;
        }
        this.f8588r = 3;
        return true;
    }

    private static boolean R(int i2) {
        return i2 == 1836019574 || i2 == 1953653099 || i2 == 1835297121 || i2 == 1835626086 || i2 == 1937007212 || i2 == 1836019558 || i2 == 1953653094 || i2 == 1836475768 || i2 == 1701082227;
    }

    private static boolean S(int i2) {
        return i2 == 1751411826 || i2 == 1835296868 || i2 == 1836476516 || i2 == 1936286840 || i2 == 1937011556 || i2 == 1937011827 || i2 == 1668576371 || i2 == 1937011555 || i2 == 1937011578 || i2 == 1937013298 || i2 == 1937007471 || i2 == 1668232756 || i2 == 1937011571 || i2 == 1952867444 || i2 == 1952868452 || i2 == 1953196132 || i2 == 1953654136 || i2 == 1953658222 || i2 == 1886614376 || i2 == 1935763834 || i2 == 1935763823 || i2 == 1936027235 || i2 == 1970628964 || i2 == 1935828848 || i2 == 1936158820 || i2 == 1701606260 || i2 == 1835362404 || i2 == 1701671783;
    }

    private static int d(int i2) throws ParserException {
        if (i2 >= 0) {
            return i2;
        }
        throw ParserException.a("Unexpected negative value: " + i2, (Throwable) null);
    }

    private void e() {
        this.f8588r = 0;
        this.f8591u = 0;
    }

    private DefaultSampleValues f(SparseArray<DefaultSampleValues> sparseArray, int i2) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return (DefaultSampleValues) Assertions.f(sparseArray.get(i2));
    }

    private static DrmInitData h(List<Atom.LeafAtom> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            Atom.LeafAtom leafAtom = list.get(i2);
            if (leafAtom.f8524a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] e2 = leafAtom.f8528b.e();
                UUID f2 = PsshAtomUtil.f(e2);
                if (f2 == null) {
                    Log.h("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
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

    private static TrackBundle l(SparseArray<TrackBundle> sparseArray) {
        int size = sparseArray.size();
        TrackBundle trackBundle = null;
        long j2 = Clock.MAX_TIME;
        for (int i2 = 0; i2 < size; i2++) {
            TrackBundle valueAt = sparseArray.valueAt(i2);
            if ((valueAt.f8611l || valueAt.f8605f != valueAt.f8603d.f8695b) && (!valueAt.f8611l || valueAt.f8607h != valueAt.f8601b.f8680e)) {
                long d2 = valueAt.d();
                if (d2 < j2) {
                    trackBundle = valueAt;
                    j2 = d2;
                }
            }
        }
        return trackBundle;
    }

    private void n() {
        int i2;
        TrackOutput[] trackOutputArr = new TrackOutput[2];
        this.H = trackOutputArr;
        TrackOutput trackOutput = this.f8586p;
        int i3 = 0;
        if (trackOutput != null) {
            trackOutputArr[0] = trackOutput;
            i2 = 1;
        } else {
            i2 = 0;
        }
        int i4 = 100;
        if ((this.f8572b & 4) != 0) {
            trackOutputArr[i2] = this.G.d(100, 5);
            i4 = 101;
            i2++;
        }
        TrackOutput[] trackOutputArr2 = (TrackOutput[]) Util.U0(this.H, i2);
        this.H = trackOutputArr2;
        for (TrackOutput c2 : trackOutputArr2) {
            c2.c(M);
        }
        this.I = new TrackOutput[this.f8574d.size()];
        while (i3 < this.I.length) {
            TrackOutput d2 = this.G.d(i4, 3);
            d2.c(this.f8574d.get(i3));
            this.I[i3] = d2;
            i3++;
            i4++;
        }
    }

    private static boolean o(Track track) {
        long[] jArr;
        long[] jArr2 = track.f8667h;
        if (jArr2 == null || jArr2.length != 1 || (jArr = track.f8668i) == null) {
            return false;
        }
        long j2 = jArr2[0];
        if (j2 != 0 && Util.c1(j2 + jArr[0], 1000000, track.f8663d) < track.f8664e) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] p() {
        return new Extractor[]{new FragmentedMp4Extractor(SubtitleParser.Factory.f8798a, 32)};
    }

    private void r(Atom.ContainerAtom containerAtom) throws ParserException {
        int i2 = containerAtom.f8524a;
        if (i2 == 1836019574) {
            v(containerAtom);
        } else if (i2 == 1836019558) {
            u(containerAtom);
        } else if (!this.f8584n.isEmpty()) {
            this.f8584n.peek().d(containerAtom);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void s(androidx.media3.common.util.ParsableByteArray r28) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            androidx.media3.extractor.TrackOutput[] r2 = r0.H
            int r2 = r2.length
            if (r2 != 0) goto L_0x000a
            return
        L_0x000a:
            r2 = 8
            r1.U(r2)
            int r2 = r28.q()
            int r2 = androidx.media3.extractor.mp4.Atom.c(r2)
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
            androidx.media3.common.util.Log.h(r2, r1)
            return
        L_0x0038:
            long r12 = r28.J()
            long r6 = r28.M()
            r8 = 1000000(0xf4240, double:4.940656E-318)
            r10 = r12
            long r14 = androidx.media3.common.util.Util.c1(r6, r8, r10)
            long r6 = r28.J()
            r8 = 1000(0x3e8, double:4.94E-321)
            long r6 = androidx.media3.common.util.Util.c1(r6, r8, r10)
            long r8 = r28.J()
            java.lang.String r2 = r28.B()
            java.lang.Object r2 = androidx.media3.common.util.Assertions.f(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r10 = r28.B()
            java.lang.Object r10 = androidx.media3.common.util.Assertions.f(r10)
            java.lang.String r10 = (java.lang.String) r10
            r20 = r2
            r22 = r6
            r24 = r8
            r21 = r10
            r8 = r4
            goto L_0x00be
        L_0x0074:
            java.lang.String r2 = r28.B()
            java.lang.Object r2 = androidx.media3.common.util.Assertions.f(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r6 = r28.B()
            java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r6)
            r10 = r6
            java.lang.String r10 = (java.lang.String) r10
            long r6 = r28.J()
            long r11 = r28.J()
            r13 = 1000000(0xf4240, double:4.940656E-318)
            r15 = r6
            long r8 = androidx.media3.common.util.Util.c1(r11, r13, r15)
            long r11 = r0.A
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
            long r6 = androidx.media3.common.util.Util.c1(r11, r13, r15)
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
            androidx.media3.extractor.metadata.emsg.EventMessage r1 = new androidx.media3.extractor.metadata.emsg.EventMessage
            r19 = r1
            r26 = r2
            r19.<init>(r20, r21, r22, r24, r26)
            androidx.media3.common.util.ParsableByteArray r2 = new androidx.media3.common.util.ParsableByteArray
            androidx.media3.extractor.metadata.emsg.EventMessageEncoder r6 = r0.f8582l
            byte[] r1 = r6.a(r1)
            r2.<init>((byte[]) r1)
            int r1 = r2.a()
            androidx.media3.extractor.TrackOutput[] r6 = r0.H
            int r10 = r6.length
            r11 = 0
        L_0x00e8:
            if (r11 >= r10) goto L_0x00f5
            r12 = r6[r11]
            r2.U(r7)
            r12.b(r2, r1)
            int r11 = r11 + 1
            goto L_0x00e8
        L_0x00f5:
            int r2 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0109
            java.util.ArrayDeque<androidx.media3.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo> r2 = r0.f8585o
            androidx.media3.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo r4 = new androidx.media3.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo
            r4.<init>(r8, r3, r1)
            r2.addLast(r4)
            int r2 = r0.f8594x
            int r2 = r2 + r1
            r0.f8594x = r2
            goto L_0x015a
        L_0x0109:
            java.util.ArrayDeque<androidx.media3.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo> r2 = r0.f8585o
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0121
            java.util.ArrayDeque<androidx.media3.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo> r2 = r0.f8585o
            androidx.media3.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo r3 = new androidx.media3.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo
            r3.<init>(r14, r7, r1)
            r2.addLast(r3)
            int r2 = r0.f8594x
            int r2 = r2 + r1
            r0.f8594x = r2
            goto L_0x015a
        L_0x0121:
            androidx.media3.common.util.TimestampAdjuster r2 = r0.f8581k
            if (r2 == 0) goto L_0x013b
            boolean r2 = r2.g()
            if (r2 != 0) goto L_0x013b
            java.util.ArrayDeque<androidx.media3.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo> r2 = r0.f8585o
            androidx.media3.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo r3 = new androidx.media3.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo
            r3.<init>(r14, r7, r1)
            r2.addLast(r3)
            int r2 = r0.f8594x
            int r2 = r2 + r1
            r0.f8594x = r2
            goto L_0x015a
        L_0x013b:
            androidx.media3.common.util.TimestampAdjuster r2 = r0.f8581k
            if (r2 == 0) goto L_0x0143
            long r14 = r2.a(r14)
        L_0x0143:
            androidx.media3.extractor.TrackOutput[] r2 = r0.H
            int r3 = r2.length
        L_0x0146:
            if (r7 >= r3) goto L_0x015a
            r16 = r2[r7]
            r19 = 1
            r21 = 0
            r22 = 0
            r17 = r14
            r20 = r1
            r16.f(r17, r19, r20, r21, r22)
            int r7 = r7 + 1
            goto L_0x0146
        L_0x015a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.FragmentedMp4Extractor.s(androidx.media3.common.util.ParsableByteArray):void");
    }

    private void t(Atom.LeafAtom leafAtom, long j2) throws ParserException {
        if (!this.f8584n.isEmpty()) {
            this.f8584n.peek().e(leafAtom);
            return;
        }
        int i2 = leafAtom.f8524a;
        if (i2 == 1936286840) {
            Pair<Long, ChunkIndex> E2 = E(leafAtom.f8528b, j2);
            this.A = ((Long) E2.first).longValue();
            this.G.r((SeekMap) E2.second);
            this.J = true;
        } else if (i2 == 1701671783) {
            s(leafAtom.f8528b);
        }
    }

    private void u(Atom.ContainerAtom containerAtom) throws ParserException {
        boolean z2;
        SparseArray<TrackBundle> sparseArray = this.f8575e;
        if (this.f8573c != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        y(containerAtom, sparseArray, z2, this.f8572b, this.f8579i);
        DrmInitData h2 = h(containerAtom.f8526c);
        if (h2 != null) {
            int size = this.f8575e.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f8575e.valueAt(i2).n(h2);
            }
        }
        if (this.f8595y != -9223372036854775807L) {
            int size2 = this.f8575e.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.f8575e.valueAt(i3).l(this.f8595y);
            }
            this.f8595y = -9223372036854775807L;
        }
    }

    private void v(Atom.ContainerAtom containerAtom) throws ParserException {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        int i2 = 0;
        if (this.f8573c == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.i(z2, "Unexpected moov box.");
        DrmInitData h2 = h(containerAtom.f8526c);
        Atom.ContainerAtom containerAtom2 = (Atom.ContainerAtom) Assertions.f(containerAtom.f(1836475768));
        SparseArray sparseArray = new SparseArray();
        int size = containerAtom2.f8526c.size();
        long j2 = -9223372036854775807L;
        for (int i3 = 0; i3 < size; i3++) {
            Atom.LeafAtom leafAtom = containerAtom2.f8526c.get(i3);
            int i4 = leafAtom.f8524a;
            if (i4 == 1953654136) {
                Pair<Integer, DefaultSampleValues> I2 = I(leafAtom.f8528b);
                sparseArray.put(((Integer) I2.first).intValue(), (DefaultSampleValues) I2.second);
            } else if (i4 == 1835362404) {
                j2 = x(leafAtom.f8528b);
            }
        }
        GaplessInfoHolder gaplessInfoHolder = new GaplessInfoHolder();
        if ((this.f8572b & 16) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        List<TrackSampleTable> B2 = AtomParsers.B(containerAtom, gaplessInfoHolder, j2, h2, z3, false, new a(this));
        int size2 = B2.size();
        if (this.f8575e.size() == 0) {
            while (i2 < size2) {
                TrackSampleTable trackSampleTable = B2.get(i2);
                Track track = trackSampleTable.f8694a;
                this.f8575e.put(track.f8660a, new TrackBundle(this.G.d(i2, track.f8661b), trackSampleTable, f(sparseArray, track.f8660a)));
                this.f8596z = Math.max(this.f8596z, track.f8664e);
                i2++;
            }
            this.G.m();
            return;
        }
        if (this.f8575e.size() != size2) {
            z4 = false;
        }
        Assertions.h(z4);
        while (i2 < size2) {
            TrackSampleTable trackSampleTable2 = B2.get(i2);
            Track track2 = trackSampleTable2.f8694a;
            this.f8575e.get(track2.f8660a).j(trackSampleTable2, f(sparseArray, track2.f8660a));
            i2++;
        }
    }

    private void w(long j2) {
        while (!this.f8585o.isEmpty()) {
            MetadataSampleInfo removeFirst = this.f8585o.removeFirst();
            this.f8594x -= removeFirst.f8599c;
            long j3 = removeFirst.f8597a;
            if (removeFirst.f8598b) {
                j3 += j2;
            }
            TimestampAdjuster timestampAdjuster = this.f8581k;
            if (timestampAdjuster != null) {
                j3 = timestampAdjuster.a(j3);
            }
            for (TrackOutput f2 : this.H) {
                f2.f(j3, 1, removeFirst.f8599c, this.f8594x, (TrackOutput.CryptoData) null);
            }
        }
    }

    private static long x(ParsableByteArray parsableByteArray) {
        parsableByteArray.U(8);
        if (Atom.c(parsableByteArray.q()) == 0) {
            return parsableByteArray.J();
        }
        return parsableByteArray.M();
    }

    private static void y(Atom.ContainerAtom containerAtom, SparseArray<TrackBundle> sparseArray, boolean z2, int i2, byte[] bArr) throws ParserException {
        int size = containerAtom.f8527d.size();
        for (int i3 = 0; i3 < size; i3++) {
            Atom.ContainerAtom containerAtom2 = containerAtom.f8527d.get(i3);
            if (containerAtom2.f8524a == 1953653094) {
                H(containerAtom2, sparseArray, z2, i2, bArr);
            }
        }
    }

    private static void z(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        long j2;
        parsableByteArray.U(8);
        int q2 = parsableByteArray.q();
        if ((Atom.b(q2) & 1) == 1) {
            parsableByteArray.V(8);
        }
        int L2 = parsableByteArray.L();
        if (L2 == 1) {
            int c2 = Atom.c(q2);
            long j3 = trackFragment.f8679d;
            if (c2 == 0) {
                j2 = parsableByteArray.J();
            } else {
                j2 = parsableByteArray.M();
            }
            trackFragment.f8679d = j3 + j2;
            return;
        }
        throw ParserException.a("Unexpected saio entry count: " + L2, (Throwable) null);
    }

    public void a(long j2, long j3) {
        int size = this.f8575e.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f8575e.valueAt(i2).k();
        }
        this.f8585o.clear();
        this.f8594x = 0;
        this.f8595y = j3;
        this.f8584n.clear();
        e();
    }

    public /* synthetic */ Extractor c() {
        return d.b(this);
    }

    public void g(ExtractorOutput extractorOutput) {
        ExtractorOutput extractorOutput2;
        if ((this.f8572b & 32) == 0) {
            extractorOutput2 = new SubtitleTranscodingExtractorOutput(extractorOutput, this.f8571a);
        } else {
            extractorOutput2 = extractorOutput;
        }
        this.G = extractorOutput2;
        e();
        n();
        Track track = this.f8573c;
        if (track != null) {
            this.f8575e.put(0, new TrackBundle(extractorOutput.d(0, track.f8661b), new TrackSampleTable(this.f8573c, new long[0], new int[0], 0, new long[0], new int[0], 0), new DefaultSampleValues(0, 0, 0, 0)));
            this.G.m();
        }
    }

    public boolean i(ExtractorInput extractorInput) throws IOException {
        ImmutableList<SniffFailure> immutableList;
        SniffFailure b2 = Sniffer.b(extractorInput);
        if (b2 != null) {
            immutableList = ImmutableList.s(b2);
        } else {
            immutableList = ImmutableList.r();
        }
        this.f8587q = immutableList;
        if (b2 == null) {
            return true;
        }
        return false;
    }

    public int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        while (true) {
            int i2 = this.f8588r;
            if (i2 != 0) {
                if (i2 == 1) {
                    O(extractorInput);
                } else if (i2 == 2) {
                    P(extractorInput);
                } else if (Q(extractorInput)) {
                    return 0;
                }
            } else if (!N(extractorInput)) {
                return -1;
            }
        }
    }

    /* renamed from: m */
    public ImmutableList<SniffFailure> j() {
        return this.f8587q;
    }

    /* access modifiers changed from: protected */
    public Track q(Track track) {
        return track;
    }

    public void release() {
    }

    public FragmentedMp4Extractor(SubtitleParser.Factory factory, int i2) {
        this(factory, i2, (TimestampAdjuster) null, (Track) null, ImmutableList.r(), (TrackOutput) null);
    }

    public FragmentedMp4Extractor(SubtitleParser.Factory factory, int i2, TimestampAdjuster timestampAdjuster, Track track, List<Format> list, TrackOutput trackOutput) {
        this.f8571a = factory;
        this.f8572b = i2;
        this.f8581k = timestampAdjuster;
        this.f8573c = track;
        this.f8574d = Collections.unmodifiableList(list);
        this.f8586p = trackOutput;
        this.f8582l = new EventMessageEncoder();
        this.f8583m = new ParsableByteArray(16);
        this.f8576f = new ParsableByteArray(NalUnitUtil.f4748a);
        this.f8577g = new ParsableByteArray(5);
        this.f8578h = new ParsableByteArray();
        byte[] bArr = new byte[16];
        this.f8579i = bArr;
        this.f8580j = new ParsableByteArray(bArr);
        this.f8584n = new ArrayDeque<>();
        this.f8585o = new ArrayDeque<>();
        this.f8575e = new SparseArray<>();
        this.f8587q = ImmutableList.r();
        this.f8596z = -9223372036854775807L;
        this.f8595y = -9223372036854775807L;
        this.A = -9223372036854775807L;
        this.G = ExtractorOutput.f8013y0;
        this.H = new TrackOutput[0];
        this.I = new TrackOutput[0];
    }
}
