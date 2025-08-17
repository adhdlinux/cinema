package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzckm implements zzezh {
    private final zzciq zza;
    private final zzckm zzb = this;
    private final zzgwr zzc;
    private final zzgwr zzd;
    private final zzgwr zze;
    private final zzgwr zzf;
    private final zzgwr zzg;
    private final zzgwr zzh;
    private final zzgwr zzi;
    private final zzgwr zzj;

    /* synthetic */ zzckm(zzciq zzciq, Context context, String str, zzckl zzckl) {
        this.zza = zzciq;
        zzgwe zza2 = zzgwf.zza(context);
        this.zzc = zza2;
        zzexh zzexh = new zzexh(zza2, zzciq.zzaE, zzciq.zzaF);
        this.zzd = zzexh;
        zzgwr zzc2 = zzgwd.zzc(new zzeyr(zzciq.zzaE));
        this.zze = zzc2;
        zzgwr zzc3 = zzgwd.zzc(zzfaf.zza());
        this.zzf = zzc3;
        zzgwr zzc4 = zzgwd.zzc(new zzezb(zza2, zzciq.zzo, zzciq.zzU, zzexh, zzc2, zzfak.zza(), zzc3));
        this.zzg = zzc4;
        this.zzh = zzgwd.zzc(new zzezl(zzc4, zzc2, zzc3));
        zzgwe zzc5 = zzgwf.zzc(str);
        this.zzi = zzc5;
        this.zzj = zzgwd.zzc(new zzezf(zzc5, zzc4, zza2, zzc2, zzc3, zzciq.zzh, zzciq.zzV, zzciq.zzZ));
    }

    public final zzeze zza() {
        return (zzeze) this.zzj.zzb();
    }

    public final zzezk zzb() {
        return (zzezk) this.zzh.zzb();
    }
}
