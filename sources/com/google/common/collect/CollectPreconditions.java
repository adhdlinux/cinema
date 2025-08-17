package com.google.common.collect;

import com.google.common.base.Preconditions;

final class CollectPreconditions {
    CollectPreconditions() {
    }

    static void a(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        } else if (obj2 == null) {
            throw new NullPointerException("null value in entry: " + obj + "=null");
        }
    }

    static int b(int i2, String str) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i2);
    }

    static void c(boolean z2) {
        Preconditions.r(z2, "no calls to next() since the last call to remove()");
    }
}
