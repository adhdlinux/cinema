package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzgfz extends zzghe {
    private final int zza;
    private final int zzb;
    private final zzgfx zzc;

    /* synthetic */ zzgfz(int i2, int i3, zzgfx zzgfx, zzgfy zzgfy) {
        this.zza = i2;
        this.zzb = i3;
        this.zzc = zzgfx;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgfz)) {
            return false;
        }
        zzgfz zzgfz = (zzgfz) obj;
        if (zzgfz.zza == this.zza && zzgfz.zzc() == zzc() && zzgfz.zzc == this.zzc) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzgfz.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        int i2 = this.zzb;
        int i3 = this.zza;
        return "AES-CMAC Parameters (variant: " + valueOf + ", " + i2 + "-byte tags, and " + i3 + "-byte key)";
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzc() {
        zzgfx zzgfx = this.zzc;
        if (zzgfx == zzgfx.zzd) {
            return this.zzb;
        }
        if (zzgfx == zzgfx.zza || zzgfx == zzgfx.zzb || zzgfx == zzgfx.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzgfx zzd() {
        return this.zzc;
    }

    public final boolean zze() {
        return this.zzc != zzgfx.zzd;
    }
}
