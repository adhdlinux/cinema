package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

public final class GlobalScope implements CoroutineScope {

    /* renamed from: b  reason: collision with root package name */
    public static final GlobalScope f40653b = new GlobalScope();

    private GlobalScope() {
    }

    public CoroutineContext c() {
        return EmptyCoroutineContext.f40358b;
    }
}
