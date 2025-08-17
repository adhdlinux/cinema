package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public final class zzgvv extends AbstractList {
    private static final zzgvw zzc = zzgvw.zzb(zzgvv.class);
    final List zza;
    final Iterator zzb;

    public zzgvv(List list, Iterator it2) {
        this.zza = list;
        this.zzb = it2;
    }

    public final Object get(int i2) {
        if (this.zza.size() > i2) {
            return this.zza.get(i2);
        }
        if (this.zzb.hasNext()) {
            this.zza.add(this.zzb.next());
            return get(i2);
        }
        throw new NoSuchElementException();
    }

    public final Iterator iterator() {
        return new zzgvu(this);
    }

    public final int size() {
        zzgvw zzgvw = zzc;
        zzgvw.zza("potentially expensive size() call");
        zzgvw.zza("blowup running");
        while (this.zzb.hasNext()) {
            this.zza.add(this.zzb.next());
        }
        return this.zza.size();
    }
}
