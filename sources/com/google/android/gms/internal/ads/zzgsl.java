package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

@Deprecated
public final class zzgsl extends AbstractList implements RandomAccess, zzgqe {
    /* access modifiers changed from: private */
    public final zzgqe zza;

    public zzgsl(zzgqe zzgqe) {
        this.zza = zzgqe;
    }

    public final /* bridge */ /* synthetic */ Object get(int i2) {
        return ((zzgqd) this.zza).get(i2);
    }

    public final Iterator iterator() {
        return new zzgsk(this);
    }

    public final ListIterator listIterator(int i2) {
        return new zzgsj(this, i2);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzgqe zze() {
        return this;
    }

    public final Object zzf(int i2) {
        return this.zza.zzf(i2);
    }

    public final List zzh() {
        return this.zza.zzh();
    }

    public final void zzi(zzgoe zzgoe) {
        throw new UnsupportedOperationException();
    }
}
