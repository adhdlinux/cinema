package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;

public final class zzdpl implements zzcyb, zzcwu, zzcvj {
    private final zzdpv zza;
    private final zzdqf zzb;

    public zzdpl(zzdpv zzdpv, zzdqf zzdqf) {
        this.zza = zzdpv;
        this.zzb = zzdqf;
    }

    public final void zza(zze zze) {
        this.zza.zza().put("action", "ftl");
        this.zza.zza().put("ftl", String.valueOf(zze.zza));
        this.zza.zza().put("ed", zze.zzc);
        this.zzb.zze(this.zza.zza());
    }

    public final void zzb(zzezz zzezz) {
        this.zza.zzb(zzezz);
    }

    public final void zzbA(zzbue zzbue) {
        this.zza.zzc(zzbue.zza);
    }

    public final void zzn() {
        this.zza.zza().put("action", "loaded");
        this.zzb.zze(this.zza.zza());
    }
}
