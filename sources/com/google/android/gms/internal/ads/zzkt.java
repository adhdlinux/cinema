package com.google.android.gms.internal.ads;

import android.util.Pair;

public final /* synthetic */ class zzkt implements Runnable {
    public final /* synthetic */ zzkx zza;
    public final /* synthetic */ Pair zzb;
    public final /* synthetic */ zztf zzc;
    public final /* synthetic */ zztk zzd;

    public /* synthetic */ zzkt(zzkx zzkx, Pair pair, zztf zztf, zztk zztk) {
        this.zza = zzkx;
        this.zzb = pair;
        this.zzc = zztf;
        this.zzd = zztk;
    }

    public final void run() {
        zzkx zzkx = this.zza;
        Pair pair = this.zzb;
        zzkx.zza.zzh.zzae(((Integer) pair.first).intValue(), (zzto) pair.second, this.zzc, this.zzd);
    }
}
