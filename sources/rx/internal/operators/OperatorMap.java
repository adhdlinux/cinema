package rx.internal.operators;

import rx.Observable;
import rx.functions.Func1;

public final class OperatorMap<T, R> implements Observable.Operator<R, T> {

    /* renamed from: a  reason: collision with root package name */
    private final Func1<? super T, ? extends R> f42081a;

    public OperatorMap(Func1<? super T, ? extends R> func1) {
        this.f42081a = func1;
    }
}
