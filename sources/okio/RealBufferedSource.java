package okio;

import com.facebook.common.time.Clock;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import okio.internal.Buffer;

public final class RealBufferedSource implements BufferedSource {

    /* renamed from: b  reason: collision with root package name */
    public final Source f41372b;

    /* renamed from: c  reason: collision with root package name */
    public final Buffer f41373c = new Buffer();

    /* renamed from: d  reason: collision with root package name */
    public boolean f41374d;

    public RealBufferedSource(Source source) {
        Intrinsics.f(source, "source");
        this.f41372b = source;
    }

    public String F() {
        return t(Clock.MAX_TIME);
    }

    public byte[] G(long j2) {
        N(j2);
        return this.f41373c.G(j2);
    }

    public void N(long j2) {
        if (!request(j2)) {
            throw new EOFException();
        }
    }

    public ByteString Q(long j2) {
        N(j2);
        return this.f41373c.Q(j2);
    }

    public byte[] U() {
        this.f41373c.y(this.f41372b);
        return this.f41373c.U();
    }

    public boolean V() {
        if (!(!this.f41374d)) {
            throw new IllegalStateException("closed".toString());
        } else if (!this.f41373c.V() || this.f41372b.read(this.f41373c, 8192) != -1) {
            return false;
        } else {
            return true;
        }
    }

    public long W() {
        int i2;
        N(1);
        long j2 = 0;
        while (true) {
            long j3 = j2 + 1;
            if (!request(j3)) {
                break;
            }
            byte z2 = this.f41373c.z(j2);
            if ((z2 >= 48 && z2 <= 57) || (j2 == 0 && z2 == 45)) {
                j2 = j3;
            } else if (i2 == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Expected a digit or '-' but was 0x");
                String num = Integer.toString(z2, CharsKt__CharJVMKt.a(CharsKt__CharJVMKt.a(16)));
                Intrinsics.e(num, "toString(this, checkRadix(radix))");
                sb.append(num);
                throw new NumberFormatException(sb.toString());
            }
        }
        return this.f41373c.W();
    }

    public long a(byte b2) {
        return f(b2, 0, Clock.MAX_TIME);
    }

    public String a0(Charset charset) {
        Intrinsics.f(charset, "charset");
        this.f41373c.y(this.f41372b);
        return this.f41373c.a0(charset);
    }

    public Buffer c() {
        return this.f41373c;
    }

    public ByteString c0() {
        this.f41373c.y(this.f41372b);
        return this.f41373c.c0();
    }

    public void close() {
        if (!this.f41374d) {
            this.f41374d = true;
            this.f41372b.close();
            this.f41373c.a();
        }
    }

    public InputStream d() {
        return new RealBufferedSource$inputStream$1(this);
    }

    public long f(byte b2, long j2, long j3) {
        boolean z2 = true;
        if (!this.f41374d) {
            if (0 > j2 || j2 > j3) {
                z2 = false;
            }
            if (z2) {
                while (j2 < j3) {
                    long A = this.f41373c.A(b2, j2, j3);
                    if (A != -1) {
                        return A;
                    }
                    long size = this.f41373c.size();
                    if (size >= j3 || this.f41372b.read(this.f41373c, 8192) == -1) {
                        return -1;
                    }
                    j2 = Math.max(j2, size);
                }
                return -1;
            }
            throw new IllegalArgumentException(("fromIndex=" + j2 + " toIndex=" + j3).toString());
        }
        throw new IllegalStateException("closed".toString());
    }

    public String f0() {
        this.f41373c.y(this.f41372b);
        return this.f41373c.f0();
    }

    public boolean i(long j2, ByteString byteString, int i2, int i3) {
        Intrinsics.f(byteString, "bytes");
        if (!this.f41374d) {
            if (j2 >= 0 && i2 >= 0 && i3 >= 0 && byteString.size() - i2 >= i3) {
                int i4 = 0;
                while (i4 < i3) {
                    long j3 = ((long) i4) + j2;
                    if (request(1 + j3) && this.f41373c.z(j3) == byteString.f(i2 + i4)) {
                        i4++;
                    }
                }
                return true;
            }
            return false;
        }
        throw new IllegalStateException("closed".toString());
    }

    public long i0(Sink sink) {
        Intrinsics.f(sink, "sink");
        long j2 = 0;
        while (this.f41372b.read(this.f41373c, 8192) != -1) {
            long i2 = this.f41373c.i();
            if (i2 > 0) {
                j2 += i2;
                sink.write(this.f41373c, i2);
            }
        }
        if (this.f41373c.size() <= 0) {
            return j2;
        }
        long size = j2 + this.f41373c.size();
        Buffer buffer = this.f41373c;
        sink.write(buffer, buffer.size());
        return size;
    }

    public boolean isOpen() {
        return !this.f41374d;
    }

