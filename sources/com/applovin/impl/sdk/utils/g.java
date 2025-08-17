package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.StrictMode;
import android.view.Display;
import android.view.WindowManager;
import com.vungle.ads.internal.protos.Sdk$SDKError;

public class g {
    public static Point a(Context context) {
        Point point = new Point();
        point.x = 480;
        point.y = Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            if (b()) {
                defaultDisplay.getRealSize(point);
            } else {
                defaultDisplay.getSize(point);
            }
        }
        StrictMode.setVmPolicy(vmPolicy);
        return point;
    }

    public static void a() {
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        } catch (Throwable unused) {
        }
    }

    public static boolean a(String str, Context context) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static boolean b() {
        return true;
    }

    public static boolean c() {
        return true;
    }

    public static boolean d() {
        return true;
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean f() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean g() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean h() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static boolean i() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean j() {
        return Build.VERSION.SDK_INT >= 30;
    }
}
