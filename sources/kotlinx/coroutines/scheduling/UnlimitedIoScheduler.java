package kotlinx.coroutines.scheduling;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.LimitedDispatcherKt;

final class UnlimitedIoScheduler extends CoroutineDispatcher {

    /* renamed from: c  reason: collision with root package name */
    public static final UnlimitedIoScheduler f40835c = new UnlimitedIoScheduler();

    private UnlimitedIoScheduler() {
    }

    public void o0(CoroutineContext coroutineContext, Runnable runnable) {
        DefaultScheduler.f40816i.t0(runnable, TasksKt.f40834h, false);
    }

    public CoroutineDispatcher q0(int i2) {
        LimitedDispatcherKt.a(i2);
        if (i2 >= TasksKt.f40830d) {
            return this;
        }
        return super.q0(i2);
    }
}
