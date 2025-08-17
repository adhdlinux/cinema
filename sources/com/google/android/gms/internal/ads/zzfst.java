package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

abstract class zzfst extends zzftx {
    zzfst() {
    }

    public final void clear() {
        zza().clear();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object zza = zzfsx.zza(zza(), key);
        if (!zzfpc.zza(zza, entry.getValue())) {
            return false;
        }
        if (zza != null || zza().containsKey(key)) {
            return true;
        }
        return false;
    }

    public final boolean isEmpty() {
        return zza().isEmpty();
    }

    public boolean remove(Object obj) {
        if (!contains(obj) || !(obj instanceof Map.Entry)) {
            return false;
        }
        return zza().keySet().remove(((Map.Entry) obj).getKey());
    }

    public final boolean removeAll(Collection collection) {
        collection.getClass();
        try {
            return zzfty.zzd(this, collection);
        } catch (UnsupportedOperationException unused) {
            return zzfty.zze(this, collection.iterator());
        }
    }

    public final boolean retainAll(Collection collection) {
        int i2;
        collection.getClass();
        try {
            return super.retainAll(collection);
        } catch (UnsupportedOperationException unused) {
            int size = collection.size();
            if (size < 3) {
                zzfqz.zza(size, "expectedSize");
                i2 = size + 1;
            } else if (size < 1073741824) {
                i2 = (int) Math.ceil(((double) size) / 0.75d);
            } else {
                i2 = Integer.MAX_VALUE;
            }
            HashSet hashSet = new HashSet(i2);
            for (Object next : collection) {
                if (contains(next) && (next instanceof Map.Entry)) {
                    hashSet.add(((Map.Entry) next).getKey());
                }
            }
            return zza().keySet().retainAll(hashSet);
        }
    }

    public final int size() {
        return zza().size();
    }

    /* access modifiers changed from: package-private */
    public abstract Map zza();
}
