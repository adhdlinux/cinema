package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

class zzfqu extends zzfqs implements List {
    final /* synthetic */ zzfqv zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfqu(zzfqv zzfqv, Object obj, List list, zzfqs zzfqs) {
        super(zzfqv, obj, list, zzfqs);
        this.zzf = zzfqv;
    }

    public final void add(int i2, Object obj) {
        zzb();
        boolean isEmpty = this.zzb.isEmpty();
        ((List) this.zzb).add(i2, obj);
        zzfqv zzfqv = this.zzf;
        zzfqv.zzb = zzfqv.zzb + 1;
        if (isEmpty) {
            zza();
        }
    }

    public final boolean addAll(int i2, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = ((List) this.zzb).addAll(i2, collection);
        if (!addAll) {
            return addAll;
        }
        int size2 = this.zzb.size();
        zzfqv zzfqv = this.zzf;
        zzfqv.zzb = zzfqv.zzb + (size2 - size);
        if (size != 0) {
            return addAll;
        }
        zza();
        return true;
    }

    public final Object get(int i2) {
        zzb();
        return ((List) this.zzb).get(i2);
    }

    public final int indexOf(Object obj) {
        zzb();
        return ((List) this.zzb).indexOf(obj);
    }

    public final int lastIndexOf(Object obj) {
        zzb();
        return ((List) this.zzb).lastIndexOf(obj);
    }

    public final ListIterator listIterator() {
        zzb();
        return new zzfqt(this);
    }

    public final Object remove(int i2) {
        zzb();
        Object remove = ((List) this.zzb).remove(i2);
        zzfqv zzfqv = this.zzf;
        zzfqv.zzb = zzfqv.zzb - 1;
        zzc();
        return remove;
    }

    public final Object set(int i2, Object obj) {
        zzb();
        return ((List) this.zzb).set(i2, obj);
    }

    public final List subList(int i2, int i3) {
        zzb();
        zzfqv zzfqv = this.zzf;
        Object obj = this.zza;
        List subList = ((List) this.zzb).subList(i2, i3);
        zzfqs zzfqs = this.zzc;
        if (zzfqs == null) {
            zzfqs = this;
        }
        return zzfqv.zzh(obj, subList, zzfqs);
    }

    public final ListIterator listIterator(int i2) {
        zzb();
        return new zzfqt(this, i2);
    }
}
