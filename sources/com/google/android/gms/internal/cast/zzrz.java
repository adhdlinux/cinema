package com.google.android.gms.internal.cast;

final class zzrz {
    private static final zzrx zza = new zzry();
    private static final zzrx zzb;

    static {
        zzrx zzrx;
        try {
            zzrx = (zzrx) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzrx = null;
        }
        zzb = zzrx;
    }

    static zzrx zza() {
        zzrx zzrx = zzb;
        if (zzrx != null) {
            return zzrx;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzrx zzb() {
        return zza;
    }
}
