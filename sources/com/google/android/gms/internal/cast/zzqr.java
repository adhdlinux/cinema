package com.google.android.gms.internal.cast;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class zzqr extends zzqh implements ScheduledFuture {
    private final ScheduledFuture zza;

    public zzqr(ListenableFuture listenableFuture, ScheduledFuture scheduledFuture) {
        super(listenableFuture);
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
