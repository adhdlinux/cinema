package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

final class zzgvu implements Iterator {
    int zza = 0;
    final /* synthetic */ zzgvv zzb;

    zzgvu(zzgvv zzgvv) {
        this.zzb = zzgvv;
    }

    public final boolean hasNext() {
        return this.zza < this.zzb.zza.size() || this.zzb.zzb.hasNext();
    }

    public final Object next() {
        if (this.zza < this.zzb.zza.size()) {
            List list = this.zzb.zza;
            int i2 = this.zza;
            this.zza = i2 + 1;
            return list.get(i2);
        }
        zzgvv zzgvv = this.zzb;
        zzgvv.zza.add(zzgvv.zzb.next());
        return next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
