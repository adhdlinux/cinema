package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzeme implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;
    private final zzgwr zzd;

    public zzeme(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3, zzgwr zzgwr4) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
        this.zzd = zzgwr4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfwn zzfwn = zzcae.zza;
        zzgwm.zzb(zzfwn);
        return new zzemc(((zzcha) this.zza).zza(), (zzbza) this.zzb.zzb(), (ScheduledExecutorService) this.zzc.zzb(), zzfwn);
    }
}
