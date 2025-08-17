package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzdph implements zzfem {
    private final Map zza;
    private final zzawz zzb;

    zzdph(zzawz zzawz, Map map) {
        this.zza = map;
        this.zzb = zzawz;
    }

    public final void zzbB(zzfef zzfef, String str) {
    }

    public final void zzbC(zzfef zzfef, String str, Throwable th) {
        if (this.zza.containsKey(zzfef)) {
            this.zzb.zzc(((zzdpg) this.zza.get(zzfef)).zzc);
        }
    }

    public final void zzc(zzfef zzfef, String str) {
        if (this.zza.containsKey(zzfef)) {
            this.zzb.zzc(((zzdpg) this.zza.get(zzfef)).zza);
        }
    }

    public final void zzd(zzfef zzfef, String str) {
        if (this.zza.containsKey(zzfef)) {
            this.zzb.zzc(((zzdpg) this.zza.get(zzfef)).zzb);
        }
    }
}
