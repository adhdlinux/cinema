package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

public final class zzeqh implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;
    private final zzgwr zzd;
    private final zzgwr zze;
    private final zzgwr zzf;

    public zzeqh(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3, zzgwr zzgwr4, zzgwr zzgwr5, zzgwr zzgwr6) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
        this.zzd = zzgwr4;
        this.zze = zzgwr5;
        this.zzf = zzgwr6;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfwn zzfwn = zzcae.zza;
        zzgwm.zzb(zzfwn);
        return new zzeqf(zzfwn, (ScheduledExecutorService) this.zzb.zzb(), (String) this.zzc.zzb(), (Context) this.zzd.zzb(), ((zzcux) this.zze).zza(), (zzcgu) this.zzf.zzb());
    }
}
