package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

public final class zzbur extends zzbut {
    private final String zza;
    private final int zzb;

    public zzbur(String str, int i2) {
        this.zza = str;
        this.zzb = i2;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzbur)) {
            zzbur zzbur = (zzbur) obj;
            if (!Objects.equal(this.zza, zzbur.zza) || !Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzbur.zzb))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zza;
    }
}
