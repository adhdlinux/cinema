package androidx.core.util;

import java.util.Locale;

public final class Preconditions {
    private Preconditions() {
    }

    public static void a(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int c(int i2, int i3, int i4, String str) {
        if (i2 < i3) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[]{str, Integer.valueOf(i3), Integer.valueOf(i4)}));
        } else if (i2 <= i4) {
            return i2;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[]{str, Integer.valueOf(i3), Integer.valueOf(i4)}));
        }
    }

    public static int d(int i2) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException();
    }

    public static int e(int i2, String str) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException(str);
    }

    public static int f(int i2, int i3) {
        if ((i2 & i3) == i2) {
            return i2;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i2) + ", but only 0x" + Integer.toHexString(i3) + " are allowed");
    }

    public static <T> T g(T t2) {
        t2.getClass();
        return t2;
    }

    public static <T> T h(T t2, Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void i(boolean z2, String str) {
        if (!z2) {
            throw new IllegalStateException(str);
        }
    }
}
