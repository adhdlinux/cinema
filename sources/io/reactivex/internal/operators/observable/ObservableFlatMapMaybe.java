package io.reactivex.internal.operators.observable;

import androidx.media3.exoplayer.mediacodec.f;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMapMaybe<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    final Function<? super T, ? extends MaybeSource<? extends R>> f39043c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f39044d;

    static final class FlatMapMaybeObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super R> f39045b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f39046c;

        /* renamed from: d  reason: collision with root package name */
        final CompositeDisposable f39047d = new CompositeDisposable();

        /* renamed from: e  reason: collision with root package name */
        final AtomicInteger f39048e = new AtomicInteger(1);

        /* renamed from: f  reason: collision with root package name */
        final AtomicThrowable f39049f = new AtomicThrowable();

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends MaybeSource<? extends R>> f39050g;

        /* renamed from: h  reason: collision with root package name */
        final AtomicReference<SpscLinkedArrayQueue<R>> f39051h = new AtomicReference<>();

        /* renamed from: i  reason: collision with root package name */
        Disposable f39052i;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f39053j;

        final class InnerObserver extends AtomicReference<Disposable> implements MaybeObserver<R>, Disposable {
            InnerObserver() {
            }

            public void dispose() {
                DisposableHelper.a(this);
            }

            public boolean isDisposed() {
                return DisposableHelper.b((Disposable) get());
            }

            public void onComplete() {
                FlatMapMaybeObserver.this.e(this);
            }

            public void onError(Throwable th) {
                FlatMapMaybeObserver.this.f(this, th);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.f(this, disposable);
            }

            public void onSuccess(R r2) {
                FlatMapMaybeObserver.this.g(this, r2);
            }
        }

        FlatMapMaybeObserver(Observer<? super R> observer, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z2) {
            this.f39045b = observer;
            this.f39050g = function;
            this.f39046c = z2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f39051h.get();
            if (spscLinkedArrayQueue != null) {
                spscLinkedArrayQueue.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (getAndIncrement() == 0) {
                c();
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            boolean z2;
            Object obj;
            Observer<? super R> observer = this.f39045b;
            AtomicInteger atomicInteger = this.f39048e;
            AtomicReference<SpscLinkedArrayQueue<R>> atomicReference = this.f39051h;
            int i2 = 1;
            while (!this.f39053j) {
                if (this.f39046c || ((Throwable) this.f39049f.get()) == null) {
                    boolean z3 = false;
                    if (atomicInteger.get() == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    SpscLinkedArrayQueue spscLinkedArrayQueue = atomicReference.get();
                    if (spscLinkedArrayQueue != null) {
                        obj = spscLinkedArrayQueue.poll();
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        z3 = true;
                    }
                    if (z2 && z3) {
                        Throwable b2 = this.f39049f.b();
                        if (b2 != null) {
                            observer.onError(b2);
                            return;
                        } else {
                            observer.onComplete();
                            return;
                        }
                    } else if (z3) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        observer.onNext(obj);
                    }
                } else {
                    Throwable b3 = this.f39049f.b();
                    a();
                    observer.onError(b3);
                    return;
                }
            }
            a();
        }

        /* access modifiers changed from: package-private */
        public SpscLinkedArrayQueue<R> d() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue;
            do {
                SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = this.f39051h.get();
                if (spscLinkedArrayQueue2 != null) {
                    return spscLinkedArrayQueue2;
                }
                spscLinkedArrayQueue = new SpscLinkedArrayQueue<>(Observable.bufferSize());
            } while (!f.a(this.f39051h, (Object) null, spscLinkedArrayQueue));
            return spscLinkedArrayQueue;
        }

        public void dispose() {
            this.f39053j = true;
            this.f39052i.dispose();
            this.f39047d.dispose();
        }

        /* access modifiers changed from: package-private */
        public void e(FlatMapMaybeObserver<T, R>.InnerObserver innerObserver) {
            this.f39047d.c(innerObserver);
            if (get() == 0) {
                boolean z2 = false;
                if (compareAndSet(0, 1)) {
                    if (this.f39048e.decrementAndGet() == 0) {
                        z2 = true;
                    }
                    SpscLinkedArrayQueue spscLinkedArrayQueue = this.f39051h.get();
                    if (z2 && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                        Throwable b2 = this.f39049f.b();
                        if (b2 != null) {
                            this.f39045b.onError(b2);
                            return;
                        } else {
                            this.f39045b.onComplete();
                            return;
                        }
                    } else if (decrementAndGet() != 0) {
                        c();
                        return;
                    } else {
                        return;
                    }
                }
            }
            this.f39048e.decrementAndGet();
            b();
        }

        /* access modifiers changed from: package-private */
        public void f(FlatMapMaybeObserver<T, R>.InnerObserver innerObserver, Throwable th) {
            this.f39047d.c(innerObserver);
            if (this.f39049f.a(th)) {
                if (!this.f39046c) {
                    this.f39052i.dispose();
                    this.f39047d.dispose();
                }
                this.f39048e.decrementAndGet();
                b();
                return;
            }
            RxJavaPlugins.s(th);
        }

        /* access modifiers changed from: package-private */
        public void g(FlatMapMaybeObserver<T, R>.InnerObserver innerObserver, R r2) {
            this.f39047d.c(innerObserver);
            if (get() == 0) {
                boolean z2 = false;
                if (compareAndSet(0, 1)) {
                    this.f39045b.onNext(r2);
                    if (this.f39048e.decrementAndGet() == 0) {
                        z2 = true;
                    }
                    SpscLinkedArrayQueue spscLinkedArrayQueue = this.f39051h.get();
                    if (!z2 || (spscLinkedArrayQueue != null && !spscLinkedArrayQueue.isEmpty())) {
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        c();
                    }
                    Throwable b2 = this.f39049f.b();
                    if (b2 != null) {
                        this.f39045b.onError(b2);
                        return;
                    } else {
                        this.f39045b.onComplete();
                        return;
                    }
                }
            }
            SpscLinkedArrayQueue d2 = d();
            synchronized (d2) {
                d2.offer(r2);
            }
            this.f39048e.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            c();
        }

        public boolean isDisposed() {
            return this.f39053j;
        }

        public void onComplete() {
            this.f39048e.decrementAndGet();
            b();
        }

        public void onError(Throwable th) {
            this.f39048e.decrementAndGet();
            if (this.f39049f.a(th)) {
                if (!this.f39046c) {
                    this.f39047d.dispose();
                }
                b();
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(T t2) {
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.e(this.f39050g.apply(t2), "The mapper returned a null MaybeSource");
                this.f39048e.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.f39053j && this.f39047d.b(innerObserver)) {
                    maybeSource.a(innerObserver);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f39052i.dispose();
                onError(th);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39052i, disposable)) {
                this.f39052i = disposable;
                this.f39045b.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapMaybe(ObservableSource<T> observableSource, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z2) {
        super(observableSource);
        this.f39043c = function;
        this.f39044d = z2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super R> observer) {
        this.f38612b.subscribe(new FlatMapMaybeObserver(observer, this.f39043c, this.f39044d));
    }
}
