package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public final class ObservableIgnoreElements<T> extends AbstractObservableWithUpstream<T, T> {

    static final class IgnoreObservable<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39153b;

        /* renamed from: c  reason: collision with root package name */
        Disposable f39154c;

        IgnoreObservable(Observer<? super T> observer) {
            this.f39153b = observer;
        }

        public void dispose() {
            this.f39154c.dispose();
        }

        public boolean isDisposed() {
            return this.f39154c.isDisposed();
        }

        public void onComplete() {
            this.f39153b.onComplete();
        }

        public void onError(Throwable th) {
            this.f39153b.onError(th);
        }

        public void onNext(T t2) {
        }

        public void onSubscribe(Disposable disposable) {
            this.f39154c = disposable;
            this.f39153b.onSubscribe(this);
        }
    }

    public ObservableIgnoreElements(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new IgnoreObservable(observer));
    }
}
