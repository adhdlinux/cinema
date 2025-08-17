package com.chartboost.sdk.impl;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class h2 {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f17829a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f17830b;

        public a(String str, Object obj) {
            this.f17829a = str;
            this.f17830b = obj;
        }
    }

    public static JSONObject a(JSONObject jSONObject, String... strArr) {
        for (String str : strArr) {
            if (jSONObject == null) {
                break;
            }
            jSONObject = jSONObject.optJSONObject(str);
        }
        return jSONObject;
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e2) {
            w7.b("CBJSON", "put (" + str + ")" + e2.toString());
        }
    }

    public static JSONObject a(a... aVarArr) {
        JSONObject jSONObject = new JSONObject();
        for (a aVar : aVarArr) {
            a(jSONObject, aVar.f17829a, aVar.f17830b);
        }
        return jSONObject;
    }

    public static a a(String str, Object obj) {
        return new a(str, obj);
    }
}
