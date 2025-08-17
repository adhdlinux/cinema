package com.facebook.ads.internal.p.a;

import android.util.Base64;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;

public class o {
    private static String a(byte[] bArr, String str) {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.reset();
        return Base64.encodeToString(instance.digest(bArr), 0);
    }

    public static void a(HttpsURLConnection httpsURLConnection, Set<String> set, Set<String> set2) {
        try {
            Certificate[] serverCertificates = httpsURLConnection.getServerCertificates();
            int length = serverCertificates.length;
            int i2 = 0;
            while (i2 < length) {
                X509Certificate x509Certificate = (X509Certificate) serverCertificates[i2];
                String a2 = a(x509Certificate.getEncoded(), "SHA-1");
                if (set == null || !set.contains(a2)) {
                    String a3 = a(x509Certificate.getPublicKey().getEncoded(), "SHA-1");
                    if (set2 == null || !set2.contains(a3)) {
                        i2++;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            throw new CertificateException("Unable to find valid certificate or public key.");
        } catch (Exception e2) {
            throw e2;
        }
    }
}
