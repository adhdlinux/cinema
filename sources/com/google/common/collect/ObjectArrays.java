package com.google.common.collect;

public final class ObjectArrays {
    private ObjectArrays() {
    }

    static Object a(Object obj, int i2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i2);
    }

    static Object[] b(Object... objArr) {
        c(objArr, objArr.length);
        return objArr;
    }

    static Object[] c(Object[] objArr, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            a(objArr[i3], i3);
        }
        return objArr;
    }

    public static <T> T[] d(T[] tArr, int i2) {
        return Platform.b(tArr, i2);
    }
}
