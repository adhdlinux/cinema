package com.chartboost.sdk.impl;

import com.facebook.react.uimanager.ViewProps;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public abstract class pb {

    /* renamed from: a  reason: collision with root package name */
    public static final List f18385a = CollectionsKt__CollectionsKt.f();

    public static final List a() {
        return f18385a;
    }

    public static final ob b(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        Intrinsics.f(jSONObject2, "<this>");
        JSONObject optJSONObject = jSONObject2.optJSONObject("tracking");
        if (optJSONObject == null) {
            return new ob(false, (List) null, (String) null, 0, 0, false, 0, 127, (DefaultConstructorMarker) null);
        }
        boolean optBoolean = optJSONObject.optBoolean(ViewProps.ENABLED, false);
        String optString = optJSONObject.optString("endpoint", "https://ssp-events.chartboost.com/track/sdk");
        int optInt = optJSONObject.optInt("eventLimit", 10);
        int optInt2 = optJSONObject.optInt("windowDuration", 60);
        boolean optBoolean2 = optJSONObject.optBoolean("persistenceEnabled", true);
        int optInt3 = optJSONObject.optInt("persistenceMaxEvents", 100);
        List a2 = a(optJSONObject);
        Intrinsics.e(optString, "optString(TRACKING_ENDPO…NDPOINT_TRACKING_DEFAULT)");
        return new ob(optBoolean, a2, optString, optInt, optInt2, optBoolean2, optInt3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r1 = com.chartboost.sdk.impl.ub.a((r1 = com.chartboost.sdk.impl.r5.asList(r1)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List a(org.json.JSONObject r1) {
        /*
            java.lang.String r0 = "blacklist"
            org.json.JSONArray r1 = r1.optJSONArray(r0)
            if (r1 == 0) goto L_0x0015
            java.util.List r1 = com.chartboost.sdk.impl.r5.asList(r1)
            if (r1 == 0) goto L_0x0015
            java.util.List r1 = com.chartboost.sdk.impl.ub.a(r1)
            if (r1 == 0) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            java.util.List r1 = f18385a
        L_0x0017:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.pb.a(org.json.JSONObject):java.util.List");
    }
}
