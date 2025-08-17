package io.reactivex.internal.operators.single;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;

public final class SingleToObservable<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    final SingleSource<? extends T> f39917b;

    static final class SingleToObservableObserver<T> extends DeferredScalarDisposable<T> implements SingleObserver<T> {

        /* renamed from: d  reason: collision with root package name */
        Disposable f39918d;

        SingleToObservableObserver(Observer<? super T> observer) {
            super(observer);
        }

        public void dispose() {
            super.dispose();
            this.f39918d.dispose();
        }

        public void onError(Throwable th) {
            d(th);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39918d, disposable)) {
                this.f39918d = disposable;
                this.f38393b.onSubscribe(this);
            }
        }

        public void onSuccess(T t2) {
            c(t2);
        }
    }

    public SingleToObservable(SingleSource<? extends T> singleSource) {
        this.f39917b = singleSource;
    }

    public static <T> SingleObserver<T> b(Observer<? super T> observer) {
        return new SingleToObservableObserver(observer);
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f39917b.a(b(observer));
    }
}
