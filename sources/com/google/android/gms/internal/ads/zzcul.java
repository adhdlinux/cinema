package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.google.android.gms.ads.internal.client.zzba;

public final class zzcul implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;
    private final zzgwr zzd;
    private final zzgwr zze;
    private final zzgwr zzf;
    private final zzgwr zzg;
    private final zzgwr zzh;
    private final zzgwr zzi;
    private final zzgwr zzj;
    private final zzgwr zzk;

    public zzcul(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3, zzgwr zzgwr4, zzgwr zzgwr5, zzgwr zzgwr6, zzgwr zzgwr7, zzgwr zzgwr8, zzgwr zzgwr9, zzgwr zzgwr10, zzgwr zzgwr11) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
        this.zzd = zzgwr4;
        this.zze = zzgwr5;
        this.zzf = zzgwr6;
        this.zzg = zzgwr7;
        this.zzh = zzgwr8;
        this.zzi = zzgwr9;
        this.zzj = zzgwr10;
        this.zzk = zzgwr11;
    }

    /* renamed from: zza */
    public final zzcuk zzb() {
        zzbzx zza2 = ((zzchm) this.zzb).zza();
        ApplicationInfo zza3 = ((zzduj) this.zzc).zzb();
        String zza4 = ((zzdup) this.zzd).zzb();
        zzbbe zzbbe = zzbbm.zza;
        return new zzcuk((zzfel) this.zza.zzb(), zza2, zza3, zza4, zzba.zza().zza(), (PackageInfo) this.zzf.zzb(), zzgwd.zza(this.zzg), ((zzcgy) this.zzh).zzb(), (String) this.zzi.zzb(), ((zzerc) this.zzj).zzb(), ((zzcux) this.zzk).zza());
    }
}
