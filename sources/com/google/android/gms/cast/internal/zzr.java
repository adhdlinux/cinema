package com.google.android.gms.cast.internal;

final class zzr implements Runnable {
    final /* synthetic */ zzw zza;
    final /* synthetic */ int zzb;

    zzr(zzv zzv, zzw zzw, int i2) {
        this.zza = zzw;
        this.zzb = i2;
    }

    public final void run() {
        this.zza.zzj.onApplicationDisconnected(this.zzb);
    }
}
