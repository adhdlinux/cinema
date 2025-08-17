package kotlin.io;

import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

public final class ByteStreamsKt {
    public static final long a(InputStream inputStream, OutputStream outputStream, int i2) {
        Intrinsics.f(inputStream, "<this>");
        Intrinsics.f(outputStream, "out");
        byte[] bArr = new byte[i2];
        int read = inputStream.read(bArr);
        long j2 = 0;
        while (read >= 0) {
            outputStream.write(bArr, 0, read);
            j2 += (long) read;
            read = inputStream.read(bArr);
        }
        return j2;
    }
}
