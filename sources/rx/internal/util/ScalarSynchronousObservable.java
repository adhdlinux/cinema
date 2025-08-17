package rx.internal.util;

import rx.Observable;

public final class ScalarSynchronousObservable<T> extends Observable<T> {

    /* renamed from: e  reason: collision with root package name */
    private final T f42092e;

    protected ScalarSynchronousObservable(final T t2) {
        super(new Observable.OnSubscribe<T>() {
        });
        this.f42092e = t2;
    }

    public static final <T> ScalarSynchronousObservable<T> k(T t2) {
        return new ScalarSynchronousObservable<>(t2);
    }
}
