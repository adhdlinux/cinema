package com.applovin.impl.mediation.c;

import com.applovin.impl.mediation.a.c;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

public class g extends ab {

    /* renamed from: a  reason: collision with root package name */
    private final c f14429a;

    public g(c cVar, m mVar) {
        super("TaskValidateMaxReward", mVar);
        this.f14429a = cVar;
    }

    /* access modifiers changed from: protected */
    public String a() {
        return "2.0/mvr";
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        super.a(i2);
        this.f14429a.a(com.applovin.impl.sdk.b.c.a((i2 < 400 || i2 >= 500) ? "network_timeout" : "rejected"));
    }

    /* access modifiers changed from: protected */
    public void a(com.applovin.impl.sdk.b.c cVar) {
        this.f14429a.a(cVar);
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "ad_unit_id", this.f14429a.getAdUnitId());
        JsonUtils.putString(jSONObject, "placement", this.f14429a.getPlacement());
        JsonUtils.putString(jSONObject, "custom_data", this.f14429a.Z());
        JsonUtils.putString(jSONObject, "ad_format", this.f14429a.getFormat().getLabel());
        String D = this.f14429a.D();
        if (!StringUtils.isValidString(D)) {
            D = "NO_MCODE";
        }
        JsonUtils.putString(jSONObject, "mcode", D);
        String C = this.f14429a.C();
        if (!StringUtils.isValidString(C)) {
            C = "NO_BCODE";
        }
        JsonUtils.putString(jSONObject, "bcode", C);
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        return this.f14429a.E();
    }
}
