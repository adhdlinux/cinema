package com.chartboost.sdk.impl;

import org.json.JSONObject;

public final class nd {

    public interface a {
        void a(JSONObject jSONObject);
    }

    public final void a(String str, a aVar) {
        if (a(str)) {
            w7.b("Chartboost", "CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource");
            if (aVar != null) {
                aVar.a(new JSONObject().put("message", "CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource"));
            }
        }
    }

    public final boolean a(String str) {
        if (str == null || !StringsKt__StringsKt.L(str, "Access-Control-Allow-Origin", false, 2, (Object) null) || !StringsKt__StringsKt.L(str, "'null'", false, 2, (Object) null) || StringsKt__StringsKt.L(str, "http://", false, 2, (Object) null) || StringsKt__StringsKt.L(str, "https://", false, 2, (Object) null)) {
            return false;
        }
        return true;
    }
}
