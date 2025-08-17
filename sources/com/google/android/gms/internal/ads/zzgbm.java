package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzgbm extends zzfyu {
    private final int zza;
    private final zzgbk zzb;

    /* synthetic */ zzgbm(int i2, zzgbk zzgbk, zzgbl zzgbl) {
        this.zza = i2;
        this.zzb = zzgbk;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgbm)) {
            return false;
        }
        zzgbm zzgbm = (zzgbm) obj;
        return zzgbm.zza == this.zza && zzgbm.zzb == this.zzb;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzgbm.class, Integer.valueOf(this.zza), this.zzb});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzb);
        int i2 = this.zza;
        return "AesGcmSiv Parameters (variant: " + valueOf + ", " + i2 + "-byte key)";
    }

    public final int zza() {
        return this.zza;
    }

    public final zzgbk zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        return this.zzb != zzgbk.zzc;
    }
}
