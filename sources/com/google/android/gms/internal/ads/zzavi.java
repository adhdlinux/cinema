package com.google.android.gms.internal.ads;

public final class zzavi {
    final long zza;
    final String zzb;
    final int zzc;

    zzavi(long j2, String str, int i2) {
        this.zza = j2;
        this.zzb = str;
        this.zzc = i2;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzavi)) {
            zzavi zzavi = (zzavi) obj;
            return zzavi.zza == this.zza && zzavi.zzc == this.zzc;
        }
    }

    public final int hashCode() {
        return (int) this.zza;
    }
}
