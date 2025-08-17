package okhttp3.internal.platform.android;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import android.os.Build;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.android.SocketAdapter;

@SuppressSignatureCheck
@SuppressLint({"NewApi"})
public final class Android10SocketAdapter implements SocketAdapter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @SuppressSignatureCheck
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SocketAdapter buildIfSupported() {
            if (isSupported()) {
                return new Android10SocketAdapter();
            }
            return null;
        }

        public final boolean isSupported() {
            return Platform.Companion.isAndroid() && Build.VERSION.SDK_INT >= 29;
        }
    }

    @SuppressLint({"NewApi"})
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        Intrinsics.f(sSLSocket, "sslSocket");
        Intrinsics.f(list, "protocols");
        try {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            sSLParameters.setApplicationProtocols((String[]) Platform.Companion.alpnProtocolNames(list).toArray(new String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e2) {
            throw new IOException("Android internal error", e2);
        }
    }

    @SuppressLint({"NewApi"})
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        boolean z2;
        Intrinsics.f(sSLSocket, "sslSocket");
        String a2 = sSLSocket.getApplicationProtocol();
        if (a2 == null) {
            z2 = true;
        } else {
            z2 = Intrinsics.a(a2, "");
        }
        if (z2) {
            return null;
        }
        return a2;
    }

    public boolean isSupported() {
        return Companion.isSupported();
    }

    public boolean matchesSocket(SSLSocket sSLSocket) {
        Intrinsics.f(sSLSocket, "sslSocket");
        return SSLSockets.isSupportedSocket(sSLSocket);
    }

    public boolean matchesSocketFactory(SSLSocketFactory sSLSocketFactory) {
        return SocketAdapter.DefaultImpls.matchesSocketFactory(this, sSLSocketFactory);
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        return SocketAdapter.DefaultImpls.trustManager(this, sSLSocketFactory);
    }
}
