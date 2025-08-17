package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowBoundary<T, B> extends AbstractObservableWithUpstream<T, Observable<T>> {

    /* renamed from: c  reason: collision with root package name */
    final ObservableSource<B> f39752c;

    /* renamed from: d  reason: collision with root package name */
    final int f39753d;

    static final class WindowBoundaryInnerObserver<T, B> extends DisposableObserver<B> {

        /* renamed from: c  reason: collision with root package name */
        final WindowBoundaryMainObserver<T, B> f39754c;

        /* renamed from: d  reason: collision with root package name */
        boolean f39755d;

        WindowBoundaryInnerObserver(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.f39754c = windowBoundaryMainObserver;
        }

        public void onComplete() {
            if (!this.f39755d) {
                this.f39755d = true;
                this.f39754c.b();
            }
        }

        public void onError(Throwable th) {
            if (this.f39755d) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f39755d = true;
            this.f39754c.c(th);
        }

        public void onNext(B b2) {
            if (!this.f39755d) {
                this.f39754c.d();
            }
        }
    }

    static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements Observer<T>, Disposable, Runnable {

        /* renamed from: l  reason: collision with root package name */
        static final Object f39756l = new Object();

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super Observable<T>> f39757b;

        /* renamed from: c  reason: collision with root package name */
        final int f39758c;

        /* renamed from: d  reason: collision with root package name */
        final WindowBoundaryInnerObserver<T, B> f39759d = new WindowBoundaryInnerObserver<>(this);

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<Disposable> f39760e = new AtomicReference<>();

        /* renamed from: f  reason: collision with root package name */
        final AtomicInteger f39761f = new AtomicInteger(1);

        /* renamed from: g  reason: collision with root package name */
        final MpscLinkedQueue<Object> f39762g = new MpscLinkedQueue<>();

        /* renamed from: h  reason: collision with root package name */
        final AtomicThrowable f39763h = new AtomicThrowable();

        /* renamed from: i  reason: collision with root package name */
        final AtomicBoolean f39764i = new AtomicBoolean();

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f39765j;

        /* renamed from: k  reason: collision with root package name */
        UnicastSubject<T> f39766k;

        WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, int i2) {
            this.f39757b = observer;
            this.f39758c = i2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            boolean z2;
            if (getAndIncrement() == 0) {
                Observer<? super Observable<T>> observer = this.f39757b;
                MpscLinkedQueue<Object> mpscLinkedQueue = this.f39762g;
                AtomicThrowable atomicThrowable = this.f39763h;
                int i2 = 1;
                while (this.f39761f.get() != 0) {
                    UnicastSubject<T> unicastSubject = this.f39766k;
                    boolean z3 = this.f39765j;
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
                                    this.f39766k = null;
                                    unicastSubject.onComplete();
                                }
                                observer.onComplete();
                                return;
                            }
                            if (unicastSubject != null) {
                                this.f39766k = null;
                                unicastSubject.onError(b2);
                            }
                            observer.onError(b2);
                            return;
                        } else if (z2) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else if (poll != f39756l) {
                            unicastSubject.onNext(poll);
                        } else {
                            if (unicastSubject != null) {
                                this.f39766k = null;
                                unicastSubject.onComplete();
                            }
                            if (!this.f39764i.get()) {
                                UnicastSubject<T> e2 = UnicastSubject.e(this.f39758c, this);
                                this.f39766k = e2;
                                this.f39761f.getAndIncrement();
                                observer.onNext(e2);
                            }
                        }
                    } else {
                        mpscLinkedQueue.clear();
                        Throwable b3 = atomicThrowable.b();
                        if (unicastSubject != null) {
                            this.f39766k = null;
                            unicastSubject.onError(b3);
                        }
                        observer.onError(b3);
                        return;
                    }
                }
                mpscLinkedQueue.clear();
                this.f39766k = null;
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            DisposableHelper.a(this.f39760e);
            this.f39765j = true;
            a();
        }

        /* access modifiers changed from: package-private */
        public void c(Throwable th) {
            DisposableHelper.a(this.f39760e);
            if (this.f39763h.a(th)) {
                this.f39765j = true;
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f39762g.offer(f39756l);
            a();
        }

        public void dispose() {
            if (this.f39764i.compareAndSet(false, true)) {
                this.f39759d.dispose();
                if (this.f39761f.decrementAndGet() == 0) {
                    DisposableHelper.a(this.f39760e);
                }
            }
        }

        public boolean isDisposed() {
            return this.f39764i.get();
        }

        public void onComplete() {
            this.f39759d.dispose();
            this.f39765j = true;
            a();
        }

        public void onError(Throwable th) {
            this.f39759d.dispose();
            if (this.f39763h.a(th)) {
                this.f39765j = true;
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(T t2) {
            this.f39762g.offer(t2);
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.f(this.f39760e, disposable)) {
                d();
            }
        }

        public void run() {
            if (this.f39761f.decrementAndGet() == 0) {
                DisposableHelper.a(this.f39760e);
            }
        }
    }

    public ObservableWindowBoundary(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, int i2) {
        super(observableSource);
        this.f39752c = observableSource2;
        this.f39753d = i2;
    }

    public void subscribeActual(Observer<? super Observable<T>> observer) {
        WindowBoundaryMainObserver windowBoundaryMainObserver = new WindowBoundaryMainObserver(observer, this.f39753d);
        observer.onSubscribe(windowBoundaryMainObserver);
        this.f39752c.subscribe(windowBoundaryMainObserver.f39759d);
        this.f38612b.subscribe(windowBoundaryMainObserver);
    }
}
