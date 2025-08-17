package com.google.android.gms.internal.ads;

import java.util.Iterator;

final class zzfsj extends zzfqd {
    final /* synthetic */ Iterator zza;
    final /* synthetic */ zzfpi zzb;

    zzfsj(Iterator it2, zzfpi zzfpi) {
        this.zza = it2;
        this.zzb = zzfpi;
    }

    /* access modifiers changed from: protected */
    public final Object zza() {
        while (this.zza.hasNext()) {
            Object next = this.zza.next();
            if (this.zzb.zza(next)) {
                return next;
            }
        }
        zzb();
        return null;
    }
}
