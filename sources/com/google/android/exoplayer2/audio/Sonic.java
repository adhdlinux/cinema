package com.google.android.exoplayer2.audio;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ShortBuffer;
import java.util.Arrays;

final class Sonic {

    /* renamed from: a  reason: collision with root package name */
    private final int f23856a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23857b;

    /* renamed from: c  reason: collision with root package name */
    private final float f23858c;

    /* renamed from: d  reason: collision with root package name */
    private final float f23859d;

    /* renamed from: e  reason: collision with root package name */
    private final float f23860e;

    /* renamed from: f  reason: collision with root package name */
    private final int f23861f;

    /* renamed from: g  reason: collision with root package name */
    private final int f23862g;

    /* renamed from: h  reason: collision with root package name */
    private final int f23863h;

    /* renamed from: i  reason: collision with root package name */
    private final short[] f23864i;

    /* renamed from: j  reason: collision with root package name */
    private short[] f23865j;

    /* renamed from: k  reason: collision with root package name */
    private int f23866k;

    /* renamed from: l  reason: collision with root package name */
    private short[] f23867l;

    /* renamed from: m  reason: collision with root package name */
    private int f23868m;

    /* renamed from: n  reason: collision with root package name */
    private short[] f23869n;

    /* renamed from: o  reason: collision with root package name */
    private int f23870o;

    /* renamed from: p  reason: collision with root package name */
    private int f23871p;

    /* renamed from: q  reason: collision with root package name */
    private int f23872q;

    /* renamed from: r  reason: collision with root package name */
    private int f23873r;

    /* renamed from: s  reason: collision with root package name */
    private int f23874s;

    /* renamed from: t  reason: collision with root package name */
    private int f23875t;

    /* renamed from: u  reason: collision with root package name */
    private int f23876u;

    /* renamed from: v  reason: collision with root package name */
    private int f23877v;

    public Sonic(int i2, int i3, float f2, float f3, int i4) {
        this.f23856a = i2;
        this.f23857b = i3;
        this.f23858c = f2;
        this.f23859d = f3;
        this.f23860e = ((float) i2) / ((float) i4);
        this.f23861f = i2 / 400;
        int i5 = i2 / 65;
        this.f23862g = i5;
        int i6 = i5 * 2;
        this.f23863h = i6;
        this.f23864i = new short[i6];
        this.f23865j = new short[(i6 * i3)];
        this.f23867l = new short[(i6 * i3)];
        this.f23869n = new short[(i6 * i3)];
    }

    private void a(float f2, int i2) {
        int i3;
        int i4;
        if (this.f23868m != i2) {
            int i5 = this.f23856a;
            int i6 = (int) (((float) i5) / f2);
            while (true) {
                if (i6 <= 16384 && i5 <= 16384) {
                    break;
                }
                i6 /= 2;
                i5 /= 2;
            }
            o(i2);
            int i7 = 0;
            while (true) {
                int i8 = this.f23870o;
                boolean z2 = true;
                if (i7 < i8 - 1) {
                    while (true) {
                        i3 = this.f23871p;
                        int i9 = (i3 + 1) * i6;
                        i4 = this.f23872q;
                        if (i9 <= i4 * i5) {
                            break;
                        }
                        this.f23867l = f(this.f23867l, this.f23868m, 1);
                        int i10 = 0;
                        while (true) {
                            int i11 = this.f23857b;
                            if (i10 >= i11) {
                                break;
                            }
                            this.f23867l[(this.f23868m * i11) + i10] = n(this.f23869n, (i11 * i7) + i10, i5, i6);
                            i10++;
                        }
                        this.f23872q++;
                        this.f23868m++;
                    }
                    int i12 = i3 + 1;
                    this.f23871p = i12;
                    if (i12 == i5) {
                        this.f23871p = 0;
                        if (i4 != i6) {
                            z2 = false;
                        }
                        Assertions.g(z2);
                        this.f23872q = 0;
                    }
                    i7++;
                } else {
                    u(i8 - 1);
                    return;
                }
            }
        }
    }

    private void b(float f2) {
        int m2;
        int i2 = this.f23866k;
        if (i2 >= this.f23863h) {
            int i3 = 0;
            do {
                if (this.f23873r > 0) {
                    m2 = c(i3);
                } else {
                    int g2 = g(this.f23865j, i3);
                    if (((double) f2) > 1.0d) {
                        m2 = g2 + w(this.f23865j, i3, f2, g2);
                    } else {
                        m2 = m(this.f23865j, i3, f2, g2);
                    }
                }
                i3 += m2;
            } while (this.f23863h + i3 <= i2);
            v(i3);
        }
    }

    private int c(int i2) {
        int min = Math.min(this.f23863h, this.f23873r);
        d(this.f23865j, i2, min);
        this.f23873r -= min;
        return min;
    }

