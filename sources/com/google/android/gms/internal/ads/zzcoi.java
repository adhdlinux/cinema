package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

public final class zzcoi implements zzgwe {
    private final zzgwr zza;

    public zzcoi(zzgwr zzgwr) {
        this.zza = zzgwr;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        try {
            return new JSONObject(((zzcrt) this.zza).zza().zzA);
        } catch (JSONException unused) {
            return null;
        }
    }
}
