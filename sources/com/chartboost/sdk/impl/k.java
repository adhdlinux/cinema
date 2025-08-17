package com.chartboost.sdk.impl;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final qd f18001a;

    public k(qd qdVar) {
        this.f18001a = qdVar;
    }

    public static k a(p pVar) {
        qd qdVar = (qd) pVar;
        df.a((Object) pVar, "AdSession is null");
        df.g(qdVar);
        df.b(qdVar);
        k kVar = new k(qdVar);
        qdVar.k().a(kVar);
        return kVar;
    }

    public void b() {
        df.a(this.f18001a);
        df.e(this.f18001a);
        this.f18001a.p();
    }

    public void a() {
        df.b(this.f18001a);
        df.e(this.f18001a);
        if (!this.f18001a.h()) {
            try {
                this.f18001a.b();
            } catch (Exception unused) {
            }
        }
        if (this.f18001a.h()) {
            this.f18001a.o();
        }
    }
}
