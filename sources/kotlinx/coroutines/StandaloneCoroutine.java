package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;

class StandaloneCoroutine extends AbstractCoroutine<Unit> {
    public StandaloneCoroutine(CoroutineContext coroutineContext, boolean z2) {
        super(coroutineContext, true, z2);
    }

    /* access modifiers changed from: protected */
    public boolean P(Throwable th) {
        CoroutineExceptionHandlerKt.a(getContext(), th);
        return true;
    }
}
