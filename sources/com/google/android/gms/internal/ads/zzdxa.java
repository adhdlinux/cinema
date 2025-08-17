package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzay;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class zzdxa implements zzfov {
    public final /* synthetic */ zzdxb zza;
    public final /* synthetic */ zzbue zzb;

    public /* synthetic */ zzdxa(zzdxb zzdxb, zzbue zzbue) {
        this.zza = zzdxb;
        this.zzb = zzbue;
    }

    public final Object apply(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        Bundle bundle = this.zzb.zza;
        if (bundle == null) {
            return jSONObject;
        }
        try {
            JSONObject zzh = zzay.zzb().zzh(bundle);
            try {
                zzay.zzb().zzk(jSONObject, zzh);
                return jSONObject;
            } catch (JSONException unused) {
                return zzh;
            }
        } catch (JSONException unused2) {
            return jSONObject;
        }
    }
}
