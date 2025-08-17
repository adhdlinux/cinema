package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzdsd implements zzgwe {
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

    public zzdsd(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3, zzgwr zzgwr4, zzgwr zzgwr5, zzgwr zzgwr6, zzgwr zzgwr7, zzgwr zzgwr8, zzgwr zzgwr9, zzgwr zzgwr10) {
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
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzcha) this.zzb).zza();
        WeakReference zza3 = ((zzchb) this.zzc).zza();
        zzfwn zzfwn = zzcae.zza;
        zzgwm.zzb(zzfwn);
        return new zzdsc((Executor) this.zza.zzb(), zza2, zza3, zzfwn, (zzdnv) this.zze.zzb(), (ScheduledExecutorService) this.zzf.zzb(), (zzdqj) this.zzg.zzb(), ((zzchm) this.zzh).zza(), ((zzdby) this.zzi).zzb(), (zzfgb) this.zzj.zzb());
    }
}
