package okio;

import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

public final class Buffer$inputStream$1 extends InputStream {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Buffer f41329b;

    Buffer$inputStream$1(Buffer buffer) {
        this.f41329b = buffer;
    }

    public int available() {
        return (int) Math.min(this.f41329b.size(), (long) Integer.MAX_VALUE);
    }

    public void close() {
    }

    public int read() {
        if (this.f41329b.size() > 0) {
            return this.f41329b.readByte() & 255;
        }
        return -1;
    }

    public String toString() {
        return this.f41329b + ".inputStream()";
    }

    public int read(byte[] bArr, int i2, int i3) {
        Intrinsics.f(bArr, "sink");
        return this.f41329b.read(bArr, i2, i3);
    }
}
