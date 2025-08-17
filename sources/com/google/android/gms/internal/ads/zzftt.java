package com.google.android.gms.internal.ads;

import java.io.Serializable;

final class zzftt extends zzftl implements Serializable {
    static final zzftt zza = new zzftt();

    private zzftt() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        comparable.getClass();
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public final String toString() {
        return "Ordering.natural().reverse()";
    }

    public final zzftl zza() {
        return zzftj.zza;
    }
}
