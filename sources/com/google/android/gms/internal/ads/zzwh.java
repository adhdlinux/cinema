package com.google.android.gms.internal.ads;

final class zzwh implements Comparable {
    private final boolean zza;
    private final boolean zzb;

    public zzwh(zzam zzam, int i2) {
        this.zza = 1 != (zzam.zze & 1) ? false : true;
        this.zzb = zzwy.zzn(i2, false);
    }

    /* renamed from: zza */
    public final int compareTo(zzwh zzwh) {
        return zzfrr.zzj().zzd(this.zzb, zzwh.zzb).zzd(this.zza, zzwh.zza).zza();
    }
}
