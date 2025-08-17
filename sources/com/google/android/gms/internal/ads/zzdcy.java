package com.google.android.gms.internal.ads;

import java.util.List;

public final class zzdcy {
    private final List zza;
    private final zzfgr zzb;
    private boolean zzc;

    public zzdcy(zzezn zzezn, zzfgr zzfgr) {
        this.zza = zzezn.zzq;
        this.zzb = zzfgr;
    }

    public final void zza() {
        if (!this.zzc) {
            this.zzb.zzd(this.zza);
            this.zzc = true;
        }
    }
}
