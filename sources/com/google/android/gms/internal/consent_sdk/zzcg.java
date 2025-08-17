package com.google.android.gms.internal.consent_sdk;

public final class zzcg<T> implements zzcl<T> {
    private static final Object zza = new Object();
    private volatile zzcl<T> zzb;
    private volatile Object zzc = zza;

    private zzcg(zzcl<T> zzcl) {
        this.zzb = zzcl;
    }

    public static <P extends zzcl<T>, T> zzcl<T> zza(P p2) {
        p2.getClass();
        if (p2 instanceof zzcg) {
            return p2;
        }
        return new zzcg(p2);
    }

    public final T zzb() {
        T t2 = this.zzc;
        T t3 = zza;
        if (t2 == t3) {
            synchronized (this) {
                t2 = this.zzc;
                if (t2 == t3) {
                    t2 = this.zzb.zzb();
                    T t4 = this.zzc;
                    if (t4 != t3 && !(t4 instanceof zzcj)) {
                        if (t4 != t2) {
                            String valueOf = String.valueOf(t4);
                            String valueOf2 = String.valueOf(t2);
                            StringBuilder sb = new StringBuilder(valueOf.length() + 118 + valueOf2.length());
                            sb.append("Scoped provider was invoked recursively returning different results: ");
                            sb.append(valueOf);
                            sb.append(" & ");
                            sb.append(valueOf2);
                            sb.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    this.zzc = t2;
                    this.zzb = null;
                }
            }
        }
        return t2;
    }
}
