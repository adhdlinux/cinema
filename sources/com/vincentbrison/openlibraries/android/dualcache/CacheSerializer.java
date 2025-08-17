package com.vincentbrison.openlibraries.android.dualcache;

public interface CacheSerializer<T> {
    T a(String str);

    String b(T t2);
}
