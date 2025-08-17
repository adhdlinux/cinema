package com.facebook.imagepipeline.memory;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
interface PoolBackend<T> {
    T get(int i2);

    int getSize(T t2);

    T pop();

    void put(T t2);
}
