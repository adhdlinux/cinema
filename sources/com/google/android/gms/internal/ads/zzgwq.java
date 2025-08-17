package com.google.android.gms.internal.ads;

public final class zzgwq implements zzgwr {
    private static final Object zza = new Object();
    private volatile zzgwr zzb;
    private volatile Object zzc = zza;

    private zzgwq(zzgwr zzgwr) {
        this.zzb = zzgwr;
    }

    public static zzgwr zza(zzgwr zzgwr) {
        return ((zzgwr instanceof zzgwq) || (zzgwr instanceof zzgwd)) ? zzgwr : new zzgwq(zzgwr);
    }

    public final Object zzb() {
        Object obj = this.zzc;
        if (obj != zza) {
            return obj;
        }
        zzgwr zzgwr = this.zzb;
        if (zzgwr == null) {
            return this.zzc;
        }
        Object zzb2 = zzgwr.zzb();
        this.zzc = zzb2;
        this.zzb = null;
        return zzb2;
    }
}
