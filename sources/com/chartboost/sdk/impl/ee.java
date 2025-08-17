package com.chartboost.sdk.impl;

import android.os.Build;
import org.json.JSONObject;

public abstract class ee {
    public static String a() {
        return Build.MANUFACTURER + "; " + Build.MODEL;
    }

    public static String b() {
        return "Android";
    }

    public static String c() {
        return Integer.toString(Build.VERSION.SDK_INT);
    }

    public static JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        me.a(jSONObject, "deviceType", a());
        me.a(jSONObject, "osVersion", c());
        me.a(jSONObject, "os", b());
        return jSONObject;
    }
}
