package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

abstract class zzfvo extends zzfwl {
    private final Executor zza;
    final /* synthetic */ zzfvp zzb;

    zzfvo(zzfvp zzfvp, Executor executor) {
        this.zzb = zzfvp;
        executor.getClass();
        this.zza = executor;
    }

    /* access modifiers changed from: package-private */
    public abstract void zzc(Object obj);

    /* access modifiers changed from: package-private */
    public final void zzd(Throwable th) {
        this.zzb.zza = null;
        if (th instanceof ExecutionException) {
            this.zzb.zze(((ExecutionException) th).getCause());
        } else if (th instanceof CancellationException) {
            this.zzb.cancel(false);
        } else {
            this.zzb.zze(th);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zze(Object obj) {
        this.zzb.zza = null;
        zzc(obj);
    }

    /* access modifiers changed from: package-private */
    public final void zzf() {
        try {
            this.zza.execute(this);
        } catch (RejectedExecutionException e2) {
            this.zzb.zze(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return this.zzb.isDone();
    }
}
