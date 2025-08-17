package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

public class Timeout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final Timeout NONE = new Timeout$Companion$NONE$1();
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a(long j2, long j3) {
            return (j2 != 0 && (j3 == 0 || j2 < j3)) ? j2 : j3;
        }
    }

    public final void awaitSignal(Condition condition) throws InterruptedIOException {
        Intrinsics.f(condition, "condition");
        try {
            boolean hasDeadline2 = hasDeadline();
            long timeoutNanos2 = timeoutNanos();
            long j2 = 0;
            if (hasDeadline2 || timeoutNanos2 != 0) {
                long nanoTime = System.nanoTime();
                if (hasDeadline2 && timeoutNanos2 != 0) {
                    timeoutNanos2 = Math.min(timeoutNanos2, deadlineNanoTime() - nanoTime);
                } else if (hasDeadline2) {
                    timeoutNanos2 = deadlineNanoTime() - nanoTime;
                }
                if (timeoutNanos2 > 0) {
                    condition.await(timeoutNanos2, TimeUnit.NANOSECONDS);
                    j2 = System.nanoTime() - nanoTime;
                }
                if (j2 >= timeoutNanos2) {
                    throw new InterruptedIOException("timeout");
                }
                return;
            }
            condition.await();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public Timeout clearTimeout() {
        this.timeoutNanos = 0;
        return this;
    }

    public final Timeout deadline(long j2, TimeUnit timeUnit) {
        boolean z2;
        Intrinsics.f(timeUnit, "unit");
        if (j2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(j2));
        }
        throw new IllegalArgumentException(("duration <= 0: " + j2).toString());
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final <T> T intersectWith(Timeout timeout, Function0<? extends T> function0) {
        Intrinsics.f(timeout, "other");
        Intrinsics.f(function0, "block");
        long timeoutNanos2 = timeoutNanos();
        long a2 = Companion.a(timeout.timeoutNanos(), timeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout(a2, timeUnit);
        if (hasDeadline()) {
            long deadlineNanoTime2 = deadlineNanoTime();
            if (timeout.hasDeadline()) {
                deadlineNanoTime(Math.min(deadlineNanoTime(), timeout.deadlineNanoTime()));
            }
            try {
                T invoke = function0.invoke();
                InlineMarker.b(1);
                timeout(timeoutNanos2, timeUnit);
                if (timeout.hasDeadline()) {
                    deadlineNanoTime(deadlineNanoTime2);
                }
                InlineMarker.a(1);
                return invoke;
            } catch (Throwable th) {
                InlineMarker.b(1);
                timeout(timeoutNanos2, TimeUnit.NANOSECONDS);
                if (timeout.hasDeadline()) {
                    deadlineNanoTime(deadlineNanoTime2);
                }
                InlineMarker.a(1);
                throw th;
            }
        } else {
            if (timeout.hasDeadline()) {
                deadlineNanoTime(timeout.deadlineNanoTime());
            }
            try {
                T invoke2 = function0.invoke();
                InlineMarker.b(1);
                timeout(timeoutNanos2, timeUnit);
                if (timeout.hasDeadline()) {
                    clearDeadline();
                }
                InlineMarker.a(1);
                return invoke2;
            } catch (Throwable th2) {
                InlineMarker.b(1);
                timeout(timeoutNanos2, TimeUnit.NANOSECONDS);
                if (timeout.hasDeadline()) {
                    clearDeadline();
                }
                InlineMarker.a(1);
                throw th2;
            }
        }
    }

    public void throwIfReached() throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        } else if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public Timeout timeout(long j2, TimeUnit timeUnit) {
        boolean z2;
        Intrinsics.f(timeUnit, "unit");
        if (j2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.timeoutNanos = timeUnit.toNanos(j2);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j2).toString());
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(Object obj) throws InterruptedIOException {
        Intrinsics.f(obj, "monitor");
        try {
            boolean hasDeadline2 = hasDeadline();
            long timeoutNanos2 = timeoutNanos();
            long j2 = 0;
            if (hasDeadline2 || timeoutNanos2 != 0) {
                long nanoTime = System.nanoTime();
                if (hasDeadline2 && timeoutNanos2 != 0) {
                    timeoutNanos2 = Math.min(timeoutNanos2, deadlineNanoTime() - nanoTime);
                } else if (hasDeadline2) {
                    timeoutNanos2 = deadlineNanoTime() - nanoTime;
                }
                if (timeoutNanos2 > 0) {
                    long j3 = timeoutNanos2 / 1000000;
                    Long.signum(j3);
                    obj.wait(j3, (int) (timeoutNanos2 - (1000000 * j3)));
                    j2 = System.nanoTime() - nanoTime;
                }
                if (j2 >= timeoutNanos2) {
                    throw new InterruptedIOException("timeout");
                }
                return;
            }
            obj.wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public Timeout deadlineNanoTime(long j2) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j2;
        return this;
    }
}
