package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

public final class zzdkg {
    private final Executor zza;
    private final zzdkb zzb;

    public zzdkg(Executor executor, zzdkb zzdkb) {
        this.zza = executor;
        this.zzb = zzdkb;
    }

    public final zzfwm zza(JSONObject jSONObject, String str) {
        zzfwm zzfwm;
        JSONArray optJSONArray = jSONObject.optJSONArray("custom_assets");
        if (optJSONArray == null) {
            return zzfwc.zzh(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject == null) {
                zzfwm = zzfwc.zzh((Object) null);
            } else {
                String optString = optJSONObject.optString("name");
                if (optString == null) {
                    zzfwm = zzfwc.zzh((Object) null);
                } else {
                    String optString2 = optJSONObject.optString("type");
                    if ("string".equals(optString2)) {
                        zzfwm = zzfwc.zzh(new zzdkf(optString, optJSONObject.optString("string_value")));
                    } else if ("image".equals(optString2)) {
                        zzfwm = zzfwc.zzl(this.zzb.zze(optJSONObject, "image_value"), new zzdkd(optString), this.zza);
                    } else {
                        zzfwm = zzfwc.zzh((Object) null);
                    }
                }
            }
            arrayList.add(zzfwm);
        }
        return zzfwc.zzl(zzfwc.zzd(arrayList), zzdke.zza, this.zza);
    }
}
