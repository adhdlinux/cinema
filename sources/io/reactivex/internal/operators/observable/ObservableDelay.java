package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;

public final class ObservableDelay<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final long f38905c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f38906d;

    /* renamed from: e  reason: collision with root package name */
    final Scheduler f38907e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f38908f;

    static final class DelayObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f38909b;

        /* renamed from: c  reason: collision with root package name */
        final long f38910c;

        /* renamed from: d  reason: collision with root package name */
        final TimeUnit f38911d;

        /* renamed from: e  reason: collision with root package name */
        final Scheduler.Worker f38912e;

        /* renamed from: f  reason: collision with root package name */
        final boolean f38913f;

        /* renamed from: g  reason: collision with root package name */
        Disposable f38914g;

        final class OnComplete implements Runnable {
            OnComplete() {
            }

            public void run() {
                try {
                    DelayObserver.this.f38909b.onComplete();
                } finally {
                    DelayObserver.this.f38912e.dispose();
                }
            }
        }

        final class OnError implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            private final Throwable f38916b;

            OnError(Throwable th) {
                this.f38916b = th;
            }

            public void run() {
                try {
                    DelayObserver.this.f38909b.onError(this.f38916b);
                } finally {
                    DelayObserver.this.f38912e.dispose();
                }
            }
        }

        final class OnNext implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            private final T f38918b;

            OnNext(T t2) {
                this.f38918b = t2;
            }

            public void run() {
                DelayObserver.this.f38909b.onNext(this.f38918b);
            }
        }

        DelayObserver(Observer<? super T> observer, long j2, TimeUnit timeUnit, Scheduler.Worker worker, boolean z2) {
            this.f38909b = observer;
            this.f38910c = j2;
            this.f38911d = timeUnit;
            this.f38912e = worker;
            this.f38913f = z2;
        }

        public void dispose() {
            this.f38914g.dispose();
            this.f38912e.dispose();
        }

        public boolean isDisposed() {
            return this.f38912e.isDisposed();
        }

        public void onComplete() {
            this.f38912e.c(new OnComplete(), this.f38910c, this.f38911d);
        }

        public void onError(Throwable th) {
            this.f38912e.c(new OnError(th), this.f38913f ? this.f38910c : 0, this.f38911d);
        }

        public void onNext(T t2) {
            this.f38912e.c(new OnNext(t2), this.f38910c, this.f38911d);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38914g, disposable)) {
                this.f38914g = disposable;
                this.f38909b.onSubscribe(this);
            }
        }
    }

    public ObservableDelay(ObservableSource<T> observableSource, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z2) {
        super(observableSource);
        this.f38905c = j2;
        this.f38906d = timeUnit;
        this.f38907e = scheduler;
        this.f38908f = z2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver;
        if (this.f38908f) {
            serializedObserver = observer;
        } else {
            serializedObserver = new SerializedObserver(observer);
        }
        this.f38612b.subscribe(new DelayObserver(serializedObserver, this.f38905c, this.f38906d, this.f38907e.a(), this.f38908f));
    }
}
