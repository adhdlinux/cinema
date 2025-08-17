package com.google.android.gms.internal.ads;

public final class zzqb implements zzpm {
    protected zzqb(zzqa zzqa) {
    }

    protected static int zza(int i2, int i3, int i4) {
        return zzfuk.zza(((((long) i2) * ((long) i3)) * ((long) i4)) / 1000000);
    }

    protected static int zzb(int i2) {
        switch (i2) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 14:
                return 3062500;
            case 15:
                return 8000;
            case 16:
                return 256000;
            case 17:
                return 336000;
            case 20:
                return 63750;
            default:
                throw new IllegalArgumentException();
        }
    }
}
