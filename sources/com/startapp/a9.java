package com.startapp;

import com.startapp.sdk.adsbase.remoteconfig.AnalyticsCategoryConfig;
import java.util.ArrayList;
import java.util.List;

public class a9 {

    /* renamed from: a  reason: collision with root package name */
    public final double f34194a;

    /* renamed from: b  reason: collision with root package name */
    public final int f34195b;

    /* renamed from: c  reason: collision with root package name */
    public final int f34196c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f34197d;

    /* renamed from: e  reason: collision with root package name */
    public final long f34198e;

    /* renamed from: f  reason: collision with root package name */
    public final long f34199f;

    /* renamed from: g  reason: collision with root package name */
    public final List<c9> f34200g;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public double f34201a = 1.0d;

        /* renamed from: b  reason: collision with root package name */
        public int f34202b;

        /* renamed from: c  reason: collision with root package name */
        public int f34203c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f34204d;

        /* renamed from: e  reason: collision with root package name */
        public String f34205e;

        /* renamed from: f  reason: collision with root package name */
        public String f34206f;

        /* renamed from: g  reason: collision with root package name */
        public List<c9> f34207g;

        public double a() {
            return this.f34201a;
        }

        public List<c9> b() {
            return this.f34207g;
        }

        public String c() {
            return this.f34206f;
        }

        public int d() {
            return this.f34202b;
        }

        public int e() {
            return this.f34203c;
        }

        public String f() {
            return this.f34205e;
        }

        public boolean g() {
            return this.f34204d;
        }

        public a a(c9 c9Var) {
            if (this.f34207g == null) {
                this.f34207g = new ArrayList();
            }
            this.f34207g.add(c9Var);
            return this;
        }
    }

    public a9(a aVar) {
        this.f34194a = aVar.a();
        this.f34195b = aVar.d();
        this.f34196c = aVar.e();
        this.f34197d = aVar.g();
        this.f34198e = Math.max(60000, lb.e(aVar.f()));
        this.f34199f = Math.max(0, lb.e(aVar.c()));
        this.f34200g = lb.b(aVar.b());
    }

    public static <T> T a(T t2, T t3) {
        return t3 != null ? t3 : t2;
    }

    public double a() {
        return this.f34194a;
    }

    public List<c9> b() {
        return this.f34200g;
    }

    public long c() {
        return this.f34199f;
    }

    public int d() {
        return this.f34195b;
    }

    public int e() {
        return this.f34196c;
    }

    public long f() {
        return this.f34198e;
    }

    public boolean g() {
        return this.f34197d;
    }

    public a9(a9 a9Var, AnalyticsCategoryConfig analyticsCategoryConfig) {
        this.f34194a = ((Double) a(Double.valueOf(a9Var.a()), analyticsCategoryConfig.a())).doubleValue();
        this.f34195b = ((Integer) a(Integer.valueOf(a9Var.d()), analyticsCategoryConfig.d())).intValue();
        this.f34196c = ((Integer) a(Integer.valueOf(a9Var.e()), analyticsCategoryConfig.e())).intValue();
        this.f34197d = ((Boolean) a(Boolean.valueOf(a9Var.g()), analyticsCategoryConfig.f())).booleanValue();
        this.f34198e = analyticsCategoryConfig.g() == null ? a9Var.f() : Math.max(60000, lb.e(analyticsCategoryConfig.g()));
        this.f34199f = analyticsCategoryConfig.c() == null ? a9Var.c() : Math.max(0, lb.e(analyticsCategoryConfig.c()));
        this.f34200g = (List) a(a9Var.b(), c9.a(analyticsCategoryConfig.b()));
    }
}
