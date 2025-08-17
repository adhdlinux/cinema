package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableCount<T> extends AbstractObservableWithUpstream<T, Long> {

    static final class CountObserver implements Observer<Object>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super Long> f38868b;

        /* renamed from: c  reason: collision with root package name */
        Disposable f38869c;

        /* renamed from: d  reason: collision with root package name */
        long f38870d;

        CountObserver(Observer<? super Long> observer) {
            this.f38868b = observer;
        }

        public void dispose() {
            this.f38869c.dispose();
        }

        public boolean isDisposed() {
            return this.f38869c.isDisposed();
        }

        public void onComplete() {
            this.f38868b.onNext(Long.valueOf(this.f38870d));
            this.f38868b.onComplete();
        }

        public void onError(Throwable th) {
            this.f38868b.onError(th);
        }

        public void onNext(Object obj) {
            this.f38870d++;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38869c, disposable)) {
                this.f38869c = disposable;
                this.f38868b.onSubscribe(this);
            }
        }
    }

    public ObservableCount(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void subscribeActual(Observer<? super Long> observer) {
        this.f38612b.subscribe(new CountObserver(observer));
    }
}
