package com.movie.ui.activity.player.utils;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public final class SSLTrustManager implements X509TrustManager {
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
