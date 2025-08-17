package com.chartboost.sdk.impl;

import android.content.SharedPreferences;
import kotlin.jvm.internal.Intrinsics;

public final class va {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f18862a;

    public va(SharedPreferences sharedPreferences) {
        Intrinsics.f(sharedPreferences, "sharedPrefs");
        this.f18862a = sharedPreferences;
    }

    public final String a(String str) {
        Intrinsics.f(str, "sharedPrefsKey");
        try {
            return this.f18862a.getString(str, (String) null);
        } catch (Exception e2) {
            String a2 = wa.f18903a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "Load from shared prefs exception: " + e2);
            return null;
        }
    }

    public final void a(String str, String str2) {
        Intrinsics.f(str, "sharedPrefsKey");
        try {
            this.f18862a.edit().putString(str, str2).apply();
        } catch (Exception e2) {
            String a2 = wa.f18903a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "Save to shared prefs exception: " + e2);
        }
    }
}
