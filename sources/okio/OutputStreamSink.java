package okio;

import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

final class OutputStreamSink implements Sink {

    /* renamed from: b  reason: collision with root package name */
    private final OutputStream f41360b;

    /* renamed from: c  reason: collision with root package name */
    private final Timeout f41361c;

    public OutputStreamSink(OutputStream outputStream, Timeout timeout) {
        Intrinsics.f(outputStream, "out");
        Intrinsics.f(timeout, "timeout");
        this.f41360b = outputStream;
        this.f41361c = timeout;
    }

    public void close() {
        this.f41360b.close();
    }

    public void flush() {
        this.f41360b.flush();
    }

    public Timeout timeout() {
        return this.f41361c;
    }

    public String toString() {
        return "sink(" + this.f41360b + ')';
    }

    public void write(Buffer buffer, long j2) {
        Intrinsics.f(buffer, "source");
        SegmentedByteString.b(buffer.size(), 0, j2);
        while (j2 > 0) {
            this.f41361c.throwIfReached();
            Segment segment = buffer.f41320b;
            Intrinsics.c(segment);
            int min = (int) Math.min(j2, (long) (segment.f41379c - segment.f41378b));
            this.f41360b.write(segment.f41377a, segment.f41378b, min);
            segment.f41378b += min;
            long j3 = (long) min;
            j2 -= j3;
            buffer.t0(buffer.size() - j3);
            if (segment.f41378b == segment.f41379c) {
                buffer.f41320b = segment.b();
                SegmentPool.b(segment);
            }
        }
    }
}
