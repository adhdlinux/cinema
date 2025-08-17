package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzcjy implements zzdrj {
    /* access modifiers changed from: private */
    public final Context zza;
    private final zzbjg zzb;
    private final zzciq zzc;
    private final zzcjy zzd = this;
    private final zzgwr zze;
    private final zzgwr zzf;
    private final zzgwr zzg;
    private final zzgwr zzh;

    /* synthetic */ zzcjy(zzciq zzciq, Context context, zzbjg zzbjg, zzcjx zzcjx) {
        this.zzc = zzciq;
        this.zza = context;
        this.zzb = zzbjg;
        zzgwe zza2 = zzgwf.zza(this);
        this.zze = zza2;
        zzgwe zza3 = zzgwf.zza(zzbjg);
        this.zzf = zza3;
        zzdrf zzdrf = new zzdrf(zza3);
        this.zzg = zzdrf;
        this.zzh = zzgwd.zzc(new zzdrh(zza2, zzdrf));
    }

    public final zzdra zzb() {
        return new zzcjs(this.zzc, this.zzd, (zzcjr) null);
    }

    public final zzdrg zzd() {
        return (zzdrg) this.zzh.zzb();
    }
}
