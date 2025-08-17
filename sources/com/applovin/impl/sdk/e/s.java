package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.ad.a;
import com.applovin.impl.sdk.ad.b;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import org.json.JSONObject;

class s extends a {

    /* renamed from: a  reason: collision with root package name */
    private final JSONObject f15430a;

    /* renamed from: c  reason: collision with root package name */
    private final JSONObject f15431c;

    /* renamed from: d  reason: collision with root package name */
    private final AppLovinAdLoadListener f15432d;

    /* renamed from: e  reason: collision with root package name */
    private final b f15433e;

    s(JSONObject jSONObject, JSONObject jSONObject2, b bVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
        super("TaskRenderAppLovinAd", mVar);
        this.f15430a = jSONObject;
        this.f15431c = jSONObject2;
        this.f15433e = bVar;
        this.f15432d = appLovinAdLoadListener;
    }

    public void run() {
        if (v.a()) {
            a("Rendering ad...");
        }
        a aVar = new a(this.f15430a, this.f15431c, this.f15433e, this.f15333b);
        boolean booleanValue = JsonUtils.getBoolean(this.f15430a, "gs_load_immediately", Boolean.FALSE).booleanValue();
        boolean booleanValue2 = JsonUtils.getBoolean(this.f15430a, "vs_load_immediately", Boolean.TRUE).booleanValue();
        d dVar = new d(aVar, this.f15333b, this.f15432d);
        dVar.a(booleanValue2);
        dVar.b(booleanValue);
        o.a aVar2 = o.a.CACHING_OTHER;
        if (((Boolean) this.f15333b.a(com.applovin.impl.sdk.c.b.bi)).booleanValue()) {
            AppLovinAdSize size = aVar.getSize();
            AppLovinAdSize appLovinAdSize = AppLovinAdSize.INTERSTITIAL;
            if (size == appLovinAdSize && aVar.getType() == AppLovinAdType.REGULAR) {
                aVar2 = o.a.CACHING_INTERSTITIAL;
            } else if (aVar.getSize() == appLovinAdSize && aVar.getType() == AppLovinAdType.INCENTIVIZED) {
                aVar2 = o.a.CACHING_INCENTIVIZED;
            }
        }
        this.f15333b.S().a((a) dVar, aVar2);
    }
}
