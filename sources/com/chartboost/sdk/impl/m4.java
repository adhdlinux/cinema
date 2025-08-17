package com.chartboost.sdk.impl;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import java.util.UUID;

public abstract class m4 {

    /* renamed from: a  reason: collision with root package name */
    public static int f18188a = 4;

    /* renamed from: b  reason: collision with root package name */
    public static int f18189b = 5;

    public static String a(Context context, boolean z2) {
        String a2 = a(context);
        if (z2 || a2 == null) {
            return c(context);
        }
        return a2;
    }

    public static Integer b(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f2 = ((float) displayMetrics.heightPixels) / displayMetrics.ydpi;
        float f3 = ((float) displayMetrics.widthPixels) / displayMetrics.xdpi;
        if (Math.sqrt((double) ((f3 * f3) + (f2 * f2))) >= 6.5d) {
            return Integer.valueOf(f18189b);
        }
        return Integer.valueOf(f18188a);
    }

    public static String c(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("cbPrefs", 0);
        if (sharedPreferences == null) {
            return UUID.randomUUID().toString();
        }
        String string = sharedPreferences.getString("cbUUID", (String) null);
        if (string != null) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (edit != null) {
            edit.putString("cbUUID", uuid).apply();
        }
        return uuid;
    }

    public static String d(Context context) {
        Resources resources;
        Configuration configuration;
        if (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null) {
            return "phone";
        }
        int i2 = configuration.uiMode & 15;
        int i3 = configuration.screenLayout & 15;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return "phone";
        }
        if (packageManager.hasSystemFeature("org.chromium.arc.device_management")) {
            return "chromebook";
        }
        String str = Build.BRAND;
        if (str != null && str.equals("chromium") && Build.MANUFACTURER.equals("chromium")) {
            return "chromebook";
        }
        String str2 = Build.DEVICE;
        if (str2 != null && str2.matches(".+_cheets")) {
            return "chromebook";
        }
        if (packageManager.hasSystemFeature("android.hardware.type.watch") || i2 == 6) {
            return "watch";
        }
        if (packageManager.hasSystemFeature("android.hardware.type.television") || i2 == 4) {
            return "tv";
        }
        String str3 = Build.MANUFACTURER;
        if ((str3 == null || !str3.equalsIgnoreCase("Amazon")) && i3 != 4) {
            return "phone";
        }
        return "tablet";
    }

    public static boolean e(Context context) {
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("cb.limit.aid");
            if (!(obj instanceof Integer) || ((Integer) obj).intValue() != 1) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String a(Context context) {
        ContentResolver contentResolver;
        if (context == null || Build.VERSION.SDK_INT >= 26 || e(context) || (contentResolver = context.getContentResolver()) == null) {
            return null;
        }
        try {
            String string = Settings.Secure.getString(contentResolver, "android_id");
            try {
                if ("9774d56d682e549c".equals(string)) {
                    return null;
                }
            } catch (Exception unused) {
            }
            return string;
        } catch (Exception unused2) {
            return null;
        }
    }
}
