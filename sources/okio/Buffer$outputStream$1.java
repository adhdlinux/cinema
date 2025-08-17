package okio;

import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

public final class Buffer$outputStream$1 extends OutputStream {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Buffer f41330b;

    Buffer$outputStream$1(Buffer buffer) {
        this.f41330b = buffer;
    }

    public void close() {
    }

    public void flush() {
    }

    public String toString() {
        return this.f41330b + ".outputStream()";
    }

    public void write(int i2) {
        this.f41330b.writeByte(i2);
    }

    public void write(byte[] bArr, int i2, int i3) {
        Intrinsics.f(bArr, "data");
        this.f41330b.write(bArr, i2, i3);
    }
}
