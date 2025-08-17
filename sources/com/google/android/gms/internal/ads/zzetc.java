package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

final class zzetc implements zzeqy {
    private final JSONObject zza;

    zzetc(Context context) {
        this.zza = zzbuo.zzc(context);
    }

    public final int zza() {
        return 46;
    }

    public final zzfwm zzb() {
        return zzfwc.zzh(new zzetb(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", this.zza);
        } catch (JSONException unused) {
            zze.zza("Failed putting version constants.");
        }
    }
}
