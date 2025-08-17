package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;

final /* synthetic */ class Okio__JvmOkioKt {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f41356a = Logger.getLogger("okio.Okio");

    public static final Sink b(File file) throws FileNotFoundException {
        Intrinsics.f(file, "<this>");
        return Okio.h(new FileOutputStream(file, true));
    }

    public static final boolean c(AssertionError assertionError) {
        boolean z2;
        Intrinsics.f(assertionError, "<this>");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        if (message != null) {
            z2 = StringsKt__StringsKt.L(message, "getsockname failed", false, 2, (Object) null);
        } else {
            z2 = false;
        }
        if (z2) {
            return true;
        }
        return false;
    }

    public static final Sink d(File file) throws FileNotFoundException {
        Intrinsics.f(file, "<this>");
        return h(file, false, 1, (Object) null);
    }

    public static final Sink e(File file, boolean z2) throws FileNotFoundException {
        Intrinsics.f(file, "<this>");
        return Okio.h(new FileOutputStream(file, z2));
    }

    public static final Sink f(OutputStream outputStream) {
        Intrinsics.f(outputStream, "<this>");
        return new OutputStreamSink(outputStream, new Timeout());
    }

    public static final Sink g(Socket socket) throws IOException {
        Intrinsics.f(socket, "<this>");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        OutputStream outputStream = socket.getOutputStream();
        Intrinsics.e(outputStream, "getOutputStream(...)");
        return socketAsyncTimeout.sink(new OutputStreamSink(outputStream, socketAsyncTimeout));
    }

    public static /* synthetic */ Sink h(File file, boolean z2, int i2, Object obj) throws FileNotFoundException {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        return Okio.g(file, z2);
    }

    public static final Source i(File file) throws FileNotFoundException {
        Intrinsics.f(file, "<this>");
        return new InputStreamSource(new FileInputStream(file), Timeout.NONE);
    }

    public static final Source j(InputStream inputStream) {
        Intrinsics.f(inputStream, "<this>");
        return new InputStreamSource(inputStream, new Timeout());
    }

    public static final Source k(Socket socket) throws IOException {
        Intrinsics.f(socket, "<this>");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        InputStream inputStream = socket.getInputStream();
        Intrinsics.e(inputStream, "getInputStream(...)");
        return socketAsyncTimeout.source(new InputStreamSource(inputStream, socketAsyncTimeout));
    }
}
