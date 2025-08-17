package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

final class zzfwo implements Executor {
    final /* synthetic */ Executor zza;
    final /* synthetic */ zzfuq zzb;

    zzfwo(Executor executor, zzfuq zzfuq) {
        this.zza = executor;
        this.zzb = zzfuq;
    }

    public final void execute(Runnable runnable) {
        try {
            this.zza.execute(runnable);
        } catch (RejectedExecutionException e2) {
            this.zzb.zze(e2);
        }
    }
}
