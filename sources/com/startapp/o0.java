package com.startapp;

public class o0 {

    /* renamed from: a  reason: collision with root package name */
    public final l0 f35532a;

    /* renamed from: b  reason: collision with root package name */
    public final l0 f35533b;

    /* renamed from: c  reason: collision with root package name */
    public final m0 f35534c;

    /* renamed from: d  reason: collision with root package name */
    public final s0 f35535d;

    /* renamed from: e  reason: collision with root package name */
    public final r0 f35536e = new r0();

    /* renamed from: f  reason: collision with root package name */
    public final m0 f35537f;

    /* renamed from: g  reason: collision with root package name */
    public final k0 f35538g;

    /* renamed from: h  reason: collision with root package name */
    public final q0 f35539h;

    /* renamed from: i  reason: collision with root package name */
    public final k0 f35540i;

    /* renamed from: j  reason: collision with root package name */
    public final n0 f35541j;

    /* renamed from: k  reason: collision with root package name */
    public final k0 f35542k;

    /* renamed from: l  reason: collision with root package name */
    public long f35543l;

    /* renamed from: m  reason: collision with root package name */
    public long f35544m;

    public o0(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17) {
        double d18 = d2;
        double d19 = d3;
        l0 l0Var = new l0(new m0(d2), new m0(d2), new m0(d2));
        this.f35532a = l0Var;
        this.f35533b = new l0(new m0(d3), new m0(d3), new m0(d3));
        double d20 = d4;
        this.f35534c = new m0(d4);
        double d21 = d6;
        double d22 = d7;
        this.f35535d = new s0(new t0(d21, d22, l0Var.b()), new t0(d21, d22, l0Var.c()), new t0(d21, d22, l0Var.d()));
        this.f35537f = new m0(d5);
        double d23 = d13;
        double d24 = d14;
        double d25 = d15;
        double d26 = d16;
        double d27 = d17;
        this.f35538g = new k0(d23, d24, d25, d26, d27);
        this.f35539h = new q0();
        this.f35540i = new k0(d23, d24, d25, d26, d27);
        this.f35541j = new n0(5.0d, false);
        this.f35542k = new k0(d8, d9, d10, d11, d12);
    }

    public void a(double d2, long j2) {
        this.f35542k.f34797g = Math.min(Math.max(0.0d, d2), 1.0d);
        this.f35542k.f34798h = j2;
    }

