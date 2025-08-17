package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class LambdaObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    final Consumer<? super T> f38411b;

    /* renamed from: c  reason: collision with root package name */
    final Consumer<? super Throwable> f38412c;

    /* renamed from: d  reason: collision with root package name */
    final Action f38413d;

    /* renamed from: e  reason: collision with root package name */
    final Consumer<? super Disposable> f38414e;

    public LambdaObserver(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Disposable> consumer3) {
        this.f38411b = consumer;
        this.f38412c = consumer2;
        this.f38413d = action;
        this.f38414e = consumer3;
    }

    public void dispose() {
        DisposableHelper.a(this);
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void onComplete() {
        if (!isDisposed()) {
            lazySet(DisposableHelper.DISPOSED);
            try {
                this.f38413d.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(th);
            }
        }
    }

    public void onError(Throwable th) {
        if (!isDisposed()) {
            lazySet(DisposableHelper.DISPOSED);
            try {
                this.f38412c.accept(th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                RxJavaPlugins.s(new CompositeException(th, th2));
            }
        } else {
            RxJavaPlugins.s(th);
        }
    }

    public void onNext(T t2) {
        if (!isDisposed()) {
            try {
                this.f38411b.accept(t2);
            } catch (Throwable th) {
                Exceptions.b(th);
                ((Disposable) get()).dispose();
                onError(th);
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.f(this, disposable)) {
            try {
                this.f38414e.accept(this);
            } catch (Throwable th) {
                Exceptions.b(th);
                disposable.dispose();
                onError(th);
            }
        }
    }
}
