package com.google.android.gms.internal.cast;

final class zzsd implements zztn {
    private static final zzsd zza = new zzsd();

    private zzsd() {
    }

    public static zzsd zza() {
        return zza;
    }

    public final zztm zzb(Class cls) {
        Class<zzsh> cls2 = zzsh.class;
        if (cls2.isAssignableFrom(cls)) {
            try {
                return (zztm) zzsh.zzv(cls.asSubclass(cls2)).zzb(3, (Object) null, (Object) null);
            } catch (Exception e2) {
                throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e2);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
    }

    public final boolean zzc(Class cls) {
        return zzsh.class.isAssignableFrom(cls);
    }
}
