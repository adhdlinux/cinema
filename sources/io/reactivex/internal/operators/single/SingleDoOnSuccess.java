package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

public final class SingleDoOnSuccess<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    final SingleSource<T> f39897b;

    /* renamed from: c  reason: collision with root package name */
    final Consumer<? super T> f39898c;

    final class DoOnSuccess implements SingleObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        final SingleObserver<? super T> f39899b;

        DoOnSuccess(SingleObserver<? super T> singleObserver) {
            this.f39899b = singleObserver;
        }

        public void onError(Throwable th) {
            this.f39899b.onError(th);
        }

        public void onSubscribe(Disposable disposable) {
            this.f39899b.onSubscribe(disposable);
        }

        public void onSuccess(T t2) {
            try {
                SingleDoOnSuccess.this.f39898c.accept(t2);
                this.f39899b.onSuccess(t2);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f39899b.onError(th);
            }
        }
    }

    public SingleDoOnSuccess(SingleSource<T> singleSource, Consumer<? super T> consumer) {
        this.f39897b = singleSource;
        this.f39898c = consumer;
    }

    /* access modifiers changed from: protected */
    public void j(SingleObserver<? super T> singleObserver) {
        this.f39897b.a(new DoOnSuccess(singleObserver));
    }
}
