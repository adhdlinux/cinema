package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class zzfvu extends zzfvt {
    private final zzfwm zza;

    zzfvu(zzfwm zzfwm) {
        zzfwm.getClass();
        this.zza = zzfwm;
    }

    public final boolean cancel(boolean z2) {
        return this.zza.cancel(z2);
    }

    public final Object get() throws InterruptedException, ExecutionException {
        return this.zza.get();
    }

    public final boolean isCancelled() {
        return this.zza.isCancelled();
    }

    public final boolean isDone() {
        return this.zza.isDone();
    }

    public final String toString() {
        return this.zza.toString();
    }

    public final void zzc(Runnable runnable, Executor executor) {
        this.zza.zzc(runnable, executor);
    }

    public final Object get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.zza.get(j2, timeUnit);
    }
}
