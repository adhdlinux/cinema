package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;

public final class zzfsm {
    static Object zza(Iterator it2) {
        if (!it2.hasNext()) {
            return null;
        }
        Object next = it2.next();
        it2.remove();
        return next;
    }

    static void zzb(Iterator it2) {
        while (it2.hasNext()) {
            it2.next();
            it2.remove();
        }
    }

    public static boolean zzc(Collection collection, Iterator it2) {
        boolean z2 = false;
        while (it2.hasNext()) {
            z2 |= collection.add(it2.next());
        }
        return z2;
    }
}
