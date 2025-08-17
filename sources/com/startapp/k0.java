package com.startapp;

public class k0 implements p0 {

    /* renamed from: a  reason: collision with root package name */
    public final double f34791a;

    /* renamed from: b  reason: collision with root package name */
    public final double f34792b;

    /* renamed from: c  reason: collision with root package name */
    public final double f34793c;

    /* renamed from: d  reason: collision with root package name */
    public final double f34794d;

    /* renamed from: e  reason: collision with root package name */
    public final double f34795e;

    /* renamed from: f  reason: collision with root package name */
    public final double f34796f;

    /* renamed from: g  reason: collision with root package name */
    public double f34797g;

    /* renamed from: h  reason: collision with root package name */
    public long f34798h;

    /* renamed from: i  reason: collision with root package name */
    public double f34799i;

    public k0(double d2, double d3, double d4, double d5, double d6) {
        double d7 = d2 + d3;
        this.f34791a = d2 / d7;
        this.f34792b = d3 / d7;
        this.f34793c = d4;
        this.f34794d = d5;
        this.f34795e = d6;
        this.f34796f = p.a(0.0d, d5, d6);
    }

    public static double a(long j2, long j3, double d2, double d3, double d4, double d5) {
        double max = ((double) Math.max(0, j2 - j3)) / d2;
        if (d4 > 0.0d) {
            return p.a(max, d3, d4, d5);
        }
        if (d4 < 0.0d) {
            return p.a(max, d3, d4) / d5;
        }
        return p.a(max, d3, d4);
    }

    public void a(long j2, double d2) {
        double a2 = this.f34797g * a(j2, this.f34798h, this.f34793c, this.f34794d, this.f34795e, this.f34796f);
        double d3 = (this.f34791a * a2) + (this.f34792b * d2);
        this.f34799i = d3;
        if (a2 < d3) {
            this.f34797g = d3;
            this.f34798h = j2;
        }
    }

    public double a() {
        return this.f34799i;
    }
}
