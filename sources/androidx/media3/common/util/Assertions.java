package androidx.media3.common.util;

import android.text.TextUtils;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;

public final class Assertions {
    private Assertions() {
    }

    @Pure
    public static void a(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    @Pure
    public static void b(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @Pure
    public static int c(int i2, int i3, int i4) {
        if (i2 >= i3 && i2 < i4) {
            return i2;
        }
        throw new IndexOutOfBoundsException();
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static String d(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException();
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static String e(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static <T> T f(T t2) {
        t2.getClass();
        return t2;
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static <T> T g(T t2, Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @Pure
    public static void h(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }

    @Pure
    public static void i(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static <T> T j(T t2) {
        if (t2 != null) {
            return t2;
        }
        throw new IllegalStateException();
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static <T> T k(T t2, Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new IllegalStateException(String.valueOf(obj));
    }
}
