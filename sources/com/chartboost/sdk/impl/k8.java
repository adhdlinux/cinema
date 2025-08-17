package com.chartboost.sdk.impl;

import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class k8 {
    public static final List a(JSONObject jSONObject) {
        List<JSONObject> asListSkipNull;
        pc pcVar;
        Intrinsics.f(jSONObject, "<this>");
        JSONArray optJSONArray = jSONObject.optJSONArray("verification");
        if (optJSONArray == null || (asListSkipNull = r5.asListSkipNull(optJSONArray)) == null) {
            return CollectionsKt__CollectionsKt.f();
        }
        ArrayList arrayList = new ArrayList();
        for (JSONObject jSONObject2 : asListSkipNull) {
            try {
                String string = jSONObject2.getString(ImagesContract.URL);
                Intrinsics.e(string, "it.getString(\"url\")");
                String string2 = jSONObject2.getString("vendor");
                Intrinsics.e(string2, "it.getString(\"vendor\")");
                String string3 = jSONObject2.getString("params");
                Intrinsics.e(string3, "it.getString(\"params\")");
                pcVar = new pc(string, string2, string3);
            } catch (Exception unused) {
                pcVar = null;
            }
            if (pcVar != null) {
                arrayList.add(pcVar);
            }
        }
        return arrayList;
    }

    public static final j8 b(JSONObject jSONObject) {
        Intrinsics.f(jSONObject, "config");
        List a2 = a(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("viewabilitySettings");
        if (optJSONObject == null) {
            return new j8(jSONObject.optBoolean(ViewProps.ENABLED, false), jSONObject.optBoolean("verificationEnabled", false), 0, 0, 0, 0, a2, 60, (DefaultConstructorMarker) null);
        }
        return new j8(jSONObject.optBoolean(ViewProps.ENABLED, false), jSONObject.optBoolean("verificationEnabled", false), optJSONObject.optInt("minVisibleDips", 1), optJSONObject.optInt("minVisibleDurationMs", 0), optJSONObject.optLong("visibilityCheckIntervalMs", 100), optJSONObject.optInt("traversalLimit", 25), a2);
    }
}
