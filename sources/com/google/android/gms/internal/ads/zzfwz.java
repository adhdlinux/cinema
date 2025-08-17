package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class zzfwz extends zzfvs {
    /* access modifiers changed from: private */
    public zzfwm zza;
    /* access modifiers changed from: private */
    public ScheduledFuture zzb;

    private zzfwz(zzfwm zzfwm) {
        zzfwm.getClass();
        this.zza = zzfwm;
    }

    static zzfwm zzg(zzfwm zzfwm, long j2, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzfwz zzfwz = new zzfwz(zzfwm);
        zzfww zzfww = new zzfww(zzfwz);
        zzfwz.zzb = scheduledExecutorService.schedule(zzfww, j2, timeUnit);
        zzfwm.zzc(zzfww, zzfvq.INSTANCE);
        return zzfwz;
    }

    /* access modifiers changed from: protected */
    public final String zza() {
        zzfwm zzfwm = this.zza;
        ScheduledFuture scheduledFuture = this.zzb;
        if (zzfwm == null) {
            return null;
        }
        String str = "inputFuture=[" + zzfwm.toString() + "]";
        if (scheduledFuture == null) {
            return str;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return str;
        }
        return str + ", remaining delay=[" + delay + " ms]";
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        zzs(this.zza);
        ScheduledFuture scheduledFuture = this.zzb;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zza = null;
        this.zzb = null;
    }
}
