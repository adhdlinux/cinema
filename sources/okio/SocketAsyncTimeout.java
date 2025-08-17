package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;

final class SocketAsyncTimeout extends AsyncTimeout {

    /* renamed from: a  reason: collision with root package name */
    private final Socket f41391a;

    public SocketAsyncTimeout(Socket socket) {
        Intrinsics.f(socket, "socket");
        this.f41391a = socket;
    }

    /* access modifiers changed from: protected */
    public IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    /* access modifiers changed from: protected */
    public void timedOut() {
        try {
            this.f41391a.close();
        } catch (Exception e2) {
            Logger a2 = Okio__JvmOkioKt.f41356a;
            Level level = Level.WARNING;
            a2.log(level, "Failed to close timed out socket " + this.f41391a, e2);
        } catch (AssertionError e3) {
            if (Okio.e(e3)) {
                Logger a3 = Okio__JvmOkioKt.f41356a;
                Level level2 = Level.WARNING;
                a3.log(level2, "Failed to close timed out socket " + this.f41391a, e3);
                return;
            }
            throw e3;
        }
    }
}
