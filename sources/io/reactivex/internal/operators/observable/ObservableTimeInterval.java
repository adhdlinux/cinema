package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.schedulers.Timed;
import java.util.concurrent.TimeUnit;

public final class ObservableTimeInterval<T> extends AbstractObservableWithUpstream<T, Timed<T>> {

    /* renamed from: c  reason: collision with root package name */
    final Scheduler f39661c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f39662d;

    static final class TimeIntervalObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super Timed<T>> f39663b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f39664c;

        /* renamed from: d  reason: collision with root package name */
        final Scheduler f39665d;

        /* renamed from: e  reason: collision with root package name */
        long f39666e;

        /* renamed from: f  reason: collision with root package name */
        Disposable f39667f;

        TimeIntervalObserver(Observer<? super Timed<T>> observer, TimeUnit timeUnit, Scheduler scheduler) {
            this.f39663b = observer;
            this.f39665d = scheduler;
            this.f39664c = timeUnit;
        }

        public void dispose() {
            this.f39667f.dispose();
        }

        public boolean isDisposed() {
            return this.f39667f.isDisposed();
        }

        public void onComplete() {
            this.f39663b.onComplete();
        }

        public void onError(Throwable th) {
            this.f39663b.onError(th);
        }

        public void onNext(T t2) {
            long b2 = this.f39665d.b(this.f39664c);
            long j2 = this.f39666e;
            this.f39666e = b2;
            this.f39663b.onNext(new Timed(t2, b2 - j2, this.f39664c));
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39667f, disposable)) {
                this.f39667f = disposable;
                this.f39666e = this.f39665d.b(this.f39664c);
                this.f39663b.onSubscribe(this);
            }
        }
    }

    public ObservableTimeInterval(ObservableSource<T> observableSource, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.f39661c = scheduler;
        this.f39662d = timeUnit;
    }

    public void subscribeActual(Observer<? super Timed<T>> observer) {
        this.f38612b.subscribe(new TimeIntervalObserver(observer, this.f39662d, this.f39661c));
    }
}
