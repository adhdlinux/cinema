package com.google.android.gms.internal.ads;

import java.util.Iterator;

final class zzgsk implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzgsl zzb;

    zzgsk(zzgsl zzgsl) {
        this.zzb = zzgsl;
        this.zza = zzgsl.zza.iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
