package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class zzdyl implements zzfvj {
    public static final /* synthetic */ zzdyl zza = new zzdyl();

    private /* synthetic */ zzdyl() {
    }

    public final zzfwm zza(Object obj) {
        zzdyu zzdyu = (zzdyu) obj;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("response", zzdyu.zza);
            JSONObject jSONObject2 = new JSONObject();
            for (String str : zzdyu.zzb.keySet()) {
                if (str != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str2 : (List) zzdyu.zzb.get(str)) {
                        if (str2 != null) {
                            jSONArray.put(str2);
                        }
                    }
                    jSONObject2.put(str, jSONArray);
                }
            }
            jSONObject.put("headers", jSONObject2);
            String str3 = zzdyu.zzc;
            if (str3 != null) {
                jSONObject.put("body", str3);
            }
            jSONObject.put("latency", zzdyu.zzd);
            return zzfwc.zzh(new ByteArrayInputStream(jSONObject.toString().getBytes(StandardCharsets.UTF_8)));
        } catch (JSONException e2) {
            zzbzr.zzj("Error converting response to JSONObject: ".concat(String.valueOf(e2.getMessage())));
            throw new JSONException("Parsing HTTP Response: ".concat(String.valueOf(e2.getCause())));
        }
    }
}
