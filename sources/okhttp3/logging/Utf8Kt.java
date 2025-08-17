package okhttp3.logging;

import java.io.EOFException;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

public final class Utf8Kt {
    public static final boolean isProbablyUtf8(Buffer buffer) {
        Intrinsics.g(buffer, "$this$isProbablyUtf8");
        try {
            Buffer buffer2 = new Buffer();
            buffer.q(buffer2, 0, RangesKt___RangesKt.e(buffer.size(), 64));
            for (int i2 = 0; i2 < 16; i2++) {
                if (buffer2.V()) {
                    return true;
                }
                int s02 = buffer2.s0();
                if (Character.isISOControl(s02) && !Character.isWhitespace(s02)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
