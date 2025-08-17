package com.google.android.gms.internal.ads;

final class zzgox {
    private final Object zza;
    private final int zzb;

    zzgox(Object obj, int i2) {
        this.zza = obj;
        this.zzb = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgox)) {
            return false;
        }
        zzgox zzgox = (zzgox) obj;
        if (this.zza == zzgox.zza && this.zzb == zzgox.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
