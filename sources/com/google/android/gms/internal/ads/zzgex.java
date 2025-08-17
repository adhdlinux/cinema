package com.google.android.gms.internal.ads;

import java.util.Arrays;

final class zzgex {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzgex(Class cls, Class cls2, zzgew zzgew) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgex)) {
            return false;
        }
        zzgex zzgex = (zzgex) obj;
        if (!zzgex.zza.equals(this.zza) || !zzgex.zzb.equals(this.zzb)) {
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
        return simpleName + " with primitive type: " + simpleName2;
    }
}
