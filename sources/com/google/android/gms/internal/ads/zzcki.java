package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;

final class zzcki implements zzext {
    private final zzciq zza;
    private final zzcki zzb = this;
    private final zzgwr zzc;
    private final zzgwr zzd;
    private final zzgwr zze;
    private final zzgwr zzf;
    private final zzgwr zzg;
    private final zzgwr zzh;
    private final zzgwr zzi;

    /* synthetic */ zzcki(zzciq zzciq, Context context, String str, zzq zzq, zzckh zzckh) {
        this.zza = zzciq;
        zzgwe zza2 = zzgwf.zza(context);
        this.zzc = zza2;
        zzgwe zza3 = zzgwf.zza(zzq);
        this.zzd = zza3;
        zzgwe zza4 = zzgwf.zza(str);
        this.zze = zza4;
        zzgwr zzc2 = zzgwd.zzc(new zzejn(zzciq.zzn));
        this.zzf = zzc2;
        zzgwr zzc3 = zzgwd.zzc(new zzeyr(zzciq.zzaE));
        this.zzg = zzc3;
        zzgwr zzgwr = zzc2;
        zzgwr zzgwr2 = zzc3;
        zzgwr zzc4 = zzgwd.zzc(new zzexr(zza2, zzciq.zzo, zzciq.zzU, zzgwr, zzgwr2, zzfak.zza()));
        this.zzh = zzc4;
        this.zzi = zzgwd.zzc(new zzejv(zza2, zza3, zza4, zzc4, zzgwr, zzgwr2, zzciq.zzh, zzciq.zzV, zzciq.zzZ));
    }

    public final zzeju zza() {
        return (zzeju) this.zzi.zzb();
    }
}
