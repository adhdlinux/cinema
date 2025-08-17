package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final /* synthetic */ class zzcnv implements Runnable {
    public final /* synthetic */ zzcez zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzcnv(zzcez zzcez, JSONObject jSONObject) {
        this.zza = zzcez;
        this.zzb = jSONObject;
    }

    public final void run() {
        this.zza.zzl("AFMA_updateActiveView", this.zzb);
    }
}
