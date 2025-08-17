package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.h;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

public class k extends h {

    /* renamed from: c  reason: collision with root package name */
    private final AppLovinAdLoadListener f15372c;

    public k(d dVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
        this(dVar, appLovinAdLoadListener, "TaskFetchNextAd", mVar);
    }

    public k(d dVar, AppLovinAdLoadListener appLovinAdLoadListener, String str, m mVar) {
        super(dVar, str, mVar);
        this.f15372c = appLovinAdLoadListener;
    }

    /* access modifiers changed from: protected */
    public a a(JSONObject jSONObject) {
        return new p(jSONObject, this.f15363a, h(), this.f15372c, this.f15333b);
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        super.a(i2);
        this.f15372c.failedToReceiveAd(i2);
    }

    /* access modifiers changed from: protected */
    public String b() {
        return h.g(this.f15333b);
    }

    /* access modifiers changed from: protected */
    public String c() {
        return h.h(this.f15333b);
    }
}
