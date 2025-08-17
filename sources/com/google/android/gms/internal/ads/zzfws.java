package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class zzfws extends zzfwp implements ScheduledExecutorService {
    final ScheduledExecutorService zza;

    zzfws(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        scheduledExecutorService.getClass();
        this.zza = scheduledExecutorService;
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j2, TimeUnit timeUnit) {
        zzfxc zzf = zzfxc.zzf(runnable, (Object) null);
        return new zzfwq(zzf, this.zza.schedule(zzf, j2, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        zzfwr zzfwr = new zzfwr(runnable);
        return new zzfwq(zzfwr, this.zza.scheduleAtFixedRate(zzfwr, j2, j3, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        zzfwr zzfwr = new zzfwr(runnable);
        return new zzfwq(zzfwr, this.zza.scheduleWithFixedDelay(zzfwr, j2, j3, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable callable, long j2, TimeUnit timeUnit) {
        zzfxc zzfxc = new zzfxc(callable);
        return new zzfwq(zzfxc, this.zza.schedule(zzfxc, j2, timeUnit));
    }
}
