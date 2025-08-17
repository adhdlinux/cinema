package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableHide<T> extends AbstractObservableWithUpstream<T, T> {

    static final class HideDisposable<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39151b;

        /* renamed from: c  reason: collision with root package name */
        Disposable f39152c;

        HideDisposable(Observer<? super T> observer) {
            this.f39151b = observer;
        }

        public void dispose() {
            this.f39152c.dispose();
        }

        public boolean isDisposed() {
            return this.f39152c.isDisposed();
        }

        public void onComplete() {
            this.f39151b.onComplete();
        }

        public void onError(Throwable th) {
            this.f39151b.onError(th);
        }

        public void onNext(T t2) {
            this.f39151b.onNext(t2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39152c, disposable)) {
                this.f39152c = disposable;
                this.f39151b.onSubscribe(this);
            }
        }
    }

    public ObservableHide(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new HideDisposable(observer));
    }
}
