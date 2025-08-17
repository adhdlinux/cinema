package io.reactivex.observables;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.operators.observable.ObservableRefCount;
import io.reactivex.plugins.RxJavaPlugins;

public abstract class ConnectableObservable<T> extends Observable<T> {
    public abstract void b(Consumer<? super Disposable> consumer);

    public Observable<T> c() {
        return RxJavaPlugins.n(new ObservableRefCount(this));
    }
}
