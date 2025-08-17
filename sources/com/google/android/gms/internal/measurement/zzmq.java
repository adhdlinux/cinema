package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzmq extends AbstractList implements RandomAccess, zzkr {
    /* access modifiers changed from: private */
    public final zzkr zza;

    public zzmq(zzkr zzkr) {
        this.zza = zzkr;
    }

    public final /* bridge */ /* synthetic */ Object get(int i2) {
        return ((zzkq) this.zza).get(i2);
    }

    public final Iterator iterator() {
        return new zzmp(this);
    }

    public final ListIterator listIterator(int i2) {
        return new zzmo(this, i2);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzkr zze() {
        return this;
    }

    public final Object zzf(int i2) {
        return this.zza.zzf(i2);
    }

    public final List zzh() {
        return this.zza.zzh();
    }

    public final void zzi(zzjb zzjb) {
        throw new UnsupportedOperationException();
    }
}
