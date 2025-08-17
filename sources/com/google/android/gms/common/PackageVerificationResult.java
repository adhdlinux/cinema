package com.google.android.gms.common;

public class PackageVerificationResult {
    private final String zza;
    private final boolean zzb;
    private final String zzc;
    private final Throwable zzd;

    private PackageVerificationResult(String str, int i2, boolean z2, String str2, Throwable th) {
        this.zza = str;
        this.zzb = z2;
        this.zzc = str2;
        this.zzd = th;
    }

    public static PackageVerificationResult zza(String str, String str2, Throwable th) {
        return new PackageVerificationResult(str, 1, false, str2, th);
    }

    public static PackageVerificationResult zzd(String str, int i2) {
        return new PackageVerificationResult(str, i2, true, (String) null, (Throwable) null);
    }

    public final void zzb() {
        if (!this.zzb) {
            String valueOf = String.valueOf(this.zzc);
            Throwable th = this.zzd;
            String concat = "PackageVerificationRslt: ".concat(valueOf);
            if (th != null) {
                throw new SecurityException(concat, th);
            }
            throw new SecurityException(concat);
        }
    }

    public final boolean zzc() {
        return this.zzb;
    }
}
