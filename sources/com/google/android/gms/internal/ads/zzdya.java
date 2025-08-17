package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

public final /* synthetic */ class zzdya implements Callable {
    public final /* synthetic */ zzfwm zza;
    public final /* synthetic */ zzfwm zzb;

    public /* synthetic */ zzdya(zzfwm zzfwm, zzfwm zzfwm2) {
        this.zza = zzfwm;
        this.zzb = zzfwm2;
    }

    public final Object call() {
        zzfwm zzfwm = this.zza;
        zzfwm zzfwm2 = this.zzb;
        return new zzdyg((zzdyu) zzfwm.get(), ((zzdye) zzfwm2.get()).zzb, ((zzdye) zzfwm2.get()).zza);
    }
}
