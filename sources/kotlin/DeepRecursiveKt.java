package kotlin;

import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

public final class DeepRecursiveKt {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Object f40249a = Result.b(IntrinsicsKt__IntrinsicsKt.e());

    static {
        Result.Companion companion = Result.f40263c;
    }

    public static final <T, R> R b(DeepRecursiveFunction<T, R> deepRecursiveFunction, T t2) {
        Intrinsics.f(deepRecursiveFunction, "<this>");
        return new DeepRecursiveScopeImpl(deepRecursiveFunction.a(), t2).c();
    }
}
