package com.original.tase.utils;

import android.app.UiModeManager;
import android.os.Build;
import com.movie.FreeMoviesApp;
import com.utils.Utils;

public class DeviceUtils {
    public static boolean a() {
        if (Build.MANUFACTURER.toLowerCase().contains("nvidia")) {
            String str = Build.MODEL;
            return str.toLowerCase().contains("shield") && !str.toLowerCase().contains("tablet");
        }
    }

    public static boolean b() {
        return Build.MANUFACTURER.trim().toLowerCase().contains("amazon") && Build.MODEL.trim().toLowerCase().contains("aft");
    }

    public static boolean c() {
        if (FreeMoviesApp.p().getBoolean("pref_force_tv_mode", false)) {
            return true;
        }
        UiModeManager uiModeManager = (UiModeManager) Utils.v().getSystemService("uimode");
        String str = Build.MODEL;
        String lowerCase = str.toLowerCase();
        String lowerCase2 = Build.MANUFACTURER.toLowerCase();
        if ((uiModeManager == null || uiModeManager.getCurrentModeType() != 4) && !str.contains("AFT") && !lowerCase.contains("firestick") && !lowerCase.contains("fire tv") && !lowerCase.contains("chromecast") && ((!lowerCase2.contains("xiaomi") || !lowerCase.toLowerCase().contains("bravia")) && ((!lowerCase2.contains("sony") || !lowerCase.toLowerCase().contains("nexus player")) && ((!lowerCase2.contains("asus") || !lowerCase.toLowerCase().contains("mibox")) && (!lowerCase2.contains("quya") || !lowerCase.toLowerCase().contains("ouya_")))))) {
            return false;
        }
        return true;
    }
}
