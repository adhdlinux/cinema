package com.applovin.impl.sdk.d;

import android.annotation.TargetApi;
import android.app.Activity;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.d.c;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.g;
import com.applovin.impl.sdk.utils.h;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final m f15287a;

    /* renamed from: b  reason: collision with root package name */
    private final g f15288b;

    /* renamed from: c  reason: collision with root package name */
    private final c.a f15289c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f15290d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private final long f15291e;

    /* renamed from: f  reason: collision with root package name */
    private long f15292f;

    /* renamed from: g  reason: collision with root package name */
    private long f15293g;

    /* renamed from: h  reason: collision with root package name */
    private long f15294h;

    public d(AppLovinAdImpl appLovinAdImpl, m mVar) {
        if (appLovinAdImpl == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (mVar != null) {
            this.f15287a = mVar;
            this.f15288b = mVar.T();
            c.a a2 = mVar.ac().a(appLovinAdImpl);
            this.f15289c = a2;
            a2.a(b.f15257a, (long) appLovinAdImpl.getSource().ordinal()).a();
            this.f15291e = appLovinAdImpl.getCreatedAtMillis();
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    public static void a(long j2, AppLovinAdBase appLovinAdBase, m mVar) {
        if (appLovinAdBase != null && mVar != null) {
            mVar.ac().a(appLovinAdBase).a(b.f15258b, j2).a();
        }
    }

    public static void a(AppLovinAdBase appLovinAdBase, m mVar) {
        if (appLovinAdBase != null && mVar != null) {
            mVar.ac().a(appLovinAdBase).a(b.f15259c, appLovinAdBase.getFetchLatencyMillis()).a(b.f15260d, appLovinAdBase.getFetchResponseSize()).a();
        }
    }

    private void a(b bVar) {
        synchronized (this.f15290d) {
            if (this.f15292f > 0) {
                this.f15289c.a(bVar, System.currentTimeMillis() - this.f15292f).a();
            }
        }
    }

    public static void a(e eVar, AppLovinAdBase appLovinAdBase, m mVar) {
        if (appLovinAdBase != null && mVar != null && eVar != null) {
            mVar.ac().a(appLovinAdBase).a(b.f15261e, eVar.c()).a(b.f15262f, eVar.d()).a(b.f15277u, eVar.g()).a(b.f15278v, eVar.h()).a(b.f15279w, eVar.b() ? 1 : 0).a();
        }
    }

    @TargetApi(24)
    public void a() {
        this.f15289c.a(b.f15266j, this.f15288b.a(f.f15303b)).a(b.f15265i, this.f15288b.a(f.f15305d));
        synchronized (this.f15290d) {
            long j2 = 0;
            if (this.f15291e > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f15292f = currentTimeMillis;
                long O = currentTimeMillis - this.f15287a.O();
                long j3 = this.f15292f - this.f15291e;
                long j4 = h.a(this.f15287a.L()) ? 1 : 0;
                Activity a2 = this.f15287a.af().a();
                if (g.f() && a2 != null && a2.isInMultiWindowMode()) {
                    j2 = 1;
                }
                this.f15289c.a(b.f15264h, O).a(b.f15263g, j3).a(b.f15272p, j4).a(b.f15280x, j2);
            }
        }
        this.f15289c.a();
    }

    public void a(long j2) {
        this.f15289c.a(b.f15274r, j2).a();
    }

    public void b() {
        synchronized (this.f15290d) {
            if (this.f15293g < 1) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f15293g = currentTimeMillis;
                long j2 = this.f15292f;
                if (j2 > 0) {
                    this.f15289c.a(b.f15269m, currentTimeMillis - j2).a();
                }
            }
        }
    }

    public void b(long j2) {
        this.f15289c.a(b.f15273q, j2).a();
    }

    public void c() {
        a(b.f15267k);
    }

    public void c(long j2) {
        this.f15289c.a(b.f15275s, j2).a();
    }

    public void d() {
        a(b.f15270n);
    }

    public void d(long j2) {
        synchronized (this.f15290d) {
            if (this.f15294h < 1) {
                this.f15294h = j2;
                this.f15289c.a(b.f15276t, j2).a();
            }
        }
    }

    public void e() {
        a(b.f15271o);
    }

    public void f() {
        a(b.f15268l);
    }

    public void g() {
        this.f15289c.a(b.f15281y).a();
    }
}
