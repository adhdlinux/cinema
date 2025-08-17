package rx.internal.operators;

import rx.Observable;

public final class OperatorConcat<T> implements Observable.Operator<T, Observable<? extends T>> {

    private static final class Holder {

        /* renamed from: a  reason: collision with root package name */
        static final OperatorConcat<Object> f42079a = new OperatorConcat<>();

        private Holder() {
        }
    }

    public static <T> OperatorConcat<T> a() {
        return Holder.f42079a;
    }

    private OperatorConcat() {
    }
}
