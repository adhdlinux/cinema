package com.applovin.impl.sdk.nativeAd;

import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.e.a;
import com.applovin.impl.sdk.e.h;
import com.applovin.impl.sdk.m;
import org.json.JSONObject;

public class c extends h {

    /* renamed from: c  reason: collision with root package name */
    private final AppLovinNativeAdLoadListener f15576c;

    public c(d dVar, String str, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, m mVar) {
        super(dVar, str, mVar);
        this.f15576c = appLovinNativeAdLoadListener;
    }

    /* access modifiers changed from: protected */
    public a a(JSONObject jSONObject) {
        return new d(jSONObject, this.f15576c, this.f15333b);
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        super.a(i2);
        this.f15576c.onNativeAdLoadFailed(i2);
    }

    /* access modifiers changed from: protected */
    public String b() {
        return com.applovin.impl.sdk.utils.h.i(this.f15333b);
    }

    /* access modifiers changed from: protected */
    public String c() {
        return com.applovin.impl.sdk.utils.h.j(this.f15333b);
    }
}
