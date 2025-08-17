package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzgae extends zzfyu {
    private final int zza;
    private final int zzb;
    private final int zzc = 16;
    private final zzgac zzd;

    /* synthetic */ zzgae(int i2, int i3, int i4, zzgac zzgac, zzgad zzgad) {
        this.zza = i2;
        this.zzb = i3;
        this.zzd = zzgac;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgae)) {
            return false;
        }
        zzgae zzgae = (zzgae) obj;
        return zzgae.zza == this.zza && zzgae.zzb == this.zzb && zzgae.zzd == this.zzd;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzgae.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), 16, this.zzd});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzd);
        int i2 = this.zzb;
        int i3 = this.zza;
        return "AesEax Parameters (variant: " + valueOf + ", " + i2 + "-byte IV, " + 16 + "-byte tag, and " + i3 + "-byte key)";
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzgac zzc() {
        return this.zzd;
    }

    public final boolean zzd() {
        return this.zzd != zzgac.zzc;
    }
}
