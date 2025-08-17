package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlinx.coroutines.EventLoopImplBase;

public abstract class EventLoopImplPlatform extends EventLoop {
    /* access modifiers changed from: protected */
    public abstract Thread D0();

    /* access modifiers changed from: protected */
    public void E0(long j2, EventLoopImplBase.DelayedTask delayedTask) {
        DefaultExecutor.f40623i.P0(j2, delayedTask);
    }

    /* access modifiers changed from: protected */
    public final void F0() {
        Unit unit;
        Thread D0 = D0();
        if (Thread.currentThread() != D0) {
            AbstractTimeSource a2 = AbstractTimeSourceKt.a();
            if (a2 != null) {
                a2.f(D0);
                unit = Unit.f40298a;
            } else {
                unit = null;
            }
            if (unit == null) {
                LockSupport.unpark(D0);
            }
        }
    }
}
