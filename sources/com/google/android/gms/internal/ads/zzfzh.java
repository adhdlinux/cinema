package com.google.android.gms.internal.ads;

public final class zzfzh {
    public static final zzfzh zza = new zzfzh("SHA1");
    public static final zzfzh zzb = new zzfzh("SHA224");
    public static final zzfzh zzc = new zzfzh("SHA256");
    public static final zzfzh zzd = new zzfzh("SHA384");
    public static final zzfzh zze = new zzfzh("SHA512");
    private final String zzf;

    private zzfzh(String str) {
        this.zzf = str;
    }

    public final String toString() {
        return this.zzf;
    }
}
