package com.google.android.gms.internal.ads;

public final class zzabw {
    public static final zzabw zza = new zzabw(0, 0);
    public final long zzb;
    public final long zzc;

    public zzabw(long j2, long j3) {
        this.zzb = j2;
        this.zzc = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzabw.class == obj.getClass()) {
            zzabw zzabw = (zzabw) obj;
            return this.zzb == zzabw.zzb && this.zzc == zzabw.zzc;
        }
    }

    public final int hashCode() {
        return (((int) this.zzb) * 31) + ((int) this.zzc);
    }

    public final String toString() {
        long j2 = this.zzb;
        long j3 = this.zzc;
        return "[timeUs=" + j2 + ", position=" + j3 + "]";
    }
}
