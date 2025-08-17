package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

public final /* synthetic */ class zzawr implements Runnable {
    public final /* synthetic */ zzcaj zza;
    public final /* synthetic */ Future zzb;

    public /* synthetic */ zzawr(zzcaj zzcaj, Future future) {
        this.zza = zzcaj;
        this.zzb = future;
    }

    public final void run() {
        zzcaj zzcaj = this.zza;
        Future future = this.zzb;
        if (zzcaj.isCancelled()) {
            future.cancel(true);
        }
    }
}
