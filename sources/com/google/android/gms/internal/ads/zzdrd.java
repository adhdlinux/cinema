package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import org.json.JSONException;
import org.json.JSONObject;

final class zzdrd {
    /* access modifiers changed from: private */
    public Long zza;
    private final String zzb;
    /* access modifiers changed from: private */
    public String zzc;
    /* access modifiers changed from: private */
    public Integer zzd;
    /* access modifiers changed from: private */
    public String zze;
    /* access modifiers changed from: private */
    public Integer zzf;

    /* synthetic */ zzdrd(String str, zzdrc zzdrc) {
        this.zzb = str;
    }

    static /* bridge */ /* synthetic */ String zza(zzdrd zzdrd) {
        String str = (String) zzba.zzc().zzb(zzbbm.zzje);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("objectId", zzdrd.zza);
            jSONObject.put("eventCategory", zzdrd.zzb);
            jSONObject.putOpt("event", zzdrd.zzc);
            jSONObject.putOpt("errorCode", zzdrd.zzd);
            jSONObject.putOpt("rewardType", zzdrd.zze);
            jSONObject.putOpt("rewardAmount", zzdrd.zzf);
        } catch (JSONException unused) {
            zzbzr.zzj("Could not convert parameters to JSON.");
        }
        String jSONObject2 = jSONObject.toString();
        return str + "(\"h5adsEvent\"," + jSONObject2 + ");";
    }
}
