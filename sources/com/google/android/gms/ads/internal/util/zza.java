package com.google.android.gms.ads.internal.util;

final class zza implements Runnable {
    final /* synthetic */ zzb zza;

    zza(zzb zzb) {
        this.zza = zzb;
    }

    public final void run() {
        this.zza.zzb = Thread.currentThread();
        this.zza.zza();
    }
}
