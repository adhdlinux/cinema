package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzesq implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;
    private final zzgwr zzd;
    private final zzgwr zze;

    public zzesq(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3, zzgwr zzgwr4, zzgwr zzgwr5) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
        this.zzd = zzgwr4;
        this.zze = zzgwr5;
    }

    public static zzeso zza(String str, zzawc zzawc, zzbza zzbza, ScheduledExecutorService scheduledExecutorService, zzfwn zzfwn) {
        return new zzeso(str, zzawc, zzbza, scheduledExecutorService, zzfwn);
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfwn zzfwn = zzcae.zza;
        zzgwm.zzb(zzfwn);
        return new zzeso(((zzett) this.zza).zza(), new zzawc(), (zzbza) this.zzc.zzb(), (ScheduledExecutorService) this.zzd.zzb(), zzfwn);
    }
}
