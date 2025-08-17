package com.google.common.base;

public final class Preconditions {
    private Preconditions() {
    }

    private static String a(int i2, int i3, String str) {
        if (i2 < 0) {
            return Strings.b("%s (%s) must not be negative", str, Integer.valueOf(i2));
        } else if (i3 >= 0) {
            return Strings.b("%s (%s) must be less than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        } else {
            throw new IllegalArgumentException("negative size: " + i3);
        }
    }

    private static String b(int i2, int i3, String str) {
        if (i2 < 0) {
            return Strings.b("%s (%s) must not be negative", str, Integer.valueOf(i2));
        } else if (i3 >= 0) {
            return Strings.b("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        } else {
            throw new IllegalArgumentException("negative size: " + i3);
        }
    }

    private static String c(int i2, int i3, int i4) {
        if (i2 < 0 || i2 > i4) {
            return b(i2, i4, "start index");
        }
        if (i3 < 0 || i3 > i4) {
            return b(i3, i4, "end index");
        }
        return Strings.b("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2));
    }

    public static void d(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void f(boolean z2, String str, int i2, int i3) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.b(str, Integer.valueOf(i2), Integer.valueOf(i3)));
        }
    }

    public static void g(boolean z2, String str, long j2) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.b(str, Long.valueOf(j2)));
        }
    }

    public static void h(boolean z2, String str, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.b(str, obj));
        }
    }

    public static void i(boolean z2, String str, Object obj, Object obj2) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.b(str, obj, obj2));
        }
    }

    public static int j(int i2, int i3) {
        return k(i2, i3, "index");
    }

    public static int k(int i2, int i3, String str) {
        if (i2 >= 0 && i2 < i3) {
            return i2;
        }
        throw new IndexOutOfBoundsException(a(i2, i3, str));
    }

    public static <T> T l(T t2) {
        t2.getClass();
        return t2;
    }

    public static <T> T m(T t2, Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int n(int i2, int i3) {
        return o(i2, i3, "index");
    }

    public static int o(int i2, int i3, String str) {
        if (i2 >= 0 && i2 <= i3) {
            return i2;
        }
        throw new IndexOutOfBoundsException(b(i2, i3, str));
    }

    public static void p(int i2, int i3, int i4) {
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            throw new IndexOutOfBoundsException(c(i2, i3, i4));
        }
    }

    public static void q(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }

    public static void r(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void s(boolean z2, String str, Object obj) {
        if (!z2) {
            throw new IllegalStateException(Strings.b(str, obj));
        }
    }
}
