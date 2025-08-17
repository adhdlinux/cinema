package com.applovin.impl.mediation.debugger.b.a;

import com.applovin.impl.mediation.debugger.a.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.facebook.hermes.intl.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final String f14497a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f14498b;

    /* renamed from: c  reason: collision with root package name */
    private final List<b> f14499c;

    /* renamed from: d  reason: collision with root package name */
    private final List<b> f14500d;

    /* renamed from: e  reason: collision with root package name */
    private final List<b> f14501e;

    c(JSONObject jSONObject, Map<String, com.applovin.impl.mediation.debugger.b.b.b> map, MaxAdFormat maxAdFormat, m mVar) {
        List<b> list;
        b bVar;
        this.f14497a = JsonUtils.getString(jSONObject, "name", "");
        this.f14498b = JsonUtils.getBoolean(jSONObject, Constants.COLLATION_DEFAULT, Boolean.FALSE).booleanValue();
        JSONObject jSONObject2 = jSONObject;
        Map<String, com.applovin.impl.mediation.debugger.b.b.b> map2 = map;
        MaxAdFormat maxAdFormat2 = maxAdFormat;
        m mVar2 = mVar;
        this.f14499c = a("bidders", jSONObject2, map2, maxAdFormat2, mVar2);
        List<b> a2 = a("waterfall", jSONObject2, map2, maxAdFormat2, mVar2);
        this.f14500d = a2;
        Iterator<b> it2 = a2.iterator();
        while (true) {
            list = null;
            if (!it2.hasNext()) {
                bVar = null;
                break;
            }
            bVar = it2.next();
            if (bVar.a().c().x()) {
                break;
            }
        }
        this.f14501e = bVar != null ? bVar.e() : list;
    }

    private List<b> a(String str, JSONObject jSONObject, Map<String, com.applovin.impl.mediation.debugger.b.b.b> map, MaxAdFormat maxAdFormat, m mVar) {
        com.applovin.impl.mediation.debugger.b.b.b bVar;
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, str, new JSONArray());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i2, (JSONObject) null);
            if (!(jSONObject2 == null || (bVar = map.get(JsonUtils.getString(jSONObject2, "adapter_class", ""))) == null)) {
                arrayList.add(new b(jSONObject2, maxAdFormat, bVar, mVar));
            }
        }
        return arrayList;
    }

    public List<b> a() {
        return this.f14499c;
    }

    public List<b> b() {
        return this.f14500d;
    }

    public boolean c() {
        return this.f14498b;
    }

    public List<b> d() {
        return this.f14501e;
    }
}
