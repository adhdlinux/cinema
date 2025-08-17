package com.chartboost.sdk.impl;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.List;
import org.json.JSONArray;

public abstract class r5 {
    public static final <T> List<T> asList(JSONArray jSONArray) {
        return s5.a(jSONArray);
    }

    public static final <T> List<T> asListSkipNull(JSONArray jSONArray) {
        return s5.b(jSONArray);
    }

    public static final PackageInfo getPackageInfoCompat(PackageManager packageManager, String str, int i2) {
        return s5.a(packageManager, str, i2);
    }

    public static final String getPackageVersionName(PackageManager packageManager, String str) {
        return s5.a(packageManager, str);
    }

    public static final hb toBodyFields(gb gbVar) {
        return s5.a(gbVar);
    }

    public static final t9 toReachabilityBodyFields(r2 r2Var) {
        return s5.a(r2Var);
    }
}
