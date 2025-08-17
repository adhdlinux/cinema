package com.google.android.gms.internal.ads;

final class zzcbb implements Runnable {
    final /* synthetic */ zzcbe zza;

    zzcbb(zzcbe zzcbe) {
        this.zza = zzcbe;
    }

    public final void run() {
        zzcbe zzcbe = this.zza;
        if (zzcbe.zzq != null) {
            zzcbe.zzq.zzd();
            this.zza.zzq.zzi();
        }
    }
}
