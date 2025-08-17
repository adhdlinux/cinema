package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;

public final class ObservableJust<T> extends Observable<T> implements ScalarCallable<T> {

    /* renamed from: b  reason: collision with root package name */
    private final T f39220b;

    public ObservableJust(T t2) {
        this.f39220b = t2;
    }

    public T call() {
        return this.f39220b;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(observer, this.f39220b);
        observer.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }
}
