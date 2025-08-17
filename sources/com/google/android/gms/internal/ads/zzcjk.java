package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;

final class zzcjk implements zzewc {
    private final Context zza;
    private final zzq zzb;
    private final String zzc;
    private final zzciq zzd;
    private final zzcjk zze = this;
    private final zzgwr zzf;
    private final zzgwr zzg;
    private final zzgwr zzh;
    private final zzgwr zzi;
    private final zzgwr zzj;
    private final zzgwr zzk;

    /* synthetic */ zzcjk(zzciq zzciq, Context context, String str, zzq zzq, zzcjj zzcjj) {
        this.zzd = zzciq;
        this.zza = context;
        this.zzb = zzq;
        this.zzc = str;
        zzgwe zza2 = zzgwf.zza(context);
        this.zzf = zza2;
        zzgwe zza3 = zzgwf.zza(zzq);
        this.zzg = zza3;
        zzgwr zzc2 = zzgwd.zzc(new zzejn(zzciq.zzn));
        this.zzh = zzc2;
        zzgwr zzc3 = zzgwd.zzc(zzejs.zza());
        this.zzi = zzc3;
        zzgwr zzc4 = zzgwd.zzc(zzdae.zza());
        this.zzj = zzc4;
        this.zzk = zzgwd.zzc(new zzewa(zza2, zzciq.zzo, zza3, zzciq.zzU, zzc2, zzc3, zzfak.zza(), zzc4));
    }

    public final zzeis zza() {
        zzbzx zzd2 = this.zzd.zza.zzd();
        zzgwm.zzb(zzd2);
        return new zzeis(this.zza, this.zzb, this.zzc, (zzevz) this.zzk.zzb(), (zzejm) this.zzh.zzb(), zzd2, (zzdqa) this.zzd.zzZ.zzb());
    }
}
