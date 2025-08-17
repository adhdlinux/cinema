package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

final class zzfqk implements Iterator {
    Map.Entry zza;
    final /* synthetic */ Iterator zzb;
    final /* synthetic */ zzfql zzc;

    zzfqk(zzfql zzfql, Iterator it2) {
        this.zzc = zzfql;
        this.zzb = it2;
    }

    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    public final Object next() {
        Map.Entry entry = (Map.Entry) this.zzb.next();
        this.zza = entry;
        return entry.getKey();
    }

    public final void remove() {
        boolean z2;
        if (this.zza != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzfph.zzi(z2, "no calls to next() since the last call to remove()");
        Collection collection = (Collection) this.zza.getValue();
        this.zzb.remove();
        zzfqv zzfqv = this.zzc.zza;
        zzfqv.zzb = zzfqv.zzb - collection.size();
        collection.clear();
        this.zza = null;
    }
}
