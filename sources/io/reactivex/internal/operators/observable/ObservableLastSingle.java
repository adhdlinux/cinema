package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

public final class ObservableLastSingle<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<T> f39225b;

    /* renamed from: c  reason: collision with root package name */
    final T f39226c;

    static final class LastObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final SingleObserver<? super T> f39227b;

        /* renamed from: c  reason: collision with root package name */
        final T f39228c;

        /* renamed from: d  reason: collision with root package name */
        Disposable f39229d;

        /* renamed from: e  reason: collision with root package name */
        T f39230e;

        LastObserver(SingleObserver<? super T> singleObserver, T t2) {
            this.f39227b = singleObserver;
            this.f39228c = t2;
        }

        public void dispose() {
            this.f39229d.dispose();
            this.f39229d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f39229d == DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            this.f39229d = DisposableHelper.DISPOSED;
            T t2 = this.f39230e;
            if (t2 != null) {
                this.f39230e = null;
                this.f39227b.onSuccess(t2);
                return;
            }
            T t3 = this.f39228c;
            if (t3 != null) {
                this.f39227b.onSuccess(t3);
            } else {
                this.f39227b.onError(new NoSuchElementException());
            }
        }

        public void onError(Throwable th) {
            this.f39229d = DisposableHelper.DISPOSED;
            this.f39230e = null;
            this.f39227b.onError(th);
        }

        public void onNext(T t2) {
            this.f39230e = t2;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39229d, disposable)) {
                this.f39229d = disposable;
                this.f39227b.onSubscribe(this);
            }
        }
    }

    public ObservableLastSingle(ObservableSource<T> observableSource, T t2) {
        this.f39225b = observableSource;
        this.f39226c = t2;
    }

    /* access modifiers changed from: protected */
    public void j(SingleObserver<? super T> singleObserver) {
        this.f39225b.subscribe(new LastObserver(singleObserver, this.f39226c));
    }
}
