package com.google.android.gms.internal.cast;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

@Deprecated
public final class zzuw extends AbstractList implements RandomAccess, zzsx {
    /* access modifiers changed from: private */
    public final zzsx zza;

    public zzuw(zzsx zzsx) {
        this.zza = zzsx;
    }

    public final /* bridge */ /* synthetic */ Object get(int i2) {
        return ((zzsw) this.zza).get(i2);
    }

    public final Iterator iterator() {
        return new zzuv(this);
    }

    public final ListIterator listIterator(int i2) {
        return new zzuu(this, i2);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzsx zzd() {
        return this;
    }

    public final Object zze(int i2) {
        return this.zza.zze(i2);
    }

    public final List zzh() {
        return this.zza.zzh();
    }
}
