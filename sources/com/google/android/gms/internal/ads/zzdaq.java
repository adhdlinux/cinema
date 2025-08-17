package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public class zzdaq {
    protected final Map zza = new HashMap();

    protected zzdaq(Set set) {
        zzo(set);
    }

    public final synchronized void zzj(zzdcm zzdcm) {
        zzm(zzdcm.zza, zzdcm.zzb);
    }

    public final synchronized void zzm(Object obj, Executor executor) {
        this.zza.put(obj, executor);
    }

    public final synchronized void zzo(Set set) {
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            zzj((zzdcm) it2.next());
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zzp(zzdap zzdap) {
        for (Map.Entry entry : this.zza.entrySet()) {
            ((Executor) entry.getValue()).execute(new zzdao(zzdap, entry.getKey()));
        }
    }
}
