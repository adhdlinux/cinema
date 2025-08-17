package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.h2;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f1 {

    /* renamed from: a  reason: collision with root package name */
    public final String f17671a;

    /* renamed from: b  reason: collision with root package name */
    public final String f17672b;

    /* renamed from: c  reason: collision with root package name */
    public final String f17673c;

    public f1(String str, String str2, String str3) {
        this.f17671a = str;
        this.f17672b = str2;
        this.f17673c = str3;
    }

    public static Map b(JSONObject jSONObject, int i2) {
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("cache_assets");
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if ("templates".equals(next)) {
                    hashMap.putAll(a(jSONObject2, i2));
                } else {
                    hashMap.putAll(a(jSONObject2, next));
                }
            }
        } catch (JSONException e2) {
            w7.b("Asset", "v2PrefetchToAssets: " + e2.toString());
        }
        return hashMap;
    }

    public String a() {
        return this.f17673c;
    }

    public String toString() {
        return "Asset{directory='" + this.f17671a + '\'' + ", filename='" + this.f17672b + '\'' + ", url='" + this.f17673c + '\'' + '}';
    }

    public static Map a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            w7.a("Asset", "deserializeAssets assetsJson is null");
            return hashMap;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject jSONObject2 = jSONObject.getJSONObject(next);
            Iterator<String> keys2 = jSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                JSONObject jSONObject3 = jSONObject2.getJSONObject(next2);
                hashMap.put(next2, new f1(next, jSONObject3.getString("filename"), jSONObject3.getString(ImagesContract.URL)));
            }
        }
        return hashMap;
    }

    public static JSONObject a(JSONArray jSONArray) {
        JSONObject a2 = h2.a(new h2.a[0]);
        if (jSONArray == null) {
            return a2;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            String optString = jSONObject.optString("name");
            String optString2 = jSONObject.optString("type");
            String optString3 = jSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
            String optString4 = jSONObject.optString("param");
            if (!"param".equals(optString2) && optString4.isEmpty()) {
                JSONObject optJSONObject = a2.optJSONObject(optString2);
                if (optJSONObject == null) {
                    optJSONObject = h2.a(new h2.a[0]);
                    a2.put(optString2, optJSONObject);
                }
                optJSONObject.put("html".equals(optString2) ? "body" : optString, h2.a(h2.a("filename", (Object) optString), h2.a((String) ImagesContract.URL, (Object) optString3)));
            }
        }
        return a2;
    }

    public static Map a(JSONObject jSONObject, int i2) {
        JSONArray optJSONArray;
        HashMap hashMap = new HashMap();
        if (!(jSONObject == null || (optJSONArray = jSONObject.optJSONArray("templates")) == null)) {
            int min = Math.min(i2, optJSONArray.length());
            for (int i3 = 0; i3 < min; i3++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                for (Map.Entry value : a(jSONObject2 != null ? a(jSONObject2.getJSONArray("elements")) : null).entrySet()) {
                    f1 f1Var = (f1) value.getValue();
                    hashMap.put(f1Var.f17672b, f1Var);
                }
            }
        }
        return hashMap;
    }

    public static Map a(JSONObject jSONObject, String str) {
        HashMap hashMap = new HashMap();
        if (!(jSONObject == null || str == null)) {
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                String string = jSONObject2.getString("name");
                hashMap.put(string, new f1(str, string, jSONObject2.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE)));
            }
        }
        return hashMap;
    }

    public File a(File file) {
        if (this.f17671a == null || this.f17672b == null) {
            w7.a("Asset", "Cannot create file. Directory or filename is null.");
        } else {
            String str = this.f17671a + "/" + this.f17672b;
            try {
                return new File(file, str);
            } catch (Exception e2) {
                w7.a("Asset", "Cannot create file for path: " + str + ". Error: " + e2.toString());
            }
        }
        return null;
    }
}
