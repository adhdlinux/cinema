package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public abstract class AbstractCoroutineContextKey<B extends CoroutineContext.Element, E extends B> implements CoroutineContext.Key<E> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<CoroutineContext.Element, E> f40351b;

    /* renamed from: c  reason: collision with root package name */
    private final CoroutineContext.Key<?> f40352c;

    public AbstractCoroutineContextKey(CoroutineContext.Key<B> key, Function1<? super CoroutineContext.Element, ? extends E> function1) {
        Intrinsics.f(key, "baseKey");
        Intrinsics.f(function1, "safeCast");
        this.f40351b = function1;
        this.f40352c = key instanceof AbstractCoroutineContextKey ? ((AbstractCoroutineContextKey) key).f40352c : key;
    }

    public final boolean a(CoroutineContext.Key<?> key) {
        Intrinsics.f(key, "key");
        if (key == this || this.f40352c == key) {
            return true;
        }
        return false;
    }

    public final E b(CoroutineContext.Element element) {
        Intrinsics.f(element, "element");
        return (CoroutineContext.Element) this.f40351b.invoke(element);
    }
}
