package com.applovin.impl.mediation.debugger.b.a;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import org.json.JSONObject;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final String f14506a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14507b;

    public e(JSONObject jSONObject, m mVar) {
        this.f14506a = JsonUtils.getString(jSONObject, "id", "");
        this.f14507b = JsonUtils.getString(jSONObject, InAppPurchaseMetaData.KEY_PRICE, (String) null);
    }

    public String a() {
        return this.f14506a;
    }

    public String b() {
        return this.f14507b;
    }
}
