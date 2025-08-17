package com.google.android.gms.internal.ads;

final class zzcba implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzcbe zzc;

    zzcba(zzcbe zzcbe, int i2, int i3) {
        this.zzc = zzcbe;
        this.zza = i2;
        this.zzb = i3;
    }

    public final void run() {
        zzcbe zzcbe = this.zzc;
        if (zzcbe.zzq != null) {
            zzcbe.zzq.zzj(this.zza, this.zzb);
        }
    }
}
