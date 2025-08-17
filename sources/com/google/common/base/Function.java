package com.google.common.base;

public interface Function<F, T> {
    T apply(F f2);

    boolean equals(Object obj);
}
