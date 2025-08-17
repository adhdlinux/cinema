package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.vungle.ads.internal.ui.AdActivity;
import org.json.JSONException;
import org.json.JSONObject;

final class zzdyf implements zzbms {
    zzdyf() {
    }

    public final /* bridge */ /* synthetic */ JSONObject zzb(Object obj) throws JSONException {
        zzdyg zzdyg = (zzdyg) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zziN)).booleanValue()) {
            jSONObject2.put("ad_request_url", zzdyg.zzd.zze());
            jSONObject2.put("ad_request_post_body", zzdyg.zzd.zzd());
        }
        jSONObject2.put("base_url", zzdyg.zzd.zzb());
        jSONObject2.put("signals", zzdyg.zzc);
        jSONObject3.put("body", zzdyg.zzb.zzc);
        jSONObject3.put("headers", zzay.zzb().zzi(zzdyg.zzb.zzb));
        jSONObject3.put("response_code", zzdyg.zzb.zza);
        jSONObject3.put("latency", zzdyg.zzb.zzd);
        jSONObject.put(AdActivity.REQUEST_KEY_EXTRA, jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzdyg.zzd.zzg());
        return jSONObject;
    }
}
