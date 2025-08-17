package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

public final /* synthetic */ class zzdty implements Callable {
    public final /* synthetic */ zzdub zza;
    public final /* synthetic */ zzbue zzb;

    public /* synthetic */ zzdty(zzdub zzdub, zzbue zzbue) {
        this.zza = zzdub;
        this.zzb = zzbue;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb);
    }
}
