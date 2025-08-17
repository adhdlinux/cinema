package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableFromCallable<T> extends Observable<T> implements Callable<T> {

    /* renamed from: b  reason: collision with root package name */
    final Callable<? extends T> f39077b;

    public ObservableFromCallable(Callable<? extends T> callable) {
        this.f39077b = callable;
    }

    public T call() throws Exception {
        return ObjectHelper.e(this.f39077b.call(), "The callable returned a null value");
    }

    public void subscribeActual(Observer<? super T> observer) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (!deferredScalarDisposable.isDisposed()) {
            try {
                deferredScalarDisposable.c(ObjectHelper.e(this.f39077b.call(), "Callable returned null"));
            } catch (Throwable th) {
                Exceptions.b(th);
                if (!deferredScalarDisposable.isDisposed()) {
                    observer.onError(th);
                } else {
                    RxJavaPlugins.s(th);
                }
            }
        }
    }
}
