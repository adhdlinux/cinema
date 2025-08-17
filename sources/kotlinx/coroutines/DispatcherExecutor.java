package kotlinx.coroutines;

import java.util.concurrent.Executor;
import kotlin.coroutines.EmptyCoroutineContext;

final class DispatcherExecutor implements Executor {

    /* renamed from: b  reason: collision with root package name */
    public final CoroutineDispatcher f40629b;

    public DispatcherExecutor(CoroutineDispatcher coroutineDispatcher) {
        this.f40629b = coroutineDispatcher;
    }

    public void execute(Runnable runnable) {
        CoroutineDispatcher coroutineDispatcher = this.f40629b;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f40358b;
        if (coroutineDispatcher.p0(emptyCoroutineContext)) {
            this.f40629b.o0(emptyCoroutineContext, runnable);
        } else {
            runnable.run();
        }
    }

    public String toString() {
        return this.f40629b.toString();
    }
}
