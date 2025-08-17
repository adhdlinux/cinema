package com.google.android.gms.internal.ads;

final class zzakv implements Runnable {
    final /* synthetic */ zzalk zza;
    final /* synthetic */ zzakw zzb;

    zzakv(zzakw zzakw, zzalk zzalk) {
        this.zzb = zzakw;
        this.zza = zzalk;
    }

    public final void run() {
        try {
            this.zzb.zzc.put(this.zza);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
