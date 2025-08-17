package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

final class zzfqh implements Iterator {
    final Iterator zza;
    Collection zzb;
    final /* synthetic */ zzfqi zzc;

    zzfqh(zzfqi zzfqi) {
        this.zzc = zzfqi;
        this.zza = zzfqi.zza.entrySet().iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        this.zzb = (Collection) entry.getValue();
        return this.zzc.zza(entry);
    }

    public final void remove() {
        boolean z2;
        if (this.zzb != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzfph.zzi(z2, "no calls to next() since the last call to remove()");
        this.zza.remove();
        zzfqv zzfqv = this.zzc.zzb;
        zzfqv.zzb = zzfqv.zzb - this.zzb.size();
        this.zzb.clear();
        this.zzb = null;
    }
}
