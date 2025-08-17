package com.google.android.gms.internal.ads;

final class zzen {
    public final Object zza;
    private zzaf zzb = new zzaf();
    private boolean zzc;
    private boolean zzd;

    public zzen(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzen.class != obj.getClass()) {
            return false;
        }
        return this.zza.equals(((zzen) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zza(int i2, zzel zzel) {
        if (!this.zzd) {
            if (i2 != -1) {
                this.zzb.zza(i2);
            }
            this.zzc = true;
            zzel.zza(this.zza);
        }
    }

    public final void zzb(zzem zzem) {
        if (!this.zzd && this.zzc) {
            zzah zzb2 = this.zzb.zzb();
            this.zzb = new zzaf();
            this.zzc = false;
            zzem.zza(this.zza, zzb2);
        }
    }

    public final void zzc(zzem zzem) {
        this.zzd = true;
        if (this.zzc) {
            this.zzc = false;
            zzem.zza(this.zza, this.zzb.zzb());
        }
    }
}
