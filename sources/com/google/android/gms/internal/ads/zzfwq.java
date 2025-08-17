package com.google.android.gms.internal.ads;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class zzfwq extends zzfvw implements ScheduledFuture {
    private final ScheduledFuture zza;

    public zzfwq(zzfwm zzfwm, ScheduledFuture scheduledFuture) {
        super(zzfwm);
        this.zza = scheduledFuture;
    }

    public final boolean cancel(boolean z2) {
        boolean cancel = zzb().cancel(z2);
        if (cancel) {
            this.zza.cancel(z2);
        }
        return cancel;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zza.compareTo((Delayed) obj);
    }

    public final long getDelay(TimeUnit timeUnit) {
        return this.zza.getDelay(timeUnit);
    }
}
