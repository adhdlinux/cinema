package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

public final class zzfih {
    private JSONObject zza;
    private final zzfiq zzb;

    public zzfih(zzfiq zzfiq) {
        this.zzb = zzfiq;
    }

    public final JSONObject zza() {
        return this.zza;
    }

    public final void zzb() {
        this.zzb.zzb(new zzfir(this));
    }

    public final void zzc(JSONObject jSONObject, HashSet hashSet, long j2) {
        this.zzb.zzb(new zzfis(this, hashSet, jSONObject, j2));
    }

    public final void zzd(JSONObject jSONObject, HashSet hashSet, long j2) {
        this.zzb.zzb(new zzfit(this, hashSet, jSONObject, j2));
    }

    public final void zze(JSONObject jSONObject) {
        this.zza = jSONObject;
    }
}
