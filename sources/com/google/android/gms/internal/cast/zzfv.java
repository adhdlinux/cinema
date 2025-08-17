package com.google.android.gms.internal.cast;

import java.util.Set;

public final class zzfv {
    static int zza(Set set) {
        int i2;
        int i3 = 0;
        for (Object next : set) {
            if (next != null) {
                i2 = next.hashCode();
            } else {
                i2 = 0;
            }
            i3 += i2;
        }
        return i3;
    }
}
