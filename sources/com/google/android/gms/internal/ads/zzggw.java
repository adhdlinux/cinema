package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzggw extends zzghe {
    private final int zza;
    private final int zzb;
    private final zzggu zzc;
    private final zzggt zzd;

    /* synthetic */ zzggw(int i2, int i3, zzggu zzggu, zzggt zzggt, zzggv zzggv) {
        this.zza = i2;
        this.zzb = i3;
        this.zzc = zzggu;
        this.zzd = zzggt;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzggw)) {
            return false;
        }
        zzggw zzggw = (zzggw) obj;
        if (zzggw.zza == this.zza && zzggw.zzc() == zzc() && zzggw.zzc == this.zzc && zzggw.zzd == this.zzd) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzggw.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        String valueOf2 = String.valueOf(this.zzd);
        int i2 = this.zzb;
        int i3 = this.zza;
        return "HMAC Parameters (variant: " + valueOf + ", hashType: " + valueOf2 + ", " + i2 + "-byte tags, and " + i3 + "-byte key)";
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzc() {
        zzggu zzggu = this.zzc;
        if (zzggu == zzggu.zzd) {
            return this.zzb;
        }
        if (zzggu == zzggu.zza || zzggu == zzggu.zzb || zzggu == zzggu.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzggt zzd() {
        return this.zzd;
    }

    public final zzggu zze() {
        return this.zzc;
    }

    public final boolean zzf() {
        return this.zzc != zzggu.zzd;
    }
}
