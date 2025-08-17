package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class zzfsc<E> extends zzfrx<E> implements List<E>, RandomAccess {
    private static final zzfud zza = new zzfsa(zzftm.zza, 0);
    public static final /* synthetic */ int zzd = 0;

    zzfsc() {
    }

    static zzfsc zzi(Object[] objArr, int i2) {
        if (i2 == 0) {
            return zzftm.zza;
        }
        return new zzftm(objArr, i2);
    }

    public static zzfsc zzj(Collection collection) {
        if (collection instanceof zzfrx) {
            zzfsc zzd2 = ((zzfrx) collection).zzd();
            if (!zzd2.zzf()) {
                return zzd2;
            }
            Object[] array = zzd2.toArray();
            return zzi(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        zzftk.zzb(array2, length);
        return zzi(array2, length);
    }

    public static zzfsc zzk(Object[] objArr) {
        if (objArr.length == 0) {
            return zzftm.zza;
        }
        Object[] objArr2 = (Object[]) objArr.clone();
        int length = objArr2.length;
        zzftk.zzb(objArr2, length);
        return zzi(objArr2, length);
    }

    public static zzfsc zzl() {
        return zzftm.zza;
    }

    public static zzfsc zzm(Object obj) {
        Object[] objArr = {obj};
        zzftk.zzb(objArr, 1);
        return zzi(objArr, 1);
    }

    public static zzfsc zzn(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        zzftk.zzb(objArr, 2);
        return zzi(objArr, 2);
    }

    public static zzfsc zzo(Object obj, Object obj2, Object obj3) {
        Object[] objArr = {obj, obj2, obj3};
        zzftk.zzb(objArr, 3);
        return zzi(objArr, 3);
    }

    public static zzfsc zzp(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        Object[] objArr = {obj, obj2, obj3, obj4, obj5};
        zzftk.zzb(objArr, 5);
        return zzi(objArr, 5);
    }

    public static zzfsc zzq(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        Object[] objArr = {"3010", "3008", "1005", "1009", "2011", "2007"};
        zzftk.zzb(objArr, 6);
        return zzi(objArr, 6);
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
                        if (zzfpc.zza(get(i2), list.get(i2))) {
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
                            if (!zzfpc.zza(it2.next(), it3.next())) {
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
            objArr[i2 + i3] = get(i3);
        }
        return i2 + size;
    }

    @Deprecated
    public final zzfsc zzd() {
        return this;
    }

    public final zzfuc zze() {
        return listIterator(0);
    }

    /* renamed from: zzh */
    public zzfsc subList(int i2, int i3) {
        zzfph.zzg(i2, i3, size());
        int i4 = i3 - i2;
        if (i4 == size()) {
            return this;
        }
        if (i4 == 0) {
            return zzftm.zza;
        }
        return new zzfsb(this, i2, i4);
    }

    /* renamed from: zzr */
    public final zzfud listIterator(int i2) {
        zzfph.zzb(i2, size(), "index");
        if (isEmpty()) {
            return zza;
        }
        return new zzfsa(this, i2);
    }
}
