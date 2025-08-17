package com.google.android.gms.internal.ads;

public final class zzftk {
    static Object zza(Object obj, int i2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i2);
    }

    static Object[] zzb(Object[] objArr, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            zza(objArr[i3], i3);
        }
        return objArr;
    }
}
