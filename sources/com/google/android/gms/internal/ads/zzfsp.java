package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

final class zzfsp extends AbstractSequentialList implements Serializable {
    final List zza;
    final zzfov zzb;

    zzfsp(List list, zzfov zzfov) {
        this.zza = list;
        this.zzb = zzfov;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final ListIterator listIterator(int i2) {
        return new zzfso(this, this.zza.listIterator(i2));
    }

    public final int size() {
        return this.zza.size();
    }
}
