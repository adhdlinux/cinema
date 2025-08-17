package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.ArrayList;
import org.json.JSONObject;

public final class zzdjo {
    private final zzfwn zza;
    private final zzdkb zzb;
    private final zzdkg zzc;

    public zzdjo(zzfwn zzfwn, zzdkb zzdkb, zzdkg zzdkg) {
        this.zza = zzfwn;
        this.zzb = zzdkb;
        this.zzc = zzdkg;
    }

    public final zzfwm zza(zzezz zzezz, zzezn zzezn, JSONObject jSONObject) {
        zzfwm zzm;
        zzezz zzezz2 = zzezz;
        zzezn zzezn2 = zzezn;
        JSONObject jSONObject2 = jSONObject;
        zzfwm zzb2 = this.zza.zzb(new zzdjm(this, zzezz2, zzezn2, jSONObject2));
        zzfwm zzf = this.zzb.zzf(jSONObject2, "images");
        zzfwm zzg = this.zzb.zzg(jSONObject2, "images", zzezn2, zzezz2.zzb.zzb);
        zzfwm zze = this.zzb.zze(jSONObject2, "secondary_image");
        zzfwm zze2 = this.zzb.zze(jSONObject2, "app_icon");
        zzfwm zzd = this.zzb.zzd(jSONObject2, "attribution");
        zzfwm zzh = this.zzb.zzh(jSONObject2, zzezn2, zzezz2.zzb.zzb);
        zzfwm zza2 = this.zzc.zza(jSONObject2, "custom_assets");
        zzdkb zzdkb = this.zzb;
        if (!jSONObject2.optBoolean("enable_omid")) {
            zzm = zzfwc.zzh((Object) null);
        } else {
            JSONObject optJSONObject = jSONObject2.optJSONObject("omid_settings");
            if (optJSONObject == null) {
                zzm = zzfwc.zzh((Object) null);
            } else {
                String optString = optJSONObject.optString("omid_html");
                if (TextUtils.isEmpty(optString)) {
                    zzm = zzfwc.zzh((Object) null);
                } else {
                    zzm = zzfwc.zzm(zzfwc.zzh((Object) null), new zzdjq(zzdkb, optString), zzcae.zze);
                }
            }
        }
        zzfwm zzfwm = zzm;
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzb2);
        arrayList.add(zzf);
        arrayList.add(zzg);
        arrayList.add(zze);
        arrayList.add(zze2);
        arrayList.add(zzd);
        arrayList.add(zzh);
        arrayList.add(zza2);
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzeS)).booleanValue()) {
            arrayList.add(zzfwm);
        }
        return zzfwc.zza(arrayList).zza(new zzdjn(this, zzb2, zzf, zze2, zze, zzd, jSONObject, zzh, zzg, zzfwm, zza2), this.zza);
    }
}
