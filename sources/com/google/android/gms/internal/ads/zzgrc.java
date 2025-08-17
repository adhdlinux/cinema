package com.google.android.gms.internal.ads;

final class zzgrc {
    private static final zzgrb zza;
    private static final zzgrb zzb = new zzgrb();

    static {
        zzgrb zzgrb;
        try {
            zzgrb = (zzgrb) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzgrb = null;
        }
        zza = zzgrb;
    }

    static zzgrb zza() {
        return zza;
    }

    static zzgrb zzb() {
        return zzb;
    }
}
