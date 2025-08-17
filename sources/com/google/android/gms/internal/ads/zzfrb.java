package com.google.android.gms.internal.ads;

import java.util.Collection;

public final class zzfrb {
    static boolean zza(Collection collection, Object obj) {
        collection.getClass();
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }
}
