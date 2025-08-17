package io.reactivex.internal.operators.observable;

import androidx.media3.exoplayer.mediacodec.f;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
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

public final class ObservableFlatMapSingle<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    final Function<? super T, ? extends SingleSource<? extends R>> f39055c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f39056d;

    static final class FlatMapSingleObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super R> f39057b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f39058c;

        /* renamed from: d  reason: collision with root package name */
        final CompositeDisposable f39059d = new CompositeDisposable();

        /* renamed from: e  reason: collision with root package name */
        final AtomicInteger f39060e = new AtomicInteger(1);

        /* renamed from: f  reason: collision with root package name */
        final AtomicThrowable f39061f = new AtomicThrowable();

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends SingleSource<? extends R>> f39062g;

        /* renamed from: h  reason: collision with root package name */
        final AtomicReference<SpscLinkedArrayQueue<R>> f39063h = new AtomicReference<>();

        /* renamed from: i  reason: collision with root package name */
        Disposable f39064i;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f39065j;

        final class InnerObserver extends AtomicReference<Disposable> implements SingleObserver<R>, Disposable {
            InnerObserver() {
            }

            public void dispose() {
                DisposableHelper.a(this);
            }

            public boolean isDisposed() {
                return DisposableHelper.b((Disposable) get());
            }

            public void onError(Throwable th) {
                FlatMapSingleObserver.this.e(this, th);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.f(this, disposable);
            }

            public void onSuccess(R r2) {
                FlatMapSingleObserver.this.f(this, r2);
            }
        }

        FlatMapSingleObserver(Observer<? super R> observer, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z2) {
            this.f39057b = observer;
            this.f39062g = function;
            this.f39058c = z2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f39063h.get();
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
            Observer<? super R> observer = this.f39057b;
            AtomicInteger atomicInteger = this.f39060e;
            AtomicReference<SpscLinkedArrayQueue<R>> atomicReference = this.f39063h;
            int i2 = 1;
            while (!this.f39065j) {
                if (this.f39058c || ((Throwable) this.f39061f.get()) == null) {
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
                        Throwable b2 = this.f39061f.b();
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
                    Throwable b3 = this.f39061f.b();
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
                SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = this.f39063h.get();
                if (spscLinkedArrayQueue2 != null) {
                    return spscLinkedArrayQueue2;
                }
                spscLinkedArrayQueue = new SpscLinkedArrayQueue<>(Observable.bufferSize());
            } while (!f.a(this.f39063h, (Object) null, spscLinkedArrayQueue));
            return spscLinkedArrayQueue;
        }

        public void dispose() {
            this.f39065j = true;
            this.f39064i.dispose();
            this.f39059d.dispose();
        }

        /* access modifiers changed from: package-private */
        public void e(FlatMapSingleObserver<T, R>.InnerObserver innerObserver, Throwable th) {
            this.f39059d.c(innerObserver);
            if (this.f39061f.a(th)) {
                if (!this.f39058c) {
                    this.f39064i.dispose();
                    this.f39059d.dispose();
                }
                this.f39060e.decrementAndGet();
                b();
                return;
            }
            RxJavaPlugins.s(th);
        }

        /* access modifiers changed from: package-private */
        public void f(FlatMapSingleObserver<T, R>.InnerObserver innerObserver, R r2) {
            this.f39059d.c(innerObserver);
            if (get() == 0) {
                boolean z2 = false;
                if (compareAndSet(0, 1)) {
                    this.f39057b.onNext(r2);
                    if (this.f39060e.decrementAndGet() == 0) {
                        z2 = true;
                    }
                    SpscLinkedArrayQueue spscLinkedArrayQueue = this.f39063h.get();
                    if (!z2 || (spscLinkedArrayQueue != null && !spscLinkedArrayQueue.isEmpty())) {
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        c();
                    }
                    Throwable b2 = this.f39061f.b();
                    if (b2 != null) {
                        this.f39057b.onError(b2);
                        return;
                    } else {
                        this.f39057b.onComplete();
                        return;
                    }
                }
            }
            SpscLinkedArrayQueue d2 = d();
            synchronized (d2) {
                d2.offer(r2);
            }
            this.f39060e.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            c();
        }

        public boolean isDisposed() {
            return this.f39065j;
        }

        public void onComplete() {
            this.f39060e.decrementAndGet();
            b();
        }

        public void onError(Throwable th) {
            this.f39060e.decrementAndGet();
            if (this.f39061f.a(th)) {
                if (!this.f39058c) {
                    this.f39059d.dispose();
                }
                b();
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(T t2) {
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.e(this.f39062g.apply(t2), "The mapper returned a null SingleSource");
                this.f39060e.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.f39065j && this.f39059d.b(innerObserver)) {
                    singleSource.a(innerObserver);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f39064i.dispose();
                onError(th);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39064i, disposable)) {
                this.f39064i = disposable;
                this.f39057b.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapSingle(ObservableSource<T> observableSource, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z2) {
        super(observableSource);
        this.f39055c = function;
        this.f39056d = z2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super R> observer) {
        this.f38612b.subscribe(new FlatMapSingleObserver(observer, this.f39055c, this.f39056d));
    }
}
