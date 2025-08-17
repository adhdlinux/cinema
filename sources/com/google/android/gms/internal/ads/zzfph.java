package com.google.android.gms.internal.ads;

public final class zzfph {
    public static int zza(int i2, int i3, String str) {
        String str2;
        if (i2 >= 0 && i2 < i3) {
            return i2;
        }
        if (i2 < 0) {
            str2 = zzfpw.zzb("%s (%s) must not be negative", "index", Integer.valueOf(i2));
        } else if (i3 < 0) {
            throw new IllegalArgumentException("negative size: " + i3);
        } else {
            str2 = zzfpw.zzb("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        throw new IndexOutOfBoundsException(str2);
    }

    public static int zzb(int i2, int i3, String str) {
        if (i2 >= 0 && i2 <= i3) {
            return i2;
        }
        throw new IndexOutOfBoundsException(zzj(i2, i3, "index"));
    }

    public static Object zzc(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException((String) obj2);
    }

    public static Object zzd(Object obj, String str, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(zzfpw.zzb(str, obj2));
    }

    public static void zze(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    public static void zzf(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException((String) obj);
        }
    }

    public static void zzg(int i2, int i3, int i4) {
        String str;
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            if (i2 < 0 || i2 > i4) {
                str = zzj(i2, i4, "start index");
            } else if (i3 < 0 || i3 > i4) {
                str = zzj(i3, i4, "end index");
            } else {
                str = zzfpw.zzb("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }

    public static void zzh(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }

    public static void zzi(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalStateException((String) obj);
        }
    }

    private static String zzj(int i2, int i3, String str) {
        if (i2 < 0) {
            return zzfpw.zzb("%s (%s) must not be negative", str, Integer.valueOf(i2));
        } else if (i3 >= 0) {
            return zzfpw.zzb("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        } else {
            throw new IllegalArgumentException("negative size: " + i3);
        }
    }
}
