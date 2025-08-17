package com.google.common.base;

import java.io.Serializable;

public abstract class Optional<T> implements Serializable {
    Optional() {
    }

    public static <T> Optional<T> a() {
        return Absent.d();
    }

    public abstract T b();

    public abstract boolean c();
}
