package com.startapp.networkTest.net;

import com.facebook.common.util.UriUtil;
import com.startapp.b2;
import com.startapp.c2;
import com.startapp.l2;
import com.startapp.z2;
import com.uwetrottmann.thetvdb.TheTvdb;
import com.uwetrottmann.trakt5.TraktV2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public abstract class WebApiClient {

    /* renamed from: a  reason: collision with root package name */
    private static final String f35422a = "WebApiClient";

    /* renamed from: b  reason: collision with root package name */
    private static final int f35423b = 10000;

    public enum RequestMethod {
        POST,
        GET,
        PUT,
        DELETE
    }

    public class a implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public static c2 a(RequestMethod requestMethod, String str) throws IOException {
        return a(requestMethod, str, (Object) null);
    }

    public static c2 a(RequestMethod requestMethod, String str, Object obj) throws IOException {
        return a(requestMethod, str, obj, new b2[]{new b2(TraktV2.HEADER_CONTENT_TYPE, "application/json; charset=UTF-8"), new b2(TheTvdb.HEADER_ACCEPT, TraktV2.CONTENT_TYPE_JSON)});
    }

    public static c2 a(RequestMethod requestMethod, String str, Object obj, b2[] b2VarArr) throws IOException {
        return a(requestMethod, str, obj, b2VarArr, false);
    }

    public static c2 a(RequestMethod requestMethod, String str, Object obj, b2[] b2VarArr, boolean z2) throws IOException {
        HttpsURLConnection httpsURLConnection;
        c2 c2Var = new c2();
        URL url = new URL(str);
        URL url2 = new URL(str);
        if (!z2 || !url2.getProtocol().toLowerCase().equals(UriUtil.HTTPS_SCHEME)) {
            httpsURLConnection = (HttpURLConnection) url.openConnection();
        } else {
            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
            a(httpsURLConnection2);
            httpsURLConnection2.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            httpsURLConnection = httpsURLConnection2;
        }
        httpsURLConnection.setRequestMethod(requestMethod.toString());
        if (b2VarArr != null) {
            for (b2 b2Var : b2VarArr) {
                httpsURLConnection.setRequestProperty(b2Var.f34235a, b2Var.f34236b);
            }
        }
        httpsURLConnection.setConnectTimeout(f35423b);
        httpsURLConnection.setReadTimeout(f35423b);
        if (obj != null) {
            if (requestMethod.equals(RequestMethod.GET) || requestMethod.equals(RequestMethod.DELETE)) {
                throw new IOException("GET and DELETE does not support a body");
            }
            httpsURLConnection.setDoOutput(true);
            String a2 = z2.a(obj);
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            outputStream.write(a2.getBytes());
            outputStream.flush();
            outputStream.close();
        }
        c2Var.f34282a = httpsURLConnection.getResponseCode();
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            bufferedReader.close();
        } catch (Throwable th) {
            l2.a(th);
        }
        httpsURLConnection.disconnect();
        c2Var.f34283b = sb.toString();
        return c2Var;
    }

    private static void a(HttpsURLConnection httpsURLConnection) {
        TrustManager[] trustManagerArr = {new a()};
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, trustManagerArr, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(instance.getSocketFactory());
        } catch (Throwable th) {
            l2.a(th);
        }
    }
}
