package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcvv implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;
    private final zzgwr zzd;

    public zzcvv(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3, zzgwr zzgwr4) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
        this.zzd = zzgwr4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcvs zza2 = ((zzcvu) this.zza).zzb();
        Set zzc2 = ((zzgwp) this.zzb).zzb();
        zzfwn zzfwn = zzcae.zza;
        zzgwm.zzb(zzfwn);
        return new zzcvt(zza2, zzc2, zzfwn, (ScheduledExecutorService) this.zzd.zzb());
    }
}
