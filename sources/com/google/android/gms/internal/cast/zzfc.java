package com.google.android.gms.internal.cast;

public class zzfc {
    zzfc() {
    }

    static int zza(int i2, int i3) {
        if (i3 >= 0) {
            int i4 = i2 + (i2 >> 1) + 1;
            if (i4 < i3) {
                int highestOneBit = Integer.highestOneBit(i3 - 1);
                i4 = highestOneBit + highestOneBit;
            }
            if (i4 < 0) {
                return Integer.MAX_VALUE;
            }
            return i4;
        }
        throw new AssertionError("cannot store more than MAX_VALUE elements");
    }
}
