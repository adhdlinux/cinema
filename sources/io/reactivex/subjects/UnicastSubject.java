package io.reactivex.subjects;

import androidx.media3.exoplayer.mediacodec.f;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class UnicastSubject<T> extends Subject<T> {

    /* renamed from: b  reason: collision with root package name */
    final SpscLinkedArrayQueue<T> f40166b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<Observer<? super T>> f40167c;

    /* renamed from: d  reason: collision with root package name */
    final AtomicReference<Runnable> f40168d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f40169e;

    /* renamed from: f  reason: collision with root package name */
    volatile boolean f40170f;

    /* renamed from: g  reason: collision with root package name */
    volatile boolean f40171g;

    /* renamed from: h  reason: collision with root package name */
    Throwable f40172h;

    /* renamed from: i  reason: collision with root package name */
    final AtomicBoolean f40173i;

    /* renamed from: j  reason: collision with root package name */
    final BasicIntQueueDisposable<T> f40174j;

    /* renamed from: k  reason: collision with root package name */
    boolean f40175k;

    final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        UnicastQueueDisposable() {
        }

        public int b(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            UnicastSubject.this.f40175k = true;
            return 2;
        }

        public void clear() {
            UnicastSubject.this.f40166b.clear();
        }

        public void dispose() {
            if (!UnicastSubject.this.f40170f) {
                UnicastSubject.this.f40170f = true;
                UnicastSubject.this.f();
                UnicastSubject.this.f40167c.lazySet((Object) null);
                if (UnicastSubject.this.f40174j.getAndIncrement() == 0) {
                    UnicastSubject.this.f40167c.lazySet((Object) null);
                    UnicastSubject.this.f40166b.clear();
                }
            }
        }

        public boolean isDisposed() {
            return UnicastSubject.this.f40170f;
        }

        public boolean isEmpty() {
            return UnicastSubject.this.f40166b.isEmpty();
        }

        public T poll() throws Exception {
            return UnicastSubject.this.f40166b.poll();
        }
    }

    UnicastSubject(int i2, boolean z2) {
        this.f40166b = new SpscLinkedArrayQueue<>(ObjectHelper.f(i2, "capacityHint"));
        this.f40168d = new AtomicReference<>();
        this.f40169e = z2;
        this.f40167c = new AtomicReference<>();
        this.f40173i = new AtomicBoolean();
        this.f40174j = new UnicastQueueDisposable();
    }

    public static <T> UnicastSubject<T> c() {
        return new UnicastSubject<>(Observable.bufferSize(), true);
    }

    public static <T> UnicastSubject<T> d(int i2) {
        return new UnicastSubject<>(i2, true);
    }

    public static <T> UnicastSubject<T> e(int i2, Runnable runnable) {
        return new UnicastSubject<>(i2, runnable, true);
    }

    /* access modifiers changed from: package-private */
    public void f() {
        Runnable runnable = this.f40168d.get();
        if (runnable != null && f.a(this.f40168d, runnable, (Object) null)) {
            runnable.run();
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.f40174j.getAndIncrement() == 0) {
            Observer observer = this.f40167c.get();
            int i2 = 1;
            while (observer == null) {
                i2 = this.f40174j.addAndGet(-i2);
                if (i2 != 0) {
                    observer = this.f40167c.get();
                } else {
                    return;
                }
            }
            if (this.f40175k) {
                h(observer);
            } else {
                i(observer);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h(Observer<? super T> observer) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f40166b;
        int i2 = 1;
        boolean z2 = !this.f40169e;
        while (!this.f40170f) {
            boolean z3 = this.f40171g;
            if (!z2 || !z3 || !k(spscLinkedArrayQueue, observer)) {
                observer.onNext(null);
                if (z3) {
                    j(observer);
                    return;
                }
                i2 = this.f40174j.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            } else {
                return;
            }
        }
        this.f40167c.lazySet((Object) null);
        spscLinkedArrayQueue.clear();
    }

    /* access modifiers changed from: package-private */
    public void i(Observer<? super T> observer) {
        boolean z2;
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f40166b;
        boolean z3 = !this.f40169e;
        boolean z4 = true;
        int i2 = 1;
        while (!this.f40170f) {
            boolean z5 = this.f40171g;
            T poll = this.f40166b.poll();
            if (poll == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z5) {
                if (z3 && z4) {
                    if (!k(spscLinkedArrayQueue, observer)) {
                        z4 = false;
                    } else {
                        return;
                    }
                }
                if (z2) {
                    j(observer);
                    return;
                }
            }
            if (z2) {
                i2 = this.f40174j.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            } else {
                observer.onNext(poll);
            }
        }
        this.f40167c.lazySet((Object) null);
        spscLinkedArrayQueue.clear();
    }

    /* access modifiers changed from: package-private */
    public void j(Observer<? super T> observer) {
        this.f40167c.lazySet((Object) null);
        Throwable th = this.f40172h;
        if (th != null) {
            observer.onError(th);
        } else {
            observer.onComplete();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean k(SimpleQueue<T> simpleQueue, Observer<? super T> observer) {
        Throwable th = this.f40172h;
        if (th == null) {
            return false;
        }
        this.f40167c.lazySet((Object) null);
        simpleQueue.clear();
        observer.onError(th);
        return true;
    }

    public void onComplete() {
        if (!this.f40171g && !this.f40170f) {
            this.f40171g = true;
            f();
            g();
        }
    }

    public void onError(Throwable th) {
        ObjectHelper.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f40171g || this.f40170f) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f40172h = th;
        this.f40171g = true;
        f();
        g();
    }

    public void onNext(T t2) {
        ObjectHelper.e(t2, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f40171g && !this.f40170f) {
            this.f40166b.offer(t2);
            g();
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f40171g || this.f40170f) {
            disposable.dispose();
        }
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        if (this.f40173i.get() || !this.f40173i.compareAndSet(false, true)) {
            EmptyDisposable.e(new IllegalStateException("Only a single observer allowed."), observer);
            return;
        }
        observer.onSubscribe(this.f40174j);
        this.f40167c.lazySet(observer);
        if (this.f40170f) {
            this.f40167c.lazySet((Object) null);
        } else {
            g();
        }
    }

    UnicastSubject(int i2, Runnable runnable, boolean z2) {
        this.f40166b = new SpscLinkedArrayQueue<>(ObjectHelper.f(i2, "capacityHint"));
        this.f40168d = new AtomicReference<>(ObjectHelper.e(runnable, "onTerminate"));
        this.f40169e = z2;
        this.f40167c = new AtomicReference<>();
        this.f40173i = new AtomicBoolean();
        this.f40174j = new UnicastQueueDisposable();
    }
}
