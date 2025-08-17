package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public final class zzati {
    private final Map zza = new HashMap();

    public final AtomicReference zza(String str) {
        synchronized (this) {
            if (!this.zza.containsKey(str)) {
                this.zza.put(str, new AtomicReference());
            }
        }
        return (AtomicReference) this.zza.get(str);
    }
}
