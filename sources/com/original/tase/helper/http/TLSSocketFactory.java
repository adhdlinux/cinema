package com.original.tase.helper.http;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class TLSSocketFactory extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    private SSLSocketFactory f33899a;

    /* renamed from: b  reason: collision with root package name */
    private TrustManager[] f33900b;

    public TLSSocketFactory() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        b();
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init((KeyManager[]) null, this.f33900b, (SecureRandom) null);
        this.f33899a = instance.getSocketFactory();
    }

    private Socket a(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.1", "TLSv1.2"});
        }
        return socket;
    }

    private void b() throws KeyStoreException, NoSuchAlgorithmException {
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init((KeyStore) null);
        TrustManager[] trustManagers = instance.getTrustManagers();
        if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        }
        this.f33900b = trustManagers;
    }

    public X509TrustManager c() {
        return (X509TrustManager) this.f33900b[0];
    }

    public Socket createSocket() throws IOException {
        return a(this.f33899a.createSocket());
    }

    public String[] getDefaultCipherSuites() {
        return this.f33899a.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.f33899a.getSupportedCipherSuites();
    }

    public Socket createSocket(Socket socket, String str, int i2, boolean z2) throws IOException {
        return a(this.f33899a.createSocket(socket, str, i2, z2));
    }

    public Socket createSocket(String str, int i2) throws IOException, UnknownHostException {
        return a(this.f33899a.createSocket(str, i2));
    }

    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException, UnknownHostException {
        return a(this.f33899a.createSocket(str, i2, inetAddress, i3));
    }

    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return a(this.f33899a.createSocket(inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return a(this.f33899a.createSocket(inetAddress, i2, inetAddress2, i3));
    }
}
