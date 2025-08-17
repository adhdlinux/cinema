package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.plugins.RxJavaPlugins;

public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {

    /* renamed from: b  reason: collision with root package name */
    protected final Observer<? super T> f38393b;

    /* renamed from: c  reason: collision with root package name */
    protected T f38394c;

    public DeferredScalarDisposable(Observer<? super T> observer) {
        this.f38393b = observer;
    }

    public final void a() {
        if ((get() & 54) == 0) {
            lazySet(2);
            this.f38393b.onComplete();
        }
    }

    public final int b(int i2) {
        if ((i2 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final void c(T t2) {
        int i2 = get();
        if ((i2 & 54) == 0) {
            Observer<? super T> observer = this.f38393b;
            if (i2 == 8) {
                this.f38394c = t2;
                lazySet(16);
                observer.onNext(null);
            } else {
                lazySet(2);
                observer.onNext(t2);
            }
            if (get() != 4) {
                observer.onComplete();
            }
        }
    }

    public final void clear() {
        lazySet(32);
        this.f38394c = null;
    }

    public final void d(Throwable th) {
        if ((get() & 54) != 0) {
            RxJavaPlugins.s(th);
            return;
        }
        lazySet(2);
        this.f38393b.onError(th);
    }

    public void dispose() {
        set(4);
        this.f38394c = null;
    }

    public final boolean isDisposed() {
        return get() == 4;
    }

    public final boolean isEmpty() {
        return get() != 16;
    }

    public final T poll() throws Exception {
        if (get() != 16) {
            return null;
        }
        T t2 = this.f38394c;
        this.f38394c = null;
        lazySet(32);
        return t2;
    }
}
