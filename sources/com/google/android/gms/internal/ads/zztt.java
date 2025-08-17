package com.google.android.gms.internal.ads;

import java.io.IOException;

public final /* synthetic */ class zztt implements Runnable {
    public final /* synthetic */ zztx zza;
    public final /* synthetic */ zzty zzb;
    public final /* synthetic */ zztf zzc;
    public final /* synthetic */ zztk zzd;
    public final /* synthetic */ IOException zze;
    public final /* synthetic */ boolean zzf;

    public /* synthetic */ zztt(zztx zztx, zzty zzty, zztf zztf, zztk zztk, IOException iOException, boolean z2) {
        this.zza = zztx;
        this.zzb = zzty;
        this.zzc = zztf;
        this.zzd = zztk;
        this.zze = iOException;
        this.zzf = z2;
    }

    public final void run() {
        zztx zztx = this.zza;
        this.zzb.zzaf(0, zztx.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
