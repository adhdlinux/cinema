package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

final class zzbnc implements zzbiw {
    final /* synthetic */ zzbnd zza;
    private final zzbmf zzb;
    private final zzcaj zzc;

    public zzbnc(zzbnd zzbnd, zzbmf zzbmf, zzcaj zzcaj) {
        this.zza = zzbnd;
        this.zzb = zzbmf;
        this.zzc = zzcaj;
    }

    public final void zza(String str) {
        zzbmf zzbmf;
        if (str == null) {
            try {
                this.zzc.zze(new zzbmo());
            } catch (IllegalStateException unused) {
                zzbmf = this.zzb;
            } catch (Throwable th) {
                this.zzb.zzb();
                throw th;
            }
        } else {
            this.zzc.zze(new zzbmo(str));
        }
        zzbmf = this.zzb;
        zzbmf.zzb();
    }

    public final void zzb(JSONObject jSONObject) {
        zzbmf zzbmf;
        try {
            this.zzc.zzd(this.zza.zza.zza(jSONObject));
            zzbmf = this.zzb;
        } catch (IllegalStateException unused) {
            zzbmf = this.zzb;
        } catch (JSONException e2) {
            this.zzc.zze(e2);
            zzbmf = this.zzb;
        } catch (Throwable th) {
            this.zzb.zzb();
            throw th;
        }
        zzbmf.zzb();
    }
}
