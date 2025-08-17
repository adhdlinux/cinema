package com.original.tase.helper.http;

import com.original.Constants;
import com.original.tase.Logger;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Http2Helper {

    /* renamed from: b  reason: collision with root package name */
    private static volatile Http2Helper f33889b;

    /* renamed from: c  reason: collision with root package name */
    private static final TrustManager[] f33890c;

    /* renamed from: d  reason: collision with root package name */
    private static final SSLContext f33891d;

    /* renamed from: e  reason: collision with root package name */
    private static final SSLSocketFactory f33892e;

    /* renamed from: a  reason: collision with root package name */
    private OkHttpClient f33893a;

    static {
        TrustManager[] trustManagerArr = {new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }};
        f33890c = trustManagerArr;
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            f33891d = instance;
            instance.init((KeyManager[]) null, trustManagerArr, new SecureRandom());
            f33892e = instance.getSocketFactory();
        } catch (KeyManagementException | NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    private Http2Helper() {
        if (this.f33893a == null) {
            this.f33893a = a();
        }
    }

    private OkHttpClient a() {
        return new OkHttpClient();
    }

    public static Http2Helper b() {
        if (f33889b == null) {
            synchronized (Http2Helper.class) {
                if (f33889b == null) {
                    f33889b = new Http2Helper();
                }
            }
        }
        return f33889b;
    }

    public String c(String str, String str2, Map<String, String>... mapArr) {
        Map<String, String> map;
        if (str.isEmpty()) {
            return null;
        }
        Request.Builder tag = new Request.Builder().url(str).addHeader("User-Agent", Constants.C).tag(HttpHelper.f33895d);
        if (!(mapArr == null || mapArr.length <= 0 || (map = mapArr[0]) == null)) {
            for (Map.Entry next : map.entrySet()) {
                if (((String) next.getKey()).toLowerCase().equals("user-agent")) {
                    tag.header("User-Agent", (String) next.getValue());
                } else {
                    tag.addHeader((String) next.getKey(), (String) next.getValue());
                }
            }
        }
        try {
            Response execute = this.f33893a.newCall(tag.url(str).post(RequestBody.create(str2, MediaType.parse("application/x-www-form-urlencoded"))).build()).execute();
            if (execute == null) {
                return null;
            }
            if (execute.code() == 200 || (execute.code() == 301 && execute.code() == 302 && execute.code() == 307 && execute.code() == 308)) {
                return execute.body().string();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String d(String str, Map<String, String>... mapArr) {
        Map<String, String> map;
        if (str.isEmpty()) {
            return null;
        }
        Request.Builder tag = new Request.Builder().url(str).addHeader("User-Agent", Constants.C).tag(HttpHelper.f33895d);
        if (!(mapArr == null || mapArr.length <= 0 || (map = mapArr[0]) == null)) {
            for (Map.Entry next : map.entrySet()) {
                if (((String) next.getKey()).toLowerCase().equals("user-agent")) {
                    tag.header("User-Agent", (String) next.getValue());
                } else {
                    tag.addHeader((String) next.getKey(), (String) next.getValue());
                }
            }
        }
        try {
            Response execute = this.f33893a.newCall(tag.url(str).build()).execute();
            if (execute == null) {
                return null;
            }
            if (execute.code() == 200 || (execute.code() == 301 && execute.code() == 302 && execute.code() == 307 && execute.code() == 308)) {
                return execute.body().string();
            }
            return null;
        } catch (Throwable th) {
            Logger.a(th.toString());
            return null;
        }
    }
}
