package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzesz implements zzeqx {
    private final JSONObject zza;

    public zzesz(JSONObject jSONObject) {
        this.zza = jSONObject;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        try {
            ((JSONObject) obj).put("cache_state", this.zza);
        } catch (JSONException unused) {
            zze.zza("Unable to get cache_state");
        }
    }
}
