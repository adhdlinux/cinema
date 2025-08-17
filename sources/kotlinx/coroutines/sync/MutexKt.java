package kotlinx.coroutines.sync;

import kotlinx.coroutines.internal.Symbol;

public final class MutexKt {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Symbol f40853a = new Symbol("NO_OWNER");

    /* renamed from: b  reason: collision with root package name */
    private static final Symbol f40854b = new Symbol("ALREADY_LOCKED_BY_OWNER");

    public static final Mutex a(boolean z2) {
        return new MutexImpl(z2);
    }

    public static /* synthetic */ Mutex b(boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        return a(z2);
    }
}
