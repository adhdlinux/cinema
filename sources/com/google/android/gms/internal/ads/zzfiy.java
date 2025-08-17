package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzfiy implements Runnable {
    public final /* synthetic */ TaskCompletionSource zza;

    public /* synthetic */ zzfiy(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void run() {
        this.zza.setResult(zzfld.zzc());
    }
}
