package com.google.common.collect;

import java.util.Arrays;
import java.util.Map;

final class Platform {
    private Platform() {
    }

    static <T> T[] a(Object[] objArr, int i2, int i3, T[] tArr) {
        return Arrays.copyOfRange(objArr, i2, i3, tArr.getClass());
    }

    static <T> T[] b(T[] tArr, int i2) {
        if (tArr.length != 0) {
            tArr = Arrays.copyOf(tArr, 0);
        }
        return Arrays.copyOf(tArr, i2);
    }

    static <K, V> Map<K, V> c(int i2) {
        return CompactHashMap.x(i2);
    }

    static <K, V> Map<K, V> d() {
        return CompactHashMap.s();
    }
}
