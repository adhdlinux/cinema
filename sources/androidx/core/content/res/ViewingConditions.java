package androidx.core.content.res;

final class ViewingConditions {

    /* renamed from: k  reason: collision with root package name */
    static final ViewingConditions f2525k = k(CamUtils.f2495c, (float) ((((double) CamUtils.h(50.0f)) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);

    /* renamed from: a  reason: collision with root package name */
    private final float f2526a;

    /* renamed from: b  reason: collision with root package name */
    private final float f2527b;

    /* renamed from: c  reason: collision with root package name */
    private final float f2528c;

    /* renamed from: d  reason: collision with root package name */
    private final float f2529d;

    /* renamed from: e  reason: collision with root package name */
    private final float f2530e;

    /* renamed from: f  reason: collision with root package name */
    private final float f2531f;

    /* renamed from: g  reason: collision with root package name */
    private final float[] f2532g;

    /* renamed from: h  reason: collision with root package name */
    private final float f2533h;

    /* renamed from: i  reason: collision with root package name */
    private final float f2534i;

    /* renamed from: j  reason: collision with root package name */
    private final float f2535j;

    private ViewingConditions(float f2, float f3, float f4, float f5, float f6, float f7, float[] fArr, float f8, float f9, float f10) {
        this.f2531f = f2;
        this.f2526a = f3;
        this.f2527b = f4;
        this.f2528c = f5;
        this.f2529d = f6;
        this.f2530e = f7;
        this.f2532g = fArr;
        this.f2533h = f8;
        this.f2534i = f9;
        this.f2535j = f10;
    }

    static ViewingConditions k(float[] fArr, float f2, float f3, float f4, boolean z2) {
        float f5;
        float f6;
        float f7 = f2;
        float[][] fArr2 = CamUtils.f2493a;
        float f8 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f9 = fArr[1];
        float f10 = fArr[2];
        float f11 = (fArr3[0] * f8) + (fArr3[1] * f9) + (fArr3[2] * f10);
        float[] fArr4 = fArr2[1];
        float f12 = (fArr4[0] * f8) + (fArr4[1] * f9) + (fArr4[2] * f10);
        float[] fArr5 = fArr2[2];
        float f13 = (f8 * fArr5[0]) + (f9 * fArr5[1]) + (f10 * fArr5[2]);
        float f14 = (f4 / 10.0f) + 0.8f;
        if (((double) f14) >= 0.9d) {
            f5 = CamUtils.d(0.59f, 0.69f, (f14 - 0.9f) * 10.0f);
        } else {
            f5 = CamUtils.d(0.525f, 0.59f, (f14 - 0.8f) * 10.0f);
        }
        float f15 = f5;
        if (z2) {
            f6 = 1.0f;
        } else {
            f6 = (1.0f - (((float) Math.exp((double) (((-f7) - 42.0f) / 92.0f))) * 0.2777778f)) * f14;
        }
        double d2 = (double) f6;
        if (d2 > 1.0d) {
            f6 = 1.0f;
        } else if (d2 < 0.0d) {
            f6 = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f11) * f6) + 1.0f) - f6, (((100.0f / f12) * f6) + 1.0f) - f6, (((100.0f / f13) * f6) + 1.0f) - f6};
        float f16 = 1.0f / ((5.0f * f7) + 1.0f);
        float f17 = f16 * f16 * f16 * f16;
        float f18 = 1.0f - f17;
        float cbrt = (f17 * f7) + (0.1f * f18 * f18 * ((float) Math.cbrt(((double) f7) * 5.0d)));
        float h2 = CamUtils.h(f3) / fArr[1];
        double d3 = (double) h2;
        float sqrt = ((float) Math.sqrt(d3)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d3, 0.2d));
        float pow2 = (float) Math.pow(((double) ((fArr6[2] * cbrt) * f13)) / 100.0d, 0.42d);
        float[] fArr7 = {(float) Math.pow(((double) ((fArr6[0] * cbrt) * f11)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[1] * cbrt) * f12)) / 100.0d, 0.42d), pow2};
        float f19 = fArr7[0];
        float f20 = fArr7[1];
        return new ViewingConditions(h2, ((((f19 * 400.0f) / (f19 + 27.13f)) * 2.0f) + ((f20 * 400.0f) / (f20 + 27.13f)) + (((400.0f * pow2) / (pow2 + 27.13f)) * 0.05f)) * pow, pow, pow, f15, f14, fArr6, cbrt, (float) Math.pow((double) cbrt, 0.25d), sqrt);
    }

    /* access modifiers changed from: package-private */
    public float a() {
        return this.f2526a;
    }

    /* access modifiers changed from: package-private */
    public float b() {
        return this.f2529d;
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.f2533h;
    }

    /* access modifiers changed from: package-private */
    public float d() {
        return this.f2534i;
    }

    /* access modifiers changed from: package-private */
    public float e() {
        return this.f2531f;
    }

    /* access modifiers changed from: package-private */
    public float f() {
        return this.f2527b;
    }

    /* access modifiers changed from: package-private */
    public float g() {
        return this.f2530e;
    }

    /* access modifiers changed from: package-private */
    public float h() {
        return this.f2528c;
    }

    /* access modifiers changed from: package-private */
    public float[] i() {
        return this.f2532g;
    }

    /* access modifiers changed from: package-private */
    public float j() {
        return this.f2535j;
    }
}
