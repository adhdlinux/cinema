package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

public final class zzdvc implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;
    private final zzgwr zzd;
    private final zzgwr zze;
    private final zzgwr zzf;
    private final zzgwr zzg;

    public zzdvc(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3, zzgwr zzgwr4, zzgwr zzgwr5, zzgwr zzgwr6, zzgwr zzgwr7) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
        this.zzd = zzgwr4;
        this.zze = zzgwr5;
        this.zzf = zzgwr6;
        this.zzg = zzgwr7;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzcha) this.zza).zza();
        zzfai zza3 = ((zzcux) this.zzb).zza();
        zzdub zza4 = ((zzduc) this.zzc).zzb();
        zzfwn zzfwn = zzcae.zza;
        zzgwm.zzb(zzfwn);
        return new zzdvb(zza2, zza3, zza4, zzfwn, (ScheduledExecutorService) this.zze.zzb(), (zzdzx) this.zzf.zzb(), (zzffy) this.zzg.zzb());
    }
}
