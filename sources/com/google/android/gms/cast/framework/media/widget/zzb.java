package com.google.android.gms.cast.framework.media.widget;

public final class zzb {
    public final int zza;
    public final int zzb;
    public final boolean zzc;

    public zzb(int i2, int i3, boolean z2) {
        this.zza = i2;
        this.zzb = i3;
        this.zzc = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof zzb) && this.zza == ((zzb) obj).zza) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.valueOf(this.zza).hashCode();
    }
}
