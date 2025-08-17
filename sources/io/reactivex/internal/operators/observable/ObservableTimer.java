package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTimer extends Observable<Long> {

    /* renamed from: b  reason: collision with root package name */
    final Scheduler f39705b;

    /* renamed from: c  reason: collision with root package name */
    final long f39706c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f39707d;

    static final class TimerObserver extends AtomicReference<Disposable> implements Disposable, Runnable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super Long> f39708b;

        TimerObserver(Observer<? super Long> observer) {
            this.f39708b = observer;
        }

        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        public void dispose() {
            DisposableHelper.a(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void run() {
            if (!isDisposed()) {
                this.f39708b.onNext(0L);
                lazySet(EmptyDisposable.INSTANCE);
                this.f39708b.onComplete();
            }
        }
    }

    public ObservableTimer(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.f39706c = j2;
        this.f39707d = timeUnit;
        this.f39705b = scheduler;
    }

    public void subscribeActual(Observer<? super Long> observer) {
        TimerObserver timerObserver = new TimerObserver(observer);
        observer.onSubscribe(timerObserver);
        timerObserver.a(this.f39705b.d(timerObserver, this.f39706c, this.f39707d));
    }
}
