package com.google.android.gms.internal.ads;

import java.util.Arrays;

final class zzgfi {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzgfi(Class cls, Class cls2, zzgfh zzgfh) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgfi)) {
            return false;
        }
        zzgfi zzgfi = (zzgfi) obj;
        if (!zzgfi.zza.equals(this.zza) || !zzgfi.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        String simpleName = this.zza.getSimpleName();
        String simpleName2 = this.zzb.getSimpleName();
        return simpleName + " with serialization type: " + simpleName2;
    }
}
