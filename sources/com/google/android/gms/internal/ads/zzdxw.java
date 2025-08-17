package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

public final /* synthetic */ class zzdxw implements Callable {
    public final /* synthetic */ zzfwm zza;
    public final /* synthetic */ zzfwm zzb;
    public final /* synthetic */ zzfwm zzc;

    public /* synthetic */ zzdxw(zzfwm zzfwm, zzfwm zzfwm2, zzfwm zzfwm3) {
        this.zza = zzfwm;
        this.zzb = zzfwm2;
        this.zzc = zzfwm3;
    }

    public final Object call() {
        return new zzdyg((zzdyu) this.zza.get(), (JSONObject) this.zzb.get(), (zzbuh) this.zzc.get());
    }
}
