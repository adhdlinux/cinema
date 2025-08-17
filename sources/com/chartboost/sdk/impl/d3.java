package com.chartboost.sdk.impl;

import org.json.JSONObject;

public class d3 {
    public JSONObject a(b3 b3Var) {
        if (b3Var == null) {
            return new JSONObject();
        }
        return h2.a(h2.a("carrier-name", (Object) b3Var.d()), h2.a("mobile-country-code", (Object) b3Var.a()), h2.a("mobile-network-code", (Object) b3Var.b()), h2.a("iso-country-code", (Object) b3Var.c()), h2.a("phone-type", (Object) Integer.valueOf(b3Var.e())));
    }
}
