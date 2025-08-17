package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleObserveOn<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    final SingleSource<T> f39906b;

    /* renamed from: c  reason: collision with root package name */
    final Scheduler f39907c;

    static final class ObserveOnSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {

        /* renamed from: b  reason: collision with root package name */
        final SingleObserver<? super T> f39908b;

        /* renamed from: c  reason: collision with root package name */
        final Scheduler f39909c;

        /* renamed from: d  reason: collision with root package name */
        T f39910d;

        /* renamed from: e  reason: collision with root package name */
        Throwable f39911e;

        ObserveOnSingleObserver(SingleObserver<? super T> singleObserver, Scheduler scheduler) {
            this.f39908b = singleObserver;
            this.f39909c = scheduler;
        }

        public void dispose() {
            DisposableHelper.a(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.b((Disposable) get());
        }

        public void onError(Throwable th) {
            this.f39911e = th;
            DisposableHelper.c(this, this.f39909c.c(this));
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.f(this, disposable)) {
                this.f39908b.onSubscribe(this);
            }
        }

        public void onSuccess(T t2) {
            this.f39910d = t2;
            DisposableHelper.c(this, this.f39909c.c(this));
        }

        public void run() {
            Throwable th = this.f39911e;
            if (th != null) {
                this.f39908b.onError(th);
            } else {
                this.f39908b.onSuccess(this.f39910d);
            }
        }
    }

    public SingleObserveOn(SingleSource<T> singleSource, Scheduler scheduler) {
        this.f39906b = singleSource;
        this.f39907c = scheduler;
    }

    /* access modifiers changed from: protected */
    public void j(SingleObserver<? super T> singleObserver) {
        this.f39906b.a(new ObserveOnSingleObserver(singleObserver, this.f39907c));
    }
}
