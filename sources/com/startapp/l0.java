package com.startapp;

public class l0 implements p0 {

    /* renamed from: a  reason: collision with root package name */
    public final m0 f34849a;

    /* renamed from: b  reason: collision with root package name */
    public final m0 f34850b;

    /* renamed from: c  reason: collision with root package name */
    public final m0 f34851c;

    /* renamed from: d  reason: collision with root package name */
    public double f34852d;

    public l0(m0 m0Var, m0 m0Var2, m0 m0Var3) {
        this.f34849a = m0Var;
        this.f34850b = m0Var2;
        this.f34851c = m0Var3;
    }

    public void a(double d2, double d3, double d4) {
        this.f34849a.a(d2);
        this.f34850b.a(d3);
        this.f34851c.a(d4);
        double d5 = this.f34849a.f34893c;
        double d6 = this.f34850b.f34893c;
        double d7 = (d5 * d5) + (d6 * d6);
        double d8 = this.f34851c.f34893c;
        this.f34852d = Math.sqrt(d7 + (d8 * d8));
    }

    public m0 b() {
        return this.f34849a;
    }

    public m0 c() {
        return this.f34850b;
    }

    public m0 d() {
        return this.f34851c;
    }

    public double a() {
        return this.f34852d;
    }
}
