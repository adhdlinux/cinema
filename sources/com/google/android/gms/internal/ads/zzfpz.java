package com.google.android.gms.internal.ads;

final class zzfpz implements zzfpx {
    private static final zzfpx zza = zzfpy.zza;
    private volatile zzfpx zzb;
    private Object zzc;

    zzfpz(zzfpx zzfpx) {
        this.zzb = zzfpx;
    }

    public final String toString() {
        Object obj = this.zzb;
        if (obj == zza) {
            obj = "<supplier that returned " + String.valueOf(this.zzc) + ">";
        }
        return "Suppliers.memoize(" + String.valueOf(obj) + ")";
    }

    public final Object zza() {
        zzfpx zzfpx = this.zzb;
        zzfpx zzfpx2 = zza;
        if (zzfpx != zzfpx2) {
            synchronized (this) {
                if (this.zzb != zzfpx2) {
                    Object zza2 = this.zzb.zza();
                    this.zzc = zza2;
                    this.zzb = zzfpx2;
                    return zza2;
                }
            }
        }
        return this.zzc;
    }
}
