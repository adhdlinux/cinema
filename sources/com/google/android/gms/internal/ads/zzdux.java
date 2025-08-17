package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzdux implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;
    private final zzgwr zzd;
    private final zzgwr zze;

    public zzdux(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3, zzgwr zzgwr4, zzgwr zzgwr5) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
        this.zzd = zzgwr4;
        this.zze = zzgwr5;
    }

    /* renamed from: zza */
    public final zzduw zzb() {
        zzfwn zzfwn = zzcae.zza;
        zzgwm.zzb(zzfwn);
        zzfwn zzfwn2 = zzcae.zzb;
        zzgwm.zzb(zzfwn2);
        return new zzduw((ScheduledExecutorService) this.zza.zzb(), zzfwn, zzfwn2, ((zzdvo) this.zzd).zzb(), zzgwd.zza(this.zze));
    }
}
