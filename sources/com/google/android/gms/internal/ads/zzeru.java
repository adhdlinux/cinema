package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzeru implements zzeqx {
    private final String zza;

    public zzeru(String str) {
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        try {
            ((JSONObject) obj).put("ms", this.zza);
        } catch (JSONException e2) {
            zze.zzb("Failed putting Ad ID.", e2);
        }
    }
}
