package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

public final /* synthetic */ class zzdxx implements Callable {
    public final /* synthetic */ zzdyh zza;
    public final /* synthetic */ zzfwm zzb;
    public final /* synthetic */ zzfwm zzc;
    public final /* synthetic */ zzbue zzd;
    public final /* synthetic */ zzffn zze;

    public /* synthetic */ zzdxx(zzdyh zzdyh, zzfwm zzfwm, zzfwm zzfwm2, zzbue zzbue, zzffn zzffn) {
        this.zza = zzdyh;
        this.zzb = zzfwm;
        this.zzc = zzfwm2;
        this.zzd = zzbue;
        this.zze = zzffn;
    }

    public final Object call() {
        return this.zza.zzj(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
