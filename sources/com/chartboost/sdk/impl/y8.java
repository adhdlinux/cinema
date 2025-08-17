package com.chartboost.sdk.impl;

import com.chartboost.sdk.internal.Model.CBError;
import org.json.JSONException;
import org.json.JSONObject;

public class y8 extends t2 {

    /* renamed from: s  reason: collision with root package name */
    public static final String f19091s = "y8";

    public y8(g8 g8Var, o oVar, q8 q8Var, z4 z4Var) {
        super(g8Var.f17756a, g8Var.f17757b, g8Var.f17758c, g8Var.f17759d, g8Var.f17760e, (String) null, g8Var.f17761f, z4Var);
        this.f18625p = new z8(g8Var.f17759d, oVar, q8Var).f();
    }

    public o2 a(p2 p2Var) {
        try {
            return o2.a((Object) new JSONObject(new String(p2Var.a())));
        } catch (JSONException e2) {
            String str = f19091s;
            w7.b(str, "parseServerResponse: " + e2);
            return o2.a(new CBError(CBError.a.HTTP_NOT_FOUND, "No Bid"));
        }
    }

    public void g() {
    }
}
