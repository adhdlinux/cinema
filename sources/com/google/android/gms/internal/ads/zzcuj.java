package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

public final /* synthetic */ class zzcuj implements Callable {
    public final /* synthetic */ zzcuk zza;
    public final /* synthetic */ zzfwm zzb;

    public /* synthetic */ zzcuj(zzcuk zzcuk, zzfwm zzfwm) {
        this.zza = zzcuk;
        this.zzb = zzfwm;
    }

    public final Object call() {
        return this.zza.zza(this.zzb);
    }
}
