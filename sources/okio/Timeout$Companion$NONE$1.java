package okio;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

public final class Timeout$Companion$NONE$1 extends Timeout {
    Timeout$Companion$NONE$1() {
    }

    public Timeout deadlineNanoTime(long j2) {
        return this;
    }

    public void throwIfReached() {
    }

    public Timeout timeout(long j2, TimeUnit timeUnit) {
        Intrinsics.f(timeUnit, "unit");
        return this;
    }
}
