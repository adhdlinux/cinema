package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzgav extends zzfyu {
    private final int zza;
    private final int zzb = 12;
    private final int zzc = 16;
    private final zzgat zzd;

    /* synthetic */ zzgav(int i2, int i3, int i4, zzgat zzgat, zzgau zzgau) {
        this.zza = i2;
        this.zzd = zzgat;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgav)) {
            return false;
        }
        zzgav zzgav = (zzgav) obj;
        return zzgav.zza == this.zza && zzgav.zzd == this.zzd;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzgav.class, Integer.valueOf(this.zza), 12, 16, this.zzd});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzd);
        int i2 = this.zza;
        return "AesGcm Parameters (variant: " + valueOf + ", " + 12 + "-byte IV, " + 16 + "-byte tag, and " + i2 + "-byte key)";
    }

    public final int zza() {
        return this.zza;
    }

    public final zzgat zzb() {
        return this.zzd;
    }

    public final boolean zzc() {
        return this.zzd != zzgat.zzc;
    }
}
