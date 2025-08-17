package com.google.android.gms.internal.ads;

import com.vungle.ads.internal.ui.AdActivity;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class zzdvd implements zzfvj {
    public final /* synthetic */ zzdvg zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzdvd(zzdvg zzdvg, String str, String str2) {
        this.zza = zzdvg;
        this.zzb = str;
        this.zzc = str2;
    }

    public final zzfwm zza(Object obj) {
        String str = this.zzb;
        String str2 = this.zzc;
        String str3 = (String) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("headers", new JSONObject());
            jSONObject3.put("body", str);
            jSONObject2.put("base_url", "");
            jSONObject2.put("signals", new JSONObject(str2));
            jSONObject.put(AdActivity.REQUEST_KEY_EXTRA, jSONObject2);
            jSONObject.put("response", jSONObject3);
            jSONObject.put("flags", new JSONObject());
            return zzfwc.zzh(jSONObject);
        } catch (JSONException e2) {
            throw new JSONException("Preloaded loader: ".concat(String.valueOf(e2.getCause())));
        }
    }
}
