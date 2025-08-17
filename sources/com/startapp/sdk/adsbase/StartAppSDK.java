package com.startapp.sdk.adsbase;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.startapp.d7;
import com.startapp.hb;
import com.startapp.ia;
import com.startapp.lb;
import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.x6;
import com.startapp.y8;
import com.startapp.z8;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

public class StartAppSDK {
    public static void addWrapper(Context context, String str, String str2) {
        String str3 = StartAppSDKInternal.f36218a;
        StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.c.f36252a;
        if (startAppSDKInternal.f36236s == null) {
            startAppSDKInternal.f36236s = new TreeMap();
        }
        startAppSDKInternal.f36236s.put(str, str2);
        x6 d2 = ComponentLocator.a(context).d();
        Map<String, String> map = startAppSDKInternal.f36236s;
        Map<Activity, Integer> map2 = lb.f34876a;
        String jSONObject = new JSONObject(map).toString();
        x6.a a2 = d2.edit();
        a2.a("sharedPrefsWrappers", jSONObject);
        a2.f36915a.putString("sharedPrefsWrappers", jSONObject);
        a2.apply();
    }

    public static void enableReturnAds(boolean z2) {
        String str = StartAppSDKInternal.f36218a;
        StartAppSDKInternal.c.f36252a.a(z2);
    }

    public static SharedPreferences getExtras(Context context) {
        return ComponentLocator.a(context).G.b();
    }

    public static String getVersion() {
        return "4.10.0";
    }

    public static void inAppPurchaseMade(Context context) {
        inAppPurchaseMade(context, 0.0d);
    }

    public static void init(Context context, String str) {
        init(context, str, new SDKAdPreferences());
    }

    public static void setTestAdsEnabled(boolean z2) {
        String str = StartAppSDKInternal.f36218a;
        StartAppSDKInternal.c.f36252a.F = z2;
    }

    public static void setUserConsent(Context context, String str, long j2, boolean z2) {
        String str2;
        String str3;
        String str4 = StartAppSDKInternal.f36218a;
        StartAppSDKInternal.c.f36252a.getClass();
        if ("pas".equalsIgnoreCase(str)) {
            x6 d2 = ComponentLocator.a(context).d();
            String string = d2.getString("USER_CONSENT_PERSONALIZED_ADS_SERVING", (String) null);
            String str5 = "1";
            if (string != null) {
                if (z2) {
                    str3 = str5;
                } else {
                    str3 = "0";
                }
                if (string.equals(str3)) {
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            if (z2) {
                str2 = str5;
            } else {
                str2 = "0";
            }
            sb.append(str2);
            sb.append("M");
            String sb2 = sb.toString();
            y8 y8Var = new y8(z8.f36995b);
            y8Var.f36954d = "User consent: " + str;
            y8Var.f36955e = sb2;
            y8Var.a(context);
            x6.a a2 = d2.edit();
            if (!z2) {
                str5 = "0";
            }
            a2.a("USER_CONSENT_PERSONALIZED_ADS_SERVING", str5);
            a2.f36915a.putString("USER_CONSENT_PERSONALIZED_ADS_SERVING", str5);
            a2.apply();
            hb.f34639a.a(context, MetaDataRequest.RequestReason.PAS);
        }
    }

    public static void startNewSession(Context context) {
        String str = StartAppSDKInternal.f36218a;
        StartAppSDKInternal.c.f36252a.b(context, MetaDataRequest.RequestReason.CUSTOM);
    }

    public static void inAppPurchaseMade(Context context, double d2) {
        x6 d3 = ComponentLocator.a(context).d();
        float f2 = d3.getFloat("inAppPurchaseAmount", 0.0f);
        x6.a a2 = d3.edit();
        float f3 = (float) (((double) f2) + d2);
        a2.a("inAppPurchaseAmount", Float.valueOf(f3));
        a2.f36915a.putFloat("inAppPurchaseAmount", f3);
        a2.a("payingUser", Boolean.TRUE);
        a2.f36915a.putBoolean("payingUser", true);
        a2.apply();
        String str = StartAppSDKInternal.f36218a;
        StartAppSDKInternal.c.f36252a.b(context, MetaDataRequest.RequestReason.IN_APP_PURCHASE);
    }

    public static void init(Context context, String str, SDKAdPreferences sDKAdPreferences) {
        init(context, (String) null, str, sDKAdPreferences);
    }

    public static void init(Context context, String str, String str2) {
        init(context, str, str2, new SDKAdPreferences());
    }

    public static void init(Context context, String str, String str2, SDKAdPreferences sDKAdPreferences) {
        init(context, str, str2, sDKAdPreferences, true);
    }

    public static void init(Context context, String str, boolean z2) {
        init(context, (String) null, str, z2);
    }

    public static void init(Context context, String str, String str2, boolean z2) {
        init(context, str, str2, new SDKAdPreferences(), z2);
    }

    public static void init(Context context, String str, SDKAdPreferences sDKAdPreferences, boolean z2) {
        init(context, (String) null, str, sDKAdPreferences, z2);
    }

    public static void init(Context context, String str, String str2, SDKAdPreferences sDKAdPreferences, boolean z2) {
        String str3 = StartAppSDKInternal.f36218a;
        StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.c.f36252a;
        startAppSDKInternal.getClass();
        Context b2 = ia.b(context);
        StartAppSDKInternal.a(b2, (Runnable) new d7(startAppSDKInternal, b2, str, str2, sDKAdPreferences, z2));
    }
}
