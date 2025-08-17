package com.chartboost.sdk.impl;

import com.google.android.gms.common.internal.ImagesContract;
import org.json.JSONObject;

public final class gc {
    public final String a(JSONObject jSONObject) {
        String str;
        if (jSONObject != null) {
            str = jSONObject.optString(ImagesContract.URL, "");
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public final x2 b(JSONObject jSONObject) {
        return new x2(a(jSONObject), c(jSONObject));
    }

    public final Boolean c(JSONObject jSONObject) {
        if (jSONObject != null) {
            return i2.a(jSONObject, "shouldDismiss");
        }
        return null;
    }
}
