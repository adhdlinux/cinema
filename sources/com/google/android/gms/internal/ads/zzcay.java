package com.google.android.gms.internal.ads;

final class zzcay implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcbe zzc;

    zzcay(zzcbe zzcbe, String str, String str2) {
        this.zzc = zzcbe;
        this.zza = str;
        this.zzb = str2;
    }

    public final void run() {
        zzcbe zzcbe = this.zzc;
        if (zzcbe.zzq != null) {
            zzcbe.zzq.zzb(this.zza, this.zzb);
        }
    }
}
