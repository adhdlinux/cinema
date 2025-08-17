package okhttp3.internal.platform;

import java.security.KeyStore;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;

public final class ConscryptPlatform extends Platform {
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

        public static /* synthetic */ boolean atLeastVersion$default(Companion companion, int i2, int i3, int i4, int i5, Object obj) {
            if ((i5 & 2) != 0) {
                i3 = 0;
            }
            if ((i5 & 4) != 0) {
                i4 = 0;
            }
            return companion.atLeastVersion(i2, i3, i4);
        }

        public final boolean atLeastVersion(int i2, int i3, int i4) {
            Conscrypt.Version version = Conscrypt.version();
            if (version.major() != i2) {
                if (version.major() > i2) {
                    return true;
                }
                return false;
            } else if (version.minor() != i3) {
                if (version.minor() > i3) {
                    return true;
                }
                return false;
            } else if (version.patch() >= i4) {
                return true;
            } else {
                return false;
            }
        }

        public final ConscryptPlatform buildIfSupported() {
            if (isSupported()) {
                return new ConscryptPlatform((DefaultConstructorMarker) null);
            }
            return null;
        }

        public final boolean isSupported() {
            return ConscryptPlatform.isSupported;
        }
    }

    public static final class DisabledHostnameVerifier implements ConscryptHostnameVerifier {
        public static final DisabledHostnameVerifier INSTANCE = new DisabledHostnameVerifier();

        private DisabledHostnameVerifier() {
        }

        public final boolean verify(String str, SSLSession sSLSession) {
            return true;
        }

        public boolean verify(X509Certificate[] x509CertificateArr, String str, SSLSession sSLSession) {
            return true;
        }
    }

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        boolean z2 = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, companion.getClass().getClassLoader());
            if (Conscrypt.isAvailable() && companion.atLeastVersion(2, 1, 0)) {
                z2 = true;
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        isSupported = z2;
    }

    private ConscryptPlatform() {
        Provider newProvider = Conscrypt.newProvider();
        Intrinsics.e(newProvider, "newProvider()");
        this.provider = newProvider;
    }

    public /* synthetic */ ConscryptPlatform(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        Intrinsics.f(sSLSocket, "sslSocket");
        Intrinsics.f(list, "protocols");
        if (Conscrypt.isConscrypt(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) Platform.Companion.alpnProtocolNames(list).toArray(new String[0]));
            return;
        }
        super.configureTlsExtensions(sSLSocket, str, list);
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        Intrinsics.f(sSLSocket, "sslSocket");
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return super.getSelectedProtocol(sSLSocket);
    }

    public SSLContext newSSLContext() {
        SSLContext instance = SSLContext.getInstance("TLS", this.provider);
        Intrinsics.e(instance, "getInstance(\"TLS\", provider)");
        return instance;
    }

    public SSLSocketFactory newSslSocketFactory(X509TrustManager x509TrustManager) {
        Intrinsics.f(x509TrustManager, "trustManager");
        SSLContext newSSLContext = newSSLContext();
        newSSLContext.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
        SSLSocketFactory socketFactory = newSSLContext.getSocketFactory();
        Intrinsics.e(socketFactory, "newSSLContext().apply {\n…null)\n    }.socketFactory");
        return socketFactory;
    }

    public X509TrustManager platformTrustManager() {
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
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
            X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
            Conscrypt.setHostnameVerifier(x509TrustManager, DisabledHostnameVerifier.INSTANCE);
            return x509TrustManager;
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
        return null;
    }
}
