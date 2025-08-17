package kotlinx.coroutines;

import com.facebook.common.time.Clock;
import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

final class BlockingCoroutine<T> extends AbstractCoroutine<T> {

    /* renamed from: e  reason: collision with root package name */
    private final Thread f40587e;

    /* renamed from: f  reason: collision with root package name */
    private final EventLoop f40588f;

    public BlockingCoroutine(CoroutineContext coroutineContext, Thread thread, EventLoop eventLoop) {
        super(coroutineContext, true, true);
        this.f40587e = thread;
        this.f40588f = eventLoop;
    }

    /* access modifiers changed from: protected */
    public boolean T() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void n(Object obj) {
        Unit unit;
        if (!Intrinsics.a(Thread.currentThread(), this.f40587e)) {
            Thread thread = this.f40587e;
            AbstractTimeSource a2 = AbstractTimeSourceKt.a();
            if (a2 != null) {
                a2.f(thread);
                unit = Unit.f40298a;
            } else {
                unit = null;
            }
            if (unit == null) {
                LockSupport.unpark(thread);
            }
        }
    }

    public final T y0() {
        long j2;
        Unit unit;
        AbstractTimeSource a2 = AbstractTimeSourceKt.a();
        if (a2 != null) {
            a2.c();
        }
        try {
            EventLoop eventLoop = this.f40588f;
            CompletedExceptionally completedExceptionally = null;
            if (eventLoop != null) {
                EventLoop.x0(eventLoop, false, 1, (Object) null);
            }
            while (!Thread.interrupted()) {
                EventLoop eventLoop2 = this.f40588f;
                if (eventLoop2 != null) {
                    j2 = eventLoop2.A0();
                } else {
                    j2 = Clock.MAX_TIME;
                }
                if (!S()) {
                    AbstractTimeSource a3 = AbstractTimeSourceKt.a();
                    if (a3 != null) {
                        a3.b(this, j2);
                        unit = Unit.f40298a;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        LockSupport.parkNanos(this, j2);
                    }
                } else {
                    EventLoop eventLoop3 = this.f40588f;
                    if (eventLoop3 != null) {
                        EventLoop.s0(eventLoop3, false, 1, (Object) null);
                    }
                    AbstractTimeSource a4 = AbstractTimeSourceKt.a();
                    if (a4 != null) {
                        a4.g();
                    }
                    T h2 = JobSupportKt.h(O());
                    if (h2 instanceof CompletedExceptionally) {
                        completedExceptionally = (CompletedExceptionally) h2;
                    }
                    if (completedExceptionally == null) {
                        return h2;
                    }
                    throw completedExceptionally.f40605a;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            o(interruptedException);
            throw interruptedException;
        } catch (Throwable th) {
            AbstractTimeSource a5 = AbstractTimeSourceKt.a();
            if (a5 != null) {
                a5.g();
            }
            throw th;
        }
    }
}
