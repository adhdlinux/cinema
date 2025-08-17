package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;

public final class AbortFlowException extends CancellationException {
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
