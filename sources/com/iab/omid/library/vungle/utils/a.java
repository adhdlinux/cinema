package com.iab.omid.library.vungle.utils;

import android.app.UiModeManager;
import android.content.Context;
import com.iab.omid.library.vungle.adsession.DeviceCategory;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static UiModeManager f31751a;

    public static DeviceCategory a() {
        UiModeManager uiModeManager = f31751a;
        if (uiModeManager == null) {
            return DeviceCategory.OTHER;
        }
        int currentModeType = uiModeManager.getCurrentModeType();
        return currentModeType != 1 ? currentModeType != 4 ? DeviceCategory.OTHER : DeviceCategory.CTV : DeviceCategory.MOBILE;
    }

    public static void b(Context context) {
        if (context != null) {
            f31751a = (UiModeManager) context.getSystemService("uimode");
        }
    }
}
