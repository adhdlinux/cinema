package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

public final class UdpDataSource extends BaseDataSource {

    /* renamed from: e  reason: collision with root package name */
    private final int f4919e;

    /* renamed from: f  reason: collision with root package name */
    private final byte[] f4920f;

    /* renamed from: g  reason: collision with root package name */
    private final DatagramPacket f4921g;

    /* renamed from: h  reason: collision with root package name */
    private Uri f4922h;

    /* renamed from: i  reason: collision with root package name */
    private DatagramSocket f4923i;

    /* renamed from: j  reason: collision with root package name */
    private MulticastSocket f4924j;

    /* renamed from: k  reason: collision with root package name */
    private InetAddress f4925k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f4926l;

    /* renamed from: m  reason: collision with root package name */
    private int f4927m;

    public static final class UdpDataSourceException extends DataSourceException {
        public UdpDataSourceException(Throwable th, int i2) {
            super(th, i2);
        }
    }

    public UdpDataSource() {
        this(2000);
    }

    public Uri b() {
        return this.f4922h;
    }

    public void close() {
        this.f4922h = null;
        MulticastSocket multicastSocket = this.f4924j;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup((InetAddress) Assertions.f(this.f4925k));
            } catch (IOException unused) {
            }
            this.f4924j = null;
        }
        DatagramSocket datagramSocket = this.f4923i;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f4923i = null;
        }
        this.f4925k = null;
        this.f4927m = 0;
        if (this.f4926l) {
            this.f4926l = false;
            p();
        }
    }

    public long i(DataSpec dataSpec) throws UdpDataSourceException {
        Uri uri = dataSpec.f4823a;
        this.f4922h = uri;
        String str = (String) Assertions.f(uri.getHost());
        int port = this.f4922h.getPort();
        q(dataSpec);
        try {
            this.f4925k = InetAddress.getByName(str);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f4925k, port);
            if (this.f4925k.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.f4924j = multicastSocket;
                multicastSocket.joinGroup(this.f4925k);
                this.f4923i = this.f4924j;
            } else {
                this.f4923i = new DatagramSocket(inetSocketAddress);
            }
            this.f4923i.setSoTimeout(this.f4919e);
            this.f4926l = true;
            r(dataSpec);
            return -1;
        } catch (SecurityException e2) {
            throw new UdpDataSourceException(e2, 2006);
        } catch (IOException e3) {
            throw new UdpDataSourceException(e3, 2001);
        }
    }

    public int read(byte[] bArr, int i2, int i3) throws UdpDataSourceException {
        if (i3 == 0) {
            return 0;
        }
        if (this.f4927m == 0) {
            try {
                ((DatagramSocket) Assertions.f(this.f4923i)).receive(this.f4921g);
                int length = this.f4921g.getLength();
                this.f4927m = length;
                o(length);
            } catch (SocketTimeoutException e2) {
                throw new UdpDataSourceException(e2, 2002);
            } catch (IOException e3) {
                throw new UdpDataSourceException(e3, 2001);
            }
        }
        int length2 = this.f4921g.getLength();
        int i4 = this.f4927m;
        int min = Math.min(i4, i3);
        System.arraycopy(this.f4920f, length2 - i4, bArr, i2, min);
        this.f4927m -= min;
        return min;
    }

    public UdpDataSource(int i2) {
        this(i2, 8000);
    }

    public UdpDataSource(int i2, int i3) {
        super(true);
        this.f4919e = i3;
        byte[] bArr = new byte[i2];
        this.f4920f = bArr;
        this.f4921g = new DatagramPacket(bArr, 0, i2);
    }
}
