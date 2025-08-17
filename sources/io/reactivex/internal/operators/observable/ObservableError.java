package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class ObservableError<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    final Callable<? extends Throwable> f38992b;

    public ObservableError(Callable<? extends Throwable> callable) {
        this.f38992b = callable;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            th = (Throwable) ObjectHelper.e(this.f38992b.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            Exceptions.b(th);
        }
        EmptyDisposable.e(th, observer);
    }
}
