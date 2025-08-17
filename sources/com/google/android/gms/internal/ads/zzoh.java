package com.google.android.gms.internal.ads;

public final class zzoh {
    public static final zzoh zza = new zzof().zzd();
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;

    /* synthetic */ zzoh(zzof zzof, zzog zzog) {
        this.zzb = zzof.zza;
        this.zzc = zzof.zzb;
        this.zzd = zzof.zzc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzoh.class == obj.getClass()) {
            zzoh zzoh = (zzoh) obj;
            return this.zzb == zzoh.zzb && this.zzc == zzoh.zzc && this.zzd == zzoh.zzd;
        }
    }

    public final int hashCode() {
        boolean z2 = this.zzc;
        return ((this.zzb ? 1 : 0) << true) + (z2 ? 1 : 0) + z2 + (this.zzd ? 1 : 0);
    }
}
