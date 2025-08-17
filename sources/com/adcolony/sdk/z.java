package com.adcolony.sdk;

import com.adcolony.sdk.e0;
import com.adcolony.sdk.z0;
import java.util.Date;

class z {

    /* renamed from: a  reason: collision with root package name */
    private boolean f13533a = true;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Runnable f13534b = new a();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Runnable f13535c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public c f13536d;

    class a implements Runnable {
        a() {
        }

        public void run() {
            new h0("AdColony.heartbeat", 1).e();
            z.this.g();
        }
    }

    class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ z0.c f13538b;

        b(z0.c cVar) {
            this.f13538b = cVar;
        }

        public void run() {
            Runnable unused = z.this.f13535c = null;
            if (a.i()) {
                k f2 = a.f();
                if (this.f13538b.b() && f2.h()) {
                    f2.u();
                    e0.a c2 = new e0.a().c("Controller heartbeat timeout occurred. ");
                    e0.a c3 = c2.c("Timeout set to: " + this.f13538b.c() + " ms. ");
                    c3.c("Interval set to: " + f2.m0() + " ms. ").c("Heartbeat last reply: ").b(z.this.f13536d).d(e0.f13114i);
                    z.this.b();
                } else if (f2.e()) {
                    z.this.b();
                } else {
                    z0.n(z.this.f13534b, f2.m0());
                }
            }
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        private final f1 f13540a;

        /* synthetic */ c(f1 f1Var, a aVar) {
            this(f1Var);
        }

        public String toString() {
            return this.f13540a.toString();
        }

        private c(f1 f1Var) {
            f1 E = f1Var != null ? f1Var.E("payload") : c0.q();
            this.f13540a = E;
            c0.n(E, "heartbeatLastTimestamp", f0.f13120e.format(new Date()));
        }
    }

    z() {
    }

    /* access modifiers changed from: private */
    public void b() {
        this.f13533a = true;
        z0.C(this.f13534b);
        z0.C(this.f13535c);
        this.f13535c = null;
    }

    /* access modifiers changed from: private */
    public void g() {
        if (a.i()) {
            z0.c cVar = new z0.c(a.f().o0());
            b bVar = new b(cVar);
            this.f13535c = bVar;
            z0.n(bVar, cVar.d());
        }
    }

    /* access modifiers changed from: package-private */
    public void c(h0 h0Var) {
        if (a.i() && !this.f13533a) {
            this.f13536d = new c(h0Var.a(), (a) null);
            Runnable runnable = this.f13535c;
            if (runnable != null) {
                z0.C(runnable);
                z0.A(this.f13535c);
                return;
            }
            z0.C(this.f13534b);
            z0.n(this.f13534b, a.f().m0());
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        b();
        this.f13533a = false;
        z0.n(this.f13534b, a.f().m0());
    }
}
