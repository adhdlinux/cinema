package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.util.concurrent.Callable;
import org.json.JSONObject;

public final /* synthetic */ class zzdjm implements Callable {
    public final /* synthetic */ zzdjo zza;
    public final /* synthetic */ zzezz zzb;
    public final /* synthetic */ zzezn zzc;
    public final /* synthetic */ JSONObject zzd;

    public /* synthetic */ zzdjm(zzdjo zzdjo, zzezz zzezz, zzezn zzezn, JSONObject jSONObject) {
        this.zza = zzdjo;
        this.zzb = zzezz;
        this.zzc = zzezn;
        this.zzd = jSONObject;
    }

    public final Object call() {
        String str;
        zzezz zzezz = this.zzb;
        zzezn zzezn = this.zzc;
        JSONObject jSONObject = this.zzd;
        zzdha zzdha = new zzdha();
        zzdha.zzY(jSONObject.optInt("template_id", -1));
        zzdha.zzJ(jSONObject.optString("custom_template_id"));
        JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
        if (optJSONObject != null) {
            str = optJSONObject.optString("omid_partner_name");
        } else {
            str = null;
        }
        zzdha.zzU(str);
        zzfai zzfai = zzezz.zza.zza;
        if (zzfai.zzg.contains(Integer.toString(zzdha.zzc()))) {
            if (zzdha.zzc() == 3) {
                if (zzdha.zzz() == null) {
                    throw new zzefu(1, "No custom template id for custom template ad response.");
                } else if (!zzfai.zzh.contains(zzdha.zzz())) {
                    throw new zzefu(1, "Unexpected custom template id in the response.");
                }
            }
            zzdha.zzW(jSONObject.optDouble("rating", -1.0d));
            String optString = jSONObject.optString("headline", (String) null);
            if (zzezn.zzN) {
                zzt.zzp();
                optString = zzs.zzu() + " : " + optString;
            }
            zzdha.zzX("headline", optString);
            zzdha.zzX("body", jSONObject.optString("body", (String) null));
            zzdha.zzX("call_to_action", jSONObject.optString("call_to_action", (String) null));
            zzdha.zzX("store", jSONObject.optString("store", (String) null));
            zzdha.zzX(InAppPurchaseMetaData.KEY_PRICE, jSONObject.optString(InAppPurchaseMetaData.KEY_PRICE, (String) null));
            zzdha.zzX("advertiser", jSONObject.optString("advertiser", (String) null));
            return zzdha;
        }
        throw new zzefu(1, "Invalid template ID: " + zzdha.zzc());
    }
}
