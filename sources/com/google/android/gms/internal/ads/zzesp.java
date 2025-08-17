package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzesp implements zzeqx {
    final String zza;
    final int zzb;

    public zzesp(String str, int i2) {
        this.zza = str;
        this.zzb = i2;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (!TextUtils.isEmpty(this.zza) && this.zzb != -1) {
            try {
                JSONObject zzf = zzbu.zzf(jSONObject, "pii");
                zzf.put("pvid", this.zza);
                zzf.put("pvid_s", this.zzb);
            } catch (JSONException e2) {
                zze.zzb("Failed putting gms core app set ID info.", e2);
            }
        }
    }
}
