package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;

public final class zzae {
    public static int zza(int i2) {
        boolean z2;
        if (!(i2 == 100 || i2 == 102 || i2 == 104)) {
            if (i2 == 105) {
                i2 = 105;
            } else {
                z2 = false;
                Preconditions.checkArgument(z2, "priority %d must be a Priority.PRIORITY_* constant", Integer.valueOf(i2));
                return i2;
            }
        }
        z2 = true;
        Preconditions.checkArgument(z2, "priority %d must be a Priority.PRIORITY_* constant", Integer.valueOf(i2));
        return i2;
    }

    public static String zzb(int i2) {
        if (i2 == 100) {
            return "HIGH_ACCURACY";
        }
        if (i2 == 102) {
            return "BALANCED_POWER_ACCURACY";
        }
        if (i2 == 104) {
            return "LOW_POWER";
        }
        if (i2 == 105) {
            return "PASSIVE";
        }
        throw new IllegalArgumentException();
    }
}
