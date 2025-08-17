package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzepg implements zzeqy {
    private final zzeqy zza;
    private final long zzb;
    private final ScheduledExecutorService zzc;

    public zzepg(zzeqy zzeqy, long j2, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzeqy;
        this.zzb = j2;
        this.zzc = scheduledExecutorService;
    }

    public final int zza() {
        return this.zza.zza();
    }

    public final zzfwm zzb() {
        zzfwm zzb2 = this.zza.zzb();
        long j2 = this.zzb;
        if (j2 > 0) {
            zzb2 = zzfwc.zzn(zzb2, j2, TimeUnit.MILLISECONDS, this.zzc);
        }
        return zzfwc.zzf(zzb2, Throwable.class, zzepf.zza, zzcae.zzf);
    }
}
