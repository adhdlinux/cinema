package com.google.android.gms.internal.ads;

final class zzfmv extends zzfnn {
    private final int zza;
    private final String zzb;

    /* synthetic */ zzfmv(int i2, String str, zzfmu zzfmu) {
        this.zza = i2;
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfnn) {
            zzfnn zzfnn = (zzfnn) obj;
            if (this.zza != zzfnn.zza() || ((str = this.zzb) != null ? !str.equals(zzfnn.zzb()) : zzfnn.zzb() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.zza ^ 1000003;
        String str = this.zzb;
        return (i2 * 1000003) ^ (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        int i2 = this.zza;
        String str = this.zzb;
        return "OverlayDisplayState{statusCode=" + i2 + ", sessionToken=" + str + "}";
    }

    public final int zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }
}
