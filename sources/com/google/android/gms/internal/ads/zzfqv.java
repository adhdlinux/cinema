package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;

abstract class zzfqv extends zzfqy implements Serializable {
    /* access modifiers changed from: private */
    public final transient Map zza;
    /* access modifiers changed from: private */
    public transient int zzb;

    protected zzfqv(Map map) {
        zzfph.zze(map.isEmpty());
        this.zza = map;
    }

    static /* bridge */ /* synthetic */ void zzo(zzfqv zzfqv, Object obj) {
        Object obj2;
        try {
            obj2 = zzfqv.zza.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            obj2 = null;
        }
        Collection collection = (Collection) obj2;
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            zzfqv.zzb -= size;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract Collection zza();

    /* access modifiers changed from: package-private */
    public Collection zzb(Collection collection) {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public Collection zzc(Object obj, Collection collection) {
        throw null;
    }

    public final int zze() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final Collection zzf() {
        return new zzfqx(this);
    }

    /* access modifiers changed from: package-private */
    public final Iterator zzg() {
        return new zzfqf(this);
    }

    /* access modifiers changed from: package-private */
    public final List zzh(Object obj, List list, zzfqs zzfqs) {
        if (list instanceof RandomAccess) {
            return new zzfqo(this, obj, list, zzfqs);
        }
        return new zzfqu(this, obj, list, zzfqs);
    }

    /* access modifiers changed from: package-private */
    public Map zzj() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public final Map zzk() {
        Map map = this.zza;
        if (map instanceof NavigableMap) {
            return new zzfqm(this, (NavigableMap) map);
        }
        if (map instanceof SortedMap) {
            return new zzfqp(this, (SortedMap) map);
        }
        return new zzfqi(this, map);
    }

    /* access modifiers changed from: package-private */
    public Set zzl() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public final Set zzm() {
        Map map = this.zza;
        if (map instanceof NavigableMap) {
            return new zzfqn(this, (NavigableMap) map);
        }
        if (map instanceof SortedMap) {
            return new zzfqq(this, (SortedMap) map);
        }
        return new zzfql(this, map);
    }

    public final void zzp() {
        for (Collection clear : this.zza.values()) {
            clear.clear();
        }
        this.zza.clear();
        this.zzb = 0;
    }

    public final boolean zzq(Object obj, Object obj2) {
        Collection collection = (Collection) this.zza.get(obj);
        if (collection == null) {
            Collection zza2 = zza();
            if (zza2.add(obj2)) {
                this.zzb++;
                this.zza.put(obj, zza2);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(obj2)) {
            return false;
        } else {
            this.zzb++;
            return true;
        }
    }
}
