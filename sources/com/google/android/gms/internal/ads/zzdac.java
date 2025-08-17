package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

public final class zzdac implements zzcyb {
    private int zza = ((Integer) zzba.zzc().zzb(zzbbm.zzbd)).intValue();

    public final synchronized void zzb(zzezz zzezz) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzbe)).booleanValue()) {
            try {
                this.zza = zzezz.zzb.zzb.zzc;
            } catch (NullPointerException unused) {
            }
        }
    }

    public final void zzbA(zzbue zzbue) {
    }

    public final synchronized int zzc() {
        return this.zza;
    }
}
