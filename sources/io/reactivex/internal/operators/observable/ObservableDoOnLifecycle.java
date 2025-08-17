package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.DisposableLambdaObserver;

public final class ObservableDoOnLifecycle<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    private final Consumer<? super Disposable> f38963c;

    /* renamed from: d  reason: collision with root package name */
    private final Action f38964d;

    public ObservableDoOnLifecycle(Observable<T> observable, Consumer<? super Disposable> consumer, Action action) {
        super(observable);
        this.f38963c = consumer;
        this.f38964d = action;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new DisposableLambdaObserver(observer, this.f38963c, this.f38964d));
    }
}
