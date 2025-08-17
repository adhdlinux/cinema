package com.google.android.gms.internal.ads;

final class zzgqs {
    private static final zzgqr zza;
    private static final zzgqr zzb = new zzgqr();

    static {
        zzgqr zzgqr;
        try {
            zzgqr = (zzgqr) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzgqr = null;
        }
        zza = zzgqr;
    }

    static zzgqr zza() {
        return zza;
    }

    static zzgqr zzb() {
        return zzb;
    }
}
