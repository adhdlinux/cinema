package io.reactivex.internal.functions;

import io.reactivex.functions.BiPredicate;

public final class ObjectHelper {

    /* renamed from: a  reason: collision with root package name */
    static final BiPredicate<Object, Object> f38375a = new BiObjectPredicate();

    static final class BiObjectPredicate implements BiPredicate<Object, Object> {
        BiObjectPredicate() {
        }

        public boolean test(Object obj, Object obj2) {
            return ObjectHelper.c(obj, obj2);
        }
    }

    private ObjectHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static int a(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }

    public static int b(long j2, long j3) {
        int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 > 0 ? 1 : 0;
    }

    public static boolean c(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <T> BiPredicate<T, T> d() {
        return f38375a;
    }

    public static <T> T e(T t2, String str) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(str);
    }

    public static int f(int i2, String str) {
        if (i2 > 0) {
            return i2;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i2);
    }

    public static long g(long j2, String str) {
        if (j2 > 0) {
            return j2;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + j2);
    }
}
