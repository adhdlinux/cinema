package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeCallbackObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    final Consumer<? super T> f38518b;

    /* renamed from: c  reason: collision with root package name */
    final Consumer<? super Throwable> f38519c;

    /* renamed from: d  reason: collision with root package name */
    final Action f38520d;

    public MaybeCallbackObserver(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        this.f38518b = consumer;
        this.f38519c = consumer2;
        this.f38520d = action;
    }

    public void dispose() {
        DisposableHelper.a(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.b((Disposable) get());
    }

    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.f38520d.run();
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.s(th);
        }
    }

    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.f38519c.accept(th);
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
            this.f38518b.accept(t2);
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.s(th);
        }
    }
}
