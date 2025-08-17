package com.chartboost.sdk.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

public abstract class n {

    /* renamed from: a  reason: collision with root package name */
    public static final String f18208a = l.class.getSimpleName();

    public static final void a(v7 v7Var, Function1 function1, Function2 function2) {
        Intrinsics.f(v7Var, "<this>");
        Intrinsics.f(function1, "isSuccess");
        Intrinsics.f(function2, "isError");
        if (v7Var.b() == null) {
            function1.invoke(v7Var);
        } else {
            function2.invoke(v7Var, v7Var.b());
        }
    }
}
