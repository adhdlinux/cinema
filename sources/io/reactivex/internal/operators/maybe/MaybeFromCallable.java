package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class MaybeFromCallable<T> extends Maybe<T> implements Callable<T> {

    /* renamed from: b  reason: collision with root package name */
    final Callable<? extends T> f38521b;

    public MaybeFromCallable(Callable<? extends T> callable) {
        this.f38521b = callable;
    }

    public T call() throws Exception {
        return this.f38521b.call();
    }

    /* access modifiers changed from: protected */
    public void f(MaybeObserver<? super T> maybeObserver) {
        Disposable b2 = Disposables.b();
        maybeObserver.onSubscribe(b2);
        if (!b2.isDisposed()) {
            try {
                Object call = this.f38521b.call();
                if (b2.isDisposed()) {
                    return;
                }
                if (call == null) {
                    maybeObserver.onComplete();
                } else {
                    maybeObserver.onSuccess(call);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                if (!b2.isDisposed()) {
                    maybeObserver.onError(th);
                } else {
                    RxJavaPlugins.s(th);
                }
            }
        }
    }
}
