package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzfix implements Runnable {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ TaskCompletionSource zzb;

    public /* synthetic */ zzfix(Context context, TaskCompletionSource taskCompletionSource) {
        this.zza = context;
        this.zzb = taskCompletionSource;
    }

    public final void run() {
        this.zzb.setResult(zzfld.zzb(this.zza, "GLAS", (String) null));
    }
}
