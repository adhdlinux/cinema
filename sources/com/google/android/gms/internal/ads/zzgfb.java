package com.google.android.gms.internal.ads;

public final class zzgfb implements zzgfd {
    private final zzgnk zza;
    private final zzgkp zzb;

    private zzgfb(zzgkp zzgkp) {
        this.zzb = zzgkp;
        this.zza = zzgfm.zza(zzgkp.zzh());
    }

    public static zzgfb zza(zzgkp zzgkp) {
        return new zzgfb(zzgkp);
    }

    public final zzgkp zzb() {
        return this.zzb;
    }

    public final zzgnk zzd() {
        return this.zza;
    }
}
