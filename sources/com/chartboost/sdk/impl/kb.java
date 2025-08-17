package com.chartboost.sdk.impl;

import com.chartboost.sdk.Mediation;
import kotlin.jvm.internal.Intrinsics;

public abstract class kb {
    public static final a5 a() {
        return i3.f17882b.m().a();
    }

    public static final q3 a(String str, String str2, Mediation mediation, a5 a5Var) {
        Intrinsics.f(str, "adType");
        Intrinsics.f(str2, "location");
        Intrinsics.f(a5Var, "eventTracker");
        return new r3(str, str2, mediation, a5Var);
    }
}
