package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableLastMaybe<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<T> f39221b;

    static final class LastObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final MaybeObserver<? super T> f39222b;

        /* renamed from: c  reason: collision with root package name */
        Disposable f39223c;

        /* renamed from: d  reason: collision with root package name */
        T f39224d;

        LastObserver(MaybeObserver<? super T> maybeObserver) {
            this.f39222b = maybeObserver;
        }

        public void dispose() {
            this.f39223c.dispose();
            this.f39223c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f39223c == DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            this.f39223c = DisposableHelper.DISPOSED;
            T t2 = this.f39224d;
            if (t2 != null) {
                this.f39224d = null;
                this.f39222b.onSuccess(t2);
                return;
            }
            this.f39222b.onComplete();
        }

        public void onError(Throwable th) {
            this.f39223c = DisposableHelper.DISPOSED;
            this.f39224d = null;
            this.f39222b.onError(th);
        }

        public void onNext(T t2) {
            this.f39224d = t2;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39223c, disposable)) {
                this.f39223c = disposable;
                this.f39222b.onSubscribe(this);
            }
        }
    }

    public ObservableLastMaybe(ObservableSource<T> observableSource) {
        this.f39221b = observableSource;
    }

    /* access modifiers changed from: protected */
    public void f(MaybeObserver<? super T> maybeObserver) {
        this.f39221b.subscribe(new LastObserver(maybeObserver));
    }
}
