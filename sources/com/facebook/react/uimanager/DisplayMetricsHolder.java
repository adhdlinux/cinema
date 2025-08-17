package com.facebook.react.uimanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;

public class DisplayMetricsHolder {
    private static DisplayMetrics sScreenDisplayMetrics;
    private static DisplayMetrics sWindowDisplayMetrics;

    public static WritableMap getDisplayMetricsWritableMap(double d2) {
        boolean z2;
        if (sWindowDisplayMetrics == null || sScreenDisplayMetrics == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        Assertions.assertCondition(z2, "DisplayMetricsHolder must be initialized with initDisplayMetricsIfNotInitialized or initDisplayMetrics");
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putMap("windowPhysicalPixels", getPhysicalPixelsWritableMap(sWindowDisplayMetrics, d2));
        writableNativeMap.putMap("screenPhysicalPixels", getPhysicalPixelsWritableMap(sScreenDisplayMetrics, d2));
        return writableNativeMap;
    }

    private static WritableMap getPhysicalPixelsWritableMap(DisplayMetrics displayMetrics, double d2) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putInt("width", displayMetrics.widthPixels);
        writableNativeMap.putInt("height", displayMetrics.heightPixels);
        writableNativeMap.putDouble("scale", (double) displayMetrics.density);
        writableNativeMap.putDouble("fontScale", d2);
        writableNativeMap.putDouble("densityDpi", (double) displayMetrics.densityDpi);
        return writableNativeMap;
    }

    public static DisplayMetrics getScreenDisplayMetrics() {
        return sScreenDisplayMetrics;
    }

    @Deprecated
    public static DisplayMetrics getWindowDisplayMetrics() {
        return sWindowDisplayMetrics;
    }

    public static void initDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        setWindowDisplayMetrics(displayMetrics);
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        displayMetrics2.setTo(displayMetrics);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Assertions.assertNotNull(windowManager, "WindowManager is null!");
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics2);
        setScreenDisplayMetrics(displayMetrics2);
    }

    public static void initDisplayMetricsIfNotInitialized(Context context) {
        if (getScreenDisplayMetrics() == null) {
            initDisplayMetrics(context);
        }
    }

    public static void setScreenDisplayMetrics(DisplayMetrics displayMetrics) {
        sScreenDisplayMetrics = displayMetrics;
    }

    public static void setWindowDisplayMetrics(DisplayMetrics displayMetrics) {
        sWindowDisplayMetrics = displayMetrics;
    }
}
