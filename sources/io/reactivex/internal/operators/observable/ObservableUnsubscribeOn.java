package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableUnsubscribeOn<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final Scheduler f39718c;

    static final class UnsubscribeObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39719b;

        /* renamed from: c  reason: collision with root package name */
        final Scheduler f39720c;

        /* renamed from: d  reason: collision with root package name */
        Disposable f39721d;

        final class DisposeTask implements Runnable {
            DisposeTask() {
            }

            public void run() {
                UnsubscribeObserver.this.f39721d.dispose();
            }
        }

        UnsubscribeObserver(Observer<? super T> observer, Scheduler scheduler) {
            this.f39719b = observer;
            this.f39720c = scheduler;
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f39720c.c(new DisposeTask());
            }
        }

        public boolean isDisposed() {
            return get();
        }

        public void onComplete() {
            if (!get()) {
                this.f39719b.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (get()) {
                RxJavaPlugins.s(th);
            } else {
                this.f39719b.onError(th);
            }
        }

        public void onNext(T t2) {
            if (!get()) {
                this.f39719b.onNext(t2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39721d, disposable)) {
                this.f39721d = disposable;
                this.f39719b.onSubscribe(this);
            }
        }
    }

    public ObservableUnsubscribeOn(ObservableSource<T> observableSource, Scheduler scheduler) {
        super(observableSource);
        this.f39718c = scheduler;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new UnsubscribeObserver(observer, this.f39718c));
    }
}
