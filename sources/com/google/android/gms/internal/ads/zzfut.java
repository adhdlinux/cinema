package com.google.android.gms.internal.ads;

import sun.misc.Unsafe;

public final /* synthetic */ class zzfut {
    public static /* synthetic */ boolean zza(Unsafe unsafe, Object obj, long j2, Object obj2, Object obj3) {
        while (!m.a(unsafe, obj, j2, obj2, obj3)) {
            if (unsafe.getObject(obj, j2) != obj2) {
                return false;
            }
        }
        return true;
    }
}
