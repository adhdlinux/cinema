package com.google.android.gms.internal.ads;

public final class zzxh {
    public final int zza;
    public final zzll[] zzb;
    public final zzxa[] zzc;
    public final zzdh zzd;
    public final Object zze;

    public zzxh(zzll[] zzllArr, zzxa[] zzxaArr, zzdh zzdh, Object obj) {
        this.zzb = zzllArr;
        this.zzc = (zzxa[]) zzxaArr.clone();
        this.zzd = zzdh;
        this.zze = obj;
        this.zza = zzllArr.length;
    }

    public final boolean zza(zzxh zzxh, int i2) {
        if (zzxh != null && zzfj.zzC(this.zzb[i2], zzxh.zzb[i2]) && zzfj.zzC(this.zzc[i2], zzxh.zzc[i2])) {
            return true;
        }
        return false;
    }

    public final boolean zzb(int i2) {
        return this.zzb[i2] != null;
    }
}
