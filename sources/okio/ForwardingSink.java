package okio;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

public abstract class ForwardingSink implements Sink {
    private final Sink delegate;

    public ForwardingSink(Sink sink) {
        Intrinsics.f(sink, "delegate");
        this.delegate = sink;
    }

    /* renamed from: -deprecated_delegate  reason: not valid java name */
    public final Sink m359deprecated_delegate() {
        return this.delegate;
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public final Sink delegate() {
        return this.delegate;
    }

    public void flush() throws IOException {
        this.delegate.flush();
    }

    public Timeout timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    public void write(Buffer buffer, long j2) throws IOException {
        Intrinsics.f(buffer, "source");
        this.delegate.write(buffer, j2);
    }
}
