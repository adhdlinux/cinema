package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class zzegk implements zzece {
    private final Map zza = new HashMap();
    private final zzdnv zzb;

    public zzegk(zzdnv zzdnv) {
        this.zzb = zzdnv;
    }

    public final zzecf zza(String str, JSONObject jSONObject) throws zzfan {
        zzecf zzecf;
        synchronized (this) {
            zzecf = (zzecf) this.zza.get(str);
            if (zzecf == null) {
                zzecf = new zzecf(this.zzb.zzc(str, jSONObject), new zzedz(), str);
                this.zza.put(str, zzecf);
            }
        }
        return zzecf;
    }
}
