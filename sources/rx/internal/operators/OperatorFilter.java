package rx.internal.operators;

import rx.Observable;
import rx.functions.Func1;

public final class OperatorFilter<T> implements Observable.Operator<T, T> {

    /* renamed from: a  reason: collision with root package name */
    private final Func1<? super T, Boolean> f42080a;

    public OperatorFilter(Func1<? super T, Boolean> func1) {
        this.f42080a = func1;
    }
}
