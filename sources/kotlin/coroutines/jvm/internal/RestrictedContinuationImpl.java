package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

public abstract class RestrictedContinuationImpl extends BaseContinuationImpl {
    public RestrictedContinuationImpl(Continuation<Object> continuation) {
        super(continuation);
        boolean z2;
        if (continuation != null) {
            if (continuation.getContext() == EmptyCoroutineContext.f40358b) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    public CoroutineContext getContext() {
        return EmptyCoroutineContext.f40358b;
    }
}
