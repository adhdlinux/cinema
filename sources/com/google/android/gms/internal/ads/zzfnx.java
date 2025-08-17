package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zzfnx implements Runnable {
    private final TaskCompletionSource zza;

    zzfnx() {
        this.zza = null;
    }

    public zzfnx(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void run() {
        try {
            zza();
        } catch (Exception e2) {
            zzc(e2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zza();

    /* access modifiers changed from: package-private */
    public final TaskCompletionSource zzb() {
        return this.zza;
    }

    public final void zzc(Exception exc) {
        TaskCompletionSource taskCompletionSource = this.zza;
        if (taskCompletionSource != null) {
            taskCompletionSource.trySetException(exc);
        }
    }
}
