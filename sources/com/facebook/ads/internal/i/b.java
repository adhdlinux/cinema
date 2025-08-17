package com.facebook.ads.internal.i;

import android.os.Build;
import org.json.JSONException;
import org.json.JSONObject;

class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f20209a = "b";

    b() {
    }

    static String a() {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "is_emu", String.valueOf(b()));
        return jSONObject.toString();
    }

    private static void a(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException unused) {
        }
    }

    private static boolean b() {
        String str = Build.FINGERPRINT;
        if (!str.contains("generic") && !str.startsWith("unknown")) {
            String str2 = Build.MODEL;
            return str2.contains("google_sdk") || str2.contains("Emulator") || str2.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk".equals(Build.PRODUCT);
        }
    }
}
