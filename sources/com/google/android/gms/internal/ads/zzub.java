package com.google.android.gms.internal.ads;

final class zzub implements zzxa {
    private final zzxa zza;
    private final zzcy zzb;

    public zzub(zzxa zzxa, zzcy zzcy) {
        this.zza = zzxa;
        this.zzb = zzcy;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzub)) {
            return false;
        }
        zzub zzub = (zzub) obj;
        if (!this.zza.equals(zzub.zza) || !this.zzb.equals(zzub.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return ((this.zzb.hashCode() + 527) * 31) + this.zza.hashCode();
    }

    public final int zza(int i2) {
        return this.zza.zza(0);
    }

    public final int zzb(int i2) {
        return this.zza.zzb(i2);
    }

    public final int zzc() {
        return this.zza.zzc();
    }

    public final zzam zzd(int i2) {
        return this.zza.zzd(i2);
    }

    public final zzcy zze() {
        return this.zzb;
    }
}
