package com.google.android.gms.tasks;

final class zzc implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzd zzb;

    zzc(zzd zzd, Task task) {
        this.zzb = zzd;
        this.zza = task;
    }

    public final void run() {
        if (this.zza.isCanceled()) {
            this.zzb.zzc.zzc();
            return;
        }
        try {
            this.zzb.zzc.zzb(this.zzb.zzb.then(this.zza));
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                this.zzb.zzc.zza((Exception) e2.getCause());
            } else {
                this.zzb.zzc.zza(e2);
            }
        } catch (Exception e3) {
            this.zzb.zzc.zza(e3);
        }
    }
}
