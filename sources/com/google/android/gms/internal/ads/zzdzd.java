package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;

public final class zzdzd implements zzcyb, zzcwu, zzcvj {
    private final zzfeu zza;
    private final zzfev zzb;
    private final zzbze zzc;

    public zzdzd(zzfeu zzfeu, zzfev zzfev, zzbze zzbze) {
        this.zza = zzfeu;
        this.zzb = zzfev;
        this.zzc = zzbze;
    }

    public final void zza(zze zze) {
        zzfeu zzfeu = this.zza;
        zzfeu.zza("action", "ftl");
        zzfeu.zza("ftl", String.valueOf(zze.zza));
        zzfeu.zza("ed", zze.zzc);
        this.zzb.zzb(this.zza);
    }

    public final void zzb(zzezz zzezz) {
        this.zza.zzh(zzezz, this.zzc);
    }

    public final void zzbA(zzbue zzbue) {
        this.zza.zzi(zzbue.zza);
    }

    public final void zzn() {
        zzfev zzfev = this.zzb;
        zzfeu zzfeu = this.zza;
        zzfeu.zza("action", "loaded");
        zzfev.zzb(zzfeu);
    }
}
