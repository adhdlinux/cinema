package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONObject;

public final /* synthetic */ class zzdxt implements zzfdo {
    public static final /* synthetic */ zzdxt zza = new zzdxt();

    private /* synthetic */ zzdxt() {
    }

    public final Object zza(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        zze.zza("Ad request signals:");
        zze.zza(jSONObject.toString(2));
        return jSONObject;
    }
}
