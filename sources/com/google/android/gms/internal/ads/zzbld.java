package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class zzbld {
    public static void zza(zzble zzble, String str, Map map) {
        try {
            zzble.zze(str, zzay.zzb().zzi(map));
        } catch (JSONException unused) {
            zzbzr.zzj("Could not convert parameters to JSON.");
        }
    }

    public static void zzb(zzble zzble, String str, JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(jSONObject2);
        sb.append(");");
        zzbzr.zze("Dispatching AFMA event: ".concat(sb.toString()));
        zzble.zza(sb.toString());
    }

    public static void zzc(zzble zzble, String str, String str2) {
        zzble.zza(str + "(" + str2 + ");");
    }

    public static void zzd(zzble zzble, String str, JSONObject jSONObject) {
        zzble.zzb(str, jSONObject.toString());
    }
}
