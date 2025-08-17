package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

class zzfqi extends zzfsw {
    final transient Map zza;
    final /* synthetic */ zzfqv zzb;

    zzfqi(zzfqv zzfqv, Map map) {
        this.zzb = zzfqv;
        this.zza = map;
    }

    public final void clear() {
        Map map = this.zza;
        zzfqv zzfqv = this.zzb;
        if (map == zzfqv.zza) {
            zzfqv.zzp();
        } else {
            zzfsm.zzb(new zzfqh(this));
        }
    }

    public final boolean containsKey(Object obj) {
        Map map = this.zza;
        map.getClass();
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public final boolean equals(Object obj) {
        return this == obj || this.zza.equals(obj);
    }

    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        Collection collection = (Collection) zzfsx.zza(this.zza, obj);
        if (collection == null) {
            return null;
        }
        return this.zzb.zzc(obj, collection);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public Set keySet() {
        return this.zzb.zzt();
    }

    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        Collection collection = (Collection) this.zza.remove(obj);
        if (collection == null) {
            return null;
        }
        Collection zza2 = this.zzb.zza();
        zza2.addAll(collection);
        zzfqv zzfqv = this.zzb;
        zzfqv.zzb = zzfqv.zzb - collection.size();
        collection.clear();
        return zza2;
    }

    public final int size() {
        return this.zza.size();
    }

    public final String toString() {
        return this.zza.toString();
    }

    /* access modifiers changed from: package-private */
    public final Map.Entry zza(Map.Entry entry) {
        Object key = entry.getKey();
        return new zzfry(key, this.zzb.zzc(key, (Collection) entry.getValue()));
    }

    /* access modifiers changed from: protected */
    public final Set zzb() {
        return new zzfqg(this);
    }
}
