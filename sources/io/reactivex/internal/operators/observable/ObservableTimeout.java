package io.reactivex.internal.operators.observable;

import com.facebook.common.time.Clock;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTimeout<T, U, V> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final ObservableSource<U> f39668c;

    /* renamed from: d  reason: collision with root package name */
    final Function<? super T, ? extends ObservableSource<V>> f39669d;

    /* renamed from: e  reason: collision with root package name */
    final ObservableSource<? extends T> f39670e;

    static final class TimeoutConsumer extends AtomicReference<Disposable> implements Observer<Object>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final TimeoutSelectorSupport f39671b;

        /* renamed from: c  reason: collision with root package name */
        final long f39672c;

        TimeoutConsumer(long j2, TimeoutSelectorSupport timeoutSelectorSupport) {
            this.f39672c = j2;
            this.f39671b = timeoutSelectorSupport;
        }

        public void dispose() {
            DisposableHelper.a(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.b((Disposable) get());
        }

        public void onComplete() {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.f39671b.b(this.f39672c);
            }
        }

        public void onError(Throwable th) {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.f39671b.a(this.f39672c, th);
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(Object obj) {
            Disposable disposable = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                disposable.dispose();
                lazySet(disposableHelper);
                this.f39671b.b(this.f39672c);
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.f(this, disposable);
        }
    }

    static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, TimeoutSelectorSupport {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39673b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super T, ? extends ObservableSource<?>> f39674c;

        /* renamed from: d  reason: collision with root package name */
        final SequentialDisposable f39675d = new SequentialDisposable();

        /* renamed from: e  reason: collision with root package name */
        final AtomicLong f39676e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<Disposable> f39677f;

        /* renamed from: g  reason: collision with root package name */
        ObservableSource<? extends T> f39678g;

        TimeoutFallbackObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<?>> function, ObservableSource<? extends T> observableSource) {
            this.f39673b = observer;
            this.f39674c = function;
            this.f39678g = observableSource;
            this.f39676e = new AtomicLong();
            this.f39677f = new AtomicReference<>();
        }

        public void a(long j2, Throwable th) {
            if (this.f39676e.compareAndSet(j2, Clock.MAX_TIME)) {
                DisposableHelper.a(this);
                this.f39673b.onError(th);
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void b(long j2) {
            if (this.f39676e.compareAndSet(j2, Clock.MAX_TIME)) {
                DisposableHelper.a(this.f39677f);
                ObservableSource<? extends T> observableSource = this.f39678g;
                this.f39678g = null;
                observableSource.subscribe(new ObservableTimeoutTimed.FallbackObserver(this.f39673b, this));
            }
        }

        /* access modifiers changed from: package-private */
        public void c(ObservableSource<?> observableSource) {
            if (observableSource != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0, this);
                if (this.f39675d.a(timeoutConsumer)) {
                    observableSource.subscribe(timeoutConsumer);
                }
            }
        }

        public void dispose() {
            DisposableHelper.a(this.f39677f);
            DisposableHelper.a(this);
            this.f39675d.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.b((Disposable) get());
        }

        public void onComplete() {
            if (this.f39676e.getAndSet(Clock.MAX_TIME) != Clock.MAX_TIME) {
                this.f39675d.dispose();
                this.f39673b.onComplete();
                this.f39675d.dispose();
            }
        }

        public void onError(Throwable th) {
            if (this.f39676e.getAndSet(Clock.MAX_TIME) != Clock.MAX_TIME) {
                this.f39675d.dispose();
                this.f39673b.onError(th);
                this.f39675d.dispose();
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(T t2) {
            long j2 = this.f39676e.get();
            if (j2 != Clock.MAX_TIME) {
                long j3 = 1 + j2;
                if (this.f39676e.compareAndSet(j2, j3)) {
                    Disposable disposable = (Disposable) this.f39675d.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.f39673b.onNext(t2);
                    try {
                        ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f39674c.apply(t2), "The itemTimeoutIndicator returned a null ObservableSource.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j3, this);
                        if (this.f39675d.a(timeoutConsumer)) {
                            observableSource.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f39677f.get().dispose();
                        this.f39676e.getAndSet(Clock.MAX_TIME);
                        this.f39673b.onError(th);
                    }
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.f(this.f39677f, disposable);
        }
    }

    static final class TimeoutObserver<T> extends AtomicLong implements Observer<T>, Disposable, TimeoutSelectorSupport {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39679b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super T, ? extends ObservableSource<?>> f39680c;

        /* renamed from: d  reason: collision with root package name */
        final SequentialDisposable f39681d = new SequentialDisposable();

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<Disposable> f39682e = new AtomicReference<>();

        TimeoutObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<?>> function) {
            this.f39679b = observer;
            this.f39680c = function;
        }

        public void a(long j2, Throwable th) {
            if (compareAndSet(j2, Clock.MAX_TIME)) {
                DisposableHelper.a(this.f39682e);
                this.f39679b.onError(th);
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void b(long j2) {
            if (compareAndSet(j2, Clock.MAX_TIME)) {
                DisposableHelper.a(this.f39682e);
                this.f39679b.onError(new TimeoutException());
            }
        }

        /* access modifiers changed from: package-private */
        public void c(ObservableSource<?> observableSource) {
            if (observableSource != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0, this);
                if (this.f39681d.a(timeoutConsumer)) {
                    observableSource.subscribe(timeoutConsumer);
                }
            }
        }

        public void dispose() {
            DisposableHelper.a(this.f39682e);
            this.f39681d.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.b(this.f39682e.get());
        }

        public void onComplete() {
            if (getAndSet(Clock.MAX_TIME) != Clock.MAX_TIME) {
                this.f39681d.dispose();
                this.f39679b.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (getAndSet(Clock.MAX_TIME) != Clock.MAX_TIME) {
                this.f39681d.dispose();
                this.f39679b.onError(th);
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(T t2) {
            long j2 = get();
            if (j2 != Clock.MAX_TIME) {
                long j3 = 1 + j2;
                if (compareAndSet(j2, j3)) {
                    Disposable disposable = (Disposable) this.f39681d.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.f39679b.onNext(t2);
                    try {
                        ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f39680c.apply(t2), "The itemTimeoutIndicator returned a null ObservableSource.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j3, this);
                        if (this.f39681d.a(timeoutConsumer)) {
                            observableSource.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f39682e.get().dispose();
                        getAndSet(Clock.MAX_TIME);
                        this.f39679b.onError(th);
                    }
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.f(this.f39682e, disposable);
        }
    }

    interface TimeoutSelectorSupport extends ObservableTimeoutTimed.TimeoutSupport {
        void a(long j2, Throwable th);
    }

    public ObservableTimeout(Observable<T> observable, ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        super(observable);
        this.f39668c = observableSource;
        this.f39669d = function;
        this.f39670e = observableSource2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        if (this.f39670e == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(observer, this.f39669d);
            observer.onSubscribe(timeoutObserver);
            timeoutObserver.c(this.f39668c);
            this.f38612b.subscribe(timeoutObserver);
            return;
        }
        TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(observer, this.f39669d, this.f39670e);
        observer.onSubscribe(timeoutFallbackObserver);
        timeoutFallbackObserver.c(this.f39668c);
        this.f38612b.subscribe(timeoutFallbackObserver);
    }
}
