package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

public interface CopyableThreadContextElement<S> extends ThreadContextElement<S> {
    CopyableThreadContextElement<S> B();

    CoroutineContext i(CoroutineContext.Element element);
}
