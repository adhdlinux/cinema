package com.google.android.material.bottomappbar;

import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

public class BottomAppBarTopEdgeTreatment extends EdgeTreatment {

    /* renamed from: a  reason: collision with root package name */
    private float f29539a;

    /* renamed from: b  reason: collision with root package name */
    private float f29540b;

    /* renamed from: c  reason: collision with root package name */
    private float f29541c;

    /* renamed from: d  reason: collision with root package name */
    private float f29542d;

    /* renamed from: e  reason: collision with root package name */
    private float f29543e;

    public BottomAppBarTopEdgeTreatment(float f2, float f3, float f4) {
        this.f29540b = f2;
        this.f29539a = f3;
        this.f29542d = f4;
        if (f4 >= 0.0f) {
            this.f29543e = 0.0f;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public void a(float f2, float f3, ShapePath shapePath) {
        float f4 = f2;
        ShapePath shapePath2 = shapePath;
        float f5 = this.f29541c;
        if (f5 == 0.0f) {
            shapePath2.c(f4, 0.0f);
            return;
        }
        float f6 = ((this.f29540b * 2.0f) + f5) / 2.0f;
        float f7 = f3 * this.f29539a;
        float f8 = (f4 / 2.0f) + this.f29543e;
        float f9 = (this.f29542d * f3) + ((1.0f - f3) * f6);
        if (f9 / f6 >= 1.0f) {
            shapePath2.c(f4, 0.0f);
            return;
        }
        float f10 = f6 + f7;
        float f11 = f9 + f7;
        float sqrt = (float) Math.sqrt((double) ((f10 * f10) - (f11 * f11)));
        float f12 = f8 - sqrt;
        float f13 = f8 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan((double) (sqrt / f11)));
        float f14 = 90.0f - degrees;
        float f15 = f12 - f7;
        shapePath2.c(f15, 0.0f);
        float f16 = f7 * 2.0f;
        float f17 = degrees;
        shapePath.a(f15, 0.0f, f12 + f7, f16, 270.0f, degrees);
        shapePath.a(f8 - f6, (-f6) - f9, f8 + f6, f6 - f9, 180.0f - f14, (f14 * 2.0f) - 180.0f);
        shapePath.a(f13 - f7, 0.0f, f13 + f7, f16, 270.0f - f17, f17);
        shapePath2.c(f4, 0.0f);
    }

    /* access modifiers changed from: package-private */
    public float b() {
        return this.f29542d;
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.f29540b;
    }

    /* access modifiers changed from: package-private */
    public float d() {
        return this.f29539a;
    }

    /* access modifiers changed from: package-private */
    public float e() {
        return this.f29541c;
    }

    /* access modifiers changed from: package-private */
    public float f() {
        return this.f29543e;
    }

    /* access modifiers changed from: package-private */
    public void g(float f2) {
        this.f29542d = f2;
    }

    /* access modifiers changed from: package-private */
    public void h(float f2) {
        this.f29540b = f2;
    }

    /* access modifiers changed from: package-private */
    public void i(float f2) {
        this.f29539a = f2;
    }

    /* access modifiers changed from: package-private */
    public void j(float f2) {
        this.f29541c = f2;
    }

    /* access modifiers changed from: package-private */
    public void k(float f2) {
        this.f29543e = f2;
    }
}
