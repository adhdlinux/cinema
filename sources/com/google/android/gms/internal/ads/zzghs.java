package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzghs {
    private final zzfxs zza;
    private final int zzb;
    private final String zzc;
    private final String zzd;

    /* synthetic */ zzghs(zzfxs zzfxs, int i2, String str, String str2, zzghr zzghr) {
        this.zza = zzfxs;
        this.zzb = i2;
        this.zzc = str;
        this.zzd = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzghs)) {
            return false;
        }
        zzghs zzghs = (zzghs) obj;
        if (this.zza != zzghs.zza || this.zzb != zzghs.zzb || !this.zzc.equals(zzghs.zzc) || !this.zzd.equals(zzghs.zzd)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final String toString() {
        return String.format("(status=%s, keyId=%s, keyType='%s', keyPrefix='%s')", new Object[]{this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final int zza() {
        return this.zzb;
    }
}
