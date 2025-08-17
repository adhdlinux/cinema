package okhttp3.internal.platform;

import java.security.KeyStore;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;

public final class BouncyCastlePlatform extends Platform {
    public static final Companion Companion;
    /* access modifiers changed from: private */
    public static final boolean isSupported;
    private final Provider provider;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BouncyCastlePlatform buildIfSupported() {
            if (isSupported()) {
                return new BouncyCastlePlatform((DefaultConstructorMarker) null);
            }
            return null;
        }

        public final boolean isSupported() {
            return BouncyCastlePlatform.isSupported;
        }
    }

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        boolean z2 = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, companion.getClass().getClassLoader());
            z2 = true;
        } catch (ClassNotFoundException unused) {
        }
        isSupported = z2;
    }

    private BouncyCastlePlatform() {
        this.provider = new BouncyCastleJsseProvider();
    }

    public /* synthetic */ BouncyCastlePlatform(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        Intrinsics.f(sSLSocket, "sslSocket");
        Intrinsics.f(list, "protocols");
        if (sSLSocket instanceof BCSSLSocket) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            parameters.setApplicationProtocols((String[]) Platform.Companion.alpnProtocolNames(list).toArray(new String[0]));
            bCSSLSocket.setParameters(parameters);
            return;
        }
        super.configureTlsExtensions(sSLSocket, str, list);
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        boolean z2;
        Intrinsics.f(sSLSocket, "sslSocket");
        if (!(sSLSocket instanceof BCSSLSocket)) {
            return super.getSelectedProtocol(sSLSocket);
        }
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null) {
            z2 = true;
        } else {
            z2 = Intrinsics.a(applicationProtocol, "");
        }
        if (z2) {
            return null;
        }
        return applicationProtocol;
    }

    public SSLContext newSSLContext() {
        SSLContext instance = SSLContext.getInstance("TLS", this.provider);
        Intrinsics.e(instance, "getInstance(\"TLS\", provider)");
        return instance;
    }

    public X509TrustManager platformTrustManager() {
        TrustManagerFactory instance = TrustManagerFactory.getInstance("PKIX", "BCJSSE");
        instance.init((KeyStore) null);
        TrustManager[] trustManagers = instance.getTrustManagers();
        Intrinsics.c(trustManagers);
        boolean z2 = true;
        if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
            z2 = false;
        }
        if (z2) {
            TrustManager trustManager = trustManagers[0];
            Intrinsics.d(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            return (X509TrustManager) trustManager;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected default trust managers: ");
        String arrays = Arrays.toString(trustManagers);
        Intrinsics.e(arrays, "toString(this)");
        sb.append(arrays);
        throw new IllegalStateException(sb.toString().toString());
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        Intrinsics.f(sSLSocketFactory, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported with BouncyCastle");
    }
}
