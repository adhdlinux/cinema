package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzeul implements zzeqx {
    private final Map zza;

    public zzeul(Map map) {
        this.zza = map;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        try {
            ((JSONObject) obj).put("video_decoders", zzay.zzb().zzi(this.zza));
        } catch (JSONException e2) {
            zze.zza("Could not encode video decoder properties: ".concat(String.valueOf(e2.getMessage())));
        }
    }
}
