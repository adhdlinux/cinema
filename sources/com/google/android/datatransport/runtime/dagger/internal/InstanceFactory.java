package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;

public final class InstanceFactory<T> implements Factory<T>, Lazy<T> {

    /* renamed from: b  reason: collision with root package name */
    private static final InstanceFactory<Object> f22566b = new InstanceFactory<>((Object) null);

    /* renamed from: a  reason: collision with root package name */
    private final T f22567a;

    private InstanceFactory(T t2) {
        this.f22567a = t2;
    }

    public static <T> Factory<T> a(T t2) {
        return new InstanceFactory(Preconditions.c(t2, "instance cannot be null"));
    }

    public T get() {
        return this.f22567a;
    }
}
