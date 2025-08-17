package com.google.android.gms.internal.cast;

import java.util.ListIterator;

final class zzuu implements ListIterator {
    final ListIterator zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzuw zzc;

    zzuu(zzuw zzuw, int i2) {
        this.zzc = zzuw;
        this.zzb = i2;
        this.zza = zzuw.zza.listIterator(i2);
    }

    public final /* synthetic */ void add(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zza.hasPrevious();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    public final int nextIndex() {
        return this.zza.nextIndex();
    }

    public final /* bridge */ /* synthetic */ Object previous() {
        return (String) this.zza.previous();
    }

    public final int previousIndex() {
        return this.zza.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }
}
