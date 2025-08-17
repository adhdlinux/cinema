package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class ObservableFromFuture<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    final Future<? extends T> f39078b;

    /* renamed from: c  reason: collision with root package name */
    final long f39079c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f39080d;

    public ObservableFromFuture(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        this.f39078b = future;
        this.f39079c = j2;
        this.f39080d = timeUnit;
    }

    public void subscribeActual(Observer<? super T> observer) {
        Object obj;
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (!deferredScalarDisposable.isDisposed()) {
            try {
                TimeUnit timeUnit = this.f39080d;
                if (timeUnit != null) {
                    obj = this.f39078b.get(this.f39079c, timeUnit);
                } else {
                    obj = this.f39078b.get();
                }
                deferredScalarDisposable.c(ObjectHelper.e(obj, "Future returned null"));
            } catch (Throwable th) {
                Exceptions.b(th);
                if (!deferredScalarDisposable.isDisposed()) {
                    observer.onError(th);
                }
            }
        }
    }
}
