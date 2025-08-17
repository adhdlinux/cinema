package com.startapp;

import android.content.Context;
import com.startapp.networkTest.enums.CtTestTypes;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class d1 implements X509TrustManager {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f34323a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final String f34324b = "d1";

    /* renamed from: c  reason: collision with root package name */
    private static String f34325c = "";

    /* renamed from: d  reason: collision with root package name */
    private static boolean f34326d = false;

    /* renamed from: e  reason: collision with root package name */
    private static X509TrustManager f34327e = null;

    /* renamed from: f  reason: collision with root package name */
    private static X509TrustManager f34328f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final String f34329g = "R_hqKukfFZxKn52";

    /* renamed from: h  reason: collision with root package name */
    private static final X509TrustManager f34330h = new a();

    /* renamed from: i  reason: collision with root package name */
    private X509TrustManager[] f34331i;

    /* renamed from: j  reason: collision with root package name */
    private CtTestTypes[] f34332j;

    /* renamed from: k  reason: collision with root package name */
    private String f34333k = "";

    /* renamed from: l  reason: collision with root package name */
    private CtTestTypes f34334l = CtTestTypes.Unknown;

    public class a implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public d1(Context context, boolean z2) {
        a(context, z2);
        X509TrustManager[] x509TrustManagerArr = new X509TrustManager[3];
        this.f34331i = x509TrustManagerArr;
        CtTestTypes[] ctTestTypesArr = new CtTestTypes[3];
        this.f34332j = ctTestTypesArr;
        x509TrustManagerArr[0] = f34327e;
        ctTestTypesArr[0] = CtTestTypes.SSLOwnTs;
        x509TrustManagerArr[1] = f34328f;
        ctTestTypesArr[1] = CtTestTypes.SSLDeviceTs;
        x509TrustManagerArr[2] = f34330h;
        ctTestTypesArr[2] = CtTestTypes.SSLTrustAll;
        this.f34333k = f34325c;
    }

    public String a() {
        return this.f34333k;
    }

    public CtTestTypes b() {
        return this.f34334l;
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        int i2 = 0;
        while (true) {
            X509TrustManager[] x509TrustManagerArr = this.f34331i;
            if (i2 < x509TrustManagerArr.length) {
                X509TrustManager x509TrustManager = x509TrustManagerArr[i2];
                if (x509TrustManager != null) {
                    try {
                        this.f34334l = this.f34332j[i2];
                        x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                        return;
                    } catch (CertificateException e2) {
                        if (i2 == 0) {
                            this.f34333k += e2.getMessage();
                        }
                        if (i2 + 1 == this.f34331i.length) {
                            throw e2;
                        }
                    }
                } else {
                    i2++;
                }
            } else {
                return;
            }
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return f34328f.getAcceptedIssuers();
    }

    private void a(Context context, boolean z2) {
        if (!f34326d || z2) {
            synchronized (d1.class) {
                if (!f34326d || z2) {
                    f34325c = "";
                    int i2 = 0;
                    try {
                        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                        instance.init((KeyStore) null);
                        TrustManager[] trustManagers = instance.getTrustManagers();
                        int length = trustManagers.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                                break;
                            }
                            TrustManager trustManager = trustManagers[i3];
                            if (trustManager instanceof X509TrustManager) {
                                f34328f = (X509TrustManager) trustManager;
                                break;
                            }
                            i3++;
                        }
                    } catch (Throwable th) {
                        l2.a(th);
                        f34325c += th.getMessage();
                    }
                    try {
                        File c2 = h3.c(context);
                        File d2 = h3.d(context);
                        if (!c2.exists() || !d2.exists()) {
                            throw new KeyStoreException("Downloaded truststore not available");
                        }
                        if (w0.b().CONNECTIVITY_TEST_VERIFY_TRUSTSTORE_SIGNATURE() ? h3.a(c2, d2) : true) {
                            FileInputStream fileInputStream = new FileInputStream(c2);
                            KeyStore instance2 = KeyStore.getInstance("BKS");
                            instance2.load(fileInputStream, f34329g.toCharArray());
                            fileInputStream.close();
                            TrustManagerFactory instance3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                            instance3.init(instance2);
                            TrustManager[] trustManagers2 = instance3.getTrustManagers();
                            int length2 = trustManagers2.length;
                            while (true) {
                                if (i2 >= length2) {
                                    break;
                                }
                                TrustManager trustManager2 = trustManagers2[i2];
                                if (trustManager2 instanceof X509TrustManager) {
                                    f34327e = (X509TrustManager) trustManager2;
                                    break;
                                }
                                i2++;
                            }
                            f34326d = true;
                            return;
                        }
                        throw new KeyStoreException("Verification of downloaded truststore failed");
                    } catch (Throwable th2) {
                        l2.a(th2);
                        f34325c += th2.getMessage();
                    }
                } else {
                    return;
                }
            }
        } else {
            return;
        }
    }
}
