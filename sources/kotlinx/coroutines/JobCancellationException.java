package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;

public final class JobCancellationException extends CancellationException {

    /* renamed from: b  reason: collision with root package name */
    public final transient Job f40661b;

    public JobCancellationException(String str, Throwable th, Job job) {
        super(str);
        this.f40661b = job;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof JobCancellationException) {
                JobCancellationException jobCancellationException = (JobCancellationException) obj;
                if (!Intrinsics.a(jobCancellationException.getMessage(), getMessage()) || !Intrinsics.a(jobCancellationException.f40661b, this.f40661b) || !Intrinsics.a(jobCancellationException.getCause(), getCause())) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        Intrinsics.c(message);
        int hashCode = ((message.hashCode() * 31) + this.f40661b.hashCode()) * 31;
        Throwable cause = getCause();
        return hashCode + (cause != null ? cause.hashCode() : 0);
    }

    public String toString() {
        return super.toString() + "; job=" + this.f40661b;
    }
}
