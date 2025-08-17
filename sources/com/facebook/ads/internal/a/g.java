package com.facebook.ads.internal.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private final String f19650a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19651b;

    /* renamed from: c  reason: collision with root package name */
    private final String f19652c;

    /* renamed from: d  reason: collision with root package name */
    private final List<String> f19653d;

    /* renamed from: e  reason: collision with root package name */
    private final String f19654e;

    /* renamed from: f  reason: collision with root package name */
    private final String f19655f;

    private g(String str, String str2, String str3, List<String> list, String str4, String str5) {
        this.f19650a = str;
        this.f19651b = str2;
        this.f19652c = str3;
        this.f19653d = list;
        this.f19654e = str4;
        this.f19655f = str5;
    }

    public static g a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("package");
        String optString2 = jSONObject.optString("appsite");
        String optString3 = jSONObject.optString("appsite_url");
        JSONArray optJSONArray = jSONObject.optJSONArray("key_hashes");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                arrayList.add(optJSONArray.optString(i2));
            }
        }
        return new g(optString, optString2, optString3, arrayList, jSONObject.optString("market_uri"), jSONObject.optString("fallback_url"));
    }

    public String a() {
        return this.f19650a;
    }

    public String b() {
        return this.f19651b;
    }

    public String c() {
        return this.f19652c;
    }
}
