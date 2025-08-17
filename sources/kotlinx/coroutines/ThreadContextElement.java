package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

public interface ThreadContextElement<S> extends CoroutineContext.Element {
    void D(CoroutineContext coroutineContext, S s2);

    S j0(CoroutineContext coroutineContext);
}
