package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.TaskCompletionSource;

final class zzfoa extends zzfnx {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzfnx zzb;
    final /* synthetic */ zzfoh zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfoa(zzfoh zzfoh, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, zzfnx zzfnx) {
        super(taskCompletionSource);
        this.zzc = zzfoh;
        this.zza = taskCompletionSource2;
        this.zzb = zzfnx;
    }

    public final void zza() {
        synchronized (this.zzc.zzg) {
            zzfoh.zzn(this.zzc, this.zza);
            if (this.zzc.zzl.getAndIncrement() > 0) {
                this.zzc.zzc.zzc("Already connected to the service.", new Object[0]);
            }
            zzfoh.zzp(this.zzc, this.zzb);
        }
    }
}
