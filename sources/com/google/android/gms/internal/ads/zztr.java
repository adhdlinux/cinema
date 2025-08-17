package com.google.android.gms.internal.ads;

public final /* synthetic */ class zztr implements Runnable {
    public final /* synthetic */ zztx zza;
    public final /* synthetic */ zzty zzb;
    public final /* synthetic */ zztk zzc;

    public /* synthetic */ zztr(zztx zztx, zzty zzty, zztk zztk) {
        this.zza = zztx;
        this.zzb = zzty;
        this.zzc = zztk;
    }

    public final void run() {
        zztx zztx = this.zza;
        this.zzb.zzac(0, zztx.zzb, this.zzc);
    }
}
