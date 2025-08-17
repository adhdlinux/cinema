package com.applovin.impl.mediation;

import com.applovin.impl.mediation.a;
import com.applovin.impl.mediation.c;
import com.applovin.impl.sdk.m;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.sdk.AppLovinSdkUtils;

public class b implements a.C0010a, c.a {

    /* renamed from: a  reason: collision with root package name */
    private final a f14342a;

    /* renamed from: b  reason: collision with root package name */
    private final c f14343b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final MaxAdListener f14344c;

    public b(m mVar, MaxAdListener maxAdListener) {
        this.f14344c = maxAdListener;
        this.f14342a = new a(mVar);
        this.f14343b = new c(mVar, this);
    }

    public void a(final com.applovin.impl.mediation.a.c cVar) {
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
            public void run() {
                b.this.f14344c.onAdHidden(cVar);
            }
        }, cVar.x());
    }

    public void a(MaxAd maxAd) {
        this.f14343b.a();
        this.f14342a.a();
    }

    public void b(com.applovin.impl.mediation.a.c cVar) {
        long v2 = cVar.v();
        if (v2 >= 0) {
            this.f14343b.a(cVar, v2);
        }
        if (cVar.w()) {
            this.f14342a.a(cVar, this);
        }
    }

    public void c(com.applovin.impl.mediation.a.c cVar) {
        this.f14344c.onAdHidden(cVar);
    }
}
