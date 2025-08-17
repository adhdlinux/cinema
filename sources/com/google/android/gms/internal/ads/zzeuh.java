package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzbu;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzeuh implements zzeqx {
    private final String zza;

    public zzeuh(String str) {
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        try {
            if (!TextUtils.isEmpty(this.zza)) {
                zzbu.zzf(jSONObject, "pii").put("adsid", this.zza);
            }
        } catch (JSONException e2) {
            zzbzr.zzk("Failed putting trustless token.", e2);
        }
    }
}
