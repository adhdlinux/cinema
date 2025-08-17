package com.startapp;

public class t0 {

    /* renamed from: a  reason: collision with root package name */
    public final b f36541a = new b();

    /* renamed from: b  reason: collision with root package name */
    public final long f36542b;

    /* renamed from: c  reason: collision with root package name */
    public final double f36543c;

    /* renamed from: d  reason: collision with root package name */
    public final p0 f36544d;

    /* renamed from: e  reason: collision with root package name */
    public double f36545e;

    /* renamed from: f  reason: collision with root package name */
    public double f36546f;

    /* renamed from: g  reason: collision with root package name */
    public double f36547g;

    /* renamed from: h  reason: collision with root package name */
    public long f36548h;

    /* renamed from: i  reason: collision with root package name */
    public long f36549i;

    /* renamed from: j  reason: collision with root package name */
    public double f36550j;

    /* renamed from: k  reason: collision with root package name */
    public long f36551k;

    /* renamed from: l  reason: collision with root package name */
    public long f36552l;

    /* renamed from: m  reason: collision with root package name */
    public a f36553m;

    /* renamed from: n  reason: collision with root package name */
    public a f36554n;

    /* renamed from: o  reason: collision with root package name */
    public int f36555o;

    /* renamed from: p  reason: collision with root package name */
    public double f36556p;

    /* renamed from: q  reason: collision with root package name */
    public double f36557q;

    /* renamed from: r  reason: collision with root package name */
    public double f36558r;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public a f36559a;

        /* renamed from: b  reason: collision with root package name */
        public long f36560b;

        /* renamed from: c  reason: collision with root package name */
        public long f36561c;

        /* renamed from: d  reason: collision with root package name */
        public int f36562d;

        /* renamed from: e  reason: collision with root package name */
        public double f36563e;
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public a f36564a;
    }

    public t0(double d2, double d3, p0 p0Var) {
        this.f36542b = (long) (d2 * 1.0E9d);
        this.f36543c = d3;
        this.f36544d = p0Var;
    }

    public void a(long j2, double d2) {
        a aVar;
        this.f36545e = this.f36546f;
        this.f36546f = this.f36547g;
        this.f36547g = d2;
        this.f36548h = this.f36549i;
        this.f36549i = j2;
        long j3 = j2 - this.f36542b;
        while (true) {
            a aVar2 = this.f36553m;
            if (aVar2 == null || aVar2.f36560b >= j3 || (aVar = aVar2.f36559a) == null || aVar.f36560b >= j3) {
                b bVar = this.f36541a;
                a aVar3 = bVar.f36564a;
            } else {
                this.f36553m = aVar;
                this.f36555o -= aVar2.f36562d;
                this.f36558r -= aVar2.f36563e;
                b bVar2 = this.f36541a;
                aVar2.f36559a = bVar2.f36564a;
                bVar2.f36564a = aVar2;
            }
        }
        b bVar3 = this.f36541a;
        a aVar32 = bVar3.f36564a;
        if (aVar32 == null) {
            aVar32 = new a();
        } else {
            bVar3.f36564a = aVar32.f36559a;
            aVar32.f36559a = null;
            aVar32.f36560b = 0;
            aVar32.f36561c = 0;
            aVar32.f36562d = 0;
            aVar32.f36563e = 0.0d;
        }
        aVar32.f36560b = this.f36549i;
        aVar32.f36561c = this.f36552l;
        double a2 = this.f36544d.a();
        double d3 = this.f36545e;
        double d4 = this.f36546f;
        if (d3 < d4 && d4 > this.f36547g) {
            double d5 = d4 - a2;
            if (d5 > this.f36543c) {
                this.f36550j = d5;
                this.f36551k = this.f36548h;
            }
        }
        if (d4 > a2 && a2 > this.f36547g && this.f36551k > this.f36552l) {
            this.f36552l = this.f36549i;
            aVar32.f36562d = 1;
            aVar32.f36563e = this.f36550j;
        }
        int i2 = this.f36555o + aVar32.f36562d;
        this.f36555o = i2;
        double d6 = this.f36558r + aVar32.f36563e;
        this.f36558r = d6;
        a aVar4 = this.f36554n;
        if (aVar4 != null) {
            aVar4.f36559a = aVar32;
        }
        this.f36554n = aVar32;
        if (this.f36553m == null) {
            this.f36553m = aVar32;
        }
        long j4 = this.f36552l - this.f36553m.f36561c;
        if (j4 > 0) {
            this.f36556p = ((double) i2) / (((double) j4) / 1.0E9d);
        }
        if (i2 > 0) {
            this.f36557q = d6 / ((double) i2);
        } else {
            this.f36557q = 0.0d;
        }
    }
}
