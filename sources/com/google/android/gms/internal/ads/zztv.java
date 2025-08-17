package com.google.android.gms.internal.ads;

public final /* synthetic */ class zztv implements Runnable {
    public final /* synthetic */ zztx zza;
    public final /* synthetic */ zzty zzb;
    public final /* synthetic */ zztf zzc;
    public final /* synthetic */ zztk zzd;

    public /* synthetic */ zztv(zztx zztx, zzty zzty, zztf zztf, zztk zztk) {
        this.zza = zztx;
        this.zzb = zzty;
        this.zzc = zztf;
        this.zzd = zztk;
    }

    public final void run() {
        zztx zztx = this.zza;
        this.zzb.zzae(0, zztx.zzb, this.zzc, this.zzd);
    }
}
