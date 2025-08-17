package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleSubscribeOn<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    final SingleSource<? extends T> f39912b;

    /* renamed from: c  reason: collision with root package name */
    final Scheduler f39913c;

    static final class SubscribeOnObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {

        /* renamed from: b  reason: collision with root package name */
        final SingleObserver<? super T> f39914b;

        /* renamed from: c  reason: collision with root package name */
        final SequentialDisposable f39915c = new SequentialDisposable();

        /* renamed from: d  reason: collision with root package name */
        final SingleSource<? extends T> f39916d;

        SubscribeOnObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource) {
            this.f39914b = singleObserver;
            this.f39916d = singleSource;
        }

        public void dispose() {
            DisposableHelper.a(this);
            this.f39915c.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.b((Disposable) get());
        }

        public void onError(Throwable th) {
            this.f39914b.onError(th);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.f(this, disposable);
        }

        public void onSuccess(T t2) {
            this.f39914b.onSuccess(t2);
        }

        public void run() {
            this.f39916d.a(this);
        }
    }

    public SingleSubscribeOn(SingleSource<? extends T> singleSource, Scheduler scheduler) {
        this.f39912b = singleSource;
        this.f39913c = scheduler;
    }

    /* access modifiers changed from: protected */
    public void j(SingleObserver<? super T> singleObserver) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(singleObserver, this.f39912b);
        singleObserver.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.f39915c.a(this.f39913c.c(subscribeOnObserver));
    }
}
