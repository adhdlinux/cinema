package com.google.android.gms.location;

public final class zzai {
    public static String zza(int i2) {
        if (i2 == 0) {
            return "THROTTLE_BACKGROUND";
        }
        if (i2 == 1) {
            return "THROTTLE_ALWAYS";
        }
        if (i2 == 2) {
            return "THROTTLE_NEVER";
        }
        throw new IllegalArgumentException();
    }
}
