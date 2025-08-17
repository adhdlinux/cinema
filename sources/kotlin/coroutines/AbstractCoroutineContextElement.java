package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

public abstract class AbstractCoroutineContextElement implements CoroutineContext.Element {
    private final CoroutineContext.Key<?> key;

    public AbstractCoroutineContextElement(CoroutineContext.Key<?> key2) {
        Intrinsics.f(key2, "key");
        this.key = key2;
    }

    public <R> R fold(R r2, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return CoroutineContext.Element.DefaultImpls.a(this, r2, function2);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key2) {
        return CoroutineContext.Element.DefaultImpls.b(this, key2);
    }

    public CoroutineContext.Key<?> getKey() {
        return this.key;
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key2) {
        return CoroutineContext.Element.DefaultImpls.c(this, key2);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.Element.DefaultImpls.d(this, coroutineContext);
    }
}
