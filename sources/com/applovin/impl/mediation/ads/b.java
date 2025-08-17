package com.applovin.impl.mediation.ads;

import com.applovin.impl.mediation.a.d;
import com.applovin.impl.mediation.a.e;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.aa;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.v;
import com.applovin.impl.sdk.z;

public class b implements aa.a {

    /* renamed from: a  reason: collision with root package name */
    private final m f14337a;

    /* renamed from: b  reason: collision with root package name */
    private final d f14338b;

    /* renamed from: c  reason: collision with root package name */
    private final aa f14339c;

    /* renamed from: d  reason: collision with root package name */
    private final z f14340d;

    /* renamed from: e  reason: collision with root package name */
    private final a.C0011a f14341e;

    public b(d dVar, a.C0011a aVar, m mVar) {
        this.f14337a = mVar;
        this.f14338b = dVar;
        this.f14341e = aVar;
        this.f14340d = new z(dVar.u(), mVar);
        aa aaVar = new aa(dVar.u(), mVar, this);
        this.f14339c = aaVar;
        aaVar.a((e) dVar);
        if (v.a()) {
            v A = mVar.A();
            A.b("MaxNativeAdView", "Created new MaxNativeAdView (" + this + ")");
        }
    }

    private void a(long j2) {
        if (this.f14338b.y().compareAndSet(false, true)) {
            if (v.a()) {
                this.f14337a.A().b("MaxNativeAdView", "Scheduling viewability impression for ad...");
            }
            this.f14337a.E().processViewabilityAdImpressionPostback(this.f14338b, j2, this.f14341e);
        }
    }

    public void a() {
        this.f14339c.a();
    }

    public void b() {
        if (v.a()) {
            this.f14337a.A().b("MaxNativeAdView", "Handling view attached to window");
        }
        if (this.f14338b.x().compareAndSet(false, true)) {
            if (v.a()) {
                this.f14337a.A().b("MaxNativeAdView", "Scheduling impression for ad manually...");
            }
            this.f14337a.E().processRawAdImpressionPostback(this.f14338b, this.f14341e);
        }
    }

    public d c() {
        return this.f14338b;
    }

    public void onLogVisibilityImpression() {
        a(this.f14340d.a(this.f14338b));
    }
}
