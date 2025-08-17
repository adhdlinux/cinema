package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

final class zzbnk implements zzbiw {
    final /* synthetic */ zzbnl zza;
    private final zzcaj zzb;

    public zzbnk(zzbnl zzbnl, zzcaj zzcaj) {
        this.zza = zzbnl;
        this.zzb = zzcaj;
    }

    public final void zza(String str) {
        if (str == null) {
            try {
                this.zzb.zze(new zzbmo());
            } catch (IllegalStateException unused) {
            }
        } else {
            this.zzb.zze(new zzbmo(str));
        }
    }

    public final void zzb(JSONObject jSONObject) {
        try {
            this.zzb.zzd(jSONObject);
        } catch (IllegalStateException unused) {
        } catch (JSONException e2) {
            this.zzb.zze(e2);
        }
    }
}
