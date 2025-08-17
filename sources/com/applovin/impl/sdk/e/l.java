package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.ad.b;
import com.applovin.impl.sdk.ad.c;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.m;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.HashMap;
import java.util.Map;

public class l extends k {

    /* renamed from: c  reason: collision with root package name */
    private final c f15373c;

    public l(c cVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
        super(d.a("adtoken_zone"), appLovinAdLoadListener, "TaskFetchTokenAd", mVar);
        this.f15373c = cVar;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> a() {
        HashMap hashMap = new HashMap(2);
        hashMap.put("adtoken", this.f15373c.a());
        hashMap.put("adtoken_prefix", this.f15373c.c());
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public b h() {
        return b.REGULAR_AD_TOKEN;
    }
}
