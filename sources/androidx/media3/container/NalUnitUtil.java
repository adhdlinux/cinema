package androidx.media3.container;

import androidx.media3.common.ColorInfo;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.unity3d.services.core.device.MimeTypes;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class NalUnitUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f4748a = {0, 0, 0, 1};

    /* renamed from: b  reason: collision with root package name */
    public static final float[] f4749b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: c  reason: collision with root package name */
    private static final Object f4750c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static int[] f4751d = new int[10];

    public static final class H265SpsData {

        /* renamed from: a  reason: collision with root package name */
        public final int f4752a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f4753b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4754c;

        /* renamed from: d  reason: collision with root package name */
        public final int f4755d;

        /* renamed from: e  reason: collision with root package name */
        public final int f4756e;

        /* renamed from: f  reason: collision with root package name */
        public final int f4757f;

        /* renamed from: g  reason: collision with root package name */
        public final int f4758g;

        /* renamed from: h  reason: collision with root package name */
        public final int[] f4759h;

        /* renamed from: i  reason: collision with root package name */
        public final int f4760i;

        /* renamed from: j  reason: collision with root package name */
        public final int f4761j;

        /* renamed from: k  reason: collision with root package name */
        public final int f4762k;

        /* renamed from: l  reason: collision with root package name */
        public final int f4763l;

        /* renamed from: m  reason: collision with root package name */
        public final float f4764m;

        /* renamed from: n  reason: collision with root package name */
        public final int f4765n;

        /* renamed from: o  reason: collision with root package name */
        public final int f4766o;

        /* renamed from: p  reason: collision with root package name */
        public final int f4767p;

        /* renamed from: q  reason: collision with root package name */
        public final int f4768q;

        public H265SpsData(int i2, boolean z2, int i3, int i4, int i5, int i6, int i7, int[] iArr, int i8, int i9, int i10, int i11, float f2, int i12, int i13, int i14, int i15) {
            this.f4752a = i2;
            this.f4753b = z2;
            this.f4754c = i3;
            this.f4755d = i4;
            this.f4756e = i5;
            this.f4757f = i6;
            this.f4758g = i7;
            this.f4759h = iArr;
            this.f4760i = i8;
            this.f4761j = i9;
            this.f4762k = i10;
            this.f4763l = i11;
            this.f4764m = f2;
            this.f4765n = i12;
            this.f4766o = i13;
            this.f4767p = i14;
            this.f4768q = i15;
        }
    }

    public static final class PpsData {

        /* renamed from: a  reason: collision with root package name */
        public final int f4769a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4770b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f4771c;

        public PpsData(int i2, int i3, boolean z2) {
            this.f4769a = i2;
            this.f4770b = i3;
            this.f4771c = z2;
        }
    }

    public static final class SpsData {

        /* renamed from: a  reason: collision with root package name */
        public final int f4772a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4773b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4774c;

        /* renamed from: d  reason: collision with root package name */
        public final int f4775d;

        /* renamed from: e  reason: collision with root package name */
        public final int f4776e;

        /* renamed from: f  reason: collision with root package name */
        public final int f4777f;

        /* renamed from: g  reason: collision with root package name */
        public final int f4778g;

        /* renamed from: h  reason: collision with root package name */
        public final float f4779h;

        /* renamed from: i  reason: collision with root package name */
        public final int f4780i;

        /* renamed from: j  reason: collision with root package name */
        public final int f4781j;

        /* renamed from: k  reason: collision with root package name */
        public final boolean f4782k;

        /* renamed from: l  reason: collision with root package name */
        public final boolean f4783l;

        /* renamed from: m  reason: collision with root package name */
        public final int f4784m;

        /* renamed from: n  reason: collision with root package name */
        public final int f4785n;

        /* renamed from: o  reason: collision with root package name */
        public final int f4786o;

        /* renamed from: p  reason: collision with root package name */
        public final boolean f4787p;

        /* renamed from: q  reason: collision with root package name */
        public final int f4788q;

        /* renamed from: r  reason: collision with root package name */
        public final int f4789r;

        /* renamed from: s  reason: collision with root package name */
        public final int f4790s;

        /* renamed from: t  reason: collision with root package name */
        public final int f4791t;

        public SpsData(int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f2, int i9, int i10, boolean z2, boolean z3, int i11, int i12, int i13, boolean z4, int i14, int i15, int i16, int i17) {
            this.f4772a = i2;
            this.f4773b = i3;
            this.f4774c = i4;
            this.f4775d = i5;
            this.f4776e = i6;
            this.f4777f = i7;
            this.f4778g = i8;
            this.f4779h = f2;
            this.f4780i = i9;
            this.f4781j = i10;
            this.f4782k = z2;
            this.f4783l = z3;
            this.f4784m = i11;
            this.f4785n = i12;
            this.f4786o = i13;
            this.f4787p = z4;
            this.f4788q = i14;
            this.f4789r = i15;
            this.f4790s = i16;
            this.f4791t = i17;
        }
    }

    private NalUnitUtil() {
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static void b(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i2 + 1;
            if (i4 < position) {
                byte b2 = byteBuffer.get(i2) & 255;
                if (i3 == 3) {
                    if (b2 == 1 && (byteBuffer.get(i4) & 31) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i2 - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (b2 == 0) {
                    i3++;
                }
                if (b2 != 0) {
                    i3 = 0;
                }
                i2 = i4;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    public static int c(byte[] bArr, int i2, int i3, boolean[] zArr) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4 = i3 - i2;
        boolean z5 = false;
        if (i4 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        if (i4 == 0) {
            return i3;
        }
        if (zArr[0]) {
            a(zArr);
            return i2 - 3;
        } else if (i4 > 1 && zArr[1] && bArr[i2] == 1) {
            a(zArr);
            return i2 - 2;
        } else if (i4 <= 2 || !zArr[2] || bArr[i2] != 0 || bArr[i2 + 1] != 1) {
            int i5 = i3 - 1;
            int i6 = i2 + 2;
            while (i6 < i5) {
                byte b2 = bArr[i6];
                if ((b2 & 254) == 0) {
                    int i7 = i6 - 2;
                    if (bArr[i7] == 0 && bArr[i6 - 1] == 0 && b2 == 1) {
                        a(zArr);
                        return i7;
                    }
                    i6 -= 2;
                }
                i6 += 3;
            }
            if (i4 <= 2 ? i4 != 2 ? !zArr[1] || bArr[i5] != 1 : !(zArr[2] && bArr[i3 - 2] == 0 && bArr[i5] == 1) : !(bArr[i3 - 3] == 0 && bArr[i3 - 2] == 0 && bArr[i5] == 1)) {
                z3 = false;
            } else {
                z3 = true;
            }
            zArr[0] = z3;
            if (i4 <= 1 ? !zArr[2] || bArr[i5] != 0 : !(bArr[i3 - 2] == 0 && bArr[i5] == 0)) {
                z4 = false;
            } else {
                z4 = true;
            }
            zArr[1] = z4;
            if (bArr[i5] == 0) {
                z5 = true;
            }
            zArr[2] = z5;
            return i3;
        } else {
            a(zArr);
            return i2 - 1;
        }
    }

    private static int d(byte[] bArr, int i2, int i3) {
        while (i2 < i3 - 2) {
            if (bArr[i2] == 0 && bArr[i2 + 1] == 0 && bArr[i2 + 2] == 3) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int e(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 126) >> 1;
    }

    public static int f(byte[] bArr, int i2) {
        return bArr[i2 + 3] & 31;
    }

    public static boolean g(String str, byte b2) {
        if (MimeTypes.VIDEO_H264.equals(str) && (b2 & 31) == 6) {
            return true;
        }
        if (!MimeTypes.VIDEO_H265.equals(str) || ((b2 & 126) >> 1) != 39) {
            return false;
        }
        return true;
    }

    public static H265SpsData h(byte[] bArr, int i2, int i3) {
        return i(bArr, i2 + 2, i3);
    }

    public static H265SpsData i(byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i2, i3);
        parsableNalUnitBitArray.l(4);
        int e2 = parsableNalUnitBitArray.e(3);
        parsableNalUnitBitArray.k();
        int i11 = 2;
        int e3 = parsableNalUnitBitArray.e(2);
        boolean d2 = parsableNalUnitBitArray.d();
        int e4 = parsableNalUnitBitArray.e(5);
        int i12 = 0;
        for (int i13 = 0; i13 < 32; i13++) {
            if (parsableNalUnitBitArray.d()) {
                i12 |= 1 << i13;
            }
        }
        int[] iArr = new int[6];
        for (int i14 = 0; i14 < 6; i14++) {
            iArr[i14] = parsableNalUnitBitArray.e(8);
        }
        int e5 = parsableNalUnitBitArray.e(8);
        int i15 = 0;
        for (int i16 = 0; i16 < e2; i16++) {
            if (parsableNalUnitBitArray.d()) {
                i15 += 89;
            }
            if (parsableNalUnitBitArray.d()) {
                i15 += 8;
            }
        }
        parsableNalUnitBitArray.l(i15);
        if (e2 > 0) {
            parsableNalUnitBitArray.l((8 - e2) * 2);
        }
        int h2 = parsableNalUnitBitArray.h();
        int h3 = parsableNalUnitBitArray.h();
        if (h3 == 3) {
            parsableNalUnitBitArray.k();
        }
        int h4 = parsableNalUnitBitArray.h();
        int h5 = parsableNalUnitBitArray.h();
        if (parsableNalUnitBitArray.d()) {
            int h6 = parsableNalUnitBitArray.h();
            int h7 = parsableNalUnitBitArray.h();
            int h8 = parsableNalUnitBitArray.h();
            int h9 = parsableNalUnitBitArray.h();
            if (h3 == 1 || h3 == 2) {
                i9 = 2;
            } else {
                i9 = 1;
            }
            if (h3 == 1) {
                i10 = 2;
            } else {
                i10 = 1;
            }
            h4 -= i9 * (h6 + h7);
            h5 -= i10 * (h8 + h9);
        }
        int i17 = h5;
        int i18 = h4;
        int i19 = i17;
        int h10 = parsableNalUnitBitArray.h();
        int h11 = parsableNalUnitBitArray.h();
        int h12 = parsableNalUnitBitArray.h();
        if (parsableNalUnitBitArray.d()) {
            i4 = 0;
        } else {
            i4 = e2;
        }
        int i20 = -1;
        int i21 = -1;
        for (int i22 = i4; i22 <= e2; i22++) {
            parsableNalUnitBitArray.h();
            i21 = Math.max(parsableNalUnitBitArray.h(), i21);
            parsableNalUnitBitArray.h();
        }
        parsableNalUnitBitArray.h();
        parsableNalUnitBitArray.h();
        parsableNalUnitBitArray.h();
        parsableNalUnitBitArray.h();
        parsableNalUnitBitArray.h();
        parsableNalUnitBitArray.h();
        if (parsableNalUnitBitArray.d() && parsableNalUnitBitArray.d()) {
            n(parsableNalUnitBitArray);
        }
        parsableNalUnitBitArray.l(2);
        if (parsableNalUnitBitArray.d()) {
            parsableNalUnitBitArray.l(8);
            parsableNalUnitBitArray.h();
            parsableNalUnitBitArray.h();
            parsableNalUnitBitArray.k();
        }
        q(parsableNalUnitBitArray);
        if (parsableNalUnitBitArray.d()) {
            int h13 = parsableNalUnitBitArray.h();
            for (int i23 = 0; i23 < h13; i23++) {
                parsableNalUnitBitArray.l(h12 + 4 + 1);
            }
        }
        parsableNalUnitBitArray.l(2);
        float f2 = 1.0f;
        if (parsableNalUnitBitArray.d()) {
            if (parsableNalUnitBitArray.d()) {
                int e6 = parsableNalUnitBitArray.e(8);
                if (e6 == 255) {
                    int e7 = parsableNalUnitBitArray.e(16);
                    int e8 = parsableNalUnitBitArray.e(16);
                    if (!(e7 == 0 || e8 == 0)) {
                        f2 = ((float) e7) / ((float) e8);
                    }
                } else {
                    float[] fArr = f4749b;
                    if (e6 < fArr.length) {
                        f2 = fArr[e6];
                    } else {
                        Log.h("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + e6);
                    }
                }
            }
            if (parsableNalUnitBitArray.d()) {
                parsableNalUnitBitArray.k();
            }
            if (parsableNalUnitBitArray.d()) {
                parsableNalUnitBitArray.l(3);
                if (parsableNalUnitBitArray.d()) {
                    i11 = 1;
                }
                if (parsableNalUnitBitArray.d()) {
                    int e9 = parsableNalUnitBitArray.e(8);
                    int e10 = parsableNalUnitBitArray.e(8);
                    parsableNalUnitBitArray.l(8);
                    i20 = ColorInfo.j(e9);
                    i8 = ColorInfo.k(e10);
                } else {
                    i8 = -1;
                }
            } else {
                i8 = -1;
                i11 = -1;
            }
            if (parsableNalUnitBitArray.d()) {
                parsableNalUnitBitArray.h();
                parsableNalUnitBitArray.h();
            }
            parsableNalUnitBitArray.k();
            if (parsableNalUnitBitArray.d()) {
                i19 *= 2;
            }
            i5 = i11;
            i7 = i19;
            i6 = i20;
            i20 = i8;
        } else {
            i7 = i19;
            i6 = -1;
            i5 = -1;
        }
        return new H265SpsData(e3, d2, e4, i12, h3, h10, h11, iArr, e5, h2, i18, i7, f2, i21, i6, i5, i20);
    }

    public static PpsData j(byte[] bArr, int i2, int i3) {
        return k(bArr, i2 + 1, i3);
    }

    public static PpsData k(byte[] bArr, int i2, int i3) {
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i2, i3);
        int h2 = parsableNalUnitBitArray.h();
        int h3 = parsableNalUnitBitArray.h();
        parsableNalUnitBitArray.k();
        return new PpsData(h2, h3, parsableNalUnitBitArray.d());
    }

    public static SpsData l(byte[] bArr, int i2, int i3) {
        return m(bArr, i2 + 1, i3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:122:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x015c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.media3.container.NalUnitUtil.SpsData m(byte[] r32, int r33, int r34) {
        /*
            androidx.media3.container.ParsableNalUnitBitArray r0 = new androidx.media3.container.ParsableNalUnitBitArray
            r1 = r32
            r2 = r33
            r3 = r34
            r0.<init>(r1, r2, r3)
            r1 = 8
            int r3 = r0.e(r1)
            int r4 = r0.e(r1)
            int r5 = r0.e(r1)
            int r6 = r0.h()
            r2 = 86
            r7 = 44
            r8 = 244(0xf4, float:3.42E-43)
            r9 = 122(0x7a, float:1.71E-43)
            r10 = 110(0x6e, float:1.54E-43)
            r11 = 3
            r12 = 16
            r13 = 1
            r15 = 100
            if (r3 == r15) goto L_0x0052
            if (r3 == r10) goto L_0x0052
            if (r3 == r9) goto L_0x0052
            if (r3 == r8) goto L_0x0052
            if (r3 == r7) goto L_0x0052
            r14 = 83
            if (r3 == r14) goto L_0x0052
            if (r3 == r2) goto L_0x0052
            r14 = 118(0x76, float:1.65E-43)
            if (r3 == r14) goto L_0x0052
            r14 = 128(0x80, float:1.794E-43)
            if (r3 == r14) goto L_0x0052
            r14 = 138(0x8a, float:1.93E-43)
            if (r3 != r14) goto L_0x004a
            goto L_0x0052
        L_0x004a:
            r14 = 1
            r16 = 0
            r17 = 0
            r18 = 0
            goto L_0x0090
        L_0x0052:
            int r14 = r0.h()
            if (r14 != r11) goto L_0x005d
            boolean r16 = r0.d()
            goto L_0x005f
        L_0x005d:
            r16 = 0
        L_0x005f:
            int r17 = r0.h()
            int r18 = r0.h()
            r0.k()
            boolean r19 = r0.d()
            if (r19 == 0) goto L_0x0090
            if (r14 == r11) goto L_0x0073
            goto L_0x0077
        L_0x0073:
            r19 = 12
            r1 = 12
        L_0x0077:
            r8 = 0
        L_0x0078:
            if (r8 >= r1) goto L_0x0090
            boolean r19 = r0.d()
            if (r19 == 0) goto L_0x008b
            r9 = 6
            if (r8 >= r9) goto L_0x0086
            r9 = 16
            goto L_0x0088
        L_0x0086:
            r9 = 64
        L_0x0088:
            p(r0, r9)
        L_0x008b:
            int r8 = r8 + 1
            r9 = 122(0x7a, float:1.71E-43)
            goto L_0x0078
        L_0x0090:
            int r1 = r0.h()
            int r1 = r1 + 4
            int r9 = r0.h()
            if (r9 != 0) goto L_0x00a7
            int r8 = r0.h()
            int r8 = r8 + 4
            r21 = r3
            r24 = r8
            goto L_0x00d1
        L_0x00a7:
            if (r9 != r13) goto L_0x00cd
            boolean r8 = r0.d()
            r0.g()
            r0.g()
            int r10 = r0.h()
            r21 = r3
            long r2 = (long) r10
            r24 = r8
            r10 = 0
        L_0x00bd:
            long r7 = (long) r10
            int r25 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r25 >= 0) goto L_0x00c8
            r0.h()
            int r10 = r10 + 1
            goto L_0x00bd
        L_0x00c8:
            r25 = r24
            r24 = 0
            goto L_0x00d3
        L_0x00cd:
            r21 = r3
            r24 = 0
        L_0x00d1:
            r25 = 0
        L_0x00d3:
            int r7 = r0.h()
            r0.k()
            int r2 = r0.h()
            int r2 = r2 + r13
            int r3 = r0.h()
            int r3 = r3 + r13
            boolean r26 = r0.d()
            int r8 = 2 - r26
            int r8 = r8 * r3
            if (r26 != 0) goto L_0x00f1
            r0.k()
        L_0x00f1:
            r0.k()
            int r2 = r2 * 16
            int r8 = r8 * 16
            boolean r3 = r0.d()
            if (r3 == 0) goto L_0x0130
            int r3 = r0.h()
            int r27 = r0.h()
            int r28 = r0.h()
            int r29 = r0.h()
            if (r14 != 0) goto L_0x0115
            int r14 = 2 - r26
            r30 = 1
            goto L_0x0125
        L_0x0115:
            if (r14 != r11) goto L_0x011a
            r30 = 1
            goto L_0x011c
        L_0x011a:
            r30 = 2
        L_0x011c:
            if (r14 != r13) goto L_0x0120
            r14 = 2
            goto L_0x0121
        L_0x0120:
            r14 = 1
        L_0x0121:
            int r31 = 2 - r26
            int r14 = r14 * r31
        L_0x0125:
            int r3 = r3 + r27
            int r3 = r3 * r30
            int r2 = r2 - r3
            int r28 = r28 + r29
            int r28 = r28 * r14
            int r8 = r8 - r28
        L_0x0130:
            r14 = r8
            r3 = r21
            r8 = r2
            r2 = 44
            if (r3 == r2) goto L_0x014a
            r2 = 86
            if (r3 == r2) goto L_0x014a
            if (r3 == r15) goto L_0x014a
            r2 = 110(0x6e, float:1.54E-43)
            if (r3 == r2) goto L_0x014a
            r2 = 122(0x7a, float:1.71E-43)
            if (r3 == r2) goto L_0x014a
            r2 = 244(0xf4, float:3.42E-43)
            if (r3 != r2) goto L_0x0150
        L_0x014a:
            r2 = r4 & 16
            if (r2 == 0) goto L_0x0150
            r2 = 0
            goto L_0x0152
        L_0x0150:
            r2 = 16
        L_0x0152:
            boolean r15 = r0.d()
            r19 = -1
            r20 = 1065353216(0x3f800000, float:1.0)
            if (r15 == 0) goto L_0x022d
            boolean r15 = r0.d()
            if (r15 == 0) goto L_0x019b
            r15 = 8
            int r10 = r0.e(r15)
            r15 = 255(0xff, float:3.57E-43)
            if (r10 != r15) goto L_0x017d
            int r10 = r0.e(r12)
            int r12 = r0.e(r12)
            if (r10 == 0) goto L_0x019b
            if (r12 == 0) goto L_0x019b
            float r10 = (float) r10
            float r12 = (float) r12
            float r20 = r10 / r12
            goto L_0x019b
        L_0x017d:
            float[] r12 = f4749b
            int r15 = r12.length
            if (r10 >= r15) goto L_0x0185
            r20 = r12[r10]
            goto L_0x019b
        L_0x0185:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r15 = "Unexpected aspect_ratio_idc value: "
            r12.append(r15)
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            java.lang.String r12 = "NalUnitUtil"
            androidx.media3.common.util.Log.h(r12, r10)
        L_0x019b:
            boolean r10 = r0.d()
            if (r10 == 0) goto L_0x01a4
            r0.k()
        L_0x01a4:
            boolean r10 = r0.d()
            if (r10 == 0) goto L_0x01d3
            r0.l(r11)
            boolean r10 = r0.d()
            if (r10 == 0) goto L_0x01b4
            goto L_0x01b5
        L_0x01b4:
            r13 = 2
        L_0x01b5:
            boolean r10 = r0.d()
            if (r10 == 0) goto L_0x01d1
            r10 = 8
            int r11 = r0.e(r10)
            int r12 = r0.e(r10)
            r0.l(r10)
            int r19 = androidx.media3.common.ColorInfo.j(r11)
            int r10 = androidx.media3.common.ColorInfo.k(r12)
            goto L_0x01d5
        L_0x01d1:
            r10 = -1
            goto L_0x01d5
        L_0x01d3:
            r10 = -1
            r13 = -1
        L_0x01d5:
            boolean r11 = r0.d()
            if (r11 == 0) goto L_0x01e1
            r0.h()
            r0.h()
        L_0x01e1:
            boolean r11 = r0.d()
            if (r11 == 0) goto L_0x01ec
            r11 = 65
            r0.l(r11)
        L_0x01ec:
            boolean r11 = r0.d()
            if (r11 == 0) goto L_0x01f5
            o(r0)
        L_0x01f5:
            boolean r12 = r0.d()
            if (r12 == 0) goto L_0x01fe
            o(r0)
        L_0x01fe:
            if (r11 != 0) goto L_0x0202
            if (r12 == 0) goto L_0x0205
        L_0x0202:
            r0.k()
        L_0x0205:
            r0.k()
            boolean r11 = r0.d()
            if (r11 == 0) goto L_0x0224
            r0.k()
            r0.h()
            r0.h()
            r0.h()
            r0.h()
            int r2 = r0.h()
            r0.h()
        L_0x0224:
            r22 = r2
            r21 = r10
            r10 = r20
            r20 = r13
            goto L_0x0235
        L_0x022d:
            r22 = r2
            r10 = 1065353216(0x3f800000, float:1.0)
            r20 = -1
            r21 = -1
        L_0x0235:
            androidx.media3.container.NalUnitUtil$SpsData r0 = new androidx.media3.container.NalUnitUtil$SpsData
            r2 = r0
            r23 = r9
            r9 = r14
            r11 = r17
            r12 = r18
            r13 = r16
            r14 = r26
            r15 = r1
            r16 = r23
            r17 = r24
            r18 = r25
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.container.NalUnitUtil.m(byte[], int, int):androidx.media3.container.NalUnitUtil$SpsData");
    }

    private static void n(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = 0;
            while (i3 < 6) {
                int i4 = 1;
                if (!parsableNalUnitBitArray.d()) {
                    parsableNalUnitBitArray.h();
                } else {
                    int min = Math.min(64, 1 << ((i2 << 1) + 4));
                    if (i2 > 1) {
                        parsableNalUnitBitArray.g();
                    }
                    for (int i5 = 0; i5 < min; i5++) {
                        parsableNalUnitBitArray.g();
                    }
                }
                if (i2 == 3) {
                    i4 = 3;
                }
                i3 += i4;
            }
        }
    }

    private static void o(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int h2 = parsableNalUnitBitArray.h() + 1;
        parsableNalUnitBitArray.l(8);
        for (int i2 = 0; i2 < h2; i2++) {
            parsableNalUnitBitArray.h();
            parsableNalUnitBitArray.h();
            parsableNalUnitBitArray.k();
        }
        parsableNalUnitBitArray.l(20);
    }

    private static void p(ParsableNalUnitBitArray parsableNalUnitBitArray, int i2) {
        int i3 = 8;
        int i4 = 8;
        for (int i5 = 0; i5 < i2; i5++) {
            if (i3 != 0) {
                i3 = ((parsableNalUnitBitArray.g() + i4) + UserVerificationMethods.USER_VERIFY_HANDPRINT) % UserVerificationMethods.USER_VERIFY_HANDPRINT;
            }
            if (i3 != 0) {
                i4 = i3;
            }
        }
    }

    private static void q(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        boolean z2;
        int i2;
        int i3;
        int h2 = parsableNalUnitBitArray.h();
        int[] iArr = new int[0];
        int[] iArr2 = new int[0];
        int i4 = -1;
        int i5 = -1;
        for (int i6 = 0; i6 < h2; i6++) {
            if (i6 == 0 || !parsableNalUnitBitArray.d()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                int i7 = i4 + i5;
                int h3 = (1 - ((parsableNalUnitBitArray.d() ? 1 : 0) * true)) * (parsableNalUnitBitArray.h() + 1);
                int i8 = i7 + 1;
                boolean[] zArr = new boolean[i8];
                for (int i9 = 0; i9 <= i7; i9++) {
                    if (!parsableNalUnitBitArray.d()) {
                        zArr[i9] = parsableNalUnitBitArray.d();
                    } else {
                        zArr[i9] = true;
                    }
                }
                int[] iArr3 = new int[i8];
                int[] iArr4 = new int[i8];
                int i10 = 0;
                for (int i11 = i5 - 1; i11 >= 0; i11--) {
                    int i12 = iArr2[i11] + h3;
                    if (i12 < 0 && zArr[i4 + i11]) {
                        iArr3[i10] = i12;
                        i10++;
                    }
                }
                if (h3 < 0 && zArr[i7]) {
                    iArr3[i10] = h3;
                    i10++;
                }
                for (int i13 = 0; i13 < i4; i13++) {
                    int i14 = iArr[i13] + h3;
                    if (i14 < 0 && zArr[i13]) {
                        iArr3[i10] = i14;
                        i10++;
                    }
                }
                int[] copyOf = Arrays.copyOf(iArr3, i10);
                int i15 = 0;
                for (int i16 = i4 - 1; i16 >= 0; i16--) {
                    int i17 = iArr[i16] + h3;
                    if (i17 > 0 && zArr[i16]) {
                        iArr4[i15] = i17;
                        i15++;
                    }
                }
                if (h3 > 0 && zArr[i7]) {
                    iArr4[i15] = h3;
                    i15++;
                }
                for (int i18 = 0; i18 < i5; i18++) {
                    int i19 = iArr2[i18] + h3;
                    if (i19 > 0 && zArr[i4 + i18]) {
                        iArr4[i15] = i19;
                        i15++;
                    }
                }
                iArr2 = Arrays.copyOf(iArr4, i15);
                iArr = copyOf;
                i4 = i10;
                i5 = i15;
            } else {
                int h4 = parsableNalUnitBitArray.h();
                int h5 = parsableNalUnitBitArray.h();
                int[] iArr5 = new int[h4];
                for (int i20 = 0; i20 < h4; i20++) {
                    if (i20 > 0) {
                        i3 = iArr5[i20 - 1];
                    } else {
                        i3 = 0;
                    }
                    iArr5[i20] = i3 - (parsableNalUnitBitArray.h() + 1);
                    parsableNalUnitBitArray.k();
                }
                int[] iArr6 = new int[h5];
                for (int i21 = 0; i21 < h5; i21++) {
                    if (i21 > 0) {
                        i2 = iArr6[i21 - 1];
                    } else {
                        i2 = 0;
                    }
                    iArr6[i21] = i2 + parsableNalUnitBitArray.h() + 1;
                    parsableNalUnitBitArray.k();
                }
                int[] iArr7 = iArr5;
                i4 = h4;
                iArr = iArr7;
                int[] iArr8 = iArr6;
                i5 = h5;
                iArr2 = iArr8;
            }
        }
    }

    public static int r(byte[] bArr, int i2) {
        int i3;
        synchronized (f4750c) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < i2) {
                try {
                    i4 = d(bArr, i4, i2);
                    if (i4 < i2) {
                        int[] iArr = f4751d;
                        if (iArr.length <= i5) {
                            f4751d = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        f4751d[i5] = i4;
                        i4 += 3;
                        i5++;
                    }
                } finally {
                }
            }
            i3 = i2 - i5;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i5; i8++) {
                int i9 = f4751d[i8] - i7;
                System.arraycopy(bArr, i7, bArr, i6, i9);
                int i10 = i6 + i9;
                int i11 = i10 + 1;
                bArr[i10] = 0;
                i6 = i11 + 1;
                bArr[i11] = 0;
                i7 += i9 + 3;
            }
            System.arraycopy(bArr, i7, bArr, i6, i3 - i6);
        }
        return i3;
    }
}
