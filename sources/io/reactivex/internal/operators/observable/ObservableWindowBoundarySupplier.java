package io.reactivex.internal.operators.observable;

import androidx.media3.exoplayer.mediacodec.f;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowBoundarySupplier<T, B> extends AbstractObservableWithUpstream<T, Observable<T>> {

    /* renamed from: c  reason: collision with root package name */
    final Callable<? extends ObservableSource<B>> f39785c;

    /* renamed from: d  reason: collision with root package name */
    final int f39786d;

    static final class WindowBoundaryInnerObserver<T, B> extends DisposableObserver<B> {

        /* renamed from: c  reason: collision with root package name */
        final WindowBoundaryMainObserver<T, B> f39787c;

        /* renamed from: d  reason: collision with root package name */
        boolean f39788d;

        WindowBoundaryInnerObserver(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.f39787c = windowBoundaryMainObserver;
        }

        public void onComplete() {
            if (!this.f39788d) {
                this.f39788d = true;
                this.f39787c.c();
            }
        }

        public void onError(Throwable th) {
            if (this.f39788d) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f39788d = true;
            this.f39787c.d(th);
        }

        public void onNext(B b2) {
            if (!this.f39788d) {
                this.f39788d = true;
                dispose();
                this.f39787c.e(this);
            }
        }
    }

    static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements Observer<T>, Disposable, Runnable {

        /* renamed from: m  reason: collision with root package name */
        static final WindowBoundaryInnerObserver<Object, Object> f39789m = new WindowBoundaryInnerObserver<>((WindowBoundaryMainObserver) null);

        /* renamed from: n  reason: collision with root package name */
        static final Object f39790n = new Object();

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super Observable<T>> f39791b;

        /* renamed from: c  reason: collision with root package name */
        final int f39792c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<WindowBoundaryInnerObserver<T, B>> f39793d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        final AtomicInteger f39794e = new AtomicInteger(1);

        /* renamed from: f  reason: collision with root package name */
        final MpscLinkedQueue<Object> f39795f = new MpscLinkedQueue<>();

        /* renamed from: g  reason: collision with root package name */
        final AtomicThrowable f39796g = new AtomicThrowable();

        /* renamed from: h  reason: collision with root package name */
        final AtomicBoolean f39797h = new AtomicBoolean();

        /* renamed from: i  reason: collision with root package name */
        final Callable<? extends ObservableSource<B>> f39798i;

        /* renamed from: j  reason: collision with root package name */
        Disposable f39799j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f39800k;

        /* renamed from: l  reason: collision with root package name */
        UnicastSubject<T> f39801l;

        WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, int i2, Callable<? extends ObservableSource<B>> callable) {
            this.f39791b = observer;
            this.f39792c = i2;
            this.f39798i = callable;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            AtomicReference<WindowBoundaryInnerObserver<T, B>> atomicReference = this.f39793d;
            WindowBoundaryInnerObserver<Object, Object> windowBoundaryInnerObserver = f39789m;
            Disposable andSet = atomicReference.getAndSet(windowBoundaryInnerObserver);
            if (andSet != null && andSet != windowBoundaryInnerObserver) {
                andSet.dispose();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            boolean z2;
            if (getAndIncrement() == 0) {
                Observer<? super Observable<T>> observer = this.f39791b;
                MpscLinkedQueue<Object> mpscLinkedQueue = this.f39795f;
                AtomicThrowable atomicThrowable = this.f39796g;
                int i2 = 1;
                while (this.f39794e.get() != 0) {
                    UnicastSubject<T> unicastSubject = this.f39801l;
                    boolean z3 = this.f39800k;
                    if (!z3 || atomicThrowable.get() == null) {
                        Object poll = mpscLinkedQueue.poll();
                        if (poll == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z3 && z2) {
                            Throwable b2 = atomicThrowable.b();
                            if (b2 == null) {
                                if (unicastSubject != null) {
                                    this.f39801l = null;
                                    unicastSubject.onComplete();
                                }
                                observer.onComplete();
                                return;
                            }
                            if (unicastSubject != null) {
                                this.f39801l = null;
                                unicastSubject.onError(b2);
                            }
                            observer.onError(b2);
                            return;
                        } else if (z2) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else if (poll != f39790n) {
                            unicastSubject.onNext(poll);
                        } else {
                            if (unicastSubject != null) {
                                this.f39801l = null;
                                unicastSubject.onComplete();
                            }
                            if (!this.f39797h.get()) {
                                UnicastSubject<T> e2 = UnicastSubject.e(this.f39792c, this);
                                this.f39801l = e2;
                                this.f39794e.getAndIncrement();
                                try {
                                    ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f39798i.call(), "The other Callable returned a null ObservableSource");
                                    WindowBoundaryInnerObserver windowBoundaryInnerObserver = new WindowBoundaryInnerObserver(this);
                                    if (f.a(this.f39793d, (Object) null, windowBoundaryInnerObserver)) {
                                        observableSource.subscribe(windowBoundaryInnerObserver);
                                        observer.onNext(e2);
                                    }
                                } catch (Throwable th) {
                                    Exceptions.b(th);
                                    atomicThrowable.a(th);
                                    this.f39800k = true;
                                }
                            }
                        }
                    } else {
                        mpscLinkedQueue.clear();
                        Throwable b3 = atomicThrowable.b();
                        if (unicastSubject != null) {
                            this.f39801l = null;
                            unicastSubject.onError(b3);
                        }
                        observer.onError(b3);
                        return;
                    }
                }
                mpscLinkedQueue.clear();
                this.f39801l = null;
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f39799j.dispose();
            this.f39800k = true;
            b();
        }

        /* access modifiers changed from: package-private */
        public void d(Throwable th) {
            this.f39799j.dispose();
            if (this.f39796g.a(th)) {
                this.f39800k = true;
                b();
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void dispose() {
            if (this.f39797h.compareAndSet(false, true)) {
                a();
                if (this.f39794e.decrementAndGet() == 0) {
                    this.f39799j.dispose();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void e(WindowBoundaryInnerObserver<T, B> windowBoundaryInnerObserver) {
            f.a(this.f39793d, windowBoundaryInnerObserver, (Object) null);
            this.f39795f.offer(f39790n);
            b();
        }

        public boolean isDisposed() {
            return this.f39797h.get();
        }

        public void onComplete() {
            a();
            this.f39800k = true;
            b();
        }

        public void onError(Throwable th) {
            a();
            if (this.f39796g.a(th)) {
                this.f39800k = true;
                b();
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(T t2) {
            this.f39795f.offer(t2);
            b();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39799j, disposable)) {
                this.f39799j = disposable;
                this.f39791b.onSubscribe(this);
                this.f39795f.offer(f39790n);
                b();
            }
        }

        public void run() {
            if (this.f39794e.decrementAndGet() == 0) {
                this.f39799j.dispose();
            }
        }
    }

    public ObservableWindowBoundarySupplier(ObservableSource<T> observableSource, Callable<? extends ObservableSource<B>> callable, int i2) {
        super(observableSource);
        this.f39785c = callable;
        this.f39786d = i2;
    }

    public void subscribeActual(Observer<? super Observable<T>> observer) {
        this.f38612b.subscribe(new WindowBoundaryMainObserver(observer, this.f39786d, this.f39785c));
    }
}
