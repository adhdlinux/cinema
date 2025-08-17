package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

public final class CompletedContinuation implements Continuation<Object> {

    /* renamed from: b  reason: collision with root package name */
    public static final CompletedContinuation f40370b = new CompletedContinuation();

    private CompletedContinuation() {
    }

    public CoroutineContext getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
