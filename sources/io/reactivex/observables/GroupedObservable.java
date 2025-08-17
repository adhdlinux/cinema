package io.reactivex.observables;

import io.reactivex.Observable;

public abstract class GroupedObservable<K, T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    final K f40079b;

    protected GroupedObservable(K k2) {
        this.f40079b = k2;
    }
}
