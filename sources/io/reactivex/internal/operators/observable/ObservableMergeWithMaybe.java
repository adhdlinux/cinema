package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableMergeWithMaybe<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final MaybeSource<? extends T> f39251c;

    static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39252b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<Disposable> f39253c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        final OtherObserver<T> f39254d = new OtherObserver<>(this);

        /* renamed from: e  reason: collision with root package name */
        final AtomicThrowable f39255e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        volatile SimplePlainQueue<T> f39256f;

        /* renamed from: g  reason: collision with root package name */
        T f39257g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f39258h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f39259i;

        /* renamed from: j  reason: collision with root package name */
        volatile int f39260j;

        static final class OtherObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {

            /* renamed from: b  reason: collision with root package name */
            final MergeWithObserver<T> f39261b;

            OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.f39261b = mergeWithObserver;
            }

            public void onComplete() {
                this.f39261b.d();
            }

            public void onError(Throwable th) {
                this.f39261b.e(th);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.f(this, disposable);
            }

            public void onSuccess(T t2) {
                this.f39261b.f(t2);
            }
        }

        MergeWithObserver(Observer<? super T> observer) {
            this.f39252b = observer;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            T t2;
            boolean z2;
            Observer<? super T> observer = this.f39252b;
            int i2 = 1;
            while (!this.f39258h) {
                if (this.f39255e.get() != null) {
                    this.f39257g = null;
                    this.f39256f = null;
                    observer.onError(this.f39255e.b());
                    return;
                }
                int i3 = this.f39260j;
                if (i3 == 1) {
                    T t3 = this.f39257g;
                    this.f39257g = null;
                    this.f39260j = 2;
                    observer.onNext(t3);
                    i3 = 2;
                }
                boolean z3 = this.f39259i;
                SimplePlainQueue<T> simplePlainQueue = this.f39256f;
                if (simplePlainQueue != null) {
                    t2 = simplePlainQueue.poll();
                } else {
                    t2 = null;
                }
                if (t2 == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z3 && z2 && i3 == 2) {
                    this.f39256f = null;
                    observer.onComplete();
                    return;
                } else if (z2) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    observer.onNext(t2);
                }
            }
            this.f39257g = null;
            this.f39256f = null;
        }

        /* access modifiers changed from: package-private */
        public SimplePlainQueue<T> c() {
            SimplePlainQueue<T> simplePlainQueue = this.f39256f;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscLinkedArrayQueue spscLinkedArrayQueue = new SpscLinkedArrayQueue(Observable.bufferSize());
            this.f39256f = spscLinkedArrayQueue;
            return spscLinkedArrayQueue;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f39260j = 2;
            a();
        }

        public void dispose() {
            this.f39258h = true;
            DisposableHelper.a(this.f39253c);
            DisposableHelper.a(this.f39254d);
            if (getAndIncrement() == 0) {
                this.f39256f = null;
                this.f39257g = null;
            }
        }

        /* access modifiers changed from: package-private */
        public void e(Throwable th) {
            if (this.f39255e.a(th)) {
                DisposableHelper.a(this.f39253c);
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        /* access modifiers changed from: package-private */
        public void f(T t2) {
            if (compareAndSet(0, 1)) {
                this.f39252b.onNext(t2);
                this.f39260j = 2;
            } else {
                this.f39257g = t2;
                this.f39260j = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        public boolean isDisposed() {
            return DisposableHelper.b(this.f39253c.get());
        }

        public void onComplete() {
            this.f39259i = true;
            a();
        }

        public void onError(Throwable th) {
            if (this.f39255e.a(th)) {
                DisposableHelper.a(this.f39253c);
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(T t2) {
            if (compareAndSet(0, 1)) {
                this.f39252b.onNext(t2);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                c().offer(t2);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.f(this.f39253c, disposable);
        }
    }

    public ObservableMergeWithMaybe(Observable<T> observable, MaybeSource<? extends T> maybeSource) {
        super(observable);
        this.f39251c = maybeSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.onSubscribe(mergeWithObserver);
        this.f38612b.subscribe(mergeWithObserver);
        this.f39251c.a(mergeWithObserver.f39254d);
    }
}
