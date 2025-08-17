package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableMergeWithSingle<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final SingleSource<? extends T> f39262c;

    static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39263b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<Disposable> f39264c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        final OtherObserver<T> f39265d = new OtherObserver<>(this);

        /* renamed from: e  reason: collision with root package name */
        final AtomicThrowable f39266e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        volatile SimplePlainQueue<T> f39267f;

        /* renamed from: g  reason: collision with root package name */
        T f39268g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f39269h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f39270i;

        /* renamed from: j  reason: collision with root package name */
        volatile int f39271j;

        static final class OtherObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {

            /* renamed from: b  reason: collision with root package name */
            final MergeWithObserver<T> f39272b;

            OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.f39272b = mergeWithObserver;
            }

            public void onError(Throwable th) {
                this.f39272b.d(th);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.f(this, disposable);
            }

            public void onSuccess(T t2) {
                this.f39272b.e(t2);
            }
        }

        MergeWithObserver(Observer<? super T> observer) {
            this.f39263b = observer;
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
            Observer<? super T> observer = this.f39263b;
            int i2 = 1;
            while (!this.f39269h) {
                if (this.f39266e.get() != null) {
                    this.f39268g = null;
                    this.f39267f = null;
                    observer.onError(this.f39266e.b());
                    return;
                }
                int i3 = this.f39271j;
                if (i3 == 1) {
                    T t3 = this.f39268g;
                    this.f39268g = null;
                    this.f39271j = 2;
                    observer.onNext(t3);
                    i3 = 2;
                }
                boolean z3 = this.f39270i;
                SimplePlainQueue<T> simplePlainQueue = this.f39267f;
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
                    this.f39267f = null;
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
            this.f39268g = null;
            this.f39267f = null;
        }

        /* access modifiers changed from: package-private */
        public SimplePlainQueue<T> c() {
            SimplePlainQueue<T> simplePlainQueue = this.f39267f;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscLinkedArrayQueue spscLinkedArrayQueue = new SpscLinkedArrayQueue(Observable.bufferSize());
            this.f39267f = spscLinkedArrayQueue;
            return spscLinkedArrayQueue;
        }

        /* access modifiers changed from: package-private */
        public void d(Throwable th) {
            if (this.f39266e.a(th)) {
                DisposableHelper.a(this.f39264c);
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void dispose() {
            this.f39269h = true;
            DisposableHelper.a(this.f39264c);
            DisposableHelper.a(this.f39265d);
            if (getAndIncrement() == 0) {
                this.f39267f = null;
                this.f39268g = null;
            }
        }

        /* access modifiers changed from: package-private */
        public void e(T t2) {
            if (compareAndSet(0, 1)) {
                this.f39263b.onNext(t2);
                this.f39271j = 2;
            } else {
                this.f39268g = t2;
                this.f39271j = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        public boolean isDisposed() {
            return DisposableHelper.b(this.f39264c.get());
        }

        public void onComplete() {
            this.f39270i = true;
            a();
        }

        public void onError(Throwable th) {
            if (this.f39266e.a(th)) {
                DisposableHelper.a(this.f39264c);
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(T t2) {
            if (compareAndSet(0, 1)) {
                this.f39263b.onNext(t2);
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
            DisposableHelper.f(this.f39264c, disposable);
        }
    }

    public ObservableMergeWithSingle(Observable<T> observable, SingleSource<? extends T> singleSource) {
        super(observable);
        this.f39262c = singleSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.onSubscribe(mergeWithObserver);
        this.f38612b.subscribe(mergeWithObserver);
        this.f39262c.a(mergeWithObserver.f39265d);
    }
}
