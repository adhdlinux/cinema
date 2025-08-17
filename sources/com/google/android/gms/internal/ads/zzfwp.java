package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

class zzfwp extends zzfuv {
    private final ExecutorService zza;

    zzfwp(ExecutorService executorService) {
        executorService.getClass();
        this.zza = executorService;
    }

    public final boolean awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.zza.awaitTermination(j2, timeUnit);
    }

    public final void execute(Runnable runnable) {
        this.zza.execute(runnable);
    }

    public final boolean isShutdown() {
        return this.zza.isShutdown();
    }

    public final boolean isTerminated() {
        return this.zza.isTerminated();
    }

    public final void shutdown() {
        this.zza.shutdown();
    }

    public final List shutdownNow() {
        return this.zza.shutdownNow();
    }

    public final String toString() {
        String obj = super.toString();
        String valueOf = String.valueOf(this.zza);
        return obj + "[" + valueOf + "]";
    }
}
