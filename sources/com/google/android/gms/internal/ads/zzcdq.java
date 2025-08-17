package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzcdq {
    private final ArrayList zza = new ArrayList();
    private long zzb;

    zzcdq() {
    }

    /* access modifiers changed from: package-private */
    public final long zza() {
        Iterator it2 = this.zza.iterator();
        while (it2.hasNext()) {
            for (Map.Entry entry : ((zzgr) it2.next()).zze().entrySet()) {
                try {
                    if ("content-length".equalsIgnoreCase((String) entry.getKey())) {
                        this.zzb = Math.max(this.zzb, Long.parseLong((String) ((List) entry.getValue()).get(0)));
                    }
                } catch (RuntimeException unused) {
                }
            }
            it2.remove();
        }
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzgr zzgr) {
        this.zza.add(zzgr);
    }
}
