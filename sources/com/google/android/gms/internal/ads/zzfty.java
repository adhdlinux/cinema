package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

public final class zzfty {
    static int zza(Set set) {
        int i2;
        int i3 = 0;
        for (Object next : set) {
            if (next != null) {
                i2 = next.hashCode();
            } else {
                i2 = 0;
            }
            i3 += i2;
        }
        return i3;
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [java.util.Collection, java.util.Set] */
    public static Set zzb(Set set, zzfpi zzfpi) {
        if (set instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) set;
            if (sortedSet instanceof zzftv) {
                zzftv zzftv = (zzftv) sortedSet;
                return new zzftw((SortedSet) zzftv.zza, zzfpl.zza(zzftv.zzb, zzfpi));
            }
            sortedSet.getClass();
            return new zzftw(sortedSet, zzfpi);
        } else if (set instanceof zzftv) {
            zzftv zzftv2 = (zzftv) set;
            return new zzftv(zzftv2.zza, zzfpl.zza(zzftv2.zzb, zzfpi));
        } else {
            set.getClass();
            return new zzftv(set, zzfpi);
        }
    }

    static boolean zzc(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() != set2.size() || !set.containsAll(set2)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    static boolean zzd(Set set, Collection collection) {
        collection.getClass();
        if (collection instanceof zzfti) {
            collection = ((zzfti) collection).zza();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return zze(set, collection.iterator());
        }
        Iterator it2 = set.iterator();
        boolean z2 = false;
        while (it2.hasNext()) {
            if (collection.contains(it2.next())) {
                it2.remove();
                z2 = true;
            }
        }
        return z2;
    }

    static boolean zze(Set set, Iterator it2) {
        boolean z2 = false;
        while (it2.hasNext()) {
            z2 |= set.remove(it2.next());
        }
        return z2;
    }
}
