package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

class zzfqr implements Iterator {
    final Iterator zza;
    final Collection zzb;
    final /* synthetic */ zzfqs zzc;

    zzfqr(zzfqs zzfqs) {
        Iterator it2;
        this.zzc = zzfqs;
        Collection collection = zzfqs.zzb;
        this.zzb = collection;
        if (collection instanceof List) {
            it2 = ((List) collection).listIterator();
        } else {
            it2 = collection.iterator();
        }
        this.zza = it2;
    }

    zzfqr(zzfqs zzfqs, Iterator it2) {
        this.zzc = zzfqs;
        this.zzb = zzfqs.zzb;
        this.zza = it2;
    }

    public final boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    public final Object next() {
        zza();
        return this.zza.next();
    }

    public final void remove() {
        this.zza.remove();
        zzfqv zzfqv = this.zzc.zze;
        zzfqv.zzb = zzfqv.zzb - 1;
        this.zzc.zzc();
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzc.zzb();
        if (this.zzc.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }
}
