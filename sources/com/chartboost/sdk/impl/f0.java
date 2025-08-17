package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.n7;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.model.AdPayload;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    public final q1 f17665a;

    /* renamed from: b  reason: collision with root package name */
    public String f17666b = "";

    /* renamed from: c  reason: collision with root package name */
    public int f17667c;

    /* renamed from: d  reason: collision with root package name */
    public String f17668d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f17669e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f17670f = "";

    public f0(q1 q1Var) {
        Intrinsics.f(q1Var, "base64Wrapper");
        this.f17665a = q1Var;
    }

    public final v a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject2 != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            JSONObject jSONObject3 = jSONObject2.getJSONObject("webview");
            JSONArray jSONArray = jSONObject3.getJSONArray("elements");
            Intrinsics.e(jSONArray, "it.getJSONArray(ELEMENTS_JSON_FIELD)");
            a(jSONArray, linkedHashMap, linkedHashMap2);
            String string = jSONObject3.getString(AdPayload.KEY_TEMPLATE);
            Intrinsics.e(string, "it.getString(TEMPLATE_ELEMENT)");
            String optString = jSONObject2.optString("name");
            String string2 = jSONObject2.getString("ad_id");
            String str = this.f17669e;
            String optString2 = jSONObject2.optString("baseurl");
            n7 c2 = c(jSONObject2.optJSONObject("infoicon"));
            String string3 = jSONObject2.getString("cgn");
            String string4 = jSONObject2.getString("creative");
            String optString3 = jSONObject2.optString("media-type");
            String str2 = this.f17666b;
            String a2 = g0.a(str2);
            String string5 = jSONObject2.getString("link");
            String optString4 = jSONObject2.optString("deep-link");
            String string6 = jSONObject2.getString("to");
            LinkedHashMap linkedHashMap3 = linkedHashMap2;
            int i2 = this.f17667c;
            String str3 = this.f17668d;
            String str4 = string6;
            f1 f1Var = (f1) linkedHashMap.get("body");
            if (f1Var != null) {
                String str5 = string;
                aa a3 = aa.f17218c.a(jSONObject2.optString("renderingengine"));
                List a4 = a(jSONObject2.optJSONArray("scripts"));
                Map b2 = b(jSONObject2.optJSONObject("events"));
                y7 a5 = g0.a(jSONObject2.optInt("mtype"));
                l3 a6 = l3.f18098c.a(jSONObject2.optInt("clkp"));
                String str6 = this.f17670f;
                String str7 = string5;
                String str8 = optString4;
                String str9 = str3;
                String str10 = str4;
                v vVar = r2;
                Intrinsics.e(optString, "optString(NAME_JSON_FIELD)");
                Intrinsics.e(string2, "getString(ADID_JSON_FIELD)");
                Intrinsics.e(optString2, "optString(BASE_URL_JSON_FIELD)");
                Intrinsics.e(string3, "getString(CGN_JSON_FIELD)");
                Intrinsics.e(string4, "getString(CREATIVE_JSON_FIELD)");
                Intrinsics.e(optString3, "optString(MEDIA_TYPE_JSON_FIELD)");
                Intrinsics.e(str7, "getString(LINK_JSON_FIELD)");
                Intrinsics.e(str8, "optString(DEEP_LINK_JSON_FIELD)");
                Intrinsics.e(str10, "getString(TO_JSON_FIELD)");
                String str11 = str5;
                LinkedHashMap linkedHashMap4 = linkedHashMap3;
                String str12 = str9;
                String str13 = str10;
                v vVar2 = new v(optString, string2, optString2, str, c2, string3, string4, optString3, linkedHashMap, str2, a2, str7, str8, str13, i2, str12, str11, f1Var, linkedHashMap4, a3, a4, b2, (String) null, (String) null, a5, a6, str6, 12582912, (DefaultConstructorMarker) null);
                return vVar;
            }
            throw new IllegalStateException("WebView AdUnit does not have a template html body asset".toString());
        }
        throw new JSONException("Missing response");
    }

    public final Map b(JSONObject jSONObject) {
        Iterator<String> keys;
        HashMap hashMap = new HashMap();
        if (!(jSONObject == null || (keys = jSONObject.keys()) == null)) {
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray jSONArray = jSONObject.getJSONArray(next);
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    String string = jSONArray.getString(i2);
                    Intrinsics.e(string, "urlArray.getString(i)");
                    arrayList.add(string);
                }
                Intrinsics.e(next, "it");
                hashMap.put(next, arrayList);
            }
        }
        return hashMap;
    }

    public final n7 c(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject2 == null) {
            return new n7((String) null, (String) null, (n7.b) null, (n7.a) null, (n7.a) null, (n7.a) null, 63, (DefaultConstructorMarker) null);
        }
        String optString = jSONObject2.optString("imageurl");
        Intrinsics.e(optString, "jsonObject.optString(INF…CON_IMAGE_URL_JSON_FIELD)");
        String optString2 = jSONObject2.optString("clickthroughUrl");
        Intrinsics.e(optString2, "jsonObject.optString(INF…CKTHROUGH_URL_JSON_FIELD)");
        return new n7(optString, optString2, n7.b.f18247c.a(jSONObject2.optInt(ViewProps.POSITION)), d(jSONObject2.optJSONObject(ViewProps.MARGIN)), d(jSONObject2.optJSONObject(ViewProps.PADDING)), d(jSONObject2.optJSONObject("size")));
    }

    public final n7.a d(JSONObject jSONObject) {
        if (jSONObject != null) {
            return new n7.a(jSONObject.optDouble("w"), jSONObject.optDouble("h"));
        }
        return new n7.a(0.0d, 0.0d, 3, (DefaultConstructorMarker) null);
    }

    public final void a(JSONArray jSONArray, Map map, Map map2) {
        for (JSONObject jSONObject : r5.asList(jSONArray)) {
            String string = jSONObject.getString("name");
            String string2 = jSONObject.getString("type");
            String string3 = jSONObject.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
            String optString = jSONObject.optString("param");
            if (string2 != null) {
                int hashCode = string2.hashCode();
                if (hashCode != -1333900842) {
                    if (hashCode != 3213227) {
                        if (hashCode == 106436749 && string2.equals("param")) {
                            Intrinsics.e(optString, "param");
                            Intrinsics.e(string3, AppMeasurementSdk.ConditionalUserProperty.VALUE);
                            map2.put(optString, string3);
                            if (string != null) {
                                int hashCode2 = string.hashCode();
                                if (hashCode2 != -1422292723) {
                                    if (hashCode2 != -1389119727) {
                                        if (hashCode2 != -878282975) {
                                            if (hashCode2 == -315925656 && string.equals("reward_amount")) {
                                                a(string3);
                                            }
                                        } else if (string.equals("reward_currency")) {
                                            this.f17668d = string3;
                                        }
                                    } else if (string.equals("impression_id")) {
                                        this.f17669e = string3;
                                    }
                                } else if (string.equals("adm.js")) {
                                    this.f17670f = this.f17665a.b(string3);
                                }
                            }
                        }
                    } else if (string2.equals("html")) {
                        Intrinsics.e(optString, "param");
                        if (optString.length() == 0) {
                            optString = "body";
                        }
                        Intrinsics.e(optString, "param");
                        map.put(optString, new f1(string2, string, string3));
                    }
                } else if (string2.equals("preCachedVideo")) {
                    Intrinsics.e(string3, AppMeasurementSdk.ConditionalUserProperty.VALUE);
                    this.f17666b = string3;
                }
            }
            Intrinsics.e(optString, "param");
            if (optString.length() == 0) {
                optString = string;
            }
            Intrinsics.e(optString, "param");
            map.put(optString, new f1(string2, string, string3));
        }
    }

    public final void a(String str) {
        int i2;
        try {
            i2 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            i2 = 0;
        }
        this.f17667c = i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = com.chartboost.sdk.impl.r5.asList(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List a(org.json.JSONArray r1) {
        /*
            r0 = this;
            if (r1 == 0) goto L_0x0008
            java.util.List r1 = com.chartboost.sdk.impl.r5.asList(r1)
            if (r1 != 0) goto L_0x000c
        L_0x0008:
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.f()
        L_0x000c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.f0.a(org.json.JSONArray):java.util.List");
    }
}
