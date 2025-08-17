package androidx.media3.exoplayer.util;

import android.os.SystemClock;
import androidx.media3.exoplayer.upstream.Loader;
import com.startapp.y1;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.ConcurrentModificationException;

public final class SntpClient {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Object f7574a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Object f7575b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static boolean f7576c = false;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static long f7577d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static String f7578e = "time.android.com";

    public interface InitializationCallback {
        void a(IOException iOException);

        void b();
    }

    private static final class NtpTimeCallback implements Loader.Callback<Loader.Loadable> {

        /* renamed from: b  reason: collision with root package name */
        private final InitializationCallback f7579b;

        public NtpTimeCallback(InitializationCallback initializationCallback) {
            this.f7579b = initializationCallback;
        }

        public Loader.LoadErrorAction p(Loader.Loadable loadable, long j2, long j3, IOException iOException, int i2) {
            InitializationCallback initializationCallback = this.f7579b;
            if (initializationCallback != null) {
                initializationCallback.a(iOException);
            }
            return Loader.f7534f;
        }

        public void t(Loader.Loadable loadable, long j2, long j3) {
            if (this.f7579b == null) {
                return;
            }
            if (!SntpClient.k()) {
                this.f7579b.a(new IOException(new ConcurrentModificationException()));
            } else {
                this.f7579b.b();
            }
        }

        public void u(Loader.Loadable loadable, long j2, long j3, boolean z2) {
        }
    }

    private static final class NtpTimeLoadable implements Loader.Loadable {
        private NtpTimeLoadable() {
        }

        public void a() throws IOException {
            synchronized (SntpClient.f7574a) {
                synchronized (SntpClient.f7575b) {
                    if (!SntpClient.f7576c) {
                        long e2 = SntpClient.l();
                        synchronized (SntpClient.f7575b) {
                            long unused = SntpClient.f7577d = e2;
                            boolean unused2 = SntpClient.f7576c = true;
                        }
                    }
                }
            }
        }

        public void b() {
        }
    }

    private SntpClient() {
    }

    private static void g(byte b2, byte b3, int i2, long j2) throws IOException {
        if (b2 == 3) {
            throw new IOException("SNTP: Unsynchronized server");
        } else if (b3 != 4 && b3 != 5) {
            throw new IOException("SNTP: Untrusted mode: " + b3);
        } else if (i2 == 0 || i2 > 15) {
            throw new IOException("SNTP: Untrusted stratum: " + i2);
        } else if (j2 == 0) {
            throw new IOException("SNTP: Zero transmitTime");
        }
    }

    public static long h() {
        long j2;
        synchronized (f7575b) {
            if (f7576c) {
                j2 = f7577d;
            } else {
                j2 = -9223372036854775807L;
            }
        }
        return j2;
    }

    public static String i() {
        String str;
        synchronized (f7575b) {
            str = f7578e;
        }
        return str;
    }

    public static void j(Loader loader, InitializationCallback initializationCallback) {
        if (!k()) {
            if (loader == null) {
                loader = new Loader("SntpClient");
            }
            loader.n(new NtpTimeLoadable(), new NtpTimeCallback(initializationCallback), 1);
        } else if (initializationCallback != null) {
            initializationCallback.b();
        }
    }

    public static boolean k() {
        boolean z2;
        synchronized (f7575b) {
            z2 = f7576c;
        }
        return z2;
    }

    /* access modifiers changed from: private */
    public static long l() throws IOException {
        InetAddress byName = InetAddress.getByName(i());
        DatagramSocket datagramSocket = new DatagramSocket();
        try {
            datagramSocket.setSoTimeout(10000);
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, byName, 123);
            bArr[0] = 27;
            long currentTimeMillis = System.currentTimeMillis();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            o(bArr, 40, currentTimeMillis);
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(new DatagramPacket(bArr, 48));
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            long j2 = currentTimeMillis + (elapsedRealtime2 - elapsedRealtime);
            byte b2 = bArr[0];
            long n2 = n(bArr, 24);
            long n3 = n(bArr, 32);
            long n4 = n(bArr, 40);
            g((byte) ((b2 >> 6) & 3), (byte) (b2 & 7), bArr[1] & 255, n4);
            long j3 = (j2 + (((n3 - n2) + (n4 - j2)) / 2)) - elapsedRealtime2;
            datagramSocket.close();
            return j3;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private static long m(byte[] bArr, int i2) {
        byte b2 = bArr[i2];
        byte b3 = bArr[i2 + 1];
        byte b4 = bArr[i2 + 2];
        byte b5 = bArr[i2 + 3];
        byte b6 = b2 & true;
        int i3 = b2;
        if (b6 == true) {
            i3 = (b2 & Byte.MAX_VALUE) + y1.f36938c;
        }
        byte b7 = b3 & true;
        int i4 = b3;
        if (b7 == true) {
            i4 = (b3 & Byte.MAX_VALUE) + y1.f36938c;
        }
        byte b8 = b4 & true;
        int i5 = b4;
        if (b8 == true) {
            i5 = (b4 & Byte.MAX_VALUE) + y1.f36938c;
        }
        byte b9 = b5 & true;
        int i6 = b5;
        if (b9 == true) {
            i6 = (b5 & Byte.MAX_VALUE) + y1.f36938c;
        }
        return (((long) i3) << 24) + (((long) i4) << 16) + (((long) i5) << 8) + ((long) i6);
    }

    private static long n(byte[] bArr, int i2) {
        long m2 = m(bArr, i2);
        long m3 = m(bArr, i2 + 4);
        if (m2 == 0 && m3 == 0) {
            return 0;
        }
        return ((m2 - 2208988800L) * 1000) + ((m3 * 1000) / 4294967296L);
    }

    private static void o(byte[] bArr, int i2, long j2) {
        if (j2 == 0) {
            Arrays.fill(bArr, i2, i2 + 8, (byte) 0);
            return;
        }
        long j3 = j2 / 1000;
        long j4 = j2 - (j3 * 1000);
        long j5 = j3 + 2208988800L;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) (j5 >> 24));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) (j5 >> 16));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) (j5 >> 8));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) (j5 >> 0));
        long j6 = (j4 * 4294967296L) / 1000;
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) (j6 >> 24));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) (j6 >> 16));
        bArr[i8] = (byte) ((int) (j6 >> 8));
        bArr[i8 + 1] = (byte) ((int) (Math.random() * 255.0d));
    }
}
