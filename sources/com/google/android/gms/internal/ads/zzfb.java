package com.google.android.gms.internal.ads;

public final class zzfb {
    public static final zzfb zza = new zzfb(-1, -1);
    public static final zzfb zzb = new zzfb(0, 0);
    private final int zzc;
    private final int zzd;

    public zzfb(int i2, int i3) {
        boolean z2 = false;
        if ((i2 == -1 || i2 >= 0) && (i3 == -1 || i3 >= 0)) {
            z2 = true;
        }
        zzdy.zzd(z2);
        this.zzc = i2;
        this.zzd = i3;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfb) {
            zzfb zzfb = (zzfb) obj;
            return this.zzc == zzfb.zzc && this.zzd == zzfb.zzd;
        }
    }

    public final int hashCode() {
        int i2 = this.zzd;
        int i3 = this.zzc;
        return i2 ^ ((i3 >>> 16) | (i3 << 16));
    }

    public final String toString() {
        int i2 = this.zzc;
        int i3 = this.zzd;
        return i2 + "x" + i3;
    }

    public final int zza() {
        return this.zzd;
    }

    public final int zzb() {
        return this.zzc;
    }
}
