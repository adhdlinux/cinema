package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;

public final class zzghl {
    private HashMap zza = new HashMap();

    public final zzghn zza() {
        if (this.zza != null) {
            zzghn zzghn = new zzghn(Collections.unmodifiableMap(this.zza), (zzghm) null);
            this.zza = null;
            return zzghn;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
