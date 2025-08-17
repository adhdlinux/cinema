package com.google.android.gms.internal.cast;

public final class zzeu {
    public static int zza(int i2, int i3, String str) {
        String str2;
        if (i2 >= 0 && i2 < i3) {
            return i2;
        }
        if (i2 < 0) {
            str2 = zzew.zzb("%s (%s) must not be negative", "index", Integer.valueOf(i2));
        } else if (i3 < 0) {
            throw new IllegalArgumentException("negative size: " + i3);
        } else {
            str2 = zzew.zzb("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        throw new IndexOutOfBoundsException(str2);
    }

    public static int zzb(int i2, int i3, String str) {
        if (i2 >= 0 && i2 <= i3) {
            return i2;
        }
        throw new IndexOutOfBoundsException(zze(i2, i3, "index"));
    }

    public static Object zzc(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException((String) obj2);
    }

    public static void zzd(int i2, int i3, int i4) {
        String str;
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            if (i2 < 0 || i2 > i4) {
                str = zze(i2, i4, "start index");
            } else if (i3 < 0 || i3 > i4) {
                str = zze(i3, i4, "end index");
            } else {
                str = zzew.zzb("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }

    private static String zze(int i2, int i3, String str) {
        if (i2 < 0) {
            return zzew.zzb("%s (%s) must not be negative", str, Integer.valueOf(i2));
        } else if (i3 >= 0) {
            return zzew.zzb("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        } else {
            throw new IllegalArgumentException("negative size: " + i3);
        }
    }
}
