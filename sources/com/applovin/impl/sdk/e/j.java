package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.ad.b;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class j extends k {

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f15371c;

    public j(List<String> list, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
        super(d.a(a(list)), appLovinAdLoadListener, "TaskFetchMultizoneAd", mVar);
        this.f15371c = Collections.unmodifiableList(list);
    }

    private static String a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        throw new IllegalArgumentException("No zone identifiers specified");
    }

    /* access modifiers changed from: protected */
    public Map<String, String> a() {
        HashMap hashMap = new HashMap(1);
        List<String> list = this.f15371c;
        hashMap.put("zone_ids", CollectionUtils.implode(list, list.size()));
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public b h() {
        return b.APPLOVIN_MULTIZONE;
    }
}
