package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzaby {
    public final int zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    public zzaby(int i2, byte[] bArr, int i3, int i4) {
        this.zza = i2;
        this.zzb = bArr;
        this.zzc = i3;
        this.zzd = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaby.class == obj.getClass()) {
            zzaby zzaby = (zzaby) obj;
            if (this.zza == zzaby.zza && this.zzc == zzaby.zzc && this.zzd == zzaby.zzd && Arrays.equals(this.zzb, zzaby.zzb)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.zza * 31) + Arrays.hashCode(this.zzb)) * 31) + this.zzc) * 31) + this.zzd;
    }
}
