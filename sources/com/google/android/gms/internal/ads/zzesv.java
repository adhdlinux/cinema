package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzesv implements zzeqx {
    private final String zza;

    public zzesv(String str) {
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        try {
            JSONObject zzf = zzbu.zzf((JSONObject) obj, "pii");
            if (!TextUtils.isEmpty(this.zza)) {
                zzf.put("attok", this.zza);
            }
        } catch (JSONException e2) {
            zze.zzb("Failed putting attestation token.", e2);
        }
    }
}
