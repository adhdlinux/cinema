package com.startapp;

import android.net.TrafficStats;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;

public class g3 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f34549a = "g3";

    /* renamed from: b  reason: collision with root package name */
    private static String[] f34550b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String[] f34551c = null;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f34552d = true;

    /* renamed from: e  reason: collision with root package name */
    private static Method f34553e;

    /* renamed from: f  reason: collision with root package name */
    private static Method f34554f;

    /* renamed from: g  reason: collision with root package name */
    private static Method f34555g;

    static {
        Class<String> cls = String.class;
        Class<TrafficStats> cls2 = TrafficStats.class;
        try {
            Method declaredMethod = cls2.getDeclaredMethod("getRxBytes", new Class[]{cls});
            f34553e = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (Throwable th) {
            l2.b(th);
        }
        try {
            Method declaredMethod2 = cls2.getDeclaredMethod("getTxBytes", new Class[]{cls});
            f34554f = declaredMethod2;
            declaredMethod2.setAccessible(true);
        } catch (Throwable th2) {
            l2.b(th2);
        }
        try {
            Method declaredMethod3 = cls2.getDeclaredMethod("getMobileIfaces", new Class[0]);
            f34555g = declaredMethod3;
            declaredMethod3.setAccessible(true);
        } catch (Throwable th3) {
            l2.b(th3);
        }
    }

    private static void a() {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    if (nextElement != null && nextElement.getName().startsWith("eth")) {
                        String[] strArr = f34550b;
                        if (strArr != null && strArr.length > 0) {
                            int length = strArr.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= length) {
                                    break;
                                }
                                if (nextElement.getName().equals(strArr[i2])) {
                                    break;
                                }
                                i2++;
                            }
                        }
                        Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                        boolean z2 = false;
                        if (inetAddresses != null) {
                            while (inetAddresses.hasMoreElements()) {
                                InetAddress nextElement2 = inetAddresses.nextElement();
                                if (nextElement2 != null && nextElement2.isLinkLocalAddress() && !nextElement2.isLoopbackAddress()) {
                                    z2 = true;
                                }
                            }
                        }
                        if (z2) {
                            arrayList.add(f3.a(nextElement.getName()));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            l2.a(th);
        } finally {
            f34551c = (String[]) arrayList.toArray(new String[arrayList.size()]);
            f34552d = false;
        }
    }

    public static synchronized long b() {
        long j2;
        String[] strArr;
        synchronized (g3.class) {
            if (f34552d && ((strArr = f34551c) == null || strArr.length <= 0)) {
                a();
            }
            String[] strArr2 = f34551c;
            j2 = 0;
            if (strArr2 != null && strArr2.length > 0) {
                for (String a2 : strArr2) {
                    long a3 = a(a2);
                    if (a3 > -1) {
                        j2 += a3;
                    }
                }
            }
        }
        return j2;
    }

    public static synchronized long c() {
        long j2;
        String[] strArr;
        synchronized (g3.class) {
            if (f34552d && ((strArr = f34551c) == null || strArr.length <= 0)) {
                a();
            }
            String[] strArr2 = f34551c;
            j2 = 0;
            if (strArr2 != null && strArr2.length > 0) {
                for (String b2 : strArr2) {
                    long b3 = b(b2);
                    if (b3 > -1) {
                        j2 += b3;
                    }
                }
            }
        }
        return j2;
    }

    private static void d() {
        Method method = f34555g;
        if (method != null) {
            try {
                String[] strArr = (String[]) method.invoke((Object) null, new Object[0]);
                if (strArr != null) {
                    f34550b = strArr;
                }
            } catch (Throwable th) {
                l2.a(th);
            }
        }
    }

    public static synchronized long e() {
        long j2;
        synchronized (g3.class) {
            try {
                j2 = TrafficStats.getMobileRxBytes();
            } catch (Throwable th) {
                l2.a(th);
                j2 = 0;
            }
            if (j2 <= 0) {
                String[] strArr = f34550b;
                if (strArr != null) {
                    for (String str : strArr) {
                        long c2 = c("/sys/class/net/" + str + "/statistics/rx_bytes");
                        if (c2 > -1) {
                            j2 += c2;
                        }
                    }
                }
            } else if (f34550b == null) {
                d();
            }
        }
        return j2;
    }

    public static synchronized long f() {
        long j2;
        synchronized (g3.class) {
            try {
                j2 = TrafficStats.getMobileTxBytes();
            } catch (Throwable th) {
                l2.a(th);
                j2 = 0;
            }
            if (j2 <= 0) {
                String[] strArr = f34550b;
                if (strArr != null) {
                    for (String str : strArr) {
                        long c2 = c("/sys/class/net/" + str + "/statistics/tx_bytes");
                        if (c2 > -1) {
                            j2 += c2;
                        }
                    }
                }
            } else if (f34550b == null) {
                d();
            }
        }
        return j2;
    }

    public static synchronized long g() {
        long totalRxBytes;
        synchronized (g3.class) {
            totalRxBytes = TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
        }
        return totalRxBytes;
    }

    public static synchronized long h() {
        long totalTxBytes;
        synchronized (g3.class) {
            totalTxBytes = TrafficStats.getTotalTxBytes() - TrafficStats.getMobileTxBytes();
        }
        return totalTxBytes;
    }

    public static long b(String str) {
        Method method = f34554f;
        if (method != null) {
            try {
                return ((Long) method.invoke((Object) null, new Object[]{str})).longValue();
            } catch (Throwable th) {
                l2.a(th);
            }
        }
        return c("/sys/class/net/" + str + "/statistics/tx_bytes");
    }

    private static long c(String str) {
        String[] a2 = d3.a(str);
        if (a2.length > 0) {
            return Long.parseLong(a2[0]);
        }
        return -1;
    }

    public static long a(String str) {
        Method method = f34553e;
        if (method != null) {
            try {
                return ((Long) method.invoke((Object) null, new Object[]{str})).longValue();
            } catch (Throwable th) {
                l2.a(th);
            }
        }
        return c("/sys/class/net/" + str + "/statistics/rx_bytes");
    }
}
