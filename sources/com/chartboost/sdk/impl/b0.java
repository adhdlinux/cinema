package com.chartboost.sdk.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class b0 implements a {

    /* renamed from: a  reason: collision with root package name */
    public final List f17253a = new ArrayList();

    public JSONObject a(JSONObject jSONObject) {
        Intrinsics.f(jSONObject, "response");
        for (a a2 : this.f17253a) {
            jSONObject = (JSONObject) a2.a(jSONObject);
        }
        return jSONObject;
    }
}
