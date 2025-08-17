package com.google.android.gms.internal.fido;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class zzat extends zzaq implements List, RandomAccess {
    private static final zzba zza = new zzar(zzaw.zza, 0);
    public static final /* synthetic */ int zzd = 0;

    zzat() {
    }

    static zzat zzg(Object[] objArr, int i2) {
        if (i2 == 0) {
            return zzaw.zza;
        }
        return new zzaw(objArr, i2);
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
                        if (zzal.zza(get(i2), list.get(i2))) {
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
                            if (!zzal.zza(it2.next(), it3.next())) {
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

    public final zzaz zzd() {
        return listIterator(0);
    }

    /* renamed from: zzf */
    public zzat subList(int i2, int i3) {
        zzam.zze(i2, i3, size());
        int i4 = i3 - i2;
        if (i4 == size()) {
            return this;
        }
        if (i4 == 0) {
            return zzaw.zza;
        }
        return new zzas(this, i2, i4);
    }

    /* renamed from: zzh */
    public final zzba listIterator(int i2) {
        zzam.zzb(i2, size(), "index");
        if (isEmpty()) {
            return zza;
        }
        return new zzar(this, i2);
    }
}
