package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.jvm.internal.Intrinsics;

public final class GzipSink implements Sink {

    /* renamed from: b  reason: collision with root package name */
    private final RealBufferedSink f41340b;

    /* renamed from: c  reason: collision with root package name */
    private final Deflater f41341c;

    /* renamed from: d  reason: collision with root package name */
    private final DeflaterSink f41342d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f41343e;

    /* renamed from: f  reason: collision with root package name */
    private final CRC32 f41344f = new CRC32();

    public GzipSink(Sink sink) {
        Intrinsics.f(sink, "sink");
        RealBufferedSink realBufferedSink = new RealBufferedSink(sink);
        this.f41340b = realBufferedSink;
        Deflater deflater = new Deflater(-1, true);
        this.f41341c = deflater;
        this.f41342d = new DeflaterSink((BufferedSink) realBufferedSink, deflater);
        Buffer buffer = realBufferedSink.f41369c;
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }

    private final void a(Buffer buffer, long j2) {
        Segment segment = buffer.f41320b;
        Intrinsics.c(segment);
        while (j2 > 0) {
            int min = (int) Math.min(j2, (long) (segment.f41379c - segment.f41378b));
            this.f41344f.update(segment.f41377a, segment.f41378b, min);
            j2 -= (long) min;
            segment = segment.f41382f;
            Intrinsics.c(segment);
        }
    }

    private final void f() {
        this.f41340b.a((int) this.f41344f.getValue());
        this.f41340b.a((int) this.f41341c.getBytesRead());
    }

    public void close() throws IOException {
        if (!this.f41343e) {
            try {
                this.f41342d.f();
                f();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f41341c.end();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            try {
                this.f41340b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f41343e = true;
            if (th != null) {
                throw th;
            }
        }
    }

    public void flush() throws IOException {
        this.f41342d.flush();
    }

    public Timeout timeout() {
        return this.f41340b.timeout();
    }

    public void write(Buffer buffer, long j2) throws IOException {
        boolean z2;
        Intrinsics.f(buffer, "source");
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        } else if (i2 != 0) {
            a(buffer, j2);
            this.f41342d.write(buffer, j2);
        }
    }
}
