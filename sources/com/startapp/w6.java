package com.startapp;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

public class w6 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f36814a = "w6";

    /* renamed from: b  reason: collision with root package name */
    public String f36815b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36816c = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36817d = true;

    public w6(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    Object obj = bundle.get("com.startapp.sdk.APPLICATION_ID");
                    if (obj != null) {
                        this.f36815b = obj.toString();
                        String str = f36814a;
                        Log.i(str, "appId is " + this.f36815b);
                        if (applicationInfo.metaData.containsKey("com.startapp.sdk.RETURN_ADS_ENABLED")) {
                            this.f36816c = applicationInfo.metaData.getBoolean("com.startapp.sdk.RETURN_ADS_ENABLED");
                            Log.i(str, "returnAds enabled: " + this.f36816c);
                        }
                        if (applicationInfo.metaData.containsKey("com.startapp.sdk.SPLASH_ENABLED")) {
                            this.f36817d = applicationInfo.metaData.getBoolean("com.startapp.sdk.SPLASH_ENABLED");
                            Log.i(str, "splash enabled: " + this.f36817d);
                            return;
                        }
                        return;
                    }
                    Log.i(f36814a, "appId hasn't been provided in the Manifest");
                }
            } catch (Throwable th) {
                y8.a(context, th);
            }
        }
    }
}
