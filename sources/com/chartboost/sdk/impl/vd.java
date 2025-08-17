package com.chartboost.sdk.impl;

import android.app.UiModeManager;
import android.content.Context;

public abstract class vd {

    /* renamed from: a  reason: collision with root package name */
    public static UiModeManager f18878a;

    public static k4 a() {
        UiModeManager uiModeManager = f18878a;
        if (uiModeManager == null) {
            return k4.OTHER;
        }
        int currentModeType = uiModeManager.getCurrentModeType();
        if (currentModeType != 1) {
            return currentModeType != 4 ? k4.OTHER : k4.CTV;
        }
        return k4.MOBILE;
    }

    public static void a(Context context) {
        if (context != null) {
            f18878a = (UiModeManager) context.getSystemService("uimode");
        }
    }
}
