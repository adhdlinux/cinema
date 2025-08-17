package com.google.android.gms.internal.measurement;

final class zzjr {
    private static final zzjp zza = new zzjq();
    private static final zzjp zzb;

    static {
        zzjp zzjp;
        try {
            zzjp = (zzjp) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzjp = null;
        }
        zzb = zzjp;
    }

    static zzjp zza() {
        zzjp zzjp = zzb;
        if (zzjp != null) {
            return zzjp;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzjp zzb() {
        return zza;
    }
}
