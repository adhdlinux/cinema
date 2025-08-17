package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public final class zzfwt {
    public static zzfwn zza(ExecutorService executorService) {
        zzfwn zzfwn;
        if (executorService instanceof zzfwn) {
            return (zzfwn) executorService;
        }
        if (executorService instanceof ScheduledExecutorService) {
            zzfwn = new zzfws((ScheduledExecutorService) executorService);
        } else {
            zzfwn = new zzfwp(executorService);
        }
        return zzfwn;
    }

    public static Executor zzb() {
        return zzfvq.INSTANCE;
    }

    static Executor zzc(Executor executor, zzfuq zzfuq) {
        executor.getClass();
        if (executor == zzfvq.INSTANCE) {
            return executor;
        }
        return new zzfwo(executor, zzfuq);
    }
}
