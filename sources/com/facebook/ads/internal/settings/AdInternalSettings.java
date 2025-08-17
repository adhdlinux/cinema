package com.facebook.ads.internal.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.unity3d.services.core.di.ServiceProvider;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

public class AdInternalSettings {

    /* renamed from: a  reason: collision with root package name */
    static volatile boolean f20802a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final String f20803b = "AdInternalSettings";

    /* renamed from: c  reason: collision with root package name */
    private static final Collection<String> f20804c = new HashSet();

    /* renamed from: d  reason: collision with root package name */
    private static final Collection<String> f20805d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f20806e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f20807f;

    /* renamed from: g  reason: collision with root package name */
    private static String f20808g;

    /* renamed from: h  reason: collision with root package name */
    private static String f20809h;

    /* renamed from: i  reason: collision with root package name */
    private static String f20810i;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f20811j = false;

    /* renamed from: k  reason: collision with root package name */
    private static boolean f20812k;

    /* renamed from: l  reason: collision with root package name */
    private static boolean f20813l;

    static {
        HashSet hashSet = new HashSet();
        f20805d = hashSet;
        hashSet.add(ServiceProvider.NAMED_SDK);
        hashSet.add("google_sdk");
        hashSet.add("vbox86p");
        hashSet.add("vbox86tp");
    }

    private static void a(String str) {
        if (!f20802a) {
            f20802a = true;
            String str2 = f20803b;
            Log.d(str2, "Test mode device hash: " + str);
            Log.d(str2, "When testing your app with Facebook's ad units you must specify the device hashed ID to ensure the delivery of test ads, add the following code before loading an ad: AdSettings.addTestDevice(\"" + str + "\");");
        }
    }

    public static void addTestDevice(String str) {
        f20804c.add(str);
    }

    public static void addTestDevices(Collection<String> collection) {
        f20804c.addAll(collection);
    }

    public static void clearTestDevices() {
        f20804c.clear();
    }

    public static String getMediationService() {
        return f20809h;
    }

    public static String getUrlPrefix() {
        return f20808g;
    }

    public static boolean isDebugBuild() {
        return f20811j;
    }

    public static boolean isExplicitTestMode() {
        return f20806e;
    }

    public static boolean isTestMode(Context context) {
        if (f20811j || isExplicitTestMode() || f20805d.contains(Build.PRODUCT)) {
            return true;
        }
        if (f20810i == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("FBAdPrefs", 0);
            String string = sharedPreferences.getString("deviceIdHash", (String) null);
            f20810i = string;
            if (TextUtils.isEmpty(string)) {
                f20810i = UUID.randomUUID().toString();
                sharedPreferences.edit().putString("deviceIdHash", f20810i).apply();
            }
        }
        if (f20804c.contains(f20810i)) {
            return true;
        }
        a(f20810i);
        return false;
    }

    public static boolean isVideoAutoplay() {
        return f20812k;
    }

    public static boolean isVideoAutoplayOnMobile() {
        return f20813l;
    }

    public static boolean isVisibleAnimation() {
        return f20807f;
    }

    public static void setDebugBuild(boolean z2) {
        f20811j = z2;
    }

    public static void setMediationService(String str) {
        f20809h = str;
    }

    public static void setTestMode(boolean z2) {
        f20806e = z2;
    }

    public static void setUrlPrefix(String str) {
        f20808g = str;
    }

    public static void setVideoAutoplay(boolean z2) {
        f20812k = z2;
    }

    public static void setVideoAutoplayOnMobile(boolean z2) {
        f20813l = z2;
    }

    public static void setVisibleAnimation(boolean z2) {
        f20807f = z2;
    }
}
