package rx.internal.operators;

import rx.Observable;

public final class OnSubscribeFromIterable<T> implements Observable.OnSubscribe<T> {

    /* renamed from: b  reason: collision with root package name */
    final Iterable<? extends T> f42078b;

    public OnSubscribeFromIterable(Iterable<? extends T> iterable) {
        if (iterable != null) {
            this.f42078b = iterable;
            return;
        }
        throw new NullPointerException("iterable must not be null");
    }
}
