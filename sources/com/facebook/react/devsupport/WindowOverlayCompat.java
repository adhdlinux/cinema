package com.facebook.react.devsupport;

import android.os.Build;

class WindowOverlayCompat {
    private static final int ANDROID_OREO = 26;
    private static final int TYPE_APPLICATION_OVERLAY = 2038;
    static final int TYPE_SYSTEM_ALERT;
    static final int TYPE_SYSTEM_OVERLAY;

    static {
        int i2;
        int i3 = Build.VERSION.SDK_INT;
        int i4 = TYPE_APPLICATION_OVERLAY;
        if (i3 < 26) {
            i2 = 2003;
        } else {
            i2 = TYPE_APPLICATION_OVERLAY;
        }
        TYPE_SYSTEM_ALERT = i2;
        if (i3 < 26) {
            i4 = 2006;
        }
        TYPE_SYSTEM_OVERLAY = i4;
    }

    WindowOverlayCompat() {
    }
}
