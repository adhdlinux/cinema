package com.google.android.gms.internal.ads;

final class zzup {
    public final int zza;
    public final boolean zzb;

    public zzup(int i2, boolean z2) {
        this.zza = i2;
        this.zzb = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzup.class == obj.getClass()) {
            zzup zzup = (zzup) obj;
            return this.zza == zzup.zza && this.zzb == zzup.zzb;
        }
    }

    public final int hashCode() {
        return (this.zza * 31) + (this.zzb ? 1 : 0);
    }
}
