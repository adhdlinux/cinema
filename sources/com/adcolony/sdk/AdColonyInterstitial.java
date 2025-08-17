package com.adcolony.sdk;

import android.content.Context;

public class AdColonyInterstitial {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public AdColonyInterstitialListener f12852a;

    /* renamed from: b  reason: collision with root package name */
    private f f12853b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public c f12854c;

    /* renamed from: d  reason: collision with root package name */
    private p0 f12855d;

    /* renamed from: e  reason: collision with root package name */
    private int f12856e;

    /* renamed from: f  reason: collision with root package name */
    private String f12857f;

    /* renamed from: g  reason: collision with root package name */
    private String f12858g;

    /* renamed from: h  reason: collision with root package name */
    private final String f12859h;

    /* renamed from: i  reason: collision with root package name */
    private String f12860i;

    /* renamed from: j  reason: collision with root package name */
    private String f12861j;

    /* renamed from: k  reason: collision with root package name */
    private g f12862k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f12863l;

    /* renamed from: m  reason: collision with root package name */
    private String f12864m;

    class b implements Runnable {
        b() {
        }

        public void run() {
            if (!(a.a() instanceof AdColonyInterstitialActivity) && AdColonyInterstitial.this.f12852a != null) {
                AdColonyInterstitial.this.f12852a.h(AdColonyInterstitial.this);
            }
        }
    }

    class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f12866b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f12867c;

        c(d dVar, String str) {
            this.f12866b = dVar;
            this.f12867c = str;
        }

