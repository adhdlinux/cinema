package com.google.android.gms.internal.ads;

public final class zzggt {
    public static final zzggt zza = new zzggt("SHA1");
    public static final zzggt zzb = new zzggt("SHA224");
    public static final zzggt zzc = new zzggt("SHA256");
    public static final zzggt zzd = new zzggt("SHA384");
    public static final zzggt zze = new zzggt("SHA512");
    private final String zzf;

    private zzggt(String str) {
        this.zzf = str;
    }

    public final String toString() {
        return this.zzf;
    }
}
