package androidx.media3.extractor.mp4;

import android.util.Pair;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.Mp4LocationData;
import androidx.media3.container.Mp4TimestampData;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.Ac3Util;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.ExtractorUtil;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.OpusUtil;
import androidx.media3.extractor.VorbisUtil;
import androidx.media3.extractor.mp4.Atom;
import com.facebook.common.time.Clock;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

final class AtomParsers {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f8529a = Util.t0("OpusHead");

    private static final class ChunkIterator {

        /* renamed from: a  reason: collision with root package name */
        public final int f8530a;

        /* renamed from: b  reason: collision with root package name */
        public int f8531b;

        /* renamed from: c  reason: collision with root package name */
        public int f8532c;

        /* renamed from: d  reason: collision with root package name */
        public long f8533d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f8534e;

        /* renamed from: f  reason: collision with root package name */
        private final ParsableByteArray f8535f;

        /* renamed from: g  reason: collision with root package name */
        private final ParsableByteArray f8536g;

        /* renamed from: h  reason: collision with root package name */
        private int f8537h;

        /* renamed from: i  reason: collision with root package name */
        private int f8538i;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z2) throws ParserException {
            this.f8536g = parsableByteArray;
            this.f8535f = parsableByteArray2;
            this.f8534e = z2;
            parsableByteArray2.U(12);
            this.f8530a = parsableByteArray2.L();
            parsableByteArray.U(12);
            this.f8538i = parsableByteArray.L();
            ExtractorUtil.a(parsableByteArray.q() != 1 ? false : true, "first_chunk must be 1");
            this.f8531b = -1;
        }

