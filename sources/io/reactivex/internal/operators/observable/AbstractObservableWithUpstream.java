package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

abstract class AbstractObservableWithUpstream<T, U> extends Observable<U> {

    /* renamed from: b  reason: collision with root package name */
    protected final ObservableSource<T> f38612b;

    AbstractObservableWithUpstream(ObservableSource<T> observableSource) {
        this.f38612b = observableSource;
    }
}
