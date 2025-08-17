package com.unity3d.scar.adapter.common;

import android.os.Handler;
import android.os.Looper;

public class Utils {
    public static void a(Runnable runnable) {
        b(runnable, 0);
    }

    public static void b(Runnable runnable, long j2) {
        new Handler(Looper.getMainLooper()).postDelayed(runnable, j2);
    }
}
