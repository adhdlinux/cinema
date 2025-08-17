package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableMaterialize<T> extends AbstractObservableWithUpstream<T, Notification<T>> {

    static final class MaterializeObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super Notification<T>> f39241b;

        /* renamed from: c  reason: collision with root package name */
        Disposable f39242c;

        MaterializeObserver(Observer<? super Notification<T>> observer) {
            this.f39241b = observer;
        }

        public void dispose() {
            this.f39242c.dispose();
        }

        public boolean isDisposed() {
            return this.f39242c.isDisposed();
        }

        public void onComplete() {
            this.f39241b.onNext(Notification.a());
            this.f39241b.onComplete();
        }

        public void onError(Throwable th) {
            this.f39241b.onNext(Notification.b(th));
            this.f39241b.onComplete();
        }

        public void onNext(T t2) {
            this.f39241b.onNext(Notification.c(t2));
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39242c, disposable)) {
                this.f39242c = disposable;
                this.f39241b.onSubscribe(this);
            }
        }
    }

    public ObservableMaterialize(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void subscribeActual(Observer<? super Notification<T>> observer) {
        this.f38612b.subscribe(new MaterializeObserver(observer));
    }
}
