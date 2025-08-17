package com.iab.omid.library.adcolony.d;

import android.os.Build;
import org.json.JSONObject;

public final class a {
    public static String a() {
        return Build.MANUFACTURER + "; " + Build.MODEL;
    }

    public static String b() {
        return Integer.toString(Build.VERSION.SDK_INT);
    }

    public static String c() {
        return "Android";
    }

    public static JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        b.h(jSONObject, "deviceType", a());
        b.h(jSONObject, "osVersion", b());
        b.h(jSONObject, "os", c());
        return jSONObject;
    }
}
