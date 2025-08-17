package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONObject;

public final /* synthetic */ class zzdyn implements zzfdo {
    public static final /* synthetic */ zzdyn zza = new zzdyn();

    private /* synthetic */ zzdyn() {
    }

    public final Object zza(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        zze.zza("GMS AdRequest Signals: ");
        zze.zza(jSONObject.toString(2));
        return jSONObject;
    }
}
