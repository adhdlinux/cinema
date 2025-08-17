package com.applovin.impl.sdk.nativeAd;

import com.applovin.impl.sdk.ad.c;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.m;
import java.util.HashMap;
import java.util.Map;

public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    private final c f15575c;

    public b(c cVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, m mVar) {
        super(d.a("adtoken_zone"), "TaskFetchNativeTokenAd", appLovinNativeAdLoadListener, mVar);
        this.f15575c = cVar;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> a() {
        HashMap hashMap = new HashMap(2);
        hashMap.put("adtoken", this.f15575c.a());
        hashMap.put("adtoken_prefix", this.f15575c.c());
        return hashMap;
    }
}
