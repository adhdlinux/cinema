package com.chartboost.sdk.impl;

import android.content.SharedPreferences;
import kotlin.jvm.internal.Intrinsics;

public final class bb {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f17302a;

    public bb(SharedPreferences sharedPreferences) {
        Intrinsics.f(sharedPreferences, "defaultSharedPreferences");
        this.f17302a = sharedPreferences;
    }

    public final String a() {
        return this.f17302a.getString("IABTCF_TCString", (String) null);
    }
}
