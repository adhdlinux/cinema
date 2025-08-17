package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzfen implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;

    public zzfen(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfwn zzfwn = zzcae.zza;
        zzgwm.zzb(zzfwn);
        return new zzfel(zzfwn, (ScheduledExecutorService) this.zzb.zzb(), ((zzfeo) this.zzc).zzb());
    }
}
