package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

public final /* synthetic */ class zzete implements Callable {
    public final /* synthetic */ zzfwm zza;
    public final /* synthetic */ zzfwm zzb;

    public /* synthetic */ zzete(zzfwm zzfwm, zzfwm zzfwm2) {
        this.zza = zzfwm;
        this.zzb = zzfwm2;
    }

    public final Object call() {
        return new zzetg((String) this.zza.get(), (String) this.zzb.get());
    }
}
