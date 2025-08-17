package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableTakeLastOne<T> extends AbstractObservableWithUpstream<T, T> {

    static final class TakeLastOneObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39600b;

        /* renamed from: c  reason: collision with root package name */
        Disposable f39601c;

        /* renamed from: d  reason: collision with root package name */
        T f39602d;

        TakeLastOneObserver(Observer<? super T> observer) {
            this.f39600b = observer;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            T t2 = this.f39602d;
            if (t2 != null) {
                this.f39602d = null;
                this.f39600b.onNext(t2);
            }
            this.f39600b.onComplete();
        }

        public void dispose() {
            this.f39602d = null;
            this.f39601c.dispose();
        }

        public boolean isDisposed() {
            return this.f39601c.isDisposed();
        }

        public void onComplete() {
            a();
        }

        public void onError(Throwable th) {
            this.f39602d = null;
            this.f39600b.onError(th);
        }

        public void onNext(T t2) {
            this.f39602d = t2;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39601c, disposable)) {
                this.f39601c = disposable;
                this.f39600b.onSubscribe(this);
            }
        }
    }

    public ObservableTakeLastOne(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new TakeLastOneObserver(observer));
    }
}
