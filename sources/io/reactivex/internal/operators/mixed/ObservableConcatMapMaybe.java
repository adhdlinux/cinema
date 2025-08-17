package io.reactivex.internal.operators.mixed;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
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

public final class ObservableConcatMapMaybe<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    final Observable<T> f38540b;

    /* renamed from: c  reason: collision with root package name */
    final Function<? super T, ? extends MaybeSource<? extends R>> f38541c;

    /* renamed from: d  reason: collision with root package name */
    final ErrorMode f38542d;

    /* renamed from: e  reason: collision with root package name */
    final int f38543e;

    static final class ConcatMapMaybeMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super R> f38544b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super T, ? extends MaybeSource<? extends R>> f38545c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicThrowable f38546d = new AtomicThrowable();

        /* renamed from: e  reason: collision with root package name */
        final ConcatMapMaybeObserver<R> f38547e = new ConcatMapMaybeObserver<>(this);

        /* renamed from: f  reason: collision with root package name */
        final SimplePlainQueue<T> f38548f;

        /* renamed from: g  reason: collision with root package name */
        final ErrorMode f38549g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f38550h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f38551i;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f38552j;

        /* renamed from: k  reason: collision with root package name */
        R f38553k;

        /* renamed from: l  reason: collision with root package name */
        volatile int f38554l;

        static final class ConcatMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {

            /* renamed from: b  reason: collision with root package name */
            final ConcatMapMaybeMainObserver<?, R> f38555b;

            ConcatMapMaybeObserver(ConcatMapMaybeMainObserver<?, R> concatMapMaybeMainObserver) {
                this.f38555b = concatMapMaybeMainObserver;
            }

            /* access modifiers changed from: package-private */
            public void a() {
                DisposableHelper.a(this);
            }

            public void onComplete() {
                this.f38555b.b();
            }

            public void onError(Throwable th) {
                this.f38555b.c(th);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.c(this, disposable);
            }

            public void onSuccess(R r2) {
                this.f38555b.d(r2);
            }
        }

        ConcatMapMaybeMainObserver(Observer<? super R> observer, Function<? super T, ? extends MaybeSource<? extends R>> function, int i2, ErrorMode errorMode) {
            this.f38544b = observer;
            this.f38545c = function;
            this.f38549g = errorMode;
            this.f38548f = new SpscLinkedArrayQueue(i2);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.f38544b;
                ErrorMode errorMode = this.f38549g;
                SimplePlainQueue<T> simplePlainQueue = this.f38548f;
                AtomicThrowable atomicThrowable = this.f38546d;
                int i2 = 1;
                while (true) {
                    if (this.f38552j) {
                        simplePlainQueue.clear();
                        this.f38553k = null;
                    } else {
                        int i3 = this.f38554l;
                        if (atomicThrowable.get() == null || !(errorMode == ErrorMode.IMMEDIATE || (errorMode == ErrorMode.BOUNDARY && i3 == 0))) {
                            boolean z2 = false;
                            if (i3 == 0) {
                                boolean z3 = this.f38551i;
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
                                        MaybeSource maybeSource = (MaybeSource) ObjectHelper.e(this.f38545c.apply(poll), "The mapper returned a null MaybeSource");
                                        this.f38554l = 1;
                                        maybeSource.a(this.f38547e);
                                    } catch (Throwable th) {
                                        Exceptions.b(th);
                                        this.f38550h.dispose();
                                        simplePlainQueue.clear();
                                        atomicThrowable.a(th);
                                        observer.onError(atomicThrowable.b());
                                        return;
                                    }
                                }
                            } else if (i3 == 2) {
                                R r2 = this.f38553k;
                                this.f38553k = null;
                                observer.onNext(r2);
                                this.f38554l = 0;
                            }
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
                simplePlainQueue.clear();
                this.f38553k = null;
                observer.onError(atomicThrowable.b());
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f38554l = 0;
            a();
        }

        /* access modifiers changed from: package-private */
        public void c(Throwable th) {
            if (this.f38546d.a(th)) {
                if (this.f38549g != ErrorMode.END) {
                    this.f38550h.dispose();
                }
                this.f38554l = 0;
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        /* access modifiers changed from: package-private */
        public void d(R r2) {
            this.f38553k = r2;
            this.f38554l = 2;
            a();
        }

        public void dispose() {
            this.f38552j = true;
            this.f38550h.dispose();
            this.f38547e.a();
            if (getAndIncrement() == 0) {
                this.f38548f.clear();
                this.f38553k = null;
            }
        }

        public boolean isDisposed() {
            return this.f38552j;
        }

        public void onComplete() {
            this.f38551i = true;
            a();
        }

        public void onError(Throwable th) {
            if (this.f38546d.a(th)) {
                if (this.f38549g == ErrorMode.IMMEDIATE) {
                    this.f38547e.a();
                }
                this.f38551i = true;
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(T t2) {
            this.f38548f.offer(t2);
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38550h, disposable)) {
                this.f38550h = disposable;
                this.f38544b.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapMaybe(Observable<T> observable, Function<? super T, ? extends MaybeSource<? extends R>> function, ErrorMode errorMode, int i2) {
        this.f38540b = observable;
        this.f38541c = function;
        this.f38542d = errorMode;
        this.f38543e = i2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super R> observer) {
        if (!ScalarXMapZHelper.b(this.f38540b, this.f38541c, observer)) {
            this.f38540b.subscribe(new ConcatMapMaybeMainObserver(observer, this.f38541c, this.f38543e, this.f38542d));
        }
    }
}
