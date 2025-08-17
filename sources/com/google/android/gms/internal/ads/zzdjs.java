package com.google.android.gms.internal.ads;

import java.util.List;
import org.json.JSONObject;

public final /* synthetic */ class zzdjs implements zzfov {
    public final /* synthetic */ zzdkb zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzdjs(zzdkb zzdkb, JSONObject jSONObject) {
        this.zza = zzdkb;
        this.zzb = jSONObject;
    }

    public final Object apply(Object obj) {
        return this.zza.zza(this.zzb, (List) obj);
    }
}
