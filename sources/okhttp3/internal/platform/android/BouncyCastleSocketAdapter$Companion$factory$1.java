package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.BouncyCastlePlatform;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import org.bouncycastle.jsse.BCSSLSocket;

public final class BouncyCastleSocketAdapter$Companion$factory$1 implements DeferredSocketAdapter.Factory {
    BouncyCastleSocketAdapter$Companion$factory$1() {
    }

    public SocketAdapter create(SSLSocket sSLSocket) {
        Intrinsics.f(sSLSocket, "sslSocket");
        return new BouncyCastleSocketAdapter();
    }

    public boolean matchesSocket(SSLSocket sSLSocket) {
        Intrinsics.f(sSLSocket, "sslSocket");
        if (!BouncyCastlePlatform.Companion.isSupported() || !(sSLSocket instanceof BCSSLSocket)) {
            return false;
        }
        return true;
    }
}
