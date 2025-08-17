package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.internal.SystemPropsKt;

public final class DefaultIoScheduler extends ExecutorCoroutineDispatcher implements Executor {

    /* renamed from: d  reason: collision with root package name */
    public static final DefaultIoScheduler f40814d = new DefaultIoScheduler();

    /* renamed from: e  reason: collision with root package name */
    private static final CoroutineDispatcher f40815e = UnlimitedIoScheduler.f40835c.q0(SystemPropsKt__SystemProps_commonKt.e("kotlinx.coroutines.io.parallelism", RangesKt___RangesKt.b(64, SystemPropsKt.a()), 0, 0, 12, (Object) null));

    private DefaultIoScheduler() {
    }

    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    public void execute(Runnable runnable) {
        o0(EmptyCoroutineContext.f40358b, runnable);
    }

    public void o0(CoroutineContext coroutineContext, Runnable runnable) {
        f40815e.o0(coroutineContext, runnable);
    }

    public Executor r0() {
        return this;
    }

    public String toString() {
        return "Dispatchers.IO";
    }
}
