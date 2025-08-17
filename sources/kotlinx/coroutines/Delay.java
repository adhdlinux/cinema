package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;

public interface Delay {

    public static final class DefaultImpls {
        public static DisposableHandle a(Delay delay, long j2, Runnable runnable, CoroutineContext coroutineContext) {
            return DefaultExecutorKt.a().A(j2, runnable, coroutineContext);
        }
    }

    DisposableHandle A(long j2, Runnable runnable, CoroutineContext coroutineContext);

    void k(long j2, CancellableContinuation<? super Unit> cancellableContinuation);
}
