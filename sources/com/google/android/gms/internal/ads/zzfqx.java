package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

final class zzfqx extends AbstractCollection {
    final /* synthetic */ zzfqy zza;

    zzfqx(zzfqy zzfqy) {
        this.zza = zzfqy;
    }

    public final void clear() {
        this.zza.zzp();
    }

    public final boolean contains(Object obj) {
        for (Collection contains : this.zza.zzs().values()) {
            if (contains.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public final Iterator iterator() {
        return this.zza.zzg();
    }

    public final int size() {
        return this.zza.zze();
    }
}
