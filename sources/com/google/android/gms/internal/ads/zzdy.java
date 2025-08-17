package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;

public final class zzdy {
    @Pure
    public static int zza(int i2, int i3, int i4) {
        if (i2 >= 0 && i2 < i4) {
            return i2;
        }
        throw new IndexOutOfBoundsException();
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static Object zzb(Object obj) {
        if (obj != null) {
            return obj;
        }
        throw new IllegalStateException();
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static String zzc(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException();
    }

    @Pure
    public static void zzd(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    @Pure
    public static void zze(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException((String) obj);
        }
    }

    @Pure
    public static void zzf(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }
}
