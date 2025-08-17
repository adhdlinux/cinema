package com.google.android.gms.internal.ads;

final class zzaur implements Runnable {
    final /* synthetic */ zzaus zza;

    zzaur(zzaus zzaus) {
        this.zza = zzaus;
    }

    public final void run() {
        synchronized (this.zza.zzc) {
            zzaus zzaus = this.zza;
            if (!zzaus.zzd || !zzaus.zze) {
                zzbzr.zze("App is still foreground");
            } else {
                zzaus.zzd = false;
                zzbzr.zze("App went background");
                for (zzaut zza2 : this.zza.zzf) {
                    try {
                        zza2.zza(false);
                    } catch (Exception e2) {
                        zzbzr.zzh("", e2);
                    }
                }
            }
        }
    }
}
