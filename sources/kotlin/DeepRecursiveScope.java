package kotlin;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

public abstract class DeepRecursiveScope<T, R> {
    private DeepRecursiveScope() {
    }

    public /* synthetic */ DeepRecursiveScope(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Object a(T t2, Continuation<? super R> continuation);
}
