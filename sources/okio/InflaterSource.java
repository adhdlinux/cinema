package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.Intrinsics;

public final class InflaterSource implements Source {

    /* renamed from: b  reason: collision with root package name */
    private final BufferedSource f41350b;

    /* renamed from: c  reason: collision with root package name */
    private final Inflater f41351c;

    /* renamed from: d  reason: collision with root package name */
    private int f41352d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f41353e;

    public InflaterSource(BufferedSource bufferedSource, Inflater inflater) {
        Intrinsics.f(bufferedSource, "source");
        Intrinsics.f(inflater, "inflater");
        this.f41350b = bufferedSource;
        this.f41351c = inflater;
    }

    private final void i() {
        int i2 = this.f41352d;
        if (i2 != 0) {
            int remaining = i2 - this.f41351c.getRemaining();
            this.f41352d -= remaining;
            this.f41350b.skip((long) remaining);
        }
    }

    public final long a(Buffer buffer, long j2) throws IOException {
        boolean z2;
        Intrinsics.f(buffer, "sink");
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        } else if (!(!this.f41353e)) {
            throw new IllegalStateException("closed".toString());
        } else if (i2 == 0) {
            return 0;
        } else {
            try {
                Segment w02 = buffer.w0(1);
                int min = (int) Math.min(j2, (long) (8192 - w02.f41379c));
                f();
                int inflate = this.f41351c.inflate(w02.f41377a, w02.f41379c, min);
                i();
                if (inflate > 0) {
                    w02.f41379c += inflate;
                    long j3 = (long) inflate;
                    buffer.t0(buffer.size() + j3);
                    return j3;
                }
                if (w02.f41378b == w02.f41379c) {
                    buffer.f41320b = w02.b();
                    SegmentPool.b(w02);
                }
                return 0;
            } catch (DataFormatException e2) {
                throw new IOException(e2);
            }
        }
    }

    public void close() throws IOException {
        if (!this.f41353e) {
            this.f41351c.end();
            this.f41353e = true;
            this.f41350b.close();
        }
    }

    public final boolean f() throws IOException {
        if (!this.f41351c.needsInput()) {
            return false;
        }
        if (this.f41350b.V()) {
            return true;
        }
        Segment segment = this.f41350b.c().f41320b;
        Intrinsics.c(segment);
        int i2 = segment.f41379c;
        int i3 = segment.f41378b;
        int i4 = i2 - i3;
        this.f41352d = i4;
        this.f41351c.setInput(segment.f41377a, i3, i4);
        return false;
    }

    public long read(Buffer buffer, long j2) throws IOException {
        Intrinsics.f(buffer, "sink");
        do {
            long a2 = a(buffer, j2);
            if (a2 > 0) {
                return a2;
            }
            if (this.f41351c.finished() || this.f41351c.needsDictionary()) {
                return -1;
            }
        } while (!this.f41350b.V());
        throw new EOFException("source exhausted prematurely");
    }

    public Timeout timeout() {
        return this.f41350b.timeout();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InflaterSource(Source source, Inflater inflater) {
        this(Okio.d(source), inflater);
        Intrinsics.f(source, "source");
        Intrinsics.f(inflater, "inflater");
    }
}
