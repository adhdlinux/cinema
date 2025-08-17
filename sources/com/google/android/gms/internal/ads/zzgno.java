package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzgno extends AbstractList implements zzgpv {
    private boolean zza;

    zzgno(boolean z2) {
        this.zza = z2;
    }

    public void add(int i2, Object obj) {
        zzbH();
        super.add(i2, obj);
    }

    public boolean addAll(int i2, Collection collection) {
        zzbH();
        return super.addAll(i2, collection);
    }

    public void clear() {
        zzbH();
        super.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (!get(i2).equals(list.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i2 = 1;
        for (int i3 = 0; i3 < size; i3++) {
            i2 = (i2 * 31) + get(i3).hashCode();
        }
        return i2;
    }

    public Object remove(int i2) {
        zzbH();
        return super.remove(i2);
    }

    public final boolean removeAll(Collection collection) {
        zzbH();
        return super.removeAll(collection);
    }

    public final boolean retainAll(Collection collection) {
        zzbH();
        return super.retainAll(collection);
    }

    public Object set(int i2, Object obj) {
        zzbH();
        return super.set(i2, obj);
    }

    public final void zzb() {
        if (this.zza) {
            this.zza = false;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzbH() {
        if (!this.zza) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean zzc() {
        return this.zza;
    }

    public boolean add(Object obj) {
        zzbH();
        return super.add(obj);
    }

    public boolean addAll(Collection collection) {
        zzbH();
        return super.addAll(collection);
    }

    public final boolean remove(Object obj) {
        zzbH();
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }
}
