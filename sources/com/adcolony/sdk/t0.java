package com.adcolony.sdk;

import android.os.SystemClock;
import com.adcolony.sdk.e0;
import java.util.LinkedHashMap;

class t0 {

    /* renamed from: a  reason: collision with root package name */
    private long f13389a = 1800000;

    /* renamed from: b  reason: collision with root package name */
    private int f13390b;

    /* renamed from: c  reason: collision with root package name */
    private long f13391c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f13392d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f13393e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f13394f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f13395g = false;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f13396h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f13397i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f13398j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f13399k;

    /* renamed from: l  reason: collision with root package name */
    private u0 f13400l;

    class a implements j0 {
        a() {
        }

        public void a(h0 h0Var) {
            boolean unused = t0.this.f13398j = true;
        }
    }

    class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l f13402b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ k f13403c;

        b(t0 t0Var, l lVar, k kVar) {
            this.f13402b = lVar;
            this.f13403c = kVar;
        }

        public void run() {
            this.f13402b.b();
            this.f13403c.D0().q();
        }
    }

    class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f13404b;

        c(boolean z2) {
            this.f13404b = z2;
        }

        public void run() {
            LinkedHashMap<Integer, k0> s2 = a.f().F0().s();
            synchronized (s2) {
                for (k0 next : s2.values()) {
                    f1 q2 = c0.q();
                    c0.w(q2, "from_window_focus", this.f13404b);
                    if (t0.this.f13396h && !t0.this.f13395g) {
                        c0.w(q2, "app_in_foreground", false);
                        boolean unused = t0.this.f13396h = false;
                    }
                    new h0("SessionInfo.on_pause", next.getModuleId(), q2).e();
                }
            }
            a.k();
        }
    }

    class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f13406b;

        d(boolean z2) {
            this.f13406b = z2;
        }

        public void run() {
            k f2 = a.f();
            LinkedHashMap<Integer, k0> s2 = f2.F0().s();
            synchronized (s2) {
                for (k0 next : s2.values()) {
                    f1 q2 = c0.q();
                    c0.w(q2, "from_window_focus", this.f13406b);
                    if (t0.this.f13396h && t0.this.f13395g) {
                        c0.w(q2, "app_in_foreground", true);
                        boolean unused = t0.this.f13396h = false;
                    }
                    new h0("SessionInfo.on_resume", next.getModuleId(), q2).e();
                }
            }
            f2.D0().q();
        }
    }

    t0() {
    }

    private void r() {
        c(false);
    }

    private void s() {
        f(false);
    }

    /* access modifiers changed from: package-private */
    public long a() {
        return this.f13389a;
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        long j2;
        if (i2 <= 0) {
            j2 = this.f13389a;
        } else {
            j2 = (long) (i2 * 1000);
        }
        this.f13389a = j2;
    }

    /* access modifiers changed from: package-private */
    public void c(boolean z2) {
        this.f13393e = true;
        this.f13400l.f();
        if (!AdColony.c(new c(z2))) {
            new e0.a().c("RejectedExecutionException on session pause.").d(e0.f13114i);
        }
    }

    /* access modifiers changed from: package-private */
    public void f(boolean z2) {
        this.f13393e = false;
        this.f13400l.g();
        if (!AdColony.c(new d(z2))) {
            new e0.a().c("RejectedExecutionException on session resume.").d(e0.f13114i);
        }
    }

    /* access modifiers changed from: package-private */
    public void i(boolean z2) {
        k f2 = a.f();
        if (!this.f13394f) {
            if (this.f13397i) {
                f2.V(false);
                this.f13397i = false;
            }
            this.f13390b = 0;
            this.f13391c = SystemClock.uptimeMillis();
            this.f13392d = true;
            this.f13394f = true;
            this.f13395g = true;
            this.f13396h = false;
            AdColony.e();
            if (z2) {
                f1 q2 = c0.q();
                c0.n(q2, "id", z0.f());
                new h0("SessionInfo.on_start", 1, q2).e();
                l q3 = a.f().F0().q();
                if (q3 != null && !AdColony.c(new b(this, q3, f2))) {
                    new e0.a().c("RejectedExecutionException on controller update.").d(e0.f13114i);
                }
            }
            f2.F0().w();
            v.b().k();
        }
    }

    public void j() {
        a.e("SessionInfo.stopped", new a());
        this.f13400l = new u0(this);
    }

    /* access modifiers changed from: package-private */
    public void k(boolean z2) {
        if (z2 && this.f13393e) {
            s();
        } else if (!z2 && !this.f13393e) {
            r();
        }
        this.f13392d = z2;
    }

    /* access modifiers changed from: package-private */
    public void l(boolean z2) {
        if (this.f13395g != z2) {
            this.f13395g = z2;
            this.f13396h = true;
            if (!z2) {
                r();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return this.f13392d;
    }

    public void n(boolean z2) {
        this.f13397i = z2;
    }

    /* access modifiers changed from: package-private */
    public boolean o() {
        return this.f13394f;
    }

    /* access modifiers changed from: package-private */
    public void p(boolean z2) {
        this.f13399k = z2;
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        return this.f13399k;
    }

    /* access modifiers changed from: package-private */
    public void t() {
        s0 c2 = a.f().D0().c();
        this.f13394f = false;
        this.f13392d = false;
        if (c2 != null) {
            c2.f();
        }
        f1 q2 = c0.q();
        c0.k(q2, "session_length", ((double) (SystemClock.uptimeMillis() - this.f13391c)) / 1000.0d);
        new h0("SessionInfo.on_stop", 1, q2).e();
        a.k();
        AdColony.g();
    }
}
