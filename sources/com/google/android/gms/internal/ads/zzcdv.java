package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import javax.net.ssl.SSLSocketFactory;

final class zzcdv extends SSLSocketFactory {
    final SSLSocketFactory zza = ((SSLSocketFactory) SSLSocketFactory.getDefault());
    final /* synthetic */ zzcdw zzb;

    zzcdv(zzcdw zzcdw) {
        this.zzb = zzcdw;
    }

    private final Socket zza(Socket socket) throws SocketException {
        zzcdw zzcdw = this.zzb;
        if (zzcdw.zzr > 0) {
            socket.setReceiveBufferSize(zzcdw.zzr);
        }
        this.zzb.zzs.add(socket);
        return socket;
    }

    public final Socket createSocket(String str, int i2) throws IOException {
        Socket createSocket = this.zza.createSocket(str, i2);
        zza(createSocket);
        return createSocket;
    }

    public final String[] getDefaultCipherSuites() {
        return this.zza.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.zza.getSupportedCipherSuites();
    }

    public final Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException {
        Socket createSocket = this.zza.createSocket(str, i2, inetAddress, i3);
        zza(createSocket);
        return createSocket;
    }

    public final Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        Socket createSocket = this.zza.createSocket(inetAddress, i2);
        zza(createSocket);
        return createSocket;
    }

    public final Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        Socket createSocket = this.zza.createSocket(inetAddress, i2, inetAddress2, i3);
        zza(createSocket);
        return createSocket;
    }

    public final Socket createSocket(Socket socket, String str, int i2, boolean z2) throws IOException {
        Socket createSocket = this.zza.createSocket(socket, str, i2, z2);
        zza(createSocket);
        return createSocket;
    }
}
