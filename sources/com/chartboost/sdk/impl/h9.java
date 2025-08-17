package com.chartboost.sdk.impl;

import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.impl.t2;
import com.chartboost.sdk.impl.tb;
import com.chartboost.sdk.internal.Model.CBError;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class h9 implements t2.a {

    /* renamed from: a  reason: collision with root package name */
    public s4 f17856a;

    /* renamed from: b  reason: collision with root package name */
    public final v5 f17857b;

    /* renamed from: c  reason: collision with root package name */
    public final q2 f17858c;

    /* renamed from: d  reason: collision with root package name */
    public final ca f17859d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference f17860e;

    /* renamed from: f  reason: collision with root package name */
    public final z4 f17861f;

    /* renamed from: g  reason: collision with root package name */
    public int f17862g = 1;

    /* renamed from: h  reason: collision with root package name */
    public int f17863h = 0;

    /* renamed from: i  reason: collision with root package name */
    public long f17864i = 0;

    /* renamed from: j  reason: collision with root package name */
    public t2 f17865j = null;

    /* renamed from: k  reason: collision with root package name */
    public AtomicInteger f17866k = null;

    public h9(s4 s4Var, v5 v5Var, q2 q2Var, ca caVar, AtomicReference atomicReference, z4 z4Var) {
        this.f17856a = s4Var;
        this.f17857b = v5Var;
        this.f17858c = q2Var;
        this.f17859d = caVar;
        this.f17860e = atomicReference;
        this.f17861f = z4Var;
    }

    public final void a(pa paVar) {
        boolean z2 = paVar.f18373q;
        if (this.f17863h == 2 && !z2) {
            w7.a("Prefetcher", "Change state to IDLE");
            this.f17862g = 1;
            this.f17863h = 0;
            this.f17864i = 0;
            this.f17865j = null;
            AtomicInteger atomicInteger = this.f17866k;
            this.f17866k = null;
            if (atomicInteger != null) {
                this.f17856a.a(atomicInteger);
            }
        }
    }

    public synchronized void b() {
        try {
            w7.c("Chartboost SDK", "Sdk Version = 9.7.0, Commit: 827fd3ad693d520953527c856c9569f70402c65c");
            pa paVar = (pa) this.f17860e.get();
            a(paVar);
            if (!paVar.e()) {
                if (!paVar.d()) {
                    if (this.f17862g == 3) {
                        if (this.f17866k.get() <= 0) {
                            w7.a("Prefetcher", "Change state to COOLDOWN");
                            this.f17862g = 4;
                            this.f17866k = null;
                        } else {
                            return;
                        }
                    }
                    if (this.f17862g == 4) {
                        if (this.f17864i - System.nanoTime() > 0) {
                            w7.a("Prefetcher", "Prefetch session is still active. Won't be making any new prefetch until the prefetch session expires");
                            return;
                        }
                        w7.a("Prefetcher", "Change state to IDLE");
                        this.f17862g = 1;
                        this.f17863h = 0;
                        this.f17864i = 0;
                    }
                    if (this.f17862g == 1) {
                        if (paVar.h()) {
                            a3 a3Var = new a3(paVar.f18382z, this.f17859d.a(), i9.NORMAL, this, this.f17861f);
                            a3Var.b("cache_assets", this.f17857b.f());
                            a3Var.f18627r = true;
                            w7.a("Prefetcher", "Change state to AWAIT_PREFETCH_RESPONSE");
                            this.f17862g = 2;
                            this.f17863h = 2;
                            this.f17864i = System.nanoTime() + TimeUnit.MINUTES.toNanos((long) paVar.f18378v);
                            this.f17865j = a3Var;
                            this.f17858c.a(a3Var);
                        } else {
                            w7.b("Prefetcher", "Did not prefetch because neither native nor webview are enabled.");
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            a();
        } catch (Exception e2) {
            if (this.f17862g == 2) {
                w7.a("Prefetcher", "Change state to COOLDOWN");
                this.f17862g = 4;
                this.f17865j = null;
            }
            w7.b("Prefetcher", "prefetch: " + e2.toString());
        }
    }

    public final synchronized void a() {
        int i2 = this.f17862g;
        if (i2 == 2) {
            w7.a("Prefetcher", "Change state to COOLDOWN");
            this.f17862g = 4;
            this.f17865j = null;
        } else if (i2 == 3) {
            w7.a("Prefetcher", "Change state to COOLDOWN");
            this.f17862g = 4;
            AtomicInteger atomicInteger = this.f17866k;
            this.f17866k = null;
            if (atomicInteger != null) {
                this.f17856a.a(atomicInteger);
            }
        }
    }

    public synchronized void a(t2 t2Var, JSONObject jSONObject) {
        try {
            if (this.f17862g == 2) {
                if (t2Var == this.f17865j) {
                    w7.a("Prefetcher", "Change state to DOWNLOAD_ASSETS");
                    this.f17862g = 3;
                    this.f17865j = null;
                    this.f17866k = new AtomicInteger();
                    if (jSONObject != null) {
                        w7.a("Prefetcher", "Got Asset list for Prefetch from server :)" + jSONObject);
                        this.f17856a.a(i9.LOW, f1.b(jSONObject, ((pa) this.f17860e.get()).f18370n), this.f17866k, (g1) null, "");
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } catch (Exception e2) {
            w7.b("Prefetcher", "prefetch onSuccess: " + e2.toString());
        }
        return;
    }

    public synchronized void a(t2 t2Var, CBError cBError) {
        String str = "Prefetch failure";
        if (cBError != null) {
            str = cBError.getErrorDesc();
        }
        this.f17861f.track(new x4(tb.e.PREFETCH_REQUEST_ERROR, str, "", "", (Mediation) null));
        if (this.f17862g == 2) {
            if (t2Var == this.f17865j) {
                this.f17865j = null;
                w7.a("Prefetcher", "Change state to COOLDOWN");
                this.f17862g = 4;
            }
        }
    }
}
