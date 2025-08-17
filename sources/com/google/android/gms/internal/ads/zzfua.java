package com.google.android.gms.internal.ads;

import java.util.Iterator;

abstract class zzfua implements Iterator {
    final Iterator zzb;

    zzfua(Iterator it2) {
        it2.getClass();
        this.zzb = it2;
    }

    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    public final Object next() {
        return zza(this.zzb.next());
    }

    public final void remove() {
        this.zzb.remove();
    }

    /* access modifiers changed from: package-private */
    public abstract Object zza(Object obj);
}