    public void a(long j2, long j3, double d2, double d3, double d4) {
        double d5;
        double d6;
        double d7;
        double d8;
        double exp;
        long j4 = j2;
        long j5 = j3;
        double d9 = d2;
        double d10 = d3;
        double d11 = d4;
        if (this.f35544m < j5) {
            if (this.f35543l <= 0) {
                this.f35543l = j5;
            }
            l0 l0Var = this.f35532a;
            double d12 = l0Var.f34849a.f34893c;
            double d13 = l0Var.f34850b.f34893c;
            double d14 = l0Var.f34851c.f34893c;
            double d15 = d11;
            l0Var.a(d2, d3, d4);
            l0 l0Var2 = this.f35532a;
            double d16 = l0Var2.f34849a.f34893c - d12;
            double d17 = l0Var2.f34850b.f34893c - d13;
            double d18 = l0Var2.f34851c.f34893c - d14;
            double d19 = (d16 * d16) + (d17 * d17) + (d18 * d18);
            this.f35538g.a(j4, p.a(d19, 1.5d, 4.0d));
            this.f35540i.a(j4, p.a(d19, 0.01d, 1000.0d));
            l0 l0Var3 = this.f35533b;
            l0 l0Var4 = this.f35532a;
            l0Var3.a(d9 - l0Var4.f34849a.f34893c, d10 - l0Var4.f34850b.f34893c, d15 - l0Var4.f34851c.f34893c);
            this.f35534c.a(this.f35533b.f34852d);
            s0 s0Var = this.f35535d;
            double d20 = d15;
            long j6 = j3;
            s0Var.f35821a.a(j6, d9);
            s0Var.f35822b.a(j6, d10);
            s0Var.f35823c.a(j6, d20);
            t0 t0Var = s0Var.f35821a;
            double d21 = t0Var.f36557q;
            t0 t0Var2 = s0Var.f35822b;
            double d22 = t0Var2.f36557q;
            t0 t0Var3 = s0Var.f35823c;
            double d23 = t0Var3.f36557q;
            double d24 = d21 + d22 + d23;
            double d25 = 1.0d - this.f35538g.f34799i;
            if (d24 > 0.0d) {
                s0Var.f35824d = ((t0Var.f36556p * d21) / d24) + ((t0Var2.f36556p * d22) / d24) + ((t0Var3.f36556p * d23) / d24);
                s0Var.f35825e = d24 / 3.0d;
            } else {
                s0Var.f35824d = 0.0d;
                s0Var.f35825e = 0.0d;
            }
            double a2 = p.a(((double) (j6 - this.f35543l)) / 1.0E9d, 10.0d, 1.0d);
            r0 r0Var = this.f35536e;
            s0 s0Var2 = this.f35535d;
            double d26 = s0Var2.f35824d;
            double d27 = s0Var2.f35825e;
            double d28 = this.f35534c.f34893c;
            r0Var.f35731a = (r0Var.f35731a * 0.0d) + (Math.min(Math.exp((-Math.pow(d26 - 7.0d, 2.0d)) / 1.0d) * 2.0d, 1.0d) * 1.0d);
            double d29 = r0Var.f35732b * 0.0d;
            if (d27 < 0.0d) {
                d6 = 1.0d;
                d5 = 0.0d;
            } else {
                if (d27 < 0.5d) {
                    d5 = Math.pow(d27 * 2.0d, 4.0d);
                } else if (d27 > 2.0d) {
                    d5 = Math.exp((2.0d - d27) * 6.0d);
                } else {
                    d6 = 1.0d;
                    d5 = 1.0d;
                }
                d6 = 1.0d;
            }
            r0Var.f35732b = d29 + (d5 * d6);
            double d30 = r0Var.f35733c * 0.0d;
            if (d28 < 0.0d) {
                d8 = 1.0d;
                d7 = 0.0d;
            } else {
                if (d28 < 0.5d) {
                    exp = Math.pow(d28 * 2.0d, 4.0d);
                } else if (d28 > 5.0d) {
                    exp = Math.exp((5.0d - d28) * 4.0d);
                } else {
                    d8 = 1.0d;
                    d7 = 1.0d;
                }
                d7 = exp;
                d8 = 1.0d;
            }
            double d31 = d30 + (d7 * d8);
            r0Var.f35733c = d31;
            r0Var.f35734d = ((r0Var.f35731a * 100.0d) / 270.0d) + ((r0Var.f35732b * 70.0d) / 270.0d) + ((d31 * 100.0d) / 270.0d);
            this.f35537f.a(a2 * d25 * this.f35536e.f35734d);
            double d32 = this.f35537f.f34893c;
            q0 q0Var = this.f35539h;
            s0 s0Var3 = this.f35535d;
            double d33 = s0Var3.f35824d;
            double d34 = s0Var3.f35825e;
            this.f35541j.getClass();
            this.f35541j.getClass();
            q0Var.f35629e = (q0Var.f35629e * 0.95d) + (d33 * 0.050000000000000044d);
            q0Var.f35630f = (q0Var.f35630f * 0.95d) + (d34 * 0.050000000000000044d);
            q0Var.f35631g = (q0Var.f35631g * 0.995d) + (Math.abs(0.0d) * 0.0050000000000000044d);
            q0Var.f35632h = (q0Var.f35632h * 0.995d) + (Math.abs(0.0d) * 0.0050000000000000044d);
            q0Var.f35633i = (q0Var.f35633i * 0.9995d) + ((((p.a(q0Var.f35629e, 8.0d, 2.0d, q0.f35625a) * 2000.0d) / 5000.0d) + ((p.a(q0Var.f35630f, 0.2d, 20.0d, q0.f35626b) * 1000.0d) / 5000.0d) + ((p.a(q0Var.f35631g, 0.2d, 6.0d, q0.f35627c) * 1000.0d) / 5000.0d) + ((p.a(q0Var.f35632h, 0.4d, 5.0d, q0.f35628d) * 1000.0d) / 5000.0d)) * 4.999999999999449E-4d);
            k0 k0Var = this.f35542k;
            double d35 = this.f35540i.f34799i;
            k0Var.a(j2, (d32 * d35) + (a2 * this.f35539h.f35633i * (1.0d - d35)));
            this.f35544m = j3;
        }
    }
}
