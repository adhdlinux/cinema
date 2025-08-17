package kotlin.coroutines;

import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

public final class EmptyCoroutineContext implements CoroutineContext, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final EmptyCoroutineContext f40358b = new EmptyCoroutineContext();

    private EmptyCoroutineContext() {
    }

    public <R> R fold(R r2, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        Intrinsics.f(function2, "operation");
        return r2;
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics.f(key, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        Intrinsics.f(key, "key");
        return this;
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        Intrinsics.f(coroutineContext, "context");
        return coroutineContext;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
