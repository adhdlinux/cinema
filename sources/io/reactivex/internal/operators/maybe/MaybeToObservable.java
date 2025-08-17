package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;

public final class MaybeToObservable<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    final MaybeSource<T> f38522b;

    static final class MaybeToObservableObserver<T> extends DeferredScalarDisposable<T> implements MaybeObserver<T> {

        /* renamed from: d  reason: collision with root package name */
        Disposable f38523d;

        MaybeToObservableObserver(Observer<? super T> observer) {
            super(observer);
        }

        public void dispose() {
            super.dispose();
            this.f38523d.dispose();
        }

        public void onComplete() {
            a();
        }

        public void onError(Throwable th) {
            d(th);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38523d, disposable)) {
                this.f38523d = disposable;
                this.f38393b.onSubscribe(this);
            }
        }

        public void onSuccess(T t2) {
            c(t2);
        }
    }

    public static <T> MaybeObserver<T> b(Observer<? super T> observer) {
        return new MaybeToObservableObserver(observer);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.f38522b.a(b(observer));
    }
}
