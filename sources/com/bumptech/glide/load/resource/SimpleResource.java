package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

public class SimpleResource<T> implements Resource<T> {

    /* renamed from: b  reason: collision with root package name */
    protected final T f16805b;

    public SimpleResource(T t2) {
        this.f16805b = Preconditions.d(t2);
    }

    public Class<T> a() {
        return this.f16805b.getClass();
    }

    public final T get() {
        return this.f16805b;
    }

    public final int getSize() {
        return 1;
    }

    public void recycle() {
    }
}
