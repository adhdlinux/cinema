package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class zzfvk extends zzfvm {
    zzfvk(zzfrx zzfrx, boolean z2) {
        super(zzfrx, true);
        zzw();
    }

    public final /* bridge */ /* synthetic */ Object zzH(List list) {
        Object obj;
        ArrayList zza = zzfsq.zza(list.size());
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            zzfvl zzfvl = (zzfvl) it2.next();
            if (zzfvl != null) {
                obj = zzfvl.zza;
            } else {
                obj = null;
            }
            zza.add(obj);
        }
        return Collections.unmodifiableList(zza);
    }
}
