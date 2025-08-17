package com.google.android.gms.internal.ads;

final class zzcbc implements Runnable {
    final /* synthetic */ zzcbe zza;

    zzcbc(zzcbe zzcbe) {
        this.zza = zzcbe;
    }

    public final void run() {
        zzcbe zzcbe = this.zza;
        if (zzcbe.zzq != null) {
            if (!zzcbe.zzr) {
                zzcbe.zzq.zzg();
                this.zza.zzr = true;
            }
            this.zza.zzq.zze();
        }
    }
}
