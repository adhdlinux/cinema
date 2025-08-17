package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.b.c;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

public class v extends w {

    /* renamed from: a  reason: collision with root package name */
    private final e f15444a;

    public v(e eVar, m mVar) {
        super("TaskReportAppLovinReward", mVar);
        this.f15444a = eVar;
    }

    /* access modifiers changed from: protected */
    public String a() {
        return "2.0/cr";
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        super.a(i2);
        if (com.applovin.impl.sdk.v.a()) {
            d("Failed to report reward for ad: " + this.f15444a + " - error code: " + i2);
        }
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "zone_id", this.f15444a.getAdZone().a());
        JsonUtils.putInt(jSONObject, "fire_percent", this.f15444a.ae());
        String clCode = this.f15444a.getClCode();
        if (!StringUtils.isValidString(clCode)) {
            clCode = "NO_CLCODE";
        }
        JsonUtils.putString(jSONObject, "clcode", clCode);
    }

    /* access modifiers changed from: protected */
    public c b() {
        return this.f15444a.aG();
    }

    /* access modifiers changed from: protected */
    public void b(JSONObject jSONObject) {
        if (com.applovin.impl.sdk.v.a()) {
            a("Reported reward successfully for ad: " + this.f15444a);
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (com.applovin.impl.sdk.v.a()) {
            d("No reward result was found for ad: " + this.f15444a);
        }
    }
}
