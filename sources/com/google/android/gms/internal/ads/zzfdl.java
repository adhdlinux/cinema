package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

public final class zzfdl implements zzgwe {
    private final zzgwr zza;

    public zzfdl(zzgwr zzgwr) {
        this.zza = zzgwr;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfmc.zza();
        ScheduledExecutorService unconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, (ThreadFactory) this.zza.zzb()));
        zzgwm.zzb(unconfigurableScheduledExecutorService);
        return unconfigurableScheduledExecutorService;
    }
}
