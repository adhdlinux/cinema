package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableInterval extends Observable<Long> {

    /* renamed from: b  reason: collision with root package name */
    final Scheduler f39184b;

    /* renamed from: c  reason: collision with root package name */
    final long f39185c;

    /* renamed from: d  reason: collision with root package name */
    final long f39186d;

    /* renamed from: e  reason: collision with root package name */
    final TimeUnit f39187e;

    static final class IntervalObserver extends AtomicReference<Disposable> implements Disposable, Runnable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super Long> f39188b;

        /* renamed from: c  reason: collision with root package name */
        long f39189c;

        IntervalObserver(Observer<? super Long> observer) {
            this.f39188b = observer;
        }

        public void a(Disposable disposable) {
            DisposableHelper.f(this, disposable);
        }

        public void dispose() {
            DisposableHelper.a(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void run() {
            if (get() != DisposableHelper.DISPOSED) {
                Observer<? super Long> observer = this.f39188b;
                long j2 = this.f39189c;
                this.f39189c = 1 + j2;
                observer.onNext(Long.valueOf(j2));
            }
        }
    }

    public ObservableInterval(long j2, long j3, TimeUnit timeUnit, Scheduler scheduler) {
        this.f39185c = j2;
        this.f39186d = j3;
        this.f39187e = timeUnit;
        this.f39184b = scheduler;
    }

    public void subscribeActual(Observer<? super Long> observer) {
        IntervalObserver intervalObserver = new IntervalObserver(observer);
        observer.onSubscribe(intervalObserver);
        Scheduler scheduler = this.f39184b;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker a2 = scheduler.a();
            intervalObserver.a(a2);
            a2.d(intervalObserver, this.f39185c, this.f39186d, this.f39187e);
            return;
        }
        intervalObserver.a(scheduler.e(intervalObserver, this.f39185c, this.f39186d, this.f39187e));
    }
}
