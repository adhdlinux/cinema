package com.applovin.impl.sdk;

import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.ad.f;
import java.util.HashMap;
import java.util.Map;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final m f15174a;

    /* renamed from: b  reason: collision with root package name */
    private final v f15175b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f15176c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private final Map<d, x> f15177d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final Map<d, x> f15178e = new HashMap();

    c(m mVar) {
        this.f15174a = mVar;
        this.f15175b = mVar.A();
        for (d next : d.f()) {
            this.f15177d.put(next, new x());
            this.f15178e.put(next, new x());
        }
    }

    private x d(d dVar) {
        x xVar;
        synchronized (this.f15176c) {
            xVar = this.f15177d.get(dVar);
            if (xVar == null) {
                xVar = new x();
                this.f15177d.put(dVar, xVar);
            }
        }
        return xVar;
    }

    private x e(d dVar) {
        x xVar;
        synchronized (this.f15176c) {
            xVar = this.f15178e.get(dVar);
            if (xVar == null) {
                xVar = new x();
                this.f15178e.put(dVar, xVar);
            }
        }
        return xVar;
    }

    private x f(d dVar) {
        synchronized (this.f15176c) {
            x e2 = e(dVar);
            if (e2.a() > 0) {
                return e2;
            }
            x d2 = d(dVar);
            return d2;
        }
    }

    public AppLovinAdImpl a(d dVar) {
        f fVar;
        StringBuilder sb;
        String str;
        synchronized (this.f15176c) {
            x d2 = d(dVar);
            if (d2.a() > 0) {
                e(dVar).a(d2.c());
                fVar = new f(dVar, this.f15174a);
            } else {
                fVar = null;
            }
        }
        if (v.a()) {
            v vVar = this.f15175b;
            if (fVar != null) {
                str = "Retrieved ad of zone ";
            } else {
                sb = new StringBuilder();
                str = "Unable to retrieve ad of zone ";
            }
            sb.append(str);
            sb.append(dVar);
            sb.append("...");
            vVar.b("AdPreloadManager", sb.toString());
        }
        return fVar;
    }

    /* access modifiers changed from: package-private */
    public void a(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.f15176c) {
            d(appLovinAdImpl.getAdZone()).a(appLovinAdImpl);
            if (v.a()) {
                v vVar = this.f15175b;
                vVar.b("AdPreloadManager", "Ad enqueued: " + appLovinAdImpl);
            }
        }
    }

    public AppLovinAdImpl b(d dVar) {
        AppLovinAdImpl c2;
        synchronized (this.f15176c) {
            c2 = f(dVar).c();
        }
        return c2;
    }

    public AppLovinAdBase c(d dVar) {
        AppLovinAdImpl d2;
        synchronized (this.f15176c) {
            d2 = f(dVar).d();
        }
        return d2;
    }
}
