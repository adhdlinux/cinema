package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

final class zzfwg implements zzfwm {
    static final zzfwm zza = new zzfwg((Object) null);
    private static final Logger zzb = Logger.getLogger(zzfwg.class.getName());
    private final Object zzc;

    zzfwg(Object obj) {
        this.zzc = obj;
    }

    public final boolean cancel(boolean z2) {
        return false;
    }

    public final Object get() {
        return this.zzc;
    }

    public final Object get(long j2, TimeUnit timeUnit) throws ExecutionException {
        timeUnit.getClass();
        return this.zzc;
    }

    public final boolean isCancelled() {
        return false;
    }

    public final boolean isDone() {
        return true;
    }

    public final String toString() {
        String obj = super.toString();
        String valueOf = String.valueOf(this.zzc);
        return obj + "[status=SUCCESS, result=[" + valueOf + "]]";
    }

    public final void zzc(Runnable runnable, Executor executor) {
        zzfph.zzc(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = zzb;
            Level level = Level.SEVERE;
            String obj = runnable.toString();
            String valueOf = String.valueOf(executor);
            logger.logp(level, "com.google.common.util.concurrent.ImmediateFuture", "addListener", "RuntimeException while executing runnable " + obj + " with executor " + valueOf, e2);
        }
    }
}