        public void run() {
            Context a2 = a.a();
            if (a2 instanceof b) {
                this.f12866b.c(a2, c0.q(), this.f12867c);
            } else {
                if (AdColonyInterstitial.this.f12852a != null) {
                    AdColonyInterstitial.this.f12852a.d(AdColonyInterstitial.this);
                    AdColonyInterstitial.this.K((AdColonyInterstitialListener) null);
                }
                AdColonyInterstitial.this.F();
                AdColonyInterstitial.this.r();
                a.f().f0(false);
            }
            if (AdColonyInterstitial.this.f12854c != null) {
                this.f12866b.g(AdColonyInterstitial.this.f12854c);
                c unused = AdColonyInterstitial.this.f12854c = null;
            }
        }
    }

    class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AdColonyInterstitialListener f12869b;

        d(AdColonyInterstitialListener adColonyInterstitialListener) {
            this.f12869b = adColonyInterstitialListener;
        }

        public void run() {
            this.f12869b.j(AdColony.a(AdColonyInterstitial.this.x()));
        }
    }

    class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AdColonyInterstitialListener f12871b;

        e(AdColonyInterstitialListener adColonyInterstitialListener) {
            this.f12871b = adColonyInterstitialListener;
        }

        public void run() {
            this.f12871b.e(AdColonyInterstitial.this);
        }
    }

    interface f {
        void a();
    }

    enum g {
        REQUESTED,
        FILLED,
        NOT_FILLED,
        EXPIRED,
        SHOWN,
        CLOSED
    }

    public boolean A() {
        g gVar = this.f12862k;
        return gVar == g.EXPIRED || gVar == g.SHOWN || gVar == g.CLOSED;
    }

    /* access modifiers changed from: package-private */
    public boolean B() {
        return this.f12862k == g.FILLED;
    }

    /* access modifiers changed from: package-private */
    public boolean C() {
        return this.f12862k == g.REQUESTED;
    }

    /* access modifiers changed from: package-private */
    public boolean D() {
        return this.f12862k == g.SHOWN;
    }

    /* access modifiers changed from: package-private */
    public boolean E() {
        z0.C((Runnable) null);
        if (a.a() == null || !a.i()) {
            return false;
        }
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void F() {
        f fVar;
        synchronized (this) {
            I();
            fVar = this.f12853b;
            if (fVar != null) {
                this.f12853b = null;
            } else {
                fVar = null;
            }
        }
        if (fVar != null) {
            fVar.a();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean G() {
        J();
        AdColonyInterstitialListener adColonyInterstitialListener = this.f12852a;
        if (adColonyInterstitialListener == null) {
            return false;
        }
        z0.A(new e(adColonyInterstitialListener));
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean H() {
        N();
        AdColonyInterstitialListener adColonyInterstitialListener = this.f12852a;
        if (adColonyInterstitialListener == null) {
            return false;
        }
        z0.A(new d(adColonyInterstitialListener));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void I() {
        this.f12862k = g.CLOSED;
    }

    /* access modifiers changed from: package-private */
    public void J() {
        this.f12862k = g.EXPIRED;
    }

    public void K(AdColonyInterstitialListener adColonyInterstitialListener) {
        this.f12852a = adColonyInterstitialListener;
    }

    public void L(String str) {
        this.f12864m = str;
    }

    /* access modifiers changed from: package-private */
    public void M() {
        this.f12862k = g.FILLED;
    }

    /* access modifiers changed from: package-private */
    public void N() {
        this.f12862k = g.NOT_FILLED;
    }

    /* access modifiers changed from: package-private */
    public String b() {
        String str = this.f12858g;
        return str == null ? "" : str;
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        this.f12856e = i2;
    }

    /* access modifiers changed from: package-private */
    public void d(f fVar) {
        boolean z2;
        synchronized (this) {
            if (this.f12862k == g.CLOSED) {
                z2 = true;
            } else {
                this.f12853b = fVar;
                z2 = false;
            }
        }
        if (z2) {
            fVar.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void e(c cVar) {
        this.f12854c = cVar;
    }

    /* access modifiers changed from: package-private */
    public void f(f1 f1Var) {
        if (!f1Var.q()) {
            this.f12855d = new p0(f1Var, this.f12857f);
        }
    }

    /* access modifiers changed from: package-private */
    public void g(String str) {
        this.f12858g = str;
    }

    /* access modifiers changed from: package-private */
    public void h(boolean z2) {
    }

    /* access modifiers changed from: package-private */
    public String j() {
        return this.f12857f;
    }

    /* access modifiers changed from: package-private */
    public void k(String str) {
        this.f12860i = str;
    }

    /* access modifiers changed from: package-private */
    public void l(boolean z2) {
        this.f12863l = z2;
    }

    /* access modifiers changed from: package-private */
    public String n() {
        return this.f12860i;
    }

    /* access modifiers changed from: package-private */
    public void o(String str) {
    }

    /* access modifiers changed from: package-private */
    public c p() {
        return this.f12854c;
    }

    /* access modifiers changed from: package-private */
    public void q(String str) {
        this.f12861j = str;
    }

    public boolean r() {
        a.f().T().z().remove(this.f12857f);
        return true;
    }

    /* access modifiers changed from: package-private */
    public p0 s() {
        return this.f12855d;
    }

    /* access modifiers changed from: package-private */
    public void t(String str) {
        if (a.i()) {
            k f2 = a.f();
            d T = f2.T();
            z0.A(new b());
            AdColonyZone adColonyZone = f2.c().get(this.f12859h);
            if (adColonyZone != null && adColonyZone.i()) {
                f1 f1Var = new f1();
                c0.u(f1Var, "reward_amount", adColonyZone.g());
                c0.n(f1Var, "reward_name", adColonyZone.h());
                c0.w(f1Var, "success", true);
                c0.n(f1Var, "zone_id", this.f12859h);
                f2.g0(new h0("AdColony.v4vc_reward", 0, f1Var));
            }
            z0.A(new c(T, str));
        }
    }

    /* access modifiers changed from: package-private */
    public int u() {
        return this.f12856e;
    }

    /* access modifiers changed from: package-private */
    public String v() {
        return this.f12861j;
    }

    public AdColonyInterstitialListener w() {
        return this.f12852a;
    }

    public String x() {
        return this.f12859h;
    }

    /* access modifiers changed from: package-private */
    public boolean y() {
        return this.f12863l;
    }

    /* access modifiers changed from: package-private */
    public boolean z() {
        return this.f12855d != null;
    }
}
