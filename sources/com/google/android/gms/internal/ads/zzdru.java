package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

public final /* synthetic */ class zzdru implements Callable {
    public final /* synthetic */ zzdsc zza;
    public final /* synthetic */ zzffn zzb;

    public /* synthetic */ zzdru(zzdsc zzdsc, zzffn zzffn) {
        this.zza = zzdsc;
        this.zzb = zzffn;
    }

    public final Object call() {
        this.zza.zzf(this.zzb);
        return null;
    }
}
