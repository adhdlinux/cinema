package okio;

import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

public final class RealBufferedSource$inputStream$1 extends InputStream {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ RealBufferedSource f41375b;

    RealBufferedSource$inputStream$1(RealBufferedSource realBufferedSource) {
        this.f41375b = realBufferedSource;
    }

    public int available() {
        RealBufferedSource realBufferedSource = this.f41375b;
        if (!realBufferedSource.f41374d) {
            return (int) Math.min(realBufferedSource.f41373c.size(), (long) Integer.MAX_VALUE);
        }
        throw new IOException("closed");
    }

    public void close() {
        this.f41375b.close();
    }

    public int read() {
        RealBufferedSource realBufferedSource = this.f41375b;
        if (!realBufferedSource.f41374d) {
            if (realBufferedSource.f41373c.size() == 0) {
                RealBufferedSource realBufferedSource2 = this.f41375b;
                if (realBufferedSource2.f41372b.read(realBufferedSource2.f41373c, 8192) == -1) {
                    return -1;
                }
            }
            return this.f41375b.f41373c.readByte() & 255;
        }
        throw new IOException("closed");
    }

    public String toString() {
        return this.f41375b + ".inputStream()";
    }

    public int read(byte[] bArr, int i2, int i3) {
        Intrinsics.f(bArr, "data");
        if (!this.f41375b.f41374d) {
            SegmentedByteString.b((long) bArr.length, (long) i2, (long) i3);
            if (this.f41375b.f41373c.size() == 0) {
                RealBufferedSource realBufferedSource = this.f41375b;
                if (realBufferedSource.f41372b.read(realBufferedSource.f41373c, 8192) == -1) {
                    return -1;
                }
            }
            return this.f41375b.f41373c.read(bArr, i2, i3);
        }
        throw new IOException("closed");
    }
}
