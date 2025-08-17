package com.facebook.ads.internal.c;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.ads.internal.c.a;
import com.facebook.ads.internal.c.c;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f20055a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f20056b = "";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f20057c = false;

    /* renamed from: d  reason: collision with root package name */
    public static String f20058d = "";

    public static void a(Context context) {
        c.a aVar;
        String str;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("SDKIDFA", 0);
            if (sharedPreferences.contains("attributionId")) {
                f20055a = sharedPreferences.getString("attributionId", "");
            }
            if (sharedPreferences.contains("advertisingId")) {
                f20056b = sharedPreferences.getString("advertisingId", "");
                f20057c = sharedPreferences.getBoolean("limitAdTracking", f20057c);
                f20058d = a.c.SHARED_PREFS.name();
            }
            a aVar2 = null;
            try {
                aVar = c.a(context.getContentResolver());
            } catch (Exception e2) {
                com.facebook.ads.internal.j.b.a(com.facebook.ads.internal.j.a.a(e2, "Error retrieving attribution id from fb4a"));
                aVar = null;
            }
            if (!(aVar == null || (str = aVar.f20059a) == null)) {
                f20055a = str;
            }
            if (com.facebook.ads.internal.q.a.b.a() && com.facebook.ads.internal.q.a.b.b("aid_override")) {
                f20055a = com.facebook.ads.internal.q.a.b.a("aid_override");
            }
            try {
                aVar2 = a.a(context, aVar);
            } catch (Exception e3) {
                com.facebook.ads.internal.j.b.a(com.facebook.ads.internal.j.a.a(e3, "Error retrieving advertising id from Google Play Services"));
            }
            if (aVar2 != null) {
                String a2 = aVar2.a();
                Boolean valueOf = Boolean.valueOf(aVar2.b());
                if (a2 != null) {
                    f20056b = a2;
                    f20057c = valueOf.booleanValue();
                    f20058d = aVar2.c().name();
                }
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("attributionId", f20055a);
            edit.putString("advertisingId", f20056b);
            edit.putBoolean("limitAdTracking", f20057c);
            edit.apply();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
