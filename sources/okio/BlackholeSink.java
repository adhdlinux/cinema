package okio;

import kotlin.jvm.internal.Intrinsics;

final class BlackholeSink implements Sink {
    public void close() {
    }

    public void flush() {
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public void write(Buffer buffer, long j2) {
        Intrinsics.f(buffer, "source");
        buffer.skip(j2);
    }
}
