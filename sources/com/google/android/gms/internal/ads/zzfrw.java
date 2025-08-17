package com.google.android.gms.internal.ads;

public abstract class zzfrw {
    zzfrw() {
    }

    static int zze(int i2, int i3) {
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

    public abstract zzfrw zzb(Object obj);
}
