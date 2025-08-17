package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzcja implements zzeuo {
    private final zzciq zza;
    private final zzcja zzb = this;
    private final zzgwr zzc;
    private final zzgwr zzd;
    private final zzgwr zze;
    private final zzgwr zzf;
    private final zzgwr zzg;
    private final zzgwr zzh;

    /* synthetic */ zzcja(zzciq zzciq, Context context, String str, zzciz zzciz) {
        this.zza = zzciq;
        zzgwe zza2 = zzgwf.zza(context);
        this.zzc = zza2;
        zzgwe zza3 = zzgwf.zza(str);
        this.zzd = zza3;
        zzexg zzexg = new zzexg(zza2, zzciq.zzaE, zzciq.zzaF);
        this.zze = zzexg;
        zzgwr zzc2 = zzgwd.zzc(new zzevm(zzciq.zzaE));
        this.zzf = zzc2;
        zzgwr zzgwr = zzc2;
        zzgwr zzc3 = zzgwd.zzc(new zzevo(zza2, zzciq.zzo, zzciq.zzU, zzexg, zzgwr, zzfak.zza(), zzciq.zzh));
        this.zzg = zzc3;
        this.zzh = zzgwd.zzc(new zzevu(zzciq.zzU, zza2, zza3, zzc3, zzgwr, zzciq.zzh, zzciq.zzZ));
    }

    public final zzevt zza() {
        return (zzevt) this.zzh.zzb();
    }
}
