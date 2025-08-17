package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.media.MediaIntentReceiver;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class zzfh extends zzfd implements List, RandomAccess {
    private static final zzfy zza = new zzff(zzfo.zza, 0);
    public static final /* synthetic */ int zzd = 0;

    zzfh() {
    }

    static zzfh zzi(Object[] objArr, int i2) {
        if (i2 == 0) {
            return zzfo.zza;
        }
        return new zzfo(objArr, i2);
    }

    public static zzfh zzj(Collection collection) {
        if (collection instanceof zzfd) {
            zzfh zzd2 = ((zzfd) collection).zzd();
            if (!zzd2.zzf()) {
                return zzd2;
            }
            Object[] array = zzd2.toArray();
            return zzi(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        zzfn.zzb(array2, length);
        return zzi(array2, length);
    }

    public static zzfh zzk(Object obj, Object obj2) {
        Object[] objArr = {MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK, MediaIntentReceiver.ACTION_STOP_CASTING};
        zzfn.zzb(objArr, 2);
        return zzi(objArr, 2);
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
                        if (zzep.zza(get(i2), list.get(i2))) {
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
                            if (!zzep.zza(it2.next(), it3.next())) {
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
    public final zzfh zzd() {
        return this;
    }

    public final zzfx zze() {
        return listIterator(0);
    }

    /* renamed from: zzh */
    public zzfh subList(int i2, int i3) {
        zzeu.zzd(i2, i3, size());
        int i4 = i3 - i2;
        if (i4 == size()) {
            return this;
        }
        if (i4 == 0) {
            return zzfo.zza;
        }
        return new zzfg(this, i2, i4);
    }

    /* renamed from: zzl */
    public final zzfy listIterator(int i2) {
        zzeu.zzb(i2, size(), "index");
        if (isEmpty()) {
            return zza;
        }
        return new zzff(this, i2);
    }
}
