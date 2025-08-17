package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzddk extends zzdaq {
    private boolean zzb;

    protected zzddk(Set set) {
        super(set);
    }

    public final void zza() {
        zzp(zzddg.zza);
    }

    public final void zzb() {
        zzp(zzddi.zza);
    }

    public final synchronized void zzc() {
        if (!this.zzb) {
            zzp(zzddh.zza);
            this.zzb = true;
        }
        zzp(zzddj.zza);
    }

    public final synchronized void zzd() {
        zzp(zzddh.zza);
        this.zzb = true;
    }
}