    public int k() {
        N(4);
        return this.f41373c.o0();
    }

    public long l0() {
        N(1);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (!request((long) i3)) {
                break;
            }
            byte z2 = this.f41373c.z((long) i2);
            if ((z2 >= 48 && z2 <= 57) || ((z2 >= 97 && z2 <= 102) || (z2 >= 65 && z2 <= 70))) {
                i2 = i3;
            } else if (i2 == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Expected leading [0-9a-fA-F] character but was 0x");
                String num = Integer.toString(z2, CharsKt__CharJVMKt.a(CharsKt__CharJVMKt.a(16)));
                Intrinsics.e(num, "toString(this, checkRadix(radix))");
                sb.append(num);
                throw new NumberFormatException(sb.toString());
            }
        }
        return this.f41373c.l0();
    }

    public int n0(Options options) {
        Intrinsics.f(options, "options");
        if (!this.f41374d) {
            while (true) {
                int e2 = Buffer.e(this.f41373c, options, true);
                if (e2 == -2) {
                    if (this.f41372b.read(this.f41373c, 8192) == -1) {
                        break;
                    }
                } else if (e2 != -1) {
                    this.f41373c.skip((long) options.e()[e2].size());
                    return e2;
                }
            }
            return -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public void p(Buffer buffer, long j2) {
        Intrinsics.f(buffer, "sink");
        try {
            N(j2);
            this.f41373c.p(buffer, j2);
        } catch (EOFException e2) {
            buffer.y(this.f41373c);
            throw e2;
        }
    }

    public BufferedSource peek() {
        return Okio.d(new PeekSource(this));
    }

    public short q() {
        N(2);
        return this.f41373c.p0();
    }

    public long read(Buffer buffer, long j2) {
        Intrinsics.f(buffer, "sink");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        } else if (!(true ^ this.f41374d)) {
            throw new IllegalStateException("closed".toString());
        } else if (this.f41373c.size() == 0 && this.f41372b.read(this.f41373c, 8192) == -1) {
            return -1;
        } else {
            return this.f41373c.read(buffer, Math.min(j2, this.f41373c.size()));
        }
    }

    public byte readByte() {
        N(1);
        return this.f41373c.readByte();
    }

    public void readFully(byte[] bArr) {
        Intrinsics.f(bArr, "sink");
        try {
            N((long) bArr.length);
            this.f41373c.readFully(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (this.f41373c.size() > 0) {
                Buffer buffer = this.f41373c;
                int read = buffer.read(bArr, i2, (int) buffer.size());
                if (read != -1) {
                    i2 += read;
                } else {
                    throw new AssertionError();
                }
            }
            throw e2;
        }
    }

    public int readInt() {
        N(4);
        return this.f41373c.readInt();
    }

    public long readLong() {
        N(8);
        return this.f41373c.readLong();
    }

    public short readShort() {
        N(2);
        return this.f41373c.readShort();
    }

    public boolean request(long j2) {
        boolean z2;
        if (j2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        } else if (!this.f41374d) {
            while (this.f41373c.size() < j2) {
                if (this.f41372b.read(this.f41373c, 8192) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public void skip(long j2) {
        if (!this.f41374d) {
            while (j2 > 0) {
                if (this.f41373c.size() == 0 && this.f41372b.read(this.f41373c, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j2, this.f41373c.size());
                this.f41373c.skip(min);
                j2 -= min;
            }
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public String t(long j2) {
        boolean z2;
        long j3;
        if (j2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (j2 == Clock.MAX_TIME) {
                j3 = Long.MAX_VALUE;
            } else {
                j3 = j2 + 1;
            }
            long f2 = f((byte) 10, 0, j3);
            if (f2 != -1) {
                return Buffer.d(this.f41373c, f2);
            }
            if (j3 < Clock.MAX_TIME && request(j3) && this.f41373c.z(j3 - 1) == 13 && request(1 + j3) && this.f41373c.z(j3) == 10) {
                return Buffer.d(this.f41373c, j3);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = this.f41373c;
            buffer2.q(buffer, 0, Math.min((long) 32, buffer2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f41373c.size(), j2) + " content=" + buffer.c0().k() + 8230);
        }
        throw new IllegalArgumentException(("limit < 0: " + j2).toString());
    }

    public Timeout timeout() {
        return this.f41372b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f41372b + ')';
    }

    public boolean x(long j2, ByteString byteString) {
        Intrinsics.f(byteString, "bytes");
        return i(j2, byteString, 0, byteString.size());
    }

    public int read(ByteBuffer byteBuffer) {
        Intrinsics.f(byteBuffer, "sink");
        if (this.f41373c.size() == 0 && this.f41372b.read(this.f41373c, 8192) == -1) {
            return -1;
        }
        return this.f41373c.read(byteBuffer);
    }
}
