package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbh;

public final class zzejz {
    private final zzdhl zza;
    private final zzejm zzb;
    private final zzcvj zzc;

    public zzejz(zzdhl zzdhl, zzfev zzfev) {
        this.zza = zzdhl;
        zzejm zzejm = new zzejm(zzfev);
        this.zzb = zzejm;
        this.zzc = new zzejy(zzejm, zzdhl.zzg());
    }

    public final zzcvj zza() {
        return this.zzc;
    }

    public final zzcwu zzb() {
        return this.zzb;
    }

    public final zzdff zzc() {
        return new zzdff(this.zza, this.zzb.zzc());
    }

    public final zzejm zzd() {
        return this.zzb;
    }

    public final void zze(zzbh zzbh) {
        this.zzb.zze(zzbh);
    }
}