        public boolean a() {
            long j2;
            int i2;
            int i3 = this.f8531b + 1;
            this.f8531b = i3;
            if (i3 == this.f8530a) {
                return false;
            }
            if (this.f8534e) {
                j2 = this.f8535f.M();
            } else {
                j2 = this.f8535f.J();
            }
            this.f8533d = j2;
            if (this.f8531b == this.f8537h) {
                this.f8532c = this.f8536g.L();
                this.f8536g.V(4);
                int i4 = this.f8538i - 1;
                this.f8538i = i4;
                if (i4 > 0) {
                    i2 = this.f8536g.L() - 1;
                } else {
                    i2 = -1;
                }
                this.f8537h = i2;
            }
            return true;
        }
    }

    private static final class EsdsData {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f8539a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f8540b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final long f8541c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final long f8542d;

        public EsdsData(String str, byte[] bArr, long j2, long j3) {
            this.f8539a = str;
            this.f8540b = bArr;
            this.f8541c = j2;
            this.f8542d = j3;
        }
    }

    private interface SampleSizeBox {
        int a();

        int b();

        int c();
    }

    private static final class StsdData {

        /* renamed from: a  reason: collision with root package name */
        public final TrackEncryptionBox[] f8543a;

        /* renamed from: b  reason: collision with root package name */
        public Format f8544b;

        /* renamed from: c  reason: collision with root package name */
        public int f8545c;

        /* renamed from: d  reason: collision with root package name */
        public int f8546d = 0;

        public StsdData(int i2) {
            this.f8543a = new TrackEncryptionBox[i2];
        }
    }

    static final class StszSampleSizeBox implements SampleSizeBox {

        /* renamed from: a  reason: collision with root package name */
        private final int f8547a;

        /* renamed from: b  reason: collision with root package name */
        private final int f8548b;

        /* renamed from: c  reason: collision with root package name */
        private final ParsableByteArray f8549c;

        public StszSampleSizeBox(Atom.LeafAtom leafAtom, Format format) {
            ParsableByteArray parsableByteArray = leafAtom.f8528b;
            this.f8549c = parsableByteArray;
            parsableByteArray.U(12);
            int L = parsableByteArray.L();
            if ("audio/raw".equals(format.f4015n)) {
                int i02 = Util.i0(format.D, format.B);
                if (L == 0 || L % i02 != 0) {
                    Log.h("AtomParsers", "Audio sample size mismatch. stsd sample size: " + i02 + ", stsz sample size: " + L);
                    L = i02;
                }
            }
            this.f8547a = L == 0 ? -1 : L;
            this.f8548b = parsableByteArray.L();
        }

        public int a() {
            int i2 = this.f8547a;
            return i2 == -1 ? this.f8549c.L() : i2;
        }

        public int b() {
            return this.f8547a;
        }

        public int c() {
            return this.f8548b;
        }
    }

    static final class Stz2SampleSizeBox implements SampleSizeBox {

        /* renamed from: a  reason: collision with root package name */
        private final ParsableByteArray f8550a;

        /* renamed from: b  reason: collision with root package name */
        private final int f8551b;

        /* renamed from: c  reason: collision with root package name */
        private final int f8552c;

        /* renamed from: d  reason: collision with root package name */
        private int f8553d;

        /* renamed from: e  reason: collision with root package name */
        private int f8554e;

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.f8528b;
            this.f8550a = parsableByteArray;
            parsableByteArray.U(12);
            this.f8552c = parsableByteArray.L() & JfifUtil.MARKER_FIRST_BYTE;
            this.f8551b = parsableByteArray.L();
        }

        public int a() {
            int i2 = this.f8552c;
            if (i2 == 8) {
                return this.f8550a.H();
            }
            if (i2 == 16) {
                return this.f8550a.N();
            }
            int i3 = this.f8553d;
            this.f8553d = i3 + 1;
            if (i3 % 2 != 0) {
                return this.f8554e & 15;
            }
            int H = this.f8550a.H();
            this.f8554e = H;
            return (H & 240) >> 4;
        }

        public int b() {
            return -1;
        }

        public int c() {
            return this.f8551b;
        }
    }

    private static final class TkhdData {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f8555a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long f8556b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final int f8557c;

        public TkhdData(int i2, long j2, int i3) {
            this.f8555a = i2;
            this.f8556b = j2;
            this.f8557c = i3;
        }
    }

    private AtomParsers() {
    }

    private static Track A(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j2, DrmInitData drmInitData, boolean z2, boolean z3) throws ParserException {
        long j3;
        Atom.LeafAtom leafAtom2;
        long[] jArr;
        long[] jArr2;
        Atom.ContainerAtom f2;
        Pair<long[], long[]> j4;
        Atom.ContainerAtom containerAtom2 = containerAtom;
        Atom.ContainerAtom containerAtom3 = (Atom.ContainerAtom) Assertions.f(containerAtom2.f(1835297121));
        int e2 = e(m(((Atom.LeafAtom) Assertions.f(containerAtom3.g(1751411826))).f8528b));
        if (e2 == -1) {
            return null;
        }
        TkhdData z4 = z(((Atom.LeafAtom) Assertions.f(containerAtom2.g(1953196132))).f8528b);
        long j5 = -9223372036854775807L;
        if (j2 == -9223372036854775807L) {
            leafAtom2 = leafAtom;
            j3 = z4.f8556b;
        } else {
            leafAtom2 = leafAtom;
            j3 = j2;
        }
        long j6 = r(leafAtom2.f8528b).f4747d;
        if (j3 != -9223372036854775807L) {
            j5 = Util.c1(j3, 1000000, j6);
        }
        long j7 = j5;
        Pair<Long, String> o2 = o(((Atom.LeafAtom) Assertions.f(containerAtom3.g(1835296868))).f8528b);
        Atom.LeafAtom g2 = ((Atom.ContainerAtom) Assertions.f(((Atom.ContainerAtom) Assertions.f(containerAtom3.f(1835626086))).f(1937007212))).g(1937011556);
        if (g2 != null) {
            StsdData x2 = x(g2.f8528b, z4.f8555a, z4.f8557c, (String) o2.second, drmInitData, z3);
            if (z2 || (f2 = containerAtom2.f(1701082227)) == null || (j4 = j(f2)) == null) {
                jArr2 = null;
                jArr = null;
            } else {
                jArr = (long[]) j4.second;
                jArr2 = (long[]) j4.first;
            }
            if (x2.f8544b == null) {
                return null;
            }
            return new Track(z4.f8555a, e2, ((Long) o2.first).longValue(), j6, j7, x2.f8544b, x2.f8546d, x2.f8543a, x2.f8545c, jArr2, jArr);
        }
        throw ParserException.a("Malformed sample table (stbl) missing sample description (stsd)", (Throwable) null);
    }

    public static List<TrackSampleTable> B(Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder, long j2, DrmInitData drmInitData, boolean z2, boolean z3, Function<Track, Track> function) throws ParserException {
        Atom.ContainerAtom containerAtom2 = containerAtom;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < containerAtom2.f8527d.size(); i2++) {
            Atom.ContainerAtom containerAtom3 = containerAtom2.f8527d.get(i2);
            if (containerAtom3.f8524a != 1953653099) {
                GaplessInfoHolder gaplessInfoHolder2 = gaplessInfoHolder;
                Function<Track, Track> function2 = function;
            } else {
                Track apply = function.apply(A(containerAtom3, (Atom.LeafAtom) Assertions.f(containerAtom.g(1836476516)), j2, drmInitData, z2, z3));
                if (apply == null) {
                    GaplessInfoHolder gaplessInfoHolder3 = gaplessInfoHolder;
                } else {
                    GaplessInfoHolder gaplessInfoHolder4 = gaplessInfoHolder;
                    arrayList.add(w(apply, (Atom.ContainerAtom) Assertions.f(((Atom.ContainerAtom) Assertions.f(((Atom.ContainerAtom) Assertions.f(containerAtom3.f(1835297121))).f(1835626086))).f(1937007212)), gaplessInfoHolder));
                }
            }
        }
        return arrayList;
    }

    public static Metadata C(Atom.LeafAtom leafAtom) {
        ParsableByteArray parsableByteArray = leafAtom.f8528b;
        parsableByteArray.U(8);
        Metadata metadata = new Metadata(new Metadata.Entry[0]);
        while (parsableByteArray.a() >= 8) {
            int f2 = parsableByteArray.f();
            int q2 = parsableByteArray.q();
            int q3 = parsableByteArray.q();
            if (q3 == 1835365473) {
                parsableByteArray.U(f2);
                metadata = metadata.c(D(parsableByteArray, f2 + q2));
            } else if (q3 == 1936553057) {
                parsableByteArray.U(f2);
                metadata = metadata.c(SmtaAtomUtil.b(parsableByteArray, f2 + q2));
            } else if (q3 == -1451722374) {
                metadata = metadata.c(F(parsableByteArray));
            }
            parsableByteArray.U(f2 + q2);
        }
        return metadata;
    }

    private static Metadata D(ParsableByteArray parsableByteArray, int i2) {
        parsableByteArray.V(8);
        f(parsableByteArray);
        while (parsableByteArray.f() < i2) {
            int f2 = parsableByteArray.f();
            int q2 = parsableByteArray.q();
            if (parsableByteArray.q() == 1768715124) {
                parsableByteArray.U(f2);
                return n(parsableByteArray, f2 + q2);
            }
            parsableByteArray.U(f2 + q2);
        }
        return null;
    }

    /* JADX WARNING: type inference failed for: r2v32, types: [java.util.List<byte[]>] */
    /* JADX WARNING: type inference failed for: r6v29, types: [java.util.List<byte[]>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void E(androidx.media3.common.util.ParsableByteArray r37, int r38, int r39, int r40, int r41, int r42, androidx.media3.common.DrmInitData r43, androidx.media3.extractor.mp4.AtomParsers.StsdData r44, int r45) throws androidx.media3.common.ParserException {
        /*
            r0 = r37
            r1 = r39
            r2 = r40
            r3 = r43
            r4 = r44
            int r5 = r1 + 8
            r6 = 8
            int r5 = r5 + r6
            r0.U(r5)
            r5 = 16
            r0.V(r5)
            int r5 = r37.N()
            int r7 = r37.N()
            r8 = 50
            r0.V(r8)
            int r8 = r37.f()
            r9 = 1701733238(0x656e6376, float:7.035987E22)
            r11 = r38
            if (r11 != r9) goto L_0x0056
            android.util.Pair r9 = u(r0, r1, r2)
            if (r9 == 0) goto L_0x0053
            java.lang.Object r11 = r9.first
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            if (r3 != 0) goto L_0x0041
            r3 = 0
            goto L_0x004b
        L_0x0041:
            java.lang.Object r12 = r9.second
            androidx.media3.extractor.mp4.TrackEncryptionBox r12 = (androidx.media3.extractor.mp4.TrackEncryptionBox) r12
            java.lang.String r12 = r12.f8672b
            androidx.media3.common.DrmInitData r3 = r3.d(r12)
        L_0x004b:
            androidx.media3.extractor.mp4.TrackEncryptionBox[] r12 = r4.f8543a
            java.lang.Object r9 = r9.second
            androidx.media3.extractor.mp4.TrackEncryptionBox r9 = (androidx.media3.extractor.mp4.TrackEncryptionBox) r9
            r12[r45] = r9
        L_0x0053:
            r0.U(r8)
        L_0x0056:
            r9 = 1831958048(0x6d317620, float:3.4326032E27)
            java.lang.String r12 = "video/3gpp"
            if (r11 != r9) goto L_0x0060
            java.lang.String r9 = "video/mpeg"
            goto L_0x0068
        L_0x0060:
            r9 = 1211250227(0x48323633, float:182488.8)
            if (r11 != r9) goto L_0x0067
            r9 = r12
            goto L_0x0068
        L_0x0067:
            r9 = 0
        L_0x0068:
            r15 = 1065353216(0x3f800000, float:1.0)
            r15 = r9
            r16 = 1065353216(0x3f800000, float:1.0)
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = -1
            r21 = -1
            r22 = -1
            r23 = -1
            r24 = -1
            r25 = 0
            r26 = 0
            r27 = 0
            r9 = r8
            r8 = 8
        L_0x0086:
            int r13 = r9 - r1
            if (r13 >= r2) goto L_0x0398
            r0.U(r9)
            int r13 = r37.f()
            int r14 = r37.q()
            if (r14 != 0) goto L_0x00a1
            int r28 = r37.f()
            int r10 = r28 - r1
            if (r10 != r2) goto L_0x00a1
            goto L_0x0398
        L_0x00a1:
            if (r14 <= 0) goto L_0x00a5
            r10 = 1
            goto L_0x00a6
        L_0x00a5:
            r10 = 0
        L_0x00a6:
            java.lang.String r1 = "childAtomSize must be positive"
            androidx.media3.extractor.ExtractorUtil.a(r10, r1)
            int r1 = r37.q()
            r10 = 1635148611(0x61766343, float:2.8406573E20)
            if (r1 != r10) goto L_0x00fe
            r1 = 0
            if (r15 != 0) goto L_0x00b9
            r10 = 1
            goto L_0x00ba
        L_0x00b9:
            r10 = 0
        L_0x00ba:
            androidx.media3.extractor.ExtractorUtil.a(r10, r1)
            int r13 = r13 + 8
            r0.U(r13)
            androidx.media3.extractor.AvcConfig r1 = androidx.media3.extractor.AvcConfig.b(r37)
            java.util.List<byte[]> r6 = r1.f7917a
            int r8 = r1.f7918b
            r4.f8545c = r8
            if (r27 != 0) goto L_0x00d2
            float r8 = r1.f7927k
            r16 = r8
        L_0x00d2:
            java.lang.String r8 = r1.f7928l
            int r10 = r1.f7926j
            int r13 = r1.f7923g
            int r15 = r1.f7924h
            int r2 = r1.f7925i
            r17 = r2
            int r2 = r1.f7921e
            int r1 = r1.f7922f
            java.lang.String r18 = "video/avc"
            r36 = r3
            r21 = r10
            r28 = r11
            r29 = r12
            r22 = r13
            r23 = r15
            r24 = r17
            r15 = r18
            r17 = r6
            r18 = r8
            r8 = r1
            r6 = r2
        L_0x00fa:
            r1 = -1
            r2 = 0
            goto L_0x0389
        L_0x00fe:
            r2 = 1752589123(0x68766343, float:4.6541328E24)
            if (r1 != r2) goto L_0x014b
            r1 = 0
            if (r15 != 0) goto L_0x0108
            r10 = 1
            goto L_0x0109
        L_0x0108:
            r10 = 0
        L_0x0109:
            androidx.media3.extractor.ExtractorUtil.a(r10, r1)
            int r13 = r13 + 8
            r0.U(r13)
            androidx.media3.extractor.HevcConfig r1 = androidx.media3.extractor.HevcConfig.a(r37)
            java.util.List<byte[]> r2 = r1.f8038a
            int r6 = r1.f8039b
            r4.f8545c = r6
            if (r27 != 0) goto L_0x0121
            float r6 = r1.f8047j
            r16 = r6
        L_0x0121:
            int r6 = r1.f8048k
            java.lang.String r8 = r1.f8049l
            int r10 = r1.f8044g
            int r13 = r1.f8045h
            int r15 = r1.f8046i
            r17 = r2
            int r2 = r1.f8042e
            int r1 = r1.f8043f
            java.lang.String r18 = "video/hevc"
            r36 = r3
            r21 = r6
            r22 = r10
            r28 = r11
            r29 = r12
            r23 = r13
            r24 = r15
            r15 = r18
            r6 = r2
            r18 = r8
            r2 = 0
            r8 = r1
        L_0x0148:
            r1 = -1
            goto L_0x0389
        L_0x014b:
            r2 = 1685480259(0x64766343, float:1.8180206E22)
            if (r1 == r2) goto L_0x0365
            r2 = 1685485123(0x64767643, float:1.8185683E22)
            if (r1 != r2) goto L_0x0157
            goto L_0x0365
        L_0x0157:
            r2 = 1987076931(0x76706343, float:1.21891066E33)
            r10 = 2
            if (r1 != r2) goto L_0x01a1
            if (r15 != 0) goto L_0x0161
            r1 = 1
            goto L_0x0162
        L_0x0161:
            r1 = 0
        L_0x0162:
            r2 = 0
            androidx.media3.extractor.ExtractorUtil.a(r1, r2)
            r1 = 1987063864(0x76703038, float:1.21789965E33)
            if (r11 != r1) goto L_0x016e
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            goto L_0x0170
        L_0x016e:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
        L_0x0170:
            int r13 = r13 + 12
            r0.U(r13)
            r0.V(r10)
            int r2 = r37.H()
            int r6 = r2 >> 4
            r8 = 1
            r2 = r2 & r8
            if (r2 == 0) goto L_0x0184
            r2 = 1
            goto L_0x0185
        L_0x0184:
            r2 = 0
        L_0x0185:
            int r8 = r37.H()
            int r13 = r37.H()
            int r22 = androidx.media3.common.ColorInfo.j(r8)
            if (r2 == 0) goto L_0x0196
            r23 = 1
            goto L_0x0198
        L_0x0196:
            r23 = 2
        L_0x0198:
            int r24 = androidx.media3.common.ColorInfo.k(r13)
            r15 = r1
            r36 = r3
            r8 = r6
            goto L_0x01fb
        L_0x01a1:
            r2 = 1635135811(0x61763143, float:2.8384055E20)
            if (r1 != r2) goto L_0x01d6
            int r1 = r14 + -8
            byte[] r2 = new byte[r1]
            r6 = 0
            r0.l(r2, r6, r1)
            com.google.common.collect.ImmutableList r17 = com.google.common.collect.ImmutableList.s(r2)
            int r13 = r13 + 8
            r0.U(r13)
            androidx.media3.common.ColorInfo r1 = h(r37)
            int r2 = r1.f3947e
            int r8 = r1.f3948f
            int r10 = r1.f3943a
            int r13 = r1.f3944b
            int r1 = r1.f3945c
            java.lang.String r15 = "video/av01"
            r24 = r1
            r6 = r2
            r36 = r3
            r22 = r10
            r28 = r11
            r29 = r12
            r23 = r13
            goto L_0x00fa
        L_0x01d6:
            r2 = 1668050025(0x636c6c69, float:4.3612434E21)
            if (r1 != r2) goto L_0x0201
            if (r25 != 0) goto L_0x01e2
            java.nio.ByteBuffer r1 = a()
            goto L_0x01e4
        L_0x01e2:
            r1 = r25
        L_0x01e4:
            r2 = 21
            r1.position(r2)
            short r2 = r37.D()
            r1.putShort(r2)
            short r2 = r37.D()
            r1.putShort(r2)
            r25 = r1
            r36 = r3
        L_0x01fb:
            r28 = r11
            r29 = r12
            goto L_0x00fa
        L_0x0201:
            r2 = 1835295606(0x6d646376, float:4.4176764E27)
            if (r1 != r2) goto L_0x0275
            if (r25 != 0) goto L_0x020d
            java.nio.ByteBuffer r1 = a()
            goto L_0x020f
        L_0x020d:
            r1 = r25
        L_0x020f:
            short r2 = r37.D()
            short r10 = r37.D()
            short r13 = r37.D()
            r28 = r11
            short r11 = r37.D()
            r29 = r12
            short r12 = r37.D()
            short r4 = r37.D()
            r30 = r8
            short r8 = r37.D()
            r31 = r6
            short r6 = r37.D()
            long r32 = r37.J()
            long r34 = r37.J()
            r36 = r3
            r3 = 1
            r1.position(r3)
            r1.putShort(r12)
            r1.putShort(r4)
            r1.putShort(r2)
            r1.putShort(r10)
            r1.putShort(r13)
            r1.putShort(r11)
            r1.putShort(r8)
            r1.putShort(r6)
            r2 = 10000(0x2710, double:4.9407E-320)
            long r10 = r32 / r2
            int r4 = (int) r10
            short r4 = (short) r4
            r1.putShort(r4)
            long r2 = r34 / r2
            int r3 = (int) r2
            short r2 = (short) r3
            r1.putShort(r2)
            r25 = r1
            r8 = r30
            r6 = r31
            goto L_0x00fa
        L_0x0275:
            r36 = r3
            r31 = r6
            r30 = r8
            r28 = r11
            r29 = r12
            r2 = 1681012275(0x64323633, float:1.3149704E22)
            if (r1 != r2) goto L_0x0295
            r2 = 0
            if (r15 != 0) goto L_0x0289
            r10 = 1
            goto L_0x028a
        L_0x0289:
            r10 = 0
        L_0x028a:
            androidx.media3.extractor.ExtractorUtil.a(r10, r2)
            r15 = r29
        L_0x028f:
            r8 = r30
            r6 = r31
            goto L_0x0148
        L_0x0295:
            r2 = 0
            r3 = 1702061171(0x65736473, float:7.183675E22)
            if (r1 != r3) goto L_0x02b7
            if (r15 != 0) goto L_0x029f
            r10 = 1
            goto L_0x02a0
        L_0x029f:
            r10 = 0
        L_0x02a0:
            androidx.media3.extractor.ExtractorUtil.a(r10, r2)
            androidx.media3.extractor.mp4.AtomParsers$EsdsData r26 = k(r0, r13)
            java.lang.String r1 = r26.f8539a
            byte[] r3 = r26.f8540b
            if (r3 == 0) goto L_0x02b5
            com.google.common.collect.ImmutableList r17 = com.google.common.collect.ImmutableList.s(r3)
        L_0x02b5:
            r15 = r1
            goto L_0x028f
        L_0x02b7:
            r3 = 1885434736(0x70617370, float:2.7909473E29)
            if (r1 != r3) goto L_0x02cb
            float r1 = s(r0, r13)
            r16 = r1
            r8 = r30
            r6 = r31
            r1 = -1
            r27 = 1
            goto L_0x0389
        L_0x02cb:
            r3 = 1937126244(0x73763364, float:1.9506033E31)
            if (r1 != r3) goto L_0x02d5
            byte[] r19 = t(r0, r13, r14)
            goto L_0x028f
        L_0x02d5:
            r3 = 1936995172(0x73743364, float:1.9347576E31)
            if (r1 != r3) goto L_0x02fe
            int r1 = r37.H()
            r3 = 3
            r0.V(r3)
            if (r1 != 0) goto L_0x028f
            int r1 = r37.H()
            if (r1 == 0) goto L_0x02fb
            r8 = 1
            if (r1 == r8) goto L_0x02f8
            if (r1 == r10) goto L_0x02f5
            if (r1 == r3) goto L_0x02f2
            goto L_0x028f
        L_0x02f2:
            r20 = 3
            goto L_0x028f
        L_0x02f5:
            r20 = 2
            goto L_0x028f
        L_0x02f8:
            r20 = 1
            goto L_0x028f
        L_0x02fb:
            r20 = 0
            goto L_0x028f
        L_0x02fe:
            r8 = 1
            r3 = 1668246642(0x636f6c72, float:4.4165861E21)
            r13 = r22
            if (r1 != r3) goto L_0x0361
            r1 = -1
            r3 = r24
            if (r13 != r1) goto L_0x0381
            if (r3 != r1) goto L_0x0381
            int r4 = r37.q()
            r6 = 1852009592(0x6e636c78, float:1.7596057E28)
            if (r4 == r6) goto L_0x0337
            r6 = 1852009571(0x6e636c63, float:1.7596032E28)
            if (r4 != r6) goto L_0x031c
            goto L_0x0337
        L_0x031c:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "Unsupported color type: "
            r6.append(r8)
            java.lang.String r4 = androidx.media3.extractor.mp4.Atom.a(r4)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            java.lang.String r6 = "AtomParsers"
            androidx.media3.common.util.Log.h(r6, r4)
            goto L_0x0381
        L_0x0337:
            int r3 = r37.N()
            int r4 = r37.N()
            r0.V(r10)
            r6 = 19
            if (r14 != r6) goto L_0x0350
            int r6 = r37.H()
            r6 = r6 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x0350
            r6 = 1
            goto L_0x0351
        L_0x0350:
            r6 = 0
        L_0x0351:
            int r22 = androidx.media3.common.ColorInfo.j(r3)
            if (r6 == 0) goto L_0x035a
            r23 = 1
            goto L_0x035c
        L_0x035a:
            r23 = 2
        L_0x035c:
            int r24 = androidx.media3.common.ColorInfo.k(r4)
            goto L_0x0385
        L_0x0361:
            r3 = r24
            r1 = -1
            goto L_0x0381
        L_0x0365:
            r36 = r3
            r31 = r6
            r30 = r8
            r28 = r11
            r29 = r12
            r13 = r22
            r3 = r24
            r1 = -1
            r2 = 0
            androidx.media3.extractor.DolbyVisionConfig r4 = androidx.media3.extractor.DolbyVisionConfig.a(r37)
            if (r4 == 0) goto L_0x0381
            java.lang.String r4 = r4.f7997c
            java.lang.String r15 = "video/dolby-vision"
            r18 = r4
        L_0x0381:
            r24 = r3
            r22 = r13
        L_0x0385:
            r8 = r30
            r6 = r31
        L_0x0389:
            int r9 = r9 + r14
            r1 = r39
            r2 = r40
            r4 = r44
            r11 = r28
            r12 = r29
            r3 = r36
            goto L_0x0086
        L_0x0398:
            r36 = r3
            r31 = r6
            r30 = r8
            r13 = r22
            r3 = r24
            r2 = 0
            if (r15 != 0) goto L_0x03a6
            return
        L_0x03a6:
            androidx.media3.common.Format$Builder r0 = new androidx.media3.common.Format$Builder
            r0.<init>()
            r1 = r41
            androidx.media3.common.Format$Builder r0 = r0.Z(r1)
            androidx.media3.common.Format$Builder r0 = r0.o0(r15)
            r10 = r18
            androidx.media3.common.Format$Builder r0 = r0.O(r10)
            androidx.media3.common.Format$Builder r0 = r0.v0(r5)
            androidx.media3.common.Format$Builder r0 = r0.Y(r7)
            r15 = r16
            androidx.media3.common.Format$Builder r0 = r0.k0(r15)
            r1 = r42
            androidx.media3.common.Format$Builder r0 = r0.n0(r1)
            r10 = r19
            androidx.media3.common.Format$Builder r0 = r0.l0(r10)
            r1 = r20
            androidx.media3.common.Format$Builder r0 = r0.r0(r1)
            r10 = r17
            androidx.media3.common.Format$Builder r0 = r0.b0(r10)
            r1 = r21
            androidx.media3.common.Format$Builder r0 = r0.g0(r1)
            r1 = r36
            androidx.media3.common.Format$Builder r0 = r0.U(r1)
            androidx.media3.common.ColorInfo$Builder r1 = new androidx.media3.common.ColorInfo$Builder
            r1.<init>()
            androidx.media3.common.ColorInfo$Builder r1 = r1.d(r13)
            r13 = r23
            androidx.media3.common.ColorInfo$Builder r1 = r1.c(r13)
            androidx.media3.common.ColorInfo$Builder r1 = r1.e(r3)
            if (r25 == 0) goto L_0x0407
            byte[] r10 = r25.array()
            goto L_0x0408
        L_0x0407:
            r10 = r2
        L_0x0408:
            androidx.media3.common.ColorInfo$Builder r1 = r1.f(r10)
            r6 = r31
            androidx.media3.common.ColorInfo$Builder r1 = r1.g(r6)
            r8 = r30
            androidx.media3.common.ColorInfo$Builder r1 = r1.b(r8)
            androidx.media3.common.ColorInfo r1 = r1.a()
            androidx.media3.common.Format$Builder r0 = r0.P(r1)
            if (r26 == 0) goto L_0x0439
            long r1 = r26.f8541c
            int r1 = com.google.common.primitives.Ints.m(r1)
            androidx.media3.common.Format$Builder r1 = r0.M(r1)
            long r2 = r26.f8542d
            int r2 = com.google.common.primitives.Ints.m(r2)
            r1.j0(r2)
        L_0x0439:
            androidx.media3.common.Format r0 = r0.K()
            r1 = r44
            r1.f8544b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.AtomParsers.E(androidx.media3.common.util.ParsableByteArray, int, int, int, int, int, androidx.media3.common.DrmInitData, androidx.media3.extractor.mp4.AtomParsers$StsdData, int):void");
    }

    private static Metadata F(ParsableByteArray parsableByteArray) {
        short D = parsableByteArray.D();
        parsableByteArray.V(2);
        String E = parsableByteArray.E(D);
        int max = Math.max(E.lastIndexOf(43), E.lastIndexOf(45));
        try {
            return new Metadata(new Mp4LocationData(Float.parseFloat(E.substring(0, max)), Float.parseFloat(E.substring(max, E.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static ByteBuffer a() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static boolean b(long[] jArr, long j2, long j3, long j4) {
        int length = jArr.length - 1;
        int p2 = Util.p(4, 0, length);
        int p3 = Util.p(jArr.length - 4, 0, length);
        if (jArr[0] > j3 || j3 >= jArr[p2] || jArr[p3] >= j4 || j4 > j2) {
            return false;
        }
        return true;
    }

    private static boolean c(int i2) {
        return i2 != 1;
    }

    private static int d(ParsableByteArray parsableByteArray, int i2, int i3, int i4) throws ParserException {
        boolean z2;
        boolean z3;
        int f2 = parsableByteArray.f();
        if (f2 >= i3) {
            z2 = true;
        } else {
            z2 = false;
        }
        ExtractorUtil.a(z2, (String) null);
        while (f2 - i3 < i4) {
            parsableByteArray.U(f2);
            int q2 = parsableByteArray.q();
            if (q2 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            ExtractorUtil.a(z3, "childAtomSize must be positive");
            if (parsableByteArray.q() == i2) {
                return f2;
            }
            f2 += q2;
        }
        return -1;
    }

    private static int e(int i2) {
        if (i2 == 1936684398) {
            return 1;
        }
        if (i2 == 1986618469) {
            return 2;
        }
        if (i2 == 1952807028 || i2 == 1935832172 || i2 == 1937072756 || i2 == 1668047728) {
            return 3;
        }
        return i2 == 1835365473 ? 5 : -1;
    }

    public static void f(ParsableByteArray parsableByteArray) {
        int f2 = parsableByteArray.f();
        parsableByteArray.V(4);
        if (parsableByteArray.q() != 1751411826) {
            f2 += 4;
        }
        parsableByteArray.U(f2);
    }

    private static void g(ParsableByteArray parsableByteArray, int i2, int i3, int i4, int i5, String str, boolean z2, DrmInitData drmInitData, StsdData stsdData, int i6) throws ParserException {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        String str2;
        String str3;
        int i12;
        int i13;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i14 = i3;
        int i15 = i4;
        int i16 = i5;
        String str4 = str;
        DrmInitData drmInitData2 = drmInitData;
        StsdData stsdData2 = stsdData;
        parsableByteArray2.U(i14 + 8 + 8);
        if (z2) {
            i7 = parsableByteArray.N();
            parsableByteArray2.V(6);
        } else {
            parsableByteArray2.V(8);
            i7 = 0;
        }
        if (i7 == 0 || i7 == 1) {
            i9 = parsableByteArray.N();
            parsableByteArray2.V(6);
            i11 = parsableByteArray.I();
            parsableByteArray2.U(parsableByteArray.f() - 4);
            i10 = parsableByteArray.q();
            if (i7 == 1) {
                parsableByteArray2.V(16);
            }
            i8 = -1;
        } else if (i7 == 2) {
            parsableByteArray2.V(16);
            i11 = (int) Math.round(parsableByteArray.o());
            i9 = parsableByteArray.L();
            parsableByteArray2.V(4);
            int L = parsableByteArray.L();
            int L2 = parsableByteArray.L();
            boolean z3 = (L2 & 1) != 0;
            boolean z4 = (L2 & 2) != 0;
            if (!z3) {
                if (L == 8) {
                    i8 = 3;
                } else if (L == 16) {
                    i8 = z4 ? 268435456 : 2;
                } else if (L == 24) {
                    i8 = z4 ? 1342177280 : 21;
                } else if (L == 32) {
                    i8 = z4 ? 1610612736 : 22;
                }
                parsableByteArray2.V(8);
                i10 = 0;
            } else if (L == 32) {
                i8 = 4;
                parsableByteArray2.V(8);
                i10 = 0;
            }
            i8 = -1;
            parsableByteArray2.V(8);
            i10 = 0;
        } else {
            return;
        }
        int f2 = parsableByteArray.f();
        int i17 = i2;
        if (i17 == 1701733217) {
            Pair<Integer, TrackEncryptionBox> u2 = u(parsableByteArray2, i14, i15);
            if (u2 != null) {
                i17 = ((Integer) u2.first).intValue();
                if (drmInitData2 == null) {
                    drmInitData2 = null;
                } else {
                    drmInitData2 = drmInitData2.d(((TrackEncryptionBox) u2.second).f8672b);
                }
                stsdData2.f8543a[i6] = (TrackEncryptionBox) u2.second;
            }
            parsableByteArray2.U(f2);
        }
        String str5 = "audio/mhm1";
        if (i17 == 1633889587) {
            str2 = "audio/ac3";
        } else if (i17 == 1700998451) {
            str2 = "audio/eac3";
        } else if (i17 == 1633889588) {
            str2 = "audio/ac4";
        } else if (i17 == 1685353315) {
            str2 = "audio/vnd.dts";
        } else if (i17 == 1685353320 || i17 == 1685353324) {
            str2 = "audio/vnd.dts.hd";
        } else if (i17 == 1685353317) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (i17 == 1685353336) {
            str2 = "audio/vnd.dts.uhd;profile=p2";
        } else if (i17 == 1935764850) {
            str2 = "audio/3gpp";
        } else if (i17 == 1935767394) {
            str2 = "audio/amr-wb";
        } else {
            if (i17 != 1936684916) {
                if (i17 == 1953984371) {
                    str2 = "audio/raw";
                    i8 = 268435456;
                } else if (i17 != 1819304813) {
                    str2 = (i17 == 778924082 || i17 == 778924083) ? "audio/mpeg" : i17 == 1835557169 ? "audio/mha1" : i17 == 1835560241 ? str5 : i17 == 1634492771 ? "audio/alac" : i17 == 1634492791 ? "audio/g711-alaw" : i17 == 1970037111 ? "audio/g711-mlaw" : i17 == 1332770163 ? "audio/opus" : i17 == 1716281667 ? "audio/flac" : i17 == 1835823201 ? "audio/true-hd" : null;
                } else if (i8 != -1) {
                    str2 = "audio/raw";
                }
            }
            str2 = "audio/raw";
            i8 = 2;
        }
        int i18 = i8;
        List list = null;
        String str6 = null;
        EsdsData esdsData = null;
        while (f2 - i14 < i15) {
            parsableByteArray2.U(f2);
            int q2 = parsableByteArray.q();
            ExtractorUtil.a(q2 > 0, "childAtomSize must be positive");
            int q3 = parsableByteArray.q();
            if (q3 == 1835557187) {
                parsableByteArray2.U(f2 + 8);
                parsableByteArray2.V(1);
                int H = parsableByteArray.H();
                parsableByteArray2.V(1);
                if (Objects.equals(str2, str5)) {
                    i13 = 0;
                    str6 = String.format("mhm1.%02X", new Object[]{Integer.valueOf(H)});
                    str3 = str5;
                } else {
                    str3 = str5;
                    i13 = 0;
                    str6 = String.format("mha1.%02X", new Object[]{Integer.valueOf(H)});
                }
                int N = parsableByteArray.N();
                byte[] bArr = new byte[N];
                parsableByteArray2.l(bArr, i13, N);
                if (list == null) {
                    list = ImmutableList.s(bArr);
                } else {
                    list = ImmutableList.t(bArr, (byte[]) list.get(i13));
                }
            } else {
                str3 = str5;
                if (q3 == 1835557200) {
                    parsableByteArray2.U(f2 + 8);
                    int H2 = parsableByteArray.H();
                    if (H2 > 0) {
                        byte[] bArr2 = new byte[H2];
                        parsableByteArray2.l(bArr2, 0, H2);
                        if (list == null) {
                            list = ImmutableList.s(bArr2);
                        } else {
                            list = ImmutableList.t((byte[]) list.get(0), bArr2);
                        }
                    }
                } else if (q3 == 1702061171 || (z2 && q3 == 2002876005)) {
                    if (q3 == 1702061171) {
                        i12 = f2;
                    } else {
                        i12 = d(parsableByteArray2, 1702061171, f2, q2);
                    }
                    if (i12 != -1) {
                        esdsData = k(parsableByteArray2, i12);
                        str2 = esdsData.f8539a;
                        byte[] b2 = esdsData.f8540b;
                        if (b2 != null) {
                            if ("audio/vorbis".equals(str2)) {
                                list = VorbisUtil.e(b2);
                            } else {
                                if ("audio/mp4a-latm".equals(str2)) {
                                    AacUtil.Config e2 = AacUtil.e(b2);
                                    int i19 = e2.f7895a;
                                    int i20 = e2.f7896b;
                                    str6 = e2.f7897c;
                                    i11 = i19;
                                    i9 = i20;
                                }
                                list = ImmutableList.s(b2);
                            }
                        }
                    }
                    f2 += q2;
                    i14 = i3;
                    i15 = i4;
                    str5 = str3;
                } else {
                    if (q3 == 1684103987) {
                        parsableByteArray2.U(f2 + 8);
                        stsdData2.f8544b = Ac3Util.d(parsableByteArray2, Integer.toString(i5), str4, drmInitData2);
                    } else if (q3 == 1684366131) {
                        parsableByteArray2.U(f2 + 8);
                        stsdData2.f8544b = Ac3Util.h(parsableByteArray2, Integer.toString(i5), str4, drmInitData2);
                    } else if (q3 == 1684103988) {
                        parsableByteArray2.U(f2 + 8);
                        stsdData2.f8544b = Ac4Util.b(parsableByteArray2, Integer.toString(i5), str4, drmInitData2);
                    } else if (q3 == 1684892784) {
                        if (i10 > 0) {
                            i11 = i10;
                            i9 = 2;
                            f2 += q2;
                            i14 = i3;
                            i15 = i4;
                            str5 = str3;
                        } else {
                            throw ParserException.a("Invalid sample rate for Dolby TrueHD MLP stream: " + i10, (Throwable) null);
                        }
                    } else if (q3 == 1684305011 || q3 == 1969517683) {
                        stsdData2.f8544b = new Format.Builder().Z(i16).o0(str2).N(i9).p0(i11).U(drmInitData2).e0(str4).K();
                        f2 += q2;
                        i14 = i3;
                        i15 = i4;
                        str5 = str3;
                    } else if (q3 == 1682927731) {
                        int i21 = q2 - 8;
                        byte[] bArr3 = f8529a;
                        byte[] copyOf = Arrays.copyOf(bArr3, bArr3.length + i21);
                        parsableByteArray2.U(f2 + 8);
                        parsableByteArray2.l(copyOf, bArr3.length, i21);
                        list = OpusUtil.a(copyOf);
                    } else if (q3 == 1684425825) {
                        int i22 = q2 - 12;
                        byte[] bArr4 = new byte[(i22 + 4)];
                        bArr4[0] = 102;
                        bArr4[1] = 76;
                        bArr4[2] = 97;
                        bArr4[3] = 67;
                        parsableByteArray2.U(f2 + 12);
                        parsableByteArray2.l(bArr4, 4, i22);
                        list = ImmutableList.s(bArr4);
                        f2 += q2;
                        i14 = i3;
                        i15 = i4;
                        str5 = str3;
                    } else if (q3 == 1634492771) {
                        int i23 = q2 - 12;
                        byte[] bArr5 = new byte[i23];
                        parsableByteArray2.U(f2 + 12);
                        parsableByteArray2.l(bArr5, 0, i23);
                        Pair<Integer, Integer> e3 = CodecSpecificDataUtil.e(bArr5);
                        int intValue = ((Integer) e3.first).intValue();
                        i9 = ((Integer) e3.second).intValue();
                        int i24 = intValue;
                        list = ImmutableList.s(bArr5);
                        i11 = i24;
                        f2 += q2;
                        i14 = i3;
                        i15 = i4;
                        str5 = str3;
                    } else {
                        f2 += q2;
                        i14 = i3;
                        i15 = i4;
                        str5 = str3;
                    }
                    f2 += q2;
                    i14 = i3;
                    i15 = i4;
                    str5 = str3;
                }
            }
            f2 += q2;
            i14 = i3;
            i15 = i4;
            str5 = str3;
        }
        if (stsdData2.f8544b == null && str2 != null) {
            Format.Builder e02 = new Format.Builder().Z(i16).o0(str2).O(str6).N(i9).p0(i11).i0(i18).b0(list).U(drmInitData2).e0(str4);
            if (esdsData != null) {
                e02.M(Ints.m(esdsData.f8541c)).j0(Ints.m(esdsData.f8542d));
            }
            stsdData2.f8544b = e02.K();
        }
    }

    private static ColorInfo h(ParsableByteArray parsableByteArray) {
        int i2;
        int i3;
        int i4;
        int i5;
        ColorInfo.Builder builder = new ColorInfo.Builder();
        ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray.e());
        parsableBitArray.p(parsableByteArray.f() * 8);
        int i6 = 1;
        parsableBitArray.s(1);
        int h2 = parsableBitArray.h(3);
        parsableBitArray.r(6);
        boolean g2 = parsableBitArray.g();
        boolean g3 = parsableBitArray.g();
        int i7 = 10;
        if (h2 == 2 && g2) {
            if (g3) {
                i5 = 12;
            } else {
                i5 = 10;
            }
            builder.g(i5);
            if (g3) {
                i7 = 12;
            }
            builder.b(i7);
        } else if (h2 <= 2) {
            if (g2) {
                i4 = 10;
            } else {
                i4 = 8;
            }
            builder.g(i4);
            if (!g2) {
                i7 = 8;
            }
            builder.b(i7);
        }
        parsableBitArray.r(13);
        parsableBitArray.q();
        int h3 = parsableBitArray.h(4);
        if (h3 != 1) {
            Log.f("AtomParsers", "Unsupported obu_type: " + h3);
            return builder.a();
        } else if (parsableBitArray.g()) {
            Log.f("AtomParsers", "Unsupported obu_extension_flag");
            return builder.a();
        } else {
            boolean g4 = parsableBitArray.g();
            parsableBitArray.q();
            if (!g4 || parsableBitArray.h(8) <= 127) {
                int h4 = parsableBitArray.h(3);
                parsableBitArray.q();
                if (parsableBitArray.g()) {
                    Log.f("AtomParsers", "Unsupported reduced_still_picture_header");
                    return builder.a();
                } else if (parsableBitArray.g()) {
                    Log.f("AtomParsers", "Unsupported timing_info_present_flag");
                    return builder.a();
                } else if (parsableBitArray.g()) {
                    Log.f("AtomParsers", "Unsupported initial_display_delay_present_flag");
                    return builder.a();
                } else {
                    int h5 = parsableBitArray.h(5);
                    boolean z2 = false;
                    for (int i8 = 0; i8 <= h5; i8++) {
                        parsableBitArray.r(12);
                        if (parsableBitArray.h(5) > 7) {
                            parsableBitArray.q();
                        }
                    }
                    int h6 = parsableBitArray.h(4);
                    int h7 = parsableBitArray.h(4);
                    parsableBitArray.r(h6 + 1);
                    parsableBitArray.r(h7 + 1);
                    if (parsableBitArray.g()) {
                        parsableBitArray.r(7);
                    }
                    parsableBitArray.r(7);
                    boolean g5 = parsableBitArray.g();
                    if (g5) {
                        parsableBitArray.r(2);
                    }
                    if (parsableBitArray.g()) {
                        i2 = 2;
                    } else {
                        i2 = parsableBitArray.h(1);
                    }
                    if (i2 > 0 && !parsableBitArray.g()) {
                        parsableBitArray.r(1);
                    }
                    if (g5) {
                        parsableBitArray.r(3);
                    }
                    parsableBitArray.r(3);
                    boolean g6 = parsableBitArray.g();
                    if (h4 == 2 && g6) {
                        parsableBitArray.q();
                    }
                    if (h4 != 1 && parsableBitArray.g()) {
                        z2 = true;
                    }
                    if (parsableBitArray.g()) {
                        int h8 = parsableBitArray.h(8);
                        int h9 = parsableBitArray.h(8);
                        int h10 = parsableBitArray.h(8);
                        if (!z2 && h8 == 1 && h9 == 13 && h10 == 0) {
                            i3 = 1;
                        } else {
                            i3 = parsableBitArray.h(1);
                        }
                        ColorInfo.Builder d2 = builder.d(ColorInfo.j(h8));
                        if (i3 != 1) {
                            i6 = 2;
                        }
                        d2.c(i6).e(ColorInfo.k(h9));
                    }
                    return builder.a();
                }
            } else {
                Log.f("AtomParsers", "Excessive obu_size");
                return builder.a();
            }
        }
    }

    static Pair<Integer, TrackEncryptionBox> i(ParsableByteArray parsableByteArray, int i2, int i3) throws ParserException {
        boolean z2;
        boolean z3;
        int i4 = i2 + 8;
        boolean z4 = false;
        String str = null;
        Integer num = null;
        int i5 = -1;
        int i6 = 0;
        while (i4 - i2 < i3) {
            parsableByteArray.U(i4);
            int q2 = parsableByteArray.q();
            int q3 = parsableByteArray.q();
            if (q3 == 1718775137) {
                num = Integer.valueOf(parsableByteArray.q());
            } else if (q3 == 1935894637) {
                parsableByteArray.V(4);
                str = parsableByteArray.E(4);
            } else if (q3 == 1935894633) {
                i5 = i4;
                i6 = q2;
            }
            i4 += q2;
        }
        if (!"cenc".equals(str) && !"cbc1".equals(str) && !"cens".equals(str) && !"cbcs".equals(str)) {
            return null;
        }
        if (num != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        ExtractorUtil.a(z2, "frma atom is mandatory");
        if (i5 != -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        ExtractorUtil.a(z3, "schi atom is mandatory");
        TrackEncryptionBox v2 = v(parsableByteArray, i5, i6, str);
        if (v2 != null) {
            z4 = true;
        }
        ExtractorUtil.a(z4, "tenc atom is mandatory");
        return Pair.create(num, (TrackEncryptionBox) Util.i(v2));
    }

    private static Pair<long[], long[]> j(Atom.ContainerAtom containerAtom) {
        long j2;
        long j3;
        Atom.LeafAtom g2 = containerAtom.g(1701606260);
        if (g2 == null) {
            return null;
        }
        ParsableByteArray parsableByteArray = g2.f8528b;
        parsableByteArray.U(8);
        int c2 = Atom.c(parsableByteArray.q());
        int L = parsableByteArray.L();
        long[] jArr = new long[L];
        long[] jArr2 = new long[L];
        int i2 = 0;
        while (i2 < L) {
            if (c2 == 1) {
                j2 = parsableByteArray.M();
            } else {
                j2 = parsableByteArray.J();
            }
            jArr[i2] = j2;
            if (c2 == 1) {
                j3 = parsableByteArray.A();
            } else {
                j3 = (long) parsableByteArray.q();
            }
            jArr2[i2] = j3;
            if (parsableByteArray.D() == 1) {
                parsableByteArray.V(2);
                i2++;
            } else {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
        }
        return Pair.create(jArr, jArr2);
    }

    private static EsdsData k(ParsableByteArray parsableByteArray, int i2) {
        long j2;
        parsableByteArray.U(i2 + 8 + 4);
        parsableByteArray.V(1);
        l(parsableByteArray);
        parsableByteArray.V(2);
        int H = parsableByteArray.H();
        if ((H & 128) != 0) {
            parsableByteArray.V(2);
        }
        if ((H & 64) != 0) {
            parsableByteArray.V(parsableByteArray.H());
        }
        if ((H & 32) != 0) {
            parsableByteArray.V(2);
        }
        parsableByteArray.V(1);
        l(parsableByteArray);
        String h2 = MimeTypes.h(parsableByteArray.H());
        if ("audio/mpeg".equals(h2) || "audio/vnd.dts".equals(h2) || "audio/vnd.dts.hd".equals(h2)) {
            return new EsdsData(h2, (byte[]) null, -1, -1);
        }
        parsableByteArray.V(4);
        long J = parsableByteArray.J();
        long J2 = parsableByteArray.J();
        parsableByteArray.V(1);
        int l2 = l(parsableByteArray);
        byte[] bArr = new byte[l2];
        parsableByteArray.l(bArr, 0, l2);
        long j3 = -1;
        if (J2 > 0) {
            j2 = J2;
        } else {
            j2 = -1;
        }
        if (J > 0) {
            j3 = J;
        }
        return new EsdsData(h2, bArr, j2, j3);
    }

    private static int l(ParsableByteArray parsableByteArray) {
        int H = parsableByteArray.H();
        int i2 = H & 127;
        while ((H & 128) == 128) {
            H = parsableByteArray.H();
            i2 = (i2 << 7) | (H & 127);
        }
        return i2;
    }

    private static int m(ParsableByteArray parsableByteArray) {
        parsableByteArray.U(16);
        return parsableByteArray.q();
    }

    private static Metadata n(ParsableByteArray parsableByteArray, int i2) {
        parsableByteArray.V(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.f() < i2) {
            Metadata.Entry c2 = MetadataUtil.c(parsableByteArray);
            if (c2 != null) {
                arrayList.add(c2);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    private static Pair<Long, String> o(ParsableByteArray parsableByteArray) {
        int i2;
        int i3 = 8;
        parsableByteArray.U(8);
        int c2 = Atom.c(parsableByteArray.q());
        if (c2 == 0) {
            i2 = 8;
        } else {
            i2 = 16;
        }
        parsableByteArray.V(i2);
        long J = parsableByteArray.J();
        if (c2 == 0) {
            i3 = 4;
        }
        parsableByteArray.V(i3);
        int N = parsableByteArray.N();
        return Pair.create(Long.valueOf(J), "" + ((char) (((N >> 10) & 31) + 96)) + ((char) (((N >> 5) & 31) + 96)) + ((char) ((N & 31) + 96)));
    }

    public static Metadata p(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom g2 = containerAtom.g(1751411826);
        Atom.LeafAtom g3 = containerAtom.g(1801812339);
        Atom.LeafAtom g4 = containerAtom.g(1768715124);
        if (g2 == null || g3 == null || g4 == null || m(g2.f8528b) != 1835299937) {
            return null;
        }
        ParsableByteArray parsableByteArray = g3.f8528b;
        parsableByteArray.U(12);
        int q2 = parsableByteArray.q();
        String[] strArr = new String[q2];
        for (int i2 = 0; i2 < q2; i2++) {
            int q3 = parsableByteArray.q();
            parsableByteArray.V(4);
            strArr[i2] = parsableByteArray.E(q3 - 8);
        }
        ParsableByteArray parsableByteArray2 = g4.f8528b;
        parsableByteArray2.U(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray2.a() > 8) {
            int f2 = parsableByteArray2.f();
            int q4 = parsableByteArray2.q();
            int q5 = parsableByteArray2.q() - 1;
            if (q5 < 0 || q5 >= q2) {
                Log.h("AtomParsers", "Skipped metadata with unknown key index: " + q5);
            } else {
                MdtaMetadataEntry h2 = MetadataUtil.h(parsableByteArray2, f2 + q4, strArr[q5]);
                if (h2 != null) {
                    arrayList.add(h2);
                }
            }
            parsableByteArray2.U(f2 + q4);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    private static void q(ParsableByteArray parsableByteArray, int i2, int i3, int i4, StsdData stsdData) {
        parsableByteArray.U(i3 + 8 + 8);
        if (i2 == 1835365492) {
            parsableByteArray.B();
            String B = parsableByteArray.B();
            if (B != null) {
                stsdData.f8544b = new Format.Builder().Z(i4).o0(B).K();
            }
        }
    }

    public static Mp4TimestampData r(ParsableByteArray parsableByteArray) {
        long j2;
        long j3;
        parsableByteArray.U(8);
        if (Atom.c(parsableByteArray.q()) == 0) {
            j3 = parsableByteArray.J();
            j2 = parsableByteArray.J();
        } else {
            j3 = parsableByteArray.A();
            j2 = parsableByteArray.A();
        }
        return new Mp4TimestampData(j3, j2, parsableByteArray.J());
    }

    private static float s(ParsableByteArray parsableByteArray, int i2) {
        parsableByteArray.U(i2 + 8);
        return ((float) parsableByteArray.L()) / ((float) parsableByteArray.L());
    }

    private static byte[] t(ParsableByteArray parsableByteArray, int i2, int i3) {
        int i4 = i2 + 8;
        while (i4 - i2 < i3) {
            parsableByteArray.U(i4);
            int q2 = parsableByteArray.q();
            if (parsableByteArray.q() == 1886547818) {
                return Arrays.copyOfRange(parsableByteArray.e(), i4, q2 + i4);
            }
            i4 += q2;
        }
        return null;
    }

    private static Pair<Integer, TrackEncryptionBox> u(ParsableByteArray parsableByteArray, int i2, int i3) throws ParserException {
        boolean z2;
        Pair<Integer, TrackEncryptionBox> i4;
        int f2 = parsableByteArray.f();
        while (f2 - i2 < i3) {
            parsableByteArray.U(f2);
            int q2 = parsableByteArray.q();
            if (q2 > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            ExtractorUtil.a(z2, "childAtomSize must be positive");
            if (parsableByteArray.q() == 1936289382 && (i4 = i(parsableByteArray, f2, q2)) != null) {
                return i4;
            }
            f2 += q2;
        }
        return null;
    }

    private static TrackEncryptionBox v(ParsableByteArray parsableByteArray, int i2, int i3, String str) {
        int i4;
        int i5;
        boolean z2;
        int i6 = i2 + 8;
        while (true) {
            byte[] bArr = null;
            if (i6 - i2 >= i3) {
                return null;
            }
            parsableByteArray.U(i6);
            int q2 = parsableByteArray.q();
            if (parsableByteArray.q() == 1952804451) {
                int c2 = Atom.c(parsableByteArray.q());
                parsableByteArray.V(1);
                if (c2 == 0) {
                    parsableByteArray.V(1);
                    i5 = 0;
                    i4 = 0;
                } else {
                    int H = parsableByteArray.H();
                    i4 = H & 15;
                    i5 = (H & 240) >> 4;
                }
                if (parsableByteArray.H() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                int H2 = parsableByteArray.H();
                byte[] bArr2 = new byte[16];
                parsableByteArray.l(bArr2, 0, 16);
                if (z2 && H2 == 0) {
                    int H3 = parsableByteArray.H();
                    bArr = new byte[H3];
                    parsableByteArray.l(bArr, 0, H3);
                }
                return new TrackEncryptionBox(z2, str, H2, bArr2, i5, i4, bArr);
            }
            i6 += q2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0289  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02ad  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02bd  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x036d  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x03a9  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0131  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.media3.extractor.mp4.TrackSampleTable w(androidx.media3.extractor.mp4.Track r37, androidx.media3.extractor.mp4.Atom.ContainerAtom r38, androidx.media3.extractor.GaplessInfoHolder r39) throws androidx.media3.common.ParserException {
        /*
            r1 = r37
            r0 = r38
            r2 = r39
            r3 = 1937011578(0x7374737a, float:1.936741E31)
            androidx.media3.extractor.mp4.Atom$LeafAtom r3 = r0.g(r3)
            if (r3 == 0) goto L_0x0017
            androidx.media3.extractor.mp4.AtomParsers$StszSampleSizeBox r5 = new androidx.media3.extractor.mp4.AtomParsers$StszSampleSizeBox
            androidx.media3.common.Format r6 = r1.f8665f
            r5.<init>(r3, r6)
            goto L_0x0025
        L_0x0017:
            r3 = 1937013298(0x73747a32, float:1.9369489E31)
            androidx.media3.extractor.mp4.Atom$LeafAtom r3 = r0.g(r3)
            if (r3 == 0) goto L_0x0521
            androidx.media3.extractor.mp4.AtomParsers$Stz2SampleSizeBox r5 = new androidx.media3.extractor.mp4.AtomParsers$Stz2SampleSizeBox
            r5.<init>(r3)
        L_0x0025:
            int r3 = r5.c()
            r6 = 0
            if (r3 != 0) goto L_0x0040
            androidx.media3.extractor.mp4.TrackSampleTable r9 = new androidx.media3.extractor.mp4.TrackSampleTable
            long[] r2 = new long[r6]
            int[] r3 = new int[r6]
            r4 = 0
            long[] r5 = new long[r6]
            int[] r6 = new int[r6]
            r7 = 0
            r0 = r9
            r1 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x0040:
            r7 = 1937007471(0x7374636f, float:1.9362445E31)
            androidx.media3.extractor.mp4.Atom$LeafAtom r7 = r0.g(r7)
            r8 = 1
            if (r7 != 0) goto L_0x0059
            r7 = 1668232756(0x636f3634, float:4.4126776E21)
            androidx.media3.extractor.mp4.Atom$LeafAtom r7 = r0.g(r7)
            java.lang.Object r7 = androidx.media3.common.util.Assertions.f(r7)
            androidx.media3.extractor.mp4.Atom$LeafAtom r7 = (androidx.media3.extractor.mp4.Atom.LeafAtom) r7
            r9 = 1
            goto L_0x005a
        L_0x0059:
            r9 = 0
        L_0x005a:
            androidx.media3.common.util.ParsableByteArray r7 = r7.f8528b
            r10 = 1937011555(0x73747363, float:1.9367382E31)
            androidx.media3.extractor.mp4.Atom$LeafAtom r10 = r0.g(r10)
            java.lang.Object r10 = androidx.media3.common.util.Assertions.f(r10)
            androidx.media3.extractor.mp4.Atom$LeafAtom r10 = (androidx.media3.extractor.mp4.Atom.LeafAtom) r10
            androidx.media3.common.util.ParsableByteArray r10 = r10.f8528b
            r11 = 1937011827(0x73747473, float:1.9367711E31)
            androidx.media3.extractor.mp4.Atom$LeafAtom r11 = r0.g(r11)
            java.lang.Object r11 = androidx.media3.common.util.Assertions.f(r11)
            androidx.media3.extractor.mp4.Atom$LeafAtom r11 = (androidx.media3.extractor.mp4.Atom.LeafAtom) r11
            androidx.media3.common.util.ParsableByteArray r11 = r11.f8528b
            r12 = 1937011571(0x73747373, float:1.9367401E31)
            androidx.media3.extractor.mp4.Atom$LeafAtom r12 = r0.g(r12)
            if (r12 == 0) goto L_0x0086
            androidx.media3.common.util.ParsableByteArray r12 = r12.f8528b
            goto L_0x0087
        L_0x0086:
            r12 = 0
        L_0x0087:
            r13 = 1668576371(0x63747473, float:4.5093966E21)
            androidx.media3.extractor.mp4.Atom$LeafAtom r0 = r0.g(r13)
            if (r0 == 0) goto L_0x0093
            androidx.media3.common.util.ParsableByteArray r0 = r0.f8528b
            goto L_0x0094
        L_0x0093:
            r0 = 0
        L_0x0094:
            androidx.media3.extractor.mp4.AtomParsers$ChunkIterator r13 = new androidx.media3.extractor.mp4.AtomParsers$ChunkIterator
            r13.<init>(r10, r7, r9)
            r7 = 12
            r11.U(r7)
            int r9 = r11.L()
            int r9 = r9 - r8
            int r10 = r11.L()
            int r14 = r11.L()
            if (r0 == 0) goto L_0x00b5
            r0.U(r7)
            int r15 = r0.L()
            goto L_0x00b6
        L_0x00b5:
            r15 = 0
        L_0x00b6:
            r4 = -1
            if (r12 == 0) goto L_0x00cb
            r12.U(r7)
            int r7 = r12.L()
            if (r7 <= 0) goto L_0x00c9
            int r16 = r12.L()
            int r16 = r16 + -1
            goto L_0x00ce
        L_0x00c9:
            r12 = 0
            goto L_0x00cc
        L_0x00cb:
            r7 = 0
        L_0x00cc:
            r16 = -1
        L_0x00ce:
            int r6 = r5.b()
            androidx.media3.common.Format r8 = r1.f8665f
            java.lang.String r8 = r8.f4015n
            if (r6 == r4) goto L_0x00fa
            java.lang.String r4 = "audio/raw"
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x00f0
            java.lang.String r4 = "audio/g711-mlaw"
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x00f0
            java.lang.String r4 = "audio/g711-alaw"
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x00fa
        L_0x00f0:
            if (r9 != 0) goto L_0x00fa
            if (r15 != 0) goto L_0x00fa
            if (r7 != 0) goto L_0x00fa
            r38 = r7
            r4 = 1
            goto L_0x00fd
        L_0x00fa:
            r38 = r7
            r4 = 0
        L_0x00fd:
            if (r4 == 0) goto L_0x0131
            int r0 = r13.f8530a
            long[] r4 = new long[r0]
            int[] r0 = new int[r0]
        L_0x0105:
            boolean r5 = r13.a()
            if (r5 == 0) goto L_0x0116
            int r5 = r13.f8531b
            long r9 = r13.f8533d
            r4[r5] = r9
            int r9 = r13.f8532c
            r0[r5] = r9
            goto L_0x0105
        L_0x0116:
            long r9 = (long) r14
            androidx.media3.extractor.mp4.FixedSampleSizeRechunker$Results r0 = androidx.media3.extractor.mp4.FixedSampleSizeRechunker.a(r6, r4, r0, r9)
            long[] r4 = r0.f8565a
            int[] r5 = r0.f8566b
            int r6 = r0.f8567c
            long[] r9 = r0.f8568d
            int[] r10 = r0.f8569e
            long r11 = r0.f8570f
            r14 = r1
            r0 = r3
            r2 = r4
            r3 = r5
            r4 = r6
            r13 = r10
            r15 = r11
            r12 = r9
            goto L_0x029c
        L_0x0131:
            long[] r4 = new long[r3]
            int[] r6 = new int[r3]
            long[] r7 = new long[r3]
            int[] r8 = new int[r3]
            r24 = r11
            r2 = r16
            r1 = 0
            r11 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r16 = r15
            r15 = r14
            r14 = r10
            r36 = r9
            r9 = r38
        L_0x0151:
            r38 = r36
            java.lang.String r10 = "AtomParsers"
            if (r1 >= r3) goto L_0x0215
            r28 = r27
            r27 = r22
            r22 = 1
        L_0x015d:
            if (r27 != 0) goto L_0x017a
            boolean r22 = r13.a()
            if (r22 == 0) goto L_0x017a
            r30 = r14
            r31 = r15
            long r14 = r13.f8533d
            r32 = r3
            int r3 = r13.f8532c
            r27 = r3
            r28 = r14
            r14 = r30
            r15 = r31
            r3 = r32
            goto L_0x015d
        L_0x017a:
            r32 = r3
            r30 = r14
            r31 = r15
            if (r22 != 0) goto L_0x019e
            java.lang.String r2 = "Unexpected end of chunk data"
            androidx.media3.common.util.Log.h(r10, r2)
            long[] r4 = java.util.Arrays.copyOf(r4, r1)
            int[] r6 = java.util.Arrays.copyOf(r6, r1)
            long[] r7 = java.util.Arrays.copyOf(r7, r1)
            int[] r8 = java.util.Arrays.copyOf(r8, r1)
            r3 = r1
            r2 = r21
            r1 = r27
            goto L_0x021d
        L_0x019e:
            if (r0 == 0) goto L_0x01b1
        L_0x01a0:
            if (r23 != 0) goto L_0x01af
            if (r16 <= 0) goto L_0x01af
            int r23 = r0.L()
            int r21 = r0.q()
            int r16 = r16 + -1
            goto L_0x01a0
        L_0x01af:
            int r23 = r23 + -1
        L_0x01b1:
            r3 = r21
            r4[r1] = r28
            int r10 = r5.a()
            r6[r1] = r10
            if (r10 <= r11) goto L_0x01be
            r11 = r10
        L_0x01be:
            long r14 = (long) r3
            long r14 = r25 + r14
            r7[r1] = r14
            if (r12 != 0) goto L_0x01c7
            r10 = 1
            goto L_0x01c8
        L_0x01c7:
            r10 = 0
        L_0x01c8:
            r8[r1] = r10
            if (r1 != r2) goto L_0x01de
            r10 = 1
            r8[r1] = r10
            int r9 = r9 + -1
            if (r9 <= 0) goto L_0x01de
            java.lang.Object r2 = androidx.media3.common.util.Assertions.f(r12)
            androidx.media3.common.util.ParsableByteArray r2 = (androidx.media3.common.util.ParsableByteArray) r2
            int r2 = r2.L()
            int r2 = r2 - r10
        L_0x01de:
            r15 = r2
            r10 = r3
            r14 = r31
            long r2 = (long) r14
            long r25 = r25 + r2
            int r2 = r30 + -1
            if (r2 != 0) goto L_0x01f6
            if (r38 <= 0) goto L_0x01f6
            int r2 = r24.L()
            int r3 = r24.q()
            int r14 = r38 + -1
            goto L_0x01f9
        L_0x01f6:
            r3 = r14
            r14 = r38
        L_0x01f9:
            r38 = r2
            r2 = r6[r1]
            r21 = r3
            long r2 = (long) r2
            long r2 = r28 + r2
            int r22 = r27 + -1
            int r1 = r1 + 1
            r27 = r2
            r2 = r15
            r15 = r21
            r3 = r32
            r21 = r10
            r36 = r14
            r14 = r38
            goto L_0x0151
        L_0x0215:
            r32 = r3
            r30 = r14
            r2 = r21
            r1 = r22
        L_0x021d:
            long r12 = (long) r2
            long r12 = r25 + r12
            if (r0 == 0) goto L_0x0232
        L_0x0222:
            if (r16 <= 0) goto L_0x0232
            int r2 = r0.L()
            if (r2 == 0) goto L_0x022c
            r0 = 0
            goto L_0x0233
        L_0x022c:
            r0.q()
            int r16 = r16 + -1
            goto L_0x0222
        L_0x0232:
            r0 = 1
        L_0x0233:
            if (r9 != 0) goto L_0x0245
            if (r30 != 0) goto L_0x0245
            if (r1 != 0) goto L_0x0245
            if (r38 != 0) goto L_0x0245
            r2 = r23
            if (r2 != 0) goto L_0x0247
            if (r0 != 0) goto L_0x0242
            goto L_0x0247
        L_0x0242:
            r14 = r37
            goto L_0x0295
        L_0x0245:
            r2 = r23
        L_0x0247:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r14 = "Inconsistent stbl box for track "
            r5.append(r14)
            r14 = r37
            int r15 = r14.f8660a
            r5.append(r15)
            java.lang.String r15 = ": remainingSynchronizationSamples "
            r5.append(r15)
            r5.append(r9)
            java.lang.String r9 = ", remainingSamplesAtTimestampDelta "
            r5.append(r9)
            r9 = r30
            r5.append(r9)
            java.lang.String r9 = ", remainingSamplesInChunk "
            r5.append(r9)
            r5.append(r1)
            java.lang.String r1 = ", remainingTimestampDeltaChanges "
            r5.append(r1)
            r9 = r38
            r5.append(r9)
            java.lang.String r1 = ", remainingSamplesAtTimestampOffset "
            r5.append(r1)
            r5.append(r2)
            if (r0 != 0) goto L_0x0289
            java.lang.String r0 = ", ctts invalid"
            goto L_0x028b
        L_0x0289:
            java.lang.String r0 = ""
        L_0x028b:
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            androidx.media3.common.util.Log.h(r10, r0)
        L_0x0295:
            r0 = r3
            r2 = r4
            r3 = r6
            r4 = r11
            r15 = r12
            r12 = r7
            r13 = r8
        L_0x029c:
            r7 = 1000000(0xf4240, double:4.940656E-318)
            long r9 = r14.f8662c
            r5 = r15
            long r7 = androidx.media3.common.util.Util.c1(r5, r7, r9)
            long[] r1 = r14.f8667h
            r10 = 1000000(0xf4240, double:4.940656E-318)
            if (r1 != 0) goto L_0x02bd
            long r0 = r14.f8662c
            androidx.media3.common.util.Util.d1(r12, r10, r0)
            androidx.media3.extractor.mp4.TrackSampleTable r9 = new androidx.media3.extractor.mp4.TrackSampleTable
            r0 = r9
            r1 = r37
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x02bd:
            int r1 = r1.length
            r5 = 1
            if (r1 != r5) goto L_0x035a
            int r1 = r14.f8661b
            if (r1 != r5) goto L_0x035a
            int r1 = r12.length
            r5 = 2
            if (r1 < r5) goto L_0x035a
            long[] r1 = r14.f8668i
            java.lang.Object r1 = androidx.media3.common.util.Assertions.f(r1)
            long[] r1 = (long[]) r1
            r5 = 0
            r21 = r1[r5]
            long[] r1 = r14.f8667h
            r23 = r1[r5]
            long r5 = r14.f8662c
            long r7 = r14.f8663d
            r25 = r5
            r27 = r7
            long r5 = androidx.media3.common.util.Util.c1(r23, r25, r27)
            long r23 = r21 + r5
            r5 = r12
            r6 = r15
            r8 = r21
            r25 = r0
            r0 = r10
            r10 = r23
            boolean r5 = b(r5, r6, r8, r10)
            if (r5 == 0) goto L_0x035c
            long r6 = r15 - r23
            r5 = 0
            r8 = r12[r5]
            long r26 = r21 - r8
            androidx.media3.common.Format r5 = r14.f8665f
            int r5 = r5.C
            long r8 = (long) r5
            long r10 = r14.f8662c
            r28 = r8
            r30 = r10
            long r10 = androidx.media3.common.util.Util.c1(r26, r28, r30)
            androidx.media3.common.Format r5 = r14.f8665f
            int r5 = r5.C
            long r8 = (long) r5
            long r0 = r14.f8662c
            r38 = r4
            r4 = r10
            r10 = r0
            long r0 = androidx.media3.common.util.Util.c1(r6, r8, r10)
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0324
            int r8 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x035e
        L_0x0324:
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 > 0) goto L_0x035e
            int r8 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r8 > 0) goto L_0x035e
            int r5 = (int) r4
            r4 = r39
            r4.f8036a = r5
            int r1 = (int) r0
            r4.f8037b = r1
            long r0 = r14.f8662c
            r4 = 1000000(0xf4240, double:4.940656E-318)
            androidx.media3.common.util.Util.d1(r12, r4, r0)
            long[] r0 = r14.f8667h
            r1 = 0
            r4 = r0[r1]
            r6 = 1000000(0xf4240, double:4.940656E-318)
            long r8 = r14.f8663d
            long r7 = androidx.media3.common.util.Util.c1(r4, r6, r8)
            androidx.media3.extractor.mp4.TrackSampleTable r9 = new androidx.media3.extractor.mp4.TrackSampleTable
            r0 = r9
            r1 = r37
            r4 = r38
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x035a:
            r25 = r0
        L_0x035c:
            r38 = r4
        L_0x035e:
            long[] r0 = r14.f8667h
            int r1 = r0.length
            r4 = 1
            if (r1 != r4) goto L_0x03a9
            r1 = 0
            r4 = r0[r1]
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x03a9
            long[] r0 = r14.f8668i
            java.lang.Object r0 = androidx.media3.common.util.Assertions.f(r0)
            long[] r0 = (long[]) r0
            r4 = r0[r1]
            r6 = 0
        L_0x0378:
            int r0 = r12.length
            if (r6 >= r0) goto L_0x038f
            r0 = r12[r6]
            long r17 = r0 - r4
            r19 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r14.f8662c
            r21 = r0
            long r0 = androidx.media3.common.util.Util.c1(r17, r19, r21)
            r12[r6] = r0
            int r6 = r6 + 1
            goto L_0x0378
        L_0x038f:
            long r17 = r15 - r4
            r19 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r14.f8662c
            r21 = r0
            long r7 = androidx.media3.common.util.Util.c1(r17, r19, r21)
            androidx.media3.extractor.mp4.TrackSampleTable r9 = new androidx.media3.extractor.mp4.TrackSampleTable
            r0 = r9
            r1 = r37
            r4 = r38
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x03a9:
            int r1 = r14.f8661b
            r4 = 1
            if (r1 != r4) goto L_0x03b0
            r10 = 1
            goto L_0x03b1
        L_0x03b0:
            r10 = 0
        L_0x03b1:
            int r1 = r0.length
            int[] r1 = new int[r1]
            int r0 = r0.length
            int[] r0 = new int[r0]
            long[] r4 = r14.f8668i
            java.lang.Object r4 = androidx.media3.common.util.Assertions.f(r4)
            long[] r4 = (long[]) r4
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x03c3:
            long[] r9 = r14.f8667h
            int r11 = r9.length
            if (r5 >= r11) goto L_0x0424
            r11 = r2
            r15 = r3
            r2 = r4[r5]
            r21 = -1
            int r16 = (r2 > r21 ? 1 : (r2 == r21 ? 0 : -1))
            if (r16 == 0) goto L_0x0413
            r26 = r9[r5]
            r16 = r8
            long r8 = r14.f8662c
            r39 = r6
            r21 = r7
            long r6 = r14.f8663d
            r28 = r8
            r30 = r6
            long r6 = androidx.media3.common.util.Util.c1(r26, r28, r30)
            r8 = 1
            int r9 = androidx.media3.common.util.Util.h(r12, r2, r8, r8)
            r1[r5] = r9
            long r2 = r2 + r6
            r6 = 0
            int r2 = androidx.media3.common.util.Util.d(r12, r2, r10, r6)
            r0[r5] = r2
        L_0x03f5:
            r2 = r1[r5]
            r3 = r0[r5]
            if (r2 >= r3) goto L_0x0405
            r7 = r13[r2]
            r7 = r7 & r8
            if (r7 != 0) goto L_0x0405
            int r2 = r2 + 1
            r1[r5] = r2
            goto L_0x03f5
        L_0x0405:
            int r7 = r3 - r2
            int r7 = r21 + r7
            r9 = r16
            if (r9 == r2) goto L_0x040f
            r2 = 1
            goto L_0x0410
        L_0x040f:
            r2 = 0
        L_0x0410:
            r2 = r39 | r2
            goto L_0x041d
        L_0x0413:
            r39 = r6
            r21 = r7
            r9 = r8
            r6 = 0
            r8 = 1
            r2 = r39
            r3 = r9
        L_0x041d:
            int r5 = r5 + 1
            r6 = r2
            r8 = r3
            r2 = r11
            r3 = r15
            goto L_0x03c3
        L_0x0424:
            r11 = r2
            r15 = r3
            r39 = r6
            r3 = r25
            r6 = 0
            r8 = 1
            if (r7 == r3) goto L_0x042f
            goto L_0x0430
        L_0x042f:
            r8 = 0
        L_0x0430:
            r2 = r39 | r8
            if (r2 == 0) goto L_0x0437
            long[] r3 = new long[r7]
            goto L_0x0438
        L_0x0437:
            r3 = r11
        L_0x0438:
            if (r2 == 0) goto L_0x043d
            int[] r4 = new int[r7]
            goto L_0x043e
        L_0x043d:
            r4 = r15
        L_0x043e:
            if (r2 == 0) goto L_0x0442
            r5 = 0
            goto L_0x0444
        L_0x0442:
            r5 = r38
        L_0x0444:
            if (r2 == 0) goto L_0x0449
            int[] r8 = new int[r7]
            goto L_0x044a
        L_0x0449:
            r8 = r13
        L_0x044a:
            long[] r7 = new long[r7]
            r39 = r5
            r38 = r15
            r9 = 0
            r15 = 0
        L_0x0453:
            long[] r5 = r14.f8667h
            int r5 = r5.length
            if (r6 >= r5) goto L_0x04fd
            long[] r5 = r14.f8668i
            r16 = r5[r6]
            r5 = r1[r6]
            r18 = r1
            r1 = r0[r6]
            r27 = r0
            if (r2 == 0) goto L_0x0476
            int r0 = r1 - r5
            java.lang.System.arraycopy(r11, r5, r3, r15, r0)
            r28 = r11
            r11 = r38
            java.lang.System.arraycopy(r11, r5, r4, r15, r0)
            java.lang.System.arraycopy(r13, r5, r8, r15, r0)
            goto L_0x047a
        L_0x0476:
            r28 = r11
            r11 = r38
        L_0x047a:
            r0 = r39
        L_0x047c:
            if (r5 >= r1) goto L_0x04d7
            r23 = 1000000(0xf4240, double:4.940656E-318)
            r29 = r0
            r38 = r1
            long r0 = r14.f8663d
            r21 = r9
            r25 = r0
            long r0 = androidx.media3.common.util.Util.c1(r21, r23, r25)
            r21 = r12[r5]
            long r30 = r21 - r16
            r32 = 1000000(0xf4240, double:4.940656E-318)
            r21 = r12
            r22 = r13
            long r12 = r14.f8662c
            r34 = r12
            long r12 = androidx.media3.common.util.Util.c1(r30, r32, r34)
            r30 = r8
            int r8 = r14.f8661b
            boolean r8 = c(r8)
            r23 = r9
            if (r8 == 0) goto L_0x04b5
            r8 = 0
            long r12 = java.lang.Math.max(r8, r12)
            goto L_0x04b7
        L_0x04b5:
            r8 = 0
        L_0x04b7:
            long r0 = r0 + r12
            r7[r15] = r0
            if (r2 == 0) goto L_0x04c5
            r0 = r4[r15]
            r1 = r29
            if (r0 <= r1) goto L_0x04c7
            r0 = r11[r5]
            goto L_0x04c8
        L_0x04c5:
            r1 = r29
        L_0x04c7:
            r0 = r1
        L_0x04c8:
            int r15 = r15 + 1
            int r5 = r5 + 1
            r1 = r38
            r12 = r21
            r13 = r22
            r9 = r23
            r8 = r30
            goto L_0x047c
        L_0x04d7:
            r1 = r0
            r30 = r8
            r23 = r9
            r21 = r12
            r22 = r13
            r8 = 0
            long[] r0 = r14.f8667h
            r12 = r0[r6]
            long r12 = r23 + r12
            int r6 = r6 + 1
            r39 = r1
            r38 = r11
            r9 = r12
            r1 = r18
            r12 = r21
            r13 = r22
            r0 = r27
            r11 = r28
            r8 = r30
            goto L_0x0453
        L_0x04fd:
            r30 = r8
            r23 = r9
            r0 = 1000000(0xf4240, double:4.940656E-318)
            long r5 = r14.f8663d
            r21 = r23
            r23 = r0
            r25 = r5
            long r8 = androidx.media3.common.util.Util.c1(r21, r23, r25)
            androidx.media3.extractor.mp4.TrackSampleTable r10 = new androidx.media3.extractor.mp4.TrackSampleTable
            r0 = r10
            r1 = r37
            r2 = r3
            r3 = r4
            r4 = r39
            r5 = r7
            r6 = r30
            r7 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r10
        L_0x0521:
            java.lang.String r0 = "Track has no sample table size information"
            r1 = 0
            androidx.media3.common.ParserException r0 = androidx.media3.common.ParserException.a(r0, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.AtomParsers.w(androidx.media3.extractor.mp4.Track, androidx.media3.extractor.mp4.Atom$ContainerAtom, androidx.media3.extractor.GaplessInfoHolder):androidx.media3.extractor.mp4.TrackSampleTable");
    }

    private static StsdData x(ParsableByteArray parsableByteArray, int i2, int i3, String str, DrmInitData drmInitData, boolean z2) throws ParserException {
        boolean z3;
        int i4;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i5 = i2;
        parsableByteArray2.U(12);
        int q2 = parsableByteArray.q();
        StsdData stsdData = new StsdData(q2);
        for (int i6 = 0; i6 < q2; i6++) {
            int f2 = parsableByteArray.f();
            int q3 = parsableByteArray.q();
            if (q3 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            ExtractorUtil.a(z3, "childAtomSize must be positive");
            int q4 = parsableByteArray.q();
            if (q4 == 1635148593 || q4 == 1635148595 || q4 == 1701733238 || q4 == 1831958048 || q4 == 1836070006 || q4 == 1752589105 || q4 == 1751479857 || q4 == 1932670515 || q4 == 1211250227 || q4 == 1987063864 || q4 == 1987063865 || q4 == 1635135537 || q4 == 1685479798 || q4 == 1685479729 || q4 == 1685481573 || q4 == 1685481521) {
                i4 = f2;
                E(parsableByteArray, q4, i4, q3, i2, i3, drmInitData, stsdData, i6);
            } else if (q4 == 1836069985 || q4 == 1701733217 || q4 == 1633889587 || q4 == 1700998451 || q4 == 1633889588 || q4 == 1835823201 || q4 == 1685353315 || q4 == 1685353317 || q4 == 1685353320 || q4 == 1685353324 || q4 == 1685353336 || q4 == 1935764850 || q4 == 1935767394 || q4 == 1819304813 || q4 == 1936684916 || q4 == 1953984371 || q4 == 778924082 || q4 == 778924083 || q4 == 1835557169 || q4 == 1835560241 || q4 == 1634492771 || q4 == 1634492791 || q4 == 1970037111 || q4 == 1332770163 || q4 == 1716281667) {
                i4 = f2;
                g(parsableByteArray, q4, f2, q3, i2, str, z2, drmInitData, stsdData, i6);
            } else {
                if (q4 == 1414810956 || q4 == 1954034535 || q4 == 2004251764 || q4 == 1937010800 || q4 == 1664495672) {
                    y(parsableByteArray, q4, f2, q3, i2, str, stsdData);
                } else if (q4 == 1835365492) {
                    q(parsableByteArray2, q4, f2, i5, stsdData);
                } else if (q4 == 1667329389) {
                    stsdData.f8544b = new Format.Builder().Z(i5).o0("application/x-camera-motion").K();
                }
                i4 = f2;
            }
            parsableByteArray2.U(i4 + q3);
        }
        return stsdData;
    }

    private static void y(ParsableByteArray parsableByteArray, int i2, int i3, int i4, int i5, String str, StsdData stsdData) {
        parsableByteArray.U(i3 + 8 + 8);
        String str2 = "application/ttml+xml";
        ImmutableList immutableList = null;
        long j2 = Clock.MAX_TIME;
        if (i2 != 1414810956) {
            if (i2 == 1954034535) {
                int i6 = (i4 - 8) - 8;
                byte[] bArr = new byte[i6];
                parsableByteArray.l(bArr, 0, i6);
                immutableList = ImmutableList.s(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i2 == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i2 == 1937010800) {
                j2 = 0;
            } else if (i2 == 1664495672) {
                stsdData.f8546d = 1;
                str2 = "application/x-mp4-cea-608";
            } else {
                throw new IllegalStateException();
            }
        }
        stsdData.f8544b = new Format.Builder().Z(i5).o0(str2).e0(str).s0(j2).b0(immutableList).K();
    }

    private static TkhdData z(ParsableByteArray parsableByteArray) {
        int i2;
        boolean z2;
        long j2;
        int i3 = 8;
        parsableByteArray.U(8);
        int c2 = Atom.c(parsableByteArray.q());
        if (c2 == 0) {
            i2 = 8;
        } else {
            i2 = 16;
        }
        parsableByteArray.V(i2);
        int q2 = parsableByteArray.q();
        parsableByteArray.V(4);
        int f2 = parsableByteArray.f();
        if (c2 == 0) {
            i3 = 4;
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i5 >= i3) {
                z2 = true;
                break;
            } else if (parsableByteArray.e()[f2 + i5] != -1) {
                z2 = false;
                break;
            } else {
                i5++;
            }
        }
        long j3 = -9223372036854775807L;
        if (z2) {
            parsableByteArray.V(i3);
        } else {
            if (c2 == 0) {
                j2 = parsableByteArray.J();
            } else {
                j2 = parsableByteArray.M();
            }
            if (j2 != 0) {
                j3 = j2;
            }
        }
        parsableByteArray.V(16);
        int q3 = parsableByteArray.q();
        int q4 = parsableByteArray.q();
        parsableByteArray.V(4);
        int q5 = parsableByteArray.q();
        int q6 = parsableByteArray.q();
        if (q3 == 0 && q4 == 65536 && q5 == -65536 && q6 == 0) {
            i4 = 90;
        } else if (q3 == 0 && q4 == -65536 && q5 == 65536 && q6 == 0) {
            i4 = RotationOptions.ROTATE_270;
        } else if (q3 == -65536 && q4 == 0 && q5 == 0 && q6 == -65536) {
            i4 = RotationOptions.ROTATE_180;
        }
        return new TkhdData(q2, j3, i4);
    }
}
