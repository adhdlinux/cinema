package com.flask.colorpicker;

import android.graphics.Color;

public class ColorCircle {

    /* renamed from: a  reason: collision with root package name */
    private float f21910a;

    /* renamed from: b  reason: collision with root package name */
    private float f21911b;

    /* renamed from: c  reason: collision with root package name */
    private float[] f21912c = new float[3];

    /* renamed from: d  reason: collision with root package name */
    private float[] f21913d;

    /* renamed from: e  reason: collision with root package name */
    private int f21914e;

    public ColorCircle(float f2, float f3, float[] fArr) {
        f(f2, f3, fArr);
    }

    public int a() {
        return this.f21914e;
    }

    public float[] b() {
        return this.f21912c;
    }

    public float[] c(float f2) {
        if (this.f21913d == null) {
            this.f21913d = (float[]) this.f21912c.clone();
        }
        float[] fArr = this.f21913d;
        float[] fArr2 = this.f21912c;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        fArr[2] = f2;
        return fArr;
    }

    public float d() {
        return this.f21910a;
    }

    public float e() {
        return this.f21911b;
    }

    public void f(float f2, float f3, float[] fArr) {
        this.f21910a = f2;
        this.f21911b = f3;
        float[] fArr2 = this.f21912c;
        fArr2[0] = fArr[0];
        fArr2[1] = fArr[1];
        fArr2[2] = fArr[2];
        this.f21914e = Color.HSVToColor(fArr2);
    }

    public double g(float f2, float f3) {
        double d2 = (double) (this.f21910a - f2);
        double d3 = (double) (this.f21911b - f3);
        return (d2 * d2) + (d3 * d3);
    }
}
