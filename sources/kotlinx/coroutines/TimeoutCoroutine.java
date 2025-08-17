package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.ScopeCoroutine;

final class TimeoutCoroutine<U, T extends U> extends ScopeCoroutine<T> implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public final long f40688f;

    public TimeoutCoroutine(long j2, Continuation<? super U> continuation) {
        super(continuation.getContext(), continuation);
        this.f40688f = j2;
    }

    public String X() {
        return super.X() + "(timeMillis=" + this.f40688f + ')';
    }

    public void run() {
        o(TimeoutKt.a(this.f40688f, DelayKt.b(getContext()), this));
    }
}
