package com.google.android.gms.internal.ads;

public final class zzgwd implements zzgwr, zzgvy {
    private static final Object zza = new Object();
    private volatile zzgwr zzb;
    private volatile Object zzc = zza;

    private zzgwd(zzgwr zzgwr) {
        this.zzb = zzgwr;
    }

    public static zzgvy zza(zzgwr zzgwr) {
        if (zzgwr instanceof zzgvy) {
            return (zzgvy) zzgwr;
        }
        zzgwr.getClass();
        return new zzgwd(zzgwr);
    }

    public static zzgwr zzc(zzgwr zzgwr) {
        return zzgwr instanceof zzgwd ? zzgwr : new zzgwd(zzgwr);
    }

    public final Object zzb() {
        Object obj = this.zzc;
        Object obj2 = zza;
        if (obj == obj2) {
            synchronized (this) {
                obj = this.zzc;
                if (obj == obj2) {
                    obj = this.zzb.zzb();
                    Object obj3 = this.zzc;
                    if (obj3 != obj2) {
                        if (obj3 != obj) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + obj + ". This is likely due to a circular dependency.");
                        }
                    }
                    this.zzc = obj;
                    this.zzb = null;
                }
            }
        }
        return obj;
    }
}
