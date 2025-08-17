package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.f;
import com.chartboost.sdk.internal.Model.CBError;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f17714a = new g();

    public Object a(String str, q1 q1Var, Function2 function2) {
        String str2;
        Intrinsics.f(q1Var, "base64Wrapper");
        Intrinsics.f(function2, "onAdFailToLoad");
        if (str != null) {
            str2 = q1Var.b(str);
            if (str2.length() == 0) {
                w7.b("AdApi", "Cannot decode provided bidResponse.");
                function2.invoke("", CBError.CBImpressionError.INVALID_RESPONSE);
                Result.Companion companion = Result.f40263c;
                return Result.b(ResultKt.a(f.a.f17664b));
            }
        } else {
            str2 = null;
        }
        return Result.b(str2);
    }
}
