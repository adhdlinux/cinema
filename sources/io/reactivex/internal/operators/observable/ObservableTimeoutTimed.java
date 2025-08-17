package io.reactivex.internal.operators.observable;

import com.facebook.common.time.Clock;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTimeoutTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final long f39683c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f39684d;

    /* renamed from: e  reason: collision with root package name */
    final Scheduler f39685e;

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<? extends T> f39686f;

    static final class FallbackObserver<T> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39687b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<Disposable> f39688c;

        FallbackObserver(Observer<? super T> observer, AtomicReference<Disposable> atomicReference) {
            this.f39687b = observer;
            this.f39688c = atomicReference;
        }

        public void onComplete() {
            this.f39687b.onComplete();
        }

        public void onError(Throwable th) {
            this.f39687b.onError(th);
        }

        public void onNext(T t2) {
            this.f39687b.onNext(t2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.c(this.f39688c, disposable);
        }
    }

    static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, TimeoutSupport {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39689b;

        /* renamed from: c  reason: collision with root package name */
        final long f39690c;

        /* renamed from: d  reason: collision with root package name */
        final TimeUnit f39691d;

        /* renamed from: e  reason: collision with root package name */
        final Scheduler.Worker f39692e;

        /* renamed from: f  reason: collision with root package name */
        final SequentialDisposable f39693f = new SequentialDisposable();

        /* renamed from: g  reason: collision with root package name */
        final AtomicLong f39694g = new AtomicLong();

        /* renamed from: h  reason: collision with root package name */
        final AtomicReference<Disposable> f39695h = new AtomicReference<>();

        /* renamed from: i  reason: collision with root package name */
        ObservableSource<? extends T> f39696i;

        TimeoutFallbackObserver(Observer<? super T> observer, long j2, TimeUnit timeUnit, Scheduler.Worker worker, ObservableSource<? extends T> observableSource) {
            this.f39689b = observer;
            this.f39690c = j2;
            this.f39691d = timeUnit;
            this.f39692e = worker;
            this.f39696i = observableSource;
        }

        public void b(long j2) {
            if (this.f39694g.compareAndSet(j2, Clock.MAX_TIME)) {
                DisposableHelper.a(this.f39695h);
                ObservableSource<? extends T> observableSource = this.f39696i;
                this.f39696i = null;
                observableSource.subscribe(new FallbackObserver(this.f39689b, this));
                this.f39692e.dispose();
            }
        }

        /* access modifiers changed from: package-private */
        public void c(long j2) {
            this.f39693f.a(this.f39692e.c(new TimeoutTask(j2, this), this.f39690c, this.f39691d));
        }

        public void dispose() {
            DisposableHelper.a(this.f39695h);
            DisposableHelper.a(this);
            this.f39692e.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.b((Disposable) get());
        }

        public void onComplete() {
            if (this.f39694g.getAndSet(Clock.MAX_TIME) != Clock.MAX_TIME) {
                this.f39693f.dispose();
                this.f39689b.onComplete();
                this.f39692e.dispose();
            }
        }

        public void onError(Throwable th) {
            if (this.f39694g.getAndSet(Clock.MAX_TIME) != Clock.MAX_TIME) {
                this.f39693f.dispose();
                this.f39689b.onError(th);
                this.f39692e.dispose();
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(T t2) {
            long j2 = this.f39694g.get();
            if (j2 != Clock.MAX_TIME) {
                long j3 = 1 + j2;
                if (this.f39694g.compareAndSet(j2, j3)) {
                    ((Disposable) this.f39693f.get()).dispose();
                    this.f39689b.onNext(t2);
                    c(j3);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.f(this.f39695h, disposable);
        }
    }

    static final class TimeoutObserver<T> extends AtomicLong implements Observer<T>, Disposable, TimeoutSupport {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39697b;

        /* renamed from: c  reason: collision with root package name */
        final long f39698c;

        /* renamed from: d  reason: collision with root package name */
        final TimeUnit f39699d;

        /* renamed from: e  reason: collision with root package name */
        final Scheduler.Worker f39700e;

        /* renamed from: f  reason: collision with root package name */
        final SequentialDisposable f39701f = new SequentialDisposable();

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<Disposable> f39702g = new AtomicReference<>();

        TimeoutObserver(Observer<? super T> observer, long j2, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.f39697b = observer;
            this.f39698c = j2;
            this.f39699d = timeUnit;
            this.f39700e = worker;
        }

        public void b(long j2) {
            if (compareAndSet(j2, Clock.MAX_TIME)) {
                DisposableHelper.a(this.f39702g);
                this.f39697b.onError(new TimeoutException(ExceptionHelper.c(this.f39698c, this.f39699d)));
                this.f39700e.dispose();
            }
        }

        /* access modifiers changed from: package-private */
        public void c(long j2) {
            this.f39701f.a(this.f39700e.c(new TimeoutTask(j2, this), this.f39698c, this.f39699d));
        }

        public void dispose() {
            DisposableHelper.a(this.f39702g);
            this.f39700e.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.b(this.f39702g.get());
        }

        public void onComplete() {
            if (getAndSet(Clock.MAX_TIME) != Clock.MAX_TIME) {
                this.f39701f.dispose();
                this.f39697b.onComplete();
                this.f39700e.dispose();
            }
        }

        public void onError(Throwable th) {
            if (getAndSet(Clock.MAX_TIME) != Clock.MAX_TIME) {
                this.f39701f.dispose();
                this.f39697b.onError(th);
                this.f39700e.dispose();
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(T t2) {
            long j2 = get();
            if (j2 != Clock.MAX_TIME) {
                long j3 = 1 + j2;
                if (compareAndSet(j2, j3)) {
                    ((Disposable) this.f39701f.get()).dispose();
                    this.f39697b.onNext(t2);
                    c(j3);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.f(this.f39702g, disposable);
        }
    }

    interface TimeoutSupport {
        void b(long j2);
    }

    static final class TimeoutTask implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final TimeoutSupport f39703b;

        /* renamed from: c  reason: collision with root package name */
        final long f39704c;

        TimeoutTask(long j2, TimeoutSupport timeoutSupport) {
            this.f39704c = j2;
            this.f39703b = timeoutSupport;
        }

        public void run() {
            this.f39703b.b(this.f39704c);
        }
    }

    public ObservableTimeoutTimed(Observable<T> observable, long j2, TimeUnit timeUnit, Scheduler scheduler, ObservableSource<? extends T> observableSource) {
        super(observable);
        this.f39683c = j2;
        this.f39684d = timeUnit;
        this.f39685e = scheduler;
        this.f39686f = observableSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        if (this.f39686f == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(observer, this.f39683c, this.f39684d, this.f39685e.a());
            observer.onSubscribe(timeoutObserver);
            timeoutObserver.c(0);
            this.f38612b.subscribe(timeoutObserver);
            return;
        }
        TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(observer, this.f39683c, this.f39684d, this.f39685e.a(), this.f39686f);
        observer.onSubscribe(timeoutFallbackObserver);
        timeoutFallbackObserver.c(0);
        this.f38612b.subscribe(timeoutFallbackObserver);
    }
}
