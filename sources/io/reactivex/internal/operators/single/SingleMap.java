package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;

public final class SingleMap<T, R> extends Single<R> {

    /* renamed from: b  reason: collision with root package name */
    final SingleSource<? extends T> f39902b;

    /* renamed from: c  reason: collision with root package name */
    final Function<? super T, ? extends R> f39903c;

    static final class MapSingleObserver<T, R> implements SingleObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        final SingleObserver<? super R> f39904b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super T, ? extends R> f39905c;

        MapSingleObserver(SingleObserver<? super R> singleObserver, Function<? super T, ? extends R> function) {
            this.f39904b = singleObserver;
            this.f39905c = function;
        }

        public void onError(Throwable th) {
            this.f39904b.onError(th);
        }

        public void onSubscribe(Disposable disposable) {
            this.f39904b.onSubscribe(disposable);
        }

        public void onSuccess(T t2) {
            try {
                this.f39904b.onSuccess(ObjectHelper.e(this.f39905c.apply(t2), "The mapper function returned a null value."));
            } catch (Throwable th) {
                Exceptions.b(th);
                onError(th);
            }
        }
    }

    public SingleMap(SingleSource<? extends T> singleSource, Function<? super T, ? extends R> function) {
        this.f39902b = singleSource;
        this.f39903c = function;
    }

    /* access modifiers changed from: protected */
    public void j(SingleObserver<? super R> singleObserver) {
        this.f39902b.a(new MapSingleObserver(singleObserver, this.f39903c));
    }
}
