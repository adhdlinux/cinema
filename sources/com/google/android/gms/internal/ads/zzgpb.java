package com.google.android.gms.internal.ads;

final class zzgpb {
    private static final zzgoz zza = new zzgpa();
    private static final zzgoz zzb;

    static {
        zzgoz zzgoz;
        try {
            zzgoz = (zzgoz) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzgoz = null;
        }
        zzb = zzgoz;
    }

    static zzgoz zza() {
        zzgoz zzgoz = zzb;
        if (zzgoz != null) {
            return zzgoz;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzgoz zzb() {
        return zza;
    }
}
