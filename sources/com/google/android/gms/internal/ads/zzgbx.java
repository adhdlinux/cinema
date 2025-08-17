package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzgbx extends zzfyu {
    private final zzgbw zza;

    private zzgbx(zzgbw zzgbw) {
        this.zza = zzgbw;
    }

    public static zzgbx zzb(zzgbw zzgbw) {
        return new zzgbx(zzgbw);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzgbx) && ((zzgbx) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzgbx.class, this.zza});
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "ChaCha20Poly1305 Parameters (variant: " + obj + ")";
    }

    public final zzgbw zza() {
        return this.zza;
    }
}
