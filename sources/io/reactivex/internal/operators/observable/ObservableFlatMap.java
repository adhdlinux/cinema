package io.reactivex.internal.operators.observable;

import androidx.media3.exoplayer.mediacodec.f;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMap<T, U> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    final Function<? super T, ? extends ObservableSource<? extends U>> f38995c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f38996d;

    /* renamed from: e  reason: collision with root package name */
    final int f38997e;

    /* renamed from: f  reason: collision with root package name */
    final int f38998f;

    static final class InnerObserver<T, U> extends AtomicReference<Disposable> implements Observer<U> {

        /* renamed from: b  reason: collision with root package name */
        final long f38999b;

        /* renamed from: c  reason: collision with root package name */
        final MergeObserver<T, U> f39000c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f39001d;

        /* renamed from: e  reason: collision with root package name */
        volatile SimpleQueue<U> f39002e;

        /* renamed from: f  reason: collision with root package name */
        int f39003f;

        InnerObserver(MergeObserver<T, U> mergeObserver, long j2) {
            this.f38999b = j2;
            this.f39000c = mergeObserver;
        }

        public void a() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            this.f39001d = true;
            this.f39000c.d();
        }

        public void onError(Throwable th) {
            if (this.f39000c.f39013i.a(th)) {
                MergeObserver<T, U> mergeObserver = this.f39000c;
                if (!mergeObserver.f39008d) {
                    mergeObserver.c();
                }
                this.f39001d = true;
                this.f39000c.d();
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(U u2) {
            if (this.f39003f == 0) {
                this.f39000c.h(u2, this);
            } else {
                this.f39000c.d();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.f(this, disposable) && (disposable instanceof QueueDisposable)) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int b2 = queueDisposable.b(7);
                if (b2 == 1) {
                    this.f39003f = b2;
                    this.f39002e = queueDisposable;
                    this.f39001d = true;
                    this.f39000c.d();
                } else if (b2 == 2) {
                    this.f39003f = b2;
                    this.f39002e = queueDisposable;
                }
            }
        }
    }

    static final class MergeObserver<T, U> extends AtomicInteger implements Disposable, Observer<T> {

        /* renamed from: r  reason: collision with root package name */
        static final InnerObserver<?, ?>[] f39004r = new InnerObserver[0];

        /* renamed from: s  reason: collision with root package name */
        static final InnerObserver<?, ?>[] f39005s = new InnerObserver[0];

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super U> f39006b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super T, ? extends ObservableSource<? extends U>> f39007c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f39008d;

        /* renamed from: e  reason: collision with root package name */
        final int f39009e;

        /* renamed from: f  reason: collision with root package name */
        final int f39010f;

        /* renamed from: g  reason: collision with root package name */
        volatile SimplePlainQueue<U> f39011g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f39012h;

        /* renamed from: i  reason: collision with root package name */
        final AtomicThrowable f39013i = new AtomicThrowable();

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f39014j;

        /* renamed from: k  reason: collision with root package name */
        final AtomicReference<InnerObserver<?, ?>[]> f39015k;

        /* renamed from: l  reason: collision with root package name */
        Disposable f39016l;

        /* renamed from: m  reason: collision with root package name */
        long f39017m;

        /* renamed from: n  reason: collision with root package name */
        long f39018n;

        /* renamed from: o  reason: collision with root package name */
        int f39019o;

        /* renamed from: p  reason: collision with root package name */
        Queue<ObservableSource<? extends U>> f39020p;

        /* renamed from: q  reason: collision with root package name */
        int f39021q;

        MergeObserver(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z2, int i2, int i3) {
            this.f39006b = observer;
            this.f39007c = function;
            this.f39008d = z2;
            this.f39009e = i2;
            this.f39010f = i3;
            if (i2 != Integer.MAX_VALUE) {
                this.f39020p = new ArrayDeque(i2);
            }
            this.f39015k = new AtomicReference<>(f39004r);
        }

        /* access modifiers changed from: package-private */
        public boolean a(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver[] innerObserverArr2;
            do {
                innerObserverArr = (InnerObserver[]) this.f39015k.get();
                if (innerObserverArr == f39005s) {
                    innerObserver.a();
                    return false;
                }
                int length = innerObserverArr.length;
                innerObserverArr2 = new InnerObserver[(length + 1)];
                System.arraycopy(innerObserverArr, 0, innerObserverArr2, 0, length);
                innerObserverArr2[length] = innerObserver;
            } while (!f.a(this.f39015k, innerObserverArr, innerObserverArr2));
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            if (this.f39014j) {
                return true;
            }
            Throwable th = (Throwable) this.f39013i.get();
            if (this.f39008d || th == null) {
                return false;
            }
            c();
            Throwable b2 = this.f39013i.b();
            if (b2 != ExceptionHelper.f40066a) {
                this.f39006b.onError(b2);
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            InnerObserver<?, ?>[] innerObserverArr;
            this.f39016l.dispose();
            InnerObserver<?, ?>[] innerObserverArr2 = (InnerObserver[]) this.f39015k.get();
            InnerObserver<?, ?>[] innerObserverArr3 = f39005s;
            if (innerObserverArr2 == innerObserverArr3 || (innerObserverArr = (InnerObserver[]) this.f39015k.getAndSet(innerObserverArr3)) == innerObserverArr3) {
                return false;
            }
            for (InnerObserver<?, ?> a2 : innerObserverArr) {
                a2.a();
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (getAndIncrement() == 0) {
                e();
            }
        }

        public void dispose() {
            Throwable b2;
            if (!this.f39014j) {
                this.f39014j = true;
                if (c() && (b2 = this.f39013i.b()) != null && b2 != ExceptionHelper.f40066a) {
                    RxJavaPlugins.s(b2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            int i2;
            int i3;
            Observer<? super U> observer = this.f39006b;
            int i4 = 1;
            while (!b()) {
                SimplePlainQueue<U> simplePlainQueue = this.f39011g;
                if (simplePlainQueue != null) {
                    while (!b()) {
                        U poll = simplePlainQueue.poll();
                        if (poll != null) {
                            observer.onNext(poll);
                        }
                    }
                    return;
                }
                boolean z2 = this.f39012h;
                SimplePlainQueue<U> simplePlainQueue2 = this.f39011g;
                InnerObserver[] innerObserverArr = (InnerObserver[]) this.f39015k.get();
                int length = innerObserverArr.length;
                int i5 = 0;
                if (this.f39009e != Integer.MAX_VALUE) {
                    synchronized (this) {
                        i2 = this.f39020p.size();
                    }
                } else {
                    i2 = 0;
                }
                if (!z2 || !((simplePlainQueue2 == null || simplePlainQueue2.isEmpty()) && length == 0 && i2 == 0)) {
                    if (length != 0) {
                        long j2 = this.f39018n;
                        int i6 = this.f39019o;
                        if (length <= i6 || innerObserverArr[i6].f38999b != j2) {
                            if (length <= i6) {
                                i6 = 0;
                            }
                            for (int i7 = 0; i7 < length && innerObserverArr[i6].f38999b != j2; i7++) {
                                i6++;
                                if (i6 == length) {
                                    i6 = 0;
                                }
                            }
                            this.f39019o = i6;
                            this.f39018n = innerObserverArr[i6].f38999b;
                        }
                        int i8 = 0;
                        int i9 = 0;
                        while (i8 < length) {
                            if (!b()) {
                                InnerObserver innerObserver = innerObserverArr[i6];
                                SimpleQueue<U> simpleQueue = innerObserver.f39002e;
                                if (simpleQueue != null) {
                                    while (true) {
                                        try {
                                            U poll2 = simpleQueue.poll();
                                            if (poll2 == null) {
                                                break;
                                            }
                                            observer.onNext(poll2);
                                            if (b()) {
                                                return;
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.b(th);
                                            innerObserver.a();
                                            this.f39013i.a(th);
                                            if (!b()) {
                                                f(innerObserver);
                                                i9++;
                                                i3 = i6 + 1;
                                                if (i3 != length) {
                                                }
                                            } else {
                                                return;
                                            }
                                        }
                                    }
                                }
                                boolean z3 = innerObserver.f39001d;
                                SimpleQueue<U> simpleQueue2 = innerObserver.f39002e;
                                if (z3 && (simpleQueue2 == null || simpleQueue2.isEmpty())) {
                                    f(innerObserver);
                                    if (!b()) {
                                        i9++;
                                    } else {
                                        return;
                                    }
                                }
                                i3 = i6 + 1;
                                if (i3 != length) {
                                    i8++;
                                }
                                i3 = 0;
                                i8++;
                            } else {
                                return;
                            }
                        }
                        this.f39019o = i6;
                        this.f39018n = innerObserverArr[i6].f38999b;
                        i5 = i9;
                    }
                    if (i5 == 0) {
                        i4 = addAndGet(-i4);
                        if (i4 == 0) {
                            return;
                        }
                    } else if (this.f39009e != Integer.MAX_VALUE) {
                        while (true) {
                            int i10 = i5 - 1;
                            if (i5 == 0) {
                                continue;
                                break;
                            }
                            synchronized (this) {
                                ObservableSource poll3 = this.f39020p.poll();
                                if (poll3 == null) {
                                    this.f39021q--;
                                } else {
                                    g(poll3);
                                }
                            }
                            i5 = i10;
                        }
                        while (true) {
                        }
                    } else {
                        continue;
                    }
                } else {
                    Throwable b2 = this.f39013i.b();
                    if (b2 == ExceptionHelper.f40066a) {
                        return;
                    }
                    if (b2 == null) {
                        observer.onComplete();
                        return;
                    } else {
                        observer.onError(b2);
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void f(InnerObserver<T, U> innerObserver) {
            InnerObserver<T, U>[] innerObserverArr;
            InnerObserver<?, ?>[] innerObserverArr2;
            do {
                innerObserverArr = (InnerObserver[]) this.f39015k.get();
                int length = innerObserverArr.length;
                if (length != 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            i2 = -1;
                            break;
                        } else if (innerObserverArr[i2] == innerObserver) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 >= 0) {
                        if (length == 1) {
                            innerObserverArr2 = f39004r;
                        } else {
                            InnerObserver<?, ?>[] innerObserverArr3 = new InnerObserver[(length - 1)];
                            System.arraycopy(innerObserverArr, 0, innerObserverArr3, 0, i2);
                            System.arraycopy(innerObserverArr, i2 + 1, innerObserverArr3, i2, (length - i2) - 1);
                            innerObserverArr2 = innerObserverArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!f.a(this.f39015k, innerObserverArr, innerObserverArr2));
        }

        /* access modifiers changed from: package-private */
        public void g(ObservableSource<? extends U> observableSource) {
            boolean z2;
            while (observableSource instanceof Callable) {
                if (i((Callable) observableSource) && this.f39009e != Integer.MAX_VALUE) {
                    synchronized (this) {
                        observableSource = this.f39020p.poll();
                        if (observableSource == null) {
                            z2 = true;
                            this.f39021q--;
                        } else {
                            z2 = false;
                        }
                    }
                    if (z2) {
                        d();
                        return;
                    }
                } else {
                    return;
                }
            }
            long j2 = this.f39017m;
            this.f39017m = 1 + j2;
            InnerObserver innerObserver = new InnerObserver(this, j2);
            if (a(innerObserver)) {
                observableSource.subscribe(innerObserver);
            }
        }

        /* access modifiers changed from: package-private */
        public void h(U u2, InnerObserver<T, U> innerObserver) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                SimpleQueue simpleQueue = innerObserver.f39002e;
                if (simpleQueue == null) {
                    simpleQueue = new SpscLinkedArrayQueue(this.f39010f);
                    innerObserver.f39002e = simpleQueue;
                }
                simpleQueue.offer(u2);
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                this.f39006b.onNext(u2);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            e();
        }

        /* access modifiers changed from: package-private */
        public boolean i(Callable<? extends U> callable) {
            try {
                Object call = callable.call();
                if (call == null) {
                    return true;
                }
                if (get() != 0 || !compareAndSet(0, 1)) {
                    SimplePlainQueue<U> simplePlainQueue = this.f39011g;
                    if (simplePlainQueue == null) {
                        if (this.f39009e == Integer.MAX_VALUE) {
                            simplePlainQueue = new SpscLinkedArrayQueue<>(this.f39010f);
                        } else {
                            simplePlainQueue = new SpscArrayQueue<>(this.f39009e);
                        }
                        this.f39011g = simplePlainQueue;
                    }
                    if (!simplePlainQueue.offer(call)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return true;
                    } else if (getAndIncrement() != 0) {
                        return false;
                    }
                } else {
                    this.f39006b.onNext(call);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                }
                e();
                return true;
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f39013i.a(th);
                d();
                return true;
            }
        }

        public boolean isDisposed() {
            return this.f39014j;
        }

        public void onComplete() {
            if (!this.f39012h) {
                this.f39012h = true;
                d();
            }
        }

        public void onError(Throwable th) {
            if (this.f39012h) {
                RxJavaPlugins.s(th);
            } else if (this.f39013i.a(th)) {
                this.f39012h = true;
                d();
            } else {
                RxJavaPlugins.s(th);
            }
        }

        public void onNext(T t2) {
            if (!this.f39012h) {
                try {
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f39007c.apply(t2), "The mapper returned a null ObservableSource");
                    if (this.f39009e != Integer.MAX_VALUE) {
                        synchronized (this) {
                            int i2 = this.f39021q;
                            if (i2 == this.f39009e) {
                                this.f39020p.offer(observableSource);
                                return;
                            }
                            this.f39021q = i2 + 1;
                        }
                    }
                    g(observableSource);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f39016l.dispose();
                    onError(th);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39016l, disposable)) {
                this.f39016l = disposable;
                this.f39006b.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z2, int i2, int i3) {
        super(observableSource);
        this.f38995c = function;
        this.f38996d = z2;
        this.f38997e = i2;
        this.f38998f = i3;
    }

    public void subscribeActual(Observer<? super U> observer) {
        if (!ObservableScalarXMap.b(this.f38612b, observer, this.f38995c)) {
            this.f38612b.subscribe(new MergeObserver(observer, this.f38995c, this.f38996d, this.f38997e, this.f38998f));
        }
    }
}
