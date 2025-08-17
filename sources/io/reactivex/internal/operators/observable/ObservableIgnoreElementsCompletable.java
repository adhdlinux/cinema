package io.reactivex.internal.operators.observable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableIgnoreElementsCompletable<T> extends Completable implements FuseToObservable<T> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<T> f39155b;

    static final class IgnoreObservable<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final CompletableObserver f39156b;

        /* renamed from: c  reason: collision with root package name */
        Disposable f39157c;

        IgnoreObservable(CompletableObserver completableObserver) {
            this.f39156b = completableObserver;
        }

        public void dispose() {
            this.f39157c.dispose();
        }

        public boolean isDisposed() {
            return this.f39157c.isDisposed();
        }

        public void onComplete() {
            this.f39156b.onComplete();
        }

        public void onError(Throwable th) {
            this.f39156b.onError(th);
        }

        public void onNext(T t2) {
        }

        public void onSubscribe(Disposable disposable) {
            this.f39157c = disposable;
            this.f39156b.onSubscribe(this);
        }
    }

    public ObservableIgnoreElementsCompletable(ObservableSource<T> observableSource) {
        this.f39155b = observableSource;
    }

    public Observable<T> b() {
        return RxJavaPlugins.n(new ObservableIgnoreElements(this.f39155b));
    }

    public void c(CompletableObserver completableObserver) {
        this.f39155b.subscribe(new IgnoreObservable(completableObserver));
    }
}
