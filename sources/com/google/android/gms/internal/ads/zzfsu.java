package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

class zzfsu extends zzftx {
    final Map zzd;

    zzfsu(Map map) {
        map.getClass();
        this.zzd = map;
    }

    public void clear() {
        this.zzd.clear();
    }

    public final boolean contains(Object obj) {
        return this.zzd.containsKey(obj);
    }

    public final boolean isEmpty() {
        return this.zzd.isEmpty();
    }

    public Iterator iterator() {
        return new zzfsr(this.zzd.entrySet().iterator());
    }

    public boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        this.zzd.remove(obj);
        return true;
    }

    public final int size() {
        return this.zzd.size();
    }
}
