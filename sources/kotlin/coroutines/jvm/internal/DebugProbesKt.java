package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

public final class DebugProbesKt {
    public static final <T> Continuation<T> a(Continuation<? super T> continuation) {
        Intrinsics.f(continuation, "completion");
        return continuation;
    }

    public static final void b(Continuation<?> continuation) {
        Intrinsics.f(continuation, "frame");
    }

    public static final void c(Continuation<?> continuation) {
        Intrinsics.f(continuation, "frame");
    }
}
