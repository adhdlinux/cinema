package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzha {
    private final Map zza = new HashMap();
    private Map zzb;

    public final synchronized Map zza() {
        if (this.zzb == null) {
            this.zzb = Collections.unmodifiableMap(new HashMap(this.zza));
        }
        return this.zzb;
    }
}
