package com.chartboost.sdk.impl;

import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    public static final d0 f17397a = new d0();

    public final Pair a(b1 b1Var, u7 u7Var, Function2 function2, Function2 function22) {
        Intrinsics.f(b1Var, "appRequest");
        Intrinsics.f(u7Var, "params");
        Intrinsics.f(function2, "loadOpenRTBAd");
        Intrinsics.f(function22, "loadAdGet");
        if (b1Var.c() != null) {
            return new Pair(function2, u7Var);
        }
        return new Pair(function22, u7Var);
    }
}
