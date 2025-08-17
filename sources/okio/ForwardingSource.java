package okio;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

public abstract class ForwardingSource implements Source {
    private final Source delegate;

    public ForwardingSource(Source source) {
        Intrinsics.f(source, "delegate");
        this.delegate = source;
    }

    /* renamed from: -deprecated_delegate  reason: not valid java name */
    public final Source m360deprecated_delegate() {
        return this.delegate;
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public final Source delegate() {
        return this.delegate;
    }

    public long read(Buffer buffer, long j2) throws IOException {
        Intrinsics.f(buffer, "sink");
        return this.delegate.read(buffer, j2);
    }

    public Timeout timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
