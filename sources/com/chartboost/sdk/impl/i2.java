package com.chartboost.sdk.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class i2 {
    public static final JSONObject a(JSONObject jSONObject, String str, Object obj) {
        Intrinsics.f(jSONObject, "<this>");
        Intrinsics.f(str, "name");
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e2) {
            w7.b("CBJSON", "put (" + str + ')' + e2);
        }
        return jSONObject;
    }

    public static final Boolean a(JSONObject jSONObject, String str) {
        Intrinsics.f(jSONObject, "<this>");
        Intrinsics.f(str, "name");
        try {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static final byte[] a(JSONArray jSONArray) {
        Intrinsics.f(jSONArray, "<this>");
        String jSONArray2 = jSONArray.toString();
        Intrinsics.e(jSONArray2, "toString()");
        byte[] bytes = jSONArray2.getBytes(Charsets.f40513b);
        Intrinsics.e(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }
}
