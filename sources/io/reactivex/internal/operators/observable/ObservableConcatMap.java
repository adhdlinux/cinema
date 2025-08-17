package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMap<T, U> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    final Function<? super T, ? extends ObservableSource<? extends U>> f38809c;

    /* renamed from: d  reason: collision with root package name */
    final int f38810d;

    /* renamed from: e  reason: collision with root package name */
    final ErrorMode f38811e;

    static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super R> f38812b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super T, ? extends ObservableSource<? extends R>> f38813c;

        /* renamed from: d  reason: collision with root package name */
        final int f38814d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicThrowable f38815e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        final DelayErrorInnerObserver<R> f38816f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f38817g;

        /* renamed from: h  reason: collision with root package name */
        SimpleQueue<T> f38818h;

        /* renamed from: i  reason: collision with root package name */
        Disposable f38819i;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f38820j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f38821k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f38822l;

        /* renamed from: m  reason: collision with root package name */
        int f38823m;

        static final class DelayErrorInnerObserver<R> extends AtomicReference<Disposable> implements Observer<R> {

            /* renamed from: b  reason: collision with root package name */
            final Observer<? super R> f38824b;

            /* renamed from: c  reason: collision with root package name */
            final ConcatMapDelayErrorObserver<?, R> f38825c;

            DelayErrorInnerObserver(Observer<? super R> observer, ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver) {
                this.f38824b = observer;
                this.f38825c = concatMapDelayErrorObserver;
            }

            /* access modifiers changed from: package-private */
            public void a() {
                DisposableHelper.a(this);
            }

            public void onComplete() {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.f38825c;
                concatMapDelayErrorObserver.f38820j = false;
                concatMapDelayErrorObserver.a();
            }

            public void onError(Throwable th) {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.f38825c;
                if (concatMapDelayErrorObserver.f38815e.a(th)) {
                    if (!concatMapDelayErrorObserver.f38817g) {
                        concatMapDelayErrorObserver.f38819i.dispose();
                    }
                    concatMapDelayErrorObserver.f38820j = false;
                    concatMapDelayErrorObserver.a();
                    return;
                }
                RxJavaPlugins.s(th);
            }

            public void onNext(R r2) {
                this.f38824b.onNext(r2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.c(this, disposable);
            }
        }

        ConcatMapDelayErrorObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, boolean z2) {
            this.f38812b = observer;
            this.f38813c = function;
            this.f38814d = i2;
            this.f38817g = z2;
            this.f38816f = new DelayErrorInnerObserver<>(observer, this);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            boolean z2;
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.f38812b;
                SimpleQueue<T> simpleQueue = this.f38818h;
                AtomicThrowable atomicThrowable = this.f38815e;
                while (true) {
                    if (!this.f38820j) {
                        if (this.f38822l) {
                            simpleQueue.clear();
                            return;
                        } else if (this.f38817g || ((Throwable) atomicThrowable.get()) == null) {
                            boolean z3 = this.f38821k;
                            try {
                                T poll = simpleQueue.poll();
                                if (poll == null) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z3 && z2) {
                                    this.f38822l = true;
                                    Throwable b2 = atomicThrowable.b();
                                    if (b2 != null) {
                                        observer.onError(b2);
                                        return;
                                    } else {
                                        observer.onComplete();
                                        return;
                                    }
                                } else if (!z2) {
                                    try {
                                        ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f38813c.apply(poll), "The mapper returned a null ObservableSource");
                                        if (observableSource instanceof Callable) {
                                            try {
                                                Object call = ((Callable) observableSource).call();
                                                if (call != null && !this.f38822l) {
                                                    observer.onNext(call);
                                                }
                                            } catch (Throwable th) {
                                                Exceptions.b(th);
                                                atomicThrowable.a(th);
                                            }
                                        } else {
                                            this.f38820j = true;
                                            observableSource.subscribe(this.f38816f);
                                        }
                                    } catch (Throwable th2) {
                                        Exceptions.b(th2);
                                        this.f38822l = true;
                                        this.f38819i.dispose();
                                        simpleQueue.clear();
                                        atomicThrowable.a(th2);
                                        observer.onError(atomicThrowable.b());
                                        return;
                                    }
                                }
                            } catch (Throwable th3) {
                                Exceptions.b(th3);
                                this.f38822l = true;
                                this.f38819i.dispose();
                                atomicThrowable.a(th3);
                                observer.onError(atomicThrowable.b());
                                return;
                            }
                        } else {
                            simpleQueue.clear();
                            this.f38822l = true;
                            observer.onError(atomicThrowable.b());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void dispose() {
            this.f38822l = true;
            this.f38819i.dispose();
            this.f38816f.a();
        }

        public boolean isDisposed() {
            return this.f38822l;
        }

        public void onComplete() {
            this.f38821k = true;
            a();
        }

        public void onError(Throwable th) {
            if (this.f38815e.a(th)) {
                this.f38821k = true;
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(T t2) {
            if (this.f38823m == 0) {
                this.f38818h.offer(t2);
            }
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38819i, disposable)) {
                this.f38819i = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int b2 = queueDisposable.b(3);
                    if (b2 == 1) {
                        this.f38823m = b2;
                        this.f38818h = queueDisposable;
                        this.f38821k = true;
                        this.f38812b.onSubscribe(this);
                        a();
                        return;
                    } else if (b2 == 2) {
                        this.f38823m = b2;
                        this.f38818h = queueDisposable;
                        this.f38812b.onSubscribe(this);
                        return;
                    }
                }
                this.f38818h = new SpscLinkedArrayQueue(this.f38814d);
                this.f38812b.onSubscribe(this);
            }
        }
    }

    static final class SourceObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super U> f38826b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super T, ? extends ObservableSource<? extends U>> f38827c;

        /* renamed from: d  reason: collision with root package name */
        final InnerObserver<U> f38828d;

        /* renamed from: e  reason: collision with root package name */
        final int f38829e;

        /* renamed from: f  reason: collision with root package name */
        SimpleQueue<T> f38830f;

        /* renamed from: g  reason: collision with root package name */
        Disposable f38831g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f38832h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f38833i;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f38834j;

        /* renamed from: k  reason: collision with root package name */
        int f38835k;

        static final class InnerObserver<U> extends AtomicReference<Disposable> implements Observer<U> {

            /* renamed from: b  reason: collision with root package name */
            final Observer<? super U> f38836b;

            /* renamed from: c  reason: collision with root package name */
            final SourceObserver<?, ?> f38837c;

            InnerObserver(Observer<? super U> observer, SourceObserver<?, ?> sourceObserver) {
                this.f38836b = observer;
                this.f38837c = sourceObserver;
            }

            /* access modifiers changed from: package-private */
            public void a() {
                DisposableHelper.a(this);
            }

            public void onComplete() {
                this.f38837c.b();
            }

            public void onError(Throwable th) {
                this.f38837c.dispose();
                this.f38836b.onError(th);
            }

            public void onNext(U u2) {
                this.f38836b.onNext(u2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.c(this, disposable);
            }
        }

        SourceObserver(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, int i2) {
            this.f38826b = observer;
            this.f38827c = function;
            this.f38829e = i2;
            this.f38828d = new InnerObserver<>(observer, this);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            boolean z2;
            if (getAndIncrement() == 0) {
                while (!this.f38833i) {
                    if (!this.f38832h) {
                        boolean z3 = this.f38834j;
                        try {
                            T poll = this.f38830f.poll();
                            if (poll == null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z3 && z2) {
                                this.f38833i = true;
                                this.f38826b.onComplete();
                                return;
                            } else if (!z2) {
                                try {
                                    ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f38827c.apply(poll), "The mapper returned a null ObservableSource");
                                    this.f38832h = true;
                                    observableSource.subscribe(this.f38828d);
                                } catch (Throwable th) {
                                    Exceptions.b(th);
                                    dispose();
                                    this.f38830f.clear();
                                    this.f38826b.onError(th);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            Exceptions.b(th2);
                            dispose();
                            this.f38830f.clear();
                            this.f38826b.onError(th2);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.f38830f.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f38832h = false;
            a();
        }

        public void dispose() {
            this.f38833i = true;
            this.f38828d.a();
            this.f38831g.dispose();
            if (getAndIncrement() == 0) {
                this.f38830f.clear();
            }
        }

        public boolean isDisposed() {
            return this.f38833i;
        }

        public void onComplete() {
            if (!this.f38834j) {
                this.f38834j = true;
                a();
            }
        }

        public void onError(Throwable th) {
            if (this.f38834j) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f38834j = true;
            dispose();
            this.f38826b.onError(th);
        }

        public void onNext(T t2) {
            if (!this.f38834j) {
                if (this.f38835k == 0) {
                    this.f38830f.offer(t2);
                }
                a();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38831g, disposable)) {
                this.f38831g = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int b2 = queueDisposable.b(3);
                    if (b2 == 1) {
                        this.f38835k = b2;
                        this.f38830f = queueDisposable;
                        this.f38834j = true;
                        this.f38826b.onSubscribe(this);
                        a();
                        return;
                    } else if (b2 == 2) {
                        this.f38835k = b2;
                        this.f38830f = queueDisposable;
                        this.f38826b.onSubscribe(this);
                        return;
                    }
                }
                this.f38830f = new SpscLinkedArrayQueue(this.f38829e);
                this.f38826b.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, int i2, ErrorMode errorMode) {
        super(observableSource);
        this.f38809c = function;
        this.f38811e = errorMode;
        this.f38810d = Math.max(8, i2);
    }

    public void subscribeActual(Observer<? super U> observer) {
        boolean z2;
        if (!ObservableScalarXMap.b(this.f38612b, observer, this.f38809c)) {
            if (this.f38811e == ErrorMode.IMMEDIATE) {
                this.f38612b.subscribe(new SourceObserver(new SerializedObserver(observer), this.f38809c, this.f38810d));
                return;
            }
            ObservableSource<T> observableSource = this.f38612b;
            Function<? super T, ? extends ObservableSource<? extends U>> function = this.f38809c;
            int i2 = this.f38810d;
            if (this.f38811e == ErrorMode.END) {
                z2 = true;
            } else {
                z2 = false;
            }
            observableSource.subscribe(new ConcatMapDelayErrorObserver(observer, function, i2, z2));
        }
    }
}
