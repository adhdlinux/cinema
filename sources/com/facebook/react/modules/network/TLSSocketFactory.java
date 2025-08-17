package com.facebook.react.modules.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class TLSSocketFactory extends SSLSocketFactory {
    private SSLSocketFactory delegate;

    public TLSSocketFactory() throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
        this.delegate = instance.getSocketFactory();
    }

    private Socket enableTLSOnSocket(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"});
        }
        return socket;
    }

    public Socket createSocket(Socket socket, String str, int i2, boolean z2) throws IOException {
        return enableTLSOnSocket(this.delegate.createSocket(socket, str, i2, z2));
    }

    public String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    public Socket createSocket(String str, int i2) throws IOException, UnknownHostException {
        return enableTLSOnSocket(this.delegate.createSocket(str, i2));
    }

    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException, UnknownHostException {
        return enableTLSOnSocket(this.delegate.createSocket(str, i2, inetAddress, i3));
    }

    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return enableTLSOnSocket(this.delegate.createSocket(inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return enableTLSOnSocket(this.delegate.createSocket(inetAddress, i2, inetAddress2, i3));
    }
}
