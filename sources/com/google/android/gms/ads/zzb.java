package com.google.android.gms.ads;

public final class zzb {
    public static int zza(AdSize adSize) {
        return adSize.zzb();
    }

    public static int zzb(AdSize adSize) {
        return adSize.zza();
    }

    public static AdSize zzc(int i2, int i3, String str) {
        return new AdSize(i2, i3, str);
    }

    public static AdSize zzd(int i2, int i3) {
        AdSize adSize = new AdSize(i2, i3);
        adSize.zze(true);
        adSize.zzc(i3);
        return adSize;
    }

    public static AdSize zze(int i2, int i3) {
        AdSize adSize = new AdSize(i2, i3);
        adSize.zzf(true);
        adSize.zzd(i3);
        return adSize;
    }

    public static boolean zzf(AdSize adSize) {
        return adSize.zzg();
    }

    public static boolean zzg(AdSize adSize) {
        return adSize.zzh();
    }

    public static boolean zzh(AdSize adSize) {
        return adSize.zzi();
    }
}
