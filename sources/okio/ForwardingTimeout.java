package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

public class ForwardingTimeout extends Timeout {

    /* renamed from: a  reason: collision with root package name */
    private Timeout f41339a;

    public ForwardingTimeout(Timeout timeout) {
        Intrinsics.f(timeout, "delegate");
        this.f41339a = timeout;
    }

    public final Timeout a() {
        return this.f41339a;
    }

    public final ForwardingTimeout b(Timeout timeout) {
        Intrinsics.f(timeout, "delegate");
        this.f41339a = timeout;
        return this;
    }

    public Timeout clearDeadline() {
        return this.f41339a.clearDeadline();
    }

    public Timeout clearTimeout() {
        return this.f41339a.clearTimeout();
    }

    public long deadlineNanoTime() {
        return this.f41339a.deadlineNanoTime();
    }

    public boolean hasDeadline() {
        return this.f41339a.hasDeadline();
    }

    public void throwIfReached() throws IOException {
        this.f41339a.throwIfReached();
    }

    public Timeout timeout(long j2, TimeUnit timeUnit) {
        Intrinsics.f(timeUnit, "unit");
        return this.f41339a.timeout(j2, timeUnit);
    }

    public long timeoutNanos() {
        return this.f41339a.timeoutNanos();
    }

    public Timeout deadlineNanoTime(long j2) {
        return this.f41339a.deadlineNanoTime(j2);
    }
}
