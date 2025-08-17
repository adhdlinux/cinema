package com.google.android.exoplayer2.extractor;

import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.vorbis.VorbisComment;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class VorbisUtil {

    private static final class CodeBook {

        /* renamed from: a  reason: collision with root package name */
        public final int f24254a;

        /* renamed from: b  reason: collision with root package name */
        public final int f24255b;

        /* renamed from: c  reason: collision with root package name */
        public final long[] f24256c;

        /* renamed from: d  reason: collision with root package name */
        public final int f24257d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f24258e;

        public CodeBook(int i2, int i3, long[] jArr, int i4, boolean z2) {
            this.f24254a = i2;
            this.f24255b = i3;
            this.f24256c = jArr;
            this.f24257d = i4;
            this.f24258e = z2;
        }
    }

    public static final class CommentHeader {

        /* renamed from: a  reason: collision with root package name */
        public final String f24259a;

        /* renamed from: b  reason: collision with root package name */
        public final String[] f24260b;

        /* renamed from: c  reason: collision with root package name */
        public final int f24261c;

        public CommentHeader(String str, String[] strArr, int i2) {
            this.f24259a = str;
            this.f24260b = strArr;
            this.f24261c = i2;
        }
    }

    public static final class Mode {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f24262a;

        /* renamed from: b  reason: collision with root package name */
        public final int f24263b;

        /* renamed from: c  reason: collision with root package name */
        public final int f24264c;

        /* renamed from: d  reason: collision with root package name */
        public final int f24265d;

        public Mode(boolean z2, int i2, int i3, int i4) {
            this.f24262a = z2;
            this.f24263b = i2;
            this.f24264c = i3;
            this.f24265d = i4;
        }
    }

    public static final class VorbisIdHeader {

        /* renamed from: a  reason: collision with root package name */
        public final int f24266a;

        /* renamed from: b  reason: collision with root package name */
        public final int f24267b;

        /* renamed from: c  reason: collision with root package name */
        public final int f24268c;

        /* renamed from: d  reason: collision with root package name */
        public final int f24269d;

        /* renamed from: e  reason: collision with root package name */
        public final int f24270e;

        /* renamed from: f  reason: collision with root package name */
        public final int f24271f;

        /* renamed from: g  reason: collision with root package name */
        public final int f24272g;

        /* renamed from: h  reason: collision with root package name */
        public final int f24273h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f24274i;

        /* renamed from: j  reason: collision with root package name */
        public final byte[] f24275j;

        public VorbisIdHeader(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z2, byte[] bArr) {
            this.f24266a = i2;
            this.f24267b = i3;
            this.f24268c = i4;
            this.f24269d = i5;
            this.f24270e = i6;
            this.f24271f = i7;
            this.f24272g = i8;
            this.f24273h = i9;
            this.f24274i = z2;
            this.f24275j = bArr;
        }
    }

    private VorbisUtil() {
    }

    public static int a(int i2) {
        int i3 = 0;
        while (i2 > 0) {
            i3++;
            i2 >>>= 1;
        }
        return i3;
    }

    private static long b(long j2, long j3) {
        return (long) Math.floor(Math.pow((double) j2, 1.0d / ((double) j3)));
    }

    public static Metadata c(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2);
            String[] X0 = Util.X0(str, "=");
            if (X0.length != 2) {
                Log.i("VorbisUtil", "Failed to parse Vorbis comment: " + str);
            } else if (X0[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(PictureFrame.b(new ParsableByteArray(Base64.decode(X0[1], 0))));
                } catch (RuntimeException e2) {
                    Log.j("VorbisUtil", "Failed to parse vorbis picture", e2);
                }
            } else {
                arrayList.add(new VorbisComment(X0[0], X0[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    private static CodeBook d(VorbisBitArray vorbisBitArray) throws ParserException {
        if (vorbisBitArray.d(24) == 5653314) {
            int d2 = vorbisBitArray.d(16);
            int d3 = vorbisBitArray.d(24);
            long[] jArr = new long[d3];
            boolean c2 = vorbisBitArray.c();
            long j2 = 0;
            if (!c2) {
                boolean c3 = vorbisBitArray.c();
                for (int i2 = 0; i2 < d3; i2++) {
                    if (!c3) {
                        jArr[i2] = (long) (vorbisBitArray.d(5) + 1);
                    } else if (vorbisBitArray.c()) {
                        jArr[i2] = (long) (vorbisBitArray.d(5) + 1);
                    } else {
                        jArr[i2] = 0;
                    }
                }
            } else {
                int d4 = vorbisBitArray.d(5) + 1;
                int i3 = 0;
                while (i3 < d3) {
                    int d5 = vorbisBitArray.d(a(d3 - i3));
                    for (int i4 = 0; i4 < d5 && i3 < d3; i4++) {
                        jArr[i3] = (long) d4;
                        i3++;
                    }
                    d4++;
                }
            }
            int d6 = vorbisBitArray.d(4);
            if (d6 <= 2) {
                if (d6 == 1 || d6 == 2) {
                    vorbisBitArray.e(32);
                    vorbisBitArray.e(32);
                    int d7 = vorbisBitArray.d(4) + 1;
                    vorbisBitArray.e(1);
                    if (d6 != 1) {
                        j2 = ((long) d3) * ((long) d2);
                    } else if (d2 != 0) {
                        j2 = b((long) d3, (long) d2);
                    }
                    vorbisBitArray.e((int) (j2 * ((long) d7)));
                }
                return new CodeBook(d2, d3, jArr, d6, c2);
            }
            throw ParserException.a("lookup type greater than 2 not decodable: " + d6, (Throwable) null);
        }
        throw ParserException.a("expected code book to start with [0x56, 0x43, 0x42] at " + vorbisBitArray.b(), (Throwable) null);
    }

    private static void e(VorbisBitArray vorbisBitArray) throws ParserException {
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

    private static void f(int i2, VorbisBitArray vorbisBitArray) throws ParserException {
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
                        vorbisBitArray.e(a(i6));
                        vorbisBitArray.e(a(i6));
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

    private static Mode[] g(VorbisBitArray vorbisBitArray) {
        int d2 = vorbisBitArray.d(6) + 1;
        Mode[] modeArr = new Mode[d2];
        for (int i2 = 0; i2 < d2; i2++) {
            modeArr[i2] = new Mode(vorbisBitArray.c(), vorbisBitArray.d(16), vorbisBitArray.d(16), vorbisBitArray.d(8));
        }
        return modeArr;
    }

    private static void h(VorbisBitArray vorbisBitArray) throws ParserException {
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

    public static CommentHeader i(ParsableByteArray parsableByteArray) throws ParserException {
        return j(parsableByteArray, true, true);
    }

    public static CommentHeader j(ParsableByteArray parsableByteArray, boolean z2, boolean z3) throws ParserException {
        if (z2) {
            m(3, parsableByteArray, false);
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

    public static VorbisIdHeader k(ParsableByteArray parsableByteArray) throws ParserException {
        boolean z2 = true;
        m(1, parsableByteArray, false);
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

    public static Mode[] l(ParsableByteArray parsableByteArray, int i2) throws ParserException {
        int i3 = 0;
        m(5, parsableByteArray, false);
        int H = parsableByteArray.H() + 1;
        VorbisBitArray vorbisBitArray = new VorbisBitArray(parsableByteArray.e());
        vorbisBitArray.e(parsableByteArray.f() * 8);
        for (int i4 = 0; i4 < H; i4++) {
            d(vorbisBitArray);
        }
        int d2 = vorbisBitArray.d(6) + 1;
        while (i3 < d2) {
            if (vorbisBitArray.d(16) == 0) {
                i3++;
            } else {
                throw ParserException.a("placeholder of time domain transforms not zeroed out", (Throwable) null);
            }
        }
        e(vorbisBitArray);
        h(vorbisBitArray);
        f(i2, vorbisBitArray);
        Mode[] g2 = g(vorbisBitArray);
        if (vorbisBitArray.c()) {
            return g2;
        }
        throw ParserException.a("framing bit after modes not set as expected", (Throwable) null);
    }

    public static boolean m(int i2, ParsableByteArray parsableByteArray, boolean z2) throws ParserException {
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
