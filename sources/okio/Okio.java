package okio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public final class Okio {
    public static final Sink a(File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.b(file);
    }

    public static final Sink b() {
        return Okio__OkioKt.a();
    }

    public static final BufferedSink c(Sink sink) {
        return Okio__OkioKt.b(sink);
    }

    public static final BufferedSource d(Source source) {
        return Okio__OkioKt.c(source);
    }

    public static final boolean e(AssertionError assertionError) {
        return Okio__JvmOkioKt.c(assertionError);
    }

    public static final Sink f(File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.d(file);
    }

    public static final Sink g(File file, boolean z2) throws FileNotFoundException {
        return Okio__JvmOkioKt.e(file, z2);
    }

    public static final Sink h(OutputStream outputStream) {
        return Okio__JvmOkioKt.f(outputStream);
    }

    public static final Sink i(Socket socket) throws IOException {
        return Okio__JvmOkioKt.g(socket);
    }

    public static final Source k(File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.i(file);
    }

    public static final Source l(InputStream inputStream) {
        return Okio__JvmOkioKt.j(inputStream);
    }

    public static final Source m(Socket socket) throws IOException {
        return Okio__JvmOkioKt.k(socket);
    }
}
