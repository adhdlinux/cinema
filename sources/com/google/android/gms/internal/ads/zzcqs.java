package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

public final class zzcqs implements zzcwu, zzaua {
    private final zzezn zza;
    private final zzcvy zzb;
    private final zzcxd zzc;
    private final AtomicBoolean zzd = new AtomicBoolean();
    private final AtomicBoolean zze = new AtomicBoolean();

    public zzcqs(zzezn zzezn, zzcvy zzcvy, zzcxd zzcxd) {
        this.zza = zzezn;
        this.zzb = zzcvy;
        this.zzc = zzcxd;
    }

    private final void zza() {
        if (this.zzd.compareAndSet(false, true)) {
            this.zzb.zza();
        }
    }

    public final void zzc(zzatz zzatz) {
        if (this.zza.zzf == 1 && zzatz.zzj) {
            zza();
        }
        if (zzatz.zzj && this.zze.compareAndSet(false, true)) {
            this.zzc.zza();
        }
    }

    public final synchronized void zzn() {
        if (this.zza.zzf != 1) {
            zza();
        }
    }
}
