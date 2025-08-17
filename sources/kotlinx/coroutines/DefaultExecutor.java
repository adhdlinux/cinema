package kotlinx.coroutines;

import com.facebook.common.time.Clock;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.EventLoopImplBase;

public final class DefaultExecutor extends EventLoopImplBase implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: i  reason: collision with root package name */
    public static final DefaultExecutor f40623i;

    /* renamed from: j  reason: collision with root package name */
    private static final long f40624j;

    static {
        Long l2;
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        f40623i = defaultExecutor;
        EventLoop.x0(defaultExecutor, false, 1, (Object) null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException unused) {
            l2 = 1000L;
        }
        f40624j = timeUnit.toNanos(l2.longValue());
    }

    private DefaultExecutor() {
    }

    private final synchronized void U0() {
        if (X0()) {
            debugStatus = 3;
            O0();
            Intrinsics.d(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    private final synchronized Thread V0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final boolean W0() {
        return debugStatus == 4;
    }

    private final boolean X0() {
        int i2 = debugStatus;
        return i2 == 2 || i2 == 3;
    }

    private final synchronized boolean Y0() {
        if (X0()) {
            return false;
        }
        debugStatus = 1;
        Intrinsics.d(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    private final void Z0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    public DisposableHandle A(long j2, Runnable runnable, CoroutineContext coroutineContext) {
        return R0(j2, runnable);
    }

    /* access modifiers changed from: protected */
    public Thread D0() {
        Thread thread = _thread;
        return thread == null ? V0() : thread;
    }

    /* access modifiers changed from: protected */
    public void E0(long j2, EventLoopImplBase.DelayedTask delayedTask) {
        Z0();
    }

    public void J0(Runnable runnable) {
        if (W0()) {
            Z0();
        }
        super.J0(runnable);
    }

    public void run() {
        Unit unit;
        long j2;
        ThreadLocalEventLoop.f40685a.d(this);
        AbstractTimeSource a2 = AbstractTimeSourceKt.a();
        if (a2 != null) {
            a2.c();
        }
        try {
            if (Y0()) {
                long j3 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long A0 = A0();
                    if (A0 == Clock.MAX_TIME) {
                        AbstractTimeSource a3 = AbstractTimeSourceKt.a();
                        if (a3 != null) {
                            j2 = a3.a();
                        } else {
                            j2 = System.nanoTime();
                        }
                        if (j3 == Clock.MAX_TIME) {
                            j3 = f40624j + j2;
                        }
                        long j4 = j3 - j2;
                        if (j4 <= 0) {
                            _thread = null;
                            U0();
                            AbstractTimeSource a4 = AbstractTimeSourceKt.a();
                            if (a4 != null) {
                                a4.g();
                            }
                            if (!M0()) {
                                D0();
                                return;
                            }
                            return;
                        }
                        A0 = RangesKt___RangesKt.e(A0, j4);
                    } else {
                        j3 = Long.MAX_VALUE;
                    }
                    if (A0 > 0) {
                        if (X0()) {
                            _thread = null;
                            U0();
                            AbstractTimeSource a5 = AbstractTimeSourceKt.a();
                            if (a5 != null) {
                                a5.g();
                            }
                            if (!M0()) {
                                D0();
                                return;
                            }
                            return;
                        }
                        AbstractTimeSource a6 = AbstractTimeSourceKt.a();
                        if (a6 != null) {
                            a6.b(this, A0);
                            unit = Unit.f40298a;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            LockSupport.parkNanos(this, A0);
                        }
                    }
                }
            }
        } finally {
            _thread = null;
            U0();
            AbstractTimeSource a7 = AbstractTimeSourceKt.a();
            if (a7 != null) {
                a7.g();
            }
            if (!M0()) {
                D0();
            }
        }
    }

    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
