package com.google.android.gms.internal.ads;

public final class zzfuk extends zzful {
    public static int zza(long j2) {
        int i2 = (int) j2;
        if (((long) i2) == j2) {
            return i2;
        }
        throw new IllegalArgumentException(zzfpw.zzb("Out of range: %s", Long.valueOf(j2)));
    }

    public static int zzb(int i2, int i3, int i4) {
        return Math.min(Math.max(i2, i3), 1073741823);
    }

    public static int zzc(long j2) {
        if (j2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j2 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j2;
    }
}
