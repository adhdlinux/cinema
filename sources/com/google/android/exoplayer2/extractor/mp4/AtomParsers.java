package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import com.facebook.common.time.Clock;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ExtractorUtil;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.android.exoplayer2.video.DolbyVisionConfig;
import com.google.android.exoplayer2.video.HevcConfig;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import com.unity3d.services.core.device.MimeTypes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class AtomParsers {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f24536a = Util.p0("OpusHead");

    private static final class ChunkIterator {

        /* renamed from: a  reason: collision with root package name */
        public final int f24537a;

        /* renamed from: b  reason: collision with root package name */
        public int f24538b;

        /* renamed from: c  reason: collision with root package name */
        public int f24539c;

        /* renamed from: d  reason: collision with root package name */
        public long f24540d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f24541e;

        /* renamed from: f  reason: collision with root package name */
        private final ParsableByteArray f24542f;

        /* renamed from: g  reason: collision with root package name */
        private final ParsableByteArray f24543g;

        /* renamed from: h  reason: collision with root package name */
        private int f24544h;

        /* renamed from: i  reason: collision with root package name */
        private int f24545i;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z2) throws ParserException {
            this.f24543g = parsableByteArray;
            this.f24542f = parsableByteArray2;
            this.f24541e = z2;
            parsableByteArray2.U(12);
            this.f24537a = parsableByteArray2.L();
            parsableByteArray.U(12);
            this.f24545i = parsableByteArray.L();
            ExtractorUtil.a(parsableByteArray.q() != 1 ? false : true, "first_chunk must be 1");
            this.f24538b = -1;
        }

        public boolean a() {
            long j2;
            int i2;
            int i3 = this.f24538b + 1;
            this.f24538b = i3;
            if (i3 == this.f24537a) {
                return false;
            }
            if (this.f24541e) {
                j2 = this.f24542f.M();
            } else {
                j2 = this.f24542f.J();
            }
            this.f24540d = j2;
            if (this.f24538b == this.f24544h) {
                this.f24539c = this.f24543g.L();
                this.f24543g.V(4);
                int i4 = this.f24545i - 1;
                this.f24545i = i4;
                if (i4 > 0) {
                    i2 = this.f24543g.L() - 1;
                } else {
                    i2 = -1;
                }
                this.f24544h = i2;
            }
            return true;
        }
    }

    private static final class EsdsData {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f24546a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f24547b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final long f24548c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final long f24549d;

        public EsdsData(String str, byte[] bArr, long j2, long j3) {
            this.f24546a = str;
            this.f24547b = bArr;
            this.f24548c = j2;
            this.f24549d = j3;
        }
    }

    private interface SampleSizeBox {
        int a();

        int b();

        int c();
    }

    private static final class StsdData {

        /* renamed from: a  reason: collision with root package name */
        public final TrackEncryptionBox[] f24550a;

        /* renamed from: b  reason: collision with root package name */
        public Format f24551b;

        /* renamed from: c  reason: collision with root package name */
        public int f24552c;

        /* renamed from: d  reason: collision with root package name */
        public int f24553d = 0;

        public StsdData(int i2) {
            this.f24550a = new TrackEncryptionBox[i2];
        }
    }

    static final class StszSampleSizeBox implements SampleSizeBox {

        /* renamed from: a  reason: collision with root package name */
        private final int f24554a;

        /* renamed from: b  reason: collision with root package name */
        private final int f24555b;

        /* renamed from: c  reason: collision with root package name */
        private final ParsableByteArray f24556c;

        public StszSampleSizeBox(Atom.LeafAtom leafAtom, Format format) {
            ParsableByteArray parsableByteArray = leafAtom.f24535b;
            this.f24556c = parsableByteArray;
            parsableByteArray.U(12);
            int L = parsableByteArray.L();
            if ("audio/raw".equals(format.f23071m)) {
                int f02 = Util.f0(format.B, format.f23084z);
                if (L == 0 || L % f02 != 0) {
                    Log.i("AtomParsers", "Audio sample size mismatch. stsd sample size: " + f02 + ", stsz sample size: " + L);
                    L = f02;
                }
            }
            this.f24554a = L == 0 ? -1 : L;
            this.f24555b = parsableByteArray.L();
        }

        public int a() {
            int i2 = this.f24554a;
            return i2 == -1 ? this.f24556c.L() : i2;
        }

        public int b() {
            return this.f24554a;
        }

        public int c() {
            return this.f24555b;
        }
    }

    static final class Stz2SampleSizeBox implements SampleSizeBox {

        /* renamed from: a  reason: collision with root package name */
        private final ParsableByteArray f24557a;

        /* renamed from: b  reason: collision with root package name */
        private final int f24558b;

        /* renamed from: c  reason: collision with root package name */
        private final int f24559c;

        /* renamed from: d  reason: collision with root package name */
        private int f24560d;

        /* renamed from: e  reason: collision with root package name */
        private int f24561e;

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.f24535b;
            this.f24557a = parsableByteArray;
            parsableByteArray.U(12);
            this.f24559c = parsableByteArray.L() & JfifUtil.MARKER_FIRST_BYTE;
            this.f24558b = parsableByteArray.L();
        }

        public int a() {
            int i2 = this.f24559c;
            if (i2 == 8) {
                return this.f24557a.H();
            }
            if (i2 == 16) {
                return this.f24557a.N();
            }
            int i3 = this.f24560d;
            this.f24560d = i3 + 1;
            if (i3 % 2 != 0) {
                return this.f24561e & 15;
            }
            int H = this.f24557a.H();
            this.f24561e = H;
            return (H & 240) >> 4;
        }

        public int b() {
            return -1;
        }

        public int c() {
            return this.f24558b;
        }
    }

    private static final class TkhdData {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f24562a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long f24563b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final int f24564c;

        public TkhdData(int i2, long j2, int i3) {
            this.f24562a = i2;
            this.f24563b = j2;
            this.f24564c = i3;
        }
    }

    private AtomParsers() {
    }

    public static List<TrackSampleTable> A(Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder, long j2, DrmInitData drmInitData, boolean z2, boolean z3, Function<Track, Track> function) throws ParserException {
        Atom.ContainerAtom containerAtom2 = containerAtom;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < containerAtom2.f24534d.size(); i2++) {
            Atom.ContainerAtom containerAtom3 = containerAtom2.f24534d.get(i2);
            if (containerAtom3.f24531a != 1953653099) {
                GaplessInfoHolder gaplessInfoHolder2 = gaplessInfoHolder;
                Function<Track, Track> function2 = function;
            } else {
                Track apply = function.apply(z(containerAtom3, (Atom.LeafAtom) Assertions.e(containerAtom.g(1836476516)), j2, drmInitData, z2, z3));
                if (apply == null) {
                    GaplessInfoHolder gaplessInfoHolder3 = gaplessInfoHolder;
                } else {
                    GaplessInfoHolder gaplessInfoHolder4 = gaplessInfoHolder;
                    arrayList.add(v(apply, (Atom.ContainerAtom) Assertions.e(((Atom.ContainerAtom) Assertions.e(((Atom.ContainerAtom) Assertions.e(containerAtom3.f(1835297121))).f(1835626086))).f(1937007212)), gaplessInfoHolder));
                }
            }
        }
        return arrayList;
    }

    public static Pair<Metadata, Metadata> B(Atom.LeafAtom leafAtom) {
        ParsableByteArray parsableByteArray = leafAtom.f24535b;
        parsableByteArray.U(8);
        Metadata metadata = null;
        Metadata metadata2 = null;
        while (parsableByteArray.a() >= 8) {
            int f2 = parsableByteArray.f();
            int q2 = parsableByteArray.q();
            int q3 = parsableByteArray.q();
            if (q3 == 1835365473) {
                parsableByteArray.U(f2);
                metadata = C(parsableByteArray, f2 + q2);
            } else if (q3 == 1936553057) {
                parsableByteArray.U(f2);
                metadata2 = u(parsableByteArray, f2 + q2);
            }
            parsableByteArray.U(f2 + q2);
        }
        return Pair.create(metadata, metadata2);
    }

    private static Metadata C(ParsableByteArray parsableByteArray, int i2) {
        parsableByteArray.V(8);
        e(parsableByteArray);
        while (parsableByteArray.f() < i2) {
            int f2 = parsableByteArray.f();
            int q2 = parsableByteArray.q();
            if (parsableByteArray.q() == 1768715124) {
                parsableByteArray.U(f2);
                return l(parsableByteArray, f2 + q2);
            }
            parsableByteArray.U(f2 + q2);
        }
        return null;
    }

    private static void D(ParsableByteArray parsableByteArray, int i2, int i3, int i4, int i5, int i6, DrmInitData drmInitData, StsdData stsdData, int i7) throws ParserException {
        String str;
        byte[] bArr;
        String str2;
        boolean z2;
        int i8;
        DrmInitData drmInitData2;
        int i9;
        float f2;
        List<byte[]> list;
        int i10;
        int i11;
        int i12;
        boolean z3;
        int i13;
        boolean z4;
        boolean z5;
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        boolean z6;
        String str3;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i14 = i3;
        int i15 = i4;
        DrmInitData drmInitData3 = drmInitData;
        StsdData stsdData2 = stsdData;
        parsableByteArray2.U(i14 + 8 + 8);
        parsableByteArray2.V(16);
        int N = parsableByteArray.N();
        int N2 = parsableByteArray.N();
        parsableByteArray2.V(50);
        int f3 = parsableByteArray.f();
        int i16 = i2;
        if (i16 == 1701733238) {
            Pair<Integer, TrackEncryptionBox> s2 = s(parsableByteArray2, i14, i15);
            if (s2 != null) {
                i16 = ((Integer) s2.first).intValue();
                if (drmInitData3 == null) {
                    drmInitData3 = null;
                } else {
                    drmInitData3 = drmInitData3.d(((TrackEncryptionBox) s2.second).f24671b);
                }
                stsdData2.f24550a[i7] = (TrackEncryptionBox) s2.second;
            }
            parsableByteArray2.U(f3);
        }
        String str4 = "video/3gpp";
        if (i16 == 1831958048) {
            str = "video/mpeg";
        } else if (i16 == 1211250227) {
            str = str4;
        } else {
            str = null;
        }
        float f4 = 1.0f;
        String str5 = null;
        List<byte[]> list2 = null;
        byte[] bArr2 = null;
        int i17 = -1;
        int i18 = -1;
        int i19 = -1;
        int i20 = -1;
        ByteBuffer byteBuffer3 = null;
        EsdsData esdsData = null;
        boolean z11 = false;
        while (f3 - i14 < i15) {
            parsableByteArray2.U(f3);
            int f5 = parsableByteArray.f();
            int q2 = parsableByteArray.q();
            if (q2 == 0) {
                str2 = str4;
                if (parsableByteArray.f() - i14 == i15) {
                    break;
                }
            } else {
                str2 = str4;
            }
            if (q2 > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            ExtractorUtil.a(z2, "childAtomSize must be positive");
            int q3 = parsableByteArray.q();
            if (q3 == 1635148611) {
                if (str == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                ExtractorUtil.a(z10, (String) null);
                parsableByteArray2.U(f5 + 8);
                AvcConfig b2 = AvcConfig.b(parsableByteArray);
                list2 = b2.f28832a;
                stsdData2.f24552c = b2.f28833b;
                if (!z11) {
                    f4 = b2.f28836e;
                }
                str5 = b2.f28837f;
                str3 = MimeTypes.VIDEO_H264;
            } else {
                if (q3 == 1752589123) {
                    if (str == null) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    ExtractorUtil.a(z9, (String) null);
                    parsableByteArray2.U(f5 + 8);
                    HevcConfig a2 = HevcConfig.a(parsableByteArray);
                    list2 = a2.f28866a;
                    stsdData2.f24552c = a2.f28867b;
                    if (!z11) {
                        f4 = a2.f28870e;
                    }
                    str5 = a2.f28874i;
                    int i21 = a2.f28871f;
                    int i22 = a2.f28872g;
                    i20 = a2.f28873h;
                    drmInitData2 = drmInitData3;
                    i8 = N2;
                    i18 = i21;
                    i9 = i16;
                    i19 = i22;
                    str = MimeTypes.VIDEO_H265;
                } else {
                    if (q3 == 1685480259 || q3 == 1685485123) {
                        drmInitData2 = drmInitData3;
                        i8 = N2;
                        i9 = i16;
                        f2 = f4;
                        list = list2;
                        i10 = i18;
                        i12 = i19;
                        i11 = i20;
                        DolbyVisionConfig a3 = DolbyVisionConfig.a(parsableByteArray);
                        if (a3 != null) {
                            str5 = a3.f28851c;
                            str = "video/dolby-vision";
                        }
                    } else if (q3 == 1987076931) {
                        if (str == null) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        ExtractorUtil.a(z7, (String) null);
                        if (i16 == 1987063864) {
                            str3 = "video/x-vnd.on2.vp8";
                        } else {
                            str3 = "video/x-vnd.on2.vp9";
                        }
                        parsableByteArray2.U(f5 + 12);
                        parsableByteArray2.V(2);
                        if ((parsableByteArray.H() & 1) != 0) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        int H = parsableByteArray.H();
                        int H2 = parsableByteArray.H();
                        i18 = ColorInfo.b(H);
                        if (z8) {
                            i19 = 1;
                        } else {
                            i19 = 2;
                        }
                        i20 = ColorInfo.c(H2);
                    } else if (q3 == 1635135811) {
                        if (str == null) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        ExtractorUtil.a(z6, (String) null);
                        str3 = "video/av01";
                    } else if (q3 == 1668050025) {
                        if (byteBuffer3 == null) {
                            byteBuffer2 = a();
                        } else {
                            byteBuffer2 = byteBuffer3;
                        }
                        byteBuffer2.position(21);
                        byteBuffer2.putShort(parsableByteArray.D());
                        byteBuffer2.putShort(parsableByteArray.D());
                        byteBuffer3 = byteBuffer2;
                        drmInitData2 = drmInitData3;
                        i8 = N2;
                        i9 = i16;
                    } else if (q3 == 1835295606) {
                        if (byteBuffer3 == null) {
                            byteBuffer = a();
                        } else {
                            byteBuffer = byteBuffer3;
                        }
                        short D = parsableByteArray.D();
                        short D2 = parsableByteArray.D();
                        short D3 = parsableByteArray.D();
                        i9 = i16;
                        short D4 = parsableByteArray.D();
                        short D5 = parsableByteArray.D();
                        drmInitData2 = drmInitData3;
                        short D6 = parsableByteArray.D();
                        List<byte[]> list3 = list2;
                        short D7 = parsableByteArray.D();
                        float f6 = f4;
                        short D8 = parsableByteArray.D();
                        long J = parsableByteArray.J();
                        long J2 = parsableByteArray.J();
                        i8 = N2;
                        byteBuffer.position(1);
                        byteBuffer.putShort(D5);
                        byteBuffer.putShort(D6);
                        byteBuffer.putShort(D);
                        byteBuffer.putShort(D2);
                        byteBuffer.putShort(D3);
                        byteBuffer.putShort(D4);
                        byteBuffer.putShort(D7);
                        byteBuffer.putShort(D8);
                        byteBuffer.putShort((short) ((int) (J / NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS)));
                        byteBuffer.putShort((short) ((int) (J2 / NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS)));
                        byteBuffer3 = byteBuffer;
                        list2 = list3;
                        f4 = f6;
                    } else {
                        drmInitData2 = drmInitData3;
                        i8 = N2;
                        i9 = i16;
                        f2 = f4;
                        list = list2;
                        if (q3 == 1681012275) {
                            if (str == null) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            ExtractorUtil.a(z5, (String) null);
                            str = str2;
                        } else if (q3 == 1702061171) {
                            if (str == null) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            ExtractorUtil.a(z4, (String) null);
                            esdsData = i(parsableByteArray2, f5);
                            String a4 = esdsData.f24546a;
                            byte[] b3 = esdsData.f24547b;
                            if (b3 != null) {
                                list2 = ImmutableList.s(b3);
                            } else {
                                list2 = list;
                            }
                            str = a4;
                            f4 = f2;
                            f3 += q2;
                            i14 = i3;
                            i15 = i4;
                            stsdData2 = stsdData;
                            str4 = str2;
                            i16 = i9;
                            drmInitData3 = drmInitData2;
                            N2 = i8;
                        } else if (q3 == 1885434736) {
                            f4 = q(parsableByteArray2, f5);
                            list2 = list;
                            z11 = true;
                            f3 += q2;
                            i14 = i3;
                            i15 = i4;
                            stsdData2 = stsdData;
                            str4 = str2;
                            i16 = i9;
                            drmInitData3 = drmInitData2;
                            N2 = i8;
                        } else if (q3 == 1937126244) {
                            bArr2 = r(parsableByteArray2, f5, q2);
                        } else if (q3 == 1936995172) {
                            int H3 = parsableByteArray.H();
                            parsableByteArray2.V(3);
                            if (H3 == 0) {
                                int H4 = parsableByteArray.H();
                                if (H4 == 0) {
                                    i17 = 0;
                                } else if (H4 == 1) {
                                    i17 = 1;
                                } else if (H4 == 2) {
                                    i17 = 2;
                                } else if (H4 == 3) {
                                    i17 = 3;
                                }
                            }
                        } else {
                            i10 = i18;
                            if (q3 == 1668246642) {
                                i12 = i19;
                                if (i10 == -1) {
                                    i11 = i20;
                                    if (i12 == -1 && i11 == -1) {
                                        int q4 = parsableByteArray.q();
                                        if (q4 == 1852009592 || q4 == 1852009571) {
                                            int N3 = parsableByteArray.N();
                                            int N4 = parsableByteArray.N();
                                            parsableByteArray2.V(2);
                                            if (q2 != 19 || (parsableByteArray.H() & 128) == 0) {
                                                z3 = false;
                                            } else {
                                                z3 = true;
                                            }
                                            i18 = ColorInfo.b(N3);
                                            if (z3) {
                                                i13 = 1;
                                            } else {
                                                i13 = 2;
                                            }
                                            i20 = ColorInfo.c(N4);
                                        } else {
                                            Log.i("AtomParsers", "Unsupported color type: " + Atom.a(q4));
                                        }
                                    }
                                }
                            } else {
                                i12 = i19;
                            }
                            i11 = i20;
                        }
                        list2 = list;
                        f4 = f2;
                        f3 += q2;
                        i14 = i3;
                        i15 = i4;
                        stsdData2 = stsdData;
                        str4 = str2;
                        i16 = i9;
                        drmInitData3 = drmInitData2;
                        N2 = i8;
                    }
                    i19 = i12;
                    i20 = i11;
                    i18 = i10;
                    list2 = list;
                    f4 = f2;
                    f3 += q2;
                    i14 = i3;
                    i15 = i4;
                    stsdData2 = stsdData;
                    str4 = str2;
                    i16 = i9;
                    drmInitData3 = drmInitData2;
                    N2 = i8;
                }
                f3 += q2;
                i14 = i3;
                i15 = i4;
                stsdData2 = stsdData;
                str4 = str2;
                i16 = i9;
                drmInitData3 = drmInitData2;
                N2 = i8;
            }
            str = str3;
            drmInitData2 = drmInitData3;
            i8 = N2;
            i9 = i16;
            f3 += q2;
            i14 = i3;
            i15 = i4;
            stsdData2 = stsdData;
            str4 = str2;
            i16 = i9;
            drmInitData3 = drmInitData2;
            N2 = i8;
        }
        DrmInitData drmInitData4 = drmInitData3;
        int i23 = N2;
        float f7 = f4;
        List<byte[]> list4 = list2;
        int i24 = i18;
        int i25 = i19;
        int i26 = i20;
        if (str != null) {
            Format.Builder O = new Format.Builder().T(i5).g0(str).K(str5).n0(N).S(i23).c0(f7).f0(i6).d0(bArr2).j0(i17).V(list4).O(drmInitData4);
            if (!(i24 == -1 && i25 == -1 && i26 == -1 && byteBuffer3 == null)) {
                if (byteBuffer3 != null) {
                    bArr = byteBuffer3.array();
                } else {
                    bArr = null;
                }
                O.L(new ColorInfo(i24, i25, i26, bArr));
            }
            if (esdsData != null) {
                O.I(Ints.m(esdsData.f24548c)).b0(Ints.m(esdsData.f24549d));
            }
            stsdData.f24551b = O.G();
        }
    }

    private static ByteBuffer a() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static boolean b(long[] jArr, long j2, long j3, long j4) {
        int length = jArr.length - 1;
        int q2 = Util.q(4, 0, length);
        int q3 = Util.q(jArr.length - 4, 0, length);
        if (jArr[0] > j3 || j3 >= jArr[q2] || jArr[q3] >= j4 || j4 > j2) {
            return false;
        }
        return true;
    }

    private static int c(ParsableByteArray parsableByteArray, int i2, int i3, int i4) throws ParserException {
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

    private static int d(int i2) {
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

    public static void e(ParsableByteArray parsableByteArray) {
        int f2 = parsableByteArray.f();
        parsableByteArray.V(4);
        if (parsableByteArray.q() != 1751411826) {
            f2 += 4;
        }
        parsableByteArray.U(f2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:155:0x031d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:167:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0168  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void f(com.google.android.exoplayer2.util.ParsableByteArray r22, int r23, int r24, int r25, int r26, java.lang.String r27, boolean r28, com.google.android.exoplayer2.drm.DrmInitData r29, com.google.android.exoplayer2.extractor.mp4.AtomParsers.StsdData r30, int r31) throws com.google.android.exoplayer2.ParserException {
        /*
            r0 = r22
            r1 = r24
            r2 = r25
            r3 = r26
            r4 = r27
            r5 = r29
            r6 = r30
            int r7 = r1 + 8
            r8 = 8
            int r7 = r7 + r8
            r0.U(r7)
            r7 = 6
            if (r28 == 0) goto L_0x0021
            int r8 = r22.N()
            r0.V(r7)
            goto L_0x0025
        L_0x0021:
            r0.V(r8)
            r8 = 0
        L_0x0025:
            r10 = 16
            r11 = 4
            r12 = 2
            r13 = 1
            if (r8 == 0) goto L_0x0049
            if (r8 != r13) goto L_0x002f
            goto L_0x0049
        L_0x002f:
            if (r8 != r12) goto L_0x0048
            r0.V(r10)
            double r7 = r22.o()
            long r7 = java.lang.Math.round(r7)
            int r8 = (int) r7
            int r7 = r22.L()
            r10 = 20
            r0.V(r10)
            r15 = 0
            goto L_0x0067
        L_0x0048:
            return
        L_0x0049:
            int r14 = r22.N()
            r0.V(r7)
            int r7 = r22.I()
            int r15 = r22.f()
            int r15 = r15 - r11
            r0.U(r15)
            int r15 = r22.q()
            if (r8 != r13) goto L_0x0065
            r0.V(r10)
        L_0x0065:
            r8 = r7
            r7 = r14
        L_0x0067:
            int r10 = r22.f()
            r14 = 1701733217(0x656e6361, float:7.0359778E22)
            r12 = r23
            if (r12 != r14) goto L_0x0099
            android.util.Pair r14 = s(r0, r1, r2)
            if (r14 == 0) goto L_0x0096
            java.lang.Object r12 = r14.first
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            if (r5 != 0) goto L_0x0084
            r5 = 0
            goto L_0x008e
        L_0x0084:
            java.lang.Object r13 = r14.second
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox r13 = (com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox) r13
            java.lang.String r13 = r13.f24671b
            com.google.android.exoplayer2.drm.DrmInitData r5 = r5.d(r13)
        L_0x008e:
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox[] r13 = r6.f24550a
            java.lang.Object r14 = r14.second
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox r14 = (com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox) r14
            r13[r31] = r14
        L_0x0096:
            r0.U(r10)
        L_0x0099:
            r13 = 1633889587(0x61632d33, float:2.6191674E20)
            r14 = 1634492771(0x616c6163, float:2.7252807E20)
            if (r12 != r13) goto L_0x00a8
            java.lang.String r12 = "audio/ac3"
        L_0x00a3:
            r19 = r12
            r12 = -1
            goto L_0x015c
        L_0x00a8:
            r13 = 1700998451(0x65632d33, float:6.7050686E22)
            if (r12 != r13) goto L_0x00b0
            java.lang.String r12 = "audio/eac3"
            goto L_0x00a3
        L_0x00b0:
            r13 = 1633889588(0x61632d34, float:2.6191676E20)
            if (r12 != r13) goto L_0x00b8
            java.lang.String r12 = "audio/ac4"
            goto L_0x00a3
        L_0x00b8:
            r13 = 1685353315(0x64747363, float:1.803728E22)
            if (r12 != r13) goto L_0x00c0
            java.lang.String r12 = "audio/vnd.dts"
            goto L_0x00a3
        L_0x00c0:
            r13 = 1685353320(0x64747368, float:1.8037286E22)
            if (r12 == r13) goto L_0x0158
            r13 = 1685353324(0x6474736c, float:1.803729E22)
            if (r12 != r13) goto L_0x00cc
            goto L_0x0158
        L_0x00cc:
            r13 = 1685353317(0x64747365, float:1.8037282E22)
            if (r12 != r13) goto L_0x00d4
            java.lang.String r12 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x00a3
        L_0x00d4:
            r13 = 1685353336(0x64747378, float:1.8037304E22)
            if (r12 != r13) goto L_0x00dc
            java.lang.String r12 = "audio/vnd.dts.uhd;profile=p2"
            goto L_0x00a3
        L_0x00dc:
            r13 = 1935764850(0x73616d72, float:1.7860208E31)
            if (r12 != r13) goto L_0x00e4
            java.lang.String r12 = "audio/3gpp"
            goto L_0x00a3
        L_0x00e4:
            r13 = 1935767394(0x73617762, float:1.7863284E31)
            if (r12 != r13) goto L_0x00ec
            java.lang.String r12 = "audio/amr-wb"
            goto L_0x00a3
        L_0x00ec:
            r13 = 1819304813(0x6c70636d, float:1.1624469E27)
            java.lang.String r19 = "audio/raw"
            if (r12 == r13) goto L_0x0156
            r13 = 1936684916(0x736f7774, float:1.89725E31)
            if (r12 != r13) goto L_0x00f9
            goto L_0x0156
        L_0x00f9:
            r13 = 1953984371(0x74776f73, float:7.841539E31)
            if (r12 != r13) goto L_0x0101
            r12 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x015c
        L_0x0101:
            r13 = 778924082(0x2e6d7032, float:5.398721E-11)
            if (r12 == r13) goto L_0x0152
            r13 = 778924083(0x2e6d7033, float:5.3987214E-11)
            if (r12 != r13) goto L_0x010c
            goto L_0x0152
        L_0x010c:
            r13 = 1835557169(0x6d686131, float:4.4948762E27)
            if (r12 != r13) goto L_0x0114
            java.lang.String r12 = "audio/mha1"
            goto L_0x00a3
        L_0x0114:
            r13 = 1835560241(0x6d686d31, float:4.495783E27)
            if (r12 != r13) goto L_0x011c
            java.lang.String r12 = "audio/mhm1"
            goto L_0x00a3
        L_0x011c:
            if (r12 != r14) goto L_0x0121
            java.lang.String r12 = "audio/alac"
            goto L_0x00a3
        L_0x0121:
            r13 = 1634492791(0x616c6177, float:2.7252842E20)
            if (r12 != r13) goto L_0x012a
            java.lang.String r12 = "audio/g711-alaw"
            goto L_0x00a3
        L_0x012a:
            r13 = 1970037111(0x756c6177, float:2.9964816E32)
            if (r12 != r13) goto L_0x0133
            java.lang.String r12 = "audio/g711-mlaw"
            goto L_0x00a3
        L_0x0133:
            r13 = 1332770163(0x4f707573, float:4.03422899E9)
            if (r12 != r13) goto L_0x013c
            java.lang.String r12 = "audio/opus"
            goto L_0x00a3
        L_0x013c:
            r13 = 1716281667(0x664c6143, float:2.4128923E23)
            if (r12 != r13) goto L_0x0145
            java.lang.String r12 = "audio/flac"
            goto L_0x00a3
        L_0x0145:
            r13 = 1835823201(0x6d6c7061, float:4.573395E27)
            if (r12 != r13) goto L_0x014e
            java.lang.String r12 = "audio/true-hd"
            goto L_0x00a3
        L_0x014e:
            r12 = -1
            r19 = 0
            goto L_0x015c
        L_0x0152:
            java.lang.String r12 = "audio/mpeg"
            goto L_0x00a3
        L_0x0156:
            r12 = 2
            goto L_0x015c
        L_0x0158:
            java.lang.String r12 = "audio/vnd.dts.hd"
            goto L_0x00a3
        L_0x015c:
            r13 = r19
            r19 = 0
            r20 = 0
            r21 = 0
        L_0x0164:
            int r11 = r10 - r1
            if (r11 >= r2) goto L_0x0319
            r0.U(r10)
            int r11 = r22.q()
            if (r11 <= 0) goto L_0x0173
            r14 = 1
            goto L_0x0174
        L_0x0173:
            r14 = 0
        L_0x0174:
            java.lang.String r9 = "childAtomSize must be positive"
            com.google.android.exoplayer2.extractor.ExtractorUtil.a(r14, r9)
            int r9 = r22.q()
            r14 = 1835557187(0x6d686143, float:4.4948815E27)
            if (r9 != r14) goto L_0x019d
            int r9 = r11 + -13
            byte[] r14 = new byte[r9]
            int r1 = r10 + 13
            r0.U(r1)
            r1 = 0
            r0.l(r14, r1, r9)
            com.google.common.collect.ImmutableList r21 = com.google.common.collect.ImmutableList.s(r14)
        L_0x0193:
            r9 = -1
            r14 = 1
            r16 = 4
            r17 = 2
        L_0x0199:
            r18 = 0
            goto L_0x030f
        L_0x019d:
            r1 = 1702061171(0x65736473, float:7.183675E22)
            if (r9 == r1) goto L_0x02d4
            if (r28 == 0) goto L_0x01ab
            r14 = 2002876005(0x77617665, float:4.5729223E33)
            if (r9 != r14) goto L_0x01ab
            goto L_0x02d4
        L_0x01ab:
            r1 = 1684103987(0x64616333, float:1.6630662E22)
            if (r9 != r1) goto L_0x01ca
            int r1 = r10 + 8
            r0.U(r1)
            java.lang.String r1 = java.lang.Integer.toString(r26)
            com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.audio.Ac3Util.d(r0, r1, r4, r5)
            r6.f24551b = r1
        L_0x01bf:
            r2 = 1634492771(0x616c6163, float:2.7252807E20)
            r9 = 0
            r14 = 1
            r16 = 4
            r17 = 2
            goto L_0x02d1
        L_0x01ca:
            r1 = 1684366131(0x64656333, float:1.692581E22)
            if (r9 != r1) goto L_0x01df
            int r1 = r10 + 8
            r0.U(r1)
            java.lang.String r1 = java.lang.Integer.toString(r26)
            com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.audio.Ac3Util.h(r0, r1, r4, r5)
            r6.f24551b = r1
            goto L_0x01bf
        L_0x01df:
            r1 = 1684103988(0x64616334, float:1.6630663E22)
            if (r9 != r1) goto L_0x01f4
            int r1 = r10 + 8
            r0.U(r1)
            java.lang.String r1 = java.lang.Integer.toString(r26)
            com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.audio.Ac4Util.b(r0, r1, r4, r5)
            r6.f24551b = r1
            goto L_0x01bf
        L_0x01f4:
            r1 = 1684892784(0x646d6c70, float:1.7518768E22)
            if (r9 != r1) goto L_0x0215
            if (r15 <= 0) goto L_0x01fe
            r8 = r15
            r7 = 2
            goto L_0x0193
        L_0x01fe:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid sample rate for Dolby TrueHD MLP stream: "
            r0.append(r1)
            r0.append(r15)
            java.lang.String r0 = r0.toString()
            r14 = 0
            com.google.android.exoplayer2.ParserException r0 = com.google.android.exoplayer2.ParserException.a(r0, r14)
            throw r0
        L_0x0215:
            r14 = 0
            r1 = 1684305011(0x64647473, float:1.6856995E22)
            if (r9 == r1) goto L_0x02a5
            r1 = 1969517683(0x75647473, float:2.8960097E32)
            if (r9 != r1) goto L_0x0222
            goto L_0x02a5
        L_0x0222:
            r1 = 1682927731(0x644f7073, float:1.5306315E22)
            if (r9 != r1) goto L_0x0240
            int r1 = r11 + -8
            byte[] r9 = f24536a
            int r14 = r9.length
            int r14 = r14 + r1
            byte[] r14 = java.util.Arrays.copyOf(r9, r14)
            int r2 = r10 + 8
            r0.U(r2)
            int r2 = r9.length
            r0.l(r14, r2, r1)
            java.util.List r21 = com.google.android.exoplayer2.audio.OpusUtil.a(r14)
            goto L_0x0193
        L_0x0240:
            r1 = 1684425825(0x64664c61, float:1.6993019E22)
            if (r9 != r1) goto L_0x0272
            int r1 = r11 + -12
            int r2 = r1 + 4
            byte[] r2 = new byte[r2]
            r9 = 102(0x66, float:1.43E-43)
            r14 = 0
            r2[r14] = r9
            r9 = 76
            r14 = 1
            r2[r14] = r9
            r9 = 97
            r17 = 2
            r2[r17] = r9
            r9 = 3
            r18 = 67
            r2[r9] = r18
            int r9 = r10 + 12
            r0.U(r9)
            r9 = 4
            r0.l(r2, r9, r1)
            com.google.common.collect.ImmutableList r21 = com.google.common.collect.ImmutableList.s(r2)
            r9 = -1
            r16 = 4
            goto L_0x0199
        L_0x0272:
            r2 = 1634492771(0x616c6163, float:2.7252807E20)
            r14 = 1
            r16 = 4
            r17 = 2
            if (r9 != r2) goto L_0x02a3
            int r1 = r11 + -12
            byte[] r7 = new byte[r1]
            int r8 = r10 + 12
            r0.U(r8)
            r9 = 0
            r0.l(r7, r9, r1)
            android.util.Pair r1 = com.google.android.exoplayer2.util.CodecSpecificDataUtil.h(r7)
            java.lang.Object r8 = r1.first
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            com.google.common.collect.ImmutableList r21 = com.google.common.collect.ImmutableList.s(r7)
            r7 = r1
            goto L_0x02d1
        L_0x02a3:
            r9 = 0
            goto L_0x02d1
        L_0x02a5:
            r2 = 1634492771(0x616c6163, float:2.7252807E20)
            r9 = 0
            r14 = 1
            r16 = 4
            r17 = 2
            com.google.android.exoplayer2.Format$Builder r1 = new com.google.android.exoplayer2.Format$Builder
            r1.<init>()
            com.google.android.exoplayer2.Format$Builder r1 = r1.T(r3)
            com.google.android.exoplayer2.Format$Builder r1 = r1.g0(r13)
            com.google.android.exoplayer2.Format$Builder r1 = r1.J(r7)
            com.google.android.exoplayer2.Format$Builder r1 = r1.h0(r8)
            com.google.android.exoplayer2.Format$Builder r1 = r1.O(r5)
            com.google.android.exoplayer2.Format$Builder r1 = r1.X(r4)
            com.google.android.exoplayer2.Format r1 = r1.G()
            r6.f24551b = r1
        L_0x02d1:
            r9 = -1
            goto L_0x0199
        L_0x02d4:
            r2 = 1634492771(0x616c6163, float:2.7252807E20)
            r14 = 1
            r16 = 4
            r17 = 2
            r18 = 0
            if (r9 != r1) goto L_0x02e2
            r1 = r10
            goto L_0x02e6
        L_0x02e2:
            int r1 = c(r0, r1, r10, r11)
        L_0x02e6:
            r9 = -1
            if (r1 == r9) goto L_0x030f
            com.google.android.exoplayer2.extractor.mp4.AtomParsers$EsdsData r19 = i(r0, r1)
            java.lang.String r13 = r19.f24546a
            byte[] r1 = r19.f24547b
            if (r1 == 0) goto L_0x030f
            java.lang.String r2 = "audio/mp4a-latm"
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x030b
            com.google.android.exoplayer2.audio.AacUtil$Config r2 = com.google.android.exoplayer2.audio.AacUtil.f(r1)
            int r8 = r2.f23633a
            int r7 = r2.f23634b
            java.lang.String r2 = r2.f23635c
            r20 = r2
        L_0x030b:
            com.google.common.collect.ImmutableList r21 = com.google.common.collect.ImmutableList.s(r1)
        L_0x030f:
            int r10 = r10 + r11
            r1 = r24
            r2 = r25
            r14 = 1634492771(0x616c6163, float:2.7252807E20)
            goto L_0x0164
        L_0x0319:
            com.google.android.exoplayer2.Format r0 = r6.f24551b
            if (r0 != 0) goto L_0x036b
            if (r13 == 0) goto L_0x036b
            com.google.android.exoplayer2.Format$Builder r0 = new com.google.android.exoplayer2.Format$Builder
            r0.<init>()
            com.google.android.exoplayer2.Format$Builder r0 = r0.T(r3)
            com.google.android.exoplayer2.Format$Builder r0 = r0.g0(r13)
            r1 = r20
            com.google.android.exoplayer2.Format$Builder r0 = r0.K(r1)
            com.google.android.exoplayer2.Format$Builder r0 = r0.J(r7)
            com.google.android.exoplayer2.Format$Builder r0 = r0.h0(r8)
            com.google.android.exoplayer2.Format$Builder r0 = r0.a0(r12)
            r1 = r21
            com.google.android.exoplayer2.Format$Builder r0 = r0.V(r1)
            com.google.android.exoplayer2.Format$Builder r0 = r0.O(r5)
            com.google.android.exoplayer2.Format$Builder r0 = r0.X(r4)
            if (r19 == 0) goto L_0x0365
            long r1 = r19.f24548c
            int r1 = com.google.common.primitives.Ints.m(r1)
            com.google.android.exoplayer2.Format$Builder r1 = r0.I(r1)
            long r2 = r19.f24549d
            int r2 = com.google.common.primitives.Ints.m(r2)
            r1.b0(r2)
        L_0x0365:
            com.google.android.exoplayer2.Format r0 = r0.G()
            r6.f24551b = r0
        L_0x036b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.AtomParsers.f(com.google.android.exoplayer2.util.ParsableByteArray, int, int, int, int, java.lang.String, boolean, com.google.android.exoplayer2.drm.DrmInitData, com.google.android.exoplayer2.extractor.mp4.AtomParsers$StsdData, int):void");
    }

    static Pair<Integer, TrackEncryptionBox> g(ParsableByteArray parsableByteArray, int i2, int i3) throws ParserException {
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
        TrackEncryptionBox t2 = t(parsableByteArray, i5, i6, str);
        if (t2 != null) {
            z4 = true;
        }
        ExtractorUtil.a(z4, "tenc atom is mandatory");
        return Pair.create(num, (TrackEncryptionBox) Util.j(t2));
    }

    private static Pair<long[], long[]> h(Atom.ContainerAtom containerAtom) {
        long j2;
        long j3;
        Atom.LeafAtom g2 = containerAtom.g(1701606260);
        if (g2 == null) {
            return null;
        }
        ParsableByteArray parsableByteArray = g2.f24535b;
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

    private static EsdsData i(ParsableByteArray parsableByteArray, int i2) {
        long j2;
        parsableByteArray.U(i2 + 8 + 4);
        parsableByteArray.V(1);
        j(parsableByteArray);
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
        j(parsableByteArray);
        String h2 = com.google.android.exoplayer2.util.MimeTypes.h(parsableByteArray.H());
        if ("audio/mpeg".equals(h2) || "audio/vnd.dts".equals(h2) || "audio/vnd.dts.hd".equals(h2)) {
            return new EsdsData(h2, (byte[]) null, -1, -1);
        }
        parsableByteArray.V(4);
        long J = parsableByteArray.J();
        long J2 = parsableByteArray.J();
        parsableByteArray.V(1);
        int j3 = j(parsableByteArray);
        byte[] bArr = new byte[j3];
        parsableByteArray.l(bArr, 0, j3);
        long j4 = -1;
        if (J2 > 0) {
            j2 = J2;
        } else {
            j2 = -1;
        }
        if (J > 0) {
            j4 = J;
        }
        return new EsdsData(h2, bArr, j2, j4);
    }

    private static int j(ParsableByteArray parsableByteArray) {
        int H = parsableByteArray.H();
        int i2 = H & 127;
        while ((H & 128) == 128) {
            H = parsableByteArray.H();
            i2 = (i2 << 7) | (H & 127);
        }
        return i2;
    }

    private static int k(ParsableByteArray parsableByteArray) {
        parsableByteArray.U(16);
        return parsableByteArray.q();
    }

    private static Metadata l(ParsableByteArray parsableByteArray, int i2) {
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

    private static Pair<Long, String> m(ParsableByteArray parsableByteArray) {
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

    public static Metadata n(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom g2 = containerAtom.g(1751411826);
        Atom.LeafAtom g3 = containerAtom.g(1801812339);
        Atom.LeafAtom g4 = containerAtom.g(1768715124);
        if (g2 == null || g3 == null || g4 == null || k(g2.f24535b) != 1835299937) {
            return null;
        }
        ParsableByteArray parsableByteArray = g3.f24535b;
        parsableByteArray.U(12);
        int q2 = parsableByteArray.q();
        String[] strArr = new String[q2];
        for (int i2 = 0; i2 < q2; i2++) {
            int q3 = parsableByteArray.q();
            parsableByteArray.V(4);
            strArr[i2] = parsableByteArray.E(q3 - 8);
        }
        ParsableByteArray parsableByteArray2 = g4.f24535b;
        parsableByteArray2.U(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray2.a() > 8) {
            int f2 = parsableByteArray2.f();
            int q4 = parsableByteArray2.q();
            int q5 = parsableByteArray2.q() - 1;
            if (q5 < 0 || q5 >= q2) {
                Log.i("AtomParsers", "Skipped metadata with unknown key index: " + q5);
            } else {
                MdtaMetadataEntry f3 = MetadataUtil.f(parsableByteArray2, f2 + q4, strArr[q5]);
                if (f3 != null) {
                    arrayList.add(f3);
                }
            }
            parsableByteArray2.U(f2 + q4);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    private static void o(ParsableByteArray parsableByteArray, int i2, int i3, int i4, StsdData stsdData) {
        parsableByteArray.U(i3 + 8 + 8);
        if (i2 == 1835365492) {
            parsableByteArray.B();
            String B = parsableByteArray.B();
            if (B != null) {
                stsdData.f24551b = new Format.Builder().T(i4).g0(B).G();
            }
        }
    }

    private static long p(ParsableByteArray parsableByteArray) {
        int i2 = 8;
        parsableByteArray.U(8);
        if (Atom.c(parsableByteArray.q()) != 0) {
            i2 = 16;
        }
        parsableByteArray.V(i2);
        return parsableByteArray.J();
    }

    private static float q(ParsableByteArray parsableByteArray, int i2) {
        parsableByteArray.U(i2 + 8);
        return ((float) parsableByteArray.L()) / ((float) parsableByteArray.L());
    }

    private static byte[] r(ParsableByteArray parsableByteArray, int i2, int i3) {
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

    private static Pair<Integer, TrackEncryptionBox> s(ParsableByteArray parsableByteArray, int i2, int i3) throws ParserException {
        boolean z2;
        Pair<Integer, TrackEncryptionBox> g2;
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
            if (parsableByteArray.q() == 1936289382 && (g2 = g(parsableByteArray, f2, q2)) != null) {
                return g2;
            }
            f2 += q2;
        }
        return null;
    }

    private static TrackEncryptionBox t(ParsableByteArray parsableByteArray, int i2, int i3, String str) {
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

    private static Metadata u(ParsableByteArray parsableByteArray, int i2) {
        float f2;
        parsableByteArray.V(12);
        while (parsableByteArray.f() < i2) {
            int f3 = parsableByteArray.f();
            int q2 = parsableByteArray.q();
            if (parsableByteArray.q() != 1935766900) {
                parsableByteArray.U(f3 + q2);
            } else if (q2 < 14) {
                return null;
            } else {
                parsableByteArray.V(5);
                int H = parsableByteArray.H();
                if (H != 12 && H != 13) {
                    return null;
                }
                if (H == 12) {
                    f2 = 240.0f;
                } else {
                    f2 = 120.0f;
                }
                parsableByteArray.V(1);
                return new Metadata(new SmtaMetadataEntry(f2, parsableByteArray.H()));
            }
        }
        return null;
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
    private static com.google.android.exoplayer2.extractor.mp4.TrackSampleTable v(com.google.android.exoplayer2.extractor.mp4.Track r38, com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom r39, com.google.android.exoplayer2.extractor.GaplessInfoHolder r40) throws com.google.android.exoplayer2.ParserException {
        /*
            r1 = r38
            r0 = r39
            r2 = r40
            r3 = 1937011578(0x7374737a, float:1.936741E31)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r3 = r0.g(r3)
            if (r3 == 0) goto L_0x0017
            com.google.android.exoplayer2.extractor.mp4.AtomParsers$StszSampleSizeBox r5 = new com.google.android.exoplayer2.extractor.mp4.AtomParsers$StszSampleSizeBox
            com.google.android.exoplayer2.Format r6 = r1.f24664f
            r5.<init>(r3, r6)
            goto L_0x0025
        L_0x0017:
            r3 = 1937013298(0x73747a32, float:1.9369489E31)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r3 = r0.g(r3)
            if (r3 == 0) goto L_0x0512
            com.google.android.exoplayer2.extractor.mp4.AtomParsers$Stz2SampleSizeBox r5 = new com.google.android.exoplayer2.extractor.mp4.AtomParsers$Stz2SampleSizeBox
            r5.<init>(r3)
        L_0x0025:
            int r3 = r5.c()
            r6 = 0
            if (r3 != 0) goto L_0x0040
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r9 = new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable
            long[] r2 = new long[r6]
            int[] r3 = new int[r6]
            r4 = 0
            long[] r5 = new long[r6]
            int[] r6 = new int[r6]
            r7 = 0
            r0 = r9
            r1 = r38
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x0040:
            r7 = 1937007471(0x7374636f, float:1.9362445E31)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r7 = r0.g(r7)
            r8 = 1
            if (r7 != 0) goto L_0x0059
            r7 = 1668232756(0x636f3634, float:4.4126776E21)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r7 = r0.g(r7)
            java.lang.Object r7 = com.google.android.exoplayer2.util.Assertions.e(r7)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r7 = (com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom) r7
            r9 = 1
            goto L_0x005a
        L_0x0059:
            r9 = 0
        L_0x005a:
            com.google.android.exoplayer2.util.ParsableByteArray r7 = r7.f24535b
            r10 = 1937011555(0x73747363, float:1.9367382E31)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r10 = r0.g(r10)
            java.lang.Object r10 = com.google.android.exoplayer2.util.Assertions.e(r10)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r10 = (com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom) r10
            com.google.android.exoplayer2.util.ParsableByteArray r10 = r10.f24535b
            r11 = 1937011827(0x73747473, float:1.9367711E31)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r11 = r0.g(r11)
            java.lang.Object r11 = com.google.android.exoplayer2.util.Assertions.e(r11)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r11 = (com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom) r11
            com.google.android.exoplayer2.util.ParsableByteArray r11 = r11.f24535b
            r12 = 1937011571(0x73747373, float:1.9367401E31)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r12 = r0.g(r12)
            if (r12 == 0) goto L_0x0086
            com.google.android.exoplayer2.util.ParsableByteArray r12 = r12.f24535b
            goto L_0x0087
        L_0x0086:
            r12 = 0
        L_0x0087:
            r13 = 1668576371(0x63747473, float:4.5093966E21)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r0 = r0.g(r13)
            if (r0 == 0) goto L_0x0093
            com.google.android.exoplayer2.util.ParsableByteArray r0 = r0.f24535b
            goto L_0x0094
        L_0x0093:
            r0 = 0
        L_0x0094:
            com.google.android.exoplayer2.extractor.mp4.AtomParsers$ChunkIterator r13 = new com.google.android.exoplayer2.extractor.mp4.AtomParsers$ChunkIterator
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
            com.google.android.exoplayer2.Format r8 = r1.f24664f
            java.lang.String r8 = r8.f23071m
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
            r39 = r7
            r4 = 1
            goto L_0x00fd
        L_0x00fa:
            r39 = r7
            r4 = 0
        L_0x00fd:
            if (r4 == 0) goto L_0x0131
            int r0 = r13.f24537a
            long[] r4 = new long[r0]
            int[] r0 = new int[r0]
        L_0x0105:
            boolean r5 = r13.a()
            if (r5 == 0) goto L_0x0116
            int r5 = r13.f24538b
            long r9 = r13.f24540d
            r4[r5] = r9
            int r9 = r13.f24539c
            r0[r5] = r9
            goto L_0x0105
        L_0x0116:
            long r9 = (long) r14
            com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker$Results r0 = com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker.a(r6, r4, r0, r9)
            long[] r4 = r0.f24569a
            int[] r5 = r0.f24570b
            int r6 = r0.f24571c
            long[] r9 = r0.f24572d
            int[] r10 = r0.f24573e
            long r11 = r0.f24574f
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
            r37 = r9
            r9 = r39
        L_0x0151:
            r39 = r37
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
            long r14 = r13.f24540d
            r32 = r3
            int r3 = r13.f24539c
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
            com.google.android.exoplayer2.util.Log.i(r10, r2)
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
            java.lang.Object r2 = com.google.android.exoplayer2.util.Assertions.e(r12)
            com.google.android.exoplayer2.util.ParsableByteArray r2 = (com.google.android.exoplayer2.util.ParsableByteArray) r2
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
            if (r39 <= 0) goto L_0x01f6
            int r2 = r24.L()
            int r3 = r24.q()
            int r14 = r39 + -1
            goto L_0x01f9
        L_0x01f6:
            r3 = r14
            r14 = r39
        L_0x01f9:
            r39 = r2
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
            r37 = r14
            r14 = r39
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
            if (r39 != 0) goto L_0x0245
            r2 = r23
            if (r2 != 0) goto L_0x0247
            if (r0 != 0) goto L_0x0242
            goto L_0x0247
        L_0x0242:
            r14 = r38
            goto L_0x0295
        L_0x0245:
            r2 = r23
        L_0x0247:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r14 = "Inconsistent stbl box for track "
            r5.append(r14)
            r14 = r38
            int r15 = r14.f24659a
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
            r9 = r39
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
            com.google.android.exoplayer2.util.Log.i(r10, r0)
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
            long r9 = r14.f24661c
            r5 = r15
            long r7 = com.google.android.exoplayer2.util.Util.R0(r5, r7, r9)
            long[] r1 = r14.f24666h
            r10 = 1000000(0xf4240, double:4.940656E-318)
            if (r1 != 0) goto L_0x02bd
            long r0 = r14.f24661c
            com.google.android.exoplayer2.util.Util.T0(r12, r10, r0)
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r9 = new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable
            r0 = r9
            r1 = r38
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x02bd:
            int r1 = r1.length
            r5 = 1
            if (r1 != r5) goto L_0x035a
            int r1 = r14.f24660b
            if (r1 != r5) goto L_0x035a
            int r1 = r12.length
            r5 = 2
            if (r1 < r5) goto L_0x035a
            long[] r1 = r14.f24667i
            java.lang.Object r1 = com.google.android.exoplayer2.util.Assertions.e(r1)
            long[] r1 = (long[]) r1
            r5 = 0
            r21 = r1[r5]
            long[] r1 = r14.f24666h
            r23 = r1[r5]
            long r5 = r14.f24661c
            long r7 = r14.f24662d
            r25 = r5
            r27 = r7
            long r5 = com.google.android.exoplayer2.util.Util.R0(r23, r25, r27)
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
            com.google.android.exoplayer2.Format r5 = r14.f24664f
            int r5 = r5.A
            long r8 = (long) r5
            long r10 = r14.f24661c
            r28 = r8
            r30 = r10
            long r10 = com.google.android.exoplayer2.util.Util.R0(r26, r28, r30)
            com.google.android.exoplayer2.Format r5 = r14.f24664f
            int r5 = r5.A
            long r8 = (long) r5
            long r0 = r14.f24661c
            r39 = r4
            r4 = r10
            r10 = r0
            long r0 = com.google.android.exoplayer2.util.Util.R0(r6, r8, r10)
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
            r4 = r40
            r4.f24224a = r5
            int r1 = (int) r0
            r4.f24225b = r1
            long r0 = r14.f24661c
            r4 = 1000000(0xf4240, double:4.940656E-318)
            com.google.android.exoplayer2.util.Util.T0(r12, r4, r0)
            long[] r0 = r14.f24666h
            r1 = 0
            r4 = r0[r1]
            r6 = 1000000(0xf4240, double:4.940656E-318)
            long r8 = r14.f24662d
            long r7 = com.google.android.exoplayer2.util.Util.R0(r4, r6, r8)
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r9 = new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable
            r0 = r9
            r1 = r38
            r4 = r39
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x035a:
            r25 = r0
        L_0x035c:
            r39 = r4
        L_0x035e:
            long[] r0 = r14.f24666h
            int r1 = r0.length
            r4 = 1
            if (r1 != r4) goto L_0x03a9
            r1 = 0
            r4 = r0[r1]
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x03a9
            long[] r0 = r14.f24667i
            java.lang.Object r0 = com.google.android.exoplayer2.util.Assertions.e(r0)
            long[] r0 = (long[]) r0
            r4 = r0[r1]
            r6 = 0
        L_0x0378:
            int r0 = r12.length
            if (r6 >= r0) goto L_0x038f
            r0 = r12[r6]
            long r17 = r0 - r4
            r19 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r14.f24661c
            r21 = r0
            long r0 = com.google.android.exoplayer2.util.Util.R0(r17, r19, r21)
            r12[r6] = r0
            int r6 = r6 + 1
            goto L_0x0378
        L_0x038f:
            long r17 = r15 - r4
            r19 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r14.f24661c
            r21 = r0
            long r7 = com.google.android.exoplayer2.util.Util.R0(r17, r19, r21)
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r9 = new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable
            r0 = r9
            r1 = r38
            r4 = r39
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x03a9:
            int r1 = r14.f24660b
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
            long[] r4 = r14.f24667i
            java.lang.Object r4 = com.google.android.exoplayer2.util.Assertions.e(r4)
            long[] r4 = (long[]) r4
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x03c3:
            long[] r9 = r14.f24666h
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
            long r8 = r14.f24661c
            r40 = r6
            r21 = r7
            long r6 = r14.f24662d
            r28 = r8
            r30 = r6
            long r6 = com.google.android.exoplayer2.util.Util.R0(r26, r28, r30)
            r8 = 1
            int r9 = com.google.android.exoplayer2.util.Util.i(r12, r2, r8, r8)
            r1[r5] = r9
            long r2 = r2 + r6
            r6 = 0
            int r2 = com.google.android.exoplayer2.util.Util.e(r12, r2, r10, r6)
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
            r2 = r40 | r2
            goto L_0x041d
        L_0x0413:
            r40 = r6
            r21 = r7
            r9 = r8
            r6 = 0
            r8 = 1
            r2 = r40
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
            r40 = r6
            r3 = r25
            r6 = 0
            r8 = 1
            if (r7 == r3) goto L_0x042f
            goto L_0x0430
        L_0x042f:
            r8 = 0
        L_0x0430:
            r2 = r40 | r8
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
            r5 = r39
        L_0x0444:
            if (r2 == 0) goto L_0x0449
            int[] r8 = new int[r7]
            goto L_0x044a
        L_0x0449:
            r8 = r13
        L_0x044a:
            long[] r7 = new long[r7]
            r40 = r5
            r39 = r15
            r9 = 0
            r15 = 0
        L_0x0453:
            long[] r5 = r14.f24666h
            int r5 = r5.length
            if (r6 >= r5) goto L_0x04f2
            long[] r5 = r14.f24667i
            r16 = r5[r6]
            r5 = r1[r6]
            r18 = r1
            r1 = r0[r6]
            r27 = r0
            if (r2 == 0) goto L_0x0476
            int r0 = r1 - r5
            java.lang.System.arraycopy(r11, r5, r3, r15, r0)
            r28 = r11
            r11 = r39
            java.lang.System.arraycopy(r11, r5, r4, r15, r0)
            java.lang.System.arraycopy(r13, r5, r8, r15, r0)
            goto L_0x047a
        L_0x0476:
            r28 = r11
            r11 = r39
        L_0x047a:
            r0 = r40
        L_0x047c:
            if (r5 >= r1) goto L_0x04cc
            r23 = 1000000(0xf4240, double:4.940656E-318)
            r29 = r0
            r39 = r1
            long r0 = r14.f24662d
            r21 = r9
            r25 = r0
            long r0 = com.google.android.exoplayer2.util.Util.R0(r21, r23, r25)
            r21 = r12[r5]
            r23 = r12
            r24 = r13
            long r12 = r21 - r16
            r30 = r8
            r21 = r9
            r8 = 0
            long r31 = java.lang.Math.max(r8, r12)
            r33 = 1000000(0xf4240, double:4.940656E-318)
            long r12 = r14.f24661c
            r35 = r12
            long r12 = com.google.android.exoplayer2.util.Util.R0(r31, r33, r35)
            long r0 = r0 + r12
            r7[r15] = r0
            if (r2 == 0) goto L_0x04ba
            r0 = r4[r15]
            r1 = r29
            if (r0 <= r1) goto L_0x04bc
            r0 = r11[r5]
            goto L_0x04bd
        L_0x04ba:
            r1 = r29
        L_0x04bc:
            r0 = r1
        L_0x04bd:
            int r15 = r15 + 1
            int r5 = r5 + 1
            r1 = r39
            r9 = r21
            r12 = r23
            r13 = r24
            r8 = r30
            goto L_0x047c
        L_0x04cc:
            r1 = r0
            r30 = r8
            r21 = r9
            r23 = r12
            r24 = r13
            r8 = 0
            long[] r0 = r14.f24666h
            r12 = r0[r6]
            long r12 = r21 + r12
            int r6 = r6 + 1
            r40 = r1
            r39 = r11
            r9 = r12
            r1 = r18
            r12 = r23
            r13 = r24
            r0 = r27
            r11 = r28
            r8 = r30
            goto L_0x0453
        L_0x04f2:
            r30 = r8
            r21 = r9
            r23 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r14.f24662d
            r25 = r0
            long r8 = com.google.android.exoplayer2.util.Util.R0(r21, r23, r25)
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r10 = new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable
            r0 = r10
            r1 = r38
            r2 = r3
            r3 = r4
            r4 = r40
            r5 = r7
            r6 = r30
            r7 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r10
        L_0x0512:
            java.lang.String r0 = "Track has no sample table size information"
            r1 = 0
            com.google.android.exoplayer2.ParserException r0 = com.google.android.exoplayer2.ParserException.a(r0, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.AtomParsers.v(com.google.android.exoplayer2.extractor.mp4.Track, com.google.android.exoplayer2.extractor.mp4.Atom$ContainerAtom, com.google.android.exoplayer2.extractor.GaplessInfoHolder):com.google.android.exoplayer2.extractor.mp4.TrackSampleTable");
    }

    private static StsdData w(ParsableByteArray parsableByteArray, int i2, int i3, String str, DrmInitData drmInitData, boolean z2) throws ParserException {
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
                D(parsableByteArray, q4, i4, q3, i2, i3, drmInitData, stsdData, i6);
            } else if (q4 == 1836069985 || q4 == 1701733217 || q4 == 1633889587 || q4 == 1700998451 || q4 == 1633889588 || q4 == 1835823201 || q4 == 1685353315 || q4 == 1685353317 || q4 == 1685353320 || q4 == 1685353324 || q4 == 1685353336 || q4 == 1935764850 || q4 == 1935767394 || q4 == 1819304813 || q4 == 1936684916 || q4 == 1953984371 || q4 == 778924082 || q4 == 778924083 || q4 == 1835557169 || q4 == 1835560241 || q4 == 1634492771 || q4 == 1634492791 || q4 == 1970037111 || q4 == 1332770163 || q4 == 1716281667) {
                i4 = f2;
                f(parsableByteArray, q4, f2, q3, i2, str, z2, drmInitData, stsdData, i6);
            } else {
                if (q4 == 1414810956 || q4 == 1954034535 || q4 == 2004251764 || q4 == 1937010800 || q4 == 1664495672) {
                    x(parsableByteArray, q4, f2, q3, i2, str, stsdData);
                } else if (q4 == 1835365492) {
                    o(parsableByteArray2, q4, f2, i5, stsdData);
                } else if (q4 == 1667329389) {
                    stsdData.f24551b = new Format.Builder().T(i5).g0("application/x-camera-motion").G();
                }
                i4 = f2;
            }
            parsableByteArray2.U(i4 + q3);
        }
        return stsdData;
    }

    private static void x(ParsableByteArray parsableByteArray, int i2, int i3, int i4, int i5, String str, StsdData stsdData) {
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
                stsdData.f24553d = 1;
                str2 = "application/x-mp4-cea-608";
            } else {
                throw new IllegalStateException();
            }
        }
        stsdData.f24551b = new Format.Builder().T(i5).g0(str2).X(str).k0(j2).V(immutableList).G();
    }

    private static TkhdData y(ParsableByteArray parsableByteArray) {
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

    private static Track z(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j2, DrmInitData drmInitData, boolean z2, boolean z3) throws ParserException {
        long j3;
        Atom.LeafAtom leafAtom2;
        long[] jArr;
        long[] jArr2;
        Atom.ContainerAtom f2;
        Pair<long[], long[]> h2;
        Atom.ContainerAtom containerAtom2 = containerAtom;
        Atom.ContainerAtom containerAtom3 = (Atom.ContainerAtom) Assertions.e(containerAtom2.f(1835297121));
        int d2 = d(k(((Atom.LeafAtom) Assertions.e(containerAtom3.g(1751411826))).f24535b));
        if (d2 == -1) {
            return null;
        }
        TkhdData y2 = y(((Atom.LeafAtom) Assertions.e(containerAtom2.g(1953196132))).f24535b);
        long j4 = -9223372036854775807L;
        if (j2 == -9223372036854775807L) {
            leafAtom2 = leafAtom;
            j3 = y2.f24563b;
        } else {
            leafAtom2 = leafAtom;
            j3 = j2;
        }
        long p2 = p(leafAtom2.f24535b);
        if (j3 != -9223372036854775807L) {
            j4 = Util.R0(j3, 1000000, p2);
        }
        long j5 = j4;
        Pair<Long, String> m2 = m(((Atom.LeafAtom) Assertions.e(containerAtom3.g(1835296868))).f24535b);
        Atom.LeafAtom g2 = ((Atom.ContainerAtom) Assertions.e(((Atom.ContainerAtom) Assertions.e(containerAtom3.f(1835626086))).f(1937007212))).g(1937011556);
        if (g2 != null) {
            StsdData w2 = w(g2.f24535b, y2.f24562a, y2.f24564c, (String) m2.second, drmInitData, z3);
            if (z2 || (f2 = containerAtom2.f(1701082227)) == null || (h2 = h(f2)) == null) {
                jArr2 = null;
                jArr = null;
            } else {
                jArr = (long[]) h2.second;
                jArr2 = (long[]) h2.first;
            }
            if (w2.f24551b == null) {
                return null;
            }
            return new Track(y2.f24562a, d2, ((Long) m2.first).longValue(), p2, j5, w2.f24551b, w2.f24553d, w2.f24550a, w2.f24552c, jArr2, jArr);
        }
        throw ParserException.a("Malformed sample table (stbl) missing sample description (stsd)", (Throwable) null);
    }
}
