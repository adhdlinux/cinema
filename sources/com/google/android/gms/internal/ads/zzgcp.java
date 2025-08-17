package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzgcp extends zzfyu {
    private final zzgco zza;

    private zzgcp(zzgco zzgco) {
        this.zza = zzgco;
    }

    public static zzgcp zzb(zzgco zzgco) {
        return new zzgcp(zzgco);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzgcp) && ((zzgcp) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzgcp.class, this.zza});
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "XChaCha20Poly1305 Parameters (variant: " + obj + ")";
    }

    public final zzgco zza() {
        return this.zza;
    }
}
