package kotlinx.coroutines;

import java.util.concurrent.Executor;

public final class ExecutorsKt {
    public static final Executor a(CoroutineDispatcher coroutineDispatcher) {
        Executor r02;
        ExecutorCoroutineDispatcher executorCoroutineDispatcher = coroutineDispatcher instanceof ExecutorCoroutineDispatcher ? (ExecutorCoroutineDispatcher) coroutineDispatcher : null;
        return (executorCoroutineDispatcher == null || (r02 = executorCoroutineDispatcher.r0()) == null) ? new DispatcherExecutor(coroutineDispatcher) : r02;
    }
}
