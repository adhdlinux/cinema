package com.facebook.ads.internal.q.a;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

public class h {
    public static boolean a(int i2, int i3) {
        return i2 >= 640 && i3 >= 640;
    }

    public static boolean a(Context context) {
        boolean z2;
        try {
            if (!((ActivityManager) context.getSystemService("activity")).getRunningTasks(2).get(0).topActivity.getClassName().equals("com.unity3d.player.UnityPlayerActivity")) {
                if (!a("com.unity3d.player.UnityPlayerActivity")) {
                    z2 = false;
                    Boolean valueOf = Boolean.valueOf(z2);
                    Log.d("IS_UNITY", Boolean.toString(valueOf.booleanValue()));
                    return valueOf.booleanValue();
                }
            }
            z2 = true;
            Boolean valueOf2 = Boolean.valueOf(z2);
            Log.d("IS_UNITY", Boolean.toString(valueOf2.booleanValue()));
            return valueOf2.booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
