package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzetg implements zzeqx {
    private final String zza;
    private final String zzb;

    public zzetg(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        try {
            JSONObject zzf = zzbu.zzf((JSONObject) obj, "pii");
            zzf.put("doritos", this.zza);
            zzf.put("doritos_v2", this.zzb);
        } catch (JSONException unused) {
            zze.zza("Failed putting doritos string.");
        }
    }
}
