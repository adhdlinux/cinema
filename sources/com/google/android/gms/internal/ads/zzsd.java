package com.google.android.gms.internal.ads;

import android.text.TextUtils;

final class zzsd {
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;

    public zzsd(String str, boolean z2, boolean z3) {
        this.zza = str;
        this.zzb = z2;
        this.zzc = z3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == zzsd.class) {
            zzsd zzsd = (zzsd) obj;
            if (TextUtils.equals(this.zza, zzsd.zza) && this.zzb == zzsd.zzb && this.zzc == zzsd.zzc) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.zza.hashCode() + 31;
        int i2 = 1237;
        int i3 = true != this.zzb ? 1237 : 1231;
        if (true == this.zzc) {
            i2 = 1231;
        }
        return (((hashCode * 31) + i3) * 31) + i2;
    }
}
