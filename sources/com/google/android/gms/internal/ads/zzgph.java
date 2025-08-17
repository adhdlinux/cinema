package com.google.android.gms.internal.ads;

final class zzgph implements zzgqu {
    private static final zzgph zza = new zzgph();

    private zzgph() {
    }

    public static zzgph zza() {
        return zza;
    }

    public final zzgqt zzb(Class cls) {
        Class<zzgpm> cls2 = zzgpm.class;
        if (cls2.isAssignableFrom(cls)) {
            try {
                return (zzgqt) zzgpm.zzaC(cls.asSubclass(cls2)).zzb(3, (Object) null, (Object) null);
            } catch (Exception e2) {
                throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e2);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
    }

    public final boolean zzc(Class cls) {
        return zzgpm.class.isAssignableFrom(cls);
    }
}
