package androidx.media3.extractor;

import android.util.Base64;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.metadata.flac.PictureFrame;
import androidx.media3.extractor.metadata.vorbis.VorbisComment;
import com.facebook.imageutils.JfifUtil;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class VorbisUtil {

    public static final class CommentHeader {

        /* renamed from: a  reason: collision with root package name */
        public final String f8101a;

        /* renamed from: b  reason: collision with root package name */
        public final String[] f8102b;

        /* renamed from: c  reason: collision with root package name */
        public final int f8103c;

        public CommentHeader(String str, String[] strArr, int i2) {
            this.f8101a = str;
            this.f8102b = strArr;
            this.f8103c = i2;
        }
    }

    public static final class Mode {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f8104a;

        /* renamed from: b  reason: collision with root package name */
        public final int f8105b;

        /* renamed from: c  reason: collision with root package name */
        public final int f8106c;

        /* renamed from: d  reason: collision with root package name */
        public final int f8107d;

        public Mode(boolean z2, int i2, int i3, int i4) {
            this.f8104a = z2;
            this.f8105b = i2;
            this.f8106c = i3;
            this.f8107d = i4;
        }
    }

    public static final class VorbisIdHeader {

        /* renamed from: a  reason: collision with root package name */
        public final int f8108a;

        /* renamed from: b  reason: collision with root package name */
        public final int f8109b;

        /* renamed from: c  reason: collision with root package name */
        public final int f8110c;

        /* renamed from: d  reason: collision with root package name */
        public final int f8111d;

        /* renamed from: e  reason: collision with root package name */
        public final int f8112e;

        /* renamed from: f  reason: collision with root package name */
        public final int f8113f;

        /* renamed from: g  reason: collision with root package name */
        public final int f8114g;

        /* renamed from: h  reason: collision with root package name */
        public final int f8115h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f8116i;

        /* renamed from: j  reason: collision with root package name */
        public final byte[] f8117j;

        public VorbisIdHeader(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z2, byte[] bArr) {
            this.f8108a = i2;
            this.f8109b = i3;
            this.f8110c = i4;
            this.f8111d = i5;
            this.f8112e = i6;
            this.f8113f = i7;
            this.f8114g = i8;
            this.f8115h = i9;
            this.f8116i = z2;
            this.f8117j = bArr;
        }
    }

    private VorbisUtil() {
    }

    public static int[] a(int i2) {
        if (i2 == 3) {
            return new int[]{0, 2, 1};
        }
        if (i2 == 5) {
            return new int[]{0, 2, 1, 3, 4};
        }
        if (i2 == 6) {
            return new int[]{0, 2, 1, 5, 3, 4};
        }
        if (i2 == 7) {
            return new int[]{0, 2, 1, 6, 5, 3, 4};
        }
        if (i2 != 8) {
            return null;
        }
        return new int[]{0, 2, 1, 7, 5, 6, 3, 4};
    }

    public static int b(int i2) {
        int i3 = 0;
        while (i2 > 0) {
            i3++;
            i2 >>>= 1;
        }
        return i3;
    }

    private static long c(long j2, long j3) {
        return (long) Math.floor(Math.pow((double) j2, 1.0d / ((double) j3)));
    }

    public static Metadata d(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2);
            String[] l12 = Util.l1(str, "=");
            if (l12.length != 2) {
                Log.h("VorbisUtil", "Failed to parse Vorbis comment: " + str);
            } else if (l12[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(PictureFrame.b(new ParsableByteArray(Base64.decode(l12[1], 0))));
                } catch (RuntimeException e2) {
                    Log.i("VorbisUtil", "Failed to parse vorbis picture", e2);
                }
            } else {
                arrayList.add(new VorbisComment(l12[0], l12[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    public static ImmutableList<byte[]> e(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        parsableByteArray.V(1);
        int i2 = 0;
        while (parsableByteArray.a() > 0 && parsableByteArray.j() == 255) {
            i2 += JfifUtil.MARKER_FIRST_BYTE;
            parsableByteArray.V(1);
        }
        int H = i2 + parsableByteArray.H();
        int i3 = 0;
        while (parsableByteArray.a() > 0 && parsableByteArray.j() == 255) {
            i3 += JfifUtil.MARKER_FIRST_BYTE;
            parsableByteArray.V(1);
        }
        int H2 = i3 + parsableByteArray.H();
        byte[] bArr2 = new byte[H];
        int f2 = parsableByteArray.f();
        System.arraycopy(bArr, f2, bArr2, 0, H);
        int i4 = f2 + H + H2;
        int length = bArr.length - i4;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, i4, bArr3, 0, length);
        return ImmutableList.t(bArr2, bArr3);
    }

    private static void f(VorbisBitArray vorbisBitArray) throws ParserException {
        int d2 = vorbisBitArray.d(6) + 1;
        for (int i2 = 0; i2 < d2; i2++) {
            int d3 = vorbisBitArray.d(16);
            if (d3 == 0) {
                vorbisBitArray.e(8);
                vorbisBitArray.e(16);
                vorbisBitArray.e(16);
                vorbisBitArray.e(6);
                vorbisBitArray.e(8);
                int d4 = vorbisBitArray.d(4) + 1;
                for (int i3 = 0; i3 < d4; i3++) {
                    vorbisBitArray.e(8);
                }
            } else if (d3 == 1) {
                int d5 = vorbisBitArray.d(5);
                int[] iArr = new int[d5];
                int i4 = -1;
                for (int i5 = 0; i5 < d5; i5++) {
                    int d6 = vorbisBitArray.d(4);
                    iArr[i5] = d6;
                    if (d6 > i4) {
                        i4 = d6;
                    }
                }
                int i6 = i4 + 1;
                int[] iArr2 = new int[i6];
                for (int i7 = 0; i7 < i6; i7++) {
                    iArr2[i7] = vorbisBitArray.d(3) + 1;
                    int d7 = vorbisBitArray.d(2);
                    if (d7 > 0) {
                        vorbisBitArray.e(8);
                    }
                    for (int i8 = 0; i8 < (1 << d7); i8++) {
                        vorbisBitArray.e(8);
                    }
                }
                vorbisBitArray.e(2);
                int d8 = vorbisBitArray.d(4);
                int i9 = 0;
                int i10 = 0;
                for (int i11 = 0; i11 < d5; i11++) {
                    i9 += iArr2[iArr[i11]];
                    while (i10 < i9) {
                        vorbisBitArray.e(d8);
                        i10++;
                    }
                }
            } else {
                throw ParserException.a("floor type greater than 1 not decodable: " + d3, (Throwable) null);
            }
        }
    }

    private static void g(int i2, VorbisBitArray vorbisBitArray) throws ParserException {
        int i3;
        int d2 = vorbisBitArray.d(6) + 1;
        for (int i4 = 0; i4 < d2; i4++) {
            int d3 = vorbisBitArray.d(16);
            if (d3 != 0) {
                Log.c("VorbisUtil", "mapping type other than 0 not supported: " + d3);
            } else {
                if (vorbisBitArray.c()) {
                    i3 = vorbisBitArray.d(4) + 1;
                } else {
                    i3 = 1;
                }
                if (vorbisBitArray.c()) {
                    int d4 = vorbisBitArray.d(8) + 1;
                    for (int i5 = 0; i5 < d4; i5++) {
                        int i6 = i2 - 1;
                        vorbisBitArray.e(b(i6));
                        vorbisBitArray.e(b(i6));
                    }
                }
                if (vorbisBitArray.d(2) == 0) {
                    if (i3 > 1) {
                        for (int i7 = 0; i7 < i2; i7++) {
                            vorbisBitArray.e(4);
                        }
                    }
                    for (int i8 = 0; i8 < i3; i8++) {
                        vorbisBitArray.e(8);
                        vorbisBitArray.e(8);
                        vorbisBitArray.e(8);
                    }
                } else {
                    throw ParserException.a("to reserved bits must be zero after mapping coupling steps", (Throwable) null);
                }
            }
        }
    }

    private static Mode[] h(VorbisBitArray vorbisBitArray) {
        int d2 = vorbisBitArray.d(6) + 1;
        Mode[] modeArr = new Mode[d2];
        for (int i2 = 0; i2 < d2; i2++) {
            modeArr[i2] = new Mode(vorbisBitArray.c(), vorbisBitArray.d(16), vorbisBitArray.d(16), vorbisBitArray.d(8));
        }
        return modeArr;
    }

    private static void i(VorbisBitArray vorbisBitArray) throws ParserException {
        int i2;
        int d2 = vorbisBitArray.d(6) + 1;
        int i3 = 0;
        while (i3 < d2) {
            if (vorbisBitArray.d(16) <= 2) {
                vorbisBitArray.e(24);
                vorbisBitArray.e(24);
                vorbisBitArray.e(24);
                int d3 = vorbisBitArray.d(6) + 1;
                vorbisBitArray.e(8);
                int[] iArr = new int[d3];
                for (int i4 = 0; i4 < d3; i4++) {
                    int d4 = vorbisBitArray.d(3);
                    if (vorbisBitArray.c()) {
                        i2 = vorbisBitArray.d(5);
                    } else {
                        i2 = 0;
                    }
                    iArr[i4] = (i2 * 8) + d4;
                }
                for (int i5 = 0; i5 < d3; i5++) {
                    for (int i6 = 0; i6 < 8; i6++) {
                        if ((iArr[i5] & (1 << i6)) != 0) {
                            vorbisBitArray.e(8);
                        }
                    }
                }
                i3++;
            } else {
                throw ParserException.a("residueType greater than 2 is not decodable", (Throwable) null);
            }
        }
    }

    public static CommentHeader j(ParsableByteArray parsableByteArray) throws ParserException {
        return k(parsableByteArray, true, true);
    }

    public static CommentHeader k(ParsableByteArray parsableByteArray, boolean z2, boolean z3) throws ParserException {
        if (z2) {
            o(3, parsableByteArray, false);
        }
        String E = parsableByteArray.E((int) parsableByteArray.x());
        int length = 11 + E.length();
        long x2 = parsableByteArray.x();
        String[] strArr = new String[((int) x2)];
        int i2 = length + 4;
        for (int i3 = 0; ((long) i3) < x2; i3++) {
            String E2 = parsableByteArray.E((int) parsableByteArray.x());
            strArr[i3] = E2;
            i2 = i2 + 4 + E2.length();
        }
        if (!z3 || (parsableByteArray.H() & 1) != 0) {
            return new CommentHeader(E, strArr, i2 + 1);
        }
        throw ParserException.a("framing bit expected to be set", (Throwable) null);
    }

    public static VorbisIdHeader l(ParsableByteArray parsableByteArray) throws ParserException {
        boolean z2 = true;
        o(1, parsableByteArray, false);
        int y2 = parsableByteArray.y();
        int H = parsableByteArray.H();
        int y3 = parsableByteArray.y();
        int u2 = parsableByteArray.u();
        if (u2 <= 0) {
            u2 = -1;
        }
        int u3 = parsableByteArray.u();
        if (u3 <= 0) {
            u3 = -1;
        }
        int u4 = parsableByteArray.u();
        if (u4 <= 0) {
            u4 = -1;
        }
        int H2 = parsableByteArray.H();
        int pow = (int) Math.pow(2.0d, (double) (H2 & 15));
        int pow2 = (int) Math.pow(2.0d, (double) ((H2 & 240) >> 4));
        if ((parsableByteArray.H() & 1) <= 0) {
            z2 = false;
        }
        return new VorbisIdHeader(y2, H, y3, u2, u3, u4, pow, pow2, z2, Arrays.copyOf(parsableByteArray.e(), parsableByteArray.g()));
    }

    public static Mode[] m(ParsableByteArray parsableByteArray, int i2) throws ParserException {
        int i3 = 0;
        o(5, parsableByteArray, false);
        int H = parsableByteArray.H() + 1;
        VorbisBitArray vorbisBitArray = new VorbisBitArray(parsableByteArray.e());
        vorbisBitArray.e(parsableByteArray.f() * 8);
        for (int i4 = 0; i4 < H; i4++) {
            n(vorbisBitArray);
        }
        int d2 = vorbisBitArray.d(6) + 1;
        while (i3 < d2) {
            if (vorbisBitArray.d(16) == 0) {
                i3++;
            } else {
                throw ParserException.a("placeholder of time domain transforms not zeroed out", (Throwable) null);
            }
        }
        f(vorbisBitArray);
        i(vorbisBitArray);
        g(i2, vorbisBitArray);
        Mode[] h2 = h(vorbisBitArray);
        if (vorbisBitArray.c()) {
            return h2;
        }
        throw ParserException.a("framing bit after modes not set as expected", (Throwable) null);
    }

    private static void n(VorbisBitArray vorbisBitArray) throws ParserException {
        long j2;
        if (vorbisBitArray.d(24) == 5653314) {
            int d2 = vorbisBitArray.d(16);
            int d3 = vorbisBitArray.d(24);
            int i2 = 0;
            if (!vorbisBitArray.c()) {
                boolean c2 = vorbisBitArray.c();
                while (i2 < d3) {
                    if (!c2) {
                        vorbisBitArray.e(5);
                    } else if (vorbisBitArray.c()) {
                        vorbisBitArray.e(5);
                    }
                    i2++;
                }
            } else {
                vorbisBitArray.e(5);
                while (i2 < d3) {
                    i2 += vorbisBitArray.d(b(d3 - i2));
                }
            }
            int d4 = vorbisBitArray.d(4);
            if (d4 > 2) {
                throw ParserException.a("lookup type greater than 2 not decodable: " + d4, (Throwable) null);
            } else if (d4 == 1 || d4 == 2) {
                vorbisBitArray.e(32);
                vorbisBitArray.e(32);
                int d5 = vorbisBitArray.d(4) + 1;
                vorbisBitArray.e(1);
                if (d4 != 1) {
                    j2 = ((long) d2) * ((long) d3);
                } else if (d2 != 0) {
                    j2 = c((long) d3, (long) d2);
                } else {
                    j2 = 0;
                }
                vorbisBitArray.e((int) (j2 * ((long) d5)));
            }
        } else {
            throw ParserException.a("expected code book to start with [0x56, 0x43, 0x42] at " + vorbisBitArray.b(), (Throwable) null);
        }
    }

    public static boolean o(int i2, ParsableByteArray parsableByteArray, boolean z2) throws ParserException {
        if (parsableByteArray.a() < 7) {
            if (z2) {
                return false;
            }
            throw ParserException.a("too short header: " + parsableByteArray.a(), (Throwable) null);
        } else if (parsableByteArray.H() != i2) {
            if (z2) {
                return false;
            }
            throw ParserException.a("expected header type " + Integer.toHexString(i2), (Throwable) null);
        } else if (parsableByteArray.H() == 118 && parsableByteArray.H() == 111 && parsableByteArray.H() == 114 && parsableByteArray.H() == 98 && parsableByteArray.H() == 105 && parsableByteArray.H() == 115) {
            return true;
        } else {
            if (z2) {
                return false;
            }
            throw ParserException.a("expected characters 'vorbis'", (Throwable) null);
        }
    }
}
