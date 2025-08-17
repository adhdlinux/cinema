package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableReduceSeedSingle;
import java.util.concurrent.Callable;

public final class ObservableReduceWithSingle<T, R> extends Single<R> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<T> f39342b;

    /* renamed from: c  reason: collision with root package name */
    final Callable<R> f39343c;

    /* renamed from: d  reason: collision with root package name */
    final BiFunction<R, ? super T, R> f39344d;

    public ObservableReduceWithSingle(ObservableSource<T> observableSource, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        this.f39342b = observableSource;
        this.f39343c = callable;
        this.f39344d = biFunction;
    }

    /* access modifiers changed from: protected */
    public void j(SingleObserver<? super R> singleObserver) {
        try {
            this.f39342b.subscribe(new ObservableReduceSeedSingle.ReduceSeedObserver(singleObserver, this.f39344d, ObjectHelper.e(this.f39343c.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.f(th, singleObserver);
        }
    }
}
