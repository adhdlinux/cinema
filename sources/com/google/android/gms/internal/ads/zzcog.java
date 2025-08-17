package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final /* synthetic */ class zzcog implements Runnable {
    public final /* synthetic */ zzcoh zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzcog(zzcoh zzcoh, JSONObject jSONObject) {
        this.zza = zzcoh;
        this.zzb = jSONObject;
    }

    public final void run() {
        this.zza.zzd(this.zzb);
    }
}
