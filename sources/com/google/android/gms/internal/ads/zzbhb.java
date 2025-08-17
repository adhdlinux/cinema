package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzbu;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbhb implements zzbij {
    private final zzbhc zza;

    public zzbhb(zzbhc zzbhc) {
        this.zza = zzbhc;
    }

    public final void zza(Object obj, Map map) {
        if (this.zza != null) {
            String str = (String) map.get("name");
            if (str == null) {
                zzbzr.zzi("Ad metadata with no name parameter.");
                str = "";
            }
            Bundle bundle = null;
            if (map.containsKey("info")) {
                try {
                    bundle = zzbu.zza(new JSONObject((String) map.get("info")));
                } catch (JSONException e2) {
                    zzbzr.zzh("Failed to convert ad metadata to JSON.", e2);
                }
            }
            if (bundle == null) {
                zzbzr.zzg("Failed to convert ad metadata to Bundle.");
            } else {
                this.zza.zza(str, bundle);
            }
        }
    }
}
