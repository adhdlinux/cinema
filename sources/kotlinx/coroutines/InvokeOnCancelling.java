package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

final class InvokeOnCancelling extends JobCancellingNode {

    /* renamed from: g  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f40657g = AtomicIntegerFieldUpdater.newUpdater(InvokeOnCancelling.class, "_invoked");
    private volatile int _invoked;

    /* renamed from: f  reason: collision with root package name */
    private final Function1<Throwable, Unit> f40658f;

    public InvokeOnCancelling(Function1<? super Throwable, Unit> function1) {
        this.f40658f = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        r((Throwable) obj);
        return Unit.f40298a;
    }

    public void r(Throwable th) {
        if (f40657g.compareAndSet(this, 0, 1)) {
            this.f40658f.invoke(th);
        }
    }
}
