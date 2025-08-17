package com.applovin.impl.mediation.a;

import com.applovin.impl.mediation.g;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.vungle.ads.internal.model.AdPayload;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class d extends e {

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f14227c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f14228d = new AtomicBoolean();

    private d(d dVar, g gVar) {
        super(dVar.T(), dVar.J(), dVar.I(), gVar, dVar.f14230b);
    }

    public d(Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, m mVar) {
        super(map, jSONObject, jSONObject2, (g) null, mVar);
    }

    public a a(g gVar) {
        return new d(this, gVar);
    }

    public void a(MaxNativeAdView maxNativeAdView) {
        this.f14220a.a(maxNativeAdView);
    }

    public MaxNativeAd getNativeAd() {
        return this.f14220a.b();
    }

    public MaxNativeAdView u() {
        return this.f14220a.c();
    }

    public String v() {
        return BundleUtils.getString(AdPayload.KEY_TEMPLATE, "", U());
    }

    public boolean w() {
        return this.f14220a == null;
    }

    public AtomicBoolean x() {
        return this.f14227c;
    }

    public AtomicBoolean y() {
        return this.f14228d;
    }
}
