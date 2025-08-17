package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

public final class UdpDataSource extends BaseDataSource {

    /* renamed from: e  reason: collision with root package name */
    private final int f28520e;

    /* renamed from: f  reason: collision with root package name */
    private final byte[] f28521f;

    /* renamed from: g  reason: collision with root package name */
    private final DatagramPacket f28522g;

    /* renamed from: h  reason: collision with root package name */
    private Uri f28523h;

    /* renamed from: i  reason: collision with root package name */
    private DatagramSocket f28524i;

    /* renamed from: j  reason: collision with root package name */
    private MulticastSocket f28525j;

    /* renamed from: k  reason: collision with root package name */
    private InetAddress f28526k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f28527l;

    /* renamed from: m  reason: collision with root package name */
    private int f28528m;

    public static final class UdpDataSourceException extends DataSourceException {
        public UdpDataSourceException(Throwable th, int i2) {
            super(th, i2);
        }
    }

    public UdpDataSource() {
        this(2000);
    }

    public Uri b() {
        return this.f28523h;
    }

    public void close() {
        this.f28523h = null;
        MulticastSocket multicastSocket = this.f28525j;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup((InetAddress) Assertions.e(this.f28526k));
            } catch (IOException unused) {
            }
            this.f28525j = null;
        }
        DatagramSocket datagramSocket = this.f28524i;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f28524i = null;
        }
        this.f28526k = null;
        this.f28528m = 0;
        if (this.f28527l) {
            this.f28527l = false;
            t();
        }
    }

    public long i(DataSpec dataSpec) throws UdpDataSourceException {
        Uri uri = dataSpec.f28339a;
        this.f28523h = uri;
        String str = (String) Assertions.e(uri.getHost());
        int port = this.f28523h.getPort();
        u(dataSpec);
        try {
            this.f28526k = InetAddress.getByName(str);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f28526k, port);
            if (this.f28526k.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.f28525j = multicastSocket;
                multicastSocket.joinGroup(this.f28526k);
                this.f28524i = this.f28525j;
            } else {
                this.f28524i = new DatagramSocket(inetSocketAddress);
            }
            this.f28524i.setSoTimeout(this.f28520e);
            this.f28527l = true;
            v(dataSpec);
            return -1;
        } catch (SecurityException e2) {
            throw new UdpDataSourceException(e2, 2006);
        } catch (IOException e3) {
            throw new UdpDataSourceException(e3, 2001);
        }
    }

    public int o() {
        DatagramSocket datagramSocket = this.f28524i;
        if (datagramSocket == null) {
            return -1;
        }
        return datagramSocket.getLocalPort();
    }

    public int read(byte[] bArr, int i2, int i3) throws UdpDataSourceException {
        if (i3 == 0) {
            return 0;
        }
        if (this.f28528m == 0) {
            try {
                ((DatagramSocket) Assertions.e(this.f28524i)).receive(this.f28522g);
                int length = this.f28522g.getLength();
                this.f28528m = length;
                s(length);
            } catch (SocketTimeoutException e2) {
                throw new UdpDataSourceException(e2, 2002);
            } catch (IOException e3) {
                throw new UdpDataSourceException(e3, 2001);
            }
        }
        int length2 = this.f28522g.getLength();
        int i4 = this.f28528m;
        int min = Math.min(i4, i3);
        System.arraycopy(this.f28521f, length2 - i4, bArr, i2, min);
        this.f28528m -= min;
        return min;
    }

    public UdpDataSource(int i2) {
        this(i2, 8000);
    }

    public UdpDataSource(int i2, int i3) {
        super(true);
        this.f28520e = i3;
        byte[] bArr = new byte[i2];
        this.f28521f = bArr;
        this.f28522g = new DatagramPacket(bArr, 0, i2);
    }
}
