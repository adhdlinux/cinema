package com.applovin.impl.mediation.c;

import com.applovin.impl.mediation.a.c;
import com.applovin.impl.sdk.e.w;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.v;
import org.json.JSONObject;

public class f extends w {

    /* renamed from: a  reason: collision with root package name */
    private final c f14428a;

    public f(c cVar, m mVar) {
        super("TaskReportMaxReward", mVar);
        this.f14428a = cVar;
    }

    /* access modifiers changed from: protected */
    public String a() {
        return "2.0/mcr";
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        super.a(i2);
        if (v.a()) {
            a("Failed to report reward for mediated ad: " + this.f14428a + " - error code: " + i2);
        }
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "ad_unit_id", this.f14428a.getAdUnitId());
        JsonUtils.putString(jSONObject, "placement", this.f14428a.getPlacement());
        JsonUtils.putString(jSONObject, "custom_data", this.f14428a.Z());
        String D = this.f14428a.D();
        if (!StringUtils.isValidString(D)) {
            D = "NO_MCODE";
        }
        JsonUtils.putString(jSONObject, "mcode", D);
        String C = this.f14428a.C();
        if (!StringUtils.isValidString(C)) {
            C = "NO_BCODE";
        }
        JsonUtils.putString(jSONObject, "bcode", C);
    }

    /* access modifiers changed from: protected */
    public com.applovin.impl.sdk.b.c b() {
        return this.f14428a.G();
    }

    /* access modifiers changed from: protected */
    public void b(JSONObject jSONObject) {
        a("Reported reward successfully for mediated ad: " + this.f14428a);
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (v.a()) {
            d("No reward result was found for mediated ad: " + this.f14428a);
        }
    }
}
