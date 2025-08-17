package com.startapp;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructPollfd;
import android.util.SparseArray;
import java.io.FileDescriptor;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.Arrays;

@TargetApi(21)
public class x1 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f36884a = "x1";

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f36885b = false;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final short f36886c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f36887d = 7;

    /* renamed from: e  reason: collision with root package name */
    private static final int f36888e = 16;

    /* renamed from: f  reason: collision with root package name */
    private static final int f36889f = 64;

    /* renamed from: g  reason: collision with root package name */
    private static final short f36890g = 30583;

    /* renamed from: h  reason: collision with root package name */
    private InetAddress f36891h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public z1 f36892i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public int f36893j;

    /* renamed from: k  reason: collision with root package name */
    private int f36894k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public int f36895l;

    /* renamed from: m  reason: collision with root package name */
    private y1 f36896m;

    /* renamed from: n  reason: collision with root package name */
    private short f36897n = 1;

    /* renamed from: o  reason: collision with root package name */
    private short f36898o = f36890g;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public boolean f36899p = false;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public boolean f36900q = false;

    /* renamed from: r  reason: collision with root package name */
    private int f36901r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public int f36902s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public int f36903t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public long f36904u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public SparseArray<Long> f36905v;

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private StructPollfd[] f36906a;

        public a(StructPollfd[] structPollfdArr) {
            this.f36906a = structPollfdArr;
        }

        public void run() {
            StructPollfd structPollfd = this.f36906a[0];
            FileDescriptor fileDescriptor = structPollfd.fd;
            int a2 = x1.this.f36902s;
            byte[] bArr = new byte[a2];
            int i2 = 0;
            while (x1.this.f36900q && !x1.this.f36899p && x1.this.f36903t < x1.this.f36895l) {
                try {
                    int poll = Os.poll(this.f36906a, x1.this.f36893j);
                    if (!x1.this.f36899p) {
                        if (poll >= 0 && structPollfd.revents == x1.f36886c) {
                            structPollfd.revents = 0;
                            Os.recvfrom(fileDescriptor, bArr, 0, a2, 64, (InetSocketAddress) null);
                            int hashCode = Arrays.hashCode(x1.b(bArr));
                            Long l2 = (Long) x1.this.f36905v.get(hashCode);
                            if (l2 != null) {
                                x1.this.f36905v.remove(hashCode);
                                long elapsedRealtime = SystemClock.elapsedRealtime() - l2.longValue();
                                int i3 = i2 + 1;
                                try {
                                    x1.this.f36892i.a(i2, SystemClock.elapsedRealtime() - x1.this.f36904u, elapsedRealtime);
                                    x1.f(x1.this);
                                    i2 = i3;
                                } catch (Throwable th) {
                                    th = th;
                                    i2 = i3;
                                    l2.a(th);
                                }
                            }
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    l2.a(th);
                }
            }
        }
    }

    static {
        int i2 = OsConstants.POLLIN;
        if (i2 == 0) {
            i2 = 1;
        }
        f36886c = (short) i2;
    }

    public x1(InetAddress inetAddress, int i2, int i3, int i4, int i5) {
        byte b2;
        this.f36891h = inetAddress;
        this.f36893j = i4;
        this.f36895l = i2;
        this.f36894k = i3;
        if (inetAddress instanceof Inet6Address) {
            b2 = y1.f36938c;
        } else {
            b2 = 8;
        }
        this.f36896m = new y1(b2);
        this.f36901r = i5;
        this.f36902s = i5 + 8;
        this.f36905v = new SparseArray<>();
    }

    public static /* synthetic */ int f(x1 x1Var) {
        int i2 = x1Var.f36903t;
        x1Var.f36903t = i2 + 1;
        return i2;
    }

    public void b() {
        this.f36899p = true;
    }

    @TargetApi(21)
    public void c() {
        int i2;
        int i3;
        int i4;
        this.f36899p = false;
        if (this.f36891h instanceof Inet6Address) {
            i3 = OsConstants.AF_INET6;
            i2 = OsConstants.IPPROTO_ICMPV6;
        } else {
            i3 = OsConstants.AF_INET;
            i2 = OsConstants.IPPROTO_ICMP;
        }
        this.f36904u = SystemClock.elapsedRealtime();
        try {
            FileDescriptor socket = Os.socket(i3, OsConstants.SOCK_DGRAM, i2);
            if (socket.valid()) {
                try {
                    a(socket);
                    StructPollfd structPollfd = new StructPollfd();
                    structPollfd.fd = socket;
                    structPollfd.events = f36886c;
                    a aVar = new a(new StructPollfd[]{structPollfd});
                    this.f36900q = true;
                    this.f36904u = SystemClock.elapsedRealtime();
                    aVar.start();
                    i4 = 0;
                    while (true) {
                        if (i4 >= this.f36895l) {
                            break;
                        } else if (this.f36899p) {
                            break;
                        } else {
                            byte[] a2 = y1.a(this.f36901r);
                            y1 y1Var = this.f36896m;
                            short s2 = this.f36897n;
                            this.f36897n = (short) (s2 + 1);
                            ByteBuffer a3 = y1Var.a(s2, this.f36898o, a2);
                            this.f36905v.put(Arrays.hashCode(a2), Long.valueOf(SystemClock.elapsedRealtime()));
                            if (Os.sendto(socket, a3, 0, this.f36891h, 7) < 0) {
                                break;
                            }
                            if (i4 < this.f36895l - 1) {
                                try {
                                    Thread.sleep((long) this.f36894k);
                                } catch (Throwable th) {
                                    l2.a(th);
                                }
                            }
                            i4++;
                        }
                    }
                    this.f36900q = false;
                    if (aVar.isAlive()) {
                        aVar.join();
                    }
                    Os.close(socket);
                    this.f36900q = false;
                } catch (Throwable th2) {
                    Os.close(socket);
                    this.f36900q = false;
                    throw th2;
                }
            }
            if (!this.f36899p) {
                for (int i5 = this.f36903t; i5 < this.f36895l; i5++) {
                    this.f36892i.a(i5, SystemClock.elapsedRealtime() - this.f36904u, -1);
                }
            }
        } catch (Throwable th3) {
            l2.a(th3);
        }
    }

    /* access modifiers changed from: private */
    public static byte[] b(byte[] bArr) {
        return Arrays.copyOfRange(bArr, 8, bArr.length);
    }

    public void a(short s2) {
        this.f36898o = s2;
    }

    public void a(z1 z1Var) {
        this.f36892i = z1Var;
    }

    private void a(FileDescriptor fileDescriptor) throws ErrnoException {
        if (Build.VERSION.SDK_INT >= 26) {
            Os.setsockoptInt(fileDescriptor, OsConstants.IPPROTO_IP, OsConstants.IP_TOS, 16);
            return;
        }
        Class<Os> cls = Os.class;
        try {
            Class cls2 = Integer.TYPE;
            cls.getMethod("setsockoptInt", new Class[]{FileDescriptor.class, cls2, cls2, cls2}).invoke((Object) null, new Object[]{fileDescriptor, Integer.valueOf(OsConstants.IPPROTO_IP), Integer.valueOf(OsConstants.IP_TOS), 16});
        } catch (Throwable th) {
            l2.a(th);
        }
    }
}
