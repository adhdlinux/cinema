package kotlin;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

public final class DeepRecursiveFunction<T, R> {

    /* renamed from: a  reason: collision with root package name */
    private final Function3<DeepRecursiveScope<T, R>, T, Continuation<? super R>, Object> f40248a;

    public DeepRecursiveFunction(Function3<? super DeepRecursiveScope<T, R>, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        Intrinsics.f(function3, "block");
        this.f40248a = function3;
    }

    public final Function3<DeepRecursiveScope<T, R>, T, Continuation<? super R>, Object> a() {
        return this.f40248a;
    }
}
