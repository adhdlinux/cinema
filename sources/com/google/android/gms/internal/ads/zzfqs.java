package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

class zzfqs extends AbstractCollection {
    final Object zza;
    Collection zzb;
    final zzfqs zzc;
    final Collection zzd;
    final /* synthetic */ zzfqv zze;

    zzfqs(zzfqv zzfqv, Object obj, Collection collection, zzfqs zzfqs) {
        this.zze = zzfqv;
        this.zza = obj;
        this.zzb = collection;
        this.zzc = zzfqs;
        this.zzd = zzfqs == null ? null : zzfqs.zzb;
    }

    public final boolean add(Object obj) {
        zzb();
        boolean isEmpty = this.zzb.isEmpty();
        boolean add = this.zzb.add(obj);
        if (add) {
            zzfqv zzfqv = this.zze;
            zzfqv.zzb = zzfqv.zzb + 1;
            if (isEmpty) {
                zza();
                return true;
            }
        }
        return add;
    }

    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = this.zzb.addAll(collection);
        if (!addAll) {
            return addAll;
        }
        int size2 = this.zzb.size();
        zzfqv zzfqv = this.zze;
        zzfqv.zzb = zzfqv.zzb + (size2 - size);
        if (size != 0) {
            return addAll;
        }
        zza();
        return true;
    }

    public final void clear() {
        int size = size();
        if (size != 0) {
            this.zzb.clear();
            zzfqv zzfqv = this.zze;
            zzfqv.zzb = zzfqv.zzb - size;
            zzc();
        }
    }

    public final boolean contains(Object obj) {
        zzb();
        return this.zzb.contains(obj);
    }

    public final boolean containsAll(Collection collection) {
        zzb();
        return this.zzb.containsAll(collection);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        zzb();
        return this.zzb.equals(obj);
    }

    public final int hashCode() {
        zzb();
        return this.zzb.hashCode();
    }

    public final Iterator iterator() {
        zzb();
        return new zzfqr(this);
    }

    public final boolean remove(Object obj) {
        zzb();
        boolean remove = this.zzb.remove(obj);
        if (remove) {
            zzfqv zzfqv = this.zze;
            zzfqv.zzb = zzfqv.zzb - 1;
            zzc();
        }
        return remove;
    }

    public final boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean removeAll = this.zzb.removeAll(collection);
        if (removeAll) {
            int size2 = this.zzb.size();
            zzfqv zzfqv = this.zze;
            zzfqv.zzb = zzfqv.zzb + (size2 - size);
            zzc();
        }
        return removeAll;
    }

    public final boolean retainAll(Collection collection) {
        collection.getClass();
        int size = size();
        boolean retainAll = this.zzb.retainAll(collection);
        if (retainAll) {
            int size2 = this.zzb.size();
            zzfqv zzfqv = this.zze;
            zzfqv.zzb = zzfqv.zzb + (size2 - size);
            zzc();
        }
        return retainAll;
    }

    public final int size() {
        zzb();
        return this.zzb.size();
    }

    public final String toString() {
        zzb();
        return this.zzb.toString();
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        zzfqs zzfqs = this.zzc;
        if (zzfqs != null) {
            zzfqs.zza();
        } else {
            this.zze.zza.put(this.zza, this.zzb);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        Collection collection;
        zzfqs zzfqs = this.zzc;
        if (zzfqs != null) {
            zzfqs.zzb();
            if (this.zzc.zzb != this.zzd) {
                throw new ConcurrentModificationException();
            }
        } else if (this.zzb.isEmpty() && (collection = (Collection) this.zze.zza.get(this.zza)) != null) {
            this.zzb = collection;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        zzfqs zzfqs = this.zzc;
        if (zzfqs != null) {
            zzfqs.zzc();
        } else if (this.zzb.isEmpty()) {
            this.zze.zza.remove(this.zza);
        }
    }
}
