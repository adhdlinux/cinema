package com.google.android.gms.internal.auth;

final class zzdl implements zzdj {
    volatile zzdj zza;
    volatile boolean zzb;
    Object zzc;

    zzdl(zzdj zzdj) {
        zzdj.getClass();
        this.zza = zzdj;
    }

    public final String toString() {
        Object obj = this.zza;
        StringBuilder sb = new StringBuilder();
        sb.append("Suppliers.memoize(");
        if (obj == null) {
            obj = "<supplier that returned " + this.zzc + ">";
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }

    public final Object zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    zzdj zzdj = this.zza;
                    zzdj.getClass();
                    Object zza2 = zzdj.zza();
                    this.zzc = zza2;
                    this.zzb = true;
                    this.zza = null;
                    return zza2;
                }
            }
        }
        return this.zzc;
    }
}
