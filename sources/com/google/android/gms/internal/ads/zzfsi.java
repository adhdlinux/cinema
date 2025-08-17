package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public final class zzfsi {
    public static boolean zza(Iterable iterable, zzfpi zzfpi) {
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            Iterator it2 = iterable.iterator();
            zzfpi.getClass();
            boolean z2 = false;
            while (it2.hasNext()) {
                if (zzfpi.zza(it2.next())) {
                    it2.remove();
                    z2 = true;
                }
            }
            return z2;
        }
        zzfpi.getClass();
        return zzc((List) iterable, zzfpi);
    }

    private static void zzb(List list, zzfpi zzfpi, int i2, int i3) {
        int size = list.size();
        while (true) {
            size--;
            if (size <= i3) {
                break;
            } else if (zzfpi.zza(list.get(size))) {
                list.remove(size);
            }
        }
        while (true) {
            i3--;
            if (i3 >= i2) {
                list.remove(i3);
            } else {
                return;
            }
        }
    }

    private static boolean zzc(List list, zzfpi zzfpi) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < list.size()) {
            Object obj = list.get(i2);
            if (!zzfpi.zza(obj)) {
                if (i2 > i3) {
                    try {
                        list.set(i3, obj);
                    } catch (UnsupportedOperationException unused) {
                        zzb(list, zzfpi, i3, i2);
                        return true;
                    } catch (IllegalArgumentException unused2) {
                        zzb(list, zzfpi, i3, i2);
                        return true;
                    }
                }
                i3++;
            }
            i2++;
        }
        list.subList(i3, list.size()).clear();
        if (i2 != i3) {
            return true;
        }
        return false;
    }
}