    private void d(short[] sArr, int i2, int i3) {
        short[] f2 = f(this.f23867l, this.f23868m, i3);
        this.f23867l = f2;
        int i4 = this.f23857b;
        System.arraycopy(sArr, i2 * i4, f2, this.f23868m * i4, i4 * i3);
        this.f23868m += i3;
    }

    private void e(short[] sArr, int i2, int i3) {
        int i4 = this.f23863h / i3;
        int i5 = this.f23857b;
        int i6 = i3 * i5;
        int i7 = i2 * i5;
        for (int i8 = 0; i8 < i4; i8++) {
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                i9 += sArr[(i8 * i6) + i7 + i10];
            }
            this.f23864i[i8] = (short) (i9 / i6);
        }
    }

    private short[] f(short[] sArr, int i2, int i3) {
        int length = sArr.length;
        int i4 = this.f23857b;
        int i5 = length / i4;
        if (i2 + i3 <= i5) {
            return sArr;
        }
        return Arrays.copyOf(sArr, (((i5 * 3) / 2) + i3) * i4);
    }

    private int g(short[] sArr, int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = this.f23856a;
        if (i6 > 4000) {
            i3 = i6 / 4000;
        } else {
            i3 = 1;
        }
        if (this.f23857b == 1 && i3 == 1) {
            i4 = h(sArr, i2, this.f23861f, this.f23862g);
        } else {
            e(sArr, i2, i3);
            int h2 = h(this.f23864i, 0, this.f23861f / i3, this.f23862g / i3);
            if (i3 != 1) {
                int i7 = h2 * i3;
                int i8 = i3 * 4;
                int i9 = i7 - i8;
                int i10 = i7 + i8;
                int i11 = this.f23861f;
                if (i9 < i11) {
                    i9 = i11;
                }
                int i12 = this.f23862g;
                if (i10 > i12) {
                    i10 = i12;
                }
                if (this.f23857b == 1) {
                    i4 = h(sArr, i2, i9, i10);
                } else {
                    e(sArr, i2, 1);
                    i4 = h(this.f23864i, 0, i9, i10);
                }
            } else {
                i4 = h2;
            }
        }
        if (q(this.f23876u, this.f23877v)) {
            i5 = this.f23874s;
        } else {
            i5 = i4;
        }
        this.f23875t = this.f23876u;
        this.f23874s = i4;
        return i5;
    }

    private int h(short[] sArr, int i2, int i3, int i4) {
        int i5 = i2 * this.f23857b;
        int i6 = JfifUtil.MARKER_FIRST_BYTE;
        int i7 = 1;
        int i8 = 0;
        int i9 = 0;
        while (i3 <= i4) {
            int i10 = 0;
            for (int i11 = 0; i11 < i3; i11++) {
                i10 += Math.abs(sArr[i5 + i11] - sArr[(i5 + i3) + i11]);
            }
            if (i10 * i8 < i7 * i3) {
                i8 = i3;
                i7 = i10;
            }
            if (i10 * i6 > i9 * i3) {
                i6 = i3;
                i9 = i10;
            }
            i3++;
        }
        this.f23876u = i7 / i8;
        this.f23877v = i9 / i6;
        return i8;
    }

    private int m(short[] sArr, int i2, float f2, int i3) {
        int i4;
        if (f2 < 0.5f) {
            i4 = (int) ((((float) i3) * f2) / (1.0f - f2));
        } else {
            this.f23873r = (int) ((((float) i3) * ((2.0f * f2) - 1.0f)) / (1.0f - f2));
            i4 = i3;
        }
        int i5 = i3 + i4;
        short[] f3 = f(this.f23867l, this.f23868m, i5);
        this.f23867l = f3;
        int i6 = this.f23857b;
        System.arraycopy(sArr, i2 * i6, f3, this.f23868m * i6, i6 * i3);
        p(i4, this.f23857b, this.f23867l, this.f23868m + i3, sArr, i2 + i3, sArr, i2);
        this.f23868m += i5;
        return i4;
    }

    private short n(short[] sArr, int i2, int i3, int i4) {
        short s2 = sArr[i2];
        short s3 = sArr[i2 + this.f23857b];
        int i5 = this.f23872q * i3;
        int i6 = this.f23871p;
        int i7 = i6 * i4;
        int i8 = (i6 + 1) * i4;
        int i9 = i8 - i5;
        int i10 = i8 - i7;
        return (short) (((s2 * i9) + ((i10 - i9) * s3)) / i10);
    }

    private void o(int i2) {
        int i3 = this.f23868m - i2;
        short[] f2 = f(this.f23869n, this.f23870o, i3);
        this.f23869n = f2;
        short[] sArr = this.f23867l;
        int i4 = this.f23857b;
        System.arraycopy(sArr, i2 * i4, f2, this.f23870o * i4, i4 * i3);
        this.f23868m = i2;
        this.f23870o += i3;
    }

    private static void p(int i2, int i3, short[] sArr, int i4, short[] sArr2, int i5, short[] sArr3, int i6) {
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = (i4 * i3) + i7;
            int i9 = (i6 * i3) + i7;
            int i10 = (i5 * i3) + i7;
            for (int i11 = 0; i11 < i2; i11++) {
                sArr[i8] = (short) (((sArr2[i10] * (i2 - i11)) + (sArr3[i9] * i11)) / i2);
                i8 += i3;
                i10 += i3;
                i9 += i3;
            }
        }
    }

    private boolean q(int i2, int i3) {
        if (i2 == 0 || this.f23874s == 0 || i3 > i2 * 3 || i2 * 2 <= this.f23875t * 3) {
            return false;
        }
        return true;
    }

    private void r() {
        int i2 = this.f23868m;
        float f2 = this.f23858c;
        float f3 = this.f23859d;
        float f4 = f2 / f3;
        float f5 = this.f23860e * f3;
        double d2 = (double) f4;
        if (d2 > 1.00001d || d2 < 0.99999d) {
            b(f4);
        } else {
            d(this.f23865j, 0, this.f23866k);
            this.f23866k = 0;
        }
        if (f5 != 1.0f) {
            a(f5, i2);
        }
    }

    private void u(int i2) {
        if (i2 != 0) {
            short[] sArr = this.f23869n;
            int i3 = this.f23857b;
            System.arraycopy(sArr, i2 * i3, sArr, 0, (this.f23870o - i2) * i3);
            this.f23870o -= i2;
        }
    }

    private void v(int i2) {
        int i3 = this.f23866k - i2;
        short[] sArr = this.f23865j;
        int i4 = this.f23857b;
        System.arraycopy(sArr, i2 * i4, sArr, 0, i4 * i3);
        this.f23866k = i3;
    }

    private int w(short[] sArr, int i2, float f2, int i3) {
        int i4;
        if (f2 >= 2.0f) {
            i4 = (int) (((float) i3) / (f2 - 1.0f));
        } else {
            this.f23873r = (int) ((((float) i3) * (2.0f - f2)) / (f2 - 1.0f));
            i4 = i3;
        }
        short[] f3 = f(this.f23867l, this.f23868m, i4);
        this.f23867l = f3;
        p(i4, this.f23857b, f3, this.f23868m, sArr, i2, sArr, i2 + i3);
        this.f23868m += i4;
        return i4;
    }

    public void i() {
        this.f23866k = 0;
        this.f23868m = 0;
        this.f23870o = 0;
        this.f23871p = 0;
        this.f23872q = 0;
        this.f23873r = 0;
        this.f23874s = 0;
        this.f23875t = 0;
        this.f23876u = 0;
        this.f23877v = 0;
    }

    public void j(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.f23857b, this.f23868m);
        shortBuffer.put(this.f23867l, 0, this.f23857b * min);
        int i2 = this.f23868m - min;
        this.f23868m = i2;
        short[] sArr = this.f23867l;
        int i3 = this.f23857b;
        System.arraycopy(sArr, min * i3, sArr, 0, i2 * i3);
    }

    public int k() {
        return this.f23868m * this.f23857b * 2;
    }

    public int l() {
        return this.f23866k * this.f23857b * 2;
    }

    public void s() {
        int i2;
        int i3 = this.f23866k;
        float f2 = this.f23858c;
        float f3 = this.f23859d;
        int i4 = this.f23868m + ((int) ((((((float) i3) / (f2 / f3)) + ((float) this.f23870o)) / (this.f23860e * f3)) + 0.5f));
        this.f23865j = f(this.f23865j, i3, (this.f23863h * 2) + i3);
        int i5 = 0;
        while (true) {
            i2 = this.f23863h;
            int i6 = this.f23857b;
            if (i5 >= i2 * 2 * i6) {
                break;
            }
            this.f23865j[(i6 * i3) + i5] = 0;
            i5++;
        }
        this.f23866k += i2 * 2;
        r();
        if (this.f23868m > i4) {
            this.f23868m = i4;
        }
        this.f23866k = 0;
        this.f23873r = 0;
        this.f23870o = 0;
    }

    public void t(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i2 = this.f23857b;
        int i3 = remaining / i2;
        short[] f2 = f(this.f23865j, this.f23866k, i3);
        this.f23865j = f2;
        shortBuffer.get(f2, this.f23866k * this.f23857b, ((i2 * i3) * 2) / 2);
        this.f23866k += i3;
        r();
    }
}
