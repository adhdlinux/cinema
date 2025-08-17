package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.zzb;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@KeepForSdk
public final class Preconditions {
    private Preconditions() {
        throw new AssertionError("Uninstantiable");
    }

    @KeepForSdk
    public static void checkArgument(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    @KeepForSdk
    public static double checkArgumentInRange(double d2, double d3, double d4, String str) {
        if (d2 < d3) {
            throw new IllegalArgumentException(zza("%s is out of range of [%f, %f] (too low)", str, Double.valueOf(d3), Double.valueOf(d4)));
        } else if (d2 <= d4) {
            return d2;
        } else {
            throw new IllegalArgumentException(zza("%s is out of range of [%f, %f] (too high)", str, Double.valueOf(d3), Double.valueOf(d4)));
        }
    }

    @KeepForSdk
    public static void checkHandlerThread(Handler handler) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != handler.getLooper()) {
            String name = myLooper != null ? myLooper.getThread().getName() : "null current looper";
            String name2 = handler.getLooper().getThread().getName();
            throw new IllegalStateException("Must be called on " + name2 + " thread, but got " + name + ".");
        }
    }

    @KeepForSdk
    public static void checkMainThread() {
        checkMainThread("Must be called on the main application thread");
    }

    @KeepForSdk
    @EnsuresNonNull({"#1"})
    public static String checkNotEmpty(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Given String is empty or null");
    }

    @KeepForSdk
    public static void checkNotMainThread() {
        checkNotMainThread("Must not be called on the main application thread");
    }

    @KeepForSdk
    @EnsuresNonNull({"#1"})
    public static <T> T checkNotNull(T t2) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException("null reference");
    }

    @KeepForSdk
    public static int checkNotZero(int i2) {
        if (i2 != 0) {
            return i2;
        }
        throw new IllegalArgumentException("Given Integer is zero");
    }

    @KeepForSdk
    public static void checkState(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }

    static String zza(String str, Object... objArr) {
        int indexOf;
        StringBuilder sb = new StringBuilder(str.length() + 48);
        int i2 = 0;
        int i3 = 0;
        while (i2 < 3 && (indexOf = str.indexOf("%s", i3)) != -1) {
            sb.append(str.substring(i3, indexOf));
            sb.append(objArr[i2]);
            int i4 = i2 + 1;
            i3 = indexOf + 2;
            i2 = i4;
        }
        sb.append(str.substring(i3));
        if (i2 < 3) {
            sb.append(" [");
            sb.append(objArr[i2]);
            for (int i5 = i2 + 1; i5 < 3; i5++) {
                sb.append(", ");
                sb.append(objArr[i5]);
            }
            sb.append("]");
        }
        return sb.toString();
    }

    @KeepForSdk
    public static void checkArgument(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @KeepForSdk
    public static void checkMainThread(String str) {
        if (!zzb.zza()) {
            throw new IllegalStateException(str);
        }
    }

    @KeepForSdk
    public static void checkNotMainThread(String str) {
        if (zzb.zza()) {
            throw new IllegalStateException(str);
        }
    }

    @KeepForSdk
    @EnsuresNonNull({"#1"})
    public static <T> T checkNotNull(T t2, Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @KeepForSdk
    public static int checkNotZero(int i2, Object obj) {
        if (i2 != 0) {
            return i2;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @KeepForSdk
    public static void checkState(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    @KeepForSdk
    public static void checkArgument(boolean z2, String str, Object... objArr) {
        if (!z2) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    @KeepForSdk
    @EnsuresNonNull({"#1"})
    public static String checkNotEmpty(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @KeepForSdk
    public static long checkNotZero(long j2) {
        if (j2 != 0) {
            return j2;
        }
        throw new IllegalArgumentException("Given Long is zero");
    }

    @KeepForSdk
    public static void checkState(boolean z2, String str, Object... objArr) {
        if (!z2) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    @KeepForSdk
    public static float checkArgumentInRange(float f2, float f3, float f4, String str) {
        if (f2 < f3) {
            throw new IllegalArgumentException(zza("%s is out of range of [%f, %f] (too low)", str, Float.valueOf(f3), Float.valueOf(f4)));
        } else if (f2 <= f4) {
            return f2;
        } else {
            throw new IllegalArgumentException(zza("%s is out of range of [%f, %f] (too high)", str, Float.valueOf(f3), Float.valueOf(f4)));
        }
    }

    @KeepForSdk
    public static long checkNotZero(long j2, Object obj) {
        if (j2 != 0) {
            return j2;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @KeepForSdk
    public static void checkHandlerThread(Handler handler, String str) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException(str);
        }
    }

    @KeepForSdk
    public static int checkArgumentInRange(int i2, int i3, int i4, String str) {
        if (i2 < i3) {
            throw new IllegalArgumentException(zza("%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i3), Integer.valueOf(i4)));
        } else if (i2 <= i4) {
            return i2;
        } else {
            throw new IllegalArgumentException(zza("%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i3), Integer.valueOf(i4)));
        }
    }

    @KeepForSdk
    public static long checkArgumentInRange(long j2, long j3, long j4, String str) {
        if (j2 < j3) {
            throw new IllegalArgumentException(zza("%s is out of range of [%d, %d] (too low)", str, Long.valueOf(j3), Long.valueOf(j4)));
        } else if (j2 <= j4) {
            return j2;
        } else {
            throw new IllegalArgumentException(zza("%s is out of range of [%d, %d] (too high)", str, Long.valueOf(j3), Long.valueOf(j4)));
        }
    }
}
