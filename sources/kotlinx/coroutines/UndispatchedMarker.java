package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

final class UndispatchedMarker implements CoroutineContext.Element, CoroutineContext.Key<UndispatchedMarker> {

    /* renamed from: b  reason: collision with root package name */
    public static final UndispatchedMarker f40696b = new UndispatchedMarker();

    private UndispatchedMarker() {
    }

    public <R> R fold(R r2, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return CoroutineContext.Element.DefaultImpls.a(this, r2, function2);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return CoroutineContext.Element.DefaultImpls.b(this, key);
    }

    public CoroutineContext.Key<?> getKey() {
        return this;
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return CoroutineContext.Element.DefaultImpls.c(this, key);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.Element.DefaultImpls.d(this, coroutineContext);
    }
}
