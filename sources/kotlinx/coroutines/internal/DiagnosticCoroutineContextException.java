package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;

public final class DiagnosticCoroutineContextException extends RuntimeException {

    /* renamed from: b  reason: collision with root package name */
    private final transient CoroutineContext f40726b;

    public DiagnosticCoroutineContextException(CoroutineContext coroutineContext) {
        this.f40726b = coroutineContext;
    }

    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public String getLocalizedMessage() {
        return this.f40726b.toString();
    }
}
