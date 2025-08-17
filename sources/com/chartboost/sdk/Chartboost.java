package com.chartboost.sdk;

import android.content.Context;
import android.util.Log;
import com.applovin.sdk.AppLovinEventTypes;
import com.chartboost.sdk.callbacks.StartCallback;
import com.chartboost.sdk.impl.i3;
import com.chartboost.sdk.impl.w7;
import com.chartboost.sdk.privacy.model.DataUseConsent;
import kotlin.jvm.internal.Intrinsics;

public final class Chartboost {
    public static final Chartboost INSTANCE = new Chartboost();

    private Chartboost() {
    }

    public static final void addDataUseConsent(Context context, DataUseConsent dataUseConsent) {
        Intrinsics.f(context, "context");
        Intrinsics.f(dataUseConsent, "dataUseConsent");
        INSTANCE.initContainer(context);
        i3 i3Var = i3.f17882b;
        if (i3Var.g()) {
            i3Var.i().a().a(dataUseConsent);
        }
    }

    public static final void clearDataUseConsent(Context context, String str) {
        Intrinsics.f(context, "context");
        Intrinsics.f(str, "privacyStandard");
        INSTANCE.initContainer(context);
        i3 i3Var = i3.f17882b;
        if (i3Var.g()) {
            i3Var.i().a().b(str);
        }
    }

    public static final String getBidderToken() {
        if (isSdkStarted()) {
            return i3.f17882b.k().b().a();
        }
        Log.e("Chartboost", "Chartboost getToken failed due to SDK not being initialized.");
        return null;
    }

    public static final DataUseConsent getDataUseConsent(Context context, String str) {
        Intrinsics.f(context, "context");
        Intrinsics.f(str, "privacyStandard");
        INSTANCE.initContainer(context);
        i3 i3Var = i3.f17882b;
        if (i3Var.g()) {
            return i3Var.i().a().a(str);
        }
        return null;
    }

    public static final String getSDKVersion() {
        return "9.7.0";
    }

    private final void initContainer(Context context) {
        i3 i3Var = i3.f17882b;
        if (!i3Var.g()) {
            i3Var.a(context);
        }
    }

    public static final boolean isSdkStarted() {
        i3 i3Var = i3.f17882b;
        if (i3Var.g() && i3Var.l()) {
            try {
                return i3Var.k().c().e();
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static final void setLoggingLevel(LoggingLevel loggingLevel) {
        Intrinsics.f(loggingLevel, AppLovinEventTypes.USER_COMPLETED_LEVEL);
        w7.f18897b = loggingLevel;
    }

    public static final synchronized void startWithAppId(Context context, String str, String str2, StartCallback startCallback) {
        synchronized (Chartboost.class) {
            Intrinsics.f(context, "context");
            Intrinsics.f(str, "appId");
            Intrinsics.f(str2, "appSignature");
            Intrinsics.f(startCallback, "onStarted");
            INSTANCE.initContainer(context);
            i3 i3Var = i3.f17882b;
            if (i3Var.g()) {
                if (!isSdkStarted()) {
                    i3Var.a(str, str2);
                }
                i3Var.m().a();
                i3Var.k().b().a(str, str2, startCallback);
            } else {
                Log.e("Chartboost", "Chartboost startWithAppId failed due to DI not being initialized.");
            }
        }
    }
}
