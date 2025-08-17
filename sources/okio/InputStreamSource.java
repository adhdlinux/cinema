package okio;

import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

class InputStreamSource implements Source {

    /* renamed from: b  reason: collision with root package name */
    private final InputStream f41354b;

    /* renamed from: c  reason: collision with root package name */
    private final Timeout f41355c;

    public InputStreamSource(InputStream inputStream, Timeout timeout) {
        Intrinsics.f(inputStream, "input");
        Intrinsics.f(timeout, "timeout");
        this.f41354b = inputStream;
        this.f41355c = timeout;
    }

    public void close() {
        this.f41354b.close();
    }

    public long read(Buffer buffer, long j2) {
        boolean z2;
        Intrinsics.f(buffer, "sink");
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 == 0) {
            return 0;
        }
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            try {
                this.f41355c.throwIfReached();
                Segment w02 = buffer.w0(1);
                int read = this.f41354b.read(w02.f41377a, w02.f41379c, (int) Math.min(j2, (long) (8192 - w02.f41379c)));
                if (read != -1) {
                    w02.f41379c += read;
                    long j3 = (long) read;
                    buffer.t0(buffer.size() + j3);
                    return j3;
                } else if (w02.f41378b != w02.f41379c) {
                    return -1;
                } else {
                    buffer.f41320b = w02.b();
                    SegmentPool.b(w02);
                    return -1;
                }
            } catch (AssertionError e2) {
                if (Okio.e(e2)) {
                    throw new IOException(e2);
                }
                throw e2;
            }
        } else {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
    }

    public Timeout timeout() {
        return this.f41355c;
    }

    public String toString() {
        return "source(" + this.f41354b + ')';
    }
}
