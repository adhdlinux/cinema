package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final class zzbrz {
    public final boolean zza;
    public final String zzb;

    public zzbrz(boolean z2, String str) {
        this.zza = z2;
        this.zzb = str;
    }

    public static zzbrz zza(JSONObject jSONObject) {
        return new zzbrz(jSONObject.optBoolean("enable_prewarming", false), jSONObject.optString("prefetch_url", ""));
    }
}
