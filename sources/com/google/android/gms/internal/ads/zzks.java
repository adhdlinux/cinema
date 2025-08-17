package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;

public final /* synthetic */ class zzks implements Runnable {
    public final /* synthetic */ zzkx zza;
    public final /* synthetic */ Pair zzb;
    public final /* synthetic */ zztf zzc;
    public final /* synthetic */ zztk zzd;
    public final /* synthetic */ IOException zze;
    public final /* synthetic */ boolean zzf;

    public /* synthetic */ zzks(zzkx zzkx, Pair pair, zztf zztf, zztk zztk, IOException iOException, boolean z2) {
        this.zza = zzkx;
        this.zzb = pair;
        this.zzc = zztf;
        this.zzd = zztk;
        this.zze = iOException;
        this.zzf = z2;
    }

    public final void run() {
        zzkx zzkx = this.zza;
        Pair pair = this.zzb;
        zzkx.zza.zzh.zzaf(((Integer) pair.first).intValue(), (zzto) pair.second, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
