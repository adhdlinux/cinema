package com.facebook.ads.internal.p.b;

final class j {
    static <T> T a(T t2) {
        t2.getClass();
        return t2;
    }

    static <T> T a(T t2, String str) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(str);
    }

    static void a(boolean z2, String str) {
        if (!z2) {
            throw new IllegalArgumentException(str);
        }
    }
}
