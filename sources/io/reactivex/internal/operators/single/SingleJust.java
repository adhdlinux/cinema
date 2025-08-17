package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposables;

public final class SingleJust<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    final T f39901b;

    public SingleJust(T t2) {
        this.f39901b = t2;
    }

    /* access modifiers changed from: protected */
    public void j(SingleObserver<? super T> singleObserver) {
        singleObserver.onSubscribe(Disposables.a());
        singleObserver.onSuccess(this.f39901b);
    }
}
