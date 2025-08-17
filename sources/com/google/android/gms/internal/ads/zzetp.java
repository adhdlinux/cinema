package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzetp implements zzeqy {
    final ScheduledExecutorService zza;
    final Context zzb;
    final zzbrx zzc;

    public zzetp(zzbrx zzbrx, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.zzc = zzbrx;
        this.zza = scheduledExecutorService;
        this.zzb = context;
    }

    public final int zza() {
        return 49;
    }

    public final zzfwm zzb() {
        return zzfwc.zzl(zzfwc.zzn(zzfwc.zzh(new Bundle()), ((Long) zzba.zzc().zzb(zzbbm.zzdO)).longValue(), TimeUnit.MILLISECONDS, this.zza), zzeto.zza, zzcae.zza);
    }
}
