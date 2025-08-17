package com.google.android.exoplayer2.util;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.unity3d.services.core.device.MimeTypes;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class NalUnitUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f28716a = {0, 0, 0, 1};

    /* renamed from: b  reason: collision with root package name */
    public static final float[] f28717b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: c  reason: collision with root package name */
    private static final Object f28718c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static int[] f28719d = new int[10];

    public static final class H265SpsData {

        /* renamed from: a  reason: collision with root package name */
        public final int f28720a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f28721b;

        /* renamed from: c  reason: collision with root package name */
        public final int f28722c;

        /* renamed from: d  reason: collision with root package name */
        public final int f28723d;

        /* renamed from: e  reason: collision with root package name */
        public final int[] f28724e;

        /* renamed from: f  reason: collision with root package name */
        public final int f28725f;

        /* renamed from: g  reason: collision with root package name */
        public final int f28726g;

        /* renamed from: h  reason: collision with root package name */
        public final int f28727h;

        /* renamed from: i  reason: collision with root package name */
        public final int f28728i;

        /* renamed from: j  reason: collision with root package name */
        public final float f28729j;

        /* renamed from: k  reason: collision with root package name */
        public final int f28730k;

        /* renamed from: l  reason: collision with root package name */
        public final int f28731l;

        /* renamed from: m  reason: collision with root package name */
        public final int f28732m;

        public H265SpsData(int i2, boolean z2, int i3, int i4, int[] iArr, int i5, int i6, int i7, int i8, float f2, int i9, int i10, int i11) {
            this.f28720a = i2;
            this.f28721b = z2;
            this.f28722c = i3;
            this.f28723d = i4;
            this.f28724e = iArr;
            this.f28725f = i5;
            this.f28726g = i6;
            this.f28727h = i7;
            this.f28728i = i8;
            this.f28729j = f2;
            this.f28730k = i9;
            this.f28731l = i10;
            this.f28732m = i11;
        }
    }

    public static final class PpsData {

        /* renamed from: a  reason: collision with root package name */
        public final int f28733a;

        /* renamed from: b  reason: collision with root package name */
        public final int f28734b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f28735c;

        public PpsData(int i2, int i3, boolean z2) {
            this.f28733a = i2;
            this.f28734b = i3;
            this.f28735c = z2;
        }
    }

    public static final class SpsData {

        /* renamed from: a  reason: collision with root package name */
        public final int f28736a;

        /* renamed from: b  reason: collision with root package name */
        public final int f28737b;

        /* renamed from: c  reason: collision with root package name */
        public final int f28738c;

        /* renamed from: d  reason: collision with root package name */
        public final int f28739d;

        /* renamed from: e  reason: collision with root package name */
        public final int f28740e;

        /* renamed from: f  reason: collision with root package name */
        public final int f28741f;

        /* renamed from: g  reason: collision with root package name */
        public final int f28742g;

        /* renamed from: h  reason: collision with root package name */
        public final float f28743h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f28744i;

        /* renamed from: j  reason: collision with root package name */
        public final boolean f28745j;

        /* renamed from: k  reason: collision with root package name */
        public final int f28746k;

        /* renamed from: l  reason: collision with root package name */
        public final int f28747l;

        /* renamed from: m  reason: collision with root package name */
        public final int f28748m;

        /* renamed from: n  reason: collision with root package name */
        public final boolean f28749n;

        public SpsData(int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f2, boolean z2, boolean z3, int i9, int i10, int i11, boolean z4) {
            this.f28736a = i2;
            this.f28737b = i3;
            this.f28738c = i4;
            this.f28739d = i5;
            this.f28740e = i6;
            this.f28741f = i7;
            this.f28742g = i8;
            this.f28743h = f2;
            this.f28744i = z2;
            this.f28745j = z3;
            this.f28746k = i9;
            this.f28747l = i10;
            this.f28748m = i11;
            this.f28749n = z4;
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
        Assertions.g(z2);
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

    /* JADX WARNING: Removed duplicated region for block: B:86:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.util.NalUnitUtil.H265SpsData i(byte[] r23, int r24, int r25) {
        /*
            com.google.android.exoplayer2.util.ParsableNalUnitBitArray r0 = new com.google.android.exoplayer2.util.ParsableNalUnitBitArray
            r1 = r23
            r2 = r24
            r3 = r25
            r0.<init>(r1, r2, r3)
            r1 = 4
            r0.l(r1)
            r2 = 3
            int r3 = r0.e(r2)
            r0.k()
            r4 = 2
            int r6 = r0.e(r4)
            boolean r7 = r0.d()
            r5 = 5
            int r8 = r0.e(r5)
            r9 = 0
            r10 = 0
        L_0x0027:
            r11 = 32
            r12 = 1
            if (r10 >= r11) goto L_0x0038
            boolean r11 = r0.d()
            if (r11 == 0) goto L_0x0035
            int r11 = r12 << r10
            r9 = r9 | r11
        L_0x0035:
            int r10 = r10 + 1
            goto L_0x0027
        L_0x0038:
            r10 = 6
            int[] r11 = new int[r10]
            r13 = 0
        L_0x003c:
            r14 = 8
            if (r13 >= r10) goto L_0x0049
            int r14 = r0.e(r14)
            r11[r13] = r14
            int r13 = r13 + 1
            goto L_0x003c
        L_0x0049:
            int r13 = r0.e(r14)
            r10 = 0
            r15 = 0
        L_0x004f:
            if (r10 >= r3) goto L_0x0064
            boolean r16 = r0.d()
            if (r16 == 0) goto L_0x0059
            int r15 = r15 + 89
        L_0x0059:
            boolean r16 = r0.d()
            if (r16 == 0) goto L_0x0061
            int r15 = r15 + 8
        L_0x0061:
            int r10 = r10 + 1
            goto L_0x004f
        L_0x0064:
            r0.l(r15)
            if (r3 <= 0) goto L_0x0070
            int r10 = 8 - r3
            int r10 = r10 * 2
            r0.l(r10)
        L_0x0070:
            int r15 = r0.h()
            int r10 = r0.h()
            if (r10 != r2) goto L_0x007d
            r0.k()
        L_0x007d:
            int r16 = r0.h()
            int r17 = r0.h()
            boolean r18 = r0.d()
            if (r18 == 0) goto L_0x00b6
            int r18 = r0.h()
            int r19 = r0.h()
            int r20 = r0.h()
            int r21 = r0.h()
            if (r10 == r12) goto L_0x00a3
            if (r10 != r4) goto L_0x00a0
            goto L_0x00a3
        L_0x00a0:
            r22 = 1
            goto L_0x00a5
        L_0x00a3:
            r22 = 2
        L_0x00a5:
            if (r10 != r12) goto L_0x00a9
            r10 = 2
            goto L_0x00aa
        L_0x00a9:
            r10 = 1
        L_0x00aa:
            int r18 = r18 + r19
            int r22 = r22 * r18
            int r16 = r16 - r22
            int r20 = r20 + r21
            int r10 = r10 * r20
            int r17 = r17 - r10
        L_0x00b6:
            r0.h()
            r0.h()
            int r10 = r0.h()
            boolean r18 = r0.d()
            if (r18 == 0) goto L_0x00c9
            r18 = 0
            goto L_0x00cb
        L_0x00c9:
            r18 = r3
        L_0x00cb:
            r5 = r18
        L_0x00cd:
            if (r5 > r3) goto L_0x00db
            r0.h()
            r0.h()
            r0.h()
            int r5 = r5 + 1
            goto L_0x00cd
        L_0x00db:
            r0.h()
            r0.h()
            r0.h()
            r0.h()
            r0.h()
            r0.h()
            boolean r3 = r0.d()
            if (r3 == 0) goto L_0x00fc
            boolean r3 = r0.d()
            if (r3 == 0) goto L_0x00fc
            n(r0)
        L_0x00fc:
            r0.l(r4)
            boolean r3 = r0.d()
            if (r3 == 0) goto L_0x0111
            r0.l(r14)
            r0.h()
            r0.h()
            r0.k()
        L_0x0111:
            p(r0)
            boolean r3 = r0.d()
            if (r3 == 0) goto L_0x012a
            r5 = 0
        L_0x011b:
            int r3 = r0.h()
            if (r5 >= r3) goto L_0x012a
            int r3 = r10 + 4
            int r3 = r3 + r12
            r0.l(r3)
            int r5 = r5 + 1
            goto L_0x011b
        L_0x012a:
            r0.l(r4)
            boolean r1 = r0.d()
            r5 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L_0x01ca
            boolean r1 = r0.d()
            if (r1 == 0) goto L_0x0173
            int r1 = r0.e(r14)
            r10 = 255(0xff, float:3.57E-43)
            if (r1 != r10) goto L_0x0155
            r1 = 16
            int r10 = r0.e(r1)
            int r1 = r0.e(r1)
            if (r10 == 0) goto L_0x0173
            if (r1 == 0) goto L_0x0173
            float r5 = (float) r10
            float r1 = (float) r1
            float r5 = r5 / r1
            goto L_0x0173
        L_0x0155:
            float[] r10 = f28717b
            int r3 = r10.length
            if (r1 >= r3) goto L_0x015d
            r5 = r10[r1]
            goto L_0x0173
        L_0x015d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r10 = "Unexpected aspect_ratio_idc value: "
            r3.append(r10)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.String r3 = "NalUnitUtil"
            com.google.android.exoplayer2.util.Log.i(r3, r1)
        L_0x0173:
            boolean r1 = r0.d()
            if (r1 == 0) goto L_0x017c
            r0.k()
        L_0x017c:
            boolean r1 = r0.d()
            if (r1 == 0) goto L_0x01a8
            r0.l(r2)
            boolean r1 = r0.d()
            boolean r2 = r0.d()
            if (r2 == 0) goto L_0x01a8
            int r2 = r0.e(r14)
            int r3 = r0.e(r14)
            r0.l(r14)
            int r2 = com.google.android.exoplayer2.video.ColorInfo.b(r2)
            if (r1 == 0) goto L_0x01a1
            r4 = 1
        L_0x01a1:
            int r3 = com.google.android.exoplayer2.video.ColorInfo.c(r3)
            r1 = r3
            r3 = r2
            goto L_0x01ab
        L_0x01a8:
            r1 = -1
            r3 = -1
            r4 = -1
        L_0x01ab:
            boolean r2 = r0.d()
            if (r2 == 0) goto L_0x01b7
            r0.h()
            r0.h()
        L_0x01b7:
            r0.k()
            boolean r0 = r0.d()
            if (r0 == 0) goto L_0x01c2
            int r17 = r17 * 2
        L_0x01c2:
            r18 = r1
            r0 = r5
            r14 = r17
            r17 = r4
            goto L_0x01d3
        L_0x01ca:
            r14 = r17
            r0 = 1065353216(0x3f800000, float:1.0)
            r3 = -1
            r17 = -1
            r18 = -1
        L_0x01d3:
            com.google.android.exoplayer2.util.NalUnitUtil$H265SpsData r1 = new com.google.android.exoplayer2.util.NalUnitUtil$H265SpsData
            r5 = r1
            r10 = r11
            r11 = r13
            r12 = r15
            r13 = r16
            r15 = r0
            r16 = r3
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.NalUnitUtil.i(byte[], int, int):com.google.android.exoplayer2.util.NalUnitUtil$H265SpsData");
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

    public static SpsData m(byte[] bArr, int i2, int i3) {
        boolean z2;
        int i4;
        boolean z3;
        int i5;
        int i6;
        boolean z4;
        float f2;
        int i7;
        int i8;
        int i9;
        int i10;
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i2, i3);
        int e2 = parsableNalUnitBitArray.e(8);
        int e3 = parsableNalUnitBitArray.e(8);
        int e4 = parsableNalUnitBitArray.e(8);
        int h2 = parsableNalUnitBitArray.h();
        int i11 = 1;
        if (e2 == 100 || e2 == 110 || e2 == 122 || e2 == 244 || e2 == 44 || e2 == 83 || e2 == 86 || e2 == 118 || e2 == 128 || e2 == 138) {
            i4 = parsableNalUnitBitArray.h();
            if (i4 == 3) {
                z2 = parsableNalUnitBitArray.d();
            } else {
                z2 = false;
            }
            parsableNalUnitBitArray.h();
            parsableNalUnitBitArray.h();
            parsableNalUnitBitArray.k();
            if (parsableNalUnitBitArray.d()) {
                if (i4 != 3) {
                    i9 = 8;
                } else {
                    i9 = 12;
                }
                for (int i12 = 0; i12 < i9; i12++) {
                    if (parsableNalUnitBitArray.d()) {
                        if (i12 < 6) {
                            i10 = 16;
                        } else {
                            i10 = 64;
                        }
                        o(parsableNalUnitBitArray, i10);
                    }
                }
            }
        } else {
            i4 = 1;
            z2 = false;
        }
        int h3 = parsableNalUnitBitArray.h() + 4;
        int h4 = parsableNalUnitBitArray.h();
        if (h4 == 0) {
            i5 = i4;
            z3 = z2;
            i6 = parsableNalUnitBitArray.h() + 4;
            z4 = false;
        } else {
            if (h4 == 1) {
                boolean d2 = parsableNalUnitBitArray.d();
                parsableNalUnitBitArray.g();
                parsableNalUnitBitArray.g();
                z3 = z2;
                long h5 = (long) parsableNalUnitBitArray.h();
                i5 = i4;
                for (int i13 = 0; ((long) i13) < h5; i13++) {
                    parsableNalUnitBitArray.h();
                }
                z4 = d2;
            } else {
                i5 = i4;
                z3 = z2;
                z4 = false;
            }
            i6 = 0;
        }
        int h6 = parsableNalUnitBitArray.h();
        parsableNalUnitBitArray.k();
        int h7 = parsableNalUnitBitArray.h() + 1;
        boolean d3 = parsableNalUnitBitArray.d();
        int h8 = (true - (d3 ? 1 : 0)) * (parsableNalUnitBitArray.h() + 1);
        if (!d3) {
            parsableNalUnitBitArray.k();
        }
        parsableNalUnitBitArray.k();
        int i14 = h7 * 16;
        int i15 = h8 * 16;
        if (parsableNalUnitBitArray.d()) {
            int h9 = parsableNalUnitBitArray.h();
            int h10 = parsableNalUnitBitArray.h();
            int h11 = parsableNalUnitBitArray.h();
            int h12 = parsableNalUnitBitArray.h();
            if (i5 == 0) {
                i7 = true - d3;
            } else {
                int i16 = i5;
                if (i16 == 3) {
                    i8 = 1;
                } else {
                    i8 = 2;
                }
                if (i16 == 1) {
                    i11 = 2;
                }
                int i17 = (true - d3) * i11;
                i11 = i8;
                i7 = i17;
            }
            i14 -= (h9 + h10) * i11;
            i15 -= (h11 + h12) * i7;
        }
        int i18 = i14;
        int i19 = i15;
        float f3 = 1.0f;
        if (parsableNalUnitBitArray.d() && parsableNalUnitBitArray.d()) {
            int e5 = parsableNalUnitBitArray.e(8);
            if (e5 == 255) {
                int e6 = parsableNalUnitBitArray.e(16);
                int e7 = parsableNalUnitBitArray.e(16);
                if (!(e6 == 0 || e7 == 0)) {
                    f3 = ((float) e6) / ((float) e7);
                }
                f2 = f3;
            } else {
                float[] fArr = f28717b;
                if (e5 < fArr.length) {
                    f2 = fArr[e5];
                } else {
                    Log.i("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + e5);
                }
            }
            return new SpsData(e2, e3, e4, h2, h6, i18, i19, f2, z3, d3, h3, h4, i6, z4);
        }
        f2 = 1.0f;
        return new SpsData(e2, e3, e4, h2, h6, i18, i19, f2, z3, d3, h3, h4, i6, z4);
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

    private static void o(ParsableNalUnitBitArray parsableNalUnitBitArray, int i2) {
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

    private static void p(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        boolean z2;
        int h2 = parsableNalUnitBitArray.h();
        int[] iArr = new int[0];
        int[] iArr2 = new int[0];
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < h2; i4++) {
            if (i4 == 0 || !parsableNalUnitBitArray.d()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                int i5 = i2 + i3;
                int h3 = (1 - ((parsableNalUnitBitArray.d() ? 1 : 0) * true)) * (parsableNalUnitBitArray.h() + 1);
                int i6 = i5 + 1;
                boolean[] zArr = new boolean[i6];
                for (int i7 = 0; i7 <= i5; i7++) {
                    if (!parsableNalUnitBitArray.d()) {
                        zArr[i7] = parsableNalUnitBitArray.d();
                    } else {
                        zArr[i7] = true;
                    }
                }
                int[] iArr3 = new int[i6];
                int[] iArr4 = new int[i6];
                int i8 = 0;
                for (int i9 = i3 - 1; i9 >= 0; i9--) {
                    int i10 = iArr2[i9] + h3;
                    if (i10 < 0 && zArr[i2 + i9]) {
                        iArr3[i8] = i10;
                        i8++;
                    }
                }
                if (h3 < 0 && zArr[i5]) {
                    iArr3[i8] = h3;
                    i8++;
                }
                for (int i11 = 0; i11 < i2; i11++) {
                    int i12 = iArr[i11] + h3;
                    if (i12 < 0 && zArr[i11]) {
                        iArr3[i8] = i12;
                        i8++;
                    }
                }
                int[] copyOf = Arrays.copyOf(iArr3, i8);
                int i13 = 0;
                for (int i14 = i2 - 1; i14 >= 0; i14--) {
                    int i15 = iArr[i14] + h3;
                    if (i15 > 0 && zArr[i14]) {
                        iArr4[i13] = i15;
                        i13++;
                    }
                }
                if (h3 > 0 && zArr[i5]) {
                    iArr4[i13] = h3;
                    i13++;
                }
                for (int i16 = 0; i16 < i3; i16++) {
                    int i17 = iArr2[i16] + h3;
                    if (i17 > 0 && zArr[i2 + i16]) {
                        iArr4[i13] = i17;
                        i13++;
                    }
                }
                iArr2 = Arrays.copyOf(iArr4, i13);
                iArr = copyOf;
                i2 = i8;
                i3 = i13;
            } else {
                int h4 = parsableNalUnitBitArray.h();
                int h5 = parsableNalUnitBitArray.h();
                int[] iArr5 = new int[h4];
                for (int i18 = 0; i18 < h4; i18++) {
                    iArr5[i18] = parsableNalUnitBitArray.h() + 1;
                    parsableNalUnitBitArray.k();
                }
                int[] iArr6 = new int[h5];
                for (int i19 = 0; i19 < h5; i19++) {
                    iArr6[i19] = parsableNalUnitBitArray.h() + 1;
                    parsableNalUnitBitArray.k();
                }
                int[] iArr7 = iArr5;
                i2 = h4;
                iArr = iArr7;
                int[] iArr8 = iArr6;
                i3 = h5;
                iArr2 = iArr8;
            }
        }
    }

    public static int q(byte[] bArr, int i2) {
        int i3;
        synchronized (f28718c) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < i2) {
                try {
                    i4 = d(bArr, i4, i2);
                    if (i4 < i2) {
                        int[] iArr = f28719d;
                        if (iArr.length <= i5) {
                            f28719d = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        f28719d[i5] = i4;
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
                int i9 = f28719d[i8] - i7;
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
