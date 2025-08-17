package com.google.android.gms.internal.ads;

final class zzfez {
    public final String zza;
    public final String zzb;

    public zzfez(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfez)) {
            return false;
        }
        zzfez zzfez = (zzfez) obj;
        if (!this.zza.equals(zzfez.zza) || !this.zzb.equals(zzfez.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return String.valueOf(this.zza).concat(String.valueOf(this.zzb)).hashCode();
    }
}
