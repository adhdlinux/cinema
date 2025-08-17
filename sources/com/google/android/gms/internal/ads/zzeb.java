package com.google.android.gms.internal.ads;

public final class zzeb {
    private final zzdz zza;
    private boolean zzb;

    public zzeb() {
        throw null;
    }

    public zzeb(zzdz zzdz) {
        this.zza = zzdz;
    }

    public final synchronized void zza() throws InterruptedException {
        while (!this.zzb) {
            wait();
        }
    }

    public final synchronized void zzb() {
        boolean z2 = false;
        while (!this.zzb) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z2 = true;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
    }

    public final synchronized boolean zzc() {
        boolean z2;
        z2 = this.zzb;
        this.zzb = false;
        return z2;
    }

    public final synchronized boolean zzd() {
        return this.zzb;
    }

    public final synchronized boolean zze() {
        if (this.zzb) {
            return false;
        }
        this.zzb = true;
        notifyAll();
        return true;
    }
}
