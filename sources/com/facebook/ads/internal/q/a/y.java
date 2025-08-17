package com.facebook.ads.internal.q.a;

import java.lang.ref.WeakReference;

public abstract class y<T> implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<T> f20696a;

    public y(T t2) {
        this.f20696a = new WeakReference<>(t2);
    }

    public T a() {
        return this.f20696a.get();
    }
}
