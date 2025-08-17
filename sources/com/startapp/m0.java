package com.startapp;

public class m0 implements p0 {

    /* renamed from: a  reason: collision with root package name */
    public final double f34891a;

    /* renamed from: b  reason: collision with root package name */
    public final double f34892b;

    /* renamed from: c  reason: collision with root package name */
    public double f34893c;

    public m0(double d2) {
        double d3 = d2 + 1.0d;
        this.f34891a = d2 / d3;
        this.f34892b = 1.0d / d3;
    }

    public void a(double d2) {
        this.f34893c = (this.f34891a * this.f34893c) + (d2 * this.f34892b);
    }

    public double a() {
        return this.f34893c;
    }
}
