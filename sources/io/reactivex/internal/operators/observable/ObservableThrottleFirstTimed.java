package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableThrottleFirstTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final long f39635c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f39636d;

    /* renamed from: e  reason: collision with root package name */
    final Scheduler f39637e;

    static final class DebounceTimedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, Runnable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39638b;

        /* renamed from: c  reason: collision with root package name */
        final long f39639c;

        /* renamed from: d  reason: collision with root package name */
        final TimeUnit f39640d;

        /* renamed from: e  reason: collision with root package name */
        final Scheduler.Worker f39641e;

        /* renamed from: f  reason: collision with root package name */
        Disposable f39642f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f39643g;

        /* renamed from: h  reason: collision with root package name */
        boolean f39644h;

        DebounceTimedObserver(Observer<? super T> observer, long j2, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.f39638b = observer;
            this.f39639c = j2;
            this.f39640d = timeUnit;
            this.f39641e = worker;
        }

        public void dispose() {
            this.f39642f.dispose();
            this.f39641e.dispose();
        }

        public boolean isDisposed() {
            return this.f39641e.isDisposed();
        }

        public void onComplete() {
            if (!this.f39644h) {
                this.f39644h = true;
                this.f39638b.onComplete();
                this.f39641e.dispose();
            }
        }

        public void onError(Throwable th) {
            if (this.f39644h) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f39644h = true;
            this.f39638b.onError(th);
            this.f39641e.dispose();
        }

        public void onNext(T t2) {
            if (!this.f39643g && !this.f39644h) {
                this.f39643g = true;
                this.f39638b.onNext(t2);
                Disposable disposable = (Disposable) get();
                if (disposable != null) {
                    disposable.dispose();
                }
                DisposableHelper.c(this, this.f39641e.c(this, this.f39639c, this.f39640d));
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39642f, disposable)) {
                this.f39642f = disposable;
                this.f39638b.onSubscribe(this);
            }
        }

        public void run() {
            this.f39643g = false;
        }
    }

    public ObservableThrottleFirstTimed(ObservableSource<T> observableSource, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.f39635c = j2;
        this.f39636d = timeUnit;
        this.f39637e = scheduler;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new DebounceTimedObserver(new SerializedObserver(observer), this.f39635c, this.f39636d, this.f39637e.a()));
    }
}
