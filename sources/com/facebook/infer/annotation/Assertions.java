package com.facebook.infer.annotation;

import java.util.List;
import java.util.Map;

public class Assertions {
    public static void assertCondition(boolean z2) {
        if (!z2) {
            throw new AssertionError();
        }
    }

    public static <T> T assertGet(int i2, List<T> list) {
        assertCondition(i2 >= 0 && i2 < list.size(), "Index not in bound");
        return assertNotNull(list.get(i2), "Null value");
    }

    public static <T> T assertNotNull(T t2, String str) {
        if (t2 != null) {
            return t2;
        }
        throw new AssertionError(str);
    }

    public static AssertionError assertUnreachable() {
        throw new AssertionError();
    }

    public static void assumeCondition(boolean z2) {
    }

    public static void assumeCondition(boolean z2, String str) {
    }

    public static <T> T assumeNotNull(T t2) {
        return t2;
    }

    public static <T> T assumeNotNull(T t2, String str) {
        return t2;
    }

    public static <T> T nullsafeFIXME(T t2, String str) {
        return t2;
    }

    public static void assertCondition(boolean z2, String str) {
        if (!z2) {
            throw new AssertionError(str);
        }
    }

    public static <T> T assertNotNull(T t2) {
        if (t2 != null) {
            return t2;
        }
        throw new AssertionError();
    }

    public static AssertionError assertUnreachable(String str) {
        throw new AssertionError(str);
    }

    public static <K, V> V assertGet(K k2, Map<K, V> map) {
        assertCondition(map.containsKey(k2), "Key not found");
        return assertNotNull(map.get(k2), "Null value");
    }

    public static AssertionError assertUnreachable(Exception exc) {
        throw new AssertionError(exc);
    }
}
