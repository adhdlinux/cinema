package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

public final /* synthetic */ class zzeer implements Callable {
    public final /* synthetic */ zzeew zza;
    public final /* synthetic */ zzfwm zzb;
    public final /* synthetic */ zzfwm zzc;
    public final /* synthetic */ zzezz zzd;
    public final /* synthetic */ zzezn zze;
    public final /* synthetic */ JSONObject zzf;

    public /* synthetic */ zzeer(zzeew zzeew, zzfwm zzfwm, zzfwm zzfwm2, zzezz zzezz, zzezn zzezn, JSONObject jSONObject) {
        this.zza = zzeew;
        this.zzb = zzfwm;
        this.zzc = zzfwm2;
        this.zzd = zzezz;
        this.zze = zzezn;
        this.zzf = jSONObject;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
