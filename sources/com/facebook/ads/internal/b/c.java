package com.facebook.ads.internal.b;

import java.io.Serializable;

public class c implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private a f20023a;

    /* renamed from: b  reason: collision with root package name */
    private a f20024b;

    public static class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        private double f20025a;

        /* renamed from: b  reason: collision with root package name */
        private double f20026b;

        /* renamed from: c  reason: collision with root package name */
        private double f20027c;

        /* renamed from: d  reason: collision with root package name */
        private double f20028d;

        /* renamed from: e  reason: collision with root package name */
        private double f20029e;

        /* renamed from: f  reason: collision with root package name */
        private double f20030f;

        /* renamed from: g  reason: collision with root package name */
        private double f20031g;

        /* renamed from: h  reason: collision with root package name */
        private int f20032h;

        /* renamed from: i  reason: collision with root package name */
        private double f20033i;

        /* renamed from: j  reason: collision with root package name */
        private double f20034j;

        /* renamed from: k  reason: collision with root package name */
        private double f20035k;

        public a(double d2) {
            this.f20029e = d2;
        }

        public void a() {
            this.f20025a = 0.0d;
            this.f20027c = 0.0d;
            this.f20028d = 0.0d;
            this.f20030f = 0.0d;
            this.f20032h = 0;
            this.f20033i = 0.0d;
            this.f20034j = 1.0d;
            this.f20035k = 0.0d;
        }

        public void a(double d2, double d3) {
            this.f20032h++;
            double d4 = this.f20033i + d2;
            this.f20033i = d4;
            this.f20027c = d3;
            double d5 = this.f20035k + (d3 * d2);
            this.f20035k = d5;
            this.f20025a = d5 / d4;
            this.f20034j = Math.min(this.f20034j, d3);
            this.f20030f = Math.max(this.f20030f, d3);
            if (d3 >= this.f20029e) {
                this.f20028d += d2;
                double d6 = this.f20026b + d2;
                this.f20026b = d6;
                this.f20031g = Math.max(this.f20031g, d6);
                return;
            }
            this.f20026b = 0.0d;
        }

        public void b() {
            this.f20026b = 0.0d;
        }

        public double c() {
            if (this.f20032h == 0) {
                return 0.0d;
            }
            return this.f20034j;
        }

        public double d() {
            return this.f20025a;
        }

        public double e() {
            return this.f20030f;
        }

        public double f() {
            return this.f20033i;
        }

        public double g() {
            return this.f20028d;
        }

        public double h() {
            return this.f20031g;
        }
    }

    public c() {
        this(0.5d, 0.5d);
    }

    public c(double d2) {
        this(d2, 0.5d);
    }

    public c(double d2, double d3) {
        this.f20023a = new a(d2);
        this.f20024b = new a(d3);
        a();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f20023a.a();
        this.f20024b.a();
    }

    /* access modifiers changed from: package-private */
    public void a(double d2, double d3) {
        this.f20023a.a(d2, d3);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f20023a.b();
        this.f20024b.b();
    }

    /* access modifiers changed from: package-private */
    public void b(double d2, double d3) {
        this.f20024b.a(d2, d3);
    }

    public a c() {
        return this.f20023a;
    }

    public a d() {
        return this.f20024b;
    }
}
