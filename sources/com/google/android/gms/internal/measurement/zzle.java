package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class zzle {
    zzle() {
    }

    public static final int zza(int i2, Object obj, Object obj2) {
        zzld zzld = (zzld) obj;
        zzlc zzlc = (zzlc) obj2;
        if (zzld.isEmpty()) {
            return 0;
        }
        Iterator it2 = zzld.entrySet().iterator();
        if (!it2.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it2.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzld zzld = (zzld) obj;
        zzld zzld2 = (zzld) obj2;
        if (!zzld2.isEmpty()) {
            if (!zzld.zze()) {
                zzld = zzld.zzb();
            }
            zzld.zzd(zzld2);
        }
        return zzld;
    }
}
