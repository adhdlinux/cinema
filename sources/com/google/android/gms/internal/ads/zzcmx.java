package com.google.android.gms.internal.ads;

import org.json.JSONObject;

final class zzcmx implements zzcmk {
    private final zzbwy zza;

    zzcmx(zzbwy zzbwy) {
        this.zza = zzbwy;
    }

    public final void zza(JSONObject jSONObject) {
        int i2;
        long optLong = jSONObject.optLong("timestamp");
        if (jSONObject.optBoolean("npa_reset")) {
            i2 = -1;
        } else {
            i2 = jSONObject.optBoolean("npa");
        }
        this.zza.zzb(i2, optLong);
    }
}
