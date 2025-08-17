package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.jvm.internal.Intrinsics;

public final class DeflaterSink implements Sink {

    /* renamed from: b  reason: collision with root package name */
    private final BufferedSink f41336b;

    /* renamed from: c  reason: collision with root package name */
    private final Deflater f41337c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f41338d;

    public DeflaterSink(BufferedSink bufferedSink, Deflater deflater) {
        Intrinsics.f(bufferedSink, "sink");
        Intrinsics.f(deflater, "deflater");
        this.f41336b = bufferedSink;
        this.f41337c = deflater;
    }

    private final void a(boolean z2) {
        Segment w02;
        int i2;
        Buffer c2 = this.f41336b.c();
        while (true) {
            w02 = c2.w0(1);
            if (z2) {
                try {
                    Deflater deflater = this.f41337c;
                    byte[] bArr = w02.f41377a;
                    int i3 = w02.f41379c;
                    i2 = deflater.deflate(bArr, i3, 8192 - i3, 2);
                } catch (NullPointerException e2) {
                    throw new IOException("Deflater already closed", e2);
                }
            } else {
                Deflater deflater2 = this.f41337c;
                byte[] bArr2 = w02.f41377a;
                int i4 = w02.f41379c;
                i2 = deflater2.deflate(bArr2, i4, 8192 - i4);
            }
            if (i2 > 0) {
                w02.f41379c += i2;
                c2.t0(c2.size() + ((long) i2));
                this.f41336b.r();
            } else if (this.f41337c.needsInput()) {
                break;
            }
        }
        if (w02.f41378b == w02.f41379c) {
            c2.f41320b = w02.b();
            SegmentPool.b(w02);
        }
    }

    public void close() throws IOException {
        if (!this.f41338d) {
            try {
                f();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f41337c.end();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            try {
                this.f41336b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f41338d = true;
            if (th != null) {
                throw th;
            }
        }
    }

    public final void f() {
        this.f41337c.finish();
        a(false);
    }

    public void flush() throws IOException {
        a(true);
        this.f41336b.flush();
    }

    public Timeout timeout() {
        return this.f41336b.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.f41336b + ')';
    }

    public void write(Buffer buffer, long j2) throws IOException {
        Intrinsics.f(buffer, "source");
        SegmentedByteString.b(buffer.size(), 0, j2);
        while (j2 > 0) {
            Segment segment = buffer.f41320b;
            Intrinsics.c(segment);
            int min = (int) Math.min(j2, (long) (segment.f41379c - segment.f41378b));
            this.f41337c.setInput(segment.f41377a, segment.f41378b, min);
            a(false);
            long j3 = (long) min;
            buffer.t0(buffer.size() - j3);
            int i2 = segment.f41378b + min;
            segment.f41378b = i2;
            if (i2 == segment.f41379c) {
                buffer.f41320b = segment.b();
                SegmentPool.b(segment);
            }
            j2 -= j3;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DeflaterSink(Sink sink, Deflater deflater) {
        this(Okio.c(sink), deflater);
        Intrinsics.f(sink, "sink");
        Intrinsics.f(deflater, "deflater");
    }
}
