package com.bumptech.glide.load.data;

import java.io.IOException;

public interface DataRewinder<T> {

    public interface Factory<T> {
        Class<T> a();

        DataRewinder<T> b(T t2);
    }

    T a() throws IOException;

    void b();
}
