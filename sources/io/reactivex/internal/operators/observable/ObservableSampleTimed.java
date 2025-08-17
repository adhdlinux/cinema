package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSampleTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final long f39437c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f39438d;

    /* renamed from: e  reason: collision with root package name */
    final Scheduler f39439e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f39440f;

    static final class SampleTimedEmitLast<T> extends SampleTimedObserver<T> {

        /* renamed from: h  reason: collision with root package name */
        final AtomicInteger f39441h = new AtomicInteger(1);

        SampleTimedEmitLast(Observer<? super T> observer, long j2, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, j2, timeUnit, scheduler);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            c();
            if (this.f39441h.decrementAndGet() == 0) {
                this.f39442b.onComplete();
            }
        }

        public void run() {
            if (this.f39441h.incrementAndGet() == 2) {
                c();
                if (this.f39441h.decrementAndGet() == 0) {
                    this.f39442b.onComplete();
                }
            }
        }
    }

    static final class SampleTimedNoLast<T> extends SampleTimedObserver<T> {
        SampleTimedNoLast(Observer<? super T> observer, long j2, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, j2, timeUnit, scheduler);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f39442b.onComplete();
        }

        public void run() {
            c();
        }
    }

    static abstract class SampleTimedObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable, Runnable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39442b;

        /* renamed from: c  reason: collision with root package name */
        final long f39443c;

        /* renamed from: d  reason: collision with root package name */
        final TimeUnit f39444d;

        /* renamed from: e  reason: collision with root package name */
        final Scheduler f39445e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<Disposable> f39446f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        Disposable f39447g;

        SampleTimedObserver(Observer<? super T> observer, long j2, TimeUnit timeUnit, Scheduler scheduler) {
            this.f39442b = observer;
            this.f39443c = j2;
            this.f39444d = timeUnit;
            this.f39445e = scheduler;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            DisposableHelper.a(this.f39446f);
        }

        /* access modifiers changed from: package-private */
        public abstract void b();

        /* access modifiers changed from: package-private */
        public void c() {
            Object andSet = getAndSet((Object) null);
            if (andSet != null) {
                this.f39442b.onNext(andSet);
            }
        }

        public void dispose() {
            a();
            this.f39447g.dispose();
        }

        public boolean isDisposed() {
            return this.f39447g.isDisposed();
        }

        public void onComplete() {
            a();
            b();
        }

        public void onError(Throwable th) {
            a();
            this.f39442b.onError(th);
        }

        public void onNext(T t2) {
            lazySet(t2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39447g, disposable)) {
                this.f39447g = disposable;
                this.f39442b.onSubscribe(this);
                Scheduler scheduler = this.f39445e;
                long j2 = this.f39443c;
                DisposableHelper.c(this.f39446f, scheduler.e(this, j2, j2, this.f39444d));
            }
        }
    }

    public ObservableSampleTimed(ObservableSource<T> observableSource, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z2) {
        super(observableSource);
        this.f39437c = j2;
        this.f39438d = timeUnit;
        this.f39439e = scheduler;
        this.f39440f = z2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        if (this.f39440f) {
            this.f38612b.subscribe(new SampleTimedEmitLast(serializedObserver, this.f39437c, this.f39438d, this.f39439e));
        } else {
            this.f38612b.subscribe(new SampleTimedNoLast(serializedObserver, this.f39437c, this.f39438d, this.f39439e));
        }
    }
}
