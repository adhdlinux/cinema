package com.google.android.gms.internal.ads;

import android.util.Pair;

public final /* synthetic */ class zzkv implements Runnable {
    public final /* synthetic */ zzkx zza;
    public final /* synthetic */ Pair zzb;
    public final /* synthetic */ zztk zzc;

    public /* synthetic */ zzkv(zzkx zzkx, Pair pair, zztk zztk) {
        this.zza = zzkx;
        this.zzb = pair;
        this.zzc = zztk;
    }

    public final void run() {
        zzkx zzkx = this.zza;
        Pair pair = this.zzb;
        zzkx.zza.zzh.zzac(((Integer) pair.first).intValue(), (zzto) pair.second, this.zzc);
    }
}
