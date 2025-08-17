package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzfzk extends zzfyu {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final zzfzi zze;
    private final zzfzh zzf;

    /* synthetic */ zzfzk(int i2, int i3, int i4, int i5, zzfzi zzfzi, zzfzh zzfzh, zzfzj zzfzj) {
        this.zza = i2;
        this.zzb = i3;
        this.zzc = i4;
        this.zzd = i5;
        this.zze = zzfzi;
        this.zzf = zzfzh;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzfzk)) {
            return false;
        }
        zzfzk zzfzk = (zzfzk) obj;
        return zzfzk.zza == this.zza && zzfzk.zzb == this.zzb && zzfzk.zzc == this.zzc && zzfzk.zzd == this.zzd && zzfzk.zze == this.zze && zzfzk.zzf == this.zzf;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzfzk.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zze);
        String valueOf2 = String.valueOf(this.zzf);
        int i2 = this.zzc;
        int i3 = this.zzd;
        int i4 = this.zza;
        int i5 = this.zzb;
        return "AesCtrHmacAead Parameters (variant: " + valueOf + ", hashType: " + valueOf2 + ", " + i2 + "-byte IV, and " + i3 + "-byte tags, and " + i4 + "-byte AES key, and " + i5 + "-byte HMAC key)";
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return this.zzd;
    }

    public final zzfzh zze() {
        return this.zzf;
    }

    public final zzfzi zzf() {
        return this.zze;
    }

    public final boolean zzg() {
        return this.zze != zzfzi.zzc;
    }
}
