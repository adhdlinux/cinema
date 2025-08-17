package com.chartboost.sdk.impl;

import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

public abstract class hc {

    /* renamed from: a  reason: collision with root package name */
    public static final Regex f17874a = new Regex("^market://details\\?id=(.*)$");

    public static final String a(ec ecVar) {
        List<String> a2;
        MatchResult f2 = f17874a.f(ecVar.b());
        if (f2 == null || (a2 = f2.a()) == null) {
            return null;
        }
        return (String) CollectionsKt___CollectionsKt.E(a2, 1);
    }

    public static final ec b(ec ecVar) {
        Intrinsics.f(ecVar, "<this>");
        String a2 = a(ecVar);
        if (a2 == null) {
            return ecVar;
        }
        String format = String.format("https://play.google.com/store/apps/details?id=%s", Arrays.copyOf(new Object[]{a2}, 1));
        Intrinsics.e(format, "format(this, *args)");
        ec a3 = ec.a(ecVar, format, (l3) null, 2, (Object) null);
        if (a3 == null) {
            return ecVar;
        }
        return a3;
    }
}
