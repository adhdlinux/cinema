package com.google.android.gms.internal.location;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class zzds extends zzdp implements List, RandomAccess {
    private static final zzdv zza = new zzdq(zzdt.zza, 0);

    zzds() {
    }

    static zzds zzi(Object[] objArr, int i2) {
        if (i2 == 0) {
            return zzdt.zza;
        }
        return new zzdt(objArr, i2);
    }

    public static zzds zzj(Collection collection) {
        if (collection instanceof zzdp) {
            zzds zzd = ((zzdp) collection).zzd();
            if (!zzd.zzf()) {
                return zzd;
            }
            Object[] array = zzd.toArray();
            return zzi(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        int i2 = 0;
        while (i2 < length) {
            if (array2[i2] != null) {
                i2++;
            } else {
                throw new NullPointerException("at index " + i2);
            }
        }
        return zzi(array2, length);
    }

    public static zzds zzk() {
        return zzdt.zza;
    }

    @Deprecated
    public final void add(int i2, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i2, Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    int i2 = 0;
                    while (i2 < size) {
                        if (zzdl.zza(get(i2), list.get(i2))) {
                            i2++;
                        }
                    }
                    return true;
                }
                Iterator it2 = iterator();
                Iterator it3 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it3.hasNext()) {
                            if (!zzdl.zza(it2.next(), it3.next())) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else if (!it3.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int size = size();
        int i2 = 1;
        for (int i3 = 0; i3 < size; i3++) {
            i2 = (i2 * 31) + get(i3).hashCode();
        }
        return i2;
    }

    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (obj.equals(get(i2))) {
                return i2;
            }
        }
        return -1;
    }

    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Deprecated
    public final Object remove(int i2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object set(int i2, Object obj) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            objArr[i3] = get(i3);
        }
        return size;
    }

    @Deprecated
    public final zzds zzd() {
        return this;
    }

    public final zzdu zze() {
        return listIterator(0);
    }

    /* renamed from: zzh */
    public zzds subList(int i2, int i3) {
        zzdm.zzc(i2, i3, size());
        int i4 = i3 - i2;
        if (i4 == size()) {
            return this;
        }
        if (i4 == 0) {
            return zzdt.zza;
        }
        return new zzdr(this, i2, i4);
    }

    /* renamed from: zzl */
    public final zzdv listIterator(int i2) {
        zzdm.zzb(i2, size(), "index");
        if (isEmpty()) {
            return zza;
        }
        return new zzdq(this, i2);
    }
}
