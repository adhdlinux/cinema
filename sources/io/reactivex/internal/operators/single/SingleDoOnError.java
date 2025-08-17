package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

public final class SingleDoOnError<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    final SingleSource<T> f39893b;

    /* renamed from: c  reason: collision with root package name */
    final Consumer<? super Throwable> f39894c;

    final class DoOnError implements SingleObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        private final SingleObserver<? super T> f39895b;

        DoOnError(SingleObserver<? super T> singleObserver) {
            this.f39895b = singleObserver;
        }

        public void onError(Throwable th) {
            try {
                SingleDoOnError.this.f39894c.accept(th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f39895b.onError(th);
        }

        public void onSubscribe(Disposable disposable) {
            this.f39895b.onSubscribe(disposable);
        }

        public void onSuccess(T t2) {
            this.f39895b.onSuccess(t2);
        }
    }

    public SingleDoOnError(SingleSource<T> singleSource, Consumer<? super Throwable> consumer) {
        this.f39893b = singleSource;
        this.f39894c = consumer;
    }

    /* access modifiers changed from: protected */
    public void j(SingleObserver<? super T> singleObserver) {
        this.f39893b.a(new DoOnError(singleObserver));
    }
}
