package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;

public final class ObservableFromUnsafeSource<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<T> f39091b;

    public ObservableFromUnsafeSource(ObservableSource<T> observableSource) {
        this.f39091b = observableSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.f39091b.subscribe(observer);
    }
}
