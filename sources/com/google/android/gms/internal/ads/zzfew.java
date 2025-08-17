package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.concurrent.ScheduledExecutorService;

public final class zzfew implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;

    public zzfew(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Object obj;
        zzgvy zza2 = zzgwd.zza(this.zza);
        zzgvy zza3 = zzgwd.zza(this.zzb);
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzc.zzb();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzih)).booleanValue()) {
            obj = new zzfey((zzfev) zza2.zzb(), scheduledExecutorService);
        } else {
            obj = (zzfev) zza3.zzb();
        }
        zzgwm.zzb(obj);
        return obj;
    }
}
