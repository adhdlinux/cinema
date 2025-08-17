package com.applovin.impl.mediation.debugger.b.a;

import com.applovin.impl.mediation.debugger.b.b.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class a implements Comparable<a> {

    /* renamed from: a  reason: collision with root package name */
    private final String f14488a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14489b;

    /* renamed from: c  reason: collision with root package name */
    private final MaxAdFormat f14490c;

    /* renamed from: d  reason: collision with root package name */
    private final c f14491d;

    /* renamed from: e  reason: collision with root package name */
    private final List<c> f14492e;

    public a(JSONObject jSONObject, Map<String, b> map, m mVar) {
        this.f14488a = JsonUtils.getString(jSONObject, "name", "");
        this.f14489b = JsonUtils.getString(jSONObject, "display_name", "");
        this.f14490c = MaxAdFormat.formatFromString(JsonUtils.getString(jSONObject, "format", (String) null));
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "waterfalls", new JSONArray());
        this.f14492e = new ArrayList(jSONArray.length());
        c cVar = null;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i2, (JSONObject) null);
            if (jSONObject2 != null) {
                c cVar2 = new c(jSONObject2, map, this.f14490c, mVar);
                this.f14492e.add(cVar2);
                if (cVar == null && cVar2.c()) {
                    cVar = cVar2;
                }
            }
        }
        this.f14491d = cVar;
    }

    private c g() {
        if (!this.f14492e.isEmpty()) {
            return this.f14492e.get(0);
        }
        return null;
    }

    /* renamed from: a */
    public int compareTo(a aVar) {
        return this.f14489b.compareToIgnoreCase(aVar.f14489b);
    }

    public String a() {
        return this.f14488a;
    }

    public String b() {
        return this.f14489b;
    }

    public String c() {
        MaxAdFormat maxAdFormat = this.f14490c;
        return maxAdFormat != null ? maxAdFormat.getLabel() : "Unknown";
    }

    public MaxAdFormat d() {
        return this.f14490c;
    }

    public c e() {
        c cVar = this.f14491d;
        return cVar != null ? cVar : g();
    }

    public String f() {
        return "\n---------- " + this.f14489b + " ----------" + "\nIdentifier - " + this.f14488a + "\nFormat     - " + c();
    }
}
