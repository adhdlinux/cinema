package okhttp3.internal.platform.android;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.tls.CertificateChainCleaner;

@SuppressSignatureCheck
public final class AndroidCertificateChainCleaner extends CertificateChainCleaner {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final X509TrustManager trustManager;
    private final X509TrustManagerExtensions x509TrustManagerExtensions;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @SuppressSignatureCheck
        public final AndroidCertificateChainCleaner buildIfSupported(X509TrustManager x509TrustManager) {
            X509TrustManagerExtensions x509TrustManagerExtensions;
            Intrinsics.f(x509TrustManager, "trustManager");
            try {
                x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
            } catch (IllegalArgumentException unused) {
                x509TrustManagerExtensions = null;
            }
            if (x509TrustManagerExtensions != null) {
                return new AndroidCertificateChainCleaner(x509TrustManager, x509TrustManagerExtensions);
            }
            return null;
        }
    }

    public AndroidCertificateChainCleaner(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions2) {
        Intrinsics.f(x509TrustManager, "trustManager");
        Intrinsics.f(x509TrustManagerExtensions2, "x509TrustManagerExtensions");
        this.trustManager = x509TrustManager;
        this.x509TrustManagerExtensions = x509TrustManagerExtensions2;
    }

    @SuppressSignatureCheck
    public List<Certificate> clean(List<? extends Certificate> list, String str) throws SSLPeerUnverifiedException {
        Intrinsics.f(list, "chain");
        Intrinsics.f(str, "hostname");
        try {
            List<X509Certificate> checkServerTrusted = this.x509TrustManagerExtensions.checkServerTrusted((X509Certificate[]) list.toArray(new X509Certificate[0]), "RSA", str);
            Intrinsics.e(checkServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
            return checkServerTrusted;
        } catch (CertificateException e2) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
            sSLPeerUnverifiedException.initCause(e2);
            throw sSLPeerUnverifiedException;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AndroidCertificateChainCleaner) || ((AndroidCertificateChainCleaner) obj).trustManager != this.trustManager) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return System.identityHashCode(this.trustManager);
    }
}
