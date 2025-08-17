package io.reactivex.internal.operators.observable;

import androidx.media3.exoplayer.mediacodec.f;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCache<T> extends AbstractObservableWithUpstream<T, T> implements Observer<T> {

    /* renamed from: l  reason: collision with root package name */
    static final CacheDisposable[] f38757l = new CacheDisposable[0];

    /* renamed from: m  reason: collision with root package name */
    static final CacheDisposable[] f38758m = new CacheDisposable[0];

    /* renamed from: c  reason: collision with root package name */
    final AtomicBoolean f38759c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    final int f38760d;

    /* renamed from: e  reason: collision with root package name */
    final AtomicReference<CacheDisposable<T>[]> f38761e;

    /* renamed from: f  reason: collision with root package name */
    volatile long f38762f;

    /* renamed from: g  reason: collision with root package name */
    final Node<T> f38763g;

    /* renamed from: h  reason: collision with root package name */
    Node<T> f38764h;

    /* renamed from: i  reason: collision with root package name */
    int f38765i;

    /* renamed from: j  reason: collision with root package name */
    Throwable f38766j;

    /* renamed from: k  reason: collision with root package name */
    volatile boolean f38767k;

    static final class CacheDisposable<T> extends AtomicInteger implements Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f38768b;

        /* renamed from: c  reason: collision with root package name */
        final ObservableCache<T> f38769c;

        /* renamed from: d  reason: collision with root package name */
        Node<T> f38770d;

        /* renamed from: e  reason: collision with root package name */
        int f38771e;

        /* renamed from: f  reason: collision with root package name */
        long f38772f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f38773g;

        CacheDisposable(Observer<? super T> observer, ObservableCache<T> observableCache) {
            this.f38768b = observer;
            this.f38769c = observableCache;
            this.f38770d = observableCache.f38763g;
        }

        public void dispose() {
            if (!this.f38773g) {
                this.f38773g = true;
                this.f38769c.c(this);
            }
        }

        public boolean isDisposed() {
            return this.f38773g;
        }
    }

    static final class Node<T> {

        /* renamed from: a  reason: collision with root package name */
        final T[] f38774a;

        /* renamed from: b  reason: collision with root package name */
        volatile Node<T> f38775b;

        Node(int i2) {
            this.f38774a = new Object[i2];
        }
    }

    public ObservableCache(Observable<T> observable, int i2) {
        super(observable);
        this.f38760d = i2;
        Node<T> node = new Node<>(i2);
        this.f38763g = node;
        this.f38764h = node;
        this.f38761e = new AtomicReference<>(f38757l);
    }

    /* access modifiers changed from: package-private */
    public void b(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f38761e.get();
            if (cacheDisposableArr != f38758m) {
                int length = cacheDisposableArr.length;
                cacheDisposableArr2 = new CacheDisposable[(length + 1)];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
                cacheDisposableArr2[length] = cacheDisposable;
            } else {
                return;
            }
        } while (!f.a(this.f38761e, cacheDisposableArr, cacheDisposableArr2));
    }

    /* access modifiers changed from: package-private */
    public void c(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f38761e.get();
            int length = cacheDisposableArr.length;
            if (length != 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (cacheDisposableArr[i2] == cacheDisposable) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        cacheDisposableArr2 = f38757l;
                    } else {
                        CacheDisposable[] cacheDisposableArr3 = new CacheDisposable[(length - 1)];
                        System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i2);
                        System.arraycopy(cacheDisposableArr, i2 + 1, cacheDisposableArr3, i2, (length - i2) - 1);
                        cacheDisposableArr2 = cacheDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!f.a(this.f38761e, cacheDisposableArr, cacheDisposableArr2));
    }

    /* access modifiers changed from: package-private */
    public void d(CacheDisposable<T> cacheDisposable) {
        boolean z2;
        if (cacheDisposable.getAndIncrement() == 0) {
            long j2 = cacheDisposable.f38772f;
            int i2 = cacheDisposable.f38771e;
            Node<T> node = cacheDisposable.f38770d;
            Observer<? super T> observer = cacheDisposable.f38768b;
            int i3 = this.f38760d;
            int i4 = 1;
            while (!cacheDisposable.f38773g) {
                boolean z3 = this.f38767k;
                if (this.f38762f == j2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z3 && z2) {
                    cacheDisposable.f38770d = null;
                    Throwable th = this.f38766j;
                    if (th != null) {
                        observer.onError(th);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                } else if (!z2) {
                    if (i2 == i3) {
                        node = node.f38775b;
                        i2 = 0;
                    }
                    observer.onNext(node.f38774a[i2]);
                    i2++;
                    j2++;
                } else {
                    cacheDisposable.f38772f = j2;
                    cacheDisposable.f38771e = i2;
                    cacheDisposable.f38770d = node;
                    i4 = cacheDisposable.addAndGet(-i4);
                    if (i4 == 0) {
                        return;
                    }
                }
            }
            cacheDisposable.f38770d = null;
        }
    }

    public void onComplete() {
        this.f38767k = true;
        for (CacheDisposable d2 : (CacheDisposable[]) this.f38761e.getAndSet(f38758m)) {
            d(d2);
        }
    }

    public void onError(Throwable th) {
        this.f38766j = th;
        this.f38767k = true;
        for (CacheDisposable d2 : (CacheDisposable[]) this.f38761e.getAndSet(f38758m)) {
            d(d2);
        }
    }

    public void onNext(T t2) {
        int i2 = this.f38765i;
        if (i2 == this.f38760d) {
            Node<T> node = new Node<>(i2);
            node.f38774a[0] = t2;
            this.f38765i = 1;
            this.f38764h.f38775b = node;
            this.f38764h = node;
        } else {
            this.f38764h.f38774a[i2] = t2;
            this.f38765i = i2 + 1;
        }
        this.f38762f++;
        for (CacheDisposable d2 : (CacheDisposable[]) this.f38761e.get()) {
            d(d2);
        }
    }

    public void onSubscribe(Disposable disposable) {
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        CacheDisposable cacheDisposable = new CacheDisposable(observer, this);
        observer.onSubscribe(cacheDisposable);
        b(cacheDisposable);
        if (this.f38759c.get() || !this.f38759c.compareAndSet(false, true)) {
            d(cacheDisposable);
        } else {
            this.f38612b.subscribe(this);
        }
    }
}
