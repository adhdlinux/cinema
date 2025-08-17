package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableIntervalRange extends Observable<Long> {

    /* renamed from: b  reason: collision with root package name */
    final Scheduler f39190b;

    /* renamed from: c  reason: collision with root package name */
    final long f39191c;

    /* renamed from: d  reason: collision with root package name */
    final long f39192d;

    /* renamed from: e  reason: collision with root package name */
    final long f39193e;

    /* renamed from: f  reason: collision with root package name */
    final long f39194f;

    /* renamed from: g  reason: collision with root package name */
    final TimeUnit f39195g;

    static final class IntervalRangeObserver extends AtomicReference<Disposable> implements Disposable, Runnable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super Long> f39196b;

        /* renamed from: c  reason: collision with root package name */
        final long f39197c;

        /* renamed from: d  reason: collision with root package name */
        long f39198d;

        IntervalRangeObserver(Observer<? super Long> observer, long j2, long j3) {
            this.f39196b = observer;
            this.f39198d = j2;
            this.f39197c = j3;
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
            if (!isDisposed()) {
                long j2 = this.f39198d;
                this.f39196b.onNext(Long.valueOf(j2));
                if (j2 == this.f39197c) {
                    DisposableHelper.a(this);
                    this.f39196b.onComplete();
                    return;
                }
                this.f39198d = j2 + 1;
            }
        }
    }

    public ObservableIntervalRange(long j2, long j3, long j4, long j5, TimeUnit timeUnit, Scheduler scheduler) {
        this.f39193e = j4;
        this.f39194f = j5;
        this.f39195g = timeUnit;
        this.f39190b = scheduler;
        this.f39191c = j2;
        this.f39192d = j3;
    }

    public void subscribeActual(Observer<? super Long> observer) {
        IntervalRangeObserver intervalRangeObserver = new IntervalRangeObserver(observer, this.f39191c, this.f39192d);
        observer.onSubscribe(intervalRangeObserver);
        Scheduler scheduler = this.f39190b;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker a2 = scheduler.a();
            intervalRangeObserver.a(a2);
            a2.d(intervalRangeObserver, this.f39193e, this.f39194f, this.f39195g);
            return;
        }
        intervalRangeObserver.a(scheduler.e(intervalRangeObserver, this.f39193e, this.f39194f, this.f39195g));
    }
}
