package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    final Callable<U> f38686c;

    /* renamed from: d  reason: collision with root package name */
    final ObservableSource<? extends Open> f38687d;

    /* renamed from: e  reason: collision with root package name */
    final Function<? super Open, ? extends ObservableSource<? extends Close>> f38688e;

    static final class BufferBoundaryObserver<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super C> f38689b;

        /* renamed from: c  reason: collision with root package name */
        final Callable<C> f38690c;

        /* renamed from: d  reason: collision with root package name */
        final ObservableSource<? extends Open> f38691d;

        /* renamed from: e  reason: collision with root package name */
        final Function<? super Open, ? extends ObservableSource<? extends Close>> f38692e;

        /* renamed from: f  reason: collision with root package name */
        final CompositeDisposable f38693f = new CompositeDisposable();

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<Disposable> f38694g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        final AtomicThrowable f38695h = new AtomicThrowable();

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f38696i;

        /* renamed from: j  reason: collision with root package name */
        final SpscLinkedArrayQueue<C> f38697j = new SpscLinkedArrayQueue<>(Observable.bufferSize());

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f38698k;

        /* renamed from: l  reason: collision with root package name */
        long f38699l;

        /* renamed from: m  reason: collision with root package name */
        Map<Long, C> f38700m = new LinkedHashMap();

        static final class BufferOpenObserver<Open> extends AtomicReference<Disposable> implements Observer<Open>, Disposable {

            /* renamed from: b  reason: collision with root package name */
            final BufferBoundaryObserver<?, ?, Open, ?> f38701b;

            BufferOpenObserver(BufferBoundaryObserver<?, ?, Open, ?> bufferBoundaryObserver) {
                this.f38701b = bufferBoundaryObserver;
            }

            public void dispose() {
                DisposableHelper.a(this);
            }

            public boolean isDisposed() {
                return get() == DisposableHelper.DISPOSED;
            }

            public void onComplete() {
                lazySet(DisposableHelper.DISPOSED);
                this.f38701b.e(this);
            }

            public void onError(Throwable th) {
                lazySet(DisposableHelper.DISPOSED);
                this.f38701b.a(this, th);
            }

            public void onNext(Open open) {
                this.f38701b.d(open);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.f(this, disposable);
            }
        }

        BufferBoundaryObserver(Observer<? super C> observer, ObservableSource<? extends Open> observableSource, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Callable<C> callable) {
            this.f38689b = observer;
            this.f38690c = callable;
            this.f38691d = observableSource;
            this.f38692e = function;
        }

        /* access modifiers changed from: package-private */
        public void a(Disposable disposable, Throwable th) {
            DisposableHelper.a(this.f38694g);
            this.f38693f.c(disposable);
            onError(th);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
            if (r4 == false) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
            r3.f38696i = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
            c();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(io.reactivex.internal.operators.observable.ObservableBufferBoundary.BufferCloseObserver<T, C> r4, long r5) {
            /*
                r3 = this;
                io.reactivex.disposables.CompositeDisposable r0 = r3.f38693f
                r0.c(r4)
                io.reactivex.disposables.CompositeDisposable r4 = r3.f38693f
                int r4 = r4.f()
                r0 = 1
                if (r4 != 0) goto L_0x0015
                java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> r4 = r3.f38694g
                io.reactivex.internal.disposables.DisposableHelper.a(r4)
                r4 = 1
                goto L_0x0016
            L_0x0015:
                r4 = 0
            L_0x0016:
                monitor-enter(r3)
                java.util.Map<java.lang.Long, C> r1 = r3.f38700m     // Catch:{ all -> 0x0033 }
                if (r1 != 0) goto L_0x001d
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                return
            L_0x001d:
                io.reactivex.internal.queue.SpscLinkedArrayQueue<C> r2 = r3.f38697j     // Catch:{ all -> 0x0033 }
                java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0033 }
                java.lang.Object r5 = r1.remove(r5)     // Catch:{ all -> 0x0033 }
                r2.offer(r5)     // Catch:{ all -> 0x0033 }
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                if (r4 == 0) goto L_0x002f
                r3.f38696i = r0
            L_0x002f:
                r3.c()
                return
            L_0x0033:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableBufferBoundary.BufferBoundaryObserver.b(io.reactivex.internal.operators.observable.ObservableBufferBoundary$BufferCloseObserver, long):void");
        }

        /* access modifiers changed from: package-private */
        public void c() {
            boolean z2;
            if (getAndIncrement() == 0) {
                Observer<? super C> observer = this.f38689b;
                SpscLinkedArrayQueue<C> spscLinkedArrayQueue = this.f38697j;
                int i2 = 1;
                while (!this.f38698k) {
                    boolean z3 = this.f38696i;
                    if (!z3 || this.f38695h.get() == null) {
                        Collection collection = (Collection) spscLinkedArrayQueue.poll();
                        if (collection == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z3 && z2) {
                            observer.onComplete();
                            return;
                        } else if (z2) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else {
                            observer.onNext(collection);
                        }
                    } else {
                        spscLinkedArrayQueue.clear();
                        observer.onError(this.f38695h.b());
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void d(Open open) {
            try {
                Collection collection = (Collection) ObjectHelper.e(this.f38690c.call(), "The bufferSupplier returned a null Collection");
                ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f38692e.apply(open), "The bufferClose returned a null ObservableSource");
                long j2 = this.f38699l;
                this.f38699l = 1 + j2;
                synchronized (this) {
                    Map<Long, C> map = this.f38700m;
                    if (map != null) {
                        map.put(Long.valueOf(j2), collection);
                        BufferCloseObserver bufferCloseObserver = new BufferCloseObserver(this, j2);
                        this.f38693f.b(bufferCloseObserver);
                        observableSource.subscribe(bufferCloseObserver);
                    }
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                DisposableHelper.a(this.f38694g);
                onError(th);
            }
        }

        public void dispose() {
            if (DisposableHelper.a(this.f38694g)) {
                this.f38698k = true;
                this.f38693f.dispose();
                synchronized (this) {
                    this.f38700m = null;
                }
                if (getAndIncrement() != 0) {
                    this.f38697j.clear();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void e(BufferOpenObserver<Open> bufferOpenObserver) {
            this.f38693f.c(bufferOpenObserver);
            if (this.f38693f.f() == 0) {
                DisposableHelper.a(this.f38694g);
                this.f38696i = true;
                c();
            }
        }

        public boolean isDisposed() {
            return DisposableHelper.b(this.f38694g.get());
        }

        public void onComplete() {
            this.f38693f.dispose();
            synchronized (this) {
                Map<Long, C> map = this.f38700m;
                if (map != null) {
                    for (C offer : map.values()) {
                        this.f38697j.offer(offer);
                    }
                    this.f38700m = null;
                    this.f38696i = true;
                    c();
                }
            }
        }

        public void onError(Throwable th) {
            if (this.f38695h.a(th)) {
                this.f38693f.dispose();
                synchronized (this) {
                    this.f38700m = null;
                }
                this.f38696i = true;
                c();
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(T t2) {
            synchronized (this) {
                Map<Long, C> map = this.f38700m;
                if (map != null) {
                    for (C add : map.values()) {
                        add.add(t2);
                    }
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.f(this.f38694g, disposable)) {
                BufferOpenObserver bufferOpenObserver = new BufferOpenObserver(this);
                this.f38693f.b(bufferOpenObserver);
                this.f38691d.subscribe(bufferOpenObserver);
            }
        }
    }

    static final class BufferCloseObserver<T, C extends Collection<? super T>> extends AtomicReference<Disposable> implements Observer<Object>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final BufferBoundaryObserver<T, C, ?, ?> f38702b;

        /* renamed from: c  reason: collision with root package name */
        final long f38703c;

        BufferCloseObserver(BufferBoundaryObserver<T, C, ?, ?> bufferBoundaryObserver, long j2) {
            this.f38702b = bufferBoundaryObserver;
            this.f38703c = j2;
        }

        public void dispose() {
            DisposableHelper.a(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.f38702b.b(this, this.f38703c);
            }
        }

        public void onError(Throwable th) {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.f38702b.a(this, th);
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(Object obj) {
            Disposable disposable = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                lazySet(disposableHelper);
                disposable.dispose();
                this.f38702b.b(this, this.f38703c);
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.f(this, disposable);
        }
    }

    public ObservableBufferBoundary(ObservableSource<T> observableSource, ObservableSource<? extends Open> observableSource2, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Callable<U> callable) {
        super(observableSource);
        this.f38687d = observableSource2;
        this.f38688e = function;
        this.f38686c = callable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super U> observer) {
        BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(observer, this.f38687d, this.f38688e, this.f38686c);
        observer.onSubscribe(bufferBoundaryObserver);
        this.f38612b.subscribe(bufferBoundaryObserver);
    }
}
