package com.startapp;

public abstract class jc<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile T f34768a;

    public abstract T a();

    public T b() {
        T t2 = this.f34768a;
        if (t2 == null) {
            synchronized (this) {
                t2 = this.f34768a;
                if (t2 == null) {
                    t2 = a();
                    this.f34768a = t2;
                }
            }
        }
        return t2;
    }
}
