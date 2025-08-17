package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

final class zzgqr {
    zzgqr() {
    }

    public static final int zza(int i2, Object obj, Object obj2) {
        zzgqq zzgqq = (zzgqq) obj;
        zzgqp zzgqp = (zzgqp) obj2;
        if (zzgqq.isEmpty()) {
            return 0;
        }
        Iterator it2 = zzgqq.entrySet().iterator();
        if (!it2.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it2.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final boolean zzb(Object obj) {
        return !((zzgqq) obj).zze();
    }

    public static final Object zzc(Object obj, Object obj2) {
        zzgqq zzgqq = (zzgqq) obj;
        zzgqq zzgqq2 = (zzgqq) obj2;
        if (!zzgqq2.isEmpty()) {
            if (!zzgqq.zze()) {
                zzgqq = zzgqq.zzb();
            }
            zzgqq.zzd(zzgqq2);
        }
        return zzgqq;
    }
}
