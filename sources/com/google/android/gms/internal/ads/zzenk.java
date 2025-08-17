package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.concurrent.ScheduledExecutorService;

public final class zzenk implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;

    public zzenk(zzgwr zzgwr, zzgwr zzgwr2) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfsh zzfsh;
        zzena zza2 = zzenc.zza();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzb.zzb();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzdK)).booleanValue()) {
            zzfsh = zzfsh.zzn(new zzepg(zza2, (long) ((Integer) zzba.zzc().zzb(zzbbm.zzdL)).intValue(), scheduledExecutorService));
        } else {
            zzfsh = zzfsh.zzm();
        }
        zzgwm.zzb(zzfsh);
        return zzfsh;
    }
}
