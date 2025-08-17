package rx;

import java.util.Arrays;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.operators.OperatorConcat;
import rx.internal.operators.OperatorFilter;
import rx.internal.operators.OperatorMap;
import rx.internal.util.ScalarSynchronousObservable;
import rx.plugins.RxJavaObservableExecutionHook;
import rx.plugins.RxJavaPlugins;

public class Observable<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final RxJavaObservableExecutionHook f42062c = RxJavaPlugins.b().c();

    /* renamed from: d  reason: collision with root package name */
    private static final Observable<Object> f42063d = c(new OnSubscribe<Object>() {
    });

    /* renamed from: b  reason: collision with root package name */
    final OnSubscribe<T> f42064b;

    public interface OnSubscribe<T> extends Action1<Subscriber<? super T>> {
    }

    public interface Operator<R, T> extends Func1<Subscriber<? super R>, Subscriber<? super T>> {
    }

    protected Observable(OnSubscribe<T> onSubscribe) {
        this.f42064b = onSubscribe;
    }

    public static final <T> Observable<T> a(Observable<? extends Observable<? extends T>> observable) {
        return observable.h(OperatorConcat.a());
    }

    public static final <T> Observable<T> b(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return a(g(observable, observable2));
    }

    public static final <T> Observable<T> c(OnSubscribe<T> onSubscribe) {
        return new Observable<>(f42062c.a(onSubscribe));
    }

    public static final <T> Observable<T> e(Iterable<? extends T> iterable) {
        return c(new OnSubscribeFromIterable(iterable));
    }

    public static final <T> Observable<T> f(T t2) {
        return ScalarSynchronousObservable.k(t2);
    }

    public static final <T> Observable<T> g(T t2, T t3) {
        return e(Arrays.asList(new Object[]{t2, t3}));
    }

    public final Observable<T> d(Func1<? super T, Boolean> func1) {
        return h(new OperatorFilter(func1));
    }

    public final <R> Observable<R> h(final Operator<? extends R, ? super T> operator) {
        return new Observable<>(new OnSubscribe<R>() {
        });
    }

    public final <R> Observable<R> i(Func1<? super T, ? extends R> func1) {
        return h(new OperatorMap(func1));
    }

    public final Observable<T> j(T t2) {
        return b(f(t2), this);
    }
}
