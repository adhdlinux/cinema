package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

public final /* synthetic */ class zzdxv implements Callable {
    public final /* synthetic */ zzfwm zza;
    public final /* synthetic */ zzfwm zzb;

    public /* synthetic */ zzdxv(zzfwm zzfwm, zzfwm zzfwm2) {
        this.zza = zzfwm;
        this.zzb = zzfwm2;
    }

    public final Object call() {
        return new zzdyx((JSONObject) this.zza.get(), (zzbuh) this.zzb.get());
    }
}
