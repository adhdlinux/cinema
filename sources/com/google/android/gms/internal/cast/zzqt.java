package com.google.android.gms.internal.cast;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class zzqt extends zzqq implements ScheduledExecutorService {
    final ScheduledExecutorService zza;

    zzqt(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        scheduledExecutorService.getClass();
        this.zza = scheduledExecutorService;
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j2, TimeUnit timeUnit) {
        zzqw zzn = zzqw.zzn(runnable, (Object) null);
        return new zzqr(zzn, this.zza.schedule(zzn, j2, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        zzqs zzqs = new zzqs(runnable);
        return new zzqr(zzqs, this.zza.scheduleAtFixedRate(zzqs, j2, j3, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        zzqs zzqs = new zzqs(runnable);
        return new zzqr(zzqs, this.zza.scheduleWithFixedDelay(zzqs, j2, j3, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable callable, long j2, TimeUnit timeUnit) {
        zzqw zzqw = new zzqw(callable);
        return new zzqr(zzqw, this.zza.schedule(zzqw, j2, timeUnit));
    }
}
