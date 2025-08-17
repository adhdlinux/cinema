package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableSkip<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final long f39522c;

    static final class SkipObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39523b;

        /* renamed from: c  reason: collision with root package name */
        long f39524c;

        /* renamed from: d  reason: collision with root package name */
        Disposable f39525d;

        SkipObserver(Observer<? super T> observer, long j2) {
            this.f39523b = observer;
            this.f39524c = j2;
        }

        public void dispose() {
            this.f39525d.dispose();
        }

        public boolean isDisposed() {
            return this.f39525d.isDisposed();
        }

        public void onComplete() {
            this.f39523b.onComplete();
        }

        public void onError(Throwable th) {
            this.f39523b.onError(th);
        }

        public void onNext(T t2) {
            long j2 = this.f39524c;
            if (j2 != 0) {
                this.f39524c = j2 - 1;
            } else {
                this.f39523b.onNext(t2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39525d, disposable)) {
                this.f39525d = disposable;
                this.f39523b.onSubscribe(this);
            }
        }
    }

    public ObservableSkip(ObservableSource<T> observableSource, long j2) {
        super(observableSource);
        this.f39522c = j2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new SkipObserver(observer, this.f39522c));
    }
}
