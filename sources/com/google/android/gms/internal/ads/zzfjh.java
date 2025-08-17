package com.google.android.gms.internal.ads;

final class zzfjh extends zzfjd {
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;

    /* synthetic */ zzfjh(String str, boolean z2, boolean z3, zzfjg zzfjg) {
        this.zza = str;
        this.zzb = z2;
        this.zzc = z3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfjd) {
            zzfjd zzfjd = (zzfjd) obj;
            if (this.zza.equals(zzfjd.zzb()) && this.zzb == zzfjd.zzd() && this.zzc == zzfjd.zzc()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.zza.hashCode() ^ 1000003;
        int i2 = 1237;
        int i3 = true != this.zzb ? 1237 : 1231;
        if (true == this.zzc) {
            i2 = 1231;
        }
        return (((hashCode * 1000003) ^ i3) * 1000003) ^ i2;
    }

    public final String toString() {
        String str = this.zza;
        boolean z2 = this.zzb;
        boolean z3 = this.zzc;
        return "AdShield2Options{clientVersion=" + str + ", shouldGetAdvertisingId=" + z2 + ", isGooglePlayServicesAvailable=" + z3 + "}";
    }

    public final String zzb() {
        return this.zza;
    }

    public final boolean zzc() {
        return this.zzc;
    }

    public final boolean zzd() {
        return this.zzb;
    }
}
