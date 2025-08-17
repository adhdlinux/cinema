package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.jvm.internal.Intrinsics;

public final class GzipSource implements Source {

    /* renamed from: b  reason: collision with root package name */
    private byte f41345b;

    /* renamed from: c  reason: collision with root package name */
    private final RealBufferedSource f41346c;

    /* renamed from: d  reason: collision with root package name */
    private final Inflater f41347d;

    /* renamed from: e  reason: collision with root package name */
    private final InflaterSource f41348e;

    /* renamed from: f  reason: collision with root package name */
    private final CRC32 f41349f = new CRC32();

    public GzipSource(Source source) {
        Intrinsics.f(source, "source");
        RealBufferedSource realBufferedSource = new RealBufferedSource(source);
        this.f41346c = realBufferedSource;
        Inflater inflater = new Inflater(true);
        this.f41347d = inflater;
        this.f41348e = new InflaterSource((BufferedSource) realBufferedSource, inflater);
    }

    private final void a(String str, int i2, int i3) {
        if (i3 != i2) {
            String format = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i3), Integer.valueOf(i2)}, 3));
            Intrinsics.e(format, "format(this, *args)");
            throw new IOException(format);
        }
    }

    private final void f() throws IOException {
        boolean z2;
        boolean z3;
        boolean z4;
        this.f41346c.N(10);
        byte z5 = this.f41346c.f41373c.z(3);
        boolean z6 = true;
        if (((z5 >> 1) & 1) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            k(this.f41346c.f41373c, 0, 10);
        }
        a("ID1ID2", 8075, this.f41346c.readShort());
        this.f41346c.skip(8);
        if (((z5 >> 2) & 1) == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            this.f41346c.N(2);
            if (z2) {
                k(this.f41346c.f41373c, 0, 2);
            }
            long p02 = (long) (this.f41346c.f41373c.p0() & 65535);
            this.f41346c.N(p02);
            if (z2) {
                k(this.f41346c.f41373c, 0, p02);
            }
            this.f41346c.skip(p02);
        }
        if (((z5 >> 3) & 1) == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            long a2 = this.f41346c.a((byte) 0);
            if (a2 != -1) {
                if (z2) {
                    k(this.f41346c.f41373c, 0, a2 + 1);
                }
                this.f41346c.skip(a2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((z5 >> 4) & 1) != 1) {
            z6 = false;
        }
        if (z6) {
            long a3 = this.f41346c.a((byte) 0);
            if (a3 != -1) {
                if (z2) {
                    k(this.f41346c.f41373c, 0, a3 + 1);
                }
                this.f41346c.skip(a3 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z2) {
            a("FHCRC", this.f41346c.q(), (short) ((int) this.f41349f.getValue()));
            this.f41349f.reset();
        }
    }

    private final void i() throws IOException {
        a("CRC", this.f41346c.k(), (int) this.f41349f.getValue());
        a("ISIZE", this.f41346c.k(), (int) this.f41347d.getBytesWritten());
    }

    private final void k(Buffer buffer, long j2, long j3) {
        Segment segment = buffer.f41320b;
        Intrinsics.c(segment);
        while (true) {
            int i2 = segment.f41379c;
            int i3 = segment.f41378b;
            if (j2 < ((long) (i2 - i3))) {
                break;
            }
            j2 -= (long) (i2 - i3);
            segment = segment.f41382f;
            Intrinsics.c(segment);
        }
        while (j3 > 0) {
            int i4 = (int) (((long) segment.f41378b) + j2);
            int min = (int) Math.min((long) (segment.f41379c - i4), j3);
            this.f41349f.update(segment.f41377a, i4, min);
            j3 -= (long) min;
            segment = segment.f41382f;
            Intrinsics.c(segment);
            j2 = 0;
        }
    }

    public void close() throws IOException {
        this.f41348e.close();
    }

    public long read(Buffer buffer, long j2) throws IOException {
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
        } else if (i2 == 0) {
            return 0;
        } else {
            if (this.f41345b == 0) {
                f();
                this.f41345b = 1;
            }
            if (this.f41345b == 1) {
                long size = buffer.size();
                long read = this.f41348e.read(buffer, j2);
                if (read != -1) {
                    k(buffer, size, read);
                    return read;
                }
                this.f41345b = 2;
            }
            if (this.f41345b == 2) {
                i();
                this.f41345b = 3;
                if (!this.f41346c.V()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public Timeout timeout() {
        return this.f41346c.timeout();
    }
}
