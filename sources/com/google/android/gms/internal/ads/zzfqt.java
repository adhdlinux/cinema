package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.ListIterator;

final class zzfqt extends zzfqr implements ListIterator {
    final /* synthetic */ zzfqu zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfqt(zzfqu zzfqu) {
        super(zzfqu);
        this.zzd = zzfqu;
    }

    public final void add(Object obj) {
        boolean isEmpty = this.zzd.isEmpty();
        zza();
        ((ListIterator) this.zza).add(obj);
        zzfqv zzfqv = this.zzd.zzf;
        zzfqv.zzb = zzfqv.zzb + 1;
        if (isEmpty) {
            this.zzd.zza();
        }
    }

    public final boolean hasPrevious() {
        zza();
        return ((ListIterator) this.zza).hasPrevious();
    }

    public final int nextIndex() {
        zza();
        return ((ListIterator) this.zza).nextIndex();
    }

    public final Object previous() {
        zza();
        return ((ListIterator) this.zza).previous();
    }

    public final int previousIndex() {
        zza();
        return ((ListIterator) this.zza).previousIndex();
    }

    public final void set(Object obj) {
        zza();
        ((ListIterator) this.zza).set(obj);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfqt(zzfqu zzfqu, int i2) {
        super(zzfqu, ((List) zzfqu.zzb).listIterator(i2));
        this.zzd = zzfqu;
    }
}
