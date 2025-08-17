package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

public final class zzbil {
    private boolean zza = false;
    private boolean zzb = false;
    private float zzc = 0.0f;
    private final AtomicBoolean zzd = new AtomicBoolean(false);

    public final synchronized float zza() {
        return this.zzc;
    }

    public final synchronized void zzb(boolean z2, float f2) {
        this.zzb = z2;
        this.zzc = f2;
    }

    public final synchronized void zzc(boolean z2) {
        this.zza = z2;
        this.zzd.set(true);
    }

    public final synchronized boolean zzd() {
        return this.zzb;
    }

    public final synchronized boolean zze(boolean z2) {
        if (!this.zzd.get()) {
            return z2;
        }
        return this.zza;
    }
}
