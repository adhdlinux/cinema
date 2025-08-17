package io.reactivex.internal.operators.mixed;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
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
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMapCompletable<T> extends Completable {

    /* renamed from: b  reason: collision with root package name */
    final Observable<T> f38524b;

    /* renamed from: c  reason: collision with root package name */
    final Function<? super T, ? extends CompletableSource> f38525c;

    /* renamed from: d  reason: collision with root package name */
    final ErrorMode f38526d;

    /* renamed from: e  reason: collision with root package name */
    final int f38527e;

    static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final CompletableObserver f38528b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super T, ? extends CompletableSource> f38529c;

        /* renamed from: d  reason: collision with root package name */
        final ErrorMode f38530d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicThrowable f38531e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        final ConcatMapInnerObserver f38532f = new ConcatMapInnerObserver(this);

        /* renamed from: g  reason: collision with root package name */
        final int f38533g;

        /* renamed from: h  reason: collision with root package name */
        SimpleQueue<T> f38534h;

        /* renamed from: i  reason: collision with root package name */
        Disposable f38535i;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f38536j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f38537k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f38538l;

        static final class ConcatMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {

            /* renamed from: b  reason: collision with root package name */
            final ConcatMapCompletableObserver<?> f38539b;

            ConcatMapInnerObserver(ConcatMapCompletableObserver<?> concatMapCompletableObserver) {
                this.f38539b = concatMapCompletableObserver;
            }

            /* access modifiers changed from: package-private */
            public void a() {
                DisposableHelper.a(this);
            }

            public void onComplete() {
                this.f38539b.b();
            }

            public void onError(Throwable th) {
                this.f38539b.c(th);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.c(this, disposable);
            }
        }

        ConcatMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i2) {
            this.f38528b = completableObserver;
            this.f38529c = function;
            this.f38530d = errorMode;
            this.f38533g = i2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            boolean z2;
            CompletableSource completableSource;
            if (getAndIncrement() == 0) {
                AtomicThrowable atomicThrowable = this.f38531e;
                ErrorMode errorMode = this.f38530d;
                while (!this.f38538l) {
                    if (!this.f38536j) {
                        if (errorMode != ErrorMode.BOUNDARY || atomicThrowable.get() == null) {
                            boolean z3 = this.f38537k;
                            try {
                                T poll = this.f38534h.poll();
                                if (poll != null) {
                                    completableSource = (CompletableSource) ObjectHelper.e(this.f38529c.apply(poll), "The mapper returned a null CompletableSource");
                                    z2 = false;
                                } else {
                                    completableSource = null;
                                    z2 = true;
                                }
                                if (z3 && z2) {
                                    this.f38538l = true;
                                    Throwable b2 = atomicThrowable.b();
                                    if (b2 != null) {
                                        this.f38528b.onError(b2);
                                        return;
                                    } else {
                                        this.f38528b.onComplete();
                                        return;
                                    }
                                } else if (!z2) {
                                    this.f38536j = true;
                                    completableSource.a(this.f38532f);
                                }
                            } catch (Throwable th) {
                                Exceptions.b(th);
                                this.f38538l = true;
                                this.f38534h.clear();
                                this.f38535i.dispose();
                                atomicThrowable.a(th);
                                this.f38528b.onError(atomicThrowable.b());
                                return;
                            }
                        } else {
                            this.f38538l = true;
                            this.f38534h.clear();
                            this.f38528b.onError(atomicThrowable.b());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.f38534h.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f38536j = false;
            a();
        }

        /* access modifiers changed from: package-private */
        public void c(Throwable th) {
            if (!this.f38531e.a(th)) {
                RxJavaPlugins.s(th);
            } else if (this.f38530d == ErrorMode.IMMEDIATE) {
                this.f38538l = true;
                this.f38535i.dispose();
                Throwable b2 = this.f38531e.b();
                if (b2 != ExceptionHelper.f40066a) {
                    this.f38528b.onError(b2);
                }
                if (getAndIncrement() == 0) {
                    this.f38534h.clear();
                }
            } else {
                this.f38536j = false;
                a();
            }
        }

        public void dispose() {
            this.f38538l = true;
            this.f38535i.dispose();
            this.f38532f.a();
            if (getAndIncrement() == 0) {
                this.f38534h.clear();
            }
        }

        public boolean isDisposed() {
            return this.f38538l;
        }

        public void onComplete() {
            this.f38537k = true;
            a();
        }

        public void onError(Throwable th) {
            if (!this.f38531e.a(th)) {
                RxJavaPlugins.s(th);
            } else if (this.f38530d == ErrorMode.IMMEDIATE) {
                this.f38538l = true;
                this.f38532f.a();
                Throwable b2 = this.f38531e.b();
                if (b2 != ExceptionHelper.f40066a) {
                    this.f38528b.onError(b2);
                }
                if (getAndIncrement() == 0) {
                    this.f38534h.clear();
                }
            } else {
                this.f38537k = true;
                a();
            }
        }

        public void onNext(T t2) {
            if (t2 != null) {
                this.f38534h.offer(t2);
            }
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38535i, disposable)) {
                this.f38535i = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int b2 = queueDisposable.b(3);
                    if (b2 == 1) {
                        this.f38534h = queueDisposable;
                        this.f38537k = true;
                        this.f38528b.onSubscribe(this);
                        a();
                        return;
                    } else if (b2 == 2) {
                        this.f38534h = queueDisposable;
                        this.f38528b.onSubscribe(this);
                        return;
                    }
                }
                this.f38534h = new SpscLinkedArrayQueue(this.f38533g);
                this.f38528b.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapCompletable(Observable<T> observable, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i2) {
        this.f38524b = observable;
        this.f38525c = function;
        this.f38526d = errorMode;
        this.f38527e = i2;
    }

    /* access modifiers changed from: protected */
    public void c(CompletableObserver completableObserver) {
        if (!ScalarXMapZHelper.a(this.f38524b, this.f38525c, completableObserver)) {
            this.f38524b.subscribe(new ConcatMapCompletableObserver(completableObserver, this.f38525c, this.f38526d, this.f38527e));
        }
    }
}
