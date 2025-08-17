package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import com.facebook.react.uimanager.ViewProps;

final class zzyl {
    public static boolean zza(Context context) {
        Display display;
        DisplayManager displayManager = (DisplayManager) context.getSystemService(ViewProps.DISPLAY);
        if (displayManager != null) {
            display = displayManager.getDisplay(0);
        } else {
            display = null;
        }
        if (display == null || !display.isHdr()) {
            return false;
        }
        for (int i2 : display.getHdrCapabilities().getSupportedHdrTypes()) {
            if (i2 == 1) {
                return true;
            }
        }
        return false;
    }
}
