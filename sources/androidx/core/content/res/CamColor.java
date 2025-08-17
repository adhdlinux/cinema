package androidx.core.content.res;

import androidx.core.graphics.ColorUtils;

class CamColor {

    /* renamed from: a  reason: collision with root package name */
    private final float f2484a;

    /* renamed from: b  reason: collision with root package name */
    private final float f2485b;

    /* renamed from: c  reason: collision with root package name */
    private final float f2486c;

    /* renamed from: d  reason: collision with root package name */
    private final float f2487d;

    /* renamed from: e  reason: collision with root package name */
    private final float f2488e;

    /* renamed from: f  reason: collision with root package name */
    private final float f2489f;

    /* renamed from: g  reason: collision with root package name */
    private final float f2490g;

    /* renamed from: h  reason: collision with root package name */
    private final float f2491h;

    /* renamed from: i  reason: collision with root package name */
    private final float f2492i;

    CamColor(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.f2484a = f2;
        this.f2485b = f3;
        this.f2486c = f4;
        this.f2487d = f5;
        this.f2488e = f6;
        this.f2489f = f7;
        this.f2490g = f8;
        this.f2491h = f9;
        this.f2492i = f10;
    }

    private static CamColor b(float f2, float f3, float f4) {
        float f5 = 100.0f;
        float f6 = 1000.0f;
        CamColor camColor = null;
        float f7 = 1000.0f;
        float f8 = 0.0f;
        while (Math.abs(f8 - f5) > 0.01f) {
            float f9 = ((f5 - f8) / 2.0f) + f8;
            int p2 = e(f9, f3, f2).p();
            float b2 = CamUtils.b(p2);
            float abs = Math.abs(f4 - b2);
            if (abs < 0.2f) {
                CamColor c2 = c(p2);
                float a2 = c2.a(e(c2.k(), c2.i(), f2));
                if (a2 <= 1.0f) {
                    camColor = c2;
                    f6 = abs;
                    f7 = a2;
                }
            }
            if (f6 == 0.0f && f7 == 0.0f) {
                break;
            } else if (b2 < f4) {
                f8 = f9;
            } else {
                f5 = f9;
            }
        }
        return camColor;
    }

    static CamColor c(int i2) {
        return d(i2, ViewingConditions.f2525k);
    }

