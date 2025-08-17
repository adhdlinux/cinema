package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class ConsumerSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    final Consumer<? super T> f38391b;

    /* renamed from: c  reason: collision with root package name */
    final Consumer<? super Throwable> f38392c;

    public ConsumerSingleObserver(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        this.f38391b = consumer;
        this.f38392c = consumer2;
    }

    public void dispose() {
        DisposableHelper.a(this);
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.f38392c.accept(th);
        } catch (Throwable th2) {
            Exceptions.b(th2);
            RxJavaPlugins.s(new CompositeException(th, th2));
        }
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.f(this, disposable);
    }

    public void onSuccess(T t2) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.f38391b.accept(t2);
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.s(th);
        }
    }
}
