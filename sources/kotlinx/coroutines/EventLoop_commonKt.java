package kotlinx.coroutines;

import com.facebook.common.time.Clock;
import kotlinx.coroutines.internal.Symbol;

public final class EventLoop_commonKt {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Symbol f40649a = new Symbol("REMOVED_TASK");
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Symbol f40650b = new Symbol("CLOSED_EMPTY");

    public static final long c(long j2) {
        if (j2 <= 0) {
            return 0;
        }
        return j2 >= 9223372036854L ? Clock.MAX_TIME : 1000000 * j2;
    }
}
