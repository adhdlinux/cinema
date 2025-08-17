package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class ForEachWhileObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    final Predicate<? super T> f38399b;

    /* renamed from: c  reason: collision with root package name */
    final Consumer<? super Throwable> f38400c;

    /* renamed from: d  reason: collision with root package name */
    final Action f38401d;

    /* renamed from: e  reason: collision with root package name */
    boolean f38402e;

    public ForEachWhileObserver(Predicate<? super T> predicate, Consumer<? super Throwable> consumer, Action action) {
        this.f38399b = predicate;
        this.f38400c = consumer;
        this.f38401d = action;
    }

    public void dispose() {
        DisposableHelper.a(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.b((Disposable) get());
    }

    public void onComplete() {
        if (!this.f38402e) {
            this.f38402e = true;
            try {
                this.f38401d.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(th);
            }
        }
    }

    public void onError(Throwable th) {
        if (this.f38402e) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f38402e = true;
        try {
            this.f38400c.accept(th);
        } catch (Throwable th2) {
            Exceptions.b(th2);
            RxJavaPlugins.s(new CompositeException(th, th2));
        }
    }

    public void onNext(T t2) {
        if (!this.f38402e) {
            try {
                if (!this.f38399b.test(t2)) {
                    dispose();
                    onComplete();
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                dispose();
                onError(th);
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.f(this, disposable);
    }
}
