package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class zzcmh {
    private final Map zza;
    private final Map zzb;

    zzcmh(Map map, Map map2) {
        this.zza = map;
        this.zzb = map2;
    }

    public final void zza(zzezz zzezz) throws Exception {
        for (zzezx zzezx : zzezz.zzb.zzc) {
            if (this.zza.containsKey(zzezx.zza)) {
                ((zzcmk) this.zza.get(zzezx.zza)).zza(zzezx.zzb);
            } else if (this.zzb.containsKey(zzezx.zza)) {
                zzcmj zzcmj = (zzcmj) this.zzb.get(zzezx.zza);
                JSONObject jSONObject = zzezx.zzb;
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String optString = jSONObject.optString(next);
                    if (optString != null) {
                        hashMap.put(next, optString);
                    }
                }
                zzcmj.zza(hashMap);
            }
        }
    }
}
