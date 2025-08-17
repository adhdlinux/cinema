package androidx.core.app;

import android.app.ActivityManager;

public final class ActivityManagerCompat {
    private ActivityManagerCompat() {
    }

    public static boolean a(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }
}
