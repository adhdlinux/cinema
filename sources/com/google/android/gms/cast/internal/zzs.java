package com.google.android.gms.cast.internal;

final class zzs implements Runnable {
    final /* synthetic */ zzw zza;
    final /* synthetic */ zzab zzb;

    zzs(zzv zzv, zzw zzw, zzab zzab) {
        this.zza = zzw;
        this.zzb = zzab;
    }

    public final void run() {
        zzw.zzI(this.zza, this.zzb);
    }
}
