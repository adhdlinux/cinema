package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableCountSingle<T> extends Single<Long> implements FuseToObservable<Long> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<T> f38871b;

    static final class CountObserver implements Observer<Object>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final SingleObserver<? super Long> f38872b;

        /* renamed from: c  reason: collision with root package name */
        Disposable f38873c;

        /* renamed from: d  reason: collision with root package name */
        long f38874d;

        CountObserver(SingleObserver<? super Long> singleObserver) {
            this.f38872b = singleObserver;
        }

        public void dispose() {
            this.f38873c.dispose();
            this.f38873c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f38873c.isDisposed();
        }

        public void onComplete() {
            this.f38873c = DisposableHelper.DISPOSED;
            this.f38872b.onSuccess(Long.valueOf(this.f38874d));
        }

        public void onError(Throwable th) {
            this.f38873c = DisposableHelper.DISPOSED;
            this.f38872b.onError(th);
        }

        public void onNext(Object obj) {
            this.f38874d++;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38873c, disposable)) {
                this.f38873c = disposable;
                this.f38872b.onSubscribe(this);
            }
        }
    }

    public ObservableCountSingle(ObservableSource<T> observableSource) {
        this.f38871b = observableSource;
    }

    public Observable<Long> b() {
        return RxJavaPlugins.n(new ObservableCount(this.f38871b));
    }

    public void j(SingleObserver<? super Long> singleObserver) {
        this.f38871b.subscribe(new CountObserver(singleObserver));
    }
}
