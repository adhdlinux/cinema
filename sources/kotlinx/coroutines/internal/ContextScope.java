package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;

public final class ContextScope implements CoroutineScope {

    /* renamed from: b  reason: collision with root package name */
    private final CoroutineContext f40724b;

    public ContextScope(CoroutineContext coroutineContext) {
        this.f40724b = coroutineContext;
    }

    public CoroutineContext c() {
        return this.f40724b;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + c() + ')';
    }
}
