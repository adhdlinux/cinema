package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

public interface DataFetcher<T> {

    public interface DataCallback<T> {
        void c(Exception exc);

        void f(T t2);
    }

    Class<T> a();

    void b();

    void cancel();

    DataSource d();

    void e(Priority priority, DataCallback<? super T> dataCallback);
}
