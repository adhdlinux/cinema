package com.google.android.gms.internal.ads;

public final class zzvs {
    public final long zza;
    public final long zzb;

    public zzvs(long j2, long j3) {
        this.zza = j2;
        this.zzb = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzvs)) {
            return false;
        }
        zzvs zzvs = (zzvs) obj;
        if (this.zza == zzvs.zza && this.zzb == zzvs.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.zza) * 31) + ((int) this.zzb);
    }
}
