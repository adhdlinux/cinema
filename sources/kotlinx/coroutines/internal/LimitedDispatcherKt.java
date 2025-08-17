package kotlinx.coroutines.internal;

public final class LimitedDispatcherKt {
    public static final void a(int i2) {
        boolean z2 = true;
        if (i2 < 1) {
            z2 = false;
        }
        if (!z2) {
            throw new IllegalArgumentException(("Expected positive parallelism level, but got " + i2).toString());
        }
    }
}
