package com.applovin.impl.mediation.debugger.b.a;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final d f14493a;

    /* renamed from: b  reason: collision with root package name */
    private final e f14494b;

    /* renamed from: c  reason: collision with root package name */
    private final List<e> f14495c;

    /* renamed from: d  reason: collision with root package name */
    private final List<com.applovin.impl.mediation.debugger.a.b> f14496d;

    public b(JSONObject jSONObject, MaxAdFormat maxAdFormat, com.applovin.impl.mediation.debugger.b.b.b bVar, m mVar) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "bidder_placement", (JSONObject) null);
        if (jSONObject2 != null) {
            this.f14494b = new e(jSONObject2, mVar);
        } else {
            this.f14494b = null;
        }
        this.f14493a = new d(JsonUtils.getString(jSONObject, "name", ""), JsonUtils.getString(jSONObject, "display_name", ""), jSONObject2 != null, bVar);
        this.f14496d = bVar.x() ? new ArrayList() : null;
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "placements", new JSONArray());
        this.f14495c = new ArrayList(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONArray, i2, (JSONObject) null);
            if (jSONObject3 != null) {
                this.f14495c.add(new e(jSONObject3, mVar));
            }
            List<com.applovin.impl.mediation.debugger.a.b> list = this.f14496d;
            if (list != null) {
                list.add(new com.applovin.impl.mediation.debugger.a.b(JsonUtils.getString(jSONObject3, "id", ""), JsonUtils.getJSONObject(jSONObject3, "amazon_marketplace", (JSONObject) null), maxAdFormat));
            }
        }
    }

    public d a() {
        return this.f14493a;
    }

    public e b() {
        return this.f14494b;
    }

    public boolean c() {
        return this.f14494b != null;
    }

    public List<e> d() {
        return this.f14495c;
    }

    public List<com.applovin.impl.mediation.debugger.a.b> e() {
        return this.f14496d;
    }
}
