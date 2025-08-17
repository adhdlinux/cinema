package com.applovin.sdk;

import android.content.Context;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.v;

public class AppLovinPrivacySettings {
    public static boolean hasUserConsent(Context context) {
        v.f("AppLovinPrivacySettings", "hasUserConsent()");
        Boolean a2 = j.b().a(context);
        if (a2 != null) {
            return a2.booleanValue();
        }
        return false;
    }

    public static boolean isAgeRestrictedUser(Context context) {
        v.f("AppLovinPrivacySettings", "isAgeRestrictedUser()");
        Boolean a2 = j.a().a(context);
        if (a2 != null) {
            return a2.booleanValue();
        }
        return false;
    }

    public static boolean isAgeRestrictedUserSet(Context context) {
        v.f("AppLovinPrivacySettings", "isAgeRestrictedUserSet()");
        return j.a().a(context) != null;
    }

    public static boolean isDoNotSell(Context context) {
        v.f("AppLovinPrivacySettings", "isDoNotSell()");
        Boolean a2 = j.c().a(context);
        if (a2 != null) {
            return a2.booleanValue();
        }
        return false;
    }

    public static boolean isDoNotSellSet(Context context) {
        v.f("AppLovinPrivacySettings", "isDoNotSellSet()");
        return j.c().a(context) != null;
    }

    public static boolean isUserConsentSet(Context context) {
        v.f("AppLovinPrivacySettings", "isUserConsentSet()");
        return j.b().a(context) != null;
    }

    public static void setDoNotSell(boolean z2, Context context) {
        v.f("AppLovinPrivacySettings", "setDoNotSell()");
        if (j.c(z2, context)) {
            AppLovinSdk.reinitializeAll((Boolean) null, (Boolean) null, Boolean.valueOf(z2));
        }
    }

    public static void setHasUserConsent(boolean z2, Context context) {
        v.f("AppLovinPrivacySettings", "setHasUserConsent()");
        if (j.b(z2, context)) {
            AppLovinSdk.reinitializeAll(Boolean.valueOf(z2), (Boolean) null, (Boolean) null);
        }
    }

    public static void setIsAgeRestrictedUser(boolean z2, Context context) {
        v.f("AppLovinPrivacySettings", "setIsAgeRestrictedUser()");
        if (j.a(z2, context)) {
            AppLovinSdk.reinitializeAll((Boolean) null, Boolean.valueOf(z2), (Boolean) null);
        }
    }
}
