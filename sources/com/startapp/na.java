package com.startapp;

import java.util.Comparator;

public class na<T> implements Comparator<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Comparator<T> f34966a;

    /* renamed from: b  reason: collision with root package name */
    public final Comparator<T> f34967b;

    public na(Comparator<T> comparator, Comparator<T> comparator2) {
        this.f34966a = comparator;
        this.f34967b = comparator2;
    }

    public int compare(T t2, T t3) {
        int compare = this.f34966a.compare(t2, t3);
        if (compare == 0) {
            return this.f34967b.compare(t2, t3);
        }
        return compare;
    }
}
