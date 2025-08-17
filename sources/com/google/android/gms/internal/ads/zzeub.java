package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.concurrent.ScheduledExecutorService;

public final class zzeub {
    public static zzeqy zza(zzetf zzetf, zzeoy zzeoy, ScheduledExecutorService scheduledExecutorService, int i2) {
        return i2 == 0 ? new zzepg(zzeoy, 0, scheduledExecutorService) : new zzepg(zzetf, 0, scheduledExecutorService);
    }

    public static zzeqy zzb(zzetp zzetp, ScheduledExecutorService scheduledExecutorService) {
        return new zzepg(zzetp, ((Long) zzba.zzc().zzb(zzbbm.zzdO)).longValue(), scheduledExecutorService);
    }

    public static zzeqy zzc(zzeuk zzeuk, ScheduledExecutorService scheduledExecutorService) {
        return new zzepg(zzeuk, 0, scheduledExecutorService);
    }
}
