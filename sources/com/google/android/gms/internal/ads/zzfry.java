package com.google.android.gms.internal.ads;

import java.io.Serializable;

final class zzfry extends zzfqw implements Serializable {
    final Object zza;
    final Object zzb;

    zzfry(Object obj, Object obj2) {
        this.zza = obj;
        this.zzb = obj2;
    }

    public final Object getKey() {
        return this.zza;
    }

    public final Object getValue() {
        return this.zzb;
    }

    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}
