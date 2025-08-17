package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

public final class TimeoutCancellationException extends CancellationException {

    /* renamed from: b  reason: collision with root package name */
    public final transient Job f40687b;

    public TimeoutCancellationException(String str, Job job) {
        super(str);
        this.f40687b = job;
    }

    public TimeoutCancellationException(String str) {
        this(str, (Job) null);
    }
}
