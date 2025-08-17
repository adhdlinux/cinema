package com.google.android.gms.cast.framework;

import java.util.Locale;

public final class CastState {
    public static final int CONNECTED = 4;
    public static final int CONNECTING = 3;
    public static final int NOT_CONNECTED = 2;
    public static final int NO_DEVICES_AVAILABLE = 1;

    private CastState() {
    }

    public static String toString(int i2) {
        if (i2 == 1) {
            return "NO_DEVICES_AVAILABLE";
        }
        if (i2 == 2) {
            return "NOT_CONNECTED";
        }
        if (i2 == 3) {
            return "CONNECTING";
        }
        if (i2 == 4) {
            return "CONNECTED";
        }
        return String.format(Locale.ROOT, "UNKNOWN_STATE(%d)", new Object[]{Integer.valueOf(i2)});
    }
}
