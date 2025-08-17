package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class zzfra extends AbstractCollection {
    final Collection zza;
    final zzfpi zzb;

    zzfra(Collection collection, zzfpi zzfpi) {
        this.zza = collection;
        this.zzb = zzfpi;
    }

    public final boolean add(Object obj) {
        zzfph.zze(this.zzb.zza(obj));
        return this.zza.add(obj);
    }

    public final boolean addAll(Collection collection) {
        for (Object zza2 : collection) {
            zzfph.zze(this.zzb.zza(zza2));
        }
        return this.zza.addAll(collection);
    }

    public final void clear() {
        zzfsi.zza(this.zza, this.zzb);
    }

    public final boolean contains(Object obj) {
        if (zzfrb.zza(this.zza, obj)) {
            return this.zzb.zza(obj);
        }
        return false;
    }

    public final boolean containsAll(Collection collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isEmpty() {
        Collection<Object> collection = this.zza;
        zzfpi zzfpi = this.zzb;
        zzfph.zzc(zzfpi, "predicate");
        int i2 = 0;
        for (Object zza2 : collection) {
            if (!zzfpi.zza(zza2)) {
                i2++;
            } else if (i2 != -1) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    public final Iterator iterator() {
        Iterator it2 = this.zza.iterator();
        zzfpi zzfpi = this.zzb;
        it2.getClass();
        zzfpi.getClass();
        return new zzfsj(it2, zzfpi);
    }

    public final boolean remove(Object obj) {
        return contains(obj) && this.zza.remove(obj);
    }

    public final boolean removeAll(Collection collection) {
        Iterator it2 = this.zza.iterator();
        boolean z2 = false;
        while (it2.hasNext()) {
            Object next = it2.next();
            if (this.zzb.zza(next) && collection.contains(next)) {
                it2.remove();
                z2 = true;
            }
        }
        return z2;
    }

    public final boolean retainAll(Collection collection) {
        Iterator it2 = this.zza.iterator();
        boolean z2 = false;
        while (it2.hasNext()) {
            Object next = it2.next();
            if (this.zzb.zza(next) && !collection.contains(next)) {
                it2.remove();
                z2 = true;
            }
        }
        return z2;
    }

    public final int size() {
        int i2 = 0;
        for (Object zza2 : this.zza) {
            if (this.zzb.zza(zza2)) {
                i2++;
            }
        }
        return i2;
    }

    public final Object[] toArray() {
        Iterator it2 = iterator();
        ArrayList arrayList = new ArrayList();
        zzfsm.zzc(arrayList, it2);
        return arrayList.toArray();
    }

    public final Object[] toArray(Object[] objArr) {
        Iterator it2 = iterator();
        ArrayList arrayList = new ArrayList();
        zzfsm.zzc(arrayList, it2);
        return arrayList.toArray(objArr);
    }
}
