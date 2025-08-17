package com.bumptech.glide.load.engine.bitmap_recycle;

interface ArrayAdapterInterface<T> {
    int a();

    int b(T t2);

    String getTag();

    T newArray(int i2);
}
