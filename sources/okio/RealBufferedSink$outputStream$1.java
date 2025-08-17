package okio;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

public final class RealBufferedSink$outputStream$1 extends OutputStream {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ RealBufferedSink f41371b;

    RealBufferedSink$outputStream$1(RealBufferedSink realBufferedSink) {
        this.f41371b = realBufferedSink;
    }

    public void close() {
        this.f41371b.close();
    }

    public void flush() {
        RealBufferedSink realBufferedSink = this.f41371b;
        if (!realBufferedSink.f41370d) {
            realBufferedSink.flush();
        }
    }

    public String toString() {
        return this.f41371b + ".outputStream()";
    }

    public void write(int i2) {
        RealBufferedSink realBufferedSink = this.f41371b;
        if (!realBufferedSink.f41370d) {
            realBufferedSink.f41369c.writeByte((byte) i2);
            this.f41371b.r();
            return;
        }
        throw new IOException("closed");
    }

    public void write(byte[] bArr, int i2, int i3) {
        Intrinsics.f(bArr, "data");
        RealBufferedSink realBufferedSink = this.f41371b;
        if (!realBufferedSink.f41370d) {
            realBufferedSink.f41369c.write(bArr, i2, i3);
            this.f41371b.r();
            return;
        }
        throw new IOException("closed");
    }
}