    static CamColor d(int i2, ViewingConditions viewingConditions) {
        float f2;
        float[] f3 = CamUtils.f(i2);
        float[][] fArr = CamUtils.f2493a;
        float f4 = f3[0];
        float[] fArr2 = fArr[0];
        float f5 = f3[1];
        float f6 = f3[2];
        float f7 = (fArr2[0] * f4) + (fArr2[1] * f5) + (fArr2[2] * f6);
        float[] fArr3 = fArr[1];
        float f8 = (fArr3[0] * f4) + (fArr3[1] * f5) + (fArr3[2] * f6);
        float[] fArr4 = fArr[2];
        float f9 = (f4 * fArr4[0]) + (f5 * fArr4[1]) + (f6 * fArr4[2]);
        float f10 = viewingConditions.i()[0] * f7;
        float f11 = viewingConditions.i()[1] * f8;
        float f12 = viewingConditions.i()[2] * f9;
        float pow = (float) Math.pow(((double) (viewingConditions.c() * Math.abs(f10))) / 100.0d, 0.42d);
        float pow2 = (float) Math.pow(((double) (viewingConditions.c() * Math.abs(f11))) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow(((double) (viewingConditions.c() * Math.abs(f12))) / 100.0d, 0.42d);
        float signum = ((Math.signum(f10) * 400.0f) * pow) / (pow + 27.13f);
        float signum2 = ((Math.signum(f11) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum3 = ((Math.signum(f12) * 400.0f) * pow3) / (pow3 + 27.13f);
        double d2 = (double) signum3;
        float f13 = ((float) (((((double) signum) * 11.0d) + (((double) signum2) * -12.0d)) + d2)) / 11.0f;
        float f14 = ((float) (((double) (signum + signum2)) - (d2 * 2.0d))) / 9.0f;
        float f15 = signum2 * 20.0f;
        float f16 = (((signum * 20.0f) + f15) + (21.0f * signum3)) / 20.0f;
        float f17 = (((signum * 40.0f) + f15) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2((double) f14, (double) f13)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f18 = atan2;
        float f19 = (3.1415927f * f18) / 180.0f;
        float pow4 = ((float) Math.pow((double) ((f17 * viewingConditions.f()) / viewingConditions.a()), (double) (viewingConditions.b() * viewingConditions.j()))) * 100.0f;
        float d3 = viewingConditions.d() * (4.0f / viewingConditions.b()) * ((float) Math.sqrt((double) (pow4 / 100.0f))) * (viewingConditions.a() + 4.0f);
        if (((double) f18) < 20.14d) {
            f2 = 360.0f + f18;
        } else {
            f2 = f18;
        }
        float pow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, (double) viewingConditions.e()), 0.73d)) * ((float) Math.pow((double) ((((((((float) (Math.cos(((((double) f2) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * viewingConditions.g()) * viewingConditions.h()) * ((float) Math.sqrt((double) ((f13 * f13) + (f14 * f14))))) / (f16 + 0.305f)), 0.9d));
        float sqrt = pow5 * ((float) Math.sqrt(((double) pow4) / 100.0d));
        float d4 = sqrt * viewingConditions.d();
        float sqrt2 = ((float) Math.sqrt((double) ((pow5 * viewingConditions.b()) / (viewingConditions.a() + 4.0f)))) * 50.0f;
        float f20 = (1.7f * pow4) / ((0.007f * pow4) + 1.0f);
        float log = ((float) Math.log((double) ((0.0228f * d4) + 1.0f))) * 43.85965f;
        double d5 = (double) f19;
        return new CamColor(f18, sqrt, pow4, d3, d4, sqrt2, f20, log * ((float) Math.cos(d5)), log * ((float) Math.sin(d5)));
    }

    private static CamColor e(float f2, float f3, float f4) {
        return f(f2, f3, f4, ViewingConditions.f2525k);
    }

    private static CamColor f(float f2, float f3, float f4, ViewingConditions viewingConditions) {
        float f5 = f2;
        double d2 = ((double) f5) / 100.0d;
        float b2 = (4.0f / viewingConditions.b()) * ((float) Math.sqrt(d2)) * (viewingConditions.a() + 4.0f) * viewingConditions.d();
        float d3 = f3 * viewingConditions.d();
        float sqrt = ((float) Math.sqrt((double) (((f3 / ((float) Math.sqrt(d2))) * viewingConditions.b()) / (viewingConditions.a() + 4.0f)))) * 50.0f;
        float f6 = (1.7f * f5) / ((0.007f * f5) + 1.0f);
        float log = ((float) Math.log((((double) d3) * 0.0228d) + 1.0d)) * 43.85965f;
        double d4 = (double) ((3.1415927f * f4) / 180.0f);
        return new CamColor(f4, f3, f5, b2, d3, sqrt, f6, log * ((float) Math.cos(d4)), log * ((float) Math.sin(d4)));
    }

    static int m(float f2, float f3, float f4) {
        return n(f2, f3, f4, ViewingConditions.f2525k);
    }

    static int n(float f2, float f3, float f4, ViewingConditions viewingConditions) {
        float f5;
        if (((double) f3) < 1.0d || ((double) Math.round(f4)) <= 0.0d || ((double) Math.round(f4)) >= 100.0d) {
            return CamUtils.a(f4);
        }
        if (f2 < 0.0f) {
            f5 = 0.0f;
        } else {
            f5 = Math.min(360.0f, f2);
        }
        float f6 = f3;
        CamColor camColor = null;
        float f7 = 0.0f;
        boolean z2 = true;
        while (Math.abs(f7 - f3) >= 0.4f) {
            CamColor b2 = b(f5, f6, f4);
            if (!z2) {
                if (b2 == null) {
                    f3 = f6;
                } else {
                    f7 = f6;
                    camColor = b2;
                }
                f6 = ((f3 - f7) / 2.0f) + f7;
            } else if (b2 != null) {
                return b2.o(viewingConditions);
            } else {
                f6 = ((f3 - f7) / 2.0f) + f7;
                z2 = false;
            }
        }
        if (camColor == null) {
            return CamUtils.a(f4);
        }
        return camColor.o(viewingConditions);
    }

    /* access modifiers changed from: package-private */
    public float a(CamColor camColor) {
        float l2 = l() - camColor.l();
        float g2 = g() - camColor.g();
        float h2 = h() - camColor.h();
        return (float) (Math.pow(Math.sqrt((double) ((l2 * l2) + (g2 * g2) + (h2 * h2))), 0.63d) * 1.41d);
    }

    /* access modifiers changed from: package-private */
    public float g() {
        return this.f2491h;
    }

    /* access modifiers changed from: package-private */
    public float h() {
        return this.f2492i;
    }

    /* access modifiers changed from: package-private */
    public float i() {
        return this.f2485b;
    }

    /* access modifiers changed from: package-private */
    public float j() {
        return this.f2484a;
    }

    /* access modifiers changed from: package-private */
    public float k() {
        return this.f2486c;
    }

    /* access modifiers changed from: package-private */
    public float l() {
        return this.f2490g;
    }

    /* access modifiers changed from: package-private */
    public int o(ViewingConditions viewingConditions) {
        float f2;
        if (((double) i()) == 0.0d || ((double) k()) == 0.0d) {
            f2 = 0.0f;
        } else {
            f2 = i() / ((float) Math.sqrt(((double) k()) / 100.0d));
        }
        float pow = (float) Math.pow(((double) f2) / Math.pow(1.64d - Math.pow(0.29d, (double) viewingConditions.e()), 0.73d), 1.1111111111111112d);
        double j2 = (double) ((j() * 3.1415927f) / 180.0f);
        float a2 = viewingConditions.a() * ((float) Math.pow(((double) k()) / 100.0d, (1.0d / ((double) viewingConditions.b())) / ((double) viewingConditions.j())));
        float cos = ((float) (Math.cos(2.0d + j2) + 3.8d)) * 0.25f * 3846.1538f * viewingConditions.g() * viewingConditions.h();
        float f3 = a2 / viewingConditions.f();
        float sin = (float) Math.sin(j2);
        float cos2 = (float) Math.cos(j2);
        float f4 = (((0.305f + f3) * 23.0f) * pow) / (((cos * 23.0f) + ((11.0f * pow) * cos2)) + ((pow * 108.0f) * sin));
        float f5 = cos2 * f4;
        float f6 = f4 * sin;
        float f7 = f3 * 460.0f;
        float f8 = (((451.0f * f5) + f7) + (288.0f * f6)) / 1403.0f;
        float f9 = ((f7 - (891.0f * f5)) - (261.0f * f6)) / 1403.0f;
        float f10 = ((f7 - (f5 * 220.0f)) - (f6 * 6300.0f)) / 1403.0f;
        float signum = Math.signum(f8) * (100.0f / viewingConditions.c()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f8)) * 27.13d) / (400.0d - ((double) Math.abs(f8))))), 2.380952380952381d));
        float signum2 = Math.signum(f9) * (100.0f / viewingConditions.c()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f9)) * 27.13d) / (400.0d - ((double) Math.abs(f9))))), 2.380952380952381d));
        float signum3 = Math.signum(f10) * (100.0f / viewingConditions.c()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f10)) * 27.13d) / (400.0d - ((double) Math.abs(f10))))), 2.380952380952381d));
        float f11 = signum / viewingConditions.i()[0];
        float f12 = signum2 / viewingConditions.i()[1];
        float f13 = signum3 / viewingConditions.i()[2];
        float[][] fArr = CamUtils.f2494b;
        float[] fArr2 = fArr[0];
        float f14 = (fArr2[0] * f11) + (fArr2[1] * f12) + (fArr2[2] * f13);
        float[] fArr3 = fArr[1];
        float[] fArr4 = fArr[2];
        return ColorUtils.c((double) f14, (double) ((fArr3[0] * f11) + (fArr3[1] * f12) + (fArr3[2] * f13)), (double) ((f11 * fArr4[0]) + (f12 * fArr4[1]) + (f13 * fArr4[2])));
    }

    /* access modifiers changed from: package-private */
    public int p() {
        return o(ViewingConditions.f2525k);
    }
}
