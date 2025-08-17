package kotlin.io;

import java.io.Closeable;

public final class CloseableKt {
    public static final void a(Closeable closeable, Throwable th) {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            ExceptionsKt__ExceptionsKt.a(th, th2);
        }
    }
}
