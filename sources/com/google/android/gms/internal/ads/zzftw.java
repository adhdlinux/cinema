package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

final class zzftw extends zzftv implements SortedSet {
    zzftw(SortedSet sortedSet, zzfpi zzfpi) {
        super(sortedSet, zzfpi);
    }

    public final Comparator comparator() {
        return ((SortedSet) this.zza).comparator();
    }

    public final Object first() {
        Iterator it2 = this.zza.iterator();
        zzfpi zzfpi = this.zzb;
        it2.getClass();
        zzfpi.getClass();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (zzfpi.zza(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    public final SortedSet headSet(Object obj) {
        return new zzftw(((SortedSet) this.zza).headSet(obj), this.zzb);
    }

    public final Object last() {
        SortedSet sortedSet = (SortedSet) this.zza;
        while (true) {
            Object last = sortedSet.last();
            if (this.zzb.zza(last)) {
                return last;
            }
            sortedSet = sortedSet.headSet(last);
        }
    }

    public final SortedSet subSet(Object obj, Object obj2) {
        return new zzftw(((SortedSet) this.zza).subSet(obj, obj2), this.zzb);
    }

    public final SortedSet tailSet(Object obj) {
        return new zzftw(((SortedSet) this.zza).tailSet(obj), this.zzb);
    }
}
