package com.google.android.gms.internal.ads;

public final class zzabt {
    public final zzabw zza;
    public final zzabw zzb;

    public zzabt(zzabw zzabw, zzabw zzabw2) {
        this.zza = zzabw;
        this.zzb = zzabw2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzabt.class == obj.getClass()) {
            zzabt zzabt = (zzabt) obj;
            if (!this.zza.equals(zzabt.zza) || !this.zzb.equals(zzabt.zzb)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza.hashCode() * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        String obj = this.zza.toString();
        String concat = this.zza.equals(this.zzb) ? "" : ", ".concat(this.zzb.toString());
        return "[" + obj + concat + "]";
    }
}
