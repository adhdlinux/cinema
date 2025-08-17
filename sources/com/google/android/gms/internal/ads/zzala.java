package com.google.android.gms.internal.ads;

final class zzala implements Runnable {
    private final zzalk zza;
    private final zzalq zzb;
    private final Runnable zzc;

    public zzala(zzalk zzalk, zzalq zzalq, Runnable runnable) {
        this.zza = zzalk;
        this.zzb = zzalq;
        this.zzc = runnable;
    }

    public final void run() {
        this.zza.zzw();
        zzalq zzalq = this.zzb;
        if (zzalq.zzc()) {
            this.zza.zzo(zzalq.zza);
        } else {
            this.zza.zzn(zzalq.zzc);
        }
        if (this.zzb.zzd) {
            this.zza.zzm("intermediate-response");
        } else {
            this.zza.zzp("done");
        }
        Runnable runnable = this.zzc;
        if (runnable != null) {
            runnable.run();
        }
    }
}
