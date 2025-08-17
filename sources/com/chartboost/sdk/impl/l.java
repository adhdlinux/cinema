package com.chartboost.sdk.impl;

import com.vungle.ads.internal.presenter.MRAIDPresenter;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public interface l {

    public static final class a {
        public static String a(l lVar, JSONObject jSONObject, String str, String str2) {
            Intrinsics.f(jSONObject, "$receiver");
            Intrinsics.f(str, MRAIDPresenter.ERROR);
            Intrinsics.f(str2, "response");
            try {
                jSONObject.put(MRAIDPresenter.ERROR, str);
                jSONObject.put("response", str2);
            } catch (Exception e2) {
                String a2 = n.f18208a;
                Intrinsics.e(a2, "TAG");
                w7.b(a2, "Cannot create error json for the event: " + e2);
            }
            String jSONObject2 = jSONObject.toString();
            Intrinsics.e(jSONObject2, "apply {\n            try …   }\n        }.toString()");
            return jSONObject2;
        }
    }

    void a(u7 u7Var, Function1 function1);
}
