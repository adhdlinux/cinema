package okio;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

public final class RealBufferedSink implements BufferedSink {

    /* renamed from: b  reason: collision with root package name */
    public final Sink f41368b;

    /* renamed from: c  reason: collision with root package name */
    public final Buffer f41369c = new Buffer();

    /* renamed from: d  reason: collision with root package name */
    public boolean f41370d;

    public RealBufferedSink(Sink sink) {
        Intrinsics.f(sink, "sink");
        this.f41368b = sink;
    }

    public BufferedSink O(long j2) {
        if (!this.f41370d) {
            this.f41369c.O(j2);
            return r();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink a(int i2) {
        if (!this.f41370d) {
            this.f41369c.F0(i2);
            return r();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink b0(long j2) {
        if (!this.f41370d) {
            this.f41369c.b0(j2);
            return r();
        }
        throw new IllegalStateException("closed".toString());
    }

    public Buffer c() {
        return this.f41369c;
    }

    public void close() {
        if (!this.f41370d) {
            try {
                if (this.f41369c.size() > 0) {
                    Sink sink = this.f41368b;
                    Buffer buffer = this.f41369c;
                    sink.write(buffer, buffer.size());
                }
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f41368b.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            this.f41370d = true;
            if (th != null) {
                throw th;
            }
        }
    }

    public void flush() {
        if (!this.f41370d) {
            if (this.f41369c.size() > 0) {
                Sink sink = this.f41368b;
                Buffer buffer = this.f41369c;
                sink.write(buffer, buffer.size());
            }
            this.f41368b.flush();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink h() {
        if (!this.f41370d) {
            long size = this.f41369c.size();
            if (size > 0) {
                this.f41368b.write(this.f41369c, size);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink h0(ByteString byteString) {
        Intrinsics.f(byteString, "byteString");
        if (!this.f41370d) {
            this.f41369c.h0(byteString);
            return r();
        }
        throw new IllegalStateException("closed".toString());
    }

    public boolean isOpen() {
        return !this.f41370d;
    }

    public OutputStream k0() {
        return new RealBufferedSink$outputStream$1(this);
    }

    public BufferedSink r() {
        if (!this.f41370d) {
            long i2 = this.f41369c.i();
            if (i2 > 0) {
                this.f41368b.write(this.f41369c, i2);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    public Timeout timeout() {
        return this.f41368b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f41368b + ')';
    }

    public BufferedSink w(String str) {
        Intrinsics.f(str, "string");
        if (!this.f41370d) {
            this.f41369c.w(str);
            return r();
        }
        throw new IllegalStateException("closed".toString());
    }

    public int write(ByteBuffer byteBuffer) {
        Intrinsics.f(byteBuffer, "source");
        if (!this.f41370d) {
            int write = this.f41369c.write(byteBuffer);
            r();
            return write;
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeByte(int i2) {
        if (!this.f41370d) {
            this.f41369c.writeByte(i2);
            return r();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeInt(int i2) {
        if (!this.f41370d) {
            this.f41369c.writeInt(i2);
            return r();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeShort(int i2) {
        if (!this.f41370d) {
            this.f41369c.writeShort(i2);
            return r();
        }
        throw new IllegalStateException("closed".toString());
    }

    public long y(Source source) {
        Intrinsics.f(source, "source");
        long j2 = 0;
        while (true) {
            long read = source.read(this.f41369c, 8192);
            if (read == -1) {
                return j2;
            }
            j2 += read;
            r();
        }
    }

    public void write(Buffer buffer, long j2) {
        Intrinsics.f(buffer, "source");
        if (!this.f41370d) {
            this.f41369c.write(buffer, j2);
            r();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink write(byte[] bArr) {
        Intrinsics.f(bArr, "source");
        if (!this.f41370d) {
            this.f41369c.write(bArr);
            return r();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink write(byte[] bArr, int i2, int i3) {
        Intrinsics.f(bArr, "source");
        if (!this.f41370d) {
            this.f41369c.write(bArr, i2, i3);
            return r();
        }
        throw new IllegalStateException("closed".toString());
    }
}
