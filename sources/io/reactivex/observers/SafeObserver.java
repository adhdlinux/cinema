package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class SafeObserver<T> implements Observer<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    final Observer<? super T> f40090b;

    /* renamed from: c  reason: collision with root package name */
    Disposable f40091c;

    /* renamed from: d  reason: collision with root package name */
    boolean f40092d;

    public SafeObserver(Observer<? super T> observer) {
        this.f40090b = observer;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f40090b.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f40090b.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            RxJavaPlugins.s(new CompositeException(nullPointerException, th2));
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f40092d = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f40090b.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f40090b.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            RxJavaPlugins.s(new CompositeException(nullPointerException, th2));
        }
    }

    public void dispose() {
        this.f40091c.dispose();
    }

    public boolean isDisposed() {
        return this.f40091c.isDisposed();
    }

    public void onComplete() {
        if (!this.f40092d) {
            this.f40092d = true;
            if (this.f40091c == null) {
                a();
                return;
            }
            try {
                this.f40090b.onComplete();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(th);
            }
        }
    }

    public void onError(Throwable th) {
        if (this.f40092d) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f40092d = true;
        if (this.f40091c == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.f40090b.onSubscribe(EmptyDisposable.INSTANCE);
                try {
                    this.f40090b.onError(new CompositeException(th, nullPointerException));
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    RxJavaPlugins.s(new CompositeException(th, nullPointerException, th2));
                }
            } catch (Throwable th3) {
                Exceptions.b(th3);
                RxJavaPlugins.s(new CompositeException(th, nullPointerException, th3));
            }
        } else {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.f40090b.onError(th);
            } catch (Throwable th4) {
                Exceptions.b(th4);
                RxJavaPlugins.s(new CompositeException(th, th4));
            }
        }
    }

    public void onNext(T t2) {
        if (!this.f40092d) {
            if (this.f40091c == null) {
                b();
            } else if (t2 == null) {
                NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                try {
                    this.f40091c.dispose();
                    onError(nullPointerException);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    onError(new CompositeException(nullPointerException, th));
                }
            } else {
                try {
                    this.f40090b.onNext(t2);
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    onError(new CompositeException(th, th2));
                }
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.h(this.f40091c, disposable)) {
            this.f40091c = disposable;
            try {
                this.f40090b.onSubscribe(this);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(new CompositeException(th, th));
            }
        }
    }
}
