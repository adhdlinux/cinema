package io.reactivex.internal.operators.mixed;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMapSingle<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    final Observable<T> f38556b;

    /* renamed from: c  reason: collision with root package name */
    final Function<? super T, ? extends SingleSource<? extends R>> f38557c;

    /* renamed from: d  reason: collision with root package name */
    final ErrorMode f38558d;

    /* renamed from: e  reason: collision with root package name */
    final int f38559e;

    static final class ConcatMapSingleMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super R> f38560b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super T, ? extends SingleSource<? extends R>> f38561c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicThrowable f38562d = new AtomicThrowable();

        /* renamed from: e  reason: collision with root package name */
        final ConcatMapSingleObserver<R> f38563e = new ConcatMapSingleObserver<>(this);

        /* renamed from: f  reason: collision with root package name */
        final SimplePlainQueue<T> f38564f;

        /* renamed from: g  reason: collision with root package name */
        final ErrorMode f38565g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f38566h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f38567i;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f38568j;

        /* renamed from: k  reason: collision with root package name */
        R f38569k;

        /* renamed from: l  reason: collision with root package name */
        volatile int f38570l;

        static final class ConcatMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {

            /* renamed from: b  reason: collision with root package name */
            final ConcatMapSingleMainObserver<?, R> f38571b;

            ConcatMapSingleObserver(ConcatMapSingleMainObserver<?, R> concatMapSingleMainObserver) {
                this.f38571b = concatMapSingleMainObserver;
            }

            /* access modifiers changed from: package-private */
            public void a() {
                DisposableHelper.a(this);
            }

            public void onError(Throwable th) {
                this.f38571b.b(th);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.c(this, disposable);
            }

            public void onSuccess(R r2) {
                this.f38571b.c(r2);
            }
        }

        ConcatMapSingleMainObserver(Observer<? super R> observer, Function<? super T, ? extends SingleSource<? extends R>> function, int i2, ErrorMode errorMode) {
            this.f38560b = observer;
            this.f38561c = function;
            this.f38565g = errorMode;
            this.f38564f = new SpscLinkedArrayQueue(i2);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.f38560b;
                ErrorMode errorMode = this.f38565g;
                SimplePlainQueue<T> simplePlainQueue = this.f38564f;
                AtomicThrowable atomicThrowable = this.f38562d;
                int i2 = 1;
                while (true) {
                    if (this.f38568j) {
                        simplePlainQueue.clear();
                        this.f38569k = null;
                    } else {
                        int i3 = this.f38570l;
                        if (atomicThrowable.get() == null || !(errorMode == ErrorMode.IMMEDIATE || (errorMode == ErrorMode.BOUNDARY && i3 == 0))) {
                            boolean z2 = false;
                            if (i3 == 0) {
                                boolean z3 = this.f38567i;
                                T poll = simplePlainQueue.poll();
                                if (poll == null) {
                                    z2 = true;
                                }
                                if (z3 && z2) {
                                    Throwable b2 = atomicThrowable.b();
                                    if (b2 == null) {
                                        observer.onComplete();
                                        return;
                                    } else {
                                        observer.onError(b2);
                                        return;
                                    }
                                } else if (!z2) {
                                    try {
                                        SingleSource singleSource = (SingleSource) ObjectHelper.e(this.f38561c.apply(poll), "The mapper returned a null SingleSource");
                                        this.f38570l = 1;
                                        singleSource.a(this.f38563e);
                                    } catch (Throwable th) {
                                        Exceptions.b(th);
                                        this.f38566h.dispose();
                                        simplePlainQueue.clear();
                                        atomicThrowable.a(th);
                                        observer.onError(atomicThrowable.b());
                                        return;
                                    }
                                }
                            } else if (i3 == 2) {
                                R r2 = this.f38569k;
                                this.f38569k = null;
                                observer.onNext(r2);
                                this.f38570l = 0;
                            }
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
                simplePlainQueue.clear();
                this.f38569k = null;
                observer.onError(atomicThrowable.b());
            }
        }

        /* access modifiers changed from: package-private */
        public void b(Throwable th) {
            if (this.f38562d.a(th)) {
                if (this.f38565g != ErrorMode.END) {
                    this.f38566h.dispose();
                }
                this.f38570l = 0;
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        /* access modifiers changed from: package-private */
        public void c(R r2) {
            this.f38569k = r2;
            this.f38570l = 2;
            a();
        }

        public void dispose() {
            this.f38568j = true;
            this.f38566h.dispose();
            this.f38563e.a();
            if (getAndIncrement() == 0) {
                this.f38564f.clear();
                this.f38569k = null;
            }
        }

        public boolean isDisposed() {
            return this.f38568j;
        }

        public void onComplete() {
            this.f38567i = true;
            a();
        }

        public void onError(Throwable th) {
            if (this.f38562d.a(th)) {
                if (this.f38565g == ErrorMode.IMMEDIATE) {
                    this.f38563e.a();
                }
                this.f38567i = true;
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(T t2) {
            this.f38564f.offer(t2);
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38566h, disposable)) {
                this.f38566h = disposable;
                this.f38560b.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapSingle(Observable<T> observable, Function<? super T, ? extends SingleSource<? extends R>> function, ErrorMode errorMode, int i2) {
        this.f38556b = observable;
        this.f38557c = function;
        this.f38558d = errorMode;
        this.f38559e = i2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super R> observer) {
        if (!ScalarXMapZHelper.c(this.f38556b, this.f38557c, observer)) {
            this.f38556b.subscribe(new ConcatMapSingleMainObserver(observer, this.f38557c, this.f38559e, this.f38558d));
        }
    }
}
