package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

public final /* synthetic */ class zzcsd implements Callable {
    public final /* synthetic */ zzcsk zza;
    public final /* synthetic */ zzfwm zzb;
    public final /* synthetic */ zzfwm zzc;
    public final /* synthetic */ zzfwm zzd;

    public /* synthetic */ zzcsd(zzcsk zzcsk, zzfwm zzfwm, zzfwm zzfwm2, zzfwm zzfwm3) {
        this.zza = zzcsk;
        this.zzb = zzfwm;
        this.zzc = zzfwm2;
        this.zzd = zzfwm3;
    }

    public final Object call() {
        return this.zza.zzg(this.zzb, this.zzc, this.zzd);
    }
}
