package com.google.android.gms.internal.ads;

import java.util.Arrays;

final class zzgfg {
    private final Class zza;
    private final zzgnk zzb;

    /* synthetic */ zzgfg(Class cls, zzgnk zzgnk, zzgff zzgff) {
        this.zza = cls;
        this.zzb = zzgnk;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgfg)) {
            return false;
        }
        zzgfg zzgfg = (zzgfg) obj;
        if (!zzgfg.zza.equals(this.zza) || !zzgfg.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        String simpleName = this.zza.getSimpleName();
        String valueOf = String.valueOf(this.zzb);
        return simpleName + ", object identifier: " + valueOf;
    }
}
