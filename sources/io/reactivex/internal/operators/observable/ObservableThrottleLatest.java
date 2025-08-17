package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableThrottleLatest<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final long f39645c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f39646d;

    /* renamed from: e  reason: collision with root package name */
    final Scheduler f39647e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f39648f;

    static final class ThrottleLatestObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39649b;

        /* renamed from: c  reason: collision with root package name */
        final long f39650c;

        /* renamed from: d  reason: collision with root package name */
        final TimeUnit f39651d;

        /* renamed from: e  reason: collision with root package name */
        final Scheduler.Worker f39652e;

        /* renamed from: f  reason: collision with root package name */
        final boolean f39653f;

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<T> f39654g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        Disposable f39655h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f39656i;

        /* renamed from: j  reason: collision with root package name */
        Throwable f39657j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f39658k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f39659l;

        /* renamed from: m  reason: collision with root package name */
        boolean f39660m;

        ThrottleLatestObserver(Observer<? super T> observer, long j2, TimeUnit timeUnit, Scheduler.Worker worker, boolean z2) {
            this.f39649b = observer;
            this.f39650c = j2;
            this.f39651d = timeUnit;
            this.f39652e = worker;
            this.f39653f = z2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            boolean z2;
            if (getAndIncrement() == 0) {
                AtomicReference<T> atomicReference = this.f39654g;
                Observer<? super T> observer = this.f39649b;
                int i2 = 1;
                while (!this.f39658k) {
                    boolean z3 = this.f39656i;
                    if (!z3 || this.f39657j == null) {
                        if (atomicReference.get() == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z3) {
                            T andSet = atomicReference.getAndSet((Object) null);
                            if (!z2 && this.f39653f) {
                                observer.onNext(andSet);
                            }
                            observer.onComplete();
                            this.f39652e.dispose();
                            return;
                        }
                        if (z2) {
                            if (this.f39659l) {
                                this.f39660m = false;
                                this.f39659l = false;
                            }
                        } else if (!this.f39660m || this.f39659l) {
                            observer.onNext(atomicReference.getAndSet((Object) null));
                            this.f39659l = false;
                            this.f39660m = true;
                            this.f39652e.c(this, this.f39650c, this.f39651d);
                        }
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        atomicReference.lazySet((Object) null);
                        observer.onError(this.f39657j);
                        this.f39652e.dispose();
                        return;
                    }
                }
                atomicReference.lazySet((Object) null);
            }
        }

        public void dispose() {
            this.f39658k = true;
            this.f39655h.dispose();
            this.f39652e.dispose();
            if (getAndIncrement() == 0) {
                this.f39654g.lazySet((Object) null);
            }
        }

        public boolean isDisposed() {
            return this.f39658k;
        }

        public void onComplete() {
            this.f39656i = true;
            a();
        }

        public void onError(Throwable th) {
            this.f39657j = th;
            this.f39656i = true;
            a();
        }

        public void onNext(T t2) {
            this.f39654g.set(t2);
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39655h, disposable)) {
                this.f39655h = disposable;
                this.f39649b.onSubscribe(this);
            }
        }

        public void run() {
            this.f39659l = true;
            a();
        }
    }

    public ObservableThrottleLatest(Observable<T> observable, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z2) {
        super(observable);
        this.f39645c = j2;
        this.f39646d = timeUnit;
        this.f39647e = scheduler;
        this.f39648f = z2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new ThrottleLatestObserver(observer, this.f39645c, this.f39646d, this.f39647e.a(), this.f39648f));
    }
}
